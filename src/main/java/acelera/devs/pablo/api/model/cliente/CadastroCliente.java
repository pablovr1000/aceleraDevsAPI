package acelera.devs.pablo.api.model.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroCliente(
        @NotBlank
        String nome,
        @NotBlank
        String dataDeNascimento,
        @NotNull
        Long cpf,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep) {
}
