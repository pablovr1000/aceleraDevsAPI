package acelera.devs.pablo.api.model.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "clientes")
@Entity(name = "cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class cliente {
    @Id
    private Long cpf;
    private String nome;
    private String dataDeNascimento;
    private String cep;

    public cliente(CadastroCliente dados) {
        this.cpf = Long.valueOf(dados.cpf());
        this.nome = dados.nome();
        this.dataDeNascimento = dados.dataDeNascimento();
        this.cep = dados.cep();
    }
}
