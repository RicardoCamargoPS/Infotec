-- CRIAÇÃO DO BANCO USUARIOS
create database db_assiInfo;

-- DEFENINDO O USO PARA O BANCO DE DADOS db_assiInfo;
use db_assiInfo;

-- CRIA UMA TABELA PARA USUARIOS
create table tbUsuarios(
id int primary key, 
usuario varchar(30) not null,
fone varchar(15),
login varchar(15) not null unique,
senha varchar(15) not null
);

-- OS COMANDOS ABIXO AUXILIAM NA CRIAÇÃO, OPERAÇÕES DO GRUD, ENTRE OUTROS

-- describe "table"; -- USADO PARA DESCRERVER (MOSTRAR) A TABELA 

-- INSERÇAO DE DADOS NA TABELA
-- insert into "tabela"("TODOS OS CAMPOS DA TABELAS SEPARADOS POR,") values("valores que cada campo da tabela ira receber por , ");

-- LEITRURA DOS DADOS DA TABELA
-- select * from "tabela";

-- MUDA O DADO DA TABELA
-- update "tabela" set "canpo a ser modificado" where "de quem sera modificado geralmente identificado usando do campo da tabela ID "

-- DELETA UM REGISTRO DE UMA TABELA
-- delete from "tabela" where  "quem sera deletado geralmente identificado usando do campo da tabela ID "

-- CRIANDO A TABELA CLIENTES

create table tbClientes(

id int primary key auto_increment,
nome varchar(30) not null,
fone varchar(20) not null,
cep int not null,
cidade varchar(30) not null,
estado varchar(2) not null,
rua varchar(30) not null,
nun_residencia int not null,
enail varchar(50)
);

create table tbOS(
idOS int primary key auto_increment,
data_os timestamp default current_timestamp,
equipamento varchar(150) not null,
posivel_defeito varchar(150) not null,
servico varchar(150),
orcamento decimal(10,2),
tecnico varchar(30),
valor_conserto decimal(10,2),
idCli int not null,
foreign key(idCli) references tbClientes(id)
);

-- describe tbClientes;

-- INSERÇAO DE USUARIO PADRAO

insert into tbUsuarios(id, usuario, fone, login, senha)
values (1, "ADMIN", "null", "ADMIN", "admin");

select * from tbUsuarios;



