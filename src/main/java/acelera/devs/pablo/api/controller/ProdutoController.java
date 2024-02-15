package acelera.devs.pablo.api.controller;

import acelera.devs.pablo.api.model.produto.*;
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
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<Page<DetalhamentoProduto>> listar(@PageableDefault(size = 10, sort = {"nomeProduto"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DetalhamentoProduto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var produto = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoProduto(produto));
    }

    @PostMapping
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroProduto dados, UriComponentsBuilder uriBuilder) {
        var produto = new Produto(dados);
        repository.save(produto);

        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoProduto(produto));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoProduto dados) {
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DetalhamentoProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
