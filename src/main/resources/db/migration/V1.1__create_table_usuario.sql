 create table if not exists  usuario (
        id bigint auto_increment,
        bol_ativo integer,
        email varchar(255),
        nome varchar(255),
        senha varchar(255),
        primary key (id)
    );