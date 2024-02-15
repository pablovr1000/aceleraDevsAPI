package acelera.devs.pablo.api.controller;

import acelera.devs.pablo.api.model.registro.CadastroEntrada;
import acelera.devs.pablo.api.model.registro.Entrada;
import acelera.devs.pablo.api.model.registro.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/entrada")
public class EntradaController {
    @Autowired
    private EntradaRepository repository;

    @PostMapping("{id}")
    public ResponseEntity<String> entrada(@PathVariable Long id, @RequestBody CadastroEntrada dados) {
        repository.save(new Entrada(id, dados));
        return ResponseEntity.ok("Entrada efetuada para id: "+ id);
    }
}
