--
-- Table structure for table `calendar`
--

DROP TABLE IF EXISTS `calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendar` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `diary` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `promise` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `study_time` int DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcox0v4xnhs8qc7g4m34yuyvkq` (`user_id`),
  CONSTRAINT `FKcox0v4xnhs8qc7g4m34yuyvkq` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendar`
--

LOCK TABLES `calendar` WRITE;
/*!40000 ALTER TABLE `calendar` DISABLE KEYS */;
INSERT INTO `calendar` VALUES (2,'2021-08-16','월요병 따위는 잊어버리는 월요 코딩!\n','오늘은 대체 휴무이지만 프로젝트 마지막주니까 달려야지!',45000,2),(6,'2021-08-16','시간이 많지 않으니 여기서 비중있는 몇가지만 추려야겠다','보완이 필요한 부분 찾아서 리스트 작성',29188,7),(7,'2021-08-13','생각보다 많은 의견을 보
내준 걸 보니 수정해야 할 곳이 많은 것 같다..','발표 후 피드백 정리',7244,7),(8,'2021-08-12','이정도면 마무리 된 것 같다!','테스트 시나리오 마무리!',24249,7),(12,'2021-07-14','7월 14일 일기','7월 14일 다짐',0,7),(13,'2021-07-13','7월 13일 일기','7월 13일 다짐',0,7),(14,'2021-07-16','234234234','234234',0,7),(15,'2021-07-15','너무 어렵다..','JPA 사용법 학습',0,7),(16,'2021-07-19','entity에서 실수가 있는 것 같다. 내일 꼭 찾아보기!','JPA로 DB 정상 생성하기',0,7),(17,'2021-07-20','Qclass가 잘 안된다.. 이것도 찾아봐야지','entity 오류찾기',0,7),(18,'2021-07-21','7월 21일 일기','7월 21일 다짐',0,7),(19,'2021-07-22','ERD관련 피드
백 정리해야겠다','ERD 완성!',0,7),(20,'2021-07-23','좀 부족하지만 시작 할 수 있을 것 같다!','설계 마무리 하자!',0,7),(30,'2021-08-16',NULL,NULL,67,10),(41,'2021-07-11',NULL,NULL,1165,2),(42,'2021-07-15',NULL,NULL,51688,2),(43,'2021-07-25',NULL,NULL,485,2),(54,'2021-08-17','고치고 싶었던 기능을 고쳐서 기분이 좋았>던 하루였다.','프로젝트가 얼마 남지 않았네! 화이팅!',3000,2),(55,'2021-07-12','설계가 중요하다','프로젝트 시작',0,7),(56,'2021-08-17','계속 아쉬운 부분들이 >눈에 밟히지만 여기까지만..','마지막 수정 후 프로젝트 프리징!',36912,7),(63,'2021-08-17',NULL,NULL,2,20),(68,'2021-08-17','알고리즘의 기본은 수학!','오늘은 수
학공부를 열심히 할테야!',9000,21),(69,'2021-08-26','ㅎㅇ','ㅎㅇ',0,23),(70,'2021-09-25','ㅎㅇ','ㅎㅇ',0,23),(71,'2021-08-17',NULL,NULL,0,23),(73,'2021-08-09','월요팅!!','일주일치 계획을 미리 세워서 공부하자!',0,21),(74,'2021-08-10','화이팅!','열심히 공부를 해보자!',0,21),(75,'2021-08-11','수요팅!!','백준 골드 알>고리즘 2문제 목표!',0,21),(76,'2021-08-12','목요팅!!!','미비한 점들을 오늘 메꿔보자!',0,21),(77,'2021-08-13','금요일빠샤!','한주동안 채우지못한 부분들을 복습
해보자!',0,21),(78,'2021-08-14','토요일 뿌셔뿌셔!','다음주 예습을 미리 해보자!',0,21),(79,'2021-08-15','이료일은 서프라이즈~','평일에 복습하지 못했던 부분들>을 채워보자!!',3000,21),(80,'2021-08-16','토익 RC LC를 풀어서 목표치를 달성해서 기분이 좋다!','토익 점수 200점 향상 목표!',6000,21),(81,'2021-08-18','조금 힘
든 하루였지만 내일도 힘내보자!','오늘은 공부를 열심히 해야지!',1665,21),(82,'2021-08-19','알고리즘은 반복해서 푸는것이 중요한것 같다!','오늘은 알고리즘을 마>스터 하겠어!',0,21),(83,'2021-08-20','주말에 미비한 점들을 보충해야겠어!','목표한 공부치를 다 끝내자!!',0,21),(84,'2021-08-21','하지못했던 일들을 끝내서 기분
이 좋다!','주말에 하지못했던 공부를 끝내보자!',0,21),(85,'2021-08-09','','또다시 시작된 월요일..!! 이번 한 주도 새롭게 시작하자!',6000,2),(86,'2021-08-10','>결국 세시간밖에 하지 못했다... 내일은 더 열심히 해야지!','오늘은 꼭 10시간을 채울거야!!!',11000,2),(87,'2021-08-11','','오늘은 또 어떤 신나는 공부가 이어질까
???',11000,2),(88,'2021-08-12','','오늘은 두시간은 알고리즘을 하고 두시간은 자바스크립트 기본을 봐야겠다.',11000,2),(89,'2021-08-13',NULL,NULL,56000,2),(90,'2021-08-14','개발자는 계속해서 새로운 것을 배우는 것','개발자가 된다는건 뭘까',72000,2),(91,'2021-08-15','행복한 일요 코딩','오늘도 코딩 내일도 코딩',40000,2),(92,'2021-08-18','','오늘은 프로젝트 2일 전이다 열심히 해야지',26943,2),(93,'2021-08-09','오늘도 열심히 공부했다.','목표한 부분 다하기',10700,6),(94,'2021-08-10','오늘 공부는 조금 부족했던 것 같다.','실패는 성공의 어머니!!',18151,6),(95,'2021-08-11','공부는 재미가 없다,,ㅠㅠ','취업해야지?!',21565,6),(96,'2021-08-12','어제 열심히 했으니까 오늘은 괜찮아','쉽게 지치지말자!',5002,6),(97,'2021-08-13','오늘은 금요일 불금을 즐겨도 돼','정신 차려!!',10000,6);

--
-- Table structure for table `common_code`
--

DROP TABLE IF EXISTS `common_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `common_code` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `kind` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `common_code`
--


LOCK TABLES `common_code` WRITE;
/*!40000 ALTER TABLE `common_code` DISABLE KEYS */;
INSERT INTO `common_code` VALUES (1,'회원'),(2,'카테고리'),(3,'시간'),(4,'신고'),(6,'기타');
/*!40000 ALTER TABLE `common_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conference`
--

DROP TABLE IF EXISTS `conference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conference` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` int DEFAULT NULL,
  `end_room_date` date DEFAULT NULL,
  `end_room_time` time DEFAULT NULL,
  `max_people` int DEFAULT NULL,
  `now_people` int DEFAULT NULL,
  `session` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `start_room_date` date DEFAULT NULL,
  `start_room_time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `details_code`
--

DROP TABLE IF EXISTS `details_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `details_code` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd30oetvyu88avc523e90c73cv` (`type`),
  CONSTRAINT `FKd30oetvyu88avc523e90c73cv` FOREIGN KEY (`type`) REFERENCES `common_code` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `details_code`
--

LOCK TABLES `details_code` WRITE;
/*!40000 ALTER TABLE `details_code` DISABLE KEYS */;
INSERT INTO `details_code` VALUES (1,'일반회원',1),(2,'관리자',1),(3,'제재회원',1),(4,'수능',2),(5,'취준',2),(6,'자격증',2),(7,'고시',2),(8,'기타',2),(9,'공>부',3),(10,'휴식',3);
/*!40000 ALTER TABLE `details_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notify`
--
DROP TABLE IF EXISTS `notify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notify` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `handling` int DEFAULT NULL,
  `notify_date` date DEFAULT NULL,
  `reason` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfbw0pi68o4g3n1whir7ig8q9f` (`user_id`),
  CONSTRAINT `FKfbw0pi68o4g3n1whir7ig8q9f` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notify`
--

LOCK TABLES `notify` WRITE;
/*!40000 ALTER TABLE `notify` DISABLE KEYS */;
/*!40000 ALTER TABLE `notify` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `todo_list`
--

DROP TABLE IF EXISTS `todo_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `todo_list` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `is_finish` tinyint(1) DEFAULT '0',
  `todo` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `todoindex` int DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4xtg62i076eelmwvp7mcjchko` (`user_id`),
  CONSTRAINT `FK4xtg62i076eelmwvp7mcjchko` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo_list`
--


LOCK TABLES `todo_list` WRITE;
/*!40000 ALTER TABLE `todo_list` DISABLE KEYS */;
INSERT INTO `todo_list` VALUES (3,'2021-08-16',0,'국어',1,6),(34,'2021-07-12',0,'팀미팅',1,7),(35,'2021-07-12',0,'개발환경',2,7),(36,'2021-07-19',0,'JPA',1,7),(37,'2021-07-19',0,'swagger',2,7),(38,'2021-07-20',0,'entity',1,7),(39,'2021-07-21',0,'0721',1,7),(40,'2021-07-22',0,'ERD',1,7),(41,'2021-07-22',0,'공통코>드?',2,7),(42,'2021-07-23',0,'명세서',1,7),(65,'2021-08-18',0,'네트워크',1,20),(66,'2021-08-18',0,'프로젝트 진행',2,20),(67,'2021-08-18',0,'알고리즘',3,20),(68,'2021-08-02',0,'JPA',1,7),(69,'2021-08-03',0,'DB생성',1,7),(70,'2021-08-03',0,'외래키 설정',2,7),(71,'2021-08-03',0,'JPA entity',3,7),(72,'2021-08-18',0,'Korean',NULL,22),(73,'2021-08-18',0,'Math',NULL,22),(74,'2021-08-04',0,'entity',1,7),(75,'2021-08-04',0,'테스트',2,7),(76,'2021-08-05',0,'repository',1,7),(77,'2021-08-05',0,'QClass',2,7),(78,'2021-08-06',0,'user',1,7),(79,'2021-08-06',0,'calendar',2,7),(80,'2021-08-06',0,'todoList',3,7),(81,'2021-08-07',0,'todoList',1,7),(82,'2021-08-09',0,'swagger',1,7),(85,'2021-08-18',0,'C++',4,20),(86,'2021-08-10',0,'notify',1,7),(87,'2021-08-11',0,'회원',1,7),(88,'2021-08-11',0,'캘린더',2,7),(90,'2021-08-12',0,'todoList',1,7),(91,'2021-08-11',0,'todoList',3,7),(92,'2021-08-16',0,'회원',1,7),(93,'2021-08-16',0,'캘린더',2,7),(94,'2021-08-16',0,'todoList',3,7),(95,'2021-08-16',0,'리스트 작성',4,7),(96,'2021-08-17',0,'회원',1,7),(97,'2021-08-17',0,'캘린더',2,7),(98,'2021-08-17',0,'todoList',3,7),(99,'2021-08-18',0,'ppt',1,7),(100,'2021-08-18',0,'시나리오',2,7),(101,'2021-08-18',0,'시연영상',3,7),(102,'2021-08-13',0,'피드백 검토',1,7),(103,'2021-08-19',0,'',1,20),(104,'2021-08-19',0,'sdfasdfff',2,20),(105,'2021-08-01',0,'알고리즘',1,26),(106,'2021-08-01',0,'프로젝트',2,26),(107,'2021-08-02',0,'알고
리즘',1,26),(108,'2021-08-02',0,'프로젝트',2,26),(109,'2021-08-03',0,'알고리즘',1,26),(110,'2021-08-03',0,'프로젝트',2,26),(111,'2021-08-04',0,'알고리즘',1,26),(112,'2021-08-04',0,'프로젝트',2,26),(113,'2021-08-05',0,'알고리즘',1,26),(114,'2021-08-05',0,'프로젝트',2,26),(115,'2021-08-06',0,'알고리즘',1,26),(116,'2021-08-06',0,'프로젝트',2,26),(117,'2021-08-07',0,'알고리즘',1,26),(118,'2021-08-07',0,'프로젝트',2,26),(119,'2021-08-08',0,'프로젝트',1,26),(120,'2021-08-08',0,'알고리즘',2,26),(121,'2021-08-09',0,'알고리즘',1,26),(122,'2021-08-09',0,'프로젝트',2,26),(123,'2021-08-10',0,'알고리즘',1,26),(124,'2021-08-10',0,'프>로젝트',2,26),(125,'2021-08-11',0,'알고리즘',1,26),(126,'2021-08-11',0,'프로젝트',2,26),(127,'2021-08-12',0,'알고리즘',1,26),(128,'2021-08-12',0,'프로젝트',2,26),(129,'2021-08-13',0,'알고리즘',1,26),(130,'2021-08-13',0,'프로젝트',2,26),(131,'2021-08-14',0,'알고리즘',1,26),(132,'2021-08-14',0,'프로젝트',2,26),(133,'2021-08-15',0,'알고리즘',1,26),(134,'2021-08-15',0,'프로젝트',2,26),(135,'2021-08-16',0,'프로젝트',1,26),(136,'2021-08-16',0,'발표',2,26),(137,'2021-08-17',0,'프로젝트',1,26),(138,'2021-08-17',0,'알고리즘',2,26),(139,'2021-08-18',0,'알고리즘',1,26),(140,'2021-08-18',0,'프로젝트',2,26),(141,'2021-08-19',0,'프로>젝트',1,26);
/*!40000 ALTER TABLE `todo_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todo_list_detail`
--
DROP TABLE IF EXISTS `todo_list_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `todo_list_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `detail` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `detailindex` int DEFAULT NULL,
  `is_finish` bit(1) DEFAULT NULL,
  `todo_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK49uwwpchw4wunng6xuydqrs82` (`todo_id`),
  CONSTRAINT `FK49uwwpchw4wunng6xuydqrs82` FOREIGN KEY (`todo_id`) REFERENCES `todo_list` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=503 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo_list_detail`
--

LOCK TABLES `todo_list_detail` WRITE;
/*!40000 ALTER TABLE `todo_list_detail` DISABLE KEYS */;
INSERT INTO `todo_list_detail` VALUES (5,'국어1',NULL,_binary '^A',3),(6,'국어2',2,_binary '\0',3),(194,'팀원파악',1,_binary '\0',34),(195,'계획수립',2,_binary '\0',34),(196,'스프링',1,_binary '\0',35),(197,'데이터베이스',2,_binary '\0',35),(198,'entity생성',1,_binary '\0',36),(199,'repository생성',2,_binary '\0',36),(200,'service생성',3,_binary '\0',36),(201,'controller생성',1,_binary '\0',37),(202,'각 url별 기능 표시',2,_binary '\0',37),(203,'몇글자까지들어가는지제
가한번실험해보겠습니다람쥐썬더',3,_binary '\0',37),(204,'관계 어노테이션',1,_binary '\0',38),(205,'공통코드 추가',2,_binary '\0',38),(206,'0721-01',1,_binary '\0',39),(207,'0721-02',2,_binary '\0',39),(208,'user',1,_binary '\0',40),(209,'calendar',2,_binary '\0',40),(210,'todoList',3,_binary '\0',40),(211,'공통코
드 개념',1,_binary '\0',41),(212,'설계',2,_binary '\0',41),(213,'검토',3,_binary '\0',41),(214,'프로젝트 개요',1,_binary '\0',42),(215,'요구사항 명세서',2,_binary '\0',42),(216,'유스케이스',3,_binary '\0',42),(290,'OSI 7 계층',NULL,_binary '^A',65),(291,'TCP/IP 흐름제어',NULL,_binary '^A',65),(292,'UDP',NULL,_binary '^A',65),(293,'todo list layout',NULL,_binary '^A',66),(294,'회원 검색 axios',NULL,_binary '^A',66),(295,'버블정렬 구현',NULL,_binary '^A',67),(296,'선택
정렬 구현',NULL,_binary '^A',67),(297,'삽입정렬 구현',NULL,_binary '^A',67),(299,'개념',NULL,_binary '^A',68),(300,'사용법',2,_binary '\0',68),(301,'mybatis>와의 차이',NULL,_binary '^A',68),(302,'entity',NULL,_binary '^A',69),(303,'기본키',NULL,_binary '^A',70),(304,'외래키',2,_binary '\0',70),(305,'사용법',NULL,_binary '\0',71),(306,'어노테이션',NULL,_binary '\0',71),(307,'화법과 작문',1,_binary '\0',72),(308,'언어와 매체',NULL,_binary '^A',72),(309,'문학',NULL,_binary '^A',72),(310,'비문학',4,_binary '\0',72),(311,'수학1',NULL,_binary '\0',73),(312,'수2',NULL,_binary '^A',73),(313,'확률과 통계',3,_binary '\0',73),(314,'기하와 벡터',NULL,_binary '^A',73),(315,'user',NULL,_binary '^A',74),(316,'calendar',NULL,_binary '^A',74),(317,'todoList',NULL,_binary '^A',74),(318,'user>입력',NULL,_binary '^A',75),(319,'calendar입력',NULL,_binary '^A',75),(320,'todoList입력',3,_binary '\0',75),(321,'생성',NULL,_binary '^A',76),(322,'테스트',NULL,_binary '^A',76),(323,'만드는법',NULL,_binary '^A',77),(324,'자동생성',NULL,_binary '^A',77),(325,'닉네임으로 id호출',NULL,_binary '^A',78),(326,'반환값
 가공',NULL,_binary '^A',78),(327,'user정보 배제',NULL,_binary '^A',79),(328,'글자 수 제한',NULL,_binary '^A',79),(329,'calendar정보 배제',NULL,_binary '^A',80),(330,'정렬 후 반환',2,_binary '\0',80),(331,'정렬 후 반환',NULL,_binary '^A',81),(332,'user',NULL,_binary '^A',82),(333,'calendar',NULL,_binary '^A',82),(334,'todoList',NULL,_binary '^A',82),(339,'퀵정렬 구현',NULL,_binary '^A',67),(340,'얕은 복사 깊은 복사',NULL,_binary '^A',85),(341,'entity',NULL,_binary '^A',86),(342,'repository',NULL,_binary '^A',86),(343,'swagger',NULL,_binary '^A',86),(344,'회원가입',NULL,_binary '^A',87),(345,'회원수정',NULL,_binary '^A',87),(346,'회원탈퇴',NULL,_binary '^A',87),(347,'날짜선택',NULL,_binary '^A',88),(348,'다짐작성',NULL,_binary '^A',88),(349,'일기작성',NULL,_binary '^A',88),(355,'카테고리 생성',NULL,_binary '^A',91),(356,'카테고리 수정',2,_binary '\0',91),(357,'순서 변경',3,_binary '\0',91),(358,'삭제',4,_binary '\0',91),(359,'수>정',NULL,_binary '^A',90),(360,'순서 변경',2,_binary '\0',90),(361,'삭제',NULL,_binary '^A',90),(362,'검토',NULL,_binary '^A',92),(363,'검토',NULL,_binary '^A',93),(364,'검토',NULL,_binary '^A',94),(365,'회원',NULL,_binary '^A',95),(366,'캘린더',NULL,_binary '^A',95),(367,'todoList',NULL,_binary '^A',95),(368,'모
달창 수정',NULL,_binary '^A',96),(369,'토글버튼 배치',NULL,_binary '^A',96),(370,'UI개선',NULL,_binary '^A',97),(371,'삭제기능',NULL,_binary '\0',97),(372,'>순서변경',1,_binary '\0',98),(373,'삭제',NULL,_binary '^A',98),(374,'표지',NULL,_binary '^A',99),(375,'내용',NULL,_binary '^A',99),(376,'사진',NULL,_binary '^A',99),(377,'주제',NULL,_binary '^A',100),(378,'서비스',NULL,_binary '^A',100),(379,'강점',NULL,_binary '^A',100),(380,'회원',1,_binary '\0',101),(381,'마이
페이지',2,_binary '\0',101),(382,'공부방',3,_binary '\0',101),(383,'1팀',NULL,_binary '^A',102),(384,'2팀',NULL,_binary '^A',102),(385,'3팀',NULL,_binary '^A',102),(386,'4팀',NULL,_binary '^A',102),(387,'5팀',NULL,_binary '^A',102),(388,'6팀',NULL,_binary '^A',102),(389,'9팀',NULL,_binary '^A',102),(390,'adf2',NULL,_binary '\0',104),(391,'백준 #1',NULL,_binary '^A',105),(392,'SWEA #1',NULL,_binary '^A',105),(393,'공부 시작 타이머 기능',NULL,_binary '^A',106),(394,'공
부 휴식 기능',NULL,_binary '^A',106),(395,'공부방 내 다른 사람 프로필 조회',NULL,_binary '^A',106),(396,'공부 종료 기능',NULL,_binary '^A',106),(397,'백준 #2',1,_binary '\0',107);
/*!40000 ALTER TABLE `todo_list_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` int DEFAULT NULL,
  `is_open` tinyint(1) DEFAULT '0',
  `kakao_id_num` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `usercode` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,5,1,'1835407038','전선규',1),(6,5,0,'1818720107','chaeha',1),(7,5,1,'1835579273','임완택',1),(10,6,1,'1852612952','Dd',1),(19,4,0,'444','제재회원',3),(20,7,0,'1823892384','만재만',1),(21,5,1,'2918','A208영환',1),(22,5,1,'1835411702','하영',1),(23,5,1,'1854644188','오좀치는데',1),(24,5,1,'1856226548','장섭비',1),(25,4,1,'50208','관리자',2),(26,5,1,'50208777','일반회원2',1),(27,5,1,'50208444','제재회원2',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_history`
--

DROP TABLE IF EXISTS `user_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `enter_date` date DEFAULT NULL,
  `enter_time` time DEFAULT NULL,
  `exit_date` date DEFAULT NULL,
  `exit_time` time DEFAULT NULL,
  `type` int DEFAULT NULL,
  `conference_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK93rjn0x83br1j83xr47jgr3k2` (`conference_id`),
  KEY `FKaa6ilb6iqih95bntoeyysb2pc` (`user_id`),
  CONSTRAINT `FK93rjn0x83br1j83xr47jgr3k2` FOREIGN KEY (`conference_id`) REFERENCES `conference` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKaa6ilb6iqih95bntoeyysb2pc` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=367 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

