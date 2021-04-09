    create table if not exists tb_voto (
       id bigint auto_increment,
        nota_voto bigint,
        filme_id bigint,
        usuario_id bigint,
        primary key (id)
    );


ALTER TABLE tb_voto ADD CONSTRAINT FK_ID_FILME FOREIGN KEY ( filme_id ) REFERENCES filme ( id ) ;
ALTER TABLE tb_voto ADD CONSTRAINT FK_ID_USUARIO FOREIGN KEY ( usuario_id ) REFERENCES perfil ( id ) ;
