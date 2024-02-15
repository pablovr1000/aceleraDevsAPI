package acelera.devs.pablo.api.model.registro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "entradas")
@Entity(name = "entrada")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigoProduto;
    private Long quantidadeProduto;
    private Date dataEntrada;

    public Entrada(Long id, CadastroEntrada dados) {
        this.codigoProduto = id;
        this.quantidadeProduto = Long.valueOf(dados.quantidadeProduto());
        this.dataEntrada = dados.dataEntrada();
    }
}
