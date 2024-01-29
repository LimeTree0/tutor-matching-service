create table if not exists test
(
    id bigint generated by default as identity,
    name varchar(30),
    primary key (id)
);

create table if not exists users
(
    userid varchar(50) not null primary key,
    region_id integer not null unique,
    userpw varchar(100) not null,
    gender char(1),
    age integer,
    username varchar(50),
    profile_image varchar(100),
    phoneNumber varchar(20),
    signup_date DATE
);

create table if not exists student
(
    studentid integer not null auto_increment primary key,
    userid varchar(50) not null,
    region_id integer not null unique,
    range varchar(50),
    yail varchar(50),
    time TIME,
    category varchar(50),
    class varchar(50),
    academic varchar(50),
    foreign key (userid) references users(userid),
    foreign key (region_id) references users(region_id)
);

create table if not exists teacher
(
    teacherid integer not null auto_increment primary key,
    userid varchar(50) not null,
    region_id integer not null,
    yail varchar(50),
    time TIME,
    comment varchar(100),
    category varchar(50),
    class varchar(50),
    academic varchar(50),
    foreign key (userid) references users(userid),
    foreign key (region_id) references users(region_id)
);

create table if not exists region
(
    region_id integer not null auto_increment primary key,
    region_depth1 varchar(50) not null,
    region_depth2 varchar(50) not null,
    region_depth3 varchar(50) not null
);

create table if not exists lesson
(
    classid integer not null auto_increment primary key,
    teacherid integer not null,
    lesson_name varchar(50) not null,
    category varchar(50) not null,
    location varchar(50),
    descriptions varchar(500),
    ftf varchar(1),
    people_number integer,
    price integer,
    foreign key (teacherid) references teacher(teacherid)
);

create table if not exists lesson_buy
(
    orderid integer not null auto_increment primary key,
    studentid integer not null,
    classid integer not null,
    teacherid integer not null,
    first_date DATE,
    progress varchar(50),
    lesson_date varchar(50),

    foreign key (studentid) references student(studentid),
    foreign key (classid) references lesson(classid),
    foreign key (teacherid) references teacher(teacherid)
);

create table if not exists wishlist
(
    wishlistid integer not null auto_increment primary key,
    studentid integer not null,
    classid integer not null,
    foreign key (studentid) references student(studentid),
    foreign key (classid) references lesson(classid)
);

create table if not exists review
(
    reviewid integer not null auto_increment primary key,
    studentid Integer not null,
    classid integer not null,
    review varchar(500),
    grade integer,
    review_date DATE,

    foreign key (studentid) references student(studentid),
    foreign key (classid) references lesson(classid)
);