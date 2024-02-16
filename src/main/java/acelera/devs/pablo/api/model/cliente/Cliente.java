package acelera.devs.pablo.api.model.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    private Long cpf;
    private String nome;
    private String dataDeNascimento;
    private String cep;

    public Cliente(CadastroCliente dados) {
        this.cpf = Long.valueOf(dados.cpf());
        this.nome = dados.nome();
        this.dataDeNascimento = dados.dataDeNascimento();
        this.cep = dados.cep();
    }

    public void atualizarInformacoes(AtualizacaoCliente dados) {
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.dataDeNascimento() != null) {
            this.dataDeNascimento = dados.dataDeNascimento();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }
}
