CREATE DATABASE  IF NOT EXISTS `chowtime` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `chowtime`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: chowtime
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `preferences`
--

DROP TABLE IF EXISTS `preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preferences` (
  `locationID` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `ratingID` int(11) DEFAULT NULL,
  KEY `userID` (`userID`),
  KEY `ratingID` (`ratingID`),
  CONSTRAINT `preferences_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `preferences_ibfk_2` FOREIGN KEY (`ratingID`) REFERENCES `rating` (`ratingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferences`
--

LOCK TABLES `preferences` WRITE;
/*!40000 ALTER TABLE `preferences` DISABLE KEYS */;
/*!40000 ALTER TABLE `preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `ratingID` int(11) NOT NULL DEFAULT '0',
  `comments` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ratingID`),
  KEY `userID` (`userID`),
  CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suggestions`
--

DROP TABLE IF EXISTS `suggestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suggestions` (
  `suggestionID` int(11) NOT NULL DEFAULT '0',
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `suggestion` varchar(255) DEFAULT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`suggestionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggestions`
--

LOCK TABLES `suggestions` WRITE;
/*!40000 ALTER TABLE `suggestions` DISABLE KEYS */;
INSERT INTO `suggestions` VALUES (1,'aldsTM','aldsTM@gmail.com','<em>Sugar?</em> Yes please!<br/>Won\'t you come and put it down on me!','2015-03-21 03:21:12'),(2,'IGN','ign@ramus.com','Uses Bootstrap <b>10/10</b> <br/><i>Site of the Year</i>','2015-03-21 08:00:00'),(3,'smosh','smosh@smosh.com','<big><em>SHUT UP!</em></big>','2015-03-23 17:38:24'),(4,'loki','clarisse_poblete@dlsu.edu.ph','\"So, <i>do you think you\'re pretty?</i>\" \"<em>Of course I am!</em>\"','2015-03-25 10:45:00'),(5,'r2r0','r2r0@dlsu.edu.ph','Implement the following:<br/>1. GMaps to show nearby places <br/>2. User reviews for those places<br/>3. User\'s location history<br/>','2015-03-26 12:00:00'),(6,'aldsTM','aldsTM@gmail.com','<i>Lately, I\'ve been, I\'ve been losing sleep...</i><br/>Dreaming about things like <em>my MP</em>','2015-04-15 00:17:30'),(7,'madlantis','madison_spencer@dlsu.edu.ph','No, it’s not fair, but what makes earth feel like Hell is our expectation that it should feel like Heaven. Earth is earth. Dead is dead.','2011-09-01 00:24:07'),(8,'PewDiePie','pewdiepie@yahoo.com','What\'s going on bros? My name is <big>PewDiePie</big>!','2010-04-29 00:00:00');
/*!40000 ALTER TABLE `suggestions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL DEFAULT '0',
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0',
  `memberSince` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'aldsTM','aldsTM@gmail.com','password1',1,'2015-03-01 12:00:00'),(2,'bryan','bryan@yahoo.com','cokidoki321',1,'2015-03-02 08:00:00'),(3,'jrs000','jan_susada@dlsu.edu.ph','asdf',1,'2015-03-03 03:03:03'),(4,'r2r0','r2r0@dlsu.edu.ph','compile.txt',0,'2015-03-21 03:21:12'),(5,'loki','clarisse_poblete@dlsu.edu.ph','thor',0,'2015-04-14 09:21:14');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-15  0:37:56
