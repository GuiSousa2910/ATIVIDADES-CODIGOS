USE sprint2;

CREATE TABLE motorista (
idMotorista int primary key auto_increment,
nome varchar(45),
cnh char(9),
dtValidade date,
fkMotoristaReserva int,
constraint fkMotoristaMotoristaReserva foreign key (fkMotoristaReserva) references motorista(idMotorista));

INSERT INTO motorista (nome, cnh, dtValidade) VALUES
('Guilherme', '123456789', '2024-12-21'),
('Laise', '987654321', '2024-04-02'),
('Joao Kevin', '123789456', '2030-03-12');

CREATE TABLE carros(
idCarro int primary key auto_increment,
nome varchar(45),
placa char(7),
marca varchar(45));

INSERT INTO carros(nome, placa, marca) VALUES
('Fiat Uno', 'ABC1234', 'Fiat'),
('Toyota Corolla', 'DEF5678', 'Toyota'),
('Chevrolet Onix', 'GHI9012', 'Chevrolet');

ALTER TABLE motorista ADD COLUMN fkCarro int,
	ADD CONSTRAINT fkMotoristaCarro foreign key (fkCarro) references carro(idCarro);
    
UPDATE motorista SET fkMotoristaReserva = 2 where idMotorista = 1;
UPDATE motorista SET fkMotoristaReserva = 3 where idMotorista = 2;
UPDATE motorista SET fkMotoristaReserva = 2 where idMotorista = 3;
UPDATE motorista SET fkCarro = 2 where idMotorista = 2;
UPDATE motorista SET fkCarro = 1 where idMotorista = 1;
UPDATE motorista SET fkCarro = 3 where idMotorista = 3;

select * from motorista join carros on idCarro = fkCarro;

SELECT * FROM carros;

select reserva.nome as nomeMotoReserva, motorista.nome as nomeMotorista
	from motorista as motorista
		join motorista as reserva
			on motorista.fkMotoristaReserva = reserva.idMotorista;