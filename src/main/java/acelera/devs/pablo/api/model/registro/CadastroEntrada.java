package acelera.devs.pablo.api.model.registro;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CadastroEntrada(
        @NotBlank
        @JsonFormat(pattern = "dd/MM/yyyy")
        Date dataEntrada,
        @NotNull
        Long quantidadeProduto
) {
}