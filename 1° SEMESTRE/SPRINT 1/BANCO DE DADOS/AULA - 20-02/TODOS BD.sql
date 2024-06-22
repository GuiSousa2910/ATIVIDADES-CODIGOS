use sprint1;
create table atleta2(
idAtleta int primary key,
nome varchar(40),
modalidade varchar(40),
qtdMedalha int
);

insert atleta2 values
(1, 'Kobe Bryant', 'Basquete', 2),
(2, 'Neymar', 'Futebol', 9),
(3, 'Haaland', 'Futebol', 0),
(4, 'Ayrton Senna', 'F1', 3),
(5, 'Lebron James', 'Basquete', 7),
(6, 'Alexandre', 'Corrida', 3),
(7,'Gerson','Ginastica',1),
(8,'Rebeca','Salto com Vara',4),
(9, 'Gilberto', 'Corrida', 3);

-- • Exibir todos os dados da tabela.
select* from atleta2;

-- • Atualizar a quantidade de medalhas do atleta com id=1;
UPDATE atleta2 SET qtdMedalha = 9 where idAtleta = 1;

-- • Atualizar a quantidade de medalhas do atleta com id=2 e com o id=3;
UPDATE atleta2 SET qtdMedalha = 3 where idAtleta in (2,3);

-- • Atualizar o nome do atleta com o id=4;
UPDATE atleta2 SET nome = 'Guilherme' where idAtleta = 4;

-- • Adicionar o campo dtNasc na tabela, com a data de nascimento dos atletas, tipo date;
ALTER TABLE atleta2 ADD column dtNasc date;
describe atleta2;

-- • Atualizar a data de nascimento de todos os atletas;
UPDATE atleta2 SET dtNasc = '2000-10-20' where idAtleta = 1;
UPDATE atleta2 SET dtNasc = '2004-10-09' where idAtleta = 2;
UPDATE atleta2 SET dtNasc = '1990-10-10' where idAtleta = 3;
UPDATE atleta2 SET dtNasc = '2002-12-20' where idAtleta = 4;
UPDATE atleta2 SET dtNasc = '2004-12-01' where idAtleta = 5;
UPDATE atleta2 SET dtNasc = '1980-08-18' where idAtleta = 6;
UPDATE atleta2 SET dtNasc = '1970-09-06' where idAtleta = 7;
UPDATE atleta2 SET dtNasc = '2002-04-30' where idAtleta = 8;
UPDATE atleta2 SET dtNasc = '2000-06-20' where idAtleta = 9;

-- • Excluir o atleta com o id=5;
DELETE FROM atleta2 where idAtleta = 5;

-- • Exibir os atletas onde a modalidade é diferente de natação;
select * from atleta2 where modalidade != 'natação';

-- • Exibir os dados dos atletas que tem a quantidade de medalhas maior ou igual a 3;
select * from atleta2 where qtdMedalha >= 3;

-- • Modificar o campo modalidade do tamanho 40 para o tamanho 60;
ALTER TABLE atleta2 MODIFY COLUMN modalidade varchar(60);

-- • Descrever os campos da tabela mostrando a atualização do campo modalidade;
describe atleta2;

-- • Limpar os dados da tabela; 
truncate TABLE atleta2;

-- --------------------------------------------------- BD MUSICA
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

-- ---------------------------------------------------- BD FILME --------------------
use sprint1;

create table filme(
idFilme int primary key,
titulo varchar(50),
genero varchar(40),
diretor varchar(40));

insert filme values
(1, 'O Enigma das Sombras', 'Suspense', 'Mariana Santos'),
(2, 'Além do Infinito', 'Ficção Científica', 'Pedro Silva'),
(3, 'A Chave do Destino', 'Drama', 'Isabela Oliveira'),
(4, 'O Segredo das Estrelas', 'Aventura', 'Ricardo Pereira'),
(5, 'Entre Dois Mundos', 'Fantasia', 'Camila Martins'),
(6, 'O Jogo da Morte', 'Ação', 'Lucas Almeida'),
(7, 'A Última Fronteira', 'Ficção Científica', 'Amanda Costa'),
(8, 'Caminhos Cruzados', 'Romance', 'Carlos Oliveira');

-- • Exibir todos os dados da tabela.
select * from filme;

-- • Adicionar o campo protagonista do tipo varchar(50) na tabela;
ALTER TABLE filme ADD COLUMN protagonista varchar(50);

-- • Atualizar o campo protagonista de todas os filmes inseridos;
UPDATE filme SET protagonista = 'Woody' where idFilme = 1;
UPDATE filme SET protagonista = 'Anny' where idFilme = 2;
UPDATE filme SET protagonista = 'Franky' where idFilme = 3;
UPDATE filme SET protagonista = 'Fred' where idFilme = 4;
UPDATE filme SET protagonista = 'Rafael' where idFilme = 5;
UPDATE filme SET protagonista = 'Pietro' where idFilme = 6;
UPDATE filme SET protagonista = 'Zeus' where idFilme = 7;
UPDATE filme SET protagonista = 'Eduard' where idFilme = 8;

-- • Modificar o campo diretor do tamanho 40 para o tamanho 150;
ALTER TABLE filme MODIFY COLUMN diretor varchar(150);

-- • Atualizar o diretor do filme com id=5;
UPDATE filme SET diretor = 'Guilherme Sousa' where idFilme = 5;

-- • Atualizar o diretor dos filmes com id=2 e com o id=7;
UPDATE filme SET diretor = 'Fernanda' where idFilme in (2,7);

-- • Atualizar o título do filme com o id=6;
UPDATE filme SET titulo = 'Vivo Morto' where idFilme = 6;

-- • Excluir o filme com o id=3;
DELETE FROM filme WHERE idFilme = 3;

-- • Exibir os filmes em que o gênero é diferente de drama;
select * from filme where genero != 'Drama';

-- • Exibir os dados dos filmes que o gênero é igual ‘suspense’;
select * from filme where genero = 'Suspense';

-- Descrever os campos da tabela mostrando a atualização do campo protagonista e diretor;
describe filme;

-- • Limpar os dados da tabela; 
truncate table filme;

-- -----------------------------------------------------BD REVISTA ---------
use sprint1;
 create table revista(
 idRevista int primary key,
 nome varchar(40),
 categoria varchar(30));
 
 ALTER TABLE revista MODIFY COLUMN idRevista int auto_increment;
 insert revista value
 (default, 'Brigas do BBB', 'Veja'),
 (default, 'IAs vão dominar o mundo!', 'Epoca'),
 (default, 'McDonalds vs BurguerKing', 'Claudia'),
 (default, 'Diferença entre alcool e gasolina', 'Quatro Rodas'),
 (default, 'Davi será vencedor do BBB?', 'Veja');
 
-- • Exibir todos os dados da tabela.
select * from revista;

-- Atualize os dados das categorias das 3 revistas inseridas. Exibir os dados da tabela novamente para verificar se atualizou corretamente.
delete from revista where idRevista = 5;
UPDATE revista SET categoria = 'V Magazine' where idRevista = 1;
UPDATE revista SET categoria = 'Grazia' where idRevista = 2;
UPDATE revista SET categoria = 'Vogue' where idRevista = 3;
select * from revista;

-- Acredito que eu tenha dado CTRL ENTER 2 vezes e então foi adicionada mais colunas do que deveria
delete from revista where idRevista between 6 and 9;
select * from revista;

-- • Insira mais 3 registros completos.
insert revista values
(5, 'Laranjas estragadas estão sendo vendidas', 'Veja'),
(6, 'Roubo de celulares aumenta 32%', 'Magazine'),
(7, 'Lula vence eleições contra Bolsonaro', 'Vogue');

-- • Exibir novamente os dados da tabela.
select * from revista;

-- • Exibir a descrição da estrutura da tabela.
describe revista;

-- • Alterar a tabela para que a coluna categoria possa ter no máximo 40 caracteres.
ALTER TABLE revista MODIFY COLUMN categoria varchar(40);

-- Exibir novamente a descrição da estrutura da tabela, para verificar se alterou o tamanho da coluna categoria
describe revista;

-- • Acrescentar a coluna periodicidade à tabela, que é varchar(15).
ALTER TABLE revista ADD COLUMN periodicidade varchar(15);

-- • Exibir os dados da tabela.
select * from revista;

-- • Excluir a coluna periodicidade da tabela.
 ALTER TABLE revista DROP COLUMN periodicidade;
 describe revista;

-- --------------------------------------------------BD CURSO ----------------------------
use sprint1;
create table curso(
idCurso int primary key,
nome varchar(50),
sigla varchar(3),
coordenador varchar(40));

insert curso value
(1, 'Análise e Desenvolvimento de Sistemas', 'ADS', 'Gerson'),
(2, 'Ciência da Computação', 'CCO', 'Davi'),
(3, 'Sistema da Informação', 'SIS', 'Vera');

-- a) Exibir todos os dados da tabela.
select * from curso;

-- b) Exibir apenas os coordenadores dos cursos.
select coordenador from curso;

-- c) Exibir apenas os dados dos cursos de uma determinada sigla.
select * from curso where sigla like 'ADS';

-- d) Exibir os dados da tabela ordenados pelo nome do curso.
SELECT * FROM curso ORDER BY nome ASC;

-- e) Exibir os dados da tabela ordenados pelo nome do coordenador em ordem decrescente
select * from curso ORDER BY nome DESC;

-- f) Exibir os dados da tabela, dos cursos cujo nome comece com uma determinada letra.
select * from curso where nome like ('a%');

-- g) Exibir os dados da tabela, dos cursos cujo nome termine com uma determinada letra.
select * from curso where nome like ('%o');

-- h) Exibir os dados da tabela, dos cursos cujo nome tenha como segunda letra uma determinada letra
select * from curso where nome like ('_n%');

-- i) Exibir os dados da tabela, dos cursos cujo nome tenha como penúltima letra uma determinada letra.
select * from curso where nome like ('%a_');

-- j) Elimine a tabela.
DROP TABLE curso;

-- ------------------------------------------------------ BD PROFESSOR ----------------------
use sprint1;

create table professor(
idProfessor int primary key,
nome varchar(50),
especialidade varchar(40),
dtNasc date);

insert professor value
(1, 'Prof. Silva', 'Matemática', '1980-05-15'),
(2, 'Prof. Oliveira', 'História', '1975-11-22'),
(3, 'Prof. Santos', 'Biologia', '1988-03-10'),
(4, 'Prof. Costa', 'Inglês', '1972-08-07'),
(5, 'Prof. Pereira', 'Química', '1990-01-25'),
(6, 'Prof. Almeida', 'Educação Física', '1985-09-18'),
(7, 'Prof. Martins', 'Artes', '1978-06-30'),
(8, 'Prof. Oliveira', 'Geografia', '1983-12-14');

-- a) Exibir todos os dados da tabela.
select * from professor;

-- b) Adicionar o campo funcao do tipo varchar(50), onde a função só pode ser ‘monitor’, ‘assistente’ ou ‘titular’;
alter TABLE professor ADD COLUMN cargo varchar(50);
ALTER TABLE professor ADD CONSTRAINT checkCargo check (cargo in ('Monitor', 'Assistente', 'Titular'));

-- c) Atualizar os professores inseridos e suas respectivas funções;
UPDATE professor SET cargo = 'Monitor' where idProfessor = 1;
UPDATE professor SET cargo = 'Assistente' where idProfessor = 2;
UPDATE professor SET cargo = 'Titular' where idProfessor = 3;
UPDATE professor SET cargo = 'Monitor' where idProfessor = 4;
UPDATE professor SET cargo = 'Monitor' where idProfessor = 5;
UPDATE professor SET cargo = 'Titular' where idProfessor = 6;
UPDATE professor SET cargo = 'Monitor' where idProfessor = 7;
UPDATE professor SET cargo = 'Assistente' where idProfessor = 8;

-- d) Inserir um novo professor;
insert professor value
(9, 'Prof. Augusto', 'Fisolofia', '1990-10-31','Titular');
 
--  e) Excluir o professor onde o idProfessor é igual a 5;
DELETE FROM professor WHERE idProfessor = 5;

-- f) Exibir apenas os nomes dos professores titulares;
select nome from professor where cargo like ('Titular');

-- g) Exibir apenas as especialidades e as datas de nascimento dos professores monitores;
select especialidade, dtNasc from professor where cargo like ('Monitor');

-- h) Atualizar a data de nascimento do idProfessor igual a 3;
UPDATE professor SET dtNasc = '1974-12-03' WHERE idProfessor = 3;

--  i) Limpar a tabela Professor;
truncate table professor;