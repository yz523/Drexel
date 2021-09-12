-- Q1
select distinct enrolls.course, count(enrolls.student)
from enrolls, likes l1, likes l2
where enrolls.student = l1.student and l1.student = l2.student
and l1.professor = 'Einstein' 
and l2.professor = 'Feynman' 
group by enrolls.course;

-- Q2
select distinct enrolls.course, count(enrolls.student)
from teaches t1, teaches t2, enrolls
where t1.course = enrolls.course
and enrolls.course = t2.course
and t1.professor = 'Einstein' 
and t2.professor = 'Feynman' 
group by enrolls.course;

-- Q3
select distinct enrolls.course, count(enrolls.student)
from teaches, enrolls, likes
where teaches.course = enrolls.course
and enrolls.student = likes.student
and teaches.professor = 'Einstein'
and likes.professor = 'Feynman'
group by enrolls.course;

-- Q4
select distinct enrolls.student
from teaches, enrolls, likes
where teaches.course = enrolls.course
and enrolls.student = likes.student
and teaches.professor = likes.professor;

-- Q5
select distinct enrolls.student
from teaches, enrolls, likes
where teaches.course = enrolls.course
and enrolls.student = likes.student
and teaches.professor = likes.professor
except
select distinct enrolls.student
from teaches, enrolls
where teaches.course = enrolls.course
and (enrolls.student, teaches.professor) not in (select *
												 from likes)
intersect
select distinct enrolls.student
from enrolls, likes
where enrolls.student = likes.student
and (likes.professor, enrolls.course) not in (select * 
										   from teaches);

-- Q6
select distinct enrolls.student
from teaches, enrolls, likes
where teaches.course = enrolls.course
and enrolls.student = likes.student
and teaches.professor = likes.professor
except
select distinct likes.student
from teaches, likes
where teaches.professor = likes.professor
and (likes.student, teaches.course) not in (select *
										from enrolls);

-- Q7
select distinct enrolls.student
from teaches, enrolls
where teaches.course = enrolls.course
and (enrolls.student, teaches.professor) not in (select *
												 from likes);

-- Q8
select distinct enrolls.student
from teaches, enrolls
where teaches.course = enrolls.course
and (enrolls.student, teaches.professor) not in (select *
												 from likes)
except
select distinct likes.student
from teaches, likes
where teaches.professor = likes.professor
and (likes.student, teaches.course) not in (select *
										from enrolls);