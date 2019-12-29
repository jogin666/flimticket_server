-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: flimtiket
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
-- Table structure for table `actors`
--

DROP TABLE IF EXISTS `actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `actors` (
  `id` varchar(35) NOT NULL,
  `filmId` varchar(50) DEFAULT NULL,
  `nameEng` varchar(50) DEFAULT NULL,
  `name` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_make2` (`filmId`),
  CONSTRAINT `FK_make2` FOREIGN KEY (`filmId`) REFERENCES `film` (`filmid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actors`
--

LOCK TABLES `actors` WRITE;
/*!40000 ALTER TABLE `actors` DISABLE KEYS */;
/*!40000 ALTER TABLE `actors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cinema` (
  `cinemaId` char(10) NOT NULL,
  `cinemaName` varchar(200) NOT NULL,
  `cinemaCity` varchar(60) NOT NULL,
  `cinemaAddress` varchar(500) NOT NULL,
  PRIMARY KEY (`cinemaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES ('1','保利国际影城——上海曹路宝龙店','上海','浦东那新区金海路2505弄宝龙城市广场5楼'),('10','登天国际影城（嘉琳中心店）','深圳','坪山新区坑梓街道翠景路56号楼嘉林中心3楼'),('11','百雅国际影城','杭州','萧山区临江工业园区长风路3589号5号楼'),('12','德信影城','杭州','余杭区东湖北路蜗牛广场4F德信影城'),('13','旺盛国际影城-义蓬店','杭州','萧山区义蓬街道义蓬中路501号义蓬购物中心4楼'),('2','上海华策金球影城','上海','浦东新区上分路1810号'),('3','上海金海影城','上海','浦东新区曹路镇金群路28号楼4楼'),('4','SFC上影影城（金桥太茂店）','上海','浦东新区金高路1882号4楼L-401'),('5','上海CFR没影国际影城（新紫茂店）','上海','浦东新区巨峰路1058弄2号新紫茂商业中心3楼'),('6','SFC上海影城（唐镇店）','上海','浦东新区唐镇路1083弄2号新紫茂商业中心3楼'),('7','星际银河连锁影城','深圳','坪山新区坑梓街道金田风华苑西1号楼3楼'),('8','中影国际影城（坑梓友田万家3楼）','深圳','坪山新区深圳市坪山区坑梓街道人民路33号楼'),('9','君盛国际影城（坑梓店）','深圳','坪山区坑梓大新百货5楼');
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `director` (
  `filmId` varchar(50) DEFAULT NULL,
  `codeId` varchar(35) NOT NULL,
  `engName` varchar(25) NOT NULL,
  `cnName` varchar(25) DEFAULT NULL,
  KEY `FK_make` (`filmId`),
  CONSTRAINT `FK_make` FOREIGN KEY (`filmId`) REFERENCES `film` (`filmid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `film` (
  `filmId` varchar(50) NOT NULL,
  `filmName` char(30) NOT NULL,
  `durationMin` varchar(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `countries` varchar(30) NOT NULL,
  `rating` float DEFAULT NULL,
  `genres` varchar(100) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  `releaseDates` varchar(80) DEFAULT NULL,
  `coverUrl` varchar(300) DEFAULT NULL,
  `screenTypes` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`filmId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES ('1','阿拉丁','128','在充满异域风情的古代阿拉伯王国，善良的穷小子阿拉丁（莫纳·马苏德 饰）和勇敢的茉莉公主（娜奥米·斯科特 饰）浪漫邂逅，在可以满足主人三个愿望的神灯精灵帮助下，两人踏上了一次寻找真爱和自我的魔幻冒险。','美国',8.8,'爱情/奇幻/冒险','英语','2019-05-24','https://img.alicdn.com/bao/uploaded/i4/TB1.8Ebg8LoK1RjSZFuXXXn0XXa_.jpg_160x240.jpg','3D'),('10','哆啦A梦：大雄的月球探险记','111','月球探测器在月亮上捕捉到了白影，大雄认为这道白影是月亮上的兔子，惹来了大家的耻笑，于是哆啦A 梦为了帮助大雄，利用道具“异说俱乐部徽章”，在月球背面制造了一个兔子王国。一天，神秘少年露卡转学而来，与大雄和伙伴们一同前往月亮上的月兔王国展开了一场别开生面的浪漫想象力之旅。','日本',0,'剧情/动画','日语','2019-06-01','https://img.alicdn.com/bao/uploaded/i2/TB1BV8HX8Kw3KVjSZTEXXcuRpXa_.jpg_160x240.jpg','3D'),('2','哥斯拉2：怪兽之王','132','随着《哥斯拉》和《金刚：骷髅岛》在全球范围内的成功，华纳兄弟影片公司和传奇影业联手开启了怪兽宇宙系列电影的新篇章\\u2014一部史诗级动作冒险巨制。在这部电影中，哥斯拉将和众多大家在流行文化中所熟知的怪兽展开较量。全新故事中，研究神秘动物学的机构\\u201c帝王组织\\u201d成员将勇敢直面巨型怪兽，其中强大的哥斯拉也将和魔斯拉、拉顿和它的死对头\\u2014\\u2014三头王基多拉展开激烈对抗。当这些只存在于传说里的超级生物再度崛起时，它们将展开王者争霸，人类的命运岌岌可危','美国',8.9,'科幻/灾难/动作','英语','2019-05-31','https://img.alicdn.com/bao/uploaded/i4/TB15PVuX2WG3KVjSZPcXXbkbXXa_.jpg_160x240.jpg','2D'),('3','一条狗的使命','108','小狗贝利延续使命，在主人伊森的嘱托下，通过不断的生命轮回， 执着守护伊森的孙女CJ，将伊森对孙女的爱与陪伴，当做最重要的 使命和意义，最终帮助CJ收获幸福，再次回到主人伊森身边。','美国',8.9,'剧情/喜剧/家庭','英语','2019-05-17','https://img.alicdn.com/bao/uploaded/i2/TB1y05BU7voK1RjSZFwXXciCFXa_.jpg_160x240.jpg','3D'),('4','大侦探皮卡丘','104','好莱坞真人电影《大侦探皮卡丘》讲述了蒂姆·古德曼（贾斯提斯·史密斯饰） 为寻找下落不明的父亲来到莱姆市，意外与父亲的前宝可梦搭档大侦探皮卡丘相遇，并惊讶地发现自己是唯一能听懂皮卡丘说话的人类，他们决定组队踏上揭开真相的刺激冒险之路。探案过程中他们邂逅了各式各样的宝可梦，并意外发现了一个足以毁灭整个宝可梦宇宙的惊天阴谋。该电影改编自任天堂3DS同名游戏，由罗伯·莱特曼导演，瑞安·雷诺兹为大侦探皮卡丘配音，贾斯提斯·史密斯、凯瑟琳·纽顿等主演。电影由美国传奇影业、华纳兄弟片公司 美国传奇影业、华纳兄弟片公司 美国传奇影业、华纳兄弟片公司 联合出品 ，预计于2019年5月10日北美上映。','美国',8.5,'奇幻/冒险','英语','2019-05-10','https://img.alicdn.com/bao/uploaded/i1/TB1fypRUBLoK1RjSZFuXXXn0XXa_.jpg_160x240.jpg','3D'),('5','追龙||','103','悍匪龙志强，在香港回归前，趁香港英政府不作为，而屡犯巨案，先后绑架富豪利家及雷家之长子，勒索超过二十亿元，事主怕被报复, 交赎款后都不敢报警。中国公安部极为关注，与香港警方合力，派香港警员何天卧底潜入龙志强犯罪团伙，发现他正策划绑架澳门富豪贺不凡，最终陆港警察合力勇擒龙志强，救出贺不凡。','中国大陆/中国香港',0,'剧情/动作/犯罪','普通话/白话','2019-06-06','https://img.alicdn.com/bao/uploaded/i3/TB1ebtnTrvpK1RjSZPiXXbmwXXa_.jpg_160x240.jpg\" src=\"https://img.alicdn.com/bao/uploaded/i3/TB1ebtnTrvpK1RjSZPiXXbmwXXa_.jpg_160x240.jpg','3D'),('6','五月天人生无限公司','112','一部电影拥有超过400万位演员，是怎样的体验？人生无限公司，每个参与过的人都是主演。每个“加班夜”都如此难舍难忘，演唱会内外，你的人生故事可有什么变与不变？五月天“人生无限公司”巡演，横跨四大洲、历时一年半、上百场巡回、超过400万观众，不断刷新纪录，不断创造新的感动。这部70亿人的自传，此刻翻越到下一章节：人生无限公司将在大银幕继续营业。','中国台湾',9,'剧情/纪录片/音乐','普通话','2019-05-24','https://img.alicdn.com/bao/uploaded/i4/TB1TVUuSXzqK1RjSZFoXXbfcXXa_.jpg_160x240.jpg','3D'),('7','一个母亲的复仇','146','本片改编自震惊印度的“德里黑公交案”。艾莉亚在一次派对活动后遭到强暴，面对凿凿证据，四名罪犯却被法庭判为无罪。艾莉亚的继母，戴维琪伤心欲绝，在走投无路后愤然决定亲手为女儿寻求正义，一场高能高智商的复仇大戏拉开序幕。正义到不了的地方，还有母亲！','印度',8.9,'剧情犯罪','印度语','2019-5-10','https://img.alicdn.com/bao/uploaded/i3/TB18H9aUpzqK1RjSZFvXXcB7VXa_.jpg_160x240.jpg','3D'),('8','X战警：黑凤凰','114','影片剧情围绕X战警中最受欢迎成员之一的琴·葛蕾展开，讲述她逐渐转化为黑凤凰的故事。在一次危及生命的太空营救行动中，琴被神秘的宇宙力量击中，成为最强大的变种人。此后琴·葛蕾不仅要设法掌控日益增长、极不稳定的力量，更要与自己内心的恶魔抗争，她的失控让整个X战警大家庭分崩离析，也让整个星球陷入毁灭的威胁之中。《X战警：黑凤凰》是迄今为止气氛最紧张、情感最丰富的一部《X战警》电影，是《X战警》系列20年来的集大成之作，大家非常熟悉和热爱的变种人大家庭即将面对最为强大的敌人——而她恰恰还是他们中的一员。','美国',0,'动作/科幻/冒险','英语','2019-06-06','https://img.alicdn.com/bao/uploaded/i1/TB1lqZLUW6qK1RjSZFmXXX0PFXa_.jpg_160x240.jpg','3D'),('9','何以为家','117','法庭上，十二岁的男孩赞恩向法官状告他的亲生父母，原因是，他们给了他生命。是什么样的经历让一个孩子做出如此不可思议的举动？故事中，赞恩的父母在无力抚养和教育的状况下依然不停生育，作为家中的长子赞恩，弱小的肩膀承担了无数生活的重压。当妹妹被强行卖给商贩为妻时，赞恩愤怒离家，之后遇到一对没有合法身份的母子，相互扶持勉强生活。然而生活并没有眷顾赞恩，重重磨难迫使他做出了令人震惊的举动……','巴黎嫩/法国/美国',9.1,'剧情','阿拉伯语','2019-04-29','https://img.alicdn.com/bao/uploaded/i1/TB1FbtbTwHqK1RjSZFkXXX.WFXa_.jpg_160x240.jpg','3D');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flim_release`
--

DROP TABLE IF EXISTS `flim_release`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flim_release` (
  `filmId` varchar(50) NOT NULL,
  `cinemaId` char(10) NOT NULL,
  `releaseDate` datetime NOT NULL,
  `releaseNum` int(11) NOT NULL,
  `releasePosition` int(11) NOT NULL,
  `cinemaName` varchar(60) NOT NULL,
  `releaseTime` varchar(32) NOT NULL,
  `filmName` char(30) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `01_idx` (`cinemaId`),
  KEY `flim_release_film_filmId_fk` (`filmId`),
  CONSTRAINT `flim_release_cinema_cinemaId_fk` FOREIGN KEY (`cinemaId`) REFERENCES `cinema` (`cinemaid`),
  CONSTRAINT `flim_release_film_filmId_fk` FOREIGN KEY (`filmId`) REFERENCES `film` (`filmid`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flim_release`
--

LOCK TABLES `flim_release` WRITE;
/*!40000 ALTER TABLE `flim_release` DISABLE KEYS */;
INSERT INTO `flim_release` VALUES ('7','10','2016-06-06 00:00:00',2,5,'保利国际影城——上海曹路宝龙店','20:15:00','一个母亲的复仇',7),('9','9','2016-06-05 00:00:00',2,2,'保利国际影城——上海曹路宝龙店','19:30:00','何以为家',8),('10','8','2016-06-05 00:00:00',3,2,'保利国际影城——上海曹路宝龙店','21:45:00','哆啦A梦：大雄的月球探险记',9),('2','11','2016-06-06 00:00:00',2,2,'百雅国际影城','17:15:00','哥斯拉2：怪兽之王',10),('9','12','2016-06-05 00:00:00',2,2,'保利国际影城——上海曹路宝龙店','19:30:00','何以为家',11),('5','11','2016-06-06 00:00:00',2,2,'百雅国际影城','17:15:00','追龙2',12),('5','1','2016-06-05 00:00:00',1,2,'保利国际影城——上海曹路宝龙店','17:15:00','追龙2',37),('1','1','2016-06-05 00:00:00',2,2,'保利国际影城——上海曹路宝龙店','19:30:00','阿拉丁',38),('10','1','2016-06-05 00:00:00',3,2,'保利国际影城——上海曹路宝龙店','21:45:00','哆啦A梦：大雄的月球探险记',39),('4','2','2016-06-04 00:00:00',1,3,'上海华策金球影城','17:45:00','大侦探皮卡丘',40),('4','2','2016-06-04 00:00:00',2,3,'上海华策金球影城','20:00:00','一条狗的使命',41),('1','3','2016-06-05 00:00:00',1,6,'上海金海影城','19:15:00','阿拉丁',42),('9','3','2016-06-05 00:00:00',2,6,'上海金海影城','21:20:00','何以为家',43),('6','1','2016-06-06 00:00:00',1,5,'保利国际影城——上海曹路宝龙店','17:15:00','五月天人生无限公司',44),('7','1','2016-06-06 00:00:00',2,5,'保利国际影城——上海曹路宝龙店','20:15:00','一个母亲的复仇',45),('6','2','2016-06-06 00:00:00',4,3,'上海华策金球影城','17:15:00','五月天人生无限公司',46),('5','2','2016-06-06 00:00:00',5,3,'上海华策金球影城','20:15:00','哥斯拉2：怪兽之王',47),('8','4','2016-06-06 00:00:00',1,2,'SFC上影影城（金桥太茂店）','17:15:00','X战警：黑凤凰',48),('5','4','2016-06-06 00:00:00',2,2,'SFC上影影城（金桥太茂店）','17:15:00','追龙2',49);
/*!40000 ALTER TABLE `flim_release` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grade` (
  `stuId` varchar(12) DEFAULT NULL,
  `subj` varchar(32) DEFAULT NULL,
  `score` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES ('20161113032','英语',85),('20161113032','语文',92),('20161113032','数学',93),('20161113033','英语',59),('20161113033','语文',88),('20161113033','数学',90),('20161113038','英语',52),('20161113038','语文',78),('20161113038','数学',68);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `useraccount` varchar(40) NOT NULL,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `gender` char(2) DEFAULT NULL,
  `headImg` varchar(255) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `selfIntroduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`useraccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('13457760487',NULL,NULL,NULL,NULL,NULL,NULL),('15078066652',NULL,'123456',NULL,NULL,NULL,NULL),('15900666317','hyt','123456',NULL,NULL,NULL,NULL),('17621603654','观影人','123456','女','upload/head_img.jpg','1997-10','喜欢看电影，尤其是剧情类的。');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_order`
--

DROP TABLE IF EXISTS `user_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_order` (
  `filmId` varchar(50) NOT NULL,
  `useracount` varchar(40) NOT NULL,
  `Cinema_id` char(10) NOT NULL,
  `Release_num` int(11) NOT NULL,
  `Release_position` int(11) NOT NULL,
  `Film_price` float(3,0) NOT NULL,
  `Cinema_name` varchar(60) NOT NULL,
  `Release_date` datetime NOT NULL,
  `Order_member` int(11) NOT NULL,
  `seat` int(11) NOT NULL,
  `filmName` char(30) DEFAULT NULL,
  PRIMARY KEY (`filmId`,`useracount`,`Cinema_id`),
  KEY `FK_user_order2` (`useracount`),
  KEY `FK_user_order3` (`Cinema_id`),
  CONSTRAINT `FK_user_order` FOREIGN KEY (`filmId`) REFERENCES `film` (`filmid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_user_order2` FOREIGN KEY (`useracount`) REFERENCES `user` (`useraccount`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_user_order3` FOREIGN KEY (`Cinema_id`) REFERENCES `cinema` (`cinemaId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order`
--

LOCK TABLES `user_order` WRITE;
/*!40000 ALTER TABLE `user_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'flimtiket'
--

--
-- Dumping routines for database 'flimtiket'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-29 11:54:41
