/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : mytestdb

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2016-11-30 18:00:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `name` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '23', null, null);
INSERT INTO `t_user` VALUES ('2', '222', '34', null, null);
INSERT INTO `t_user` VALUES ('3', 'eee', '23', null, null);
