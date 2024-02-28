use sprint1;

SHOW TABLES;

Create table produto(
id int primary key auto_increment,
nome varchar(60) NOT NULL, -- NOT NULL significa que neste campo não pode ter nada, ele pode ser em branco ""
tipo varchar(50),
constraint chkTipo check (tipo in ('Comida', 'Variedades')),
preco decimal(5,2),
dtValidade datetime, -- 'YYYY-MM-DD HH-MM-SS'
dtCadastro datetime default current_timestamp); -- "current_timestamp" é quando voce pede para ele puxar o horario e dia que está no seu computador 

DESCRIBE produto;

INSERT INTO produto( nome,tipo, preco, dtValidade) VALUES
('Amaciante', 'Variedades', 16.99, null),
('Requeijão', 'Comida', 13.76, '2024-05-26 23:59:59');

select * from produto;

SELECT dtValidade FROM produto WHERE id = 2;
SELECT date_format(dtValidade, '%d/%m/%Y') FROM produto WHERE id = 2; -- "date_format() faz com que você consiga mudar o estilo que deseja mostrar uma data"

-- COMO APELIDAR OS CAMPOS
SELECT date_format(dtValidade, '%d/%m/%Y') AS 'Data da Validade' FROM produto WHERE id = 2; -- Use o AS para apelidar um campo

-- COMO CONCATENAR "concat()"
SELECT concat(nome,' ', preco) FROM produto;
SELECT concat('O nome do produto é', nome, ' e o preço é R$',preco ) FROM produto;
SELECT concat('O nome do produto é', nome, ' e o preço é R$',preco ) AS 'Frase' FROM produto;

-- "unique" é usado para deixar como uma propriedade unica, email, CPF...
ALTER TABLE produto ADD column marca varchar(50) unique;
insert into produto (nome, preco, marca) values
('bolacha', 5.99, 'Bono');

UPDATE produto set marca = 'Downey' where id = 1;
UPDATE produto set marca = 'Vigor' where id = 2;

ALTER TABLE produto ADD COLUMN desconto int default 0; -- default define o padrão
INSERT INTO produto (nome) values
('Cerveja');

select * from produto;

SELECT nome, tipo FROM produto ORDER BY nome;
SELECT nome FROM produto WHERE nome LIKE '%c%' ORDER BY preco;
SELECT nome FROM produto WHERE nome LIKE '%c%' ORDER BY preco DESC;

DELETE FROM produto WHERE id = 4;
 
 -- deleta todas as informações da tabela
truncate table produto;

select * from produto;
insert into produto(nome) values
('Amaciante');

select * from produto;