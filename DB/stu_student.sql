-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: stu
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `id` varchar(10) NOT NULL DEFAULT ' ',
  `name` varchar(10) NOT NULL DEFAULT ' ',
  `attendance` varchar(10) NOT NULL DEFAULT ' ',
  `midscore` varchar(10) NOT NULL DEFAULT ' ',
  `finalscore` varchar(10) NOT NULL DEFAULT ' ',
  `homework` varchar(10) NOT NULL DEFAULT ' ',
  `quiz` varchar(10) NOT NULL DEFAULT ' ',
  `announcement` varchar(10) NOT NULL DEFAULT ' ',
  `report` varchar(10) NOT NULL DEFAULT ' ',
  `other` varchar(10) NOT NULL DEFAULT ' ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('20306020','이성규투','30','50','100','30','90','80','40','50'),('30203203','김진현','20','30','50','10','20','30','40','50'),('332244','라니','20','30','10','50','50','100','100','30'),('33442233','나은이','50','50','50','50','50','50','50','50'),('60083029','구구가','30','20','20','40','40','50','10','100'),('60102295','가나다','20','30','40','10','10','20','40','30'),('60123333','잠만보','30','40','50','10','20','30','30','30'),('60125534','종이한장','0','40','100','90','10','10','10','10'),('60132233','바보','50','100','100','100','100','100','100','100'),('60132295','돼지','100','80','70','90','98','95','100','100'),('60141123','꿀꿀이','60','80','50','60','90','20','100','100'),('60142275','민경재','90','100','80','90','95','100','100','40'),('60204342','민','10','30','40','20','30','40','10','20'),('60223349','가나다','30','20','50','60','70','20','30','40'),('6022434','이성규','20','30','40','50','100','30','20','10'),('6022894','신짱','30','40','50','60','70','100','100','100'),('60243322','민경','30','40','10','50','60','100','100','100'),('60243344','정천우','30','40','10','20','30','30','10','30'),('60243349','밥팅이','30','20','40','40','40','40','30','20'),('60305040','종이두장','30','50','90','80','70','40','20','100'),('60332244','건후','20','30','10','50','60','10','20','30'),('603390','허애리','0','100','50','10','10','10','10','10'),('60552233','강아지','20','30','30','30','30','30','30','30'),('60594432','양치','60','60','60','60','60','60','60','60'),('77113322','라플라스','20','30','50','10','10','10','30','20');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-11  9:42:45
