package acelera.devs.pablo.api.controller;

import acelera.devs.pablo.api.model.cliente.Cliente;
import acelera.devs.pablo.api.model.cliente.ClienteRepository;
import acelera.devs.pablo.api.model.produto.Produto;
import acelera.devs.pablo.api.model.relatorios.Relatorio;
import acelera.devs.pablo.api.model.relatorios.RelatorioMes;
import acelera.devs.pablo.api.model.venda.Venda;
import acelera.devs.pablo.api.model.venda.VendaInfo;
import acelera.devs.pablo.api.model.venda.VendaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Getter
@Setter
@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    private final ClienteRepository clienteRepository;
    private final VendaRepository vendaRepository;

    public RelatorioController(ClienteRepository clienteRepository, VendaRepository vendaRepository) {
        this.clienteRepository = clienteRepository;
        this.vendaRepository = vendaRepository;
    }

    @GetMapping("/{ano}/{mes}")
    public ResponseEntity<RelatorioMes> gerarRelatorioMesEAno(@PathVariable int ano, @PathVariable int mes) {
        Date dataInicial = Date.from(LocalDate.of(ano, mes, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataFinal = Date.from(LocalDate.of(ano, mes, 1).with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());

        List<Venda> vendasDoMes = vendaRepository.findByDataCompraBetween(dataInicial, dataFinal);

        Map<Produto, Integer> vendasPorProduto = new HashMap<>();
        Map<Produto, Map<Cliente, Integer>> detalhesVendasPorProduto = new HashMap<>();

        for (Venda venda : vendasDoMes) {
            Produto produto = venda.getProduto();
            Cliente cliente = venda.getCliente();
            int quantidade = venda.getQuantidade();

            // Verifique se tanto o produto quanto o cliente não são nulos
            if (produto != null && cliente != null) {
                vendasPorProduto.put(produto, vendasPorProduto.getOrDefault(produto, 0) + quantidade);

                // Atualizar detalhes de vendas por produto e cliente
                Map<Cliente, Integer> detalhesPorCliente = detalhesVendasPorProduto.getOrDefault(produto, new HashMap<>());
                detalhesPorCliente.put(cliente, detalhesPorCliente.getOrDefault(cliente, 0) + quantidade);
                detalhesVendasPorProduto.put(produto, detalhesPorCliente);
            }
        }

        return ResponseEntity.ok(new RelatorioMes(dataInicial, dataFinal, vendasPorProduto, detalhesVendasPorProduto));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Relatorio> gerarRelatorio(@PathVariable Long cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        String viaCepUrl = "https://viacep.com.br/ws/{cep}/json";
        RestTemplate restTemplate = new RestTemplate();
        EnderecoResponse enderecoResponse = restTemplate.getForObject(viaCepUrl, EnderecoResponse.class, cliente.getCep());

        List<Venda> vendas = vendaRepository.findByCliente(cliente);

        List<VendaInfo> pedidosInfo = new ArrayList<>();
        for (Venda venda : vendas) {
            pedidosInfo.add(new VendaInfo(
                    venda.getProduto().getNomeProduto(),
                    venda.getQuantidade(),
                    venda.getDataCompra()
            ));
        }

        Relatorio relatorio = new Relatorio(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataDeNascimento(),
                cliente.getCep(),
                enderecoResponse.getLogradouro(),
                enderecoResponse.getBairro(),
                enderecoResponse.getLocalidade(),
                enderecoResponse.getUf(),
                pedidosInfo
        );

        return ResponseEntity.ok(relatorio);
    }

    @Getter
    @Setter
    private static class EnderecoResponse {
        private String logradouro;
        private String bairro;
        private String localidade;
        private String uf;
    }
}
