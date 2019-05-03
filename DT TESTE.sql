-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema MySchoolDatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MySchoolDatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MySchoolDatabase` DEFAULT CHARACTER SET utf8 ;
USE `MySchoolDatabase` ;

-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Student` (
  `idStudent` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `studentName` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `rg` VARCHAR(7) NOT NULL,
  `borndate` DATE NOT NULL,
  `studentPassword` VARCHAR(25) NOT NULL,
  `email` VARCHAR(65) NULL,
  PRIMARY KEY (`idStudent`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  UNIQUE INDEX `rg_UNIQUE` (`rg` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Professor` (
  `idProfessor` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `professorName` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `rg` VARCHAR(7) NOT NULL,
  `borndate` DATE NOT NULL,
  `professorPassword` VARCHAR(25) NOT NULL,
  `salary` INT NULL,
  `email` VARCHAR(65) NULL,
  PRIMARY KEY (`idProfessor`),
  UNIQUE INDEX `rg_UNIQUE` (`rg` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  UNIQUE INDEX `nome_UNIQUE` (`professorName` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Secretary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Secretary` (
  `idSecretary` INT NOT NULL AUTO_INCREMENT,
  `secretaryName` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `secretaryPassword` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idSecretary`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Discipline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Discipline` (
  `idDiscipline` INT NOT NULL AUTO_INCREMENT,
  `disciplineName` VARCHAR(45) NOT NULL,
  `idProfessor` INT NOT NULL,
  PRIMARY KEY (`idDiscipline`),
  UNIQUE INDEX `nome_UNIQUE` (`disciplineName` ASC),
  INDEX `fk_Discipline_Professor1_idx` (`idProfessor` ASC),
  CONSTRAINT `fk_Discipline_Professor1`
    FOREIGN KEY (`idProfessor`)
    REFERENCES `MySchoolDatabase`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Bimester`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Bimester` (
  `idBimester` INT NOT NULL AUTO_INCREMENT,
  `bimesterName` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idBimester`),
  UNIQUE INDEX `nameBimester_UNIQUE` (`bimesterName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Parcial_Grades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Parcial_Grades` (
  `idParcial_Grades` INT NOT NULL AUTO_INCREMENT,
  `idStudent` INT NOT NULL,
  `idBimester` INT NOT NULL,
  `idDiscipline` INT NOT NULL,
  `n1` DOUBLE NULL,
  `n2` DOUBLE NULL,
  `n3` DOUBLE NULL,
  `average` DOUBLE NULL,
  PRIMARY KEY (`idParcial_Grades`),
  INDEX `fk_Discipline_Grades_Discipline1_idx` (`idDiscipline` ASC),
  INDEX `fk_Discipline_Grades_Student1_idx` (`idStudent` ASC),
  INDEX `fk_Parcial_Grades_Bimester1_idx` (`idBimester` ASC),
  CONSTRAINT `fk_Discipline_Grades_Discipline1`
    FOREIGN KEY (`idDiscipline`)
    REFERENCES `MySchoolDatabase`.`Discipline` (`idDiscipline`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Discipline_Grades_Student1`
    FOREIGN KEY (`idStudent`)
    REFERENCES `MySchoolDatabase`.`Student` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Parcial_Grades_Bimester1`
    FOREIGN KEY (`idBimester`)
    REFERENCES `MySchoolDatabase`.`Bimester` (`idBimester`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Class` (
  `idClass` INT NOT NULL AUTO_INCREMENT,
  `initials` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idClass`),
  UNIQUE INDEX `initials_UNIQUE` (`initials` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Student_Class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Student_Class` (
  `idStudent_Class` INT NOT NULL AUTO_INCREMENT,
  `idClass` INT NOT NULL,
  `idStudent` INT NOT NULL,
  PRIMARY KEY (`idStudent_Class`),
  INDEX `fk_Student_Class_Class1_idx` (`idClass` ASC),
  INDEX `fk_Student_Class_Student1_idx` (`idStudent` ASC),
  CONSTRAINT `fk_Student_Class_Class1`
    FOREIGN KEY (`idClass`)
    REFERENCES `MySchoolDatabase`.`Class` (`idClass`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Class_Student1`
    FOREIGN KEY (`idStudent`)
    REFERENCES `MySchoolDatabase`.`Student` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Serie` (
  `idSerie` INT NOT NULL AUTO_INCREMENT,
  `serieName` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idSerie`),
  UNIQUE INDEX `serieName_UNIQUE` (`serieName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`SchoolReport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`SchoolReport` (
  `idSchoolReport` INT NOT NULL AUTO_INCREMENT,
  `idSerie` INT NOT NULL,
  `idStudent` INT NOT NULL,
  `idBimester` INT NOT NULL,
  `idDiscipline` INT NOT NULL,
  `average` DOUBLE NULL,
  `yearSchoolReport` INT(4) NULL,
  PRIMARY KEY (`idSchoolReport`),
  INDEX `fk_SchollReport_Bimester1_idx` (`idBimester` ASC),
  INDEX `fk_SchollReport_Discipline1_idx` (`idDiscipline` ASC),
  INDEX `fk_SchollReport_Student1_idx` (`idStudent` ASC),
  INDEX `fk_SchoolReport_Serie1_idx` (`idSerie` ASC),
  CONSTRAINT `fk_SchollReport_Bimester1`
    FOREIGN KEY (`idBimester`)
    REFERENCES `MySchoolDatabase`.`Bimester` (`idBimester`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SchollReport_Discipline1`
    FOREIGN KEY (`idDiscipline`)
    REFERENCES `MySchoolDatabase`.`Discipline` (`idDiscipline`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SchollReport_Student1`
    FOREIGN KEY (`idStudent`)
    REFERENCES `MySchoolDatabase`.`Student` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SchoolReport_Serie1`
    FOREIGN KEY (`idSerie`)
    REFERENCES `MySchoolDatabase`.`Serie` (`idSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Historic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Historic` (
  `idHistoric` INT NOT NULL AUTO_INCREMENT,
  `idStudent` INT NOT NULL,
  `idSchoolReport` INT NOT NULL,
  PRIMARY KEY (`idHistoric`),
  INDEX `fk_Historic_Student1_idx` (`idStudent` ASC),
  INDEX `fk_Historic_SchollReport1_idx` (`idSchoolReport` ASC),
  CONSTRAINT `fk_Historic_Student1`
    FOREIGN KEY (`idStudent`)
    REFERENCES `MySchoolDatabase`.`Student` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historic_SchollReport1`
    FOREIGN KEY (`idSchoolReport`)
    REFERENCES `MySchoolDatabase`.`SchoolReport` (`idSchoolReport`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MySchoolDatabase`.`Series_Class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MySchoolDatabase`.`Series_Class` (
  `idSeries_Class` INT NOT NULL AUTO_INCREMENT,
  `idClass` INT NOT NULL,
  `idSerie` INT NOT NULL,
  PRIMARY KEY (`idSeries_Class`),
  INDEX `fk_Series_Class_Class1_idx` (`idClass` ASC),
  INDEX `fk_Series_Class_Serie1_idx` (`idSerie` ASC),
  CONSTRAINT `fk_Series_Class_Class1`
    FOREIGN KEY (`idClass`)
    REFERENCES `MySchoolDatabase`.`Class` (`idClass`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Series_Class_Serie1`
    FOREIGN KEY (`idSerie`)
    REFERENCES `MySchoolDatabase`.`Serie` (`idSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
