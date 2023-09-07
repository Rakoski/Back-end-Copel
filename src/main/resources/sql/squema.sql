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
    endereco_id BIGINT not null,
    kilowattsrecebidos_id BIGINT not null,
    valor_a_pagar decimal not null,

    # eu quero aplicar uma taxa extra baseado na estação do ano
    # toda vez que for calcular o valor a pagar a gente vai multiplicar os kw/h
    # pelos rs/kw-h do mês de setembro

    data_de_vencimento date not null,
    status_pagamento varchar(45) not null,
    kilowatts_hora int not null,
    foreign key (endereco_id) references endereco(id_endereco),
    foreign key (kilowattsrecebidos_id) references kilowatts_recebidos(id_tabela_kilowatts)
);

create table endereco (
    id_endereco BIGINT not null primary key auto_increment,
    cep varchar(9) not null,
    numero varchar(5) not null
);

create table cliente_endereco (
    id_clienteendereco BIGINT Not null primary key auto_increment,
    cliente_id BIGINT NOT NULL,
    endereco_id BIGINT NOT NULL,
    foreign key (cliente_id) references clientes(id_cliente),
    foreign key (endereco_id) references endereco(id_endereco)
);

create table kilowatts_recebidos (
    id_tabela_kilowatts BIGINT not null primary key auto_increment,
    recebidosmedidor_id BIGINT NOT NULL,
    kilowatts_hora int not null,
    mes_recebido date not null,
    foreign key (recebidosmedidor_id) references recebidos_do_medidor(id_recebidosmedidor)
);

create table recebidos_do_medidor (
    id_recebidosmedidor BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    amperagem decimal not null
)

