--Кузов
create table body_car
(
body_car_id serial primary key,
name varchar(200)
);
--Двигатель
create table motor_car
(
motor_id serial primary key,
description varchar(200)
);
--Коробка передач
create table transmission_car
(
transmission_car_id serial primary key,
description varchar(200)
);
--some car
create table car
(
car_id serial primary key,
name varchar(80),
body_car_id int references body_car (body_car_id),
motor_car_id int references motor_car (motor_id),
transmission_car_id int references transmission_car (transmission_car_id)
);

--insert

insert into body_car (name)
values ('sedan'),
('hatchback'),
('bus'),
('SUV');

insert into motor_car (description) values
('2.0/75h.p./diesel'),
('2.1/95h.p./bioetanol'),
('2.2/175h.p./diesel'),
('3.0/275h.p./gibrid'),
('3.0/375h.p./diesel'),
('3.3/475h.p./diesel');

insert into transmission_car (description) values
('mehanik'),
('avtomatoc'),
('variotor'),
('robotic');

insert into car (name, body_car_id, motor_car_id, transmission_car_id)
values ('Volvo XC60', 4, 4, 4),
('Mazda C60', 2, 1, 2),
('Opel Combo', 1, 1, 2),
('Bently', 4, 1, 3),
('Fiat Punto', 3, 3, 2);