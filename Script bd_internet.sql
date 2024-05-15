create database bd_internet character set utf8 collate utf8_general_ci;
use bd_internet;

create table estudiantes(id int(11) auto_increment primary key, nombres varchar(50), apellidos varchar(50), seminario varchar(100), confimado varchar(5), fecha date);


