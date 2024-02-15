package acelera.devs.pablo.api.model.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroProduto(
        @NotBlank
        String nomeProduto,
        @NotNull
        Long codigo,
        @NotNull
        Double preco
) {
}
