--This is for Q1
select cid, cname
from Courses;

-- This is for Q2
select sname
from Students
where major = 'cs';

-- This is for Q3
select sname
from Students, Professors, enroll
where Professors.pname = 'Alberto Mendelzon'
and Professors.pid = enroll.pid
and Students.ssid = enroll.ssid;

-- This is for Q4
select sname, grade
from Students, enroll
where cid = '500'
and Students.ssid = enroll.ssid;