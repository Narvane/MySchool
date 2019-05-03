create procedure secretaryAutenticate(VARusername varchar(45), VARpassword varchar(25))
select username, secretaryPassword
from secretary
where username = VARusername and secretaryPassword = VARpassword;

create procedure professorAutenticate(VARusername varchar(45), VARpassword varchar(25))
select username, professorPassword
from professor
where username = VARusername and professorPassword = VARpassword;

create procedure studentAutenticate(VARusername varchar(45), VARpassword varchar(25))
select username, studentPassword
from student
where username = VARusername and studentPassword = VARpassword;

create procedure registerStudent(VARusername varchar(45), VARname varchar(45), VARcpf varchar(11), VARrg varchar(7), VARborndate date, VARpassword varchar(25), VARemail varchar(65))
insert into student(username, studentName, cpf, rg, borndate, studentPassword, email)
values (VARusername, VARname, VARcpf, VARrg, VARborndate, VARpassword, VARemail);

create procedure registerProfessor(VARusername varchar(45), VARname varchar(45), VARcpf varchar(11), VARrg varchar(7), VARborndate date, VARpassword varchar(25), VARsalary int, VARemail varchar(65))
insert into professor(username, professorName, cpf, rg, borndate, professorPassword, salary, email)
values (VARusername, VARname, VARcpf, VARrg, VARborndate, VARpassword, VARsalary, VARemail);

create procedure studentParcialGrades(VARid int)
select studentName, bimesterName, disciplineName, n1, n2, n3, average
from parcial_grades
join student on (parcial_grades.idStudent = student.idStudent)
join bimester on (parcial_grades.idBimester = bimester.idBimester)
join discipline on (parcial_grades.idDiscipline = discipline.idDiscipline)
where student.idStudent = VARid;

create procedure studentSchoolReport(VARid int)
select studentName, serieName, initials, bimesterName, disciplineName, average, yearSchoolReport
from schoolReport
join student on (schoolReport.idStudent = student.idStudent)
join serie on (schoolReport.idSerie = serie.idSerie)
join bimester on (schoolReport.idBimester = bimester.idBimester)
join discipline on (schoolReport.idDiscipline = discipline.idDiscipline)
join class on (serie.idSerie = class.idSerie)
where student.idStudent = VARid;

create procedure studentHistoric(VARid int)
select studentName, serieName, initials, bimesterName, disciplineName, average, yearSchoolReport
from historic
join student on (historic.idStudent = student.idStudent)
join schoolReport on (historic.idSchoolReport = schoolReport.idSchoolReport) 
join serie on (schoolReport.idSerie = serie.idSerie)
join class on (serie.idSerie = class.idClass)
join bimester on (schoolReport.idBimester = bimester.idBimester)
join discipline on (schoolReport.idDiscipline = discipline.idDiscipline)
where student.idStudent = VARid;
;

create procedure studentUpdate(VARid int, VARusername varchar(45), VARname varchar(45), VARcpf varchar(11), VARrg varchar(7), VARborndate date, VARpassword varchar(25), VARemail varchar(65))
update student set username = VARusername, studentName = VARname, cpf = VARcpf, rg = VARrg, borndate = VARborndate, studentPassword = VARpassword, email = VARemail
where student.idStudent = VARid;

create procedure ProfessorUpdate(VARid int, VARusername varchar(45), VARname varchar(45), VARcpf varchar(11), VARrg varchar(7), VARborndate date, VARpassword varchar(25), VARemail varchar(65), VARsalary int)
update professor set username = VARusername, professorName = VARname, cpf = VARcpf, rg = VARrg, borndate = VARborndate, professorPassword = VARpassword, email = VARemail, salary = VARsalary
where professor.idProfessor = VARid;

create procedure studentDelete(VARid int)
delete from student 
where student.idStudent = VARid;

create procedure professorDelete(VARid int)
delete from professor
where professor.idProfessor = VARid;

create procedure studentSearch(VARname varchar(45))
select * from student
where student.studentName = VARname;

create procedure professorSearch(VARname varchar(45))
select * from professor
where professor.professorName = VARname;

create procedure studentPerSerie(VARname varchar(45))
select studentname, cpf, rg, borndate, Student.idstudent  from student 
join student_class on (student.idStudent = student_class.idStudent)
join class on (class.idClass = student_class.idClass)
join series_class on (series_class.idClass = class.idClass)
join serie on (series_class.idSerie = serie.idSerie)
where serie.serieName= VARname;

create procedure studentPerClassroom(VARname varchar(45))
select studentname, cpf, rg, borndate, Student.idstudent from student 
join student_class on (student.idStudent = student_class.idStudent)
join class on (class.idClass = student_class.idClass)
where class.initials = VARname;

create procedure classroomPerSerie(VARname varchar(45))
select initials from class
join series_class on (series_class.idClass = class.idClass)
join serie on (series_class.idSerie = serie.idSerie)
where serie.serieName = VARname;

create view seriesView as
select * from serie;

create view studentView as
select * from student;

create view professorView as
select * from professor;

insert into secretary(secretaryname, username, secretarypassword) values("Gustavo","Bohannon","123");

insert into serie(seriename) values ("1° Serie");
insert into serie(seriename) values ("2° Serie");
insert into serie(seriename) values ("3° Serie");
insert into serie(seriename) values ("4° Serie");
insert into serie(seriename) values ("5° Serie");
insert into serie(seriename) values ("6° Serie");
insert into serie(seriename) values ("7° Serie");
insert into serie(seriename) values ("8° Serie");

insert into class(initials) values("101");
insert into class(initials) values("102");
insert into class(initials) values("103");
insert into class(initials) values("201");
insert into class(initials) values("202");
insert into class(initials) values("203");
insert into class(initials) values("301");
insert into class(initials) values("302");
insert into class(initials) values("303");
insert into class(initials) values("401");
insert into class(initials) values("402");
insert into class(initials) values("403");
insert into class(initials) values("501");
insert into class(initials) values("502");
insert into class(initials) values("503");
insert into class(initials) values("601");
insert into class(initials) values("602");
insert into class(initials) values("603");
insert into class(initials) values("701");
insert into class(initials) values("702");
insert into class(initials) values("703");
insert into class(initials) values("801");
insert into class(initials) values("802");
insert into class(initials) values("803");

insert into series_class(idClass, idSerie) values(1, 1);
insert into series_class(idClass, idSerie) values(2, 1);
insert into series_class(idClass, idSerie) values(3, 1);
insert into series_class(idClass, idSerie) values(4, 2);
insert into series_class(idClass, idSerie) values(5, 2);
insert into series_class(idClass, idSerie) values(6, 2);
insert into series_class(idClass, idSerie) values(7, 3);
insert into series_class(idClass, idSerie) values(8, 3);
insert into series_class(idClass, idSerie) values(9, 3);
insert into series_class(idClass, idSerie) values(10, 4);
insert into series_class(idClass, idSerie) values(11, 4);
insert into series_class(idClass, idSerie) values(12, 4);
insert into series_class(idClass, idSerie) values(13, 5);
insert into series_class(idClass, idSerie) values(14, 5);
insert into series_class(idClass, idSerie) values(15, 5);
insert into series_class(idClass, idSerie) values(16, 6);
insert into series_class(idClass, idSerie) values(17, 6);
insert into series_class(idClass, idSerie) values(18, 6);
insert into series_class(idClass, idSerie) values(19, 7);
insert into series_class(idClass, idSerie) values(20, 7);
insert into series_class(idClass, idSerie) values(21, 7);
insert into series_class(idClass, idSerie) values(22, 8);
insert into series_class(idClass, idSerie) values(23, 8);
insert into series_class(idClass, idSerie) values(24, 8);

insert into student(username, studentname, cpf, rg, borndate, studentpassword, email) values ("Gustavo","Gustavo", "10844870986", "1106448","19990518", "123","Gustavo@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Flavio","Flavio", "10842870986", "2106448","19990518", "123", "Flavio@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Bernando","Bernando", "10844810986", "3106448","19990518", "123", "Bernardo@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Pericles","Pericles", "10344870986", "4106448","19990518", "123", "Pericles@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Henrique","Henrique", "10894870986", "1106441","19990518", "123", "Henrique@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Pablo","Pablo", "10824830986", "1106442","19990518", "123", "Pablo@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Francisco","Francisco", "20844870946", "1106443","19990518", "123", "Francisco@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Gabriel","Gabriel", "10844870980", "1106444","19990518", "123", "Gabriel@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Ananias","Ananias", "10843888986", "1106445","19990518", "123", "Ananias@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Roberto","Roberto", "10844877786", "1106446","19990518", "123", "Roberto@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Jensen","Jensen", "10844866986", "1106447","19990518", "123", "Jensen@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Leandro","Leandro", "10844666666", "1106449","19990518", "123", "Leandro@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Leonardo","Leonardo", "10845550986", "1116148","19990518", "123", "Leonardo@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Mathues","Mathues", "14444840986", "1666448","19990518", "123", "Matheus@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Denise","Denise", "12224870986", "1776448","19990518", "123", "Denise");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Paulo","Paulo", "10845556686", "1886448","19990518", "123", "Paulo@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Pedro","Pedro", "10844456786", "1996448","19990518", "123", "Pedro");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Kilberly","Kilberly", "22244870986", "1006008","19990518", "123", "Kimberly@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Joana","Joana", "23444870986", "144448","19990518", "123", "Joana@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Juliana","Juliana", "12344870986", "2226448","19990518", "123", "Juliana@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Joelma","Joelma", "20444870986", "3336448","19990518", "123", "Joelma@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Hailie","Hailie", "30844870986", "4446448","19990518", "123", "Hailie@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Lzzy","Lzzy", "33344870986", "4242644","19990518", "123", "Lzzy@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Thais","Thais", "22844873986", "1212448","19990518", "123", "Thais@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Norberta","Norberta", "32324870986", "1313448","19990518", "123", "Norberta@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Jhefiffer","Jhefiffer", "33224870986", "1414448","19990518", "123", "Jheniffer@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Natália","Natália", "22222870986", "0000448","19990518", "123", "Natáia@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Giovanna","Giovanna", "33343870986", "111111","19990518", "123", "Giovanna@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Roberta","Roberta", "10844343443", "2222222","19990518", "123", "Roberta@gmail.com");
insert into student(username,studentname, cpf, rg, borndate, studentpassword, email) values ("Gina","Gina", "10555555555", "3333333","19990518", "123", "Gina@gmail.com");

insert into student_class(idClass, idStudent) values(1, 1);
insert into student_class(idClass, idStudent) values(1, 2);
insert into student_class(idClass, idStudent) values(2, 3);
insert into student_class(idClass, idStudent) values(2, 4);
insert into student_class(idClass, idStudent) values(3, 5);
insert into student_class(idClass, idStudent) values(3, 6);
insert into student_class(idClass, idStudent) values(4, 7);
insert into student_class(idClass, idStudent) values(5, 8);
insert into student_class(idClass, idStudent) values(6, 9);
insert into student_class(idClass, idStudent) values(7, 10);
insert into student_class(idClass, idStudent) values(8, 11);
insert into student_class(idClass, idStudent) values(9, 12);
insert into student_class(idClass, idStudent) values(9, 13);
insert into student_class(idClass, idStudent) values(10, 14);
insert into student_class(idClass, idStudent) values(10, 15);
insert into student_class(idClass, idStudent) values(11, 16);
insert into student_class(idClass, idStudent) values(11, 17);
insert into student_class(idClass, idStudent) values(12, 18);
insert into student_class(idClass, idStudent) values(13, 19);
insert into student_class(idClass, idStudent) values(14, 20);
insert into student_class(idClass, idStudent) values(15, 21);
insert into student_class(idClass, idStudent) values(16, 22);
insert into student_class(idClass, idStudent) values(17, 23);
insert into student_class(idClass, idStudent) values(18, 24);
insert into student_class(idClass, idStudent) values(19, 25);
insert into student_class(idClass, idStudent) values(20, 26);
insert into student_class(idClass, idStudent) values(21, 27);
insert into student_class(idClass, idStudent) values(22, 28);
insert into student_class(idClass, idStudent) values(23, 29);
insert into student_class(idClass, idStudent) values(24, 30);



