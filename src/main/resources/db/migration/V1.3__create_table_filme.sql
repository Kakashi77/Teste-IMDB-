 create table if not exists  filme (
       id bigint auto_increment,
        data_lacamento timestamp,
        desc_diretor varchar(255),
        desc_filme varchar(255),
        genero varchar(255),
        media double,
        nome_filme varchar(255),
        qtd_filme_votado bigint,
        primary key (id)
    );