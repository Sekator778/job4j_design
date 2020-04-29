CREATE TABLE girl (
                      id serial PRIMARY KEY,
                      name VARCHAR
);

CREATE TABLE toy (
                     id serial PRIMARY KEY,
                     name VARCHAR
);
select * from girl;
select * from toy;
truncate table girl restart identity;
--1. Написать sql инструкцию. Инструкция должна добавить колонку toy_id в таблицу girl.
alter table  girl add toy_id int;
ALTER TABLE girl ADD FOREIGN KEY (toy_id)
    REFERENCES toy;

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
--2. Написать sql запрос на получение имени девочки и ее игрушки.
select distinct girl.name "GIRL", toy.name "TOY"
from girl left join toy on (girl.toy_id = toy.id)
order by girl.name;

--3. Написать sql запрос на получение игрушек не привязанных к девочкам.
select toy.name "FREE" from toy
where toy.id not in (select distinct toy_id from girl);