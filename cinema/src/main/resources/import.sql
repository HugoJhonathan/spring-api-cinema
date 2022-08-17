INSERT INTO `salas`(`capacidade`, `nome`) VALUES ('50','sala 1')
INSERT INTO `salas`(`capacidade`, `nome`) VALUES ('50','sala 2')
INSERT INTO `salas`(`capacidade`, `nome`) VALUES ('40','sala 3')
INSERT INTO `salas`(`capacidade`, `nome`) VALUES ('40','sala 4')
INSERT INTO `salas`(`capacidade`, `nome`) VALUES ('20','sala 5')

INSERT INTO `tipos`(`nome`, `preco`) VALUES ('2D','20')
INSERT INTO `tipos`(`nome`, `preco`) VALUES ('3D','28')

INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('3280-340','Julia Souza')
INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('2830-529','Roberto Firmino')
INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('3802-138','Gabriel Borges')
INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('8032-845','Leonardo da Vinci')
INSERT INTO `pessoas`(`cpf`, `nome`) VALUES ('8023-184','Bruna Marques')

INSERT INTO `filmes`(`atores`, `diretor`, `duracao`, `generos`, `nome`, `sinopse`) VALUES ('Tom Holland, Zendaya, Benedict Cumberbatch','Jon Watts',148,'super-herói','Homem-Aranha: Sem Volta para Casa','O Homem-Aranha precisa lidar com as consequências da sua verdadeira identidade ter sido descoberta.')

INSERT INTO `filmes`(`atores`, `diretor`, `duracao`, `generos`, `nome`, `sinopse`) VALUES ('Timothée Chalamet, Zendaya, Rebecca Ferguson, Oscar Isaac, Josh Brolin','Denis Villeneuve',155,'ficção-científica','Duna','No futuro distante da humanidade, o duque Leto Atreides aceita a administração do perigoso planeta deserto Arrakis, a única fonte da substância mais valiosa do universo, a especiaria conhecida como "Melange", uma droga que prolonga a vida humana e fornece níveis acelerados de pensamento.')

INSERT INTO `filmes`(`atores`, `diretor`, `duracao`, `generos`, `nome`, `sinopse`) VALUES ('Alexander Skarsgård, Millie Bobby Brown, Rebecca Hall, Brian Tyree Henry','Adam Wingard',113,'ação, aventura','Godzilla vs. Kong','Kong e seus protetores embarcam em uma jornada perigosa para encontrar seu verdadeiro lar. No entanto, eles logo se encontram no caminho de Godzilla, completamente enfurecido, deixando um rastro de destruição em todo o mundo.')


insert into sessoes (horario, filme_id, sala_id, tipo_id) values ("2022-02-03:12:00:00", 1, 1, 1);
insert into sessoes (horario, filme_id, sala_id, tipo_id) values ("2022-02-03:16:00:00", 1, 1, 1);

insert into bilhetes (sessao_id, pessoa_id, meia, poltrona) values (1, 1, true, 1);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona) values (1, 2, false, 2);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona) values (2, 3, true, 4);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona) values (2, 4, false, 9);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona) values (2, 5, true, 10);
insert into bilhetes (sessao_id, pessoa_id, meia, poltrona) values (2, 5, false, 11);
