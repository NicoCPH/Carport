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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forespoergsel`
--

LOCK TABLES `forespoergsel` WRITE;
/*!40000 ALTER TABLE `forespoergsel` DISABLE KEYS */;
INSERT INTO `forespoergsel` VALUES (25,21,19,1,1,16,8,1,1,1,1,14,15437.5),(26,21,19,1,1,16,8,1,1,1,1,15,14582),(27,21,19,1,1,16,8,1,1,1,1,15,15437.5),(28,21,19,1,1,16,8,1,1,1,1,15,15437.5),(29,21,19,1,1,16,8,20,22,7,4,15,14437.5);
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

-- Dump completed on 2020-05-20 11:28:49
