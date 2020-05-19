-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carportdb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `forespoergsel`
--

DROP TABLE IF EXISTS `forespoergsel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forespoergsel` (
  `idforespoergsel` int NOT NULL AUTO_INCREMENT,
  `carportlaengde` int NOT NULL,
  `carportbredde` int NOT NULL,
  `carportfarve` int NOT NULL,
  `carporttraetype` int NOT NULL,
  `tagmateriale` int NOT NULL,
  `taghaeldning` int NOT NULL,
  `redskabsrumbredde` int DEFAULT NULL,
  `redskabsrumlaengde` int DEFAULT NULL,
  `redskabsrumbeklaedningstype` int DEFAULT NULL,
  `redskabsrumgulv` int DEFAULT NULL,
  `kundeID` int NOT NULL,
  `pris` double DEFAULT NULL,
  PRIMARY KEY (`idforespoergsel`),
  KEY `fk_carport_bredde_idx` (`carportbredde`),
  KEY `fk_carport_laengde_idx` (`carportlaengde`),
  KEY `fk_carport_farve_idx` (`carportfarve`),
  KEY `fk_carport_traetype_idx` (`carporttraetype`),
  KEY `fk_tag_materiale_idx` (`tagmateriale`),
  KEY `fk_tag_haeldning_idx` (`taghaeldning`),
  KEY `fk_redskabsrum_bredde_idx` (`redskabsrumbredde`),
  KEY `fk_redskabsrum_laengde_idx` (`redskabsrumlaengde`),
  KEY `fk_redskabsrum_beklaedningstype_idx` (`redskabsrumbeklaedningstype`),
  KEY `fk_kundeID_idx` (`kundeID`),
  KEY `fk_kunde_Id_idx` (`kundeID`),
  KEY `fkadl_idx` (`kundeID`),
  KEY `fk_gulv_idx` (`redskabsrumgulv`),
  CONSTRAINT `fk_carport_bredde` FOREIGN KEY (`carportbredde`) REFERENCES `bredder` (`idbredder`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_carport_farve` FOREIGN KEY (`carportfarve`) REFERENCES `farver` (`idfarver`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_carport_laengde` FOREIGN KEY (`carportlaengde`) REFERENCES `laengder` (`idlaengder`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_carport_traetype` FOREIGN KEY (`carporttraetype`) REFERENCES `traetyper` (`idtraetyper`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_gulv` FOREIGN KEY (`redskabsrumgulv`) REFERENCES `gulv` (`idGulv`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_kundeid` FOREIGN KEY (`kundeID`) REFERENCES `kunde` (`kundeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_redskabsrum_beklaedningstype` FOREIGN KEY (`redskabsrumbeklaedningstype`) REFERENCES `traetyper` (`idtraetyper`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_redskabsrum_bredde` FOREIGN KEY (`redskabsrumbredde`) REFERENCES `bredder` (`idbredder`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_redskabsrum_laengde` FOREIGN KEY (`redskabsrumlaengde`) REFERENCES `laengder` (`idlaengder`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tag_haeldning` FOREIGN KEY (`taghaeldning`) REFERENCES `haeldning` (`idhaeldning`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tag_materiale` FOREIGN KEY (`tagmateriale`) REFERENCES `tagmateriale` (`idtagmateriale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forespoergsel`
--

LOCK TABLES `forespoergsel` WRITE;
/*!40000 ALTER TABLE `forespoergsel` DISABLE KEYS */;
INSERT INTO `forespoergsel` VALUES (6,21,19,1,1,16,8,20,22,7,4,7,14437.5),(7,21,19,1,1,16,8,1,1,1,1,7,1254.55),(8,20,19,1,1,16,8,20,22,7,4,7,14118.75),(9,20,19,1,1,16,8,1,1,1,1,7,4544),(10,19,19,1,1,16,8,1,1,1,1,8,14800),(11,1,1,1,1,16,8,20,22,7,4,9,1002),(12,1,1,1,1,16,8,20,22,7,4,10,4436.25),(13,21,19,1,1,16,8,9,6,1,1,8,17387.5),(14,21,19,1,1,12,4,19,8,1,1,11,25000),(15,19,19,2,4,13,4,19,9,4,2,9,54556),(16,19,16,1,1,16,8,1,1,1,1,12,13864),(17,18,16,1,1,16,8,1,1,1,1,11,13565.5),(18,18,16,1,1,16,8,1,1,1,1,11,13565.5),(19,18,16,1,1,16,8,20,22,7,4,7,12565.5),(20,21,19,1,1,1,7,19,9,1,1,7,21950),(21,21,18,1,1,16,8,18,1,1,1,13,17662),(22,20,19,4,5,16,8,10,9,1,1,7,17668.75);
/*!40000 ALTER TABLE `forespoergsel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-19 13:40:19
