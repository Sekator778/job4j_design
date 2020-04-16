create table type(
id serial primary key,
name varchar(80) not null
);


create table product(
id serial primary key,
name varchar(80) not null,
type_id int references type(id),
expired_date timestamp not null default now(),
price int
);

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