create database sprint1;
use sprint1;

-- Criar a tabela chamada Musica
create table Musica(
idMusica int primary key,
titulo varchar(40),
artista varchar(40),
genero varchar(40));

describe Musica;

-- Inserir dados na tabela
insert Musica values
(1,'Blinding Lights','The Weekend','pop'),
(2,'Sunflower','Post Malone','pop'),
(3,'Rockstar','Post Malone','rap'),
(4,'Beat It','Michael Jackson','pop'),
(5,'Boiadeira','Ana Castela','sertanejo'),
(6,'Betty','Taylor Swift','country'),
(7,'I like you','Doja Cat','indie'),
(8,'Flashing Lights','Kanye West','rap');

-- Exibir todos os dados da tabela
select * from Musica;

-- Exibir apenas os títulos e os artistas das músicas
select titulo, artista from Musica;

-- Exibir apenas os dados das músicas de um determinado gênero
select * from Musica where genero = 'rap';

-- Exibir apenas os dados das músicas de um determinado artista.
select * from Musica where artista = 'Post Malone';

-- Exibir os dados da tabela, das músicas cujo título comece com uma determinada letra.
select * from Musica where titulo like ('f%'); 

-- Exibir os dados da tabela, das músicas cujo artista termine com uma determinada letra.
select * from Musica where titulo like ('%A');

-- Exibir os dados da tabela, das músicas cujo gênero tenha como segunda letra uma determinada letra.
select * from Musica where genero like ('_a%');

-- Exibir os dados da tabela, das músicas cujo título tenha como penúltima letra uma determinada letra.
select * from Musica where titulo like ('%e_');