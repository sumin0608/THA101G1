-- CREATE DATABASE  IF NOT EXISTS `THA101G1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
-- USE `THA101G1`;
-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: JAVA_FRAMEWORK
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

DROP TABLE IF EXISTS `COACHSKILL`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

DROP TABLE IF EXISTS `COACHSKILL`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

CREATE TABLE `COACHSKILL`
(
    `SKILLID`      int NOT NULL AUTO_INCREMENT,
    `ACCOUNTID`    int         DEFAULT NULL,
    `LICENSENAME`  varchar(50) DEFAULT NULL,
    `SPORTTYPE`    int         DEFAULT NULL,
    `LICENSEPHOTO` MEDIUMBLOB,
    `SKILLSTATE`   int         DEFAULT NULL,
    PRIMARY KEY (`SKILLID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
INSERT INTO `COACHSKILL`
(`SKILLID`, `ACCOUNTID`, `LICENSENAME`, `SPORTTYPE`, `LICENSEPHOTO`, `SKILLSTATE`)
VALUES (1, 5, '健身教練證照', 1, NULL, 1),
       (2, 2, '營養師證照', 2, NULL, 1),
       (3, 3, '瑜珈教練證照', 3, NULL, 1),
       (4, 5, '游泳教練證照', 4, NULL, 1),
       (5, 5, '有氧運動教練證照', 5, NULL, 1),
       (6, 6, '健康管理師證照', 6, NULL, 1),
       (7, 7, '體適能教練證照', 7, NULL, 1),
       (8, 8, '國際教練證照', 8, NULL, 1),
       (9, 9, '羽球教練證照', 9, NULL, 1),
       (10, 10, '跑步教練證照', 10, NULL, 1);