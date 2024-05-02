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
CREATE TABLE usuario (
	rowid bigint auto_increment primary key,
	nm_usuario VARCHAR(255),
	pw_usuario VARCHAR(255)
);

INSERT INTO usuario (nm_usuario, pw_usuario) VALUES ('admin', 'root');