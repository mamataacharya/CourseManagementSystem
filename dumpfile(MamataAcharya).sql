-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: coursemanagement
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `CourseID` varchar(10) DEFAULT NULL,
  `CourseName` varchar(255) DEFAULT NULL,
  `Modules` int DEFAULT NULL,
  `years` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('Bcs','Computer science',6,3),('Bibm','Business Management',8,4);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules`
--

DROP TABLE IF EXISTS `modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modules` (
  `Course` varchar(10) DEFAULT NULL,
  `Codee` varchar(50) NOT NULL,
  `Namee` varchar(255) NOT NULL,
  `Levell` varchar(5) NOT NULL,
  `Sem` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules`
--

LOCK TABLES `modules` WRITE;
/*!40000 ALTER TABLE `modules` DISABLE KEYS */;
INSERT INTO `modules` VALUES ('Bcs','4CI018','Academics Skills and Team Based Learning','4','1'),('Bcs','4CS015','Fundamentals of Computing','5','3'),('Bcs','4CS001','Introductory Programming','4','1'),('Bcs','4CS017','Internet Software Architecture','4','2'),('Bcs','4CS016','Embedded System Programming','4','2'),('Bcs','4MM013','Computational Mathematics','4','2'),('Bcs','5CS037','Concepts and Technologies of AI','5','3'),('Bcs','5CS019','Object oriented design and programming','5','3'),('Bcs','5CS021','Numerical Methods and Concurrency','5','3'),('Bcs','5CS024','Collaborative Development','5','4'),('Bcs','5CS022','Distributed and Cloud System Programming','5','4'),('Bcs','5CS020','Human Computer Interaction','5','4'),('Bcs','6CS030','Big Data','6','5'),('Bcs','6CS005','High Performance Computing','6','5'),('Bcs','6CS014','Complex System','6','6'),('Bcs','6CS007','Project and Professionalism','6','6'),('Bcs','6CS012','Deep Learning','6','6'),('Bcs','6CS013','Machine Learning','6','6');
/*!40000 ALTER TABLE `modules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `Stu_id` int NOT NULL,
  `teacher_id` int DEFAULT NULL,
  `Module_code` varchar(255) NOT NULL,
  `marks` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (2,3,'4CS015',55),(4,3,'4CS015',88),(5,3,'4CS015',65),(6,3,'4CS015',89),(7,3,'4CS015',78),(8,3,'4CS015',45),(10,3,'4CS015',66),(2,9,'4CI018',34),(4,9,'4CI018',77),(5,9,'4CI018',78),(6,9,'4CI018',66),(7,9,'4CI018',56),(8,9,'4CI018',77),(10,9,'4CI018',87),(2,11,'4CS001',39),(4,11,'4CS001',77),(5,11,'4CS001',87),(6,11,'4CS001',23),(7,11,'4CS001',77),(8,11,'4CS001',76),(10,11,'4CS001',66),(4,11,'4CS016',56),(5,11,'4CS016',44),(6,11,'4CS016',78),(7,11,'4CS016',56),(8,11,'4CS016',87),(10,11,'4CS016',66),(4,9,'4MM013',55),(5,9,'4MM013',67),(6,9,'4MM013',34),(7,9,'4MM013',67),(8,9,'4MM013',79),(10,9,'4MM013',66),(4,3,'4CS017',45),(5,3,'4CS017',65),(6,3,'4CS017',66),(7,3,'4CS017',87),(8,3,'4CS017',67),(10,3,'4CS017',66);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `stu_id` int DEFAULT NULL,
  `Levell` int DEFAULT NULL,
  `sem` int DEFAULT NULL,
  `Module1` varchar(50) DEFAULT NULL,
  `Module2` varchar(50) DEFAULT NULL,
  `Module3` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (2,4,2,'Internet Software Architecture','Computational Mathematics','Embedded System Programming'),(4,5,4,'Human Computer Interaction','Cloud Computing','Collaborative Development'),(5,5,3,'Concepts and Technologies of AI','Object oriented design and programming','Numerical methods and Concurrency'),(6,6,5,'Big Data','High Performance Computing','Machine Learning'),(7,6,6,'Complex System','Project and Professionalism','Deep Learning'),(10,6,5,'Big Data','High Performance Computing','Deep Learning'),(8,5,4,'Human Computer Interaction','Cloud Computing','Collaborative Development');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutors`
--

DROP TABLE IF EXISTS `tutors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutors` (
  `ModuleCode` varchar(20) DEFAULT NULL,
  `ModuleName` varchar(50) DEFAULT NULL,
  `Tutor_ID` int DEFAULT NULL,
  `Tutor` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutors`
--

LOCK TABLES `tutors` WRITE;
/*!40000 ALTER TABLE `tutors` DISABLE KEYS */;
INSERT INTO `tutors` VALUES ('4CS015','Fundamentals of Computing',3,'Jenisha Dhakal'),('5CS019','Object oriented Design and Programming',3,'Jenisha Dhakal'),('4CS017','Internet Software Architecture',3,'Jenisha Dhakal'),('4CI018','Academic Skills and Team based Learning',9,'Prabha Acharya'),('4MM013','Computational Mathematics',9,'Prabha Acharya'),('5CS037','Concept and Technologies of AI',9,'Prabha Acharya'),('4CS016','Embedded System Programming',11,'Sanjeet Acharya'),('4CS001','Introductory Programming',11,'Sanjeet Acharya'),('5CS021','Numerical Methods and Concurrency',11,'Sanjeet Acharya'),('5CS024','Collaborative Development',14,'Ankit Nepal'),('6CS005','High Performance Computing',12,'Manjeet Acharya'),('5CS020','Human Computer Interaction',12,'Manjeet Acharya'),('6CS014','Complex System',9,'Prabha Acharya'),('6CS012','Artificial Intelligence and Machine Learning',11,'Sanjeet Acharya'),('6CS007','Project and Professionalism',3,'Jenisha Dhakal'),('6CS012','Deep Learning',12,'Manjeet Acharya'),('6CS013','Machine Learning',13,'Sanir Chhetri');
/*!40000 ALTER TABLE `tutors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usersinfo`
--

DROP TABLE IF EXISTS `usersinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usersinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone_no` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password_` varchar(50) NOT NULL,
  `roles_` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usersinfo`
--

LOCK TABLES `usersinfo` WRITE;
/*!40000 ALTER TABLE `usersinfo` DISABLE KEYS */;
INSERT INTO `usersinfo` VALUES (1,'Mamata','Acharya','9840306514','check@gmail.com','mamata','mamata123','Admin'),(2,'Pushpa','Bhattarai','98841215119','pushpabhattarai@gmail.com','pushpa','pushpa123','Student'),(3,'Jenisha','Dhakal','9841140189','jenishadhakal@gmail.com','jenisha','jenisha123','Teacher'),(4,'Romina','Udas','9830493848','rominaudas@gmail.com','romina','romina123','Student'),(5,'Unisha ','Prasai','9837493849','unishaprasai@gmail.com','unisha','unisha123','Student'),(6,'Prekshya','Siwakoti','9839283949','prekshyasiwakoti@gmail.com','prekshya','prekshya123','Student'),(7,'Kabir','Shah','9830493849','kabirshah@gmail.com','kabirshah','kabir123','Student'),(8,'Ayush','Shakya','9839940394','ayushshakya@gmail.com','ayush','ayush123','Student'),(9,'prabha','acharya','9839493044','prabhaacharya@gmail.com','prabha','prabha123','Teacher'),(10,'Milan','Acharya','9845934857','milanacharya@gmail.com','milan','milan123','Student'),(11,'Sanjeet','Acharya','9837483949','sanjeet@gmail.com','sanjeet','sanjeet123','Teacher'),(12,'Manjeet','Acharya','9839493043','manjeetacharya@gmail.com','manjeet','manjeet123','Teacher'),(13,'Sanir','Chhetri','9820309438','sanirchhetri@gmail.com','sanir','sanir123','Teacher'),(14,'Ankit','Nepal','9869403943','ankitnepal@gmail.com','ankit','ankit123','Teacher');
/*!40000 ALTER TABLE `usersinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-09 14:10:30
