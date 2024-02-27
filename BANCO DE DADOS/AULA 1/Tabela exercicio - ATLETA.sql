create database sprint1;
use sprint1;

-- Criar a tabela chamada Atleta...
create table atleta(
idAtleta int primary key,
nome varchar(40),
modalidade varchar(40),
qtdMedalha int);

-- Inserir dados na tabela...
insert into atleta values
(1,'Alexandre','Corrida',6),
(2,'Vanessa','Ginastica',4),
(3,'Guilherme','Corrida',3),
(4,'Caio','Corrida',0),
(5,'Felipe','Salto com Vara', 12),
(6,'Daiane','Ginastica',3),
(7,'Gerson','Ginastica',1),
(8,'Rebeca','Salto com Vara',4);

-- Exibir todos os dados da tabela.
select * from atleta;

-- Exibir apenas os nomes e quantidade de medalhas dos atletas.
select nome, qtdMedalha from atleta;

-- Exibir apenas os dados dos atletas de uma determinada modalidade.
select * from atleta where modalidade = 'Corrida';

-- Exibir os dados da tabela, dos atletas cujo nome contenha a letra s
select * from atleta where nome like ('%s%');

-- Exibir os dados da tabela, dos atletas cujo nome comece com uma determinada letra.
select * from atleta where nome like ('G%');

-- Exibir os dados da tabela, dos atletas cujo nome termine com a letra o.
select * from atleta where nome like ('%o');

-- Exibir os dados da tabela, dos atletas cujo nome tenha a penúltima letra r.
select * from atleta where nome like('%r_');



