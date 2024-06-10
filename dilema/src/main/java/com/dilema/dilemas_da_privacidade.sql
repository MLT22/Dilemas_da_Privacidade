-- Criar o usuário admin
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

-- Conceder todas as permissões ao usuário admin
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost' WITH GRANT OPTION;

-- Aplicar as alterações de privilégios
FLUSH PRIVILEGES;

-- Criação do banco de dados
create database Dilema_Da_Privacidade;
use Dilema_Da_Privacidade;

-- Tabela de Tipos de Carta
create table tipo(
    idTipo integer primary key auto_increment,
    nomeTipo varchar(30) unique not null
);

-- Tabela de Cartas
create table carta(
    idCarta integer primary key auto_increment,
    historia varchar(3000) not null,
    qtdCasas integer not null,
    idTipo integer not null,
    foreign key (idTipo) references tipo(idTipo) on delete restrict on update cascade
);

create table cartas_especiais (
    idCarta integer primary key auto_increment,
    historia varchar(3000) not null,
    justificativa varchar(3000) not null
);

insert into cartas_es
