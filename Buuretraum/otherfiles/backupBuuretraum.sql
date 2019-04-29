-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: buuretraum
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `buuretraum`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `buuretraum` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `buuretraum`;

--
-- Table structure for table `farm`
--

DROP TABLE IF EXISTS `farm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `farm` (
  `idFarm` int(11) NOT NULL AUTO_INCREMENT,
  `Player_idPlayer` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`idFarm`),
  KEY `fk_Farm_Player_idx` (`Player_idPlayer`),
  CONSTRAINT `fk_Farm_Player` FOREIGN KEY (`Player_idPlayer`) REFERENCES `player` (`idPlayer`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farm`
--

LOCK TABLES `farm` WRITE;
/*!40000 ALTER TABLE `farm` DISABLE KEYS */;
INSERT INTO `farm` VALUES (1,3,'testfarm'),(2,3,'number2farm'),(3,3,'number3farm'),(4,3,'farm4'),(5,3,'farm5');
/*!40000 ALTER TABLE `farm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plant`
--

DROP TABLE IF EXISTS `plant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plant` (
  `idPlant` int(11) NOT NULL,
  `PlantType_idPlantType` int(11) NOT NULL,
  `Growstage` int(11) NOT NULL,
  PRIMARY KEY (`idPlant`),
  KEY `fk_Plant_PlantType1_idx` (`PlantType_idPlantType`),
  CONSTRAINT `fk_Plant_PlantType1` FOREIGN KEY (`PlantType_idPlantType`) REFERENCES `planttype` (`idPlantType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant`
--

LOCK TABLES `plant` WRITE;
/*!40000 ALTER TABLE `plant` DISABLE KEYS */;
/*!40000 ALTER TABLE `plant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plantplot`
--

DROP TABLE IF EXISTS `plantplot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plantplot` (
  `idPlantPlot` int(11) NOT NULL AUTO_INCREMENT,
  `Farm_idFarm` int(11) NOT NULL,
  `Plant_idPlant` int(11) NOT NULL,
  PRIMARY KEY (`idPlantPlot`),
  KEY `fk_PlantPlot_Farm1_idx` (`Farm_idFarm`),
  KEY `fk_PlantPlot_Plant1_idx` (`Plant_idPlant`),
  CONSTRAINT `fk_PlantPlot_Farm1` FOREIGN KEY (`Farm_idFarm`) REFERENCES `farm` (`idFarm`),
  CONSTRAINT `fk_PlantPlot_Plant1` FOREIGN KEY (`Plant_idPlant`) REFERENCES `plant` (`idPlant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plantplot`
--

LOCK TABLES `plantplot` WRITE;
/*!40000 ALTER TABLE `plantplot` DISABLE KEYS */;
/*!40000 ALTER TABLE `plantplot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planttype`
--

DROP TABLE IF EXISTS `planttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `planttype` (
  `idPlantType` int(11) NOT NULL,
  `plantname` varchar(45) NOT NULL,
  PRIMARY KEY (`idPlantType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planttype`
--

LOCK TABLES `planttype` WRITE;
/*!40000 ALTER TABLE `planttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `planttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `player` (
  `idPlayer` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(800) NOT NULL,
  PRIMARY KEY (`idPlayer`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,'testadmin','pw1234'),(2,'testuser','password'),(3,'test','$s0$41010$tjlC8p+8qtfe8zNnyuS29Q==$/zBwv2/WEW09X2uZuNqP1kIC5jckIBSX4opDB4kWudA=');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-29 13:14:57
