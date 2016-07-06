/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.46 : Database - shixun
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shixun` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shixun`;

/*Table structure for table `buy_items` */

DROP TABLE IF EXISTS `buy_items`;

CREATE TABLE `buy_items` (
  `itemID` int(10) NOT NULL,
  `buy_Time` varchar(20) NOT NULL,
  `userID` int(10) NOT NULL,
  `itemPrice` int(20) NOT NULL,
  `itemNumber` int(20) NOT NULL,
  `itemName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `buy_items` */

insert  into `buy_items`(`itemID`,`buy_Time`,`userID`,`itemPrice`,`itemNumber`,`itemName`) values (7,'2016-06-29',1,40,1,'镂空V领T恤'),(46,'2016-06-30',5,12,1,'Spring实战');

/*Table structure for table `cars` */

DROP TABLE IF EXISTS `cars`;

CREATE TABLE `cars` (
  `itemID` int(20) DEFAULT NULL,
  `userID` int(20) NOT NULL,
  `itemPrice` int(20) DEFAULT NULL,
  `itemName` varchar(20) DEFAULT NULL,
  `itemImage` varchar(40) DEFAULT NULL,
  `itemNumber` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cars` */

insert  into `cars`(`itemID`,`userID`,`itemPrice`,`itemName`,`itemImage`,`itemNumber`) values (9,1,50,'欧根纱两件套连衣裙','9.jpg',1),(5,1,20,'复古大框偏光太阳镜','5.jpg',1),(52,5,10,'床上书桌','53.jpg',1),(9,5,50,'欧根纱两件套连衣裙','9.jpg',1);

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `image` varchar(60) NOT NULL,
  `name` varchar(20) NOT NULL,
  `discription` varchar(40) NOT NULL,
  `price` int(10) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `hot` int(20) DEFAULT '0',
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

/*Data for the table `items` */

insert  into `items`(`id`,`image`,`name`,`discription`,`price`,`contact`,`hot`,`type`) values (1,'1.jpg','智能手表','很高科技',100,'152436161117',300,'数码产品'),(4,'4.jpg','防晒风衣','只穿过一次',50,'16660262095',0,'美妆服饰'),(5,'5.jpg','复古大框偏光太阳镜','女生戴着很帅气',20,'18040697018',100,'美妆服饰'),(6,'6.jpg','韩国V7素颜霜','还有很多没用',30,'19367413893',100,'美妆服饰'),(7,'7.jpg','镂空V领T恤','很好看,M码',40,'16064772951',400,'美妆服饰'),(8,'8.jpg','牛仔拼接连衣裙','穿着很漂亮',40,'16694736065',100,'美妆服饰'),(9,'9.jpg','欧根纱两件套连衣裙','材质很好',50,'16833879015',200,'美妆服饰'),(10,'10.jpg','倩碧润肤乳','很好用的牌子',20,'16833879015',0,'美妆服饰'),(11,'12.jpg','水宝宝防晒霜','很方便',20,'18763699886',0,'美妆服饰'),(12,'13.jpg','条纹A字裙','男生穿着都好看',30,'18801787792',0,'美妆服饰'),(13,'14.jpg','雅诗兰黛精华露','弹走皱纹',30,'18801787792',0,'美妆服饰'),(14,'15.jpg','依泉舒缓保湿喷雾','很保湿',20,'15045622631',0,'美妆服饰'),(15,'16.jpg','印花短裙套装','好看',100,'16482263514',0,'美妆服饰'),(16,'17.jpg','印花复古猫眼太阳镜','巨好看',30,'15065507132',0,'美妆服饰'),(17,'18.jpg','御泥坊面膜','好用',50,'15284116775',0,'美妆服饰'),(18,'19.jpg','资生堂洁面乳套装','很划算',80,'18826153956',0,'美妆服饰'),(19,'20.jpg','自然乐园芦荟胶','很健康',50,'16386820829',0,'美妆服饰'),(20,'21.jpg','字母休闲T恤','很休闲',25,'17156571390',0,'美妆服饰'),(21,'2.jpg','iPhone手机','九成新甩卖',3000,'15074048527',0,'数码产品'),(22,'3.jpg','智能手表','很高科技',100,'13386960435',0,'数码产品'),(23,'24.jpg','数码相机','和女票分手了，没有人可以拍',400,'15649747898',0,'数码产品'),(24,'25.jpg','耳机','适合运动的时候戴',30,'18932117825',0,'数码产品'),(25,'27.jpg','粉色笔记本','颜值很高的电脑',2500,'15794843550',0,'数码产品'),(26,'28.jpg','大音响','音效很棒',360,'15876119856',0,'数码产品'),(27,'29.jpg','音响','九成新',250,'15626227448',0,'数码产品'),(28,'30.jpg','国产手机','电池很耐用',600,'13741618975',0,'数码产品'),(29,'31.jpg','oppo手机','白色的很好看',1200,'13885918190',0,'数码产品'),(30,'32.jpg','iPhone10','最新的iPhone手机',250,'15941975035',0,'数码产品'),(31,'33.jpg','拍立得照相机','很方便使用',2500,'15048790637',0,'数码产品'),(32,'34.jpg','摄像机','才用了两个月',900,'13004383764',0,'数码产品'),(33,'35.jpg','粉色耳机','音效不错',25,'13796633815',0,'数码产品'),(34,'36.jpg','sony耳机','品牌耳机',380,'15705794677',0,'数码产品'),(35,'38.jpg','运动式耳机','适合跑步听',20,'13531858319',0,'数码产品'),(36,'39.jpg','智能耳机','黑科技',999,'13579858863',0,'数码产品'),(37,'ipod.jpg','lpod','很好用',60,'15659527647',0,'数码产品'),(38,'sonymp3.jpg','mp3附带耳机','人帅不要钱',1,'13440381075',0,'数码产品'),(39,'kindle.jpg','kindle','人丑就要多读书',150,'13078170543',0,'数码产品'),(40,'kindle+touch.jpg','kindle+touch','好读书，不求甚解',250,'13437488010',0,'数码产品'),(41,'CSS.jpg','CSS揭秘','从入门到放弃',20,'15762862392',0,'图书教材'),(42,'Javascript.jpg','Javascript','从入门到放弃',25,'15293345456',0,'图书教材'),(43,'Linux.jpg','Linux环境编程：从应用到内核','从入门到放弃',38,'13378296487',0,'图书教材'),(44,'Photoshop_CS6.jpg','Photoshop_CS6从入门到精通','从入门到放弃',40,'15186558335',0,'图书教材'),(45,'Python.jpg','Python学习手册','从入门到放弃',29,'15742913925',100,'图书教材'),(46,'Spring.jpg','Spring实战','从入门到放弃',12,'18834393701',100,'图书教材'),(47,'40.jpg','白夜行','变态恋童癖',30,'18871034264',100,'图书教材'),(48,'41.jpg','百年孤独','单身孤独',25,'15136017949',0,'图书教材'),(49,'50.jpg','不锈钢电热锅','毕业大甩卖',20,'13115843922',0,'生活其他'),(50,'51.jpg','充电小台灯','毕业大甩卖',10,'13334735830',0,'生活其他'),(51,'52.jpg','抽屉收纳盒','毕业大甩卖',15,'18924582414',0,'生活其他'),(52,'53.jpg','床上书桌','毕业大甩卖',10,'15309138764',100,'生活其他'),(53,'54.jpg','床上书桌','毕业大甩卖',12,'15513261405',0,'生活其他'),(54,'55.jpg','床上书桌电脑桌','毕业大甩卖',13,'13925921269',0,'生活其他'),(55,'55.jpg','自行车','毕业大甩卖',80,'15751891641',100,'生活其他'),(56,'bike05.jpg','自行车','毕业大甩卖',60,'13943139262',0,'生活其他'),(57,'56.jpg','自行车','九成新的车',100,'13199424495',0,'生活其他'),(58,'bike04.jpg','自行车','很漂亮的车',70,'15260580696',0,'生活其他'),(59,'bike10.jpg','自行车','偷来的',150,'13087549099',0,'生活其他'),(60,'bike01.jpg','自行车','室友的车',88,'15693659057',0,'生活其他');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userID`),
  KEY `checkUser` (`username`,`password`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`username`,`password`,`contact`,`address`,`userID`) values ('admin','admin','110','长沙',1),('zl','zl','15243616117','岳阳',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
