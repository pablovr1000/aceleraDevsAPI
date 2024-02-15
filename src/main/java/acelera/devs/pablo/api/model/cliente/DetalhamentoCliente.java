package acelera.devs.pablo.api.model.cliente;

public record DetalhamentoCliente(Long cpf, String nome, String dataDeNascimento, String cep) {
    public DetalhamentoCliente(cliente cliente) {
        this(cliente.getCpf(), cliente.getNome(), cliente.getDataDeNascimento(), cliente.getCep());
    }
}
