drop database if exists Rotes;

create database Rotes;

use Rotes

create table Usuario(
id bigint not null auto_increment, 
nome varchar(256) not null, 
email varchar(128) not null unique, 
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
email varchar(128) not null unique, 
senha varchar(64) not null, 
descricao varchar(256),
primary key (id));

create table Pacote(
id bigint not null auto_increment, 
idAgencia bigint not null,
cnpj varchar(14) not null, 
cidade varchar(256) not null, 
estado varchar(256) not null, 
pais varchar(256) not null, 
dataPartida date not null, 
duracaoDias int not null,
valor double not null,
descricao varchar(256),
primary key (id),
foreign key (idAgencia) references Agencia (id) ON DELETE CASCADE ON UPDATE CASCADE);


create table Proposta(
    id bigint not null auto_increment,
    idUsuario bigint not null,
    idPacote bigint not null,
    dataProposta date not null,
    valor float,
    statusProposta int not null,
    primary key (id),
    foreign key (idUsuario) references Usuario (id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (idPacote) references Pacote (id) ON DELETE CASCADE ON UPDATE CASCADE);

insert into Usuario(nome, email, cpf, senha, nascimento, papel) values ('Administrador', 'admin@email.com', '12345678910', 'admin', "2000-01-01" ,'ADM');

insert into Usuario(nome, email, cpf, senha, sexo, nascimento, telefone, papel) values ('Usuario', 'usuario@email.com', '12345678920', 'user', 'F', "2000-01-01" , '123456789' ,'USR');

insert into Agencia(cnpj, nome, email, senha, descricao) values ('12345678901234','Agencia X', 'agencia@email.com', 'agencia', 'Agencia de viagens bem bacana');

insert into Pacote(idAgencia, cnpj, cidade, estado, pais, dataPartida, duracaoDias, valor, descricao) values (1, '12345678901234', 'Batatais', 'Sao Paulo', 'Brasil', '2011-09-23', 5, 1999, 'Lorem Ipsum');

insert into Pacote(idAgencia, cnpj, cidade, estado, pais, dataPartida, duracaoDias, valor, descricao) values (1, '12345678901234', 'Bananais', 'HUEHUE', 'Bostil', '2022-08-06', 365, 42069, 'Depressao Dor Sofrimentos');

insert into Pacote(idAgencia, cnpj, cidade, estado, pais, dataPartida, duracaoDias, valor, descricao) values (1, '12345678901234', 'Paris', 'Sla', 'França', '2022-09-21', 365, 3000, 'Torre Waffle uiui');

insert into Proposta(idUsuario, idPacote, dataProposta, valor, statusProposta) values (1, 1, "2011-09-21", 1, 1);

insert into Pacote(idAgencia, cnpj, cidade, estado, pais, dataPartida, duracaoDias, valor, descricao) values (1, '12345678901234', 'Sao Carros', 'Sao Paulo', 'Brasil', '2022-09-23', 365, 42069, 'Depressao Dor Sofrimentos');

insert into Proposta(idUsuario, idPacote, dataProposta, valor, statusProposta) values (1, 1, "2011-09-21", 1, 1);

insert into Proposta(idUsuario, idPacote, dataProposta, valor, statusProposta) values (1, 2, "2011-09-21", 1, 0);

