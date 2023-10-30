INSERT INTO `space_travel`.`clients`(`first_name`,`last_name`)
VALUES ('Kavon','Rolfson'),
       ('Linda','Pfeffer'),
       ('Glenda','Kautzer'),
       ('Brandi','Satterfield'),
       ('Liana','Daniel'),
       ('Stanton','Muller'),
       ('Brooks','Larson'),
       ('Mariane','Rosenbaum'),
       ('Doug','Block'),
       ('Talon','Rempel');

INSERT INTO `space_travel`.`planets`(`id`,`planet_name`)
VALUES ('MER','Mercury'),
       ('EAR','Earth'),
       ('MAR','Mars'),
       ('JUP','Jupiter'),
       ('SAT','Saturn');

INSERT INTO `space_travel`.`tickets`(`created_at`,`client_id`,`from_planet_id`,`to_planet_id`)
VALUES ('2023-08-29 15:30:00', 1, 'MER', 'SAT'),
       ('2023-09-01 17:30:00', 2, 'EAR', 'JUP'),
       ('2023-09-05 12:45:00', 3, 'MAR', 'EAR'),
       ('2023-09-07 19:05:00', 4, 'JUP', 'MAR'),
       ('2023-09-13 06:35:00', 5, 'SAT', 'MER'),
       ('2023-09-25 21:15:00', 6, 'SAT', 'MER'),
       ('2023-10-03 13:55:00', 7, 'JUP', 'MAR'),
       ('2023-10-10 10:30:00', 8, 'MAR', 'EAR'),
       ('2023-10-19 09:20:00', 9, 'EAR', 'JUP'),
       ('2023-10-28 20:10:00', 10, 'MER', 'SAT');