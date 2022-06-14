-- create database java3;
use java3;

-- use two separated tables
create table usertable (
	username varchar(40) not null,
	password varchar(20) not null,
	primary key (username)
);

insert into usertable values
('tony', 'tony'), ('peter', 'peter'),
('hulk', 'hulk'), ('thor', 'thor');

create table userroletable (
	username varchar(40) not null,
	userrole varchar(20) not null,
	primary key (username, userrole)
);

insert into userroletable values
('tony', 'admin'), ('peter', 'admin'),
('hulk', 'guest'), ('thor', 'guest');
