INSERT INTO USUARIO(email, senha, bol_ativo,nome) VALUES('test@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq',1,'Teste');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1, 1);

INSERT INTO FILME(NOME_FILME, desc_Filme,desc_Diretor,genero) VALUES('Mortal Kombat 3', 'Filme de Luta', 'Teste1', 'Luta');

INSERT INTO tb_voto(filme_id,nota_Voto,usuario_id) VALUES(1,3,1);


