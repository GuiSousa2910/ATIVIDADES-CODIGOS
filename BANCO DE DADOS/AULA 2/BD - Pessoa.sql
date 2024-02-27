use sprint1;

create table pessoa(
id int primary key,
nome varchar(50),
altura float,
dtNascimento date);

insert pessoa value
(1, 'Cássio', 1.95, '1983-10-29');

describe pessoa;

-- Voce nao pode mudar uma informação da tabela depois de ja ter colocado, para alterar voce precisa usar o "ALTER TABLE" para alterar essa tabela, "modify column" para alterar uma coluna em especifico e "alter_increment" para auto incrementar uma informação.  
alter table pessoa modify column id int auto_increment;

insert pessoa value
(default, 'Neymar', 1.75, '1989-02-12');

-- Mesmo tendo colocado "DEFAULT" ele colocou um 2 no id, isso acontece por conta do "AUTO_INSERT"
select * from pessoa;

insert pessoa values
(default, 'Guilherme', 1.81, '2005-10-29'),
(default, 'Ana', 1.50, '2005-04-10');

select * from pessoa;

-- "RENAME COLUMN" é usado para renomar o nome de uma variavel na tabela
alter table pessoa RENAME column id TO idPessoa;

-- O que antes era "id" agora é "idPessoa"
describe pessoa;

-- "UPDATE 'nome tabela' SET 'varaivel' = 'INFORMAÇÃO NOVA' WHERE 'nome variavel da primary key' = 'numero da primary key'",é assim que se faz para alterar um dado
UPDATE pessoa SET nome = 'Guilherme Sousa' where idPessoa = 3;
select * from pessoa;

-- "DROP COLUMN" usa para excluir uma parte da tabela de forma IRREPARAVEL
ALTER TABLE pessoa DROP COLUMN dtNascimento;
describe pessoa;

-- Para adicionar uma coluna na tabela use "ADD COLUMN nome da colune e tipo" 
ALTER TABLE pessoa ADD column posicao varchar(40);
describe pessoa;

UPDATE pessoa SET posicao = 'Goleiro' where idPessoa = 1;
UPDATE pessoa SET posicao = 'Atacante' where idPessoa = 2;

-- Usasse "IN" quando existem mais de uma informação 
UPDATE pessoa SET posicao = 'Nao Joga' where idPessoa IN (3, 4);
describe pessoa;

-- "CONSTRAINT" é uma restrição/configuração especifica, um jeito dele só aceitar uma informação especifica
ALTER TABLE pessoa ADD CONSTRAINT checkPosicao check (posicao in ('Goleiro', 'Atacante', 'Nao Joga'));

-- Nessa condição tem que dar erro, já que coloquei uma restrição que só entra 'Goliero', 'Atacante', 'Nao Joga'
insert pessoa value
(default, 'Murilo', 1.80, 'Zagueiro');