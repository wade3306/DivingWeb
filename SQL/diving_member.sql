CREATE DATABASE  IF NOT EXISTS `diving` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `diving`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: diving
-- ------------------------------------------------------
-- Server version	5.6.49-log

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `memberNum` int(11) NOT NULL AUTO_INCREMENT,
  `memberId` varchar(45) COLLATE utf8_bin NOT NULL,
  `memberPassword` varchar(45) COLLATE utf8_bin NOT NULL,
  `memberName` varchar(45) COLLATE utf8_bin NOT NULL,
  `memberBirth` date NOT NULL,
  `memberMail` varchar(45) COLLATE utf8_bin NOT NULL,
  `memberPhone` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`memberNum`),
  UNIQUE KEY `memberId_UNIQUE` (`memberId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'QWER','1234','QUEEN','2020-11-13','123@456','123-456'),(2,'REWQ','4352','KINK','2010-10-01','456@123','456-123'),(3,'PPPP','1111','QOO','2000-01-01','5250@5050','5250-5050'),(4,'ALEX','ALEX','ALEX','1999-10-20','alex@yahoo.com.tw','0999099099'),(5,'VANN','VANN','VANN','2005-08-08','vann@gmail.com','0888088088'),(6,'RAINSOUND','RAINSOUND','RAINSOUND','2010-11-11','rainsound@yahoo.com.jp','0777077077'),(7,'YAYUAN','YAYUAN','YAYUAN','2010-10-10','yayuan@gmail.com','0666066066'),(8,'LITTLEJUAN','LITTLEJUAN','LITTLEJUAN','1995-07-07','littlejuan@yahoo.com','0555055055'),(9,'AXUN','AXUN','AXUN','1999-06-06','axun@google.com.uk','0333033033'),(10,'FEE','FEE','FEE','2000-01-01','fee@yahoo.com.fr','0222022022');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-21 12:55:54
