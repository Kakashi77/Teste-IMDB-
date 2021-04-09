create table if not exists  usuario_perfis (
       usuario_id bigint not null,
        perfis_id bigint not null
    );

ALTER TABLE usuario_perfis ADD CONSTRAINT FK_PERFIl_ID FOREIGN KEY ( perfis_id ) REFERENCES perfil ( id ) ;
ALTER TABLE usuario_perfis ADD CONSTRAINT FK_USUARIO_ID FOREIGN KEY ( usuario_id ) REFERENCES usuario ( id ) ;
