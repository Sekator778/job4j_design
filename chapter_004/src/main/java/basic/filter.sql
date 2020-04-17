--В системе заданы таблицы
--product(id, name, type_id, expired_date, price)
--type(id, name)
--1. Написать запрос получение всех продуктов с типом "СЫР"
select p.id, p.name, p.expired_date, p.price
from product p inner join type t on p.type_id = t.id
where t.name = 'СЫР';
 --2.Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product
where name like '%мороженное%';
--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select id, name, expired_date, price
from product
where date_part('month', expired_date) = date_part('month', current_date) + 1;
--4. Написать запрос, который выводит самый дорогой продукт.
select id, name, expired_date, price
from product
order by price desc limit 1;
--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select count(p.id)
from product p inner join type t on t.id = p.type_id
where t.name = 'СЫР';
-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select count(p.id)
from product p inner join type t on t.id = p.type_id
where t.name in ('СЫР', 'алкоголь');
-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select name from type
    where (select count(p.id) from product as p
        where p.type_id = type_id) < 10;
--8. Вывести все продукты и их тип.
select p.name, t.name
from product p inner join type t
on p.type_id = t.id;


