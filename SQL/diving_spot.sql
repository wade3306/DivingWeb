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
-- Table structure for table `spot`
--

DROP TABLE IF EXISTS `spot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spot` (
  `spotNum` int(11) NOT NULL AUTO_INCREMENT,
  `spotName` varchar(45) NOT NULL,
  `spotCity` varchar(45) NOT NULL,
  `spotArea` varchar(45) NOT NULL,
  `spotType` varchar(45) NOT NULL,
  `spotOther` varchar(100) NOT NULL,
  PRIMARY KEY (`spotNum`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spot`
--

LOCK TABLES `spot` WRITE;
/*!40000 ALTER TABLE `spot` DISABLE KEYS */;
INSERT INTO `spot` VALUES (1,'薰衣草森林','澎湖','望安','深潛','軸孔珊瑚 表孔珊瑚 鸚哥魚 雀鯛'),(2,'東吉之狼','澎湖','望安','深潛','梭魚群 魟魚'),(3,'西吉斷層','澎湖','望安','深潛','海扇林 玻璃魚群'),(4,'鐘仔礁','澎湖','望安','深潛','刺尾鯛 圓眼燕魚 烏尾? 七星斑'),(5,'東吉港內','澎湖','望安','浮潛','鹿角珊瑚 小海膽 鸚鵡魚 親子池'),(6,'凌雲艦','澎湖','七美','深潛','沈船 大理石魟 黃雞魚群'),(7,'東西吉廊道','澎湖','望安','深潛','烏尾?群 黃雞魚群'),(8,'雙峰藍洞','屏東','恆春','深潛','珊瑚礁 沈船 藍洞'),(9,'獨立礁','屏東','恆春','深潛','珊瑚礁 藍洞'),(10,'出水口','屏東','恆春','深潛','珊瑚礁 沈船&飛機 藍洞'),(11,'後壁軟珊瑚區','屏東','恆春','深潛','珊瑚礁 藍洞'),(12,'萬里桐','屏東','恆春','深潛 浮淺','珊瑚礁 海藻林'),(13,'花園北側','屏東','恆春','深潛','珊瑚礁 藍洞'),(14,'跳石','屏東','恆春','深潛','珊瑚礁 峭壁'),(15,'紅柴坑','屏東','恆春','深潛','珊瑚礁 峭壁'),(16,'船帆石','屏東','恆春','深潛','珊瑚礁 洞穴'),(17,'潭仔','屏東','恆春','深潛','珊瑚礁 沈船&飛機 藍洞'),(18,'杉福漁港','琉球','琉球','深潛','沈船 峭壁'),(19,'朗島秘境','蘭嶼','朗島','浮潛','珊瑚礁 世界第11名的浮潛聖地'),(20,'玉女岩外礁','蘭嶼','朗島','深潛','珊瑚礁 沈船 峭壁 藍洞 水族館'),(21,'軍艦岩','蘭嶼','朗島','深潛','軍艦 魚群種類多 海扇走廊'),(22,'雙獅岩','蘭嶼','朗島','深潛','珊瑚生態 牛港? 海龜 海蛇'),(23,'八代灣沈船','蘭嶼','漁人','深潛','沉船 珊瑚 烏尾? 鮪魚 燕魚'),(24,'機場外礁','蘭嶼','漁人','深潛','獨立礁石 水中花園 軟硬珊瑚'),(25,'海底拱門','蘭嶼','漁人','深潛','珊瑚 海底拱門 砂質'),(26,'椰油斷層','蘭嶼','椰油','深潛','小丑魚 珊瑚 拳擊蟹 長臂蝦 大眼鯛'),(27,'開元港藍洞','蘭嶼','椰油','深潛','海底斷層 珊瑚 礫石沙岸'),(28,'鋼鐵礁','綠島','南寮','深潛','珊瑚礁 沈船 藍洞 礦坑 遺跡'),(29,'石朗','綠島','南寮','深潛','海馬郵筒 環狀珊瑚礁 條紋豆娘魚 活體團塊微孔珊瑚'),(30,'柴口','綠島','中寮','深潛','石珊瑚'),(31,'大白沙','綠島','南寮','深潛','潛水步道'),(32,'秘境藍洞','綠島','公館','浮潛','裙狀珊瑚礁'),(33,'基隆嶼','基隆','中山','深潛','珊瑚礁 沈船 飛機 峭壁'),(34,'外木山','基隆','中山','深潛','珊瑚礁 沈船 飛機 峭壁 泥巴 人造景點'),(35,'松山運動中心','台北','松山','深潛','冰潛'),(36,'龜吼','新北','萬里','深潛','珊瑚礁 沈船 飛機 泥巴 人造景點'),(37,'深澳漁港','新北','瑞芳','深潛','珊瑚礁 沈船 飛機 峭壁 泥巴'),(38,'水晶宮','新北','瑞芳','深潛','珊瑚礁 峭壁 泥巴'),(39,'龍洞1號','新北','貢寮','深潛','珊瑚礁 沈船 飛機 峭壁 泥巴 人造景點 水道 海藻林'),(40,'龍洞1.5號','新北','貢寮','深潛','珊瑚礁 沈船 飛機 峭壁 泥巴 人造景點 水道 河流機'),(41,'龍洞2號','新北','貢寮','深潛','珊瑚礁 沈船 飛機 峭壁 泥巴 人造景點'),(42,'龍洞3號','新北','貢寮','深潛','珊瑚礁 沈船 飛機 峭壁 泥巴'),(43,'龍洞4號','新北','貢寮','深潛','珊瑚礁 沈船 飛機 峭壁 泥巴 人造景點 石灰岩洞 藍洞 礦坑 採石場 水族館 洞穴 水道 海藻林'),(44,'四季灣','新北','貢寮','深潛','珊瑚礁 峭壁 泥巴 人造景點 水道'),(45,'和美89K','新北','貢寮','深潛','珊瑚礁 沉船 飛機 峭壁 泥巴 水族館 最高 水道 海藻林'),(46,'金沙灣','新北','貢寮','深潛','珊瑚礁 峭壁 泥巴 人造景點'),(47,'美艷山','新北','貢寮','深潛','珊瑚礁 沉船 飛機 峭壁 泥巴 人造景點 礦坑 採石場 水族館 水道'),(48,'桂安漁港','新北','貢寮','深潛','珊瑚礁 峭壁 泥巴'),(49,'小香蘭','新北','貢寮','深潛','珊瑚礁 泥巴'),(50,'卯澳灣','新北','貢寮','深潛','珊瑚礁'),(51,'龜山島','宜蘭','頭城','深潛','珊瑚礁 峭壁 泥巴 石灰岩洞 藍洞'),(52,'碉堡下','宜蘭','頭城','深潛','珊瑚礁 泥巴'),(53,'龜卵','宜蘭','頭城','深潛','珊瑚礁 沈船 飛機 峭壁'),(54,'龜首','宜蘭','頭城','深潛','珊瑚礁 泥巴 石灰岩洞 藍洞 礦坑 採石場'),(55,'蘭城','宜蘭','蘭城','深潛','珊瑚礁 沈船 飛機 人造景點'),(56,'居庸艦','宜蘭','蘇澳','深潛','沈船'),(57,'粉鳥林','宜蘭','蘇澳','深潛','珊瑚礁 沈船 飛機 峭壁 泥巴'),(58,'潛立方','台中','西屯','深潛','人造景點');
/*!40000 ALTER TABLE `spot` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-13 17:40:59
