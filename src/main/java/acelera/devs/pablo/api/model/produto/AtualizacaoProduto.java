package acelera.devs.pablo.api.model.produto;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoProduto(
        String nomeProduto,

        Long codigo,
        Double preco,
        @NotNull
        Long id
) {}