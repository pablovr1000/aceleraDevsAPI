package acelera.devs.pablo.api.controller;

import acelera.devs.pablo.api.model.cliente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public ResponseEntity<Page<DetalhamentoCliente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DetalhamentoCliente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity detalhar(@PathVariable Long cpf) {
        var cliente = repository.getReferenceById(cpf);
        return ResponseEntity.ok(new DetalhamentoCliente(cliente));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroCliente dados, UriComponentsBuilder uriBuilder) {
        var cliente = new Cliente(dados);
        repository.save(cliente);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(dados.cpf()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoCliente(cliente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoCliente dados) {
        var cliente = repository.getReferenceById(dados.cpf());
        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long cpf) {
        repository.deleteById(cpf);
        return ResponseEntity.noContent().build();
    }
}
