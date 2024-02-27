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





