USE sprint2;

CREATE TABLE projetos(
idProjeto int primary key,
nome varchar(45),
descricao varchar(200));

INSERT INTO projetos VALUES
(1, 'Caprinos', 'Vamos monitorar os Caprils em beneficio dos caprinos'),
(2, 'Monitoramento dos refrigeradores em açougues', 'Iremos monitorar cada refrigerador do seu açougue para que você tenha maior noção das suas vendas');

CREATE TABLE alunos(
ra int primary key,
fkProjeto int,
constraint FkProjetoAluno foreign key (fkProjeto) references projetos(idProjeto),
fkRepresentante int,
constraint FkAlunoRepresentante foreign key (fkRepresentante) references aluno(ra),
nome varchar(45),
telefone varchar(45)
);

INSERT INTO alunos VALUES
(1, 1, null, 'Guilherme', '40028922'),
(2, 1, 1, 'Ana', '941481101'),
(3, 2, 1, 'Fernanda', '0987654321'),
(4, 2, 1, 'Artur', '123456789'),
(5, 1, 1, 'Fernando', '1234509876'),
(6, 2, 1, 'Gabriel', '1092837465');

CREATE TABLE acompanhante(
idAcompanhante int,
fkAluno int,
constraint FkAlunoAcompanhante primary key (idAcompanhante, fkAluno),
nome varchar(45),
tipoRelacao varchar(45)
);

INSERT INTO acompanhante VALUES
(1, 1, 'Gabriel', 'Pai'),
(2, 2, 'Murilo', 'Irmão'),
(3, 1, 'Pedro', 'Tio'),
(4 , 4, 'Manuela', 'Mãe'),
(5, 3, 'Woody', 'Cachorro'),
(6, 6, 'Renato', 'Tio');

select * from acompanhante;
select * from projetos;
select * from alunos;

SELECT * FROM projetos
	join alunos
		on idProjeto = fkProjeto;
        
SELECT * FROM alunos
	join acompanhante
		on fkAluno = ra;

SELECT * FROM alunos as Alunos
	join alunos as Representantes
		on Alunos.fkRepresentante = Representantes.ra;
        
SELECT * FROM alunos
	join projetos
		on idProjeto = fkProjeto
			where projetos.nome = 'Caprinos';
            
SELECT * FROM alunos 
	join projetos
		on fkProjeto = idProjeto
	join acompanhante
		on fkAluno = ra;
        
-- -.-.-.--.--.-.-.-.-.-.-.--.-.-.-.-.-.-.-.--.-.-.-.-.-.-.-.-.-.-.-.-.-.--.-.-.-.-.-.-.-.-.--.-.-.-

CREATE TABLE organizadores(
idOrganizador int primary key auto_increment,
nome varchar(45),
rua varchar(45),
bairro varchar(45),
email varchar(45),
fkOrganizadorExp int,
constraint fkNovatoExp foreign key (fkOrganizadorExp)references organizador(idOrganizador)
) auto_increment = 30;

INSERT INTO organizadores VALUES
(default, 'Guilherme', 'Avenida Paulita', 'Paulista', 'guilherme@gmail.com', null),
(default, 'Alex', 'Avenida Gulherme Giorgi', 'Carrao', 'alex@gmail.com', 30),
(default, 'Roberto', 'Avenida Paulita', 'Paulista', 'roberto@gmail.com', 30),
(default, 'Rebeca', 'Haddock Lobo', 'Paulista', 'rebeca@gmail.com', 31);

CREATE TABLE campanha (
idCampanha int primary key auto_increment,
fkOrganizador int,
constraint fkCampanhaOrganizador foreign key (fkOrganizador) references organizadores(idOrganizador),
categoriaDoação varchar(45),
instituicao1 varchar(45),
instituicao2 varchar(45),
dataFinal date
) auto_increment = 500;

INSERT INTO campanha (idCampanha, categoriaDoação, instituicao1, instituicao2,dataFinal) VALUES
(default, 'Alimento', 'Alimentos para Todos', 'Alimentação é vida', '2024-10-29'),
(default, 'Remedio', 'Remedios para Todos', 'Remedio é vida', '2024-03-29'),
(default, 'Mascaras', 'Mascaras são essenciais', 'Mascara para todos', '2025-08-29'),
(default, 'Cabelo', 'Cabelo para os carecas', null, '2024-10-30'),
(default, 'Pets', 'Adoção de pets', 'Pets fora das ruas', '2024-07-29'),
(default, 'Alimento', 'Alimentos na mesa', null, '2024-01-29');

UPDATE campanha SET fkOrganizador = 30 where idCampanha = 524;
UPDATE campanha SET fkOrganizador = 31 where idCampanha = 525;
UPDATE campanha SET fkOrganizador = 32 where idCampanha = 526;
UPDATE campanha SET fkOrganizador = 31 where idCampanha = 527;
UPDATE campanha SET fkOrganizador = 33 where idCampanha = 528;
UPDATE campanha SET fkOrganizador = 34 where idCampanha = 529;

select * from organizadores;
select * from campanha;

SELECT * FROM campanha 
	join organizadores
		on fkOrganizador = idOrganizador;
        
SELECT * FROM campanha
	join organizadores
		on fkOrganizador = idOrganizador
			where organizadores.nome = 'Guilherme';
            
SELECT * FROM organizadores as Novato
	join organizadores as Experiente
		on Experiente.idOrganizador = Novato.fkOrganizadorExp;
        
SELECT * FROM organizadores as Novato
	join organizadores as Experiente
		on Experiente.idOrganizador = Novato.fkOrganizadorExp
			where experiente.nome = 'Guilherme';
            
SELECT * FROM organizadores as novato
	join organizadores as experiente
		on novato.fkOrganizadorExp = experiente.idOrganizador
	join campanha 
		on experiente.idOrganizador = fkOrganizador;
        
SELECT * FROM organizadores as novato
	join organizadores as experiente
		on novato.fkOrganizadorExp = experiente.idOrganizador
	join campanha 
		on experiente.idOrganizador = fkOrganizador
			where novato.nome = 'Roberto';




