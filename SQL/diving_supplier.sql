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
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supplierNum` int(11) NOT NULL AUTO_INCREMENT,
  `supplierId` varchar(45) COLLATE utf8_bin NOT NULL,
  `supplierPassword` varchar(45) COLLATE utf8_bin NOT NULL,
  `supplierName` varchar(45) COLLATE utf8_bin NOT NULL,
  `supplierMail` varchar(45) COLLATE utf8_bin NOT NULL,
  `supplierPhone` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`supplierNum`),
  UNIQUE KEY `supplierId_UNIQUE` (`supplierId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'divingTest','1234','我是商家','123@123','12345678'),(2,'divingTest2','2222','我是商家2','ZZZZ@ZZ','555-55555'),(3,'liontravel','liontravel','雄獅旅行社','EnglishService@liontravel.com','02-87939000'),(4,'kkday','kkday','酷遊天國際旅行社','service@kkday.com','0971-532-770'),(5,'klook','klook','客遊天下旅行社','service@klook.com','02-89798168'),(6,'divecube','divecube','潛立方旅館','hotel@divecube.com.tw','04-2355-2208'),(7,'taiwandive','taiwandive','台灣潛水','service@taiwandive.com','08-8867082'),(8,'joytravel','joytravel','和悅國際(潛⽔)旅⾏社','service@joytravel.com.tw','02-8751-5958'),(9,'DIVINGMONKEY','DIVINGMONKEY','潛水猴','gordon@lyons.com.tw','0921-740738'),(10,'asiayo','asiayo','亞揪遊旅行社','customer_tw@asiayo.com','03-9321090   ');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-16 17:03:51
