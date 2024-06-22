CREATE DATABASE sprint3;
USE sprint3;

-- tabelas NN
CREATE TABLE paciente(
idPaciente int primary key auto_increment,
nome varchar(45)
) auto_increment = 100;

INSERT INTO paciente (nome) VALUES 
('Braian'),
('Dom'),
('Mia');

CREATE TABLE medico (
idMedico int primary key auto_increment,
nome varchar(45)
) auto_increment = 1;

INSERT INTO medico (nome)VALUES
('Dr. Rock'),
('Dr. Shawn'),
('Dra. Letty');

-- junção das tabelas paciente e medico
CREATE TABLE consulta (
idConsulta int,
fkPaciente int,
fkMedico int,
primary key (idConsulta, fkPaciente, fkMedico),
dtConsulta datetime,
valor decimal (5,2),
foreign key (fkPaciente) references paciente(idPaciente),
foreign key (fkMedico) references medico(idMedico)
);

INSERT INTO consulta VALUES
(1, 100, 1, '2024-05-06 14:00:00', 1.99),
(1, 100, 2, '2024-05-06 15:00:00', 2.99),
(1, 101, 1, '2024-05-06 15:00:00', 1.17),
(1, 101, 2, '2024-05-06 16:00:00', 1.97),
(2, 100, 1, '2024-05-16 14:00:00', 0);

-- da o join em consulta pq nao pode ir direto no medico ja que eles nao se ligam, cada um se liga na consulta
SELECT * FROM paciente join consulta
on idPaciente = fkPaciente
join medico
on idMedico = fkMedico;

-- funções matematicas 

	-- paciente sem consulta
SELECT * FROM paciente 
	LEFT JOIN consulta 
		on idPaciente = fkPaciente 
    left join medico 
		on idMedico = fkMedico 
        where idConsulta is null
UNION -- UNIFICA OS DOIS SELECT's
SELECT * FROM paciente 
	RIGHT JOIN consulta 
		on idPaciente = fkPaciente 
	right join medico 
		on idMedico = fkMedico 
        where idConsulta is null;

-- COUNT() - contabiliza campos com valor
SELECT COUNT(*) FROM consulta; 
SELECT COUNT(dtConsulta) FROM consulta; 

-- DISTINCT - SÓ APARECE OS VALORES QUE SÃO DIFERENTES

	-- INSERINDO UM VALOR REPETIDO
	INSERT INTO consulta (idConsulta, fkPaciente, fkMedico, valor) VALUES
	(1, 102, 3, 1.99);
    
    SELECT distinct valor FROM consulta;
    SELECT COUNT(DISTINCT valor) FROM consulta; -- contando os valores unicos
    
-- MAX - mostra o valor mais alto
SELECT MAX(valor) FROM consulta;

-- MIN - mostra o valor mais baixo
SELECT MIN(valor) FROM consulta;
SELECT valor FROM consulta ORDER BY valor LIMIT 2;

-- SOMA 
SELECT SUM(valor) FROM consulta;
SELECT SUM(valor) FROM consulta join PACIENTE ON idPaciente = fkPaciente where paciente.nome = 'Braian';

-- GROUP BY
SELECT nome, SUM(valor) FROM paciente 
	JOIN consulta 
		on idPaciente = fkPaciente 
        GROUP BY nome;
        
-- A MEDIA
SELECT AVG(valor) FROM consulta;
SELECT ROUND(AVG(valor), 2) FROM consulta; -- round arredonda
SELECT TRUNCATE(AVG(valor), 2) FROM consulta;

-- SUBQUERY
SELECT nome, max(valor) FROM consulta 
	JOIN paciente 
		on idPaciente = fkPaciente; 
        
SELECT nome FROM consulta join paciente on idPaCIENTE = fkPaciente WHERE valor >= (select avg(valor) from consulta);