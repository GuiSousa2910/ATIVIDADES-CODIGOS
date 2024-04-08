use sprint2;

CREATE TABLE cliente(
idCliente int primary key auto_increment,
nome varchar(45),
sobrenome varchar(45),
telefoneFixo varchar(45),
telefoneCelular varchar(45),
cep char(8),
bairro varchar(45),
logradouro varchar(45)
);

INSERT INTO cliente(nome, sobrenome, telefoneFixo, telefoneCelular, cep, bairro, logradouro)VALUES
('Guilherme', 'Sousa', '11987654321', '11912345678', '0000111', 'Cezar Menor','Rua Haddock Lobo'),
('Joaquim', 'Sousa', '1123456789', '1123123123', '1111222', 'Vila Formosa', 'Avenida Guilherme Giorgi'),
('Murilo','Ferreira', '1232455667', '989232312','2222333', 'Paulista', 'Avenida Paulista');

CREATE TABLE pet(
idPet int auto_increment primary key,
tipo varchar(45),
constraint chkTipo check (tipo in('Cachorro', 'Gato', 'Passaro', 'Exotico')),
nome varchar(45),
raca varchar(45),
dtNasc date,
fkCliente int,
constraint fkClientePet foreign key (fkCliente) references cliente(idCliente)
) auto_increment = 100;

INSERT INTO pet VALUES 
(DEFAULT, 'Cachorro', 'Woody', 'Golden Retriver', '2022-02-21', 1),
(DEFAULT, 'Gato', 'Mel', 'Gato Pelado', '2023-01-21', 1),
(DEFAULT, 'Passaro', 'Louro Jose', 'Louro', '2004-10-29', 2),
(DEFAULT, 'Exotico', 'Pericles', 'Ratazana', '2010-09-21', 3),
(DEFAULT, 'Cachorro', 'Pipa', 'Bulldog', '2010-08-21', 2);

SELECT * FROM pet;
SELECT * FROM cliente;

ALTER TABLE cliente MODIFY COLUMN nome varchar(200);

SELECT * FROM pet where tipo = 'Cachorro';

SELECT nome, dtNasc from pet;

SELECT * from pet order by nome ASC;

SELECT * FROM cliente ORDER BY bairro DESC;

SELECT * FROM pet where nome like 'w%';

SELECT * FROM cliente where sobrenome = 'Sousa';

UPDATE cliente SET telefoneFixo = 2357743242 where idCliente = 1;
SELECT * FROM cliente;

SELECT * FROM cliente join pet on fkCliente = idCliente;

SELECT * FROM cliente join pet on fkCliente = idCliente where idCliente = 1;

DELETE FROM pet where idPet = 101;
SELECT * FROM pet;

drop table pet;
drop table cliente;

-- -.-.-.-.-.-.-.-.-.-.--.-.--.-.-.-.-.--.-.-.-.-.-.-.--.-.-.-.-.-.-
CREATE TABLE pessoa(
idPessoa int primary key auto_increment,
nome varchar(45),
dtNasc date,
profissao varchar(45));

CREATE TABLE gasto(
idGasto int,
fkPessoa int,
constraint primary key (idGasto, fkPessoa),
dataValidade date,
valor decimal (10,2),
descricao varchar(200));

-- -.-.-.-.-.-.-.-.-.-.--.-.--.-.-.-.-.--.-.-.-.-.-.-.--.-.-.-.-.-.-

CREATE TABLE setor(
idSetor int primary key auto_increment,
nome varchar(45),
numeroAndar int
);

INSERT INTO setor (nome, numeroAndar)VALUES
('Doces', 2),
('Limpeza', 3),
('Decoração', 4);

CREATE TABLE funcionarios(
idFuncionario int,
nome varchar(45),
telefone varchar(45),
salario decimal(10,2),
fkSetor int,
constraint fkSetorFuncionario foreign key (fkSetor) references setor(idSetor)
);

INSERT INTO funcionarios(nome, telefone, salario, fkSetor) VALUES
('Guilherme', '11941481101', 1000.00, 1),
('Julia', '987654321', 9000.99, 1),
('Giulia', '987659876', 4000.99, 2),
('Pedro', '9871122312', 5100.00, 2),
('Joao', '123459876', 6000.00, 3),
('Caio', '123456789', 2000.00, 3);

CREATE TABLE acompanhante(
idAcompanhante int,
fkFuncionario int,
constraint primary key (idAcompanhante, fkFuncionario),
nome varchar(45),
tipoRelacionamento varchar(45),
dtNasc date);

INSERT INTO acompanhante VALUES
(1, 1, 'Murilo', 'Tio' ,'1999-10-19'),
(2, 1, 'Rosa', 'Mãe' ,'1980-09-17'),
(1, 2, 'Jose', 'Irmão' ,'1988-10-11'),
(2, 2, 'Paulo', 'Pai' ,'2000-03-12'),
(1, 3, 'Saulo', 'Tio' ,'1989-11-19'),
(2, 3, 'Peppa', 'Pai' ,'1994-11-19'),
(1, 4, 'Bruno', 'Irmão' ,'1988-03-19'),
(2, 4, 'Alexandre', 'Bisavô' ,'1920-02-19'),
(1, 5, 'Gustavo', 'Tio' ,'1993-10-21'),
(1, 6, 'Antonio', 'Tio' ,'1978-10-13');


SELECT * FROM setor;
SELECT * FROM funcionarios;
SELECT * FROM acompanhante;

SELECT * FROM funcionarios join setor on fkSetor = idSetor;

SELECT * FROM funcionarios 
	join setor 
		on fkSetor = idSetor where setor.nome = 'Doces';

SELECT * FROM funcionarios 
	join acompanhante 
		on fkFuncionario = idAcompanhante;

SELECT * FROM funcionarios
	join acompanhante 
		on fkFuncionario = idAcompanhante
			where funcionarios.nome = 'Guilherme';
            
SELECT * FROM funcionarios
	join acompanhante
		on fkFuncionario = idAcompanhante
	join setor
		on fkSetor = idSetor;