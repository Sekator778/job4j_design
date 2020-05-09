CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
insert into company (id, name)
values
(1, 'Bosh'),
       (2, 'Sony'),
       (3, 'Oracle'),
       (4, 'Sun'),
       (5, 'Yahoo');

select * from company;

insert into person (id, name, company_id) VALUES
(1, 'Kolya', 1),
(2, 'Vasya', 2),
(3, 'Olya', 3),
(4, 'Misha', 4),
(5, 'Oleg', 5),
(6, 'Sasha', 1),
(7, 'Vasiliy', 1);
select * from person;

--// 1) Получить в одном запросе:
-- // - имена всех лиц, которые НЕ находятся в компании с id = 5
-- // - название компании для каждого человека
-- do it..........
truncate table person restart identity ;








select distinct person.name, c.name from person left join company c on person.company_id = c.id
where c.id <> 5
order by person.name;
--
select person.name from person where company_id <> 5;
-- // 2) Выберите название компании с максимальным количеством людей + количество людей в этой компании
-- do it .......





select c.name, count(p.company_id) from company c left outer join  person p on c.id = p.company_id
group by c.name
order by count(p.company_id) desc
limit 1;

