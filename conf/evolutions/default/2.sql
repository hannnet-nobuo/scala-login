# --- Sample dataset

# --- !Ups

insert into user (email,password) values (  'test1@example.com','test');
insert into user (email,password) values (  'test2@example.com','test');
insert into user (email,password) values (  'test3@example.com','test');

# --- !Downs

delete from user;
