# --- First database schema

# --- !Ups


create table user (
  email                        varchar(255) not null,
  password                      varchar(255) not null,
  constraint pk_company primary key (email))
;


# --- !Downs


drop table if exists user;


