package acelera.devs.pablo.api.model.venda;

import acelera.devs.pablo.api.model.produto.Produto;
import acelera.devs.pablo.api.model.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "vendas")
@Entity(name = "venda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "codigo_produto")
    private Produto produto;

    private Integer quantidade;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCompra;
}
