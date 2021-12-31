CREATE DATABASE  IF NOT EXISTS `final_assignment` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `final_assignment`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: final_assignment
-- ------------------------------------------------------
-- Server version	8.0.27

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

--
-- Table structure for table `t_car`
--

DROP TABLE IF EXISTS `t_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_car` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `car_name` varchar(500) DEFAULT NULL COMMENT 'Car name',
  `car_driver` varchar(500) DEFAULT NULL COMMENT 'Driver''s name',
  `car_phone` varchar(500) DEFAULT NULL COMMENT 'Driver''s phone',
  `car_status` varchar(500) DEFAULT NULL COMMENT 'Car status:Shipping/Free',
  `car_text` varchar(500) DEFAULT NULL COMMENT 'Comment',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='Car';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_car`
--

LOCK TABLES `t_car` WRITE;
/*!40000 ALTER TABLE `t_car` DISABLE KEYS */;
INSERT INTO `t_car` VALUES (1,'c005','Denver','13588888888','Shipping','Normal');
/*!40000 ALTER TABLE `t_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_notice`
--

DROP TABLE IF EXISTS `t_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_notice` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `notice_name` varchar(500) DEFAULT NULL COMMENT 'Title',
  `notice_text` varchar(500) DEFAULT NULL COMMENT 'Content',
  `notice_type` varchar(500) DEFAULT NULL COMMENT 'Type',
  `create_date` varchar(500) DEFAULT NULL COMMENT 'Create time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='Notice';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_notice`
--

LOCK TABLES `t_notice` WRITE;
/*!40000 ALTER TABLE `t_notice` DISABLE KEYS */;
INSERT INTO `t_notice` VALUES (1,'System is released','You can check notice here','Information','1970-08-21 01:01:01');
/*!40000 ALTER TABLE `t_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `order_receiver` varchar(500) DEFAULT NULL COMMENT 'Receiver''s name',
  `order_rphone` varchar(500) DEFAULT NULL COMMENT 'Receiver''s phone',
  `order_raddress` varchar(500) DEFAULT NULL COMMENT 'Receiver''s address',
  `order_sender` varchar(500) DEFAULT NULL COMMENT 'Sender''s name',
  `order_sphone` varchar(500) DEFAULT NULL COMMENT 'Sender''s phone',
  `order_saddress` varchar(500) DEFAULT NULL COMMENT 'Sender''s address',
  `order_carno` varchar(500) DEFAULT NULL COMMENT 'Car''s number',
  `order_status` varchar(500) DEFAULT NULL COMMENT 'Status:Shipping/Finish',
  `order_date` varchar(500) DEFAULT NULL COMMENT 'Order time',
  `order_text` varchar(500) DEFAULT NULL COMMENT 'Comment',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='Order';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (1,'Bill','13588888888','Xiamen university','James','13688888888','Peking university','c005','Shipping','2025-10-03','Normal');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `username` varchar(500) DEFAULT NULL COMMENT 'User''s name',
  `password` varchar(500) DEFAULT NULL COMMENT 'Passport',
  `real_name` varchar(500) DEFAULT NULL COMMENT 'User''s real name',
  `user_gender` varchar(500) DEFAULT NULL COMMENT 'Gender:Male/Female',
  `user_phone` varchar(500) DEFAULT NULL COMMENT 'Phone number',
  `user_comment` varchar(500) DEFAULT NULL COMMENT 'Comment',
  `user_type` varchar(500) DEFAULT NULL COMMENT 'Type:Admin/User',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='User';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','123456','Rose','Female','13588888888','admin','Admin'),(2,'a','123456','Zach','Male','13855555555','admin','General users'),(7,'123','123','wqe','Female','dwq','eqweq','Admin');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'final_assignment'
--

--
-- Dumping routines for database 'final_assignment'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-26 13:53:46
