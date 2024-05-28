create database exercicios;
use exercicios;

CREATE TABLE departamento (
idDepto int primary key,
nomeDepto varchar(45),
dataInicioGer date
);

CREATE TABLE funcionario (
	idFunc int primary key,
    nomeFunc varchar (30),
    salario decimal(9,2),
    sexo char(1)
);

ALTER TABLE departamento ADD COLUMN fkGerente int;
ALTER TABLE departamento ADD CONSTRAINT foreign key (fkGerente) references funcionario(idFunc);

ALTER TABLE funcionario ADD COLUMN fkSupervisor int, ADD CONSTRAINT foreign key (fkSupervisor) references funcionario(idFunc);
ALTER TABLE funcionario ADD COLUMN fkDepto int, ADD CONSTRAINT foreign key (fkDepto) references departamento(idDepto);
ALTER TABLE funcionario ADD COLUMN dataNasc date;

CREATE TABLE projeto(
	idProj int primary key,
    nomeProj varchar (45),
    localProj varchar(45),
    fkDepto int,
    foreign key (fkDepto) references departamento (idDepto)
);

CREATE TABLE funcProj (
    fkFunc int,
    foreign key (fkFunc) references funcionario (idFunc),
    fkProj int,
    foreign key (fkProj) references projeto (idProj),
    horas decimal (3,1),
    primary key (fkFunc, fkProj)
);

drop table funcProj;

insert into departamento (idDepto, nomeDepto, dataInicioGer) values
(105, 'Pesquisa','2008-05-22'),
(104, 'Administração', '2015-01-01'),
(101, 'Matriz','2001-06-19');

INSERT INTO funcionario (idFunc, nomeFunc, salario, sexo, dataNasc, fkDepto) VALUES
(1, 'Joao Silva', 3500, 'm', '1985-01-09', 105),
(2, 'Fernando Wong', 4500, 'm', '1975-12-08', 105),
(3, 'Alice Sousa', 2500, 'f', '1988-01-19', 104),
(4, 'Janice Morais', 4300, 'f', '1970-06-20', 104),
(5, 'Ronaldo Lima', 3800, 'm', '1982-09-15', 105),
(6, 'Joice Leite', 2500, 'f', '1992-07-31', 105),
(7, 'Antonio Pereira', 2500, 'm', '1989-03-29', 104),
(8, 'Juliano Brito', 5500, 'm', '1957-11-10', 101);

UPDATE departamento SET fkGerente = 2 where idDepto = 105;
UPDATE departamento SET fkGerente = 7 where idDepto = 104;
UPDATE departamento SET fkGerente = 8 where idDepto = 101;

UPDATE funcionario SET fkSupervisor = 2 where idFunc = 1;
UPDATE funcionario SET fkSupervisor = 8 where idFunc = 2;
UPDATE funcionario SET fkSupervisor = 7 where idFunc = 3;
UPDATE funcionario SET fkSupervisor = 8 where idFunc = 4;
UPDATE funcionario SET fkSupervisor = 1 where idFunc = 5 and 6;
UPDATE funcionario SET fkSupervisor = 4 where idFunc = 7;

INSERT INTO projeto (idProj, nomeProj, localProj, fkDepto) VALUES
(1, 'Produto X', 'Santo André', 105),
(2, 'Produto Y', 'Itu', 105),
(3, 'Produto Z', 'São Paulo', 105),
(10, 'Informatização', 'Mauá', 104),
(20, 'Reorganização', 'São Paulo', 101),
(30, 'Benefícios', 'Mauá', 104);

INSERT INTO funcProj (fkFunc, fkProj, horas) VALUES
(1, 1, 32.5),
(1, 2, 7.5),
(5, 3, 40.0),
(6, 1, 20.0),
(6, 2, 20.0),
(2, 2, 10.0),
(2, 3, 10.0),
(2, 10, 10.0),
(2, 20, 10.0),
(3, 30, 30.0),
(3, 10, 10.0),
(7, 10, 35.0),
(7, 30, 5.0),
(4, 30, 20.0),
(4, 20, 15.0),
(8, 20, NULL);

select * from funcionario;
select * from departamento;
select * from projeto;
select * from funcProj;

INSERT INTO funcionario(idFunc, nomeFunc, salario, sexo, fkSupervisor, dataNasc, fkDepto) VALUES 
(null, 'Ceciclia', 2800, 'f', null, '1980-04-05', 104); -- id nao pode ser null

INSERT INTO funcionario(idFunc, nomeFunc, salario, sexo, fkSupervisor, dataNasc, fkDepto) VALUES 
(3, 'Alice', 2800, 'f', 4, '1980-04-05', 104); -- id ta repetindo

INSERT INTO funcionario(idFunc, nomeFunc, salario, sexo, fkSupervisor, dataNasc, fkDepto) VALUES 
(9, 'Cecilia', 2800, 'f', 4, '1980-04-05', 107); -- nao existe depto com id 107

INSERT INTO funcionario(idFunc, nomeFunc, salario, sexo, fkSupervisor, dataNasc, fkDepto) VALUES 
(9, 'Cecilia', 2800, 'f', 4, '1980-04-05', 104); -- agora foi porque nada das opções anteriores está acontecendo aqui

DELETE FROM funcProj where fkFunc = 3 and fkProj = 10; -- consegui pq apaguei as duas fk's
DELETE FROM funcionario where idFunc = 4; -- nao, teria que apagar a fk tambem
DELETE FROM funcionario where idFunc = 2; -- mesmo motivo
UPDATE funcionario SET salario = 2800 where idFunc = 3; -- consegui pq so dei update na info
UPDATE funcionario SET fkDepto = 101 where idFunc = 3; 
UPDATE funcionario SET fkDepto = 107 where idFunc = 3; -- nao existe depto 107
SELECT dataNasc, salario FROM funcionario where nomeFunc = 'João Silva';
select salario from funcionario;
select distinct(salario) from funcionario;
select * from funcionario order by nomeFunc asc;
select * from funcionario order by salario asc;
select * from funcionario where salario > 2000 and salario < 4000;
select nomeFunc, salario from funcionario where nomeFunc like 'j%';
select nomeFunc, salario from funcionario where nomeFunc like '%a';
select nomeFunc from funcionario where nomeFunc like '__n%';
select nomeFunc, dataNasc from funcionario where nomeFunc like'%s____';
select * from funcionario join departamento on idDepto = fkDepto where departamento.nomeDepto = 'Pesquisa';
select * from funcionario join departamento on idDepto = fkDepto where departamento.nomeDepto = 'Pesquisa' and funcionario.salario > 3500;
select * from funcionario join departamento on idDepto = fkDepto where departamento.nomeDepto = 'Pesquisa' and funcionario.nomeFunc like 'j%';
select idFunc as 'Funcionario', nomeFunc, fkSupervisor as 'ID do Supervisor' from funcionario;
select projeto.localProj, idProj, departamento.idDepto, funcionario.dataNasc from projeto join departamento on idDepto = fkDepto join funcionario on idDepto = fkDepto join funcionario on idFunc = fkFunc where localProj = 'São Paulo';
select funcionario.idFunc, funcionario.nomeFunc, projeto.idProj, projeto.nomeProj, funcProj.horas from funcionario join departamento on idDepto = fkDepto join projeto on idFunc = fkFunc join funcProj on idProj = fkProj;
select nomeFunc from funcionario where dataNasc < '1980-12-31';
select count(distinct(salario)) from funcionario;
select count(distinct(localProj)) from projeto;
select avg(salario), sum(salario) from funcionario;
select min(salario), max(salario) from funcionario;
select departamento.idDepto, avg(funcionario.salario), sum(funcionario.salario) from departamento join funcionario on idDepto = fkDepto group by idDepto;
select departamento.idDepto, min(funcionario.salario), max(funcionario.salario) from funcionario join departamento on idDepto = fkDepto group by idDepto;
INSERT INTO funcionario (idFunc, nomeFunc, salario, sexo, fkSupervisor, dataNasc, fkDepto) VALUES
(10, 'José', 1800, 'm', 3, '2000-10-12', null),
(11, 'Benedito', 1200, 'm', 5, '2001-09-01', null);

INSERT INTO departamento (idDepto, nomeDepto, fkGerente, dataInicioGer) VALUES
(110, 'RH', 3, '2018-11-10');

