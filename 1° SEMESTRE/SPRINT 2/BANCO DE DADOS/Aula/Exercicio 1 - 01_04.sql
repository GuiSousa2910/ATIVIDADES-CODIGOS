USE sprint2;

CREATE TABLE pet (
idPet int primary key auto_increment,
nome varchar(45),
pedigree char(3),
constraint chkPedigree check (pedigree in ('Sim', 'Nao')),
raça varchar(45),
fkPai int,
constraint fkPaiFilho foreign key (fkPai) references pet (idPet),
fkMae int,
constraint fkMaeFilho foreign key (fkMae) references pet (idPet));

INSERT INTO pet (nome, pedigree, raça) VALUES
('Woody', 'Sim', 'Golden Retriver'),
('Pipa', 'Nao', 'Bulldog Frances'),
('Jota', 'Sim', 'Shitzu'),
('Max', 'Nao', 'Vira lata');

CREATE TABLE dono(
idDono int primary key auto_increment,
nome varchar(45),
bairro varchar(45),
telefone char(9));

INSERT INTO dono (nome, bairro, telefone) VALUES
('Guilherme', 'Carrão', '941481101'),
('Joao Kevin', 'Capão Redondo', '976900686'),
('Laise', 'Penha', '910990581');

ALTER TABLE pet ADD COLUMN fkDono int, 
	ADD CONSTRAINT fkDonoPet foreign key (fkDono) references dono(idDono);
    
UPDATE pet SET fkPai = 1 where idPet = 4;
UPDATE pet SET fkMae = 1 where idPet = 2;
UPDATE pet SET fkDono = 1 where idPet = 1;
UPDATE pet SET fkDono = 2 where idPet = 2;
UPDATE pet SET fkDono = 2 where idPet = 3;
UPDATE pet SET fkDono = 3 where idPet = 4;

select filho.nome as nomeFilho, pai.nome as nomePai, mae.nome as nomeMae
	from pet as filho 
		join pet as pai
			on filho.idPet = pai.fkPai
		join pet as mae
			on filho.idPet = mae.fkMae;
            
select * from pet join dono on idDono = fkDono;
