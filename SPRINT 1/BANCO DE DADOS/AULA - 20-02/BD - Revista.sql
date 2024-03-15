use sprint1;
 create table revista(
 idRevista int primary key,
 nome varchar(40),
 categoria varchar(30));
 
 ALTER TABLE revista MODIFY COLUMN idRevista int auto_increment;
 insert revista value
 (default, 'Brigas do BBB', 'Veja'),
 (default, 'IAs vão dominar o mundo!', 'Epoca'),
 (default, 'McDonalds vs BurguerKing', 'Claudia'),
 (default, 'Diferença entre alcool e gasolina', 'Quatro Rodas'),
 (default, 'Davi será vencedor do BBB?', 'Veja');
 
-- • Exibir todos os dados da tabela.
select * from revista;

-- Atualize os dados das categorias das 3 revistas inseridas. Exibir os dados da tabela novamente para verificar se atualizou corretamente.
delete from revista where idRevista = 5;
UPDATE revista SET categoria = 'V Magazine' where idRevista = 1;
UPDATE revista SET categoria = 'Grazia' where idRevista = 2;
UPDATE revista SET categoria = 'Vogue' where idRevista = 3;
select * from revista;

-- Acredito que eu tenha dado CTRL ENTER 2 vezes e então foi adicionada mais colunas do que deveria
delete from revista where idRevista between 6 and 9;
select * from revista;

-- • Insira mais 3 registros completos.
insert revista values
(5, 'Laranjas estragadas estão sendo vendidas', 'Veja'),
(6, 'Roubo de celulares aumenta 32%', 'Magazine'),
(7, 'Lula vence eleições contra Bolsonaro', 'Vogue');

-- • Exibir novamente os dados da tabela.
select * from revista;

-- • Exibir a descrição da estrutura da tabela.
describe revista;

-- • Alterar a tabela para que a coluna categoria possa ter no máximo 40 caracteres.
ALTER TABLE revista MODIFY COLUMN categoria varchar(40);

-- Exibir novamente a descrição da estrutura da tabela, para verificar se alterou o tamanho da coluna categoria
describe revista;

-- • Acrescentar a coluna periodicidade à tabela, que é varchar(15).
ALTER TABLE revista ADD COLUMN periodicidade varchar(15);

-- • Exibir os dados da tabela.
select * from revista;

-- • Excluir a coluna periodicidade da tabela.
 ALTER TABLE revista DROP COLUMN periodicidade;
 describe revista;
