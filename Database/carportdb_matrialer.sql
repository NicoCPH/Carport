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
-- Table structure for table `matrialer`
--

DROP TABLE IF EXISTS `matrialer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matrialer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `beskrivelse` varchar(100) NOT NULL,
  `længde` double NOT NULL,
  `navn` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matrialer`
--

LOCK TABLES `matrialer` WRITE;
/*!40000 ALTER TABLE `matrialer` DISABLE KEYS */;
INSERT INTO `matrialer` VALUES (1,'45x195 Reglar',210,'Spær'),(2,'45x195 Reglar',240,'Spær'),(3,'45x195 Reglar',270,'Spær'),(4,'45x195 Reglar',300,'Spær'),(5,'45x195 Reglar',330,'Spær'),(6,'45x195 Reglar',360,'Spær'),(7,'45x195 Reglar',420,'Spær'),(8,'45x195 Reglar',450,'Spær'),(9,'45x195 Reglar',480,'Spær'),(10,'45x195 Reglar',510,'Spær'),(11,'45x195 Reglar',540,'Spær'),(12,'45x195 Reglar',570,'Spær'),(13,'45x195 Reglar',600,'Spær'),(14,'45x195 Reglar',630,'Spær'),(15,'45x195 Reglar',660,'Spær'),(16,'45x195 Reglar',690,'Spær'),(17,'45x195 Reglar',720,'Spær'),(18,'45x195 Reglar',750,'Spær'),(19,'45x195 Reglar',780,'Spær'),(20,'100x100 Trykimprægneret',100,'Stolpe'),(21,'45x195 Spærtræ',210,'Rem'),(22,'45x195 Spærtræ',240,'Rem'),(23,'45x195 Spærtræ',270,'Rem'),(24,'45x195 Spærtræ',300,'Rem'),(25,'45x195 Spærtræ',330,'Rem'),(26,'45x195 Spærtræ',360,'Rem'),(27,'45x195 Spærtræ',390,'Rem'),(28,'45x195 Spærtræ',420,'Rem'),(29,'45x195 Spærtræ',450,'Rem'),(30,'45x195 Spærtræ',480,'Rem'),(31,'45x195 Spærtræ',510,'Rem'),(32,'45x195 Spærtræ',540,'Rem'),(33,'45x195 Spærtræ',570,'Rem'),(34,'45x195 Spærtræ',600,'Rem'),(35,'45x195 Spærtræ',630,'Rem'),(36,'45x195 Spærtræ',660,'Rem'),(37,'45x195 Spærtræ',690,'Rem'),(38,'45x195 Spærtræ',720,'Rem'),(39,'45x195 Spærtræ',750,'Rem'),(40,'45x195 Spærtræ',780,'Rem'),(41,'19x100 Plast',100,'Tag'),(42,'30x30 Eternitag',30,'Tag'),(43,'30x30 Betonsten',30,'Tag');
/*!40000 ALTER TABLE `matrialer` ENABLE KEYS */;
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
