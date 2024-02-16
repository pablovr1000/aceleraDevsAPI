package acelera.devs.pablo.api.model.venda;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VendaInfo {
    private String nomeProduto;
    private Integer quantidade;
    private Date dataCompra;

    public VendaInfo (String nomeProduto, int quantidade, Date dataCompra){
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.dataCompra = dataCompra;
    }
}
