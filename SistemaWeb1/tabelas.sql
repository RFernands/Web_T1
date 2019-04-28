create table Teatro (
email varchar(256) not null,
senha varchar(24) not null,
CNPJ varchar(25) not null,
nome varchar(256) not null,
cidade varchar(256) not null,
CONSTRAINT Usuario_PK PRIMARY KEY (CNPJ)
);

create table Site (
email varchar(256) not null,
senha varchar(256) not null,
URL varchar(256) not null,
nome varchar(256) not null,
telefone varchar(256) not null,
constraint Site_PK primary key (URL)
);
CREATE TABLE Promocao (
    ID integer not null generated always as identity (start with 1, increment by 1),
    URLdoSite varchar(256) not null, 
    CNPJdoTeatro varchar(25) not null,
    nomePeca varchar(256) not null,
    precoPeca float not null,
    dataPeca varchar(256) not null,
    horario varchar(256) not null,

    constraint Promocao_PK PRIMARY KEY (id),
    constraint Site_FK FOREIGN KEY (URLdoSite) REFERENCES Site(URL) ON DELETE CASCADE,
    constraint Teatro_FK FOREIGN KEY (CNPJdoTeatro) REFERENCES Teatro(CNPJ) ON DELETE CASCADE
);