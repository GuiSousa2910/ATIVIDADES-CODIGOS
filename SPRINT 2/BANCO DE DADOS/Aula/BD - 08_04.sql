-- Tipos de atributos (campos)

-- Atributos simples e composto
-- 	simples: não pode ser dividido em subpartes
-- 		Exemplo de simples: bairro

--  composto: pode / deve ser dividio em subpartes	
-- 		Exemplo de composto: endereço 
-- 			pode ser dividio em: logradouro, número, CEP, cidade, bairro, país, complemento...
-- 		Exemplo de composto: telefone -> dependendo da regra de negocio, se o telefone nao for tao importante 
-- 										 para o projeto ele nao precisa necessariamente ser separado

-- Atributos monovalorado:
-- 	Exemplo de monovalorado: bairro -> bairro é diferente de logradouro

-- Atributo multivalorado:
-- 	'O sistema precisa ter pelo menos 2 telefones cadastrados'
-- 	No sistema multivalorados, se existirem mais de 1 valor tem de se criar outra tabela para aquela informação
-- 	Exemplo de multivalorado: 'tabela cadastro com os campos nome, idade, email1 e email 2' já que existem dois campos emails 
-- 							   ele deve criar a tabela email

-- Atributo Derivado:
-- 	idade -> porque a idade é derivado da data de nascimento

-- Atributo Identificador:
-- chave primária (primary key)

-- Uma entidade fraca é uma tabela que depende de outra para existir, uma entidade fraca 
-- 			sempre vai ter como pk o idDaTabela e a fkDaTabelaForte
-- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- . -- 

USE sprint2;

CREATE TABLE funcionario(
idFuncionario int auto_increment primary key, -- atributo identificador
nome varchar(45), -- atributo simples
cep char(9), -- atributo composto: (endereço) + numero + completo
numEndereco varchar(45), 
complemento varchar(45),
teleCelular varchar(45), -- atributos multivalorados + telFixo
teleFixo varchar(45));

INSERT INTO funcionario values
	(default, 'PicaPau', '04253-000', '1500', 'Apto 76', '11941481101', '999775434');
    
SELECT * FROM funcionario;

INSERT INTO funcionario values
	(default, 'Smurf', '04253-000', '1500', 'Apto 80', '11941481101', '999775434');
    
CREATE TABLE dependente(
idDependente int,
fkFuncionario int,
constraint pkComposta primary key (idDependente, fkFuncionario),
nome varchar(45),
parentesco varchar(45),
dtNasc date,
constraint fkFuncionarioDependente foreign key (fkFuncionario) references funcionario(idFuncionario)
);

INSERT INTO dependente VALUES
(1, 1, 'Joao', 'irmão', '1999-01-01'),
(2, 1, 'Joana', 'irmã', '2006-01-01'),
(1, 2, 'Douglas', 'pai', '1954-01-01');
-- (3, 1, 'Jonas', 'pai', '1943-01-01')

SELECT * FROM dependente;

SELECT dependente.nome, funcionario.nome FROM dependente 
	join funcionario 
		on idFuncionario = fkFuncionario;
        
SELECT nome, timestampdiff(YEAR, dtNasc, now()) as idade 
	from dependente; -- mostra a idade do usuario pela sua data de nasc
    
SELECT nome, timestampdiff(SECOND, dtNasc, now()) as idade 
	from dependente; -- mostra a idade do usuario pela sua data de nasc em SEGUNDOS
    
INSERT INTO funcionario values
	(default, 'Bob Esponja', '04253-000', '1500', 'Abacaxi', '11941481101', '999775434');
    
SELECT * FROM funcionario;

SELECT * FROM funcionario 
	left join dependente -- indicando o lado do join ele traz TODA  aquela tabela, independente dele ter as informações necessarias para estar naquele join, nesse caso Bob Esponja não tem um dependente, normalmente ele nao funcionaria, mas colocando LEFT join (por a tabela estar do laod esquerdo do join) ele traz toda a tabela e complementa com o resto do join 
		on idFuncionario = fkFuncionario;
        
-- SELECT * FROM dependente
-- 	right join funcionario
-- 		on idFuncionario = fkFuncionario;
	