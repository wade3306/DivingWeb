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
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `tourNum` int(11) NOT NULL AUTO_INCREMENT,
  `supplierNum` int(11) NOT NULL,
  `tourName` varchar(45) COLLATE utf8_bin NOT NULL,
  `tourPrice` int(11) NOT NULL,
  `tourSize` int(11) NOT NULL,
  `tourFood` varchar(1000) COLLATE utf8_bin NOT NULL,
  `tourMotel` varchar(1000) COLLATE utf8_bin NOT NULL,
  `tourTraffic` varchar(1000) COLLATE utf8_bin NOT NULL,
  `tourShow` varchar(1000) COLLATE utf8_bin NOT NULL,
  `tourWebsite` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`tourNum`),
  KEY `supplierNum_idx` (`supplierNum`),
  CONSTRAINT `supplierNum` FOREIGN KEY (`supplierNum`) REFERENCES `supplier` (`supplierNum`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,1,'潛水',2000,2,'早中晚','路邊','火車','上架(前端看的到)','https://www.dive.com'),(2,1,'潛水',3000,5,'早中晚','海邊','船','下架(前端看不到)','https://www.dive.com'),(3,4,'龍洞 SUP 板＆浮潛活動',1600,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/21735?cid=2003&ud1=68410&ud2=21735'),(4,4,'龍洞PADI 開放水域潛水員課程 ',11000,2,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/21572?cid=2003&ud1=68410&ud2=21572'),(5,4,'龍洞自由潛水 AIDA1 證照班',6500,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/21560?cid=2003&ud1=68410&ud2=21560'),(6,4,'墾丁SUP 立槳＆浮潛體驗',1850,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/22110?cid=2003&ud1=68410&ud2=22110'),(7,4,'墾丁水肺潛水體驗',2500,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/38162?cid=2003&ud1=68410&ud2=38162'),(8,4,'小琉球花瓶岩浮潛＆海龜共游＆水下拍攝',240,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/23499?cid=2003&ud1=68410&ud2=23499'),(9,4,'小琉球海洋潛水體驗',2000,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/23476?cid=2003&ud1=68410&ud2=23476'),(10,4,'綠島藍洞秘境探險',600,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/24844?cid=2003&ud1=68410&ud2=24844'),(11,4,'綠島海洋潛水體驗',2450,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/22226?cid=2003&ud1=68410&ud2=22226'),(12,4,'蘭嶼海洋浮潛體驗',500,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/21339?cid=2003&ud1=68410&ud2=21339'),(13,4,'蘭嶼專業體驗潛水一對一教學',2500,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/21343'),(14,4,'澎湖海洋浮潛＆海底郵筒寄明信片',600,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/19485?cid=2003&ud1=68410&ud2=19485'),(15,4,'澎湖海底體驗潛水＆水下拍攝',2600,1,'NA','NA','NA','上架','https://www.kkday.com/zh-tw/product/24871?cid=2003&ud1=68410&ud2=24871'),(16,5,'墾丁南灣外海平台式潛水體驗',2784,1,'NA','NA','NA','上架','https://www.klook.com/zh-TW/activity/3394-discovery-dive-floating-platform-kenting/#krt=s30&krid=92495fbc-db64-4076-45a6-9030573038ad'),(17,5,'台中潛立方旅館室內潛水',1988,1,'NA','NA','NA','上架','https://www.klook.com/zh-TW/activity/5485-divecube-diving-experience-taichung/#krt=s30&krid=92495fbc-db64-4076-45a6-9030573038ad'),(18,5,'澎湖忘憂島水上活動一日遊',3200,1,'中','NA','NA','上架','https://www.klook.com/zh-TW/activity/3604-marine-national-park-tour-penghu/#krt=s30&krid=92495fbc-db64-4076-45a6-9030573038ad'),(19,5,'綠島島潛潛水',2350,1,'NA','NA','NA','上架','https://www.klook.com/zh-TW/activity/3786-discover-diving-green-island-taitung/#krt=s30&krid=92495fbc-db64-4076-45a6-9030573038ad'),(20,5,'蘭嶼潛水體驗',2450,1,'NA','NA','NA','上架','https://www.klook.com/zh-TW/activity/3775-discover-diving-lanyu-taitung/#krt=s30&krid=92495fbc-db64-4076-45a6-9030573038ad'),(21,5,'綠島進階深潛體驗',3185,1,'NA','NA','NA','上架','https://www.klook.com/zh-TW/activity/3795-boat-dive-green-island-taitung/#krt=s30&krid=92495fbc-db64-4076-45a6-9030573038ad'),(22,5,'澎湖七美島浮潛 & 獨木舟一日遊',1300,1,'NA','NA','NA','上架','https://www.klook.com/zh-TW/activity/1087-chimei-motorbike-snorkel-day-trip/#krt=s30&krid=92495fbc-db64-4076-45a6-9030573038ad'),(23,5,'墾丁開放水域岸潛潛水體驗',2240,1,'NA','NA','飯店接駁','上架','https://docs.google.com/spreadsheets/d/1DsJfPv1HmsVR1Lc9_B--I56OueYJeDzOGPYo34Z85Eg/edit#gid=0'),(24,5,'小琉球與海龜共遊潛水體驗',2275,1,'NA','NA','NA','上架','https://www.klook.com/zh-TW/activity/561-discover-scuba-diving-kenting/#krt=s30&krid=65c1c6c7-e6c3-4365-7a5d-6ed71a4f3ddd'),(25,5,'龍洞四季灣潛水體驗',2000,1,'NA','NA','NA','上架','https://www.klook.com/zh-TW/activity/35074-four-seasons-bay-diving-experience-longdong/#krt=s30&krid=4bb504be-3927-420c-7307-68205554c536'),(26,7,'墾丁PADI 浮潛',600,1,'NA','NA','NA','上架','https://www.taiwan-dive.com/blank-12'),(27,7,'墾丁體驗潛水',2500,1,'NA','NA','NA','上架','https://www.taiwan-dive.com/discover-scuba-diving'),(28,7,'墾丁PADI開放水域潛水員課程 岸潛班',13000,3,'中','NA','NA','上架','https://www.taiwan-dive.com/openwater-shoredive'),(29,7,'墾丁PADI開放水域潛水員課程 船潛班',15000,4,'中','NA','船','上架','https://www.taiwan-dive.com/openwater-boatdive'),(30,8,'探索蘭嶼潛水3天',18900,3,'早中晚','古魯⺠宿','船','上架','https://www.joytravel.com.tw/product_d.php?lang=tw&tb=1&id=7482'),(31,8,'探索台灣之綠島潛⽔趣',20000,3,'早中晚','海洋之家','火車 船','上架','https://www.joytravel.com.tw/product_d.php?lang=tw&tb=1&id=7312'),(32,9,'墾丁潛水(3天2夜)無限岸潛專案',3800,3,'NA','民宿','NA','上架','https://www.eat-monkey.com/pd_view.asp?ID=2446'),(33,9,'小琉球潛水2天1夜',7800,2,'早中晚','民宿','船','上架','https://www.eat-monkey.com/pd_view.asp?ID=2444');
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-21 18:20:31
