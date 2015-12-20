create database Register;
use Register;
create table Registration(Email_id varchar(350), Username varchar(50), Userpassword varchar(50));
create table Employer(Email_id varchar(350), Emp_name varchar(50), emp_id varchar(50));
select * from Registration;
select * from Employer;
create table JobPost(Post varchar(300), CompanyName varchar(50), Count int);
select * from JobPost;
