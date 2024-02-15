package acelera.devs.pablo.api.controller;

import acelera.devs.pablo.api.model.cliente.CadastroCliente;
import acelera.devs.pablo.api.model.cliente.cliente;
import acelera.devs.pablo.api.model.cliente.clienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class clienteController {

    @Autowired
    private clienteRepository repository;
    @GetMapping
    public String teste1() {
        return "teste ok!";
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroCliente dados) {
        repository.save(new cliente(dados));
    }
}
