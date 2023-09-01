create database HackathonCopel;

use HackathonCopel;

create table Clientes (
    idCliente BIGINT not null primary key auto_increment,
    nome varchar(45) not null,
    sobrenome varchar(45) not null,
    email varchar(100) not null unique,
    senha_hash BLOB not null,
    senha_salt BLOB not null
);

create table InformacoesConta (
    IdInformacoesConta BIGINT not null primary key auto_increment,
    ClienteId BIGINT not null,
    valor_a_pagar decimal not null,
    data_de_emissao date not null,
    data_de_vencimento date not null,
    status_pagamento varchar(45) not null,
    foreign key (ClienteId) references Clientes(idCliente)
);

