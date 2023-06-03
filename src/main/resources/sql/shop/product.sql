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

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

#建立account資料表
CREATE TABLE product (
  id int NOT NULL AUTO_INCREMENT,
  productNo varchar(45) DEFAULT NULL,
  productName varchar(45) DEFAULT NULL,
  picture varchar(45) DEFAULT NULL,
  price int DEFAULT NULL,
  amount int DEFAULT NULL,
  comment varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET character_set_client = @saved_cs_client */;

#建立資料account
INSERT INTO product (productNo, productName, picture, price, amount, comment)
VALUES
  ('P001', 'Product A', 'image1.jpg', 100, 50, 'This is product A.'),
  ('P002', 'Product B', 'image2.jpg', 200, 30, 'This is product B.'),
  ('P003', 'Product C', 'image3.jpg', 150, 20, 'This is product C.'),
  ('P004', 'Product D', 'image4.jpg', 120, 40, 'This is product D.'),
  ('P005', 'Product E', 'image5.jpg', 180, 60, 'This is product E.'),
  ('P006', 'Product F', 'image6.jpg', 90, 10, 'This is product F.'),
  ('P007', 'Product G', 'image7.jpg', 250, 15, 'This is product G.'),
  ('P008', 'Product H', 'image8.jpg', 300, 25, 'This is product H.'),
  ('P009', 'Product I', 'image9.jpg', 160, 35, 'This is product I.'),
  ('P010', 'Product J', 'image10.jpg', 140, 5, 'This is product J.');