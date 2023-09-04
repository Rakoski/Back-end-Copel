create database copel;

use copel;

create table clientes (
    id_cliente BIGINT not null primary key auto_increment,
    nome varchar(45) not null,
    sobrenome varchar(45) not null,
    email varchar(100) not null unique,
    senha_hash BLOB not null,
    senha_salt BLOB not null
);

create table conta (
    id_conta BIGINT not null primary key auto_increment,
    cliente_id BIGINT not null,
    valor_a_pagar decimal not null,
    data_de_vencimento date not null,
    status_pagamento varchar(45) not null,
    kilowatts_hora int not null,
    foreign key (cliente_id) references clientes(id_cliente)
);

create table kilowatts_recebidos (
    id_tabela_kilowatts BIGINT not null primary key auto_increment,
    conta_id BIGINT not null,
    kilowatts_pegos int not null,
    data_de_emissao date not null,
    foreign key (conta_id) references conta(id_conta)
)
