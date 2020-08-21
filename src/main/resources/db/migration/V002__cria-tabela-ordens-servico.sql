create table if not exists ordens_servico(
    id serial not null ,
    cliente_id bigint not null ,
    descricao text not null ,
    preco decimal(10,2) not null ,
    status varchar(20) not null ,
    data_abertura timestamp not null,
    data_finalizacao timestamp,
    primary key (id)
);

alter table ordens_servico add constraint fk_ordem_servico_cliente foreign key (cliente_id) references clientes (id);