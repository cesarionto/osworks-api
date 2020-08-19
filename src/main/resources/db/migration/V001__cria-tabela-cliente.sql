create table if not exists clientes (
    id serial not null,
    nome varchar(60) not null,
    email varchar(60) not null,
    telefone varchar(60) not null,
    primary key(id)
)