-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema javatp1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema javatp1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `javatp1` DEFAULT CHARACTER SET latin1 ;
USE `javatp1` ;

-- -----------------------------------------------------
-- Table `javatp1`.`personajes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javatp1`.`personajes` ;

CREATE TABLE IF NOT EXISTS `javatp1`.`personajes` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `vida` INT(10) UNSIGNED NOT NULL,
  `energia` INT(10) UNSIGNED NOT NULL,
  `defensa` INT(10) UNSIGNED NOT NULL,
  `evasion` INT(10) UNSIGNED NOT NULL,
  `puntosTotales` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
