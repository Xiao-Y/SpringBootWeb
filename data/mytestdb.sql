/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : mytestdb

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2016-12-14 17:02:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '1', 'test_title', 'test_content');
INSERT INTO `t_article` VALUES ('2', '1', 'test_title_2', 'test_content_2');
INSERT INTO `t_article` VALUES ('3', '1', 'test_title_3', 'test_content_3');
INSERT INTO `t_article` VALUES ('4', '1', 'test_title_4', 'test_content_4');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionname` varchar(32) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'add', '2');
INSERT INTO `t_permission` VALUES ('2', 'del', '1');
INSERT INTO `t_permission` VALUES ('3', 'update', '2');
INSERT INTO `t_permission` VALUES ('4', 'query', '3');
INSERT INTO `t_permission` VALUES ('5', 'user:query', '1');
INSERT INTO `t_permission` VALUES ('6', 'user:edit', '2');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(32) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin');
INSERT INTO `t_role` VALUES ('2', 'manager');
INSERT INTO `t_role` VALUES ('3', 'normal');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `phone_number` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三533', '25', null, '15507529497');
INSERT INTO `t_user` VALUES ('2', '22222', '34', null, '15555555555');
INSERT INTO `t_user` VALUES ('3', 'eee', '23', null, '');
INSERT INTO `t_user` VALUES ('4', '张三', '24', null, '');
INSERT INTO `t_user` VALUES ('5', 'ggg', '22', null, '');
INSERT INTO `t_user` VALUES ('6', null, null, null, '');
INSERT INTO `t_user` VALUES ('7', null, null, null, '');
INSERT INTO `t_user` VALUES ('8', 'gggr', '34', null, '');
INSERT INTO `t_user` VALUES ('9', 'hhh', '23', null, '');
INSERT INTO `t_user` VALUES ('10', 'jjjjj', '33', null, '15555555555');
INSERT INTO `t_user` VALUES ('11', '12345', '22', null, '15555555555');
INSERT INTO `t_user` VALUES ('12', '22233', '23', null, '15555555555');
INSERT INTO `t_user` VALUES ('13', 'qqq', '23', null, '15507543456');
INSERT INTO `t_user` VALUES ('14', 'sss', '22', null, '15502543456');
INSERT INTO `t_user` VALUES ('15', 'www', '24', null, '15506543456');
INSERT INTO `t_user` VALUES ('16', 'rrr', '26', null, '15507573456');
INSERT INTO `t_user` VALUES ('17', 'ggg', '27', null, '15507213345');
INSERT INTO `t_user` VALUES ('18', 'ccc', '28', null, '15507547656');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('1', '3');
INSERT INTO `t_user_role` VALUES ('2', '2');
INSERT INTO `t_user_role` VALUES ('2', '3');
INSERT INTO `t_user_role` VALUES ('3', '3');
