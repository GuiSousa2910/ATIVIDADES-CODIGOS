use sprint1;
-- Guilherme de Sousa Agostinho / João Kevin Formiga / Samuel Paz

create table condominio(
idCondominio int primary key auto_increment, -- id do condominio
tipoCon varchar(20),
constraint chkTipoCon check (tipoCon in ('Casa', 'Apartamento')),
nomeSindico varchar(30),
valorCondominio decimal(7,2),
residenciasLivres int default(0),
qntResidencias int);

insert into condominio values
(null, 'Casa', 'José', 550.44, default, 100),
(null, 'Apartamento', 'Cintia', 800.50, 10, 900),
(null, 'Casa', 'João Kevin', 143.00, default, 20),
(null, 'Casa', 'Guilherme', 499.99, default, 400),
(null, 'Apartamento', 'Samuel', 100.00, default, 10),
(null, 'Apartamento', 'Ana', 670.00, 180, 1000),
(null, 'Casa', 'Ronaldo', 500.80, 30, 400),
(null, 'Apartamento', 'Cleber', 3000.00, 200, 3200);

select * from condominio;

-- No condominio com id 1 saiu 10 pessoas
UPDATE condominio SET residenciasLivres = 10 where idCondominio = 1;
select * from condominio where idCondominio = 1;

-- Dessas 10 pessoas 6 foram para o mesmo condominio onde o id é igual a 6
UPDATE condominio SET residenciasLivres = 174 where idCondominio = 6;
select * from condominio where idCondominio = 6;

-- Infelizmente a Dona Ana faleceu e sera substituida
UPDATE condominio SET nomeSindico = 'Vivian' where idCondominio = 6;
select * from condominio where idCondominio = 6;

-- Em uma reuniao entre condominios foi decidido mudar o nome da coluna 'nomeSindico' apenas para 'sindico'
ALTER TABLE condominio RENAME COLUMN nomeSindico to sindico;
describe condominio;

-- O condominio com id 4 teve uma mudança em seu preço de condominio
UPDATE condominio SET valorCondominio = 600 where idCondominio = 4;
select * from condominio where idCondominio = 4;

-- Em uma demolição em massa algumas casas que estavam vazias foram destruidas
UPDATE condominio SET qntResidencias = 3100 where idCondominio = 8;
UPDATE condominio SET residenciasLivres = 100 where idCondominio = 8;
select * from condominio where idCondominio = 8;

-- Um invasor de algum outro condominio invadiu o sistema de banco de dados desses condominios e deletou tudo
DROP TABLE condominio;

-- -----------------------------------------------------------------------------------------------------------------------------------------------
create table endereco(
idEndereco int primary key auto_increment,
CEP varchar(8),
rua varchar(80),
numero int(5),
bairro varchar(50),
complemento varchar(80) default('nao tem'),
país varchar(60),
estado varchar(40),
cidade varchar(80));

-- Cadastro endereço sptech
insert into endereco values
(default, '02815000', 'rua haddock lobo', '550', 'paulista', default, 'Brasil', 'SP', 'São Paulo');

-- Número foi alterado para númeroRua para mais facilidade de visuaização
alter table endereco rename column numero to numeroRua;
alter table endereco modify column numeroRua int(6);


-- Número da sptech mudou para 500
update endereco set numeroRua = '500'
	where idEndereco = 1;

-- Especificaram como Prédio
update endereco set complemento = 'Prédio'
	where idEndereco = 1;

-- Cep da sptech foi alterada para uma melhor organização
update endereco set CEP = '01414001'
	where idEndereco = 1;

-- Bairro alterado para o carnaval
update endereco set bairro = 'paulisto'
	where idEndereco = 1;

-- sptech não gostou das mudanças e vendeu o prédio
update endereco set complemento = 'Prédio comercial'
	where idEndereco = 1;

-- sptech revoltada com tudo isso decidiu apagar tudo
DROP TABLE endereco;

-- -------------------------------------------------------------------------------------------------------------
​
create table carrinhoDeCompra(
idCarrinho int primary key,
qntItens int default(0),
nomeProdutos varchar(80),
tipoPagamento varchar(50),
constraint chkPagamento check (tipoPagamento in ('PIX', 'Débito', 'Crédito', 'Boleto', 'Dinheiro')),
txEntrega decimal(5, 2),
prazo datetime,
totalValor decimal(10,2));

Describe table carrinhoDeCompra;
alter table carrinhoDeCompra modify column IdCarrinho int auto_increment;

insert into carrinhoDeCompra (IdCarrinho, qntItens, nomeProdutos, tipoPagamento, txEntrega, prazo, totalValor) values
(null, 1, 'Camisa Do Corinthians 23/24', 'Crédito', 13.00, '2024-03-09', 240.00);

insert into carrinhoDeCompra (IdCarrinho, qntItens, nomeProdutos, tipoPagamento, txEntrega, prazo, totalValor) values
(null, 2, 'Kit razer mouse/teclado', 'Débito', 20.00, '2024-04-01', 300.00),
(null, 1, 'Garrafa de Água', 'Pix', 31.00, '2024-07-10', 30.00),
(null, 5, 'Kt canetas fabercastell', 'Dinheiro', 0, '2024-03-23', 18.00);

select * from carrinhoDeCompra;


-- mudou o prazo de entrega do Kit Razer mouse/teclado, acabou adiantando o prazo de entrega
update carrinhoDeCompra set prazo = '2024-03-27 15:30:00' where IdCarrinho =3;

select * from carrinhoDeCompra;

-- mas acabou aumentando a txEntrega para 
update carrinhoDeCompra set txEntrega = 25.00 where IdCarrinho =3;

-- acabou que o pedido da camisa do corinthians foi cancelado, por falta de limite no cartão

delete from carrinhoDeCompra where IdCarrinho =2;

-- acabei comprando outro produto
insert into carrinhoDeCompra (IdCarrinho, qntItens, nomeProdutos, tipoPagamento, txEntrega, prazo, totalValor) values
(null, 1, 'caderno', 'Débito', 7.00, '2024-04-12', 15.00);

select * from carrinhoDeCompra;

-- os pedidos chegaram no seu devido prazo
drop table carrinhoDeCompra;
