package acelera.devs.pablo.api.model.cliente;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtualizacaoCliente(
        String nome,

        String dataDeNascimento,
        @NotNull
        Long cpf,
        @Pattern(regexp = "\\d{8}")
        String cep) {
}
