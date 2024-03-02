-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: football1
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allenatori`
--

DROP TABLE IF EXISTS `allenatori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allenatori` (
  `id` int DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  KEY `id` (`id`),
  CONSTRAINT `allenatori_ibfk_1` FOREIGN KEY (`id`) REFERENCES `persone` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allenatori`
--

LOCK TABLES `allenatori` WRITE;
/*!40000 ALTER TABLE `allenatori` DISABLE KEYS */;
INSERT INTO `allenatori` VALUES (111,'cmcgowran0','5678'),(112,'khartley1','3456'),(113,'efanshaw2','8901'),(114,'cbate3','5678'),(115,'dpitt4','8901'),(116,'ccondon5','7890'),(117,'tcrilly6','4567'),(118,'fcuredell7','0123'),(119,'adouthwaite8','3456'),(120,'khuxstep9','0123');
/*!40000 ALTER TABLE `allenatori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `allenatori_p`
--

DROP TABLE IF EXISTS `allenatori_p`;
/*!50001 DROP VIEW IF EXISTS `allenatori_p`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `allenatori_p` AS SELECT 
 1 AS `id`,
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `eta`,
 1 AS `username`,
 1 AS `id_squadra`,
 1 AS `squadra`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `campionati`
--

DROP TABLE IF EXISTS `campionati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campionati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campionati`
--

LOCK TABLES `campionati` WRITE;
/*!40000 ALTER TABLE `campionati` DISABLE KEYS */;
INSERT INTO `campionati` VALUES (1,'Serie A');
/*!40000 ALTER TABLE `campionati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dirigenti`
--

DROP TABLE IF EXISTS `dirigenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dirigenti` (
  `id` int DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  KEY `id` (`id`),
  CONSTRAINT `dirigenti_ibfk_1` FOREIGN KEY (`id`) REFERENCES `persone` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dirigenti`
--

LOCK TABLES `dirigenti` WRITE;
/*!40000 ALTER TABLE `dirigenti` DISABLE KEYS */;
INSERT INTO `dirigenti` VALUES (101,'gollivier0','7890'),(102,'jburdess1','4567'),(103,'prudinger2','2345'),(104,'astannah3','8901'),(105,'mmountjoy4','8901'),(106,'dshelmardine5','2345'),(107,'rbate6','8901'),(108,'aandroli7','6789'),(109,'krolfini8','6789'),(110,'dpriddey9','7890');
/*!40000 ALTER TABLE `dirigenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `dirigenti_p`
--

DROP TABLE IF EXISTS `dirigenti_p`;
/*!50001 DROP VIEW IF EXISTS `dirigenti_p`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `dirigenti_p` AS SELECT 
 1 AS `id`,
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `eta`,
 1 AS `username`,
 1 AS `id_squadra`,
 1 AS `squadra`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `giocatori`
--

DROP TABLE IF EXISTS `giocatori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giocatori` (
  `id` int DEFAULT NULL,
  `costo` int DEFAULT NULL,
  `id_squadra` int DEFAULT NULL,
  KEY `id` (`id`),
  KEY `id_squadra` (`id_squadra`),
  CONSTRAINT `giocatori_ibfk_1` FOREIGN KEY (`id`) REFERENCES `persone` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `giocatori_ibfk_2` FOREIGN KEY (`id_squadra`) REFERENCES `squadre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giocatori`
--

LOCK TABLES `giocatori` WRITE;
/*!40000 ALTER TABLE `giocatori` DISABLE KEYS */;
INSERT INTO `giocatori` VALUES (1,22762341,1),(2,14763899,1),(3,23612692,2),(4,18966442,1),(5,23012795,2),(6,6961875,1),(7,8774272,2),(8,17382336,5),(9,22582495,NULL),(10,12961831,5),(11,22524475,1),(12,28086929,3),(13,22486661,1),(14,9612263,1),(15,16989969,2),(16,14941168,3),(17,20958889,3),(18,32464900,NULL),(19,5821165,3),(20,36532574,3),(21,23877045,NULL),(22,35980036,3),(23,20680960,NULL),(24,20355210,1),(25,26537316,3),(26,5736645,3),(27,23059688,5),(28,5644916,5),(29,27337326,NULL),(30,20858657,NULL),(31,6242659,NULL),(32,31422265,2),(33,20856113,5),(34,37913309,2),(35,33039600,5),(36,38538961,3),(37,14961600,1),(38,36009353,3),(39,10058435,1),(40,36471195,3),(41,15893944,1),(42,5870553,2),(43,5362807,5),(44,8793442,NULL),(45,25681939,3),(46,21468435,NULL),(47,25801159,1),(48,17218751,5),(49,32481052,1),(50,29044637,NULL),(51,31189952,NULL),(52,20206162,3),(53,25011560,4),(54,17633251,3),(55,32715731,4),(56,14873385,1),(57,32560343,3),(58,29419452,5),(59,29203137,2),(60,8514965,2),(61,38380539,NULL),(62,39046125,3),(63,35849096,5),(64,22034312,4),(65,31039956,4),(66,16581005,1),(67,36602463,5),(68,27508595,5),(69,10146326,4),(70,39906421,3),(71,37304211,5),(72,17247125,2),(73,34300650,2),(74,31190150,2),(75,39261557,4),(76,19450211,5),(77,10247283,1),(78,22315717,2),(79,23304897,4),(80,33560540,4),(81,5680188,5),(82,30293777,2),(83,10262165,1),(84,28394629,1),(85,27755141,2),(86,33741453,2),(87,34638990,5),(88,30208000,5),(89,23331839,1),(90,38993809,2),(91,10702617,1),(92,39274579,5),(93,35294401,NULL),(94,12906330,4),(95,29332510,NULL),(96,35933400,4),(97,34112274,4),(98,19337214,4),(99,30028445,4),(100,18708419,4);
/*!40000 ALTER TABLE `giocatori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `giocatori_nosquadra`
--

DROP TABLE IF EXISTS `giocatori_nosquadra`;
/*!50001 DROP VIEW IF EXISTS `giocatori_nosquadra`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `giocatori_nosquadra` AS SELECT 
 1 AS `id`,
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `eta`,
 1 AS `costo`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `giocatori_p`
--

DROP TABLE IF EXISTS `giocatori_p`;
/*!50001 DROP VIEW IF EXISTS `giocatori_p`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `giocatori_p` AS SELECT 
 1 AS `id`,
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `eta`,
 1 AS `costo`,
 1 AS `id_squadra`,
 1 AS `squadra`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `giocatori_squadre`
--

DROP TABLE IF EXISTS `giocatori_squadre`;
/*!50001 DROP VIEW IF EXISTS `giocatori_squadre`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `giocatori_squadre` AS SELECT 
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `eta`,
 1 AS `costo`,
 1 AS `id`,
 1 AS `idGioc`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `info_allenatori`
--

DROP TABLE IF EXISTS `info_allenatori`;
/*!50001 DROP VIEW IF EXISTS `info_allenatori`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `info_allenatori` AS SELECT 
 1 AS `id`,
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `eta`,
 1 AS `username`,
 1 AS `id_squadra`,
 1 AS `squadra`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `info_squadre`
--

DROP TABLE IF EXISTS `info_squadre`;
/*!50001 DROP VIEW IF EXISTS `info_squadre`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `info_squadre` AS SELECT 
 1 AS `id`,
 1 AS `squadra`,
 1 AS `id_dirigente`,
 1 AS `dirigente`,
 1 AS `id_allenatore`,
 1 AS `allenatore`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `persone`
--

DROP TABLE IF EXISTS `persone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `eta` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persone`
--

LOCK TABLES `persone` WRITE;
/*!40000 ALTER TABLE `persone` DISABLE KEYS */;
INSERT INTO `persone` VALUES (1,'John','Bessom',19),(2,'Thomas','Harborow',20),(3,'John','Shill',21),(4,'David','Nand',36),(5,'James','Gueste',27),(6,'William','Lumsdall',21),(7,'Michael','Hedderly',24),(8,'Robert','Balden',37),(9,'Michael','Curcher',33),(10,'Michael','Ryding',29),(11,'William','Tinsey',28),(12,'Matthew','Guirardin',26),(13,'John','Gregorio',26),(14,'Thomas','Boulding',30),(15,'David','Brightman',25),(16,'Thomas','Cokely',37),(17,'Robert','Burdess',24),(18,'Robert','Loveridge',29),(19,'Joseph','Rumin',32),(20,'Joseph','Pugh',37),(21,'William','Peerless',32),(22,'Robert','Kearney',35),(23,'Daniel','Di Roberto',34),(24,'Michael','Ezele',23),(25,'Thomas','Kemery',18),(26,'William','Sidwick',34),(27,'Daniel','Veldstra',24),(28,'William','Matteini',30),(29,'Robert','Kilbee',22),(30,'John','Lepper',25),(31,'William','Buesden',39),(32,'James','Kohneke',21),(33,'David','Prowse',33),(34,'Thomas','Skene',28),(35,'Matthew','Lamble',29),(36,'Michael','Tille',24),(37,'Matthew','Gilogly',23),(38,'David','Starte',33),(39,'Michael','Knevit',34),(40,'Robert','Simeoni',30),(41,'Michael','Bavridge',36),(42,'David','Cartmell',20),(43,'David','Marages',33),(44,'Joseph','Norcliff',23),(45,'Robert','Gaythwaite',31),(46,'Daniel','Morena',20),(47,'Thomas','Bovaird',37),(48,'Joseph','Dennes',33),(49,'James','Drinkall',25),(50,'William','McCourtie',25),(51,'David','Silverwood',39),(52,'Daniel','Gealy',31),(53,'Joseph','Reary',36),(54,'James','Pilbury',26),(55,'Joseph','Salazar',27),(56,'John','Wolfindale',33),(57,'Robert','Plaskitt',34),(58,'Thomas','Leall',19),(59,'Thomas','Rylstone',19),(60,'Matthew','Liversidge',34),(61,'Robert','Trazzi',19),(62,'Daniel','Ciobutaru',20),(63,'James','Rollings',21),(64,'John','Brosio',35),(65,'Daniel','Fadden',31),(66,'William','Giametti',21),(67,'Michael','Upward',24),(68,'William','Kitchinghan',25),(69,'Thomas','Brasener',22),(70,'David','Burgum',32),(71,'Daniel','Cone',23),(72,'Michael','Carnoghan',30),(73,'David','Kertess',21),(74,'John','Merrett',38),(75,'Matthew','Fenning',25),(76,'William','MacGiolla',29),(77,'Daniel','Bariball',18),(78,'Matthew','Ridley',31),(79,'Joseph','Fireman',35),(80,'David','Januszewicz',27),(81,'Michael','Matts',33),(82,'David','Wait',29),(83,'Thomas','Larchiere',26),(84,'Michael','Bellamy',29),(85,'Thomas','Kubicek',40),(86,'Thomas','Falkingham',40),(87,'James','Eam',33),(88,'James','Churms',40),(89,'Matthew','Glenister',25),(90,'James','Bannister',31),(91,'John','Bromell',22),(92,'Joseph','Jirek',27),(93,'David','Beadles',26),(94,'James','Sallowaye',22),(95,'Joseph','Boarder',39),(96,'Matthew','Abrahamsohn',28),(97,'Thomas','Gonzalvo',35),(98,'William','Beare',29),(99,'Michael','Poter',38),(100,'Daniel','Caudell',24),(101,'James','Dundridge',54),(102,'John','Litherland',44),(103,'William','Edmondson',46),(104,'William','Ost',57),(105,'John','Diprose',54),(106,'Daniel','Slocket',52),(107,'James','Treace',58),(108,'Joseph','Triswell',44),(109,'Robert','Wherrett',42),(110,'David','McCosker',58),(111,'Joseph','Ripping',43),(112,'John','McDougall',46),(113,'James','Caret',52),(114,'Thomas','Trowell',46),(115,'Thomas','Ivushkin',57),(116,'John','Pershouse',53),(117,'Daniel','Milverton',46),(118,'David','Ramelot',51),(119,'Thomas','Milberry',48),(120,'James','Tubbles',49);
/*!40000 ALTER TABLE `persone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `squadre`
--

DROP TABLE IF EXISTS `squadre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `squadre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `budget` int DEFAULT NULL,
  `punti` int DEFAULT NULL,
  `id_campionato` int DEFAULT NULL,
  `id_dirigente` int DEFAULT NULL,
  `id_allenatore` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_campionato` (`id_campionato`),
  KEY `id_dirigente` (`id_dirigente`),
  KEY `id_allenatore` (`id_allenatore`),
  CONSTRAINT `squadre_ibfk_1` FOREIGN KEY (`id_campionato`) REFERENCES `campionati` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `squadre_ibfk_2` FOREIGN KEY (`id_dirigente`) REFERENCES `persone` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `squadre_ibfk_3` FOREIGN KEY (`id_allenatore`) REFERENCES `persone` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `squadre`
--

LOCK TABLES `squadre` WRITE;
/*!40000 ALTER TABLE `squadre` DISABLE KEYS */;
INSERT INTO `squadre` VALUES (1,'Roma',-2290139,0,1,101,111),(2,'Lazio',50000000,0,1,102,112),(3,'Milan',50000000,0,1,103,113),(4,'Inter',81189952,0,1,104,114),(5,'Napoli',50000000,0,1,105,115),(6,'Lazio',50000000,0,1,106,116),(7,'Milan',50000000,0,1,107,117),(8,'Roma',50000000,0,1,108,118),(9,'Inter',50000000,0,1,109,119),(10,'Napoli',50000000,0,1,110,120);
/*!40000 ALTER TABLE `squadre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transazioni`
--

DROP TABLE IF EXISTS `transazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transazioni` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_trasferimento` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_trasferimento` (`id_trasferimento`),
  CONSTRAINT `transazioni_ibfk_1` FOREIGN KEY (`id_trasferimento`) REFERENCES `giocatori` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transazioni`
--

LOCK TABLES `transazioni` WRITE;
/*!40000 ALTER TABLE `transazioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `transazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `tutte_persone`
--

DROP TABLE IF EXISTS `tutte_persone`;
/*!50001 DROP VIEW IF EXISTS `tutte_persone`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `tutte_persone` AS SELECT 
 1 AS `id`,
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `eta`,
 1 AS `costo`,
 1 AS `username`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `allenatori_p`
--

/*!50001 DROP VIEW IF EXISTS `allenatori_p`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `allenatori_p` AS select `p`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`cognome` AS `cognome`,`p`.`eta` AS `eta`,`a`.`username` AS `username`,`s`.`id` AS `id_squadra`,`s`.`nome` AS `squadra` from ((`allenatori` `a` left join `persone` `p` on((`p`.`id` = `a`.`id`))) left join `squadre` `s` on((`a`.`id` = `s`.`id_allenatore`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `dirigenti_p`
--

/*!50001 DROP VIEW IF EXISTS `dirigenti_p`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `dirigenti_p` AS select `p`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`cognome` AS `cognome`,`p`.`eta` AS `eta`,`d`.`username` AS `username`,`s`.`id` AS `id_squadra`,`s`.`nome` AS `squadra` from ((`dirigenti` `d` left join `persone` `p` on((`p`.`id` = `d`.`id`))) left join `squadre` `s` on((`d`.`id` = `s`.`id_dirigente`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `giocatori_nosquadra`
--

/*!50001 DROP VIEW IF EXISTS `giocatori_nosquadra`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `giocatori_nosquadra` AS select `g`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`cognome` AS `cognome`,`p`.`eta` AS `eta`,`g`.`costo` AS `costo` from (`giocatori` `g` join `persone` `p` on((`p`.`id` = `g`.`id`))) where (`g`.`id_squadra` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `giocatori_p`
--

/*!50001 DROP VIEW IF EXISTS `giocatori_p`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `giocatori_p` AS select `p`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`cognome` AS `cognome`,`p`.`eta` AS `eta`,`g`.`costo` AS `costo`,`s`.`id` AS `id_squadra`,`s`.`nome` AS `squadra` from ((`giocatori` `g` left join `persone` `p` on((`p`.`id` = `g`.`id`))) left join `squadre` `s` on((`s`.`id` = `g`.`id_squadra`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `giocatori_squadre`
--

/*!50001 DROP VIEW IF EXISTS `giocatori_squadre`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `giocatori_squadre` AS select `g`.`nome` AS `nome`,`g`.`cognome` AS `cognome`,`g`.`eta` AS `eta`,`g`.`costo` AS `costo`,`d`.`id` AS `id`,`g`.`id` AS `idGioc` from ((`squadre` `s` left join `giocatori_p` `g` on((`s`.`id` = `g`.`id_squadra`))) left join `dirigenti_p` `d` on((`s`.`id` = `d`.`id_squadra`))) where (`g`.`id_squadra` is not null) order by `s`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `info_allenatori`
--

/*!50001 DROP VIEW IF EXISTS `info_allenatori`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `info_allenatori` AS select `p`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`cognome` AS `cognome`,`p`.`eta` AS `eta`,`a`.`username` AS `username`,`s`.`id` AS `id_squadra`,`s`.`nome` AS `squadra` from ((`allenatori` `a` left join `persone` `p` on((`p`.`id` = `a`.`id`))) left join `squadre` `s` on((`a`.`id` = `s`.`id_allenatore`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `info_squadre`
--

/*!50001 DROP VIEW IF EXISTS `info_squadre`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `info_squadre` AS select `s`.`id` AS `id`,`s`.`nome` AS `squadra`,`d`.`id` AS `id_dirigente`,concat(`d`.`nome`,' ',`d`.`cognome`) AS `dirigente`,`a`.`id` AS `id_allenatore`,concat(`a`.`nome`,' ',`a`.`cognome`) AS `allenatore` from ((`squadre` `s` left join `dirigenti_p` `d` on((`d`.`id` = `s`.`id_dirigente`))) left join `allenatori_p` `a` on((`a`.`id` = `s`.`id_allenatore`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `tutte_persone`
--

/*!50001 DROP VIEW IF EXISTS `tutte_persone`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `tutte_persone` AS select `p`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`cognome` AS `cognome`,`p`.`eta` AS `eta`,`g`.`costo` AS `costo`,'' AS `username` from (`giocatori` `g` left join `persone` `p` on((`p`.`id` = `g`.`id`))) union select `p`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`cognome` AS `cognome`,`p`.`eta` AS `eta`,'' AS `Name_exp_11`,`d`.`username` AS `username` from (`dirigenti` `d` left join `persone` `p` on((`p`.`id` = `d`.`id`))) union select `p`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`cognome` AS `cognome`,`p`.`eta` AS `eta`,'' AS `Name_exp_17`,`a`.`username` AS `username` from (`allenatori` `a` left join `persone` `p` on((`p`.`id` = `a`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-02 15:03:05
