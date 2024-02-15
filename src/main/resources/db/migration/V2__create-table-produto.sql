create table produtos (

    id bigint auto_increment primary key,
    codigo bigint not null unique,
    nome_produto varchar(255) not null,
    preco double not null

);
