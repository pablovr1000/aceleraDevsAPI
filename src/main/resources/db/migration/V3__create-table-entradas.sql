create table entradas (
    id bigint auto_increment primary key,
    quantidade_produto bigint not null,
    data_entrada date,
    codigo_produto bigint not null,
    foreign key (codigo_produto) references Produtos(codigo)
);