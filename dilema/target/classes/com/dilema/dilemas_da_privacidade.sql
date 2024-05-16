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

-- Tabela de Partidas
create table partida(
    idPartida integer primary key auto_increment,
    dataInicio datetime not null,
    dataFim datetime
);

-- Tabela de Registro de Jogadas
create table jogada(
    idJogada integer primary key auto_increment,
    idPartida integer not null,
    jogador varchar(50) not null, -- Nome do jogador, já que não há cadastro
    idCarta integer not null,
    dataHora datetime not null,
    posicaoAnterior integer not null,
    posicaoAtual integer not null,
    foreign key (idPartida) references partida(idPartida) on delete cascade,
    foreign key (idCarta) references carta(idCarta) on delete restrict
);

-- Índices para melhorar a performance de buscas
create index idx_carta_idTipo on carta(idTipo);
create index idx_jogada_idPartida on jogada(idPartida);
