--1. Вывести список всех машин и все привязанные к ним детали.
select c.name, c.body_car_id, c.motor_car_id, c.transmission_car_id
from car as c

            inner join body_car as bc on bc.body_car_id = c.body_car_id

            inner join motor_car as mc on mc.motor_id = c.motor_car_id

            inner join transmission_car as trc on trc.transmission_car_id = c.transmission_car_id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

-- неиспользуемые кузова авто -> tables use body_car
select c.body_car_id from car as c
                                  right join body_car as bc
                      on c.body_car_id = bc.body_car_id
                      where c.body_car_id is null;

-- неиспользуемые моторы
select c.motor_car_id from car as c
                                  right join motor_car as mc
                        on c.motor_car_id = mc.motor_id
                        where c.motor_car_id is null;

-- неиспользуемые коробки передач
select c.transmission_car_id from car as c
                                            right join transmission_car as trc
                        on c.transmission_car_id = trc.transmission_car_id
                        where c.transmission_car_id is null;

