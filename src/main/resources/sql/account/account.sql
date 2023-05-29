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
  `accountPhoto` longblob DEFAULT NULL,
  `accountIdoc` longblob DEFAULT NULL,
  `accountIntro` text DEFAULT NULL,
  `accountReport` int DEFAULT NULL,
  `accountBank` varchar(100) DEFAULT NULL,
  `accountVerify` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='會員資料表';


/*!40101 SET character_set_client = @saved_cs_client */;

#建立資料account
INSERT INTO `THA101G1`.`account`
(`accountId`,
`accountPhone`,
`accountPassword`,
`accountEmail`,
`accountNickname`,
`accountLevel`,
`accountState`,
`accountAddress`,
`accountName`,
`accountBirthday`,
`accountCreatetime`,
`accountUpdatetime`,
`accountGender`,
`accountIntro`,
`accountReport`,
`accountBank`,
`accountVerify`)
VALUES
(1,'0983811530','12345678','seanuaena0608@gmail.com','sumin',1,1,'10488台北市中山區南京東路三段219號5樓','蘇軒民','1994-05-30',current_timestamp(),current_timestamp(),1,'你好我不太好',0,'123456789bank','12345');

