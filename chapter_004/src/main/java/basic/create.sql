-- create database  test_db
-- connect and choose users look PostgeSQL.txt file
-- after created tables

create table rules (
  id   serial primary key,
  name varchar(80)
);

create table role (
  id   serial primary key,
  name varchar(80)
);

create table rules_role (
  role_id       int references role (id),
  rules_id      int references rules (id),
  primary key (role_id, rules_id)
);

create table users (
  id       serial primary key,
  login    varchar(80) not null,
  password varchar(80) not null,
  role_id  int         not null references role (id)
);

create table category (
  id   serial primary key,
  name varchar(80) not null
);

create table state (
  id   serial primary key,
  name varchar(80) not null
);

create table attachs (
  id         serial primary key,
  name       varchar(80) not null,
  text varchar(2000) not null,
  created    timestamp    not null default now(),
  creator_id int          not null references users (id)
);

create table comment (
  id        serial primary key,
  body      text,
  created   timestamp not null default now(),
  author_id int       not null references users (id)
);

----------------------------
create table item (
  id          serial primary key,
  title       varchar(80) not null,
  created     timestamp    not null default now(),

  creator_id  int          not null references users (id),

  category_id int references category (id),

  state_id    int references state (id),
  attach_id int references attachs(id),
  comment_id int references comment(id)

);

insert into role (name) values ('admin');
insert into role (name) values ('user');

insert into rules (name) values ('created');
insert into rules (name) values ('open');
insert into rules (name) values ('attach');
insert into rules (name) values ('comment');

insert into rules_role (role_id, rules_id) values (1, 1);
insert into rules_role (role_id, rules_id) values (1, 2);
insert into rules_role (role_id, rules_id) values (1, 3);
insert into rules_role (role_id, rules_id) values (1, 4);
insert into rules_role (role_id, rules_id) values (2, 2);
insert into rules_role (role_id, rules_id) values (2, 4);

insert into users (login, password, role_id) values ('admin', 'admin', 1);
insert into users (login, password, role_id) values ('user', 'user', 2);

insert into category (name) values ('one category');
insert into category (name) values ('two category');
insert into category (name) values ('three category');

insert into state (name) values ('state1');

insert into attachs (name, text, created, creator_id)
 values ('attachment-one', 'some attachments sssss', now(), 1);

insert into comment (body, created, author_id) values ('comment-txt', now(), 2);

insert into item (title, created, creator_id, category_id, state_id, attach_id, comment_id) values ('title1', now(), 1, 2, 1, 1, 1);



