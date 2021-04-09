create table if not exists perfil (
        id bigint auto_increment,
        nome varchar(255),
        primary key (id)

    );

INSERT INTO PERFIL(nome) VALUES('ROLE_ADMINISTRADOR');
INSERT INTO PERFIL(nome) VALUES('ROLE_USUARIO');