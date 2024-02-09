package acelera.devs.pablo.api.controller;

import acelera.devs.pablo.api.model.cliente.CadastroCliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class clienteController {
    @GetMapping
    public String teste1() {
        return "teste ok!";
    }

    @PostMapping
    public void cadastrar(@RequestBody CadastroCliente dados) {
        System.out.println(dados);
    }
}
