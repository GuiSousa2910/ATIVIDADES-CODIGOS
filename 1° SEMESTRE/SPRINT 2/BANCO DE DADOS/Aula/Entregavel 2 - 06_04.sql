USE sprint2;

CREATE TABLE organizadores (
    idOrganizacao INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    experiencia char(10),
    constraint chkExp check(experiencia in ('novato', 'experiente'))
);
CREATE TABLE campanhas (
    idCampanha INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    fkOrganizacao INT,
    FOREIGN KEY (fkOrganizacao) REFERENCES organizadores(idOrganizacao)
);

INSERT INTO organizadores (nome, experiencia) VALUES 
('Giuliano', 'experiente'), 
('Guilherme', 'novato'),
('Marcia', 'experiente'), 
('Gabriela', 'novato');

INSERT INTO campanhas (nome, fkOrganizacao) VALUES 
('Telemarketing', 1), 
('Atacadista', 2), 
('Perfumaria', 3),
('Politica', 4);

SELECT * FROM organizadores;
SELECT * FROM campanhas;

SELECT organizadores.*, campanhas.nome
FROM organizadores 
JOIN campanhas ON organizadores.idOrganizacao = campanhas.fkOrganizacao;

SELECT organizadores.*, campanhas.nome FROM organizadores
	JOIN campanhas 
    ON organizadores.idOrganizacao = campanhas.fkOrganizacao 
		WHERE organizadores.nome = 'Giuliano';

SELECT novato.*, experiente.nome AS orientador_nome 
	FROM organizadores AS novato 
	JOIN organizadores AS experiente 
		ON novato.experiencia = 'novato' AND experiente.experiencia = 'experiente';
        
SELECT novato.*, experiente.nome AS orientador_nome 
	FROM organizadores AS novato 
	JOIN organizadores AS experiente 
		ON novato.experiencia = 'novato' AND experiente.experiencia = 'experiente' 
		WHERE experiente.nome = 'Giuliano';

SELECT novato.*, campanha.nome AS campanha_nome, experiente.nome AS orientador_nome 
	FROM organizadores AS novato 
	JOIN organizadores AS experiente 
		ON novato.experiencia = 'novato' AND experiente.experiencia = 'experiente' 
	JOIN campanhas AS campanha 
		ON novato.idOrganizacao = campanha.fkOrganizacao;

SELECT novato.*, campanha.nome AS campanha_nome, experiente.nome AS orientador_nome 
	FROM organizadores AS novato 
	JOIN organizadores AS experiente 
		ON novato.experiencia = 'novato' AND experiente.experiencia = 'experiente' 
	JOIN campanhas AS campanha 
		ON novato.idOrganizacao = campanha.fkOrganizacao 
			WHERE novato.nome = 'Guilherme';