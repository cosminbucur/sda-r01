CREATE SCHEMA `jdbc_tutorial` ;

CREATE TABLE `jdbc_tutorial`.`new_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
