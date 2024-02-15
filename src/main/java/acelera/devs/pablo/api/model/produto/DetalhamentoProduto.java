package acelera.devs.pablo.api.model.produto;

public record DetalhamentoProduto(Long id, Long codigo, String nomeProduto, Double preco) {
    public DetalhamentoProduto(Produto produto) {
        this(produto.getId(), produto.getCodigo(), produto.getNomeProduto(), produto.getPreco());
    }
}
