create database todo;

use todo;

create table tbl_todo(
	
	tno int auto_increment primary key,
	title varchar(100) not null,
	dueDate date not null,
	finished tinyint default 0
	
)

insert into tbl_todo(title, dueDate, finished)
	values('Test....', now(), 1),
	('Test....', now(), 1),
	('Test....', now(), 1),
	('Test....', now(), 1),
	('Test....', now(), 1),
	('Test....', now(), 1),
	('Test....', now(), 1),
	('Test....', now(), 1),
	('Test....', now(), 1),
	('Test....', now(), 1);
	
	
select * from tbl_todo;	