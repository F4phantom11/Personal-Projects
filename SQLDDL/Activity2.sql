drop database if exists videogames;
use videogames;
create table activity(id int auto_increment, 
activityName varchar(60), 
hours decimal, 
days varchar(60),months varchar(60),years varchar(60),
primary key(id) )