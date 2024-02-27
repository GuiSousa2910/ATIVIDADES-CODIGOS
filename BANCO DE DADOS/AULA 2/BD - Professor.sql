use sprint1;

create table professor(
idProfessor int primary key,
nome varchar(50),
especialidade varchar(40),
dtNasc date);

insert professor value
(1, 'Prof. Silva', 'Matemática', '1980-05-15'),
(2, 'Prof. Oliveira', 'História', '1975-11-22'),
(3, 'Prof. Santos', 'Biologia', '1988-03-10'),
(4, 'Prof. Costa', 'Inglês', '1972-08-07'),
(5, 'Prof. Pereira', 'Química', '1990-01-25'),
(6, 'Prof. Almeida', 'Educação Física', '1985-09-18'),
(7, 'Prof. Martins', 'Artes', '1978-06-30'),
(8, 'Prof. Oliveira', 'Geografia', '1983-12-14');

-- a) Exibir todos os dados da tabela.
select * from professor;

-- b) Adicionar o campo funcao do tipo varchar(50), onde a função só pode ser ‘monitor’, ‘assistente’ ou ‘titular’;
alter TABLE professor ADD COLUMN cargo varchar(50);
ALTER TABLE professor ADD CONSTRAINT checkCargo check (cargo in ('Monitor', 'Assistente', 'Titular'));

-- c) Atualizar os professores inseridos e suas respectivas funções;
UPDATE professor SET cargo = 'Monitor' where idProfessor = 1;
UPDATE professor SET cargo = 'Assistente' where idProfessor = 2;
UPDATE professor SET cargo = 'Titular' where idProfessor = 3;
UPDATE professor SET cargo = 'Monitor' where idProfessor = 4;
UPDATE professor SET cargo = 'Monitor' where idProfessor = 5;
UPDATE professor SET cargo = 'Titular' where idProfessor = 6;
UPDATE professor SET cargo = 'Monitor' where idProfessor = 7;
UPDATE professor SET cargo = 'Assistente' where idProfessor = 8;

-- d) Inserir um novo professor;
insert professor value
(9, 'Prof. Augusto', 'Fisolofia', '1990-10-31','Titular');
 
--  e) Excluir o professor onde o idProfessor é igual a 5;
DELETE FROM professor WHERE idProfessor = 5;

-- f) Exibir apenas os nomes dos professores titulares;
select nome from professor where cargo like ('Titular');

-- g) Exibir apenas as especialidades e as datas de nascimento dos professores monitores;
select especialidade, dtNasc from professor where cargo like ('Monitor');

-- h) Atualizar a data de nascimento do idProfessor igual a 3;
UPDATE professor SET dtNasc = '1974-12-03' WHERE idProfessor = 3;

--  i) Limpar a tabela Professor;
truncate table professor;


