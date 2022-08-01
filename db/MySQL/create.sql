drop database if exists Rotes;

create database Rotes;

use Rotes

create table Usuario(
id bigint not null auto_increment, 
nome varchar(256) not null, 
email varchar(24) not null unique, 
cpf varchar(11) not null unique, 
senha varchar(64) not null, 
sexo varchar(1),
nascimento date,
telefone varchar(11),
papel varchar(3) not null,
primary key (id));

create table Agencia(
id bigint not null auto_increment, 
cnpj varchar(14) not null unique, 
nome varchar(256) not null, 
email varchar(24) not null unique, 
senha varchar(64) not null, 
descricao varchar(256),
primary key (id));

create table Pacote(
id bigint not null auto_increment, 
cnpj varchar(14) not null unique, 
destino varchar(256) not null, 
dataPartida date not null, 
duracaoDias int not null,
valor double not null,
descricao varchar(256),
fotos TEXT,
primary key (id));

insert into Usuario(nome, email, cpf, senha, nascimento, papel) values ('Administrador', 'admin@email.com', '12345678910', 'admin', "2000-01-01" ,'ADM');

insert into Usuario(nome, email, cpf, senha, sexo, nascimento, telefone, papel) values ('Usuario', 'usuario@email.com', '12345678920', 'user', 'F', "2000-01-01" , '123456789' ,'USR');

insert into Agencia(cnpj, nome, email, senha, descricao) values ('12345678901234','Agencia X', 'agencia@email.com', 'agencia', 'Agencia de viagens bem bacana');

insert into Pacote(cnpj, destino, dataPartida, duracaoDias, valor, descricao, fotos) values ('12345678901234', 'Batatais', '2011-09-23', 5, 1999, 'Lorem Ipsum', '/db/images/example.jpg');

insert into Pacote(cnpj, destino, dataPartida, duracaoDias, valor, descricao, fotos) values ('12345678904321', 'Bananais', '2021-09-23', 365, 42069, 'Depressao Dor Sofrimentos', '/db/images/example.jpg');

