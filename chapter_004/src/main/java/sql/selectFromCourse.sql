-- В системе заданы таблицы
--
-- product(id, name, type_id, expired_date, price)
--
-- type(id, name)
--
create table type
(
    id   serial primary key,
    name varchar(90)
);
create table product
(
    id           serial primary key,
    type_id      int references type (id),
    name varchar(90),
    expired_date date,
    price        numeric(10, 2)
);
-- insert
INSERT INTO type (name) VALUES
('сыр'),
('алкоголь'),
('meat')
;

INSERT INTO product (name, type_id, price) VALUES
('сыр', 1, 9.99),
('мороженное', 1, 5.99),
('сыр с плесенью', 1, 1.99),
('мороженное в шоколаде', 1, 19.99),
('молоко', 1, 2.99),
('gin', 2, 11.99),
('bread', 2, 0.99)
;
select *
from product;
select *
from type;
drop table product;
-- Задание.
--
-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product
where product.type_id in (select id from type where name = 'сыр');
-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
--
select *
from product
where name like '%мороженное%';
-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
--
select * from product
where date_part('month', expired_date) = date_part('month', current_date) + 1;
-- 4. Написать запрос, который выводит самый дорогой продукт.
--
select *
from product
where price = (select max(price) from product);
-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
--
select product.name, count(id)
from product where product.type_id = (select id from type where type.name = 'алкоголь')
group by product.name;
-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select product.name
from product left join type t on product.type_id = t.id
where t.name = 'сыр' or t.name = 'meat';
-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name, count(t.name) from product left join type t on product.type_id = t.id
group by t.name
having count(t.name) < 10;

-- 8. Вывести все продукты и их тип.
select distinct p.name, t.name
from product p left join type t on p.type_id = t.id;

--8
select p.name, t.name
from product p inner join type t
                          on p.type_id = t.id;
