USE sprint2;

create table musica(
idMusica int primary key,
titulo varchar(40),
artista varchar(40),
genero varchar(40)
);

insert into musica values
    (1, 'Bohemian Rhapsody', 'Queen', 'Rock'),
    (2, 'Shape of You', 'Ed Sheeran', 'Pop'),
    (3, 'Smells Like Teen Spirit', 'Nirvana', 'Grunge'),
    (4, 'Stairway to Heaven', 'Led Zeppelin', 'Rock'),
    (5, 'Hotel California', 'Eagles', 'Rock'),
    (6, 'Billie Jean', 'Michael Jackson', 'Pop'),
    (7, 'Hey Jude', 'The Beatles', 'Rock');
    
create table album(
idAlbum int primary key,
nome varchar(40),
tipo char(7),
dtLancamento date
);

insert into album values
    (1, 'The Dark Side of the Moon', 'Estúdio', '1973-03-01'),
    (2, 'Thriller', 'Estúdio', '1982-11-30'),
    (3, 'Back in Black', 'Estúdio', '1980-07-25'),
    (4, 'Abbey Road', 'Estúdio', '1969-09-26');
    
select * from musica;
select * from album;

ALTER TABLE musica ADD COLUMN idMusicaAlbum int;
ALTER TABLE musica ADD constraint fkMusicaAlbum foreign key (idMusicaAlbum) references album(idAlbum);

UPDATE musica set idMusicaAlbum = 1 where idMusica = 1;
UPDATE musica set idMusicaAlbum = 2 where idMusica = 2;
UPDATE musica set idMusicaAlbum = 3 where idMusica = 3;
UPDATE musica set idMusicaAlbum = 4 where idMusica = 4;
UPDATE musica set idMusicaAlbum = 3 where idMusica = 5;
UPDATE musica set idMusicaAlbum = 2 where idMusica = 6;

select * from musica join album 
	on idAlbum = idMusicaAlbum;
    
select musica.titulo, album.nome from musica join album on idAlbum = idMusicaAlbum;

select musica.titulo, musica.artista, musica.genero,album.nome from musica join album on idAlbum = idMusicaAlbum where album.tipo = 'Estudio';