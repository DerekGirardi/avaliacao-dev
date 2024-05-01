CREATE TABLE exame (rowid bigint auto_increment primary key, nm_exame VARCHAR(255));
CREATE TABLE funcionario (rowid bigint auto_increment primary key, nm_funcionario VARCHAR(255));
CREATE TABLE exames_realizados (
    id bigint auto_increment primary key,
    id_funcionario bigint,
    id_exame bigint,
    data VARCHAR(255),
    foreign key (id_funcionario) references funcionario(rowid),
    foreign key (id_exame) references exame(rowid)
);
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue');
INSERT INTO funcionario (nm_funcionario) VALUES ('Carlos Eduardo'), ('Ana Souza'), ('Marcos Oliveira');
INSERT INTO exames_realizados (id_funcionario, id_exame, data) VALUES (1, 1, '26/04/2024'), (2, 3, '27/04/2024'), (3, 4, '28/04/2024');