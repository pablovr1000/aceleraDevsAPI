package acelera.devs.pablo.api.controller;

import acelera.devs.pablo.api.model.cliente.Cliente;
import acelera.devs.pablo.api.model.produto.Produto;
import acelera.devs.pablo.api.model.produto.ProdutoRepository;
import acelera.devs.pablo.api.model.cliente.ClienteRepository;
import acelera.devs.pablo.api.model.venda.Venda;
import acelera.devs.pablo.api.model.venda.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

@RestController
@RequestMapping("/vendas")
public class VendasController {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VendaRepository vendaRepository;

    @PostMapping("/xlsx")
    public ResponseEntity<String> handleXlsxUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("O arquivo está vazio");
        }

        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (row.getRowNum() == 0) {
                    continue;
                }

                Cell cellCodigoProduto = row.getCell(0);
                Cell cellCpfUsuario = row.getCell(1);
                Cell cellQuantidadeProdutos = row.getCell(2);
                Cell cellDataCompra = row.getCell(3);

                if (cellCodigoProduto != null && cellCpfUsuario != null && cellQuantidadeProdutos != null && cellDataCompra != null) {
                    int codigoProduto = (int) cellCodigoProduto.getNumericCellValue();
                    long cpfUsuario = (long) cellCpfUsuario.getNumericCellValue();
                    int quantidadeProdutos = (int) cellQuantidadeProdutos.getNumericCellValue();
                    Date dataCompra = cellDataCompra.getDateCellValue();

                    Cliente cliente = clienteRepository.findByCpf(cpfUsuario);
                    if (cliente == null) {
                        return ResponseEntity.badRequest().body("Cliente com CPF " + cpfUsuario + " não encontrado.");
                    }

                    Produto produto = produtoRepository.findByCodigo(codigoProduto);
                    if (produto == null) {
                        return ResponseEntity.badRequest().body("Produto com código " + codigoProduto + " não encontrado."); // Alteração aqui
                    }

                    Venda venda = new Venda();
                    venda.setCliente(cliente);
                    venda.setProduto(produto);
                    venda.setQuantidade(quantidadeProdutos);
                    venda.setDataCompra(dataCompra);

                    vendaRepository.save(venda);
                } else {
                    return ResponseEntity.ok("Upload bem-sucedido. Os dados foram salvos no banco de dados.");
                }
            }

            return ResponseEntity.ok("Upload bem-sucedido. Os dados foram salvos no banco de dados.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
