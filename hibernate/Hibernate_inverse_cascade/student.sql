create table grade(
	gid int primary key,
	gname varchar(20) not null,
	gdesc varchar(50)
);
create table student(
	sid int primary key,
	sname varchar(20) not null,
	sex char(2),
	gid int,
	FOREIGN KEY (gid) REFERENCES grade(gid)
);	
	
