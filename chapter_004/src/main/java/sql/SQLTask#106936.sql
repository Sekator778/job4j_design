--https://www.postgresqltutorial.com/how-to-delete-duplicate-rows-in-postgresql/
--В системе есть таблица cities. с полями id, name.
create table cities(
                       id  serial primary key,
                       name varchar(90));
--Система парсит объявления и записывывать города.
insert into cities (name)
values
('Moscow'),
('Kiev'),
('Baku'),
('Kiev'),
('Kiev'),
('Praha'),
('Moscow');
--В коде системы оказался баг. Он записывал дубликаты городов.
select * from cities;
truncate table cities restart identity;
--Москва, Москва,

--Багу поправили на уровне приложения, но таблица все равно содержит дубликаты.

--Ваша задача написать sql скрипт, который оставит в таблице только уникальные города.
-- Если было три раза написана Москва. то нужно оставить только одну Москву.

--найти дубликаты и их количество
SELECT name, COUNT(name)
FROM cities GROUP BY name
HAVING COUNT(name) > 1
ORDER BY name;

-- удаление дубликатов соединяем таблицу с собой через алиасы
-- каждую строку 1й со всеми последующими a.id < b.id и если они равни по нейму то delete
delete from cities a using cities b
where a.id > b.id and a.name = b.name;
-- use subquery
DELETE FROM cities
WHERE id IN
      (SELECT id
       FROM
           (SELECT id,
                   ROW_NUMBER() OVER( PARTITION BY name
                       ORDER BY  id ) AS row_num
            FROM cities ) t
       WHERE t.row_num > 1 );

-- if you want save with high ID
DELETE FROM cities
WHERE id IN
      (SELECT id
       FROM
           (SELECT id,
                   ROW_NUMBER() OVER( PARTITION BY name
                       ORDER BY  id DESC ) AS row_num
            FROM cities ) t
       WHERE t.row_num > 1 );