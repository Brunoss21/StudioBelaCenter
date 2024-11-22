CREATE TABLE IF NOT EXISTS atendimento (
    id serial PRIMARY KEY,
    nome varchar(100) NOT NULL,
    telefone varchar(20) NOT NULL,
    servico varchar(100) NOT NULL,
    data date,
    horario TIME
);
