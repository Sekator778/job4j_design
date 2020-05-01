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
(1, 'Bob', 1),
(2, 'Pol', 2),
(3, 'Molli', 3),
(4, 'Scala', 4),
(5, 'Java', 5),
(6, 'Rube', 1),
(7, 'PHP', 1);
select * from person;

--// 1) Получить в одном запросе:
-- // - имена всех лиц, которые НЕ находятся в компании с id = 5
-- // - название компании для каждого человека
-- do it..........




select distinct person.name, c.name from person left join company c on person.company_id = c.id
where c.id = 5
order by person.name;
select distinct person.name, c.name from person left join company c on person.company_id = c.id
where c.id <> 5
order by person.name;
-- // 2) Выберите название компании с максимальным количеством людей + количество людей в этой компании
-- do it .......






select c.name, count(p.company_id) from company c left join person p on c.id = p.company_id
group by c.name
order by count(p.company_id) desc
limit 1;

