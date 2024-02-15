package acelera.devs.pablo.api.controller;

import acelera.devs.pablo.api.model.cliente.AtualizacaoCliente;
import acelera.devs.pablo.api.model.cliente.CadastroCliente;
import acelera.devs.pablo.api.model.cliente.cliente;
import acelera.devs.pablo.api.model.cliente.clienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class clienteController {

    @Autowired
    private clienteRepository repository;

    @GetMapping
    public Page<cliente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroCliente dados) {
        repository.save(new cliente(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizacaoCliente dados) {
        var cliente = repository.getReferenceById(dados.cpf());
        cliente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public void excluir(@PathVariable Long cpf) {
        repository.deleteById(cpf);
    }
}
