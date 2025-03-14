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
   post_id bigserial,
   text varchar(256) not null
);

delete from public.posts;
delete from public.comments;

insert into posts(id, title, text, image_path, likes_count, tags) values (1, 'Title1', 'Text1', '/path/image1', 0, '1, 2, 3');
insert into posts(id, title, text, image_path, likes_count, tags) values (2, 'Title2', 'Text2', '/path/image2', 10, 'one, two, three');
insert into posts(id, title, text, image_path, likes_count, tags) values (3, 'Title3', 'Text3', '/path/image1', 0, '1, 2, 3');
insert into posts(id, title, text, image_path, likes_count, tags) values (4, 'Title4', 'Text4', '/path/image2', 10, 'one, two, three');
insert into posts(id, title, text, image_path, likes_count, tags) values (5, 'Title5', 'Text5', '/path/image1', 0, '1, 2, 3');
insert into posts(id, title, text, image_path, likes_count, tags) values (6, 'Title6', 'Text6', '/path/image2', 10, 'one, two, three');
insert into posts(id, title, text, image_path, likes_count, tags) values (7, 'Title7', 'Text7', '/path/image1', 0, '1, 2, 3');
insert into posts(id, title, text, image_path, likes_count, tags) values (8, 'Title8', 'Text8', '/path/image2', 10, 'one, two, three');
insert into posts(id, title, text, image_path, likes_count, tags) values (9, 'Title9', 'Text9', '/path/image1', 0, '1, 2, 3');
insert into posts(id, title, text, image_path, likes_count, tags) values (10, 'Title10', 'Text10', '/path/image2', 10, 'one, two, three');
insert into posts(id, title, text, image_path, likes_count, tags) values (11, 'Title11', 'Text11', '/path/image1', 0, '1, 2, 3');
insert into posts(id, title, text, image_path, likes_count, tags) values (12, 'Title12', 'Text12', '/path/image2', 10, 'one, two, three');

insert into comments(post_id, text) values (1, 'comment_1_1');
insert into comments(post_id, text) values (1, 'comment_1_2');
insert into comments(post_id, text) values (2, 'comment_2_1');
