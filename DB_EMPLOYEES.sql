CREATE DATABASE  IF NOT EXISTS `Employees_management` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Employees_management`;

CREATE TABLE `Countries` (
  `ISO` varchar(3) NOT NULL,
  `Description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ISO`)
);

CREATE TABLE `Regions` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(30) DEFAULT NULL,
  `ISO_Country` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ISO_Country`) REFERENCES `Countries` (`ISO`)
);

CREATE TABLE `Provinces` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(30) DEFAULT NULL,
  `ID_Region` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID_Region`) REFERENCES `Regions` (`ID`)
);

CREATE TABLE `Cities` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(30) DEFAULT NULL,
  `ID_Province` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID_Province`) REFERENCES `Provinces` (`ID`)
);

CREATE TABLE `Employees` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) DEFAULT NULL,
  `Surname` varchar(60) DEFAULT NULL,
  `TaxCode` varchar(30) DEFAULT NULL,
  `ID_City` int DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Gender` char(1) default null,
  `Email` varchar(40) DEFAULT NULL,
  `PhoneNumber` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID_City`) REFERENCES `Cities` (`ID`)
);