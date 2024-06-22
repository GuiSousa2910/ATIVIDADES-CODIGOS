use sprint3;

CREATE TABLE cliente(
idCliente int primary key auto_increment,
fkClienteIndicado int,
foreign key (fkClienteIndicado) references cliente(idCliente),
nome varchar(45),
email varchar(45),
bairro varchar(45),
logradouro varchar(45),
numero int
);

INSERT INTO cliente (nome, email, bairro, logradouro, numero) values
('Guilherme', 'gui@gmail.com', 'guilherminas', 'Avenida Guilherme Giorgi', 12),
('Ana', 'ana@gmail.com', 'ana banana', 'Rua Ana Clara', 10),
('Fernanda', 'fe@gmail.com', 'fernandinas', 'Avenida Fernanda Montenegro', 43);

UPDATE cliente SET fkClienteIndicado = 1 where idCliente = 2;
UPDATE cliente SET fkClienteIndicado = 2 where idCliente = 1;

CREATE TABLE venda(
idVenda int primary key auto_increment, 
fkCliente int,
foreign key (fkCliente) references cliente(idCliente),
totalVendas int,
dataVenda date
);

INSERT INTO venda (fkCliente, totalVendas, dataVenda) VALUES 
(1, 100, '2024-05-03'),
(2, 40, '2023-05-03'),
(3, 250, '2024-02-11');

CREATE TABLE produto(
idProduto int primary key auto_increment,
nome varchar(45),
descricao varchar(200),
preco decimal(5, 2)
);

INSERT INTO produto (nome, descricao, preco)VALUES
('Mouse', 'Mouse gamer de ultima geração', 100.20),
('Teclado', 'Teclado gamer de primeira geração', 150.20),
('Camisa', 'Camisa Polo', 300.90),
('Notebook', 'Notebook gamer', 500.99);

CREATE TABLE sistema (
fkVenda int,
fkProduto int, 
qntProdutoVendido int,
desconto decimal(5, 2),
primary key (fkVenda , fkProduto)
);

INSERT INTO sistema VALUES
(1, 1, 100, 0),
(1, 2, 100, 10),
(2, 1, 50, 0),
(2, 2, 1000, 0);

select * from sistema;
select * from venda;
select * from cliente;
select * from produto;

select * from cliente join venda on idCliente = fkCliente;

select * from cliente join venda on idCliente = fkCliente where cliente.nome = 'Guilherme';

SELECT * from cliente as principal join cliente as indicado on indicado.idCliente = principal.fkClienteIndicado;

SELECT * from cliente as principal join cliente as indicado on indicado.idCliente = principal.fkClienteIndicado where principal.nome = 'Ana';

SELECT * from cliente as principal 
	join cliente as indicado 
		on indicado.idCliente = principal.fkClienteIndicado 
	join venda 
		on indicado.idCliente = venda.fkcliente 
	join sistema 
		on venda.idVenda = sistema.fkVenda;

select venda.dataVenda, produto.nome, sistema.qntProdutoVendido from venda join sistema on sistema.fkVenda = venda.idVenda join produto on produto.fkProduto = sistema.fkProduto

SELECT 