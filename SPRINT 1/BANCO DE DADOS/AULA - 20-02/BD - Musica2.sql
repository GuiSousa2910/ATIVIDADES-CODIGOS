use sprint1;
create table musica2(
idMusica int primary key,
titulo varchar(40),
artista varchar(40),
genero varchar(40));

insert musica2 values
(1, 'Noite Estrelada', 'Luana Silva', 'Pop'),
(2, 'Caminho Infinito', 'Os Vagalumes', 'Indie'),
(3, 'Amanhecer Sereno', 'Eduardo Martins', 'MPB'),
(4, 'Ritmo Urbano', 'Urban Groove', 'R&B'),
(5, 'Onda Eletrônica', 'DJ Energy', 'Eletrônica'),
(6, 'Melodia do Coração', 'Ana Costa', 'Samba'),
(7, 'Fuga Romântica', 'Carlos Alves', 'Funk'),
(8, 'Vibrações Positivas', 'Reggae Roots', 'Reggae'),
(9, 'Harmonia Celestial', 'Orquestra Sinfônica', 'Clássico'),
(10, 'Festa na Praia', 'Banda Tropical', 'Funk');

-- a) Exibir todos os dados da tabela.
select * from musica2;

-- b) Adicionar o campo curtidas do tipo int na tabela;
ALTER TABLE musica2 ADD COLUMN curtidas int;

-- c) Atualizar o campo curtidas de todas as músicas inseridas;
UPDATE musica2 SET curtidas = 890 where idMusica = 1;
UPDATE musica2 SET curtidas= 80 where idMusica = 2;
UPDATE musica2 SET curtidas = 900 where idMusica = 3;
UPDATE musica2 SET curtidas = 3554 where idMusica = 4;
UPDATE musica2 SET curtidas = 869 where idMusica = 5;
UPDATE musica2 SET curtidas = 235 where idMusica = 6;
UPDATE musica2 SET curtidas = 236 where idMusica = 7;
UPDATE musica2 SET curtidas = 789 where idMusica = 8;
UPDATE musica2 SET curtidas = 2436 where idMusica = 9;
UPDATE musica2 SET curtidas = 489 where idMusica = 10;

-- d) Modificar o campo artista do tamanho 40 para o tamanho 80;
ALTER TABLE musica2 MODIFY COLUMN artista varchar(80);

-- e) Atualizar a quantidade de curtidas da música com id=1;
UPDATE musica2 SET curtidas = 900 where idMusica = 1;

-- f) Atualizar a quantidade de curtidas das músicas com id=2 e com o id=3;
UPDATE musica2 SET curtidas = 980 where idMusica in (2,3);

-- g) Atualizar o nome da música com o id=5;
UPDATE musica2 SET titulo = 'Galinha Pintadinha' where idMusica = 5;

-- h) Excluir a música com o id=4;
DELETE FROM musica2 where idMusica = 4;

-- i) Exibir as músicas onde o gênero é diferente de funk;
select * from musica2 where genero != 'Funk';

-- j) Exibir os dados das músicas que tem curtidas maior ou igual a 20;
select * from musica2 where curtidas >= 20;

-- k) Descrever os campos da tabela mostrando a atualização do campo artista;
describe musica2;

-- l) Limpar os dados da tabela; 
truncate table musica2;





