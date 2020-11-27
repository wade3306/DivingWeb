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
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `info` (
  `infoNum` int(11) NOT NULL AUTO_INCREMENT,
  `infoCity` varchar(45) COLLATE utf8_bin NOT NULL,
  `infoArea` varchar(45) COLLATE utf8_bin NOT NULL,
  `infoType` varchar(45) COLLATE utf8_bin NOT NULL,
  `infoShop` varchar(45) COLLATE utf8_bin NOT NULL,
  `infoWebside` varchar(1000) COLLATE utf8_bin NOT NULL,
  `infoAddress` varchar(45) COLLATE utf8_bin NOT NULL,
  `infoPhone` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`infoNum`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES (1,'屏東','恆春','餐廳','輝哥生魚片','NA','946屏東縣恆春鎮大光路79-53號','0932 757 776'),(2,'屏東','恆春','餐廳','麋谷','NA','946屏東縣恆春鎮恆南路2巷1號之1號','0903 122 862'),(3,'屏東','恆春','飯店','墾丁凱撒大飯店','https://kenting.caesarpark.com.tw/','94644屏東縣恆春鎮墾丁路6號','08 886 1888'),(4,'屏東','恆春','飯店','悠活度假村','https://www.yoho.com.tw/zh-tw','946屏東縣恆春鎮萬里路27-8號','08 886 9999'),(5,'屏東','恆春','餐廳','波波廚房','https://www.facebook.com/pages/category/Italian-Restaurant/%E6%B3%A2%E6%B3%A2%E5%BB%9A%E6%88%BF-Kitchen-Swell-1446837075557721/','946屏東縣恆春鎮光明路88號','08 889 6575'),(6,'屏東','恆春','餐廳','樹夏飲事','https://www.facebook.com/glasshousekt/','946屏東縣恆春鎮恆西路12-21號','NA'),(7,'屏東','恆春','飯店','承億文旅-墾丁雅客小半島','https://www.hotelday.com.tw/hotel07.aspx','946屏東縣恆春鎮墾丁路237號','08 886 1272'),(8,'屏東','恆春','飯店','日和灣居 Sunshine Liv.','https://www.facebook.com/ktsunshineliving/','946屏東縣恆春鎮南灣路48號','08 888 3663'),(9,'屏東','恆春','飯店','墾丁H會館','https://h-resort.com/','94352屏東縣獅子鄉竹坑巷60號','08 877 1888'),(10,'屏東','恆春','餐廳','山下人家','NA','946屏東縣恆春鎮山腳路64之1號','0981 944 133'),(11,'新北','萬里','餐廳','巧晏漁坊','https://www.facebook.com/Ivyfish0205/','207新北市萬里區漁澳路62-1號','02 24926999'),(12,'新北','萬里','餐廳','珍如意海鮮餐廳','NA','207新北市萬里區漁澳路2號','02 24928218'),(13,'新北','萬里','餐廳','海洋咖啡','https://yehliu.inhousehotel.com/dinning/cafe/','20744新北市萬里區港東路162之2號1樓','02 77035757'),(14,'新北','雙溪','飯店','小鳥敲門度假屋','https://bed-and-breakfast-1169.business.site/','227新北市雙溪區新基東街15之3號','0912 034649'),(15,'新北','貢寮','飯店','逸閒居民宿','http://www.theeasyspace.com.tw/','228新北市貢寮區福連街38號','0988 339 803'),(16,'新北','貢寮','飯店','福容大飯店(福隆)','http://www.fullon-hotels.com.tw/fl','228新北市貢寮區福隆街41號','02 24991188'),(17,'新北','貢寮','飯店','莫瑞納海灣會館','https://www.facebook.com/marinabay.resort/','228新北市貢寮區仁愛路106巷36號','02 24903955'),(18,'新北','貢寮','餐廳','菈莉帕帕','https://www.facebook.com/lollipapa.co/?modal=admin_todo_tour','228新北市貢寮區龍洞街32號','NA'),(19,'新北','瑞芳','餐廳','綠色豆子','https://facebook.com/Greenbeans808/','224新北市瑞芳區南雅路91號','0938 717 930'),(20,'新北','瑞芳','餐廳','黑炫蔬食','https://www.facebook.com/actioncoffe/?ref=page_internal','22451新北市瑞芳區洞頂路149號','0919 437 048'),(21,'新北','瑞芳','餐廳','坑口的天空','https://www.facebook.com/kengkou.okgo/','224新北市瑞芳區長仁路38號','02 24961488'),(22,'新北','瑞芳','飯店','魚礁十五號民宿','http://www.fishhome15.com/','224新北市瑞芳區建基路二段15號2樓','0908 203 789'),(23,'宜蘭','頭城','飯店','候鳥旅宿','https://www.facebook.com/migratorybirds317/','261宜蘭縣頭城鎮濱海路六段317號','0989 882990'),(24,'蘭嶼','朗島','餐廳','角落 Bais 咖啡','\nwww.facebook.Bais.com.tw','台東縣蘭嶼鄉朗島69-1號','NA'),(25,'蘭嶼','漁人','餐廳','蘭嶼漂流木餐廳','https://www.facebook.com/%E8%98%AD%E5%B6%BC%E6%BC%82%E6%B5%81%E6%9C%A8%E9%A4%90%E5%BB%B3-276401059133797/?ref=ts&fref=ts','\n台東縣蘭嶼鄉漁人村24-2號','08 973 2668'),(26,'蘭嶼','漁人','餐廳','蘭嶼無餓不坐','https://www.facebook.com/LanyuRestaurant/','台東縣蘭嶼鄉漁人77號','\n08 973 1623'),(27,'蘭嶼','紅頭','餐廳','蘭嶼雯雯芋頭冰','https://www.facebook.com/Lanyuwenwen/','952台東縣蘭嶼鄉20號','912075399'),(28,'蘭嶼','紅頭','餐廳','阿力給早餐店','https://www.facebook.com/pages/%E9%98%BF%E5%8A%9B%E7%B5%A6%E6%97%A9%E9%A4%90%E5%BA%97/216638441685165?fref=ts','台東縣蘭嶼鄉紅頭村紅頭村紅頭29號','0911 369 657'),(29,'蘭嶼','東清','餐廳','美亞美早餐店','https://www.facebook.com/%E7%BE%8E%E4%BA%9E%E7%BE%8E%E6%97%A9%E9%A4%90%E6%99%A8%E6%9B%A6%E6%B0%91%E5%AE%BF-%E8%98%AD%E5%B6%BC%E6%9D%B1%E6%B8%85%E6%9D%91-425013074196857/','台東市蘭嶼鄉東清村1鄰東清23-1號','08 9732949'),(30,'蘭嶼','椰油','餐廳','島民冰狗店','https://www.instagram.com/daominlanyu/','台東縣蘭嶼鄉椰油村椰油296-7號','0975-667-868'),(31,'蘭嶼','椰油','餐廳','有一間燒烤','https://www.facebook.com/bbq732008/','台東縣蘭嶼鄉椰油村296之4號','89732008'),(32,'蘭嶼','紅頭','飯店','碧海蘭天','https://m.facebook.com/%E8%98%AD%E5%B6%BC%E7%A2%A7%E6%B5%B7%E8%98%AD%E5%A4%A9%E6%B0%91%E5%AE%BF-771841459523275/','台東縣蘭嶼鄉紅頭村1鄰紅頭1之4號','910558337'),(33,'蘭嶼','紅頭','飯店','藍海汙潛水渡假村','https://www.boh.com.tw/','台東縣蘭嶼鄉紅頭村1-8號','988331116'),(34,'綠島','公館','飯店','享綠島','https://www.bali-hotel.com.tw/greenisland/','台東縣綠島鄉公館村2-10號','089-672799'),(35,'綠島','公館','飯店','綠島‧微風民宿','https://breeze.okgo.tw/','台東縣綠島鄉公館村柴口58之1號','089-671617'),(36,'綠島','南寮','飯店','綠島凱薪飯店','https://kaihsing.okgo.tw/','台東縣綠島鄉南寮村102-12號　','089-672033'),(37,'綠島','公館','餐廳','海邊坐坐','https://www.facebook.com/greenislandseaside/','綠島鄉公館村67號','0988-424-420'),(38,'綠島','公館','餐廳','綠島 只有海 島嶼風格餐廳','https://www.facebook.com/pg/ourocean.greenisland/menu/?ref=page_internal','台東縣綠島鄉公館村溫泉聚落','0961 057 826'),(39,'綠島','南寮','餐廳','流浪綠境','https://zh-tw.facebook.com/OASIS671580','台東市綠島鄉中寮村中寮46號','08-9671580'),(40,'綠島','南寮','餐廳','see sea toast','https://www.facebook.com/seeseatoast/','台東縣綠島鄉南寮村9鄰120號','0918 793 789'),(41,'綠島','南寮','餐廳','冰獄','https://www.facebook.com/icejail1020/','綠島鄉南寮漁港48號','0919 400 503'),(42,'綠島','南寮','餐廳','非炒不可','https://www.facebook.com/crazyfried/?hc_ref=ARQr1oh_CDgtxJg2G7Oo_mtgslDqh470rgvD75JG6x9InmK-J98y5SeAJCBrgqP_PI4&ref=nf_target&__tn__=kC-R','台東縣綠島鄉南寮村10鄰126號','08 967 1057'),(43,'綠島','南寮','餐廳','綠堤咖啡館','https://breeze.okgo.tw/scenic.html#menu','台東縣綠島鄉南寮村漁港31號','089-672880');
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
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
