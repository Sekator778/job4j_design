--1. Есть таблица встреч(id, name), есть таблица юзеров(id, name).
drop table users cascade;
drop table meeting cascade;

create table meeting
(
    id   serial primary key,
    name varchar
);

create table users
(
    id   serial primary key,
    name varchar
);

--Нужно доработать модель базы данных, так чтобы пользователи могли участвовать во встречах.
-- У каждого участника встречи может быть разный статус участия - например подтвердил участие, отклонил.
--do it
create table users_met(
    user_id int references users(id),
    meeting_id int references meeting(id),
    confirm varchar check ( confirm in ('yes', 'no')),
     primary key (user_id, meeting_id)
);











create table user_meeting
(
    meeting_id int not null references meeting (id),
    user_id    int not null references users (id),
    status     varchar CHECK (status in ('accept', 'cansel')),
    primary key (meeting_id, user_id)
);
--insert for tests
insert into users (name)
values ('Bob'),
       ('Marvin'),
       ('Harvey'),
       ('Spector');
insert into meeting (name)
values ('Read'),
       ('Speak'),
       ('Write');
insert into user_meeting
values (1, 4, 'accept'),
       (1, 2, 'accept'),
       (3, 1, 'accept');
--view tables
select *
from users;
select *
from meeting;
select *
from user_meeting;

truncate table user_meeting restart identity;
--2. Нужно написать запрос, который получит список всех заявок и количество подтвердивших участников.
--do it






select meeting.name, count(user_meeting.user_id)
from meeting  join user_meeting on (meeting.id = user_meeting.meeting_id)
where user_meeting.status = 'accept'
group by meeting.name;

--3. Нужно получить все совещания, где не было ни одной заявки на посещения
--do it










select meeting.name "SOVESCHANIE"
from meeting
         left join user_meeting on (meeting.id = user_meeting.meeting_id)
where user_meeting.user_id is null;

