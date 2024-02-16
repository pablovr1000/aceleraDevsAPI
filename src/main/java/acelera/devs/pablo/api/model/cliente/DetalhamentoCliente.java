package acelera.devs.pablo.api.model.cliente;

public record DetalhamentoCliente(Long cpf, String nome, String dataDeNascimento, String cep) {
    public DetalhamentoCliente(Cliente cliente) {
        this(cliente.getCpf(), cliente.getNome(), cliente.getDataDeNascimento(), cliente.getCep());
    }
}
