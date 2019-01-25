CREATE DATABASE PROJECTMANAGER;

drop table tasks;
drop table parent_tasks;
drop table projects;
drop table users;

CREATE TABLE users (
	employee_id VARCHAR(6) NOT NULL,
	first_name VARCHAR(50) NULL DEFAULT NULL,
	last_name VARCHAR(50) NULL DEFAULT NULL,
	status VARCHAR(1) NULL DEFAULT NULL,
	PRIMARY KEY (employee_id)
);

CREATE TABLE projects (
	project_id BIGINT(10) NOT NULL AUTO_INCREMENT,
	project_name VARCHAR(50) NULL DEFAULT NULL,
	start_date VARCHAR(10) NULL DEFAULT NULL,
	end_date VARCHAR(10) NULL DEFAULT NULL,
	priority VARCHAR(2) NULL DEFAULT NULL,
	status VARCHAR(15) NULL DEFAULT NULL,
	manager_id VARCHAR(6) NOT NULL,
	PRIMARY KEY (project_id),
	CONSTRAINT FK_PROJECTS_MANAGER_ID FOREIGN KEY (manager_id) REFERENCES users (employee_id)
);

CREATE TABLE parent_tasks (
	parent_task_id BIGINT(10) NOT NULL AUTO_INCREMENT,
	parent_task_name VARCHAR(50) NULL DEFAULT NULL,
	project_id BIGINT(10) NOT NULL,
	PRIMARY KEY (parent_task_id),
	CONSTRAINT FK_PARENT_TASKS FOREIGN KEY (project_id) REFERENCES projects (project_id)
);

CREATE TABLE tasks (
	task_id BIGINT(10) NOT NULL AUTO_INCREMENT,
	task_name VARCHAR(50) NULL DEFAULT NULL,
	parent_task_id BIGINT(10) NULL DEFAULT NULL,
	employee_id VARCHAR(6) NOT NULL,
	start_date VARCHAR(10) NULL DEFAULT NULL,
	end_date VARCHAR(10) NULL DEFAULT NULL,
	priority VARCHAR(2) NULL DEFAULT NULL,
	status VARCHAR(1) NULL DEFAULT NULL,
	project_id BIGINT(10) NOT NULL,
	PRIMARY KEY (task_id),
	CONSTRAINT FK_TASKS_PT FOREIGN KEY (parent_task_id) REFERENCES parent_tasks (parent_task_id),
	CONSTRAINT FK_TASKS_EI FOREIGN KEY (employee_id) REFERENCES users (employee_id),
	CONSTRAINT FK_TASKS_PI FOREIGN KEY (project_id) REFERENCES projects (project_id)
);

insert into users (employee_id, first_name, last_name, status) values('287431','Sudip','Chatterjee','A');
insert into users (employee_id, first_name, last_name, status) values('463657','Kousik','Dey','A');
insert into users (employee_id, first_name, last_name, status) values('397538','Avijit','Sharma','A');
insert into users (employee_id, first_name, last_name, status) values('307467','Upasak','Ganguly','A');
insert into users (employee_id, first_name, last_name, status) values('313255','Saikat','Das','A');
insert into users (employee_id, first_name, last_name, status) values('291812','Deep','Pradhan','A');
insert into users (employee_id, first_name, last_name, status) values('362480','Amit','Roy','A');
insert into users (employee_id, first_name, last_name, status) values('474325','Ashis','Karmakar','A');
insert into users (employee_id, first_name, last_name, status) values('485083','Sangeeta','Das','A');
insert into users (employee_id, first_name, last_name, status) values('456206','Nil','Roy','A');

insert into projects (project_name, start_date, end_date, priority, status, manager_id) values('ITFT','01/20/2019','01/30/2019','15','In-Progress','397538');
insert into projects (project_name, start_date, end_date, priority, status, manager_id) values('Boot Enhancement','01/21/2018','01/29/2018','17','In-Progress','287431');
insert into projects (project_name, start_date, end_date, priority, status, manager_id) values('POMS','01/19/2018','01/29/2018','20','In-Progress','463657');
insert into projects (project_name, start_date, end_date, priority, status, manager_id) values('Beauti Enhancement','01/22/2018','01/27/2018','1','In-Progress','313255');
insert into projects (project_name, start_date, end_date, priority, status, manager_id) values('Spring-Batch','01/23/2018','01/25/2018','9','In-Progress','456206');

insert into parent_tasks (parent_task_name, project_id) values('pt create screens',1);
insert into parent_tasks (parent_task_name, project_id) values('pt design database scripts',2);
insert into parent_tasks (parent_task_name, project_id) values('pt raise clarifications',3);
insert into parent_tasks (parent_task_name, project_id) values('pt design swagger',4);
insert into parent_tasks (parent_task_name, project_id) values('pt setup docker',5);
insert into parent_tasks (parent_task_name, project_id) values('pt code the rest end points',4);
insert into parent_tasks (parent_task_name, project_id) values('pt code review',3);
insert into parent_tasks (parent_task_name, project_id) values('pt create test cases',2);
insert into parent_tasks (parent_task_name, project_id) values('pt create jmeter setup',1);
insert into parent_tasks (parent_task_name, project_id) values('pt dry run the code',5);

insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('generate report of tasks',1,'11/01/2018','11/10/2018','15','A','474325',1);
insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('complete the go perform',2,'11/11/2018','11/12/2018','30','A','456206',2);
insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('sent artifacts email',3,'11/11/2018','11/13/2018','1','A','485083',3);
insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('complete coding of jira task assigned',null,'11/15/2018','11/18/2018','0','A','287431',4);
insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('perform unit testing',null,'11/17/2018','11/19/2018','26','A','456206',1);
insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('fill the TDD document on the design change',5,'11/14/2018','11/19/2018','17','A','397538',5);
insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('create db design',4,'11/17/2018','11/19/2018','15','A','463657',2);
insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('create angular project structure',1,'11/11/2018','11/19/2018','16','A','287431',5);
insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('perform code review',2,'11/11/2018','11/19/2018','19','A','397538',3);
insert into tasks (task_name, parent_task_id, start_date, end_date, priority, status, employee_id, project_id) values('help peer resource on angular',null,'11/12/2018','11/19/2018','1','A','463657',3);

select * from users;
select * from projects;
select * from parent_tasks;
select * from tasks;


update tasks set status = 'A';