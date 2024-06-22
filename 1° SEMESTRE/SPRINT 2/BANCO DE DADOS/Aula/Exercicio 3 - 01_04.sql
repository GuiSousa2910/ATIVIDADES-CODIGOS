USE sprint2;

CREATE TABLE empresa(
idEmpresa int primary key auto_increment,
nome varchar(45),
cnpj char(14),
fkMatriz int,
constraint fkEmpresaMatriz foreign key (fkMatriz) references empresa(idEmpresa));

INSERT INTO empresa(nome, cnpj) VALUES 
('Banco do Brasil', '00000000000191'),
('Itaú Unibanco Holding', '60701190000104'),
('Bradesco', '60746948000112'),
('Banco do Brasil - São paulo', '32746438054112'),
('Itaú Unibanco Holding - Maceio', '60705280221104'),
('Bradesco - Acre', '32200212000191');

CREATE TABLE funcionario(
idFuncionario int primary key auto_increment,
nome varchar(45),
area varchar(45),
constraint chkArea check (area in ('TI', 'RH', 'LIMPEZA')),
salario decimal(10,2),
fkSupervisor int,
constraint fkFuncionarioSupervisor foreign key (fkSupervisor) references funcionario(idFuncionario));

INSERT INTO funcionario(nome, area, salario) VALUES
('Guilherme', 'TI', 50000.00),
('Joao Kevin', 'LIMPEZA', 2000.00),
('Laise', 'RH', 100.00),
('Ana', 'RH', 3400.00),
('Supervisor - Ronaldo', 'TI', 83000.00),
('Supervisora - Rose', 'LIMPEZA', 5000.000),
('Supervisora - Marcela', 'RH', 6000.00);

ALTER TABLE funcionario ADD COLUMN fkEmpresa int, 
	ADD CONSTRAINT fkEmpresaFuncionario foreign key (fkEmpresa) references empresa(idEmpresa);
    
UPDATE empresa SET fkMatriz = 4 where idEmpresa = 1;    
UPDATE empresa SET fkMatriz = 5 where idEmpresa = 2;    
UPDATE empresa SET fkMatriz = 6 where idEmpresa = 3;

select empresa.nome as nomeEmpresa, matriz.nome as nomeMatriz from empresa as empresa
	join empresa as matriz
		on empresa.fkMatriz = matriz.idEmpresa;

UPDATE funcionario SET fkSupervisor = 5 where idFuncionario = 1;
UPDATE funcionario SET fkSupervisor = 6 where idFuncionario = 2;
UPDATE funcionario SET fkSupervisor = 7 where idFuncionario = 3 and 4;

select funcionario.nome as nomeFuncionario, supervisor.nome as nomeSupervisor from funcionario as supervisor
	join funcionario as funcionario
		on funcionario.fkSupervisor = supervisor.idFuncionario;

UPDATE funcionario SET fkEmpresa = 1 where idFuncionario = 1;
UPDATE funcionario SET fkEmpresa = 2 where idFuncionario = 2;
UPDATE funcionario SET fkEmpresa = 3 where idFuncionario = 3;
UPDATE funcionario SET fkEmpresa = 2 where idFuncionario = 4;

select empresa.nome, funcionario.nome, area, salario, cnpj from empresa 
	join funcionario
		on fkEmpresa = idEmpresa;