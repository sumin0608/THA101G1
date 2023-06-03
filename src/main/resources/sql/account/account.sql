CREATE DATABASE  IF NOT EXISTS `THA101G1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `THA101G1`;
-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: JAVA_FRAMEWORK
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

#建立account資料表
CREATE TABLE `account` (
  `accountId` int NOT NULL AUTO_INCREMENT,
  `accountPhone` varchar(10) DEFAULT NULL,
  `accountPassword` varchar(100) DEFAULT NULL,
  `accountEmail` varchar(100) DEFAULT NULL,
  `accountNickname` varchar(50) DEFAULT NULL,
  `accountLevel` int DEFAULT NULL,
  `accountState` int DEFAULT NULL,
  `accountAddress` varchar(100) DEFAULT NULL,
  `accountName` varchar(100) DEFAULT NULL,
  `accountBirthday` Date DEFAULT NULL,
  `accountCreatetime` timestamp DEFAULT current_timestamp,
  `accountUpdatetime` timestamp DEFAULT current_timestamp,
  `accountGender` int DEFAULT NULL,
  `accountPhoto` mediumblob DEFAULT NULL,
  `accountIdoc` mediumblob DEFAULT NULL,
  `accountIntro` text DEFAULT NULL,
  `accountReport` int DEFAULT NULL,
  `accountBank` varchar(100) DEFAULT NULL,
  `accountVerify` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='會員資料表';

/*!40101 SET character_set_client = @saved_cs_client */;

#建立資料account
INSERT INTO `account` (accountPhone, accountPassword, accountEmail, accountNickname, accountLevel, accountState, accountAddress, accountName, accountBirthday, accountCreatetime, accountUpdatetime, accountGender, accountPhoto, accountIdoc, accountIntro, accountReport, accountBank, accountVerify)
VALUES
  ('1234567890', 'password1', 'email1@example.com', 'User1', 1, 1, 'Address 1', 'John Doe', '1990-01-01', current_timestamp, current_timestamp, 1, NULL, NULL, 'Introduction 1', 0, 'Bank 1', 'Verify 1'),
  ('2345678901', 'password2', 'email2@example.com', 'User2', 2, 1, 'Address 2', 'Jane Smith', '1995-02-02', current_timestamp, current_timestamp, 2, NULL, NULL, 'Introduction 2', 0, 'Bank 2', 'Verify 2'),
  ('3456789012', 'password3', 'email3@example.com', 'User3', 1, 0, 'Address 3', 'Mike Johnson', '1988-03-03', current_timestamp, current_timestamp, 1, NULL, NULL, 'Introduction 3', 0, 'Bank 3', 'Verify 3'),
  ('4567890123', 'password4', 'email4@example.com', 'User4', 3, 1, 'Address 4', 'Emily Davis', '1992-04-04', current_timestamp, current_timestamp, 2, NULL, NULL, 'Introduction 4', 0, 'Bank 4', 'Verify 4'),
  ('5678901234', 'password5', 'email5@example.com', 'User5', 2, 1, 'Address 5', 'David Johnson', '1991-05-05', current_timestamp, current_timestamp, 1, NULL, NULL, 'Introduction 5', 0, 'Bank 5', 'Verify 5'),
  ('6789012345', 'password6', 'email6@example.com', 'User6', 1, 0, 'Address 6', 'Sarah Wilson', '1994-06-06', current_timestamp, current_timestamp, 2, NULL, NULL, 'Introduction 6', 0, 'Bank 6', 'Verify 6'),
  ('7890123456', 'password7', 'email7@example.com', 'User7', 3, 1, 'Address 7', 'Tom Thompson', '1993-07-07', current_timestamp, current_timestamp, 1, NULL, NULL, 'Introduction 7', 0, 'Bank 7', 'Verify 7'),
  ('8901234567', 'password8', 'email8@example.com', 'User8', 1, 1, 'Address 8', 'Alice Parker', '1996-08-08', current_timestamp, current_timestamp, 2, NULL, NULL, 'Introduction 8', 0, 'Bank 8', 'Verify 8'),
  ('9012345678', 'password9', 'email9@example.com', 'User9', 2, 0, 'Address 9', 'Chris Evans', '1997-09-09', current_timestamp, current_timestamp, 1, NULL, NULL, 'Introduction 9', 0, 'Bank 9', 'Verify 9'),
  ('0123456789', 'password10', 'email10@example.com', 'User10', 3, 1, 'Address 10', 'Linda Johnson', '1998-10-10', current_timestamp, current_timestamp, 2, NULL, NULL, 'Introduction 10', 0, 'Bank 10', 'Verify 10'),
  ('1023456789', 'password11', 'email11@example.com', 'User11', 1, 0, 'Address 11', 'Peter Wilson', '1999-11-11', current_timestamp, current_timestamp, 1, NULL, NULL, 'Introduction 11', 0, 'Bank 11', 'Verify 11'),
  ('2134567890', 'password12', 'email12@example.com', 'User12', 2, 1, 'Address 12', 'Emma Davis', '2000-12-12', current_timestamp, current_timestamp, 2, NULL, NULL, 'Introduction 12', 0, 'Bank 12', 'Verify 12'),
  ('3245678901', 'password13', 'email13@example.com', 'User13', 1, 1, 'Address 13', 'Ryan Smith', '2001-01-13', current_timestamp, current_timestamp, 1, NULL, NULL, 'Introduction 13', 0, 'Bank 13', 'Verify 13'),
  ('4356789012', 'password14', 'email14@example.com', 'User14', 3, 0, 'Address 14', 'Olivia Johnson', '2002-02-14', current_timestamp, current_timestamp, 2, NULL, NULL, 'Introduction 14', 0, 'Bank 14', 'Verify 14'),
  ('5467890123', 'password15', 'email15@example.com', 'User15', 2, 1, 'Address 15', 'Noah Wilson', '2003-03-15', current_timestamp, current_timestamp, 1, NULL, NULL, 'Introduction 15', 0, 'Bank 15', 'Verify 15');