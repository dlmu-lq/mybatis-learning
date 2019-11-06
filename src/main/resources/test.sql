create database mybatis_learning;

use mybatis_learning;

create table user(id int primary key auto_increment, name varchar(50), age int, birth datetime);

insert into user(name,age,birth) values("test1",12,"2005-10-16"),("test2",13,"2005-10-16");

create table user_favorites(id int primary key auto_increment, user_key int, content varchar(100),
    createTime datetime, operTime datetime, useFlg tinyint);

insert into user_favorites(user_key, content, create_time, oper_time, use_flg)
  values(1,"programming",now(),now(),1),
  (1,"communicating",now(),now(),1),
  (2,"programming",now(),now(),1),
  (2,"communicating",now(),now(),1);

