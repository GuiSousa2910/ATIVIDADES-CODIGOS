USE sprint2;

create table notebook(
idNotebook int primary key auto_increment,
preco decimal (6,2),
tamanho int,
peso int);

insert into notebook values
(default, 999.00, 38, 2),
(default, 300.99, 23, 4),
(default, 2000.00, 45, 3);

create table memoria(
idMemoria int primary key auto_increment,
tamanho int,
constraint tamanhochk check (tamanho in(4,8,16,32,64,128)),
tipo char(3),
constraint tipochk check (tipo in ('HD', 'SSD'))
);

insert into memoria values
(default, 8, 'SSD'),
(default, 4, 'HD'),
(default, 32, 'SSD');

alter table memoria ADD COLUMN fkNotebook int;
alter table memoria ADD CONSTRAINT fkMemoriaNotebook foreign key (fkNotebook) references notebook(idNotebook);

select * from memoria;
select * from notebook;

UPDATE memoria SET fkNotebook = 1 where idMemoria = 1;
UPDATE memoria SET fkNotebook = 2 where idMemoria = 2;
UPDATE memoria SET fkNotebook = 3 where idMemoria = 3;

select * from memoria join notebook on idNotebook = fkNotebook;
