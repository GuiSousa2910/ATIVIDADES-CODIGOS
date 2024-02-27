use sprint1;

create table filme(
idFilme int primary key,
titulo varchar(50),
genero varchar(40),
diretor varchar(40));

insert filme values
(1, 'O Enigma das Sombras', 'Suspense', 'Mariana Santos'),
(2, 'Além do Infinito', 'Ficção Científica', 'Pedro Silva'),
(3, 'A Chave do Destino', 'Drama', 'Isabela Oliveira'),
(4, 'O Segredo das Estrelas', 'Aventura', 'Ricardo Pereira'),
(5, 'Entre Dois Mundos', 'Fantasia', 'Camila Martins'),
(6, 'O Jogo da Morte', 'Ação', 'Lucas Almeida'),
(7, 'A Última Fronteira', 'Ficção Científica', 'Amanda Costa'),
(8, 'Caminhos Cruzados', 'Romance', 'Carlos Oliveira');

-- • Exibir todos os dados da tabela.
select * from filme;

-- • Adicionar o campo protagonista do tipo varchar(50) na tabela;
ALTER TABLE filme ADD COLUMN protagonista varchar(50);

-- • Atualizar o campo protagonista de todas os filmes inseridos;
UPDATE filme SET protagonista = 'Woody' where idFilme = 1;
UPDATE filme SET protagonista = 'Anny' where idFilme = 2;
UPDATE filme SET protagonista = 'Franky' where idFilme = 3;
UPDATE filme SET protagonista = 'Fred' where idFilme = 4;
UPDATE filme SET protagonista = 'Rafael' where idFilme = 5;
UPDATE filme SET protagonista = 'Pietro' where idFilme = 6;
UPDATE filme SET protagonista = 'Zeus' where idFilme = 7;
UPDATE filme SET protagonista = 'Eduard' where idFilme = 8;

-- • Modificar o campo diretor do tamanho 40 para o tamanho 150;
ALTER TABLE filme MODIFY COLUMN diretor varchar(150);

-- • Atualizar o diretor do filme com id=5;
UPDATE filme SET diretor = 'Guilherme Sousa' where idFilme = 5;

-- • Atualizar o diretor dos filmes com id=2 e com o id=7;
UPDATE filme SET diretor = 'Fernanda' where idFilme in (2,7);

-- • Atualizar o título do filme com o id=6;
UPDATE filme SET titulo = 'Vivo Morto' where idFilme = 6;

-- • Excluir o filme com o id=3;
DELETE FROM filme WHERE idFilme = 3;

-- • Exibir os filmes em que o gênero é diferente de drama;
select * from filme where genero != 'Drama';

-- • Exibir os dados dos filmes que o gênero é igual ‘suspense’;
select * from filme where genero = 'Suspense';

-- Descrever os campos da tabela mostrando a atualização do campo protagonista e diretor;
describe filme;

-- • Limpar os dados da tabela; 
truncate table filme;


