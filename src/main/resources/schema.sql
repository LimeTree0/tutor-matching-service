drop table if exists test CASCADE;
create table test
(
    id bigint generated by default as identity,
    name varchar(30),
    primary key (id)
);

drop table if exists users CASCADE;
create table users
(
    userid char(50) not null primary key,
    region_id integer not null,
    userpw char(50) not null,
    gender char(1),
    age integer,
    username char(50),
    profile_image char(100),
    phoneNumber char(20),
    signup_date DATE
);

drop table if exists student CASCADE;
create table student
(
    studentid integer not null auto_increment primary key,
    userid char(50) not null,
    region_id integer not null,
    range char(50),
    yail date,
    time TIME,
    category char(50),
    class char(50),
    academic char(50),
    foreign key (userid) references users(userid)
);

drop table if exists teacher CASCADE;
create table teacher
(
    teacherid integer not null auto_increment primary key,
    userid char(50) not null,
    region_id integer not null,
    range char(50),
    yail date,
    time TIME,
    comment char(100),
    category char(50),
    class char(50),
    academic char(50),
    foreign key (userid) references users(userid)
);