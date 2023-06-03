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

DROP TABLE IF EXISTS `porder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

#建立account資料表
CREATE TABLE porder (
  id int NOT NULL AUTO_INCREMENT,
  porderNo varchar(45) DEFAULT NULL,
  memberNo varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  productName varchar(45) DEFAULT NULL,
  pamount varchar(45) DEFAULT NULL,
  pdate datetime DEFAULT NULL,
  phone varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET character_set_client = @saved_cs_client */;

#建立資料account
INSERT INTO porder (porderNo, memberNo, name, productName, pamount, pdate, phone, email)
VALUES
  ('PO001', 'M001', 'John', 'Product A', '100', '2023-06-01 09:00:00', '1234567890', 'john@example.com'),
  ('PO002', 'M002', 'Jane', 'Product B', '200', '2023-06-02 10:30:00', '9876543210', 'jane@example.com'),
  ('PO003', 'M003', 'Mike', 'Product C', '150', '2023-06-03 14:45:00', '4567890123', 'mike@example.com'),
  ('PO004', 'M004', 'Emily', 'Product A', '100', '2023-06-04 11:15:00', '7890123456', 'emily@example.com'),
  ('PO005', 'M005', 'David', 'Product B', '200', '2023-06-05 16:20:00', '0123456789', 'david@example.com'),
  ('PO006', 'M006', 'Sarah', 'Product C', '150', '2023-06-06 13:30:00', '2345678901', 'sarah@example.com'),
  ('PO007', 'M007', 'Tom', 'Product A', '100', '2023-06-07 17:10:00', '5678901234', 'tom@example.com'),
  ('PO008', 'M008', 'Alice', 'Product B', '200', '2023-06-08 12:45:00', '8901234567', 'alice@example.com'),
  ('PO009', 'M009', 'Chris', 'Product C', '150', '2023-06-09 15:55:00', '9012345678', 'chris@example.com'),
  ('PO010', 'M010', 'Linda', 'Product A', '100', '2023-06-10 18:25:00', '3456789012', 'linda@example.com');
