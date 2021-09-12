insert into Professors values ('am175', 'Alberto Mendelzon', 'IT');
insert into Professors values ('gw14', 'Geraint Walker', 'CHEM');
insert into Professors values ('ms251', 'Martine Sharpe', 'CS');
insert into Professors values ('bs342', 'Bertie Strong', 'BIO');
insert into Professors values ('mm34324', 'Martyna Mcneill', 'SE');
insert into Professors values ('ks344', 'Kylan Silva', 'SE');

insert into Students values ('nn374', 'Nataniel Newton', 'cs');
insert into Students values ('rr765', 'Robin Roy', 'se');
insert into Students values ('sf4564', 'Savannah Farrow', 'cs');
insert into Students values ('kc735', 'Kya Camacho', 'cs');
insert into Students values ('sg153', 'Saima Gregory', 'chem');
insert into Students values ('da43535', 'Darragh Avalos', 'bio');

insert into Courses values ('500', 'Fundamentals of Databases', '20');
insert into Courses values ('277', 'Algorithms and Analysis', '25');
insert into Courses values ('360', 'Programming Language Concepts', '26');
insert into Courses values ('380', 'Artificial Intelligence', '20');
insert into Courses values ('383', 'Machine Learning', '26');
insert into Courses values ('338', 'Graphical User Interfaces', '21');

insert into enroll values ('ms251', 'nn374', '500', '93');
insert into enroll values ('am175', 'kc735', '277', '98');
insert into enroll values ('gw14', 'sg153', '338', '88');
insert into enroll values ('ms251', 'sf4564', '500', '89');
insert into enroll values ('am175', 'nn374', '383', '96');
insert into enroll values ('ms251', 'kc735', '500', '91');