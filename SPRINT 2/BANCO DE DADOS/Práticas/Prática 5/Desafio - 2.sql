use sprint2;

create table carro (
idCarro int primary key auto_increment,
nome varchar(45),
preco int,
ano int
);

insert into carro values 
(default, 'Gol Bolinha', 10000, 2000),
(default, 'Ferrari', 1500000, 2023),
(default, 'Palio', 20000, 2005);

create table motor(
idMotor int primary key auto_increment,
preco int,
peso int,
marca varchar(45),
fkCarro int,
constraint fkMotorCarro foreign key (fkCarro) references carro(idCarro));

insert into motor values 
(default, 1500, 34, 'Gol', 1),
(default, 500000, 20, 'Ferrari', 2),
(default, 2400, 24, 'Volks', 3);

select * from motor join carro on fkCarro = idCarro;