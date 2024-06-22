-- Criar o banco de dados / Use -> 'CREATE DATABASE'
CREATE DATABASE ADSb;

-- Selecionar o banco de dados "ADSb" / Use -> 'USE ...'
USE ADSb;

-- Criar a primeira tabela / Use -> 'CREATE TABLE "nome da tabela"'
CREATE TABLE aluno (
-- "char" e "varchar" representam textos
ra char(8) primary key, -- 8 caracteres por RA, "char" -> nao vai mudar, todos RAs teram 8 caracteres
nome varchar(45), -- "varchar" -> pode mudar, varia de acordo com a situação
bairro varchar(45));

-- Descrever campos:
describe aluno;

-- Inserir os dados na tabela / escreva "INSERT INTO" para inserir um dado em uma tabela e "VALUES" para colocar os valores
insert into aluno values 
('01241029', 'Guilherme', 'Antonieta'),
('01241123', 'Samuel', 'Tiradentes'); -- nao se pode usar a mesma chave primaria

insert into aluno values -- se cria outra porque nao se pode criar nada após o ;
('01241113', 'Luis', 'Guaianases');

-- Exibir os dados na tabela / para colocar o nome das informaçoes se coloca "SELECT" e depois o "FROM" para escolher a tabela
select ra, nome, bairro from aluno;

-- Exibir apenas nome e bairro
select nome, bairro from aluno;

-- Exibir apenas o aluno com o bairro Antonieta / "WHERE" é o filtro e "*" significa todas as opçoes
select * from aluno WHERE bairro = 'Antonieta';

-- Exibir apenas o bairro que começa com a letra T / "LIKE" para fazer buscas mais especificas, após a letra desejada colocar "%" significa que vai ignorar tudo que vier depois dessa letra
select * from aluno where bairro LIKE 'T%';

-- Exibir apenas o bairro que acaba com a letra A
select * from aluno where bairro like '%A';

-- Exibir um nome onde contem uma letra em qualquer posição
select * from aluno where nome like '%e%';

-- Exibir nome em que a SEGUNDA letra é A / "_" é usado para contabilizar a quantidade de caracteres
select nome from aluno where nome like '_a%';

-- Exibir nome em que a PENULTIMA letra é M
select nome from aluno where nome like '%m_';

-- Nao exibir o diferente
select * from aluno where nome != 'Guilherme';