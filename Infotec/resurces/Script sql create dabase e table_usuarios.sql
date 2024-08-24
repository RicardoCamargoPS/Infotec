create database dbinfotec;
use dbinfotec;

create table tbusuarios(
iduser int primary key,
usuario varchar(50) not null,
fone varchar(15),
login varchar(15) not null unique,
senha varchar(15) not null
);

describe tbusuarios;
insert into tbusuarios(iduser,usuario,login,senha)
values(1,'admin','admin','123456');

select * from tbusuarios;

create table tbclientes(
iduser int primary key auto_increment,
nome varchar(50) not null,
fone varchar(15),
cep int,
cidade varchar(20),
estado varchar(2),
rua varchar(30),
nun_residencia int,
email varchar(40)
);

describe tbclientes;
alter table tbclientes rename column iduser to idcli;

create table tbos(
os int primary key auto_increment,
data_os timestamp default current_timestamp,
equipamento varchar(30),
defeito varchar(150),
servico varchar(150),
tecnico varchar(30),
valor decimal(10,2),
idcli int not null,
foreign key(idcli) references tbclientes(idcli)
);

describe tbos;
