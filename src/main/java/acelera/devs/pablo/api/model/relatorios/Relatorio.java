package acelera.devs.pablo.api.model.relatorios;

import acelera.devs.pablo.api.model.venda.VendaInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Relatorio {
    private String nome;
    private Long cpf;
    private String dataDeNascimento;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private List<VendaInfo> pedidos;


    public Relatorio(String nome, Long cpf, String dataDeNascimento, String cep, String logradouro, String bairro, String localidade, String uf, List<VendaInfo> pedidos) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.pedidos = pedidos;
    }
}
