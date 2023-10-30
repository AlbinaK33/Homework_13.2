CREATE TABLE `space_travel`.`clients` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `first_name` VARCHAR(201) NOT NULL,
                                               `last_name` VARCHAR(201) NOT NULL,
                                               PRIMARY KEY (`id`));

CREATE TABLE `space_travel`.`planets` (
                                               id VARCHAR(10) BINARY PRIMARY KEY CHECK (id REGEXP '^[A-Z0-9]+$'),
                                               `planet_name` VARCHAR(501) NOT NULL
);

CREATE TABLE `space_travel`.`tickets` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                               `client_id` INT NOT NULL,
                                               `from_planet_id` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL CHECK (from_planet_id REGEXP '^[A-Z0-9]+$'),
                                               `to_planet_id` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL CHECK (to_planet_id REGEXP '^[A-Z0-9]+$'),
                                               PRIMARY KEY (`id`),
                                               INDEX `fk_client_id_idx` (`client_id` ASC) VISIBLE,
                                               INDEX `fk_from_planet_id_idx` (`from_planet_id` ASC) VISIBLE,
                                               INDEX `fk_to_planet_id_idx` (`to_planet_id` ASC) VISIBLE,
                                               CONSTRAINT `fk_client_id`
                                                   FOREIGN KEY (`client_id`)
                                                       REFERENCES `space_travel`.`clients` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION,
                                               CONSTRAINT `fk_from_planet_id`
                                                   FOREIGN KEY (`from_planet_id`)
                                                       REFERENCES `space_travel`.`planets` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION,
                                               CONSTRAINT `fk_to_planet_id`
                                                   FOREIGN KEY (`to_planet_id`)
                                                       REFERENCES `space_travel`.`planets` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION);

