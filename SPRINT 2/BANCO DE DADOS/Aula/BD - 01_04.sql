use sprint2;

create table pessoa(
idPessoa int primary key auto_increment,
nome varchar(45),
dtNasc date,
fkMae int,
constraint fkFilhoMae foreign key (fkMae) references pessoa(Idpessoa));

INSERT INTO pessoa (nome, dtNasc) values
('Vivian', '1983-10-13'),
('Fernanda', '1980-01-11'),
('Guilherme', '2005-10-29');

select * from pessoa;

UPDATE pessoa SET fkMae = 2 where idPessoa = 1;

ALTER TABLE pessoa ADD COLUMN fkPai int, 
	ADD CONSTRAINT fkFilhoPai foreign key (fkPai) references pessoa(idPessoa);

UPDATE pessoa SET fkPai = 3 where idPessoa = 1;

select filho.nome as nomeFilho, 
		pai.nome as nomePai,
		mae.nome as nomeMae
			from pessoa as filho join pessoa as pai on filho.fkPai = pai.idPessoa
			join pessoa as mae on filho.fkMae = mae.idPessoa;
            
insert into pessoa (nome) values 
('Alfredo');

UPDATE pessoa SET fkpai = 4 where idPessoa = 2;

select * from pessoa;

select filho.nome as Filho,
	pai.nome as Pai,
    mae.nome as Mae,
    avo.nome as Avo
		from pessoa as filho
			join pessoa as pai
			on filho.fkPai = pai.idPessoa
            JOIN pessoa as mae
            on filho.fkMae = mae.idPessoa
            JOIN pessoa as avo
            on mae.fkPai = avo.idPessoa;