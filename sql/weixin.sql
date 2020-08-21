
-- MySQL dump 10.13  Distrib 5.7.19, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: weixin
-- ------------------------------------------------------
-- Server version	5.7.19-log

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

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
--
-- Table structure for table `Video`
--

DROP TABLE IF EXISTS `Video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `createtime` bigint(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `coverImg` varchar(255) DEFAULT NULL,
  `playNum` bigint(11) DEFAULT 0,
  `commentNum` bigint(11) DEFAULT 0,
  `likes` bigint(11) DEFAULT 0,
  `videoUrl` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `block` varchar(255) DEFAULT NULL,
  `subClass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Video`
--

BEGIN;
/*!40000 ALTER TABLE `Video` DISABLE KEYS */;
INSERT INTO `Video` VALUES
(1,1,20200523,'【乐正绫】《华夏之章》【小旭PRO】【绛舞乱丸】','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/video_bc1.png',4798,2,3112,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159316153144321.mp4',"最近是FGO和FZ的联动活动，所以特地给了闪闪、呆毛、大帝一大堆镜头....孔明本身的动作场景不多，但我还是强行给塞进去了23333 另外就是切嗣爸爸，虽然我给你的戏份少，但我给你儿子的戏份多呀！！",'跑步','短跑'),
(2,1,20200623,'[ShowTime]大型装逼现场！','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/zhuangbi.png',8209,2,9762,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/15931615544638.mp4','那些上篮装逼时刻，不服来打我呀~','篮球','篮球技巧'),
(3,5,20200603,'【胖胖球】【双子星】【獒龙】荒岛 - El transcurrir de las horas','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/video_bc3.png',4891,2,5632,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159316156880224.mp4','荒岛是什么?我也不知道哈哈','其他','其他'),
(4,6,20200408,'撩人净土系列【红菱歌舞伎初音】极乐净土【大神犬PV付】MME配布','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/video_bc5.jpg',7621,2,4312,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159316157518526.mp4','撩人净土？东哥版悟空？东哥的兄弟！','健身','健身技巧'),
(5,3,20200302,'[科比]某场比赛，纪念科比','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/KOBE.png',9374,2,989,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/1593161584431103.mp4','某年某月某日，科比打的一场比赛','篮球','实战教学'),
(6,3,20200201,'回顾姚明的NBA生涯','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/yaoming.jpg',8789,5,878,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/yaoming.mp4','2003-09年连续6个赛季（生涯共8次）入选NBA全明星阵容，2次入选NBA最佳阵容二阵，3次入选NBA最佳阵容三阵',"篮球",'战术讲解'),
(7,4,20200510,'【基础动作】GTA5中的瑜伽','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/GTA5.jpg',2834,1,3412,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/GTA5.mp4','','瑜伽','基础动作'),
(8,4,20200430,'篮球对抗分析','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/lanqiu1.png',7835,1,5432,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159316166609531.mp4','比较精彩的双人对抗','篮球','战术讲解'),
(9,5,20200601,'比赛精彩时刻','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/lanqiu2.png',5832,1,2365,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159316172891059.mp4','解说下这场比赛','篮球','战术讲解'),
(10,2,20200228,'短跑教学示范','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/duanpao1.png',2834,1,235,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/1593168528914109.mp4','自己在家里做的短跑教学。观众姥爷点赞支持一下呗~','跑步','短跑'),
(11,3,20200331,'【德甲巨仁】拜仁慕尼黑19-20高燃混剪','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/159317207334978.png',6082,1,3637,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/1593172051999148.mp4','换帅如换刀，德甲八连冠的德国巨仁能否在欧冠有所斩获呢？一起欣赏拜仁本赛季的优秀表现吧！','足球','实战教学'),
(12,6,20200427,'【会挽雕弓如满月】世界杯精彩进球','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/159317262569542.png',9794,1,6423,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159317260223592.mp4','克罗斯任意球小角度绝杀加夸雷斯马凌空斩，让我们一起来欣赏吧','足球','实战教学'),
(13,5,20200523,'【Champions League】欧冠经典瞬间','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/15931726333601.png',987,43,1,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159317327227288.mp4','伴随着欧冠主题曲，让我们一起欣赏欧冠赛场上的经典时刻吧','足球','实战教学'),
(14,3,20200626,'【足球金童教你制霸绿茵场】帅气拉风的人球分过','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/159317265408222.png',1632,1,12,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/1593173291988113.mp4','学习一下，你就是野球场的亨利','足球','动作技巧'),
(15,4,20200618,'【八人制足球】阵型讲解','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/1593172662047105.png',2391,1,589,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159317334690725.mp4','八人制业余足球，如何打造一支全攻全守的平民梦之队','足球','战术讲解'),
(16,2,20200407,'【红军】渣叔的利物浦为何能战无不胜？','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/159317266858076.png',675,1,125,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159317335878232.mp4','本期战术讲解为大家揭秘欧冠冠军利物浦的制胜战术!','足球','实战教学'),
(17,1,20200321,'【足球金童教你制霸绿茵场】如何传出精确制导的地面球','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/1593172790110112.png',7805,0,3309,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159317337307714.mp4','学习一下，你就是野球场的齐达内!','足球','实战教学'),
(18,2,20190627,'【乒乓高手】如何发出上旋球','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/images/159317422253365.png',3642,0,923,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/videos/159317423342714.mp4','乒乓球达人手把手教你如何用发球制胜!','乒乓球','实战教学');
/*!40000 ALTER TABLE `Video` ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Danmu`
--

DROP TABLE IF EXISTS `Danmu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Danmu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `userImg` varchar(1000) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `likes` int(11) DEFAULT 0,
  `timelen` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Danmu`
--

BEGIN;
/*!40000 ALTER TABLE `Danmu` DISABLE KEYS */;
INSERT INTO `Danmu` VALUES (1,1,2,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/xlanjing.jpg','小蓝鲸','第1s出现的弹幕','#ff0000',146,1),
(2,2,3,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/yezhu.jpg','秋名山野猪','第4s出现的弹幕','#ff00ff',109,4),
(3,3,4,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/lzx.jpg','多人运动带师','第2s出现的弹幕','#ff00ff',81,2),
(4,4,5,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/258.jpg','孙笑川258','第4s出现的弹幕','#ff0000',74,4),
(5,5,6,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/dongge.jpg','明尼苏达的一声炮响','第5s出现的弹幕','#ff00ff',108,5),
(6,6,3,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/yezhu.jpg','秋名山野猪','第6s出现的弹幕','#ff00ff',141,6),
(7,7,2,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/xlanjing.jpg','小蓝鲸','第7s出现的弹幕','#ff0000',84,7),
(8,8,4,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/lzx.jpg','多人运动带师','第8s出现的弹幕','#ff00ff',118,8),
(9,9,6,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/dongge.jpg','明尼苏达的一声炮响','第9s出现的弹幕','#ff00ff',32,9),
(10,10,5,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/258.jpg','孙笑川258','第10s出现的弹幕','#ff0000',68,10),
(11,11,2,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/xlanjing.jpg','小蓝鲸','第11s出现的弹幕','#ff00ff',164,11),
(12,12,3,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/yezhu.jpg','秋名山野猪','第12s出现的弹幕','#ff00ff',123,12),
(13,13,2,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/xlanjing.jpg','小蓝鲸','第13s出现的弹幕','#ff0000',35,13),
(14,14,4,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/lzx.jpg','多人运动带师','第14s出现的弹幕','#ff00ff',127,14),
(15,15,2,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/xlanjing.jpg','小蓝鲸','第2s出现的弹幕','#ff00ff',130,2),
(16,6,5,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/258.jpg','孙笑川258','第1s出现的弹幕','#ff0000',132,1),
(17,6,3,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/yezhu.jpg','秋名山野猪','第3s出现的弹幕','#ff00ff',174,3),
(18,6,2,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/xlanjing.jpg','小蓝鲸','第9s出现的弹幕','#ff00ff',59,9),
(19,1,6,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/dongge.jpg','明尼苏达的一声炮响','第10s出现的弹幕','#ff0000',96,10),
(20,2,4,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/lzx.jpg','多人运动带师','第2s出现的弹幕','#ff00ff',71,2),
(21,3,3,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/yezhu.jpg','秋名山野猪','第21s出现的弹幕','#ff00ff',231,21),
(22,4,2,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/xlanjing.jpg','小蓝鲸','第22s出现的弹幕','#ff0000',123,22),
(23,5,5,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/258.jpg','孙笑川258','第14s出现的弹幕','#ff00ff',126,14),
(24,6,6,'https://fengliu-123.oss-cn-shanghai.aliyuncs.com/dongge.jpg','明尼苏达的一声炮响','第23s出现的弹幕','#ff00ff',87,23);
/*!40000 ALTER TABLE `Danmu` ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `img` varchar(1000) DEFAULT NULL,
  `fansNum` bigint(11) DEFAULT 0,
  `concern` bigint(11) DEFAULT 0,
  `collect` varchar(1000) DEFAULT NULL,
  `history` varchar(1000) DEFAULT NULL,
  `likes` varchar(1000) DEFAULT NULL,
  `likeDanmu` varchar(1000) DEFAULT NULL,
  `guanzhu` varchar(1000) DEFAULT NULL,
  `fans` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

BEGIN;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'小网红','../../imageIcon/niming.png',0,0,"","","","","",""),
(2,'小蓝鲸','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/xlanjing.jpg',0,0,'3,4,5,6','7,6,4,2','','','',''),
(3,'秋名山野猪','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/yezhu.jpg',0,0,'','','','','',''),
(4,'多人运动带师','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/lzx.jpg',0,0,'','','','','',''),
(5,'孙笑川258','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/258.jpg',0,0,'','','','','',''),
(6,'明尼苏达的一声炮响','https://fengliu-123.oss-cn-shanghai.aliyuncs.com/dongge.jpg',0,0,'','','','','','');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
COMMIT;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-12 10:08:42
SET FOREIGN_KEY_CHECKS = 1;