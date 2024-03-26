CREATE TABLE curso(
	idCurso int primary key auto_increment,
	nome varchar(50),
	sigla char(3));

insert into curso values
	(default, 'Análise e Desenvolvimento de Sistemas', 'ADS'),
	(default, 'Sistema da Informação', 'SIS'),
	(default, 'Ciencia da Computação', 'CCO');

CREATE TABLE provas(
idProva int primary key auto_increment,
dificuldade varchar(30));

insert into provas values
(default, 'Fácil'),
(default, 'Difil'),
(default, 'Medio'),
(default, 'Fácil');

ALTER TABLE provas ADD COLUMN fkCurso int;
ALTER TABLE provas ADD CONSTRAINT fkCursoProva foreign key (fkCurso) references curso(idCurso);

UPDATE provas SET fkCurso = 1 where idProva = 1;
UPDATE provas SET fkCurso = 2 where idProva = 2;
UPDATE provas SET fkCurso = 3 where idProva = 3;
UPDATE provas SET fkCurso = 2 where idProva = 4;

SELECT * FROM curso join provas on fkCurso = idCurso;
SELECT * FROM curso join provas on fkCurso = idCurso where sigla = 'ADS';
ALTER TABLE curso ADD CONSTRAINT chkCurso CHECK (sigla in ('ADS', 'SIS', 'CCO'));









