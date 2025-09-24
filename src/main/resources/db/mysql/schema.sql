-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pricingdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pricingdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pricingdb` DEFAULT CHARACTER SET utf8mb3 ;
USE `pricingdb` ;

-- -----------------------------------------------------
-- Table `pricingdb`.`payment_methods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pricingdb`.`payment_methods` (
  `id_payment_method` INT NOT NULL AUTO_INCREMENT,
  `payment_method` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_payment_method`),
  UNIQUE INDEX `metodo_de_pago_UNIQUE` (`payment_method` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `pricingdb`.`prices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pricingdb`.`prices` (
  `id_price` INT NOT NULL AUTO_INCREMENT,
  `coins_amount` INT NOT NULL,
  `price` FLOAT NOT NULL,
  `method_id` INT NOT NULL,
  PRIMARY KEY (`id_price`),
  INDEX `metodo_id_idx` (`method_id` ASC) VISIBLE,
  CONSTRAINT `method_id`
    FOREIGN KEY (`method_id`)
    REFERENCES `pricingdb`.`payment_methods` (`id_payment_method`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `pricingdb`.`discounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pricingdb`.`discounts` (
  `id_discount` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `discount_percentaje` FLOAT NOT NULL,
  `price_id` INT NOT NULL,
  PRIMARY KEY (`id_discount`),
  INDEX `price_id_idx` (`price_id` ASC) VISIBLE,
  CONSTRAINT `price_id`
    FOREIGN KEY (`price_id`)
    REFERENCES `pricingdb`.`prices` (`id_price`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
