CREATE DATABASE university;
USE university;

CREATE TABLE STUDENT(
  studentID varchar(10) key,
  firstName varchar(30),
  lastName varchar(30),
  DOB date,
  major varchar(30)
);

CREATE TABLE COURSE(
  courseID varchar(10) key,
  courseDescription varchar(30)
);

CREATE TABLE GRADES(
  courseID varchar(10),
  studentID varchar(30),
  term varchar(10),
  grade varchar(5),
  unique key grades (courseID, studentID, term)
);

INSERT INTO STUDENT VALUES
('a1','aaa','aaa','1991-1-1','CS'),
('b2','bbb','bbb','1992-2-2','IS'),
('c3','ccc','ccc','1993-3-3','IT'),
('d4','ddd','ddd','1994-4-4','CE');


INSERT INTO COURSE VALUES
('CS1','des1'),
('CS2','des2'),
('IS1','des3'),
('IS2','des4'),
('IT1','des5'),
('IT2','des6'),
('CE1','des7'),
('CE2','des8');

INSERT INTO GRADES VALUES
('CS1','a1','WI17','A+'),
('CS2','a1','WI17','A'),
('IS1','b2','WI16','A-'),
('IS2','b2','WI17','A+'),
('IT1','c3','WI16','A'),
('IT2','c3','WI16','A-'),
('CE1','d4','WI16','A+'),
('CE2','d4','WI17','A');