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

insert into Usuario(nome, email, cpf, senha, nascimento, papel) values ('Administrador', 'admin@email.com', '12345678910', 'admin', "2000-01-01" ,'ADM');

insert into Usuario(nome, email, cpf, senha, sexo, nascimento, telefone, papel) values ('Usuario', 'usuario@email.com', '12345678920', 'user', 'F', "2000-01-01" , '123456789' ,'USR');

insert into Agencia(cnpj, nome, email, senha, descricao) values ('12345678901234','Agencia X', 'agencia@email.com', 'agencia', 'Agencia de viagens bem bacana');
