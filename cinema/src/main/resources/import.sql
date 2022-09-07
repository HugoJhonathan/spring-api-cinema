INSERT INTO `salas`(`capacidade`, `nome`) VALUES (50,'Sala 01');
INSERT INTO `salas`(`capacidade`, `nome`) VALUES (50,'Sala 02');
INSERT INTO `salas`(`capacidade`, `nome`) VALUES (40,'Sala 03');
INSERT INTO `salas`(`capacidade`, `nome`) VALUES (40,'Sala 04');
INSERT INTO `salas`(`capacidade`, `nome`) VALUES (20,'Sala 05');

INSERT INTO `tipos`(`nome`, `preco`) VALUES ('2D',20);
INSERT INTO `tipos`(`nome`, `preco`) VALUES ('3D',28);

INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('3280-340','Julia Souza');
INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('2830-529','Roberto Firmino');
INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('3802-138','Gabriel Borges');
INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('8032-845','Leonardo da Vinci');
INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('8023-184','Bruna Marques');

INSERT INTO `filmes`( `nome`, `atores`, `diretor`, `duracao`, `generos`, `sinopse`, poster_url, banner_url) VALUES ('Homem-Aranha: Sem Volta para Casa','Tom Holland, Zendaya, Benedict Cumberbatch','Jon Watts',148,'super-herói','O Homem-Aranha precisa lidar com as consequências da sua verdadeira identidade ter sido descoberta.', "https://m.media-amazon.com/images/M/MV5BMTJkYzI0M2QtMDhiOC00MDczLTgyYzQtZmUzMmUxNmVkN2VhXkEyXkFqcGdeQXVyMTA3MDk2NDg2._V1_.jpg", "spiderman-no-way-home.jpg");
INSERT INTO `filmes`( `nome`, `atores`, `diretor`, `duracao`, `generos`, `sinopse`, poster_url, banner_url) VALUES ('Duna','Timothée Chalamet, Zendaya, Rebecca Ferguson, Oscar Isaac, Josh Brolin','Denis Villeneuve',155,'ficção-científica','No futuro distante da humanidade, o duque Leto Atreides aceita a administração do perigoso planeta deserto Arrakis, a única fonte da substância mais valiosa do universo.', "https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX509_.jpg", "duna2021.jpg");
INSERT INTO `filmes`( `nome`, `atores`, `diretor`, `duracao`, `generos`, `sinopse`, poster_url, banner_url) VALUES ('Godzilla vs. Kong','Alexander Skarsgård, Millie Bobby Brown, Rebecca Hall, Brian Tyree Henry','Adam Wingard',113,'ação, aventura','Kong e seus protetores embarcam em uma jornada perigosa para encontrar seu verdadeiro lar. No entanto, eles logo se encontram no caminho de Godzilla, completamente enfurecido, deixando um rastro de destruição em todo o mundo.', "https://m.media-amazon.com/images/M/MV5BYmRiOWJlYzItNjg2Ny00MTA1LTg0ODAtMzQzYWU1NDU2NmUyXkEyXkFqcGdeQXVyMTA3MDk2NDg2._V1_QL75_UY562_CR35,0,380,562_.jpg", "Godzilla-vs-Kong-2.jpg");

insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "14:00:00", 1, 1, 1, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "16:00:00", 1, 1, 1, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "20:00:00", 1, 1, 1, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "22:00:00", 1, 1, 1, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "13:00:00", 2, 5, 2, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "16:00:00", 2, 5, 2, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "20:00:00", 2, 3, 2, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "16:00:00", 3, 3, 2, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "18:00:00", 3, 2, 2, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "20:00:00", 3, 2, 2, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "22:00:00", 3, 2, 2, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "12:00:00", 2, 5, 2, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "22:00:00", 3, 2, 2, true);
insert into sessoes (data_inicio, data_final, horario, filme_id, sala_id, tipo_id, ativo) values ("2022-09-01", "2022-09-10", "14:00:00", 2, 5, 2, true);

insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (1, 1, true, 1, "2022-08-15", 10);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (1, 2, false, 2, "2022-08-16", 20);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (2, 3, true, 4, "2022-08-15", 10);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (2, 4, false, 9, "2022-08-17", 20);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (2, 5, true, 10, "2022-08-18", 10);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (2, 5, false, 11, "2022-08-19", 20);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (5, 2, false, 11, "2022-08-19", 20);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (6, 1, false, 11, "2022-08-19", 20);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (7, 3, false, 11, "2022-08-19", 20);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (8, 4, false, 11, "2022-08-19", 20);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (10, 4, false, 11, "2022-08-19", 20);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona, dia_sessao, total) values (9, 5, false, 11, "2022-08-19", 20);


--insert into pedidos (data) values ("2022-01-01")
--insert into itens_compra (meia, preco, bilhete_id, pedido_id) values (true, 20, 1, 1)
--insert into itens_compra (meia, preco, bilhete_id, pedido_id) values (false, 40, 1, 1)