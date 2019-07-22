create database mybatis_learning;

use mybatis_learning;

create table user(id int primary key auto_increment, name varchar(50), age int);

insert into user(name,age) values("test1",12),("test2",13);