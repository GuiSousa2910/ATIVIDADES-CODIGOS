use sprint2;

create table alunos(
ra int primary key,
nome varchar(45),
idade int,
fkRepresentante int,
constraint fkRepresentanteAluno foreign key (fkRepresentante) references alunos(ra));

INSERT INTO alunos (ra, nome, idade) values 
(01241029, 'Guilherme', 18),
(01241032, 'Joao Kevin', 18),
(01241443, 'Laise', 19),
(01241889, 'Ellen', 20);

select * from alunos;

create table projeto(
idProjeto int primary key auto_increment,
nome varchar(45),
descricao varchar(200));

INSERT INTO projeto (nome, descricao)VALUES 
('IoT em refrigeradores', 'No nosso projeto colocaremos sensores de bloqueio e de temperatura em refrigeradores'),
('Monitoramento de café', 'No nosso projeto vamos monitorar a umidade e temperatura das estufas de café');

select * from projeto;

UPDATE alunos SET fkRepresentante = 01241889 where ra = 01241029;
UPDATE alunos SET fkRepresentante = 01241889 where ra = 01241032;
UPDATE alunos SET fkRepresentante = 01241889 where ra = 01241443;

select * from alunos;

select alunos.nome as nomeAluno, representante.nome as nomeRep from alunos as alunos
	join alunos as representante
		on alunos.fkRepresentante = representante.ra;
        
ALTER TABLE alunos ADD column fkProjeto int, 
	ADD CONSTRAINT fkProjetoAluno foreign key (fkProjeto) references projeto(idProjeto);
    
UPDATE alunos SET fkProjeto = 1 where ra = 01241029;
UPDATE alunos SET fkProjeto = 2 where ra = 01241032;
UPDATE alunos SET fkProjeto = 1 where ra = 01241443;
UPDATE alunos SET fkProjeto = 2 where ra = 01241889;

select * from alunos join projeto on idProjeto = fkProjeto;

select * from alunos join projeto on idProjeto = fkProjeto
	where projeto.nome = 'IoT em refrigeradores';