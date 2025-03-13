--create table if not exists users(
--  id bigserial primary key,
--  first_name varchar(256) not null,
--  last_name varchar(256) not null,
--  age integer not null,
--  active boolean not null);
--
--insert into users(first_name, last_name, age, active) values ('Иван', 'Иванов', 30, true);
--insert into users(first_name, last_name, age, active) values ('Пётр', 'Петров', 25, false);
--insert into users(first_name, last_name, age, active) values ('Мария', 'Сидорова', 28, true);

create table if not exists posts(
    id bigserial primary key,
    title varchar(256) not null,
    text varchar(256) not null,
    image_path varchar(256),
    likes_count integer,
    comments_id bigserial,
    tags varchar(256)
 );

create table if not exists comments(
   id bigserial primary key,
   text varchar(256) not null
);

delete from public.posts;
delete from public.comments;

insert into posts(title, text, image_path, likes_count, tags) values ('Title1', 'Text1', '/path/image1', 0, '1, 2, 3');
insert into posts(title, text, image_path, likes_count, tags) values ('Title2', 'Text2', '/path/image2', 10, 'one, two, three');