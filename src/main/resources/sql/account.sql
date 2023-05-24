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
  `account_Id` int NOT NULL AUTO_INCREMENT,
  `account_Phone` varchar(10) DEFAULT NULL,
  `account_Password` varchar(100) DEFAULT NULL,
  `account_Email` varchar(100) DEFAULT NULL,
  `account_Nickname` varchar(50) DEFAULT NULL,
  `account_Level` int DEFAULT NULL,
  `account_State` int DEFAULT NULL,
  `account_Address` varchar(100) DEFAULT NULL,
  `account_Name` varchar(100) DEFAULT NULL,
  `account_Birthday` Date DEFAULT NULL,
  `account_Createtime` timestamp DEFAULT current_timestamp,
  `account_Updatetime` timestamp DEFAULT current_timestamp,
  `account_Gender` int DEFAULT NULL,
  `account_Photo` longblob DEFAULT NULL,
  `account_Idoc` longblob DEFAULT NULL,
  `account_Intro` text DEFAULT NULL,
  `account_Report` int DEFAULT NULL,
  `account_Bank` varchar(100) DEFAULT NULL,
  `account_Verify` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`account_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='會員資料表';


/*!40101 SET character_set_client = @saved_cs_client */;

#建立資料account
INSERT INTO `THA101G1`.`account`
(`account_Id`,
`account_Phone`,
`account_Password`,
`account_Email`,
`account_Nickname`,
`account_Level`,
`account_State`,
`account_Address`,
`account_Name`,
`account_Birthday`,
`account_Createtime`,
`account_Updatetime`,
`account_Gender`,
`account_Intro`,
`account_Report`,
`account_Bank`,
`account_Verify`)
VALUES
(1,'0983811530','12345678','seanuaena0608@gmail.com','sumin',1,1,'10488台北市中山區南京東路三段219號5樓','蘇軒民','1994-05-30',current_timestamp(),current_timestamp(),1,'你好我不太好',0,'123456789bank','12345');

