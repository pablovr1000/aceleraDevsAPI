package acelera.devs.pablo.api.model.relatorios;

import acelera.devs.pablo.api.model.cliente.Cliente;
import acelera.devs.pablo.api.model.produto.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class RelatorioMes {

    @JsonIgnore
    private Date dataInicial;

    @JsonIgnore
    private Date dataFinal;

    private Map<Produto, Integer> vendasPorProduto;
    private Map<Produto, Map<Cliente, Integer>> detalhesVendasPorProduto;

    public RelatorioMes(Date dataInicial, Date dataFinal, Map<Produto, Integer> vendasPorProduto, Map<Produto, Map<Cliente, Integer>> detalhesVendasPorProduto) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.vendasPorProduto = vendasPorProduto;
        this.detalhesVendasPorProduto = detalhesVendasPorProduto;
    }

    public String getDataInicialFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataInicial);
    }

    public String getDataFinalFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataFinal);
    }
}
