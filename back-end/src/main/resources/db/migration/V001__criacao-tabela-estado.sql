create table estado
(
    id          bigint       not null auto_increment,
    nome        varchar(120) not null,
    sigla       varchar(2)   not null,
    data_criacao date,
    data_atualizacao date,


    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8;