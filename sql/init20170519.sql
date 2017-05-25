-- 创建库
CREATE DATABASE `wjw` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- 楼盘表
CREATE TABLE `loupan` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `cityName` varchar(45) NOT NULL,
  `districtName` varchar(45) NOT NULL,
  `avgPrice` decimal(9,2) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `statFunctions` int(11) NOT NULL DEFAULT '0',
  `structFunctions` int(11) NOT NULL DEFAULT '0',
  `decoItems` int(11) NOT NULL DEFAULT '0',
  `ageLimits` int(11) NOT NULL DEFAULT '0',
  `layouts` int(11) NOT NULL DEFAULT '0',
  `developerName` varchar(45) DEFAULT NULL,
  `traffic` varchar(200) DEFAULT NULL,
  `equipment` varchar(200) DEFAULT NULL,
  `siteArea` decimal(9,2) DEFAULT NULL,
  `buildArea` decimal(9,2) DEFAULT NULL,
  `ratio` decimal(5,2) DEFAULT NULL,
  `greenRate` decimal(5,2) DEFAULT NULL,
  `carRate` varchar(15) DEFAULT NULL,
  `buildingCnt` int(11) DEFAULT NULL,
  `roomCnt` int(11) DEFAULT NULL,
  `propertyFee` decimal(9,2) DEFAULT NULL,
  `propertyName` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `linkerPhone` varchar(20) NOT NULL,
  `flag` int NOT NULL DEFAULT '0',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `creator` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updator` int(11) NOT NULL,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idx_name` (`name`),
  KEY `idx_updateTime` (`updateTime`),
  KEY `idx_avgPrice` (`avgPrice`),
  KEY `idx_districtName` (`districtName`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 楼盘图片表
CREATE TABLE `loupan_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loupanId` bigint(20) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `picUrl` varchar(50) NOT NULL,
  `main` bit NOT NULL DEFAULT '0',
  `creator` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- user 表
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `salt` char(32) NOT NULL,
  `password` char(32) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `creator` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updator` int(11) NOT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


-- 创建管理员用户
INSERT INTO `user`
		(
		`userName`,
		`salt`,
		`password`,
		`creator`,
		`updator`)
		VALUES
		(
		'admin',
		'ilovegod',
		md5(concat('ilovegod',md5('admin!@#$'))),
		1,
		1
		);