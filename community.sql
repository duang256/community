/*
Navicat MySQL Data Transfer

Source Server         : wit
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : community

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2022-02-21 23:36:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `communityid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `admin_community_fk` (`communityid`),
  CONSTRAINT `admin_community_fk` FOREIGN KEY (`communityid`) REFERENCES `communityinfo` (`communityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'root', 'root', '1');

-- ----------------------------
-- Table structure for `announcement`
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `announceid` int(10) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(50) NOT NULL COMMENT '公告标题',
  `announcetime` datetime NOT NULL COMMENT '公告发布时间',
  `content` text NOT NULL COMMENT '公告内容',
  `communityid` int(10) NOT NULL COMMENT '社区外键',
  PRIMARY KEY (`announceid`),
  KEY `announce_community_fk` (`communityid`),
  CONSTRAINT `announce_community_fk` FOREIGN KEY (`communityid`) REFERENCES `communityinfo` (`communityid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('1', '123', '2022-02-20 23:35:12', '1478928198298', '1');
INSERT INTO `announcement` VALUES ('3', 'adas', '2022-02-21 00:00:00', 'niafhiosiofhi', '1');

-- ----------------------------
-- Table structure for `communityinfo`
-- ----------------------------
DROP TABLE IF EXISTS `communityinfo`;
CREATE TABLE `communityinfo` (
  `communityid` int(10) NOT NULL AUTO_INCREMENT,
  `communityname` varchar(20) NOT NULL COMMENT '社区名称',
  `location` varchar(50) NOT NULL COMMENT '社区地址',
  PRIMARY KEY (`communityid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of communityinfo
-- ----------------------------
INSERT INTO `communityinfo` VALUES ('1', '融创壹号', '湖北省武汉市武昌区公正路');
INSERT INTO `communityinfo` VALUES ('13', '泰塑', '泰塑');

-- ----------------------------
-- Table structure for `concentrationquarantine`
-- ----------------------------
DROP TABLE IF EXISTS `concentrationquarantine`;
CREATE TABLE `concentrationquarantine` (
  `concentrationid` int(10) NOT NULL AUTO_INCREMENT COMMENT '集中隔离id',
  `starttime` date NOT NULL COMMENT '隔离开始时间',
  `quarantineaddress` varchar(100) NOT NULL COMMENT '集中隔离地点',
  PRIMARY KEY (`concentrationid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of concentrationquarantine
-- ----------------------------
INSERT INTO `concentrationquarantine` VALUES ('1', '2022-02-21', '112312333113');

-- ----------------------------
-- Table structure for `homequarantine`
-- ----------------------------
DROP TABLE IF EXISTS `homequarantine`;
CREATE TABLE `homequarantine` (
  `homeid` int(10) NOT NULL AUTO_INCREMENT COMMENT '居家隔离id',
  `starttime` date NOT NULL COMMENT '居家隔离开始时间',
  PRIMARY KEY (`homeid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homequarantine
-- ----------------------------
INSERT INTO `homequarantine` VALUES ('1', '2022-02-16');

-- ----------------------------
-- Table structure for `household`
-- ----------------------------
DROP TABLE IF EXISTS `household`;
CREATE TABLE `household` (
  `householdid` int(10) NOT NULL AUTO_INCREMENT COMMENT '户id',
  `unit` varchar(4) NOT NULL,
  `building` int(4) NOT NULL COMMENT '楼栋号',
  `room` int(4) NOT NULL COMMENT '房间号',
  PRIMARY KEY (`householdid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of household
-- ----------------------------
INSERT INTO `household` VALUES ('1', 'B', '3', '503');
INSERT INTO `household` VALUES ('7', 'D1', '1', '503');

-- ----------------------------
-- Table structure for `route`
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `routeid` int(10) NOT NULL COMMENT '行程id',
  `uid` int(10) NOT NULL,
  `place` varchar(100) NOT NULL COMMENT '经过地点',
  `arrivaltime` date NOT NULL COMMENT '经过该地点时间',
  PRIMARY KEY (`routeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of route
-- ----------------------------
INSERT INTO `route` VALUES ('1', '2', '武汉', '2021-12-27');

-- ----------------------------
-- Table structure for `temperature`
-- ----------------------------
DROP TABLE IF EXISTS `temperature`;
CREATE TABLE `temperature` (
  `tid` int(10) NOT NULL AUTO_INCREMENT,
  `temperature` double NOT NULL,
  `date` date NOT NULL,
  `uid` int(10) NOT NULL,
  PRIMARY KEY (`tid`),
  KEY `temperature_user_fk` (`uid`),
  CONSTRAINT `temperature_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temperature
-- ----------------------------
INSERT INTO `temperature` VALUES ('1', '36.5', '2022-02-21', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `username` varchar(50) NOT NULL COMMENT '登录名',
  `password` varchar(50) NOT NULL COMMENT '登录密码',
  `name` varchar(20) NOT NULL COMMENT '用户姓名',
  `sex` int(4) NOT NULL COMMENT '性别，0表示女，1表示男',
  `identityNumber` char(18) NOT NULL COMMENT '18位身份证号',
  `phoneNumber` varchar(20) NOT NULL COMMENT '11位电话号码',
  `status` varchar(10) DEFAULT '正常' COMMENT '正常、确诊、疑似、密接4种状态，确诊密接是集中隔离，疑似居家隔离。',
  `firstVaccine` date DEFAULT NULL COMMENT '第一针疫苗',
  `secondVaccine` date DEFAULT NULL COMMENT '第一针疫苗',
  `thirdVaccine` date DEFAULT NULL COMMENT '第三针疫苗',
  `latestDetection` datetime DEFAULT NULL COMMENT '最近一次核酸时间',
  `concentrationid` int(10) DEFAULT NULL COMMENT '集中隔离外键',
  `homeid` int(10) DEFAULT NULL COMMENT '居家隔离表外键',
  `householdid` int(10) NOT NULL COMMENT '户表外键',
  `communityid` int(10) NOT NULL COMMENT '社区',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`),
  KEY `user_concentration_fk` (`concentrationid`),
  KEY `user_home_fk` (`homeid`),
  KEY `user_household_fk` (`householdid`),
  KEY `user_community_fk` (`communityid`),
  CONSTRAINT `user_community_fk` FOREIGN KEY (`communityid`) REFERENCES `communityinfo` (`communityid`),
  CONSTRAINT `user_concentration_fk` FOREIGN KEY (`concentrationid`) REFERENCES `concentrationquarantine` (`concentrationid`),
  CONSTRAINT `user_home_fk` FOREIGN KEY (`homeid`) REFERENCES `homequarantine` (`homeid`),
  CONSTRAINT `user_household_fk` FOREIGN KEY (`householdid`) REFERENCES `household` (`householdid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'yanyue', '123', 'yanyue1', '1', '429004200110234317', '18372879804', '正常', '2022-02-02', '2022-03-10', '2022-02-09', '2022-02-21 00:00:00', '1', null, '1', '1');
INSERT INTO `user` VALUES ('6', 'wangxin', '123', 'wangxin', '1', '1231313123', '13123123123', '疑似', '2022-02-01', '2022-02-02', '2022-02-03', null, null, '1', '7', '13');
