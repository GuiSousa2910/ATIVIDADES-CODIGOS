use sprint2;

CREATE TABLE professor(
	idProfessor int primary key auto_increment,
	nome varchar(50),
	sobrenome varchar(30),
	especialidade1 varchar(40),
	especialidade2 varchar(40));

insert into professor values
	(default, 'Guilherme', 'Sousa', 'Matemática', 'Fisíca'),
	(default, 'Laise', 'Kevin', 'Portugues', ' Quimica'),
	(default, 'João', 'Kevin', 'Historia', 'Geografia'),
	(default, 'Ellen', 'Martin', 'Banco de Dados', 'Arq Comp'),
	(default, 'Pablo', 'Escobar', 'Algoritmo', 'Back-End'),
	(default, 'Joaquin', 'Gabriel', 'Matematica', 'Algebra');

CREATE TABLE disciplina(
	idDisc int primary key auto_increment,
	nomeDisc varchar(45));

insert into disciplina values
	(default, 'Matematica'),
	(default, 'Letras'),
	(default, 'Geografia'),
	(default, 'ADS'),
	(default, 'Ciencias');

ALTER TABLE disciplina ADD COLUMN fkProf int, 
	add constraint fkProfDisc foreign key (fkProf) references professor(idProfessor);

UPDATE disciplina SET fkProf = 1 where idDisc = 1;
UPDATE disciplina SET fkProf = 2 where idDisc = 2;
UPDATE disciplina SET fkProf = 3 where idDisc = 5;
UPDATE disciplina SET fkProf = 4 where idDisc = 3;
UPDATE disciplina SET fkProf = 5 where idDisc = 4;
UPDATE disciplina SET fkProf = 2 where idDisc = 6;

select * from professor join disciplina on fkProf = idProfessor;

select disciplina.nomeDisc, professor.nome from disciplina 
	join professor on fkProf = idProfessor;

select professor.*, nomeDisc from disciplina
	join professor on fkProf = idProfessor where sobrenome = 'Kevin';
    
select professor.especialidade1, nomeDisc from professor 
	join disciplina on fkProf = idProfessor where nome = 'Laise' order by nomeDisc asc;
    
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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








