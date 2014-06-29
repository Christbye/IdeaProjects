#database
drop database if exists tfm;
create database tfm;
use tfm;
#kind
drop table if exists kind;
create table `kind` (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20),
  type INT
);

insert into kind(name,type) values ('军事新闻',1);
insert into kind(name,type) values ('武器装备',1);
insert into kind(name,type) values ('战役与战争',2);
insert into kind(name,type) values ('科技与神秘',2);

select * from kind;
#album
drop table if exists album;
create table album (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  desc varchar(50),
  image varchar (50),
  kind INT,
  FOREIGN KEY (kind) REFERENCES kind(id)
);

insert into ALBUM values (0,'单曲',null,null,null);

select * from album;
#fm_file
drop table if exists fm_file;
create table fm_file (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  file    VARCHAR(128),
  name    VARCHAR(50) UNIQUE,
  image   VARCHAR(128),
  source  VARCHAR(20),
  kind    INT,
  seconds INT,
  album   INT DEFAULT NULL,
  upload_date TIMESTAMP DEFAULT now(),
  hot     INT,
  FOREIGN KEY (kind) REFERENCES kind (id),
  FOREIGN KEY (album) REFERENCES album (id)
);

select * from fm_file;
