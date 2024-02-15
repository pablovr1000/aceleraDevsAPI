package acelera.devs.pablo.api.model.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigo;
    private String nomeProduto;
    private Double preco;

    public Produto(CadastroProduto dados) {
        this.nomeProduto = dados.nomeProduto();
        this.codigo = dados.codigo();
        this.preco = dados.preco();
    }

    public void atualizarInformacoes(AtualizacaoProduto dados) {
        if (dados.nomeProduto() != null) {
            this.nomeProduto = dados.nomeProduto();
        }
        if (dados.codigo() != null) {
            this.codigo = dados.codigo();
        }
        if (dados.preco() != null) {
            this.preco = dados.preco();
        }
    }
}
