use adsb;
show tables;
drop table corpo;

create table empresa(
idEmpresa int primary key auto_increment,
nome varchar(45),
responsavel varchar(45));

insert into empresa values
(default, 'STEFANINI', 'Daniela'),
(default, 'C6 BANK', 'Vanessa');

select * from empresa;

create table aluno(
ra char(8) primary key,
nome varchar(45),
bairro varchar(45),
fkEmpresa int,
constraint fkAlunoEmpresa foreign key (fkEmpresa) references empresa(idEmpresa));

/*
CREATE TABLE aluno(
ra char(8) primary key,
nome varchar(45),
bairro varchar(45));

-- criar tabela empresa
ALTER TABLE aluno ADD COLUMN fkEmpresa int not null, ADD CONSTRAINT fkAlunoEmpresa foreing key (fkEmpresa) references empresa(idEmpresa)
*/

ALTER TABLE aluno MODIFY COLUMN fkEmpresa int not null;

INSERT INTO aluno values
('01241029', 'Gui', 'Consolação', 1),
('01241022', 'Duda', 'Trianon MASP', 1),
('01241345', 'Fernanda', 'Trianon MASP', 2);

select * from aluno;

-- EXIBIR AS EMPRESAS E SEUS RESPECTIVOS INTERESSADOS
SELECT * FROM empresa JOIN aluno -- JOIN serve para juntar duas tabelas, sempre tem de ter um 'ON'
	ON idEmpresa = fkEmpresa;
    
SELECT responsavel, bairro FROM empresa JOIN aluno
	ON idEmpresa = fkEmpresa
	where bairro = 'Consolação';

/* não funciona por conta das variaveis serem iguais
	por conta disso coloca o nome da tabela e um ponto antes
    
SELECT nome, nome FROM empresa JOIN aluno 
	on idEmpresa = fkEmpresa;*/
    
SELECT empresa.nome, aluno.nome FROM empresa JOIN aluno 
	on idEmpresa = fkEmpresa;

SELECT a.nome AS NomeAluno,
	e.nome as NomeEmpresa -- apelidando o campo
    from empresa AS e JOIN aluno AS a -- apelidando as tabelas para nao precisar escrever o nome por inteiro
		on a.fkEmpresa = e.idEmpresa;






