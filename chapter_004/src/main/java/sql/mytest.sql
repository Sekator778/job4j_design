-- select * from ships
-- where name like '%a' and name not like '%na';
drop table girl;
drop table toy;
CREATE TABLE girl (
                      id serial PRIMARY KEY,
                      name VARCHAR
);

CREATE TABLE toy (
                     id serial PRIMARY KEY,
                     name VARCHAR
);
-- add toy
insert into toy (name)
values
('Car'),
('Dog'),
('Cat');
insert into girl(name, toy_id)
values
('Masha', 1),
('Anya', 1),
('Masha', 2),
('Dasha', 2),
('Sveta', 1);
select * from toy;
select * from girl;
truncate table  girl  restart identity;
drop table   toy cascade;
select * from girl, toy;
-- 1. Написать sql инструкцию. Инструкция должна добавить колонку toy_id в таблицу girl.
alter table girl add column toy_id int;
alter table girl add foreign key (toy_id) references toy;
-- 2. Написать sql запрос на получение имени девочки и ее игрушки.
select girl.name, t.name from girl left join toy t on girl.toy_id = t.id
order by girl.name;
-- 3. Написать sql запрос на получение игрушек не привязанных к девочкам.
select toy.name from toy
where toy.id not in (select toy_id from girl);
