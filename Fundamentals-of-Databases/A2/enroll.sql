create table Professors(
    pid varchar(50) primary key,
    pname varchar(50) not null,
    dept varchar(50) not null
);

create table Students(
    ssid varchar(50) primary key,
    sname varchar(50) not null,
    major varchar(50) not null
);

create table Courses(
    cid integer primary key ,
    cname varchar(50) not null,
    size integer not null
);

create table enroll(
    pid varchar(50),
    ssid varchar(50),
    cid integer,
    grade varchar(50),
    primary key (pid, ssid, cid),
    foreign key (pid) references Professors(pid),
    foreign key (ssid) references Students(ssid),
    foreign key (cid) references Courses(cid)
);