CREATE DATABASE  IF NOT EXISTS `pixolutdb`;
use `pixolutdb`;

CREATE TABLE `pixolutdb`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NULL,
  `is_acitve` BIT NULL,
  `username` VARCHAR(20) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(50) NULL,
  `created_date` DATETIME NULL DEFAULT '1970-01-01 01:01:01',
  `created_by` VARCHAR(50) NULL,
  `modified_date` DATETIME NULL DEFAULT '1970-01-01 01:01:01',
  `modified_by` VARCHAR(50) NULL,
  PRIMARY KEY (`user_id`));

CREATE TABLE `pixolutdb`.`contacts` (
  `contact_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `user_id` INT NULL,
  `created_date` DATETIME NULL DEFAULT '1970-01-01 01:01:01',
  `created_by` VARCHAR(50) NULL,
  `modified_date` DATETIME NULL DEFAULT '1970-01-01 01:01:01',
  `modified_by` VARCHAR(50) NULL,
  PRIMARY KEY (`contact_id`),
  INDEX `frg_key_idx` (`user_id` ASC),
  CONSTRAINT `frg_key`
    FOREIGN KEY (`user_id`)
    REFERENCES `pixolutdb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

	