use sprint3;

create table aluno(
idAluno int primary key auto_increment,
nome varchar(45)
);

INSERT INTO aluno (nome) VALUES
('Huguinho'),
('Zezinho'),
('Luisinho');

CREATE TABLE curso (
idCurso int auto_increment primary key,
nome varchar(45)
);

INSERT INTO curso (nome) VALUES
('Ingles'),
('Espanhol'),
('Italiano'),
('Mandarim');

CREATE TABLE matricula (
idMatricula int,
fkAluno int ,
fkCurso int,
foreign key (fkAluno) references aluno(idAluno),
foreign key (fkCurso) references curso(idCurso),
nota decimal(4,2),
nivel char(2),
primary key (idMatricula, fkAluno, fkCurso)
);

INSERT INTO matricula VALUES
(1,1,1,8.9,'81'),
(1,2,1,3,'81'),
(2,2,2,9,'81'),
(1,3,4,0,'81');

select * from aluno join matricula
on idAluno = fkAluno
join curso
on idCurso = fkCurso;

select * from curso left join matricula on idCurso = fkCurso where idMatricula is null;

INSERT INTO matricula VALUES
(2,1,4,3,'A2');

select * from matricula;

select distinct nota from matricula;

SELECT nivel, nome, sum(nota) from matricula
join curso on idCurso = fkCurso
group by nivel, nome;

SELECT nivel, nome, round(avg(nota), 2) from matricula
	join curso on idCurso = fkCurso
    group by nivel, nome;
    
SELECT nome, case when nota < 6 then 'REPROVADO' else 'APROVADO'end as 'Status' from aluno join matricula on idAluno = fkAluno;

SELECT nome , nota FROM aluno join matricula on idAluno = fkAluno where nota = (SELECT min(nota) FROM matricula);
SELECT * from aluno join matricula on idAluno = fkAluno;