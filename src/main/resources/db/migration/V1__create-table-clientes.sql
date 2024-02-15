create table clientes(

    cpf bigint not null unique,
    nome varchar(100) not null,
    data_de_nascimento varchar(12) not null,
    cep varchar(9) not null,

    primary key(cpf)

);