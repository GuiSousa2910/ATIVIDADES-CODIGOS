use sprint1;
create table curso(
idCurso int primary key,
nome varchar(50),
sigla varchar(3),
coordenador varchar(40));

insert curso value
(1, 'Análise e Desenvolvimento de Sistemas', 'ADS', 'Gerson'),
(2, 'Ciência da Computação', 'CCO', 'Davi'),
(3, 'Sistema da Informação', 'SIS', 'Vera');

-- a) Exibir todos os dados da tabela.
select * from curso;

-- b) Exibir apenas os coordenadores dos cursos.
select coordenador from curso;

-- c) Exibir apenas os dados dos cursos de uma determinada sigla.
select * from curso where sigla like 'ADS';

-- d) Exibir os dados da tabela ordenados pelo nome do curso.
SELECT * FROM curso ORDER BY nome ASC;

-- e) Exibir os dados da tabela ordenados pelo nome do coordenador em ordem decrescente
select * from curso ORDER BY nome DESC;

-- f) Exibir os dados da tabela, dos cursos cujo nome comece com uma determinada letra.
select * from curso where nome like ('a%');

-- g) Exibir os dados da tabela, dos cursos cujo nome termine com uma determinada letra.
select * from curso where nome like ('%o');

-- h) Exibir os dados da tabela, dos cursos cujo nome tenha como segunda letra uma determinada letra
select * from curso where nome like ('_n%');

-- i) Exibir os dados da tabela, dos cursos cujo nome tenha como penúltima letra uma determinada letra.
select * from curso where nome like ('%a_');

-- j) Elimine a tabela.
DROP TABLE curso;


