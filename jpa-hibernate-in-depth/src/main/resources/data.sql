insert into course(id, name, created_date, updated_date) values(10001, 'Learn AWSin 10 Steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into course(id, name, created_date, updated_date) values(10002, 'Master Python Essentials', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into course(id, name, created_date, updated_date) values(10003, 'Advanced Data Structures and Algorithms', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into course(id, name, created_date, updated_date) values(10004, 'Web Development with React', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into course(id, name, created_date, updated_date) values(10005, 'Machine Learning Fundamentals', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into passport(id,passport_number) values(30001,'R123456');
insert into passport(id,passport_number) values(30002,'J146762');
insert into passport(id,passport_number) values(30003,'A635785');


insert into student (id,name,passport_id) values(20001,'Ranga',30001);
insert into student (id,name,passport_id) values(20002,'John',30002);
insert into student (id,name,passport_id) values(20003,'Alice',30003);






insert into review(id,rating,description,course_id) values(40001,5,'GreatCourse',10001);
insert into review(id,rating,description,course_id) values(40002,4,'Aewsome Course',10001);
insert into review(id,rating,description,course_id) values(40003,3,'Average Course',10003);
