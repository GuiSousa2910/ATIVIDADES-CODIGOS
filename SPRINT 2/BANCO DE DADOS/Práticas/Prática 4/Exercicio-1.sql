create database sprint2;
use sprint2;

create table país (
idPais int primary key,
nome varchar(40),
capital varchar(40));

insert into país values
(1, 'Estados Unidos', 'Washington'),
(2, 'Brasil', 'Brásilia'),
(3, 'Argentina', 'Buenos Aires'),
(4, 'Canada', 'Ottawa');

create table atleta(
idAtelta int primary key, 
nome varchar(40),
modalidade varchar(40),
qtdMedalha int);

insert into atleta values
(1, 'Guilherme', 'Atletismo', 4),
(2, 'Ana', 'Basquete', 3),
(3, 'Fernanda', 'Vôlei', 19),
(4, 'Caio', 'Basquete', 23),
(5, 'José', 'Futebol', 2),
(6, 'Alexandre', 'Golfe', 12);

ALTER TABLE atleta ADD COLUMN idPaisAtleta int;
ALTER TABLE atleta ADD CONSTRAINT fkPaisAtleta foreign key (idPaisAtleta) references país(idPais); 
ALTER TABLE atleta RENAME COLUMN idAtelta TO idAtleta;

UPDATE atleta set idPaisAtleta = 1 where idAtleta = 1;
UPDATE atleta set idPaisAtleta = 2 where idAtleta = 2;
UPDATE atleta set idPaisAtleta = 3 where idAtleta = 3;
UPDATE atleta set idPaisAtleta = 3 where idAtleta = 4;
UPDATE atleta set idPaisAtleta = 4 where idAtleta = 5;
UPDATE atleta set idPaisAtleta = 4 where idAtleta = 6;

SELECT * FROM atleta JOIN país ON idPais = idPaisAtleta;
SELECT atleta.nome, país.nome from atleta JOIN país ON idPais = idPaisAtleta; 

SELECT * from atleta JOIN país 
	ON idPais = idPaisAtleta 
		where capital = 'Washington';