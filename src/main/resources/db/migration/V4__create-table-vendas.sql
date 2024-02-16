CREATE TABLE vendas
(
    id bigint auto_increment primary key,
    cliente_id bigint,
    codigo_produto bigint,
    quantidade integer,
    data_compra DATE,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(cpf),
    FOREIGN KEY (codigo_produto) REFERENCES Produtos(codigo)
);