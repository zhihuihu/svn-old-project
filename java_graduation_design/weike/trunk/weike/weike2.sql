/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : weike

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-05-17 21:59:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `activity_user` int(11) NOT NULL,
  `activity_data` varchar(32) NOT NULL,
  `activity_place` varchar(128) NOT NULL,
  `activity_theme` varchar(64) DEFAULT NULL,
  `activity_watch` varchar(256) DEFAULT NULL,
  `activity_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `FK_class_activity` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '2', '2', '2016-04-18 21:07:56', '西华大学图书馆', '计算机', '注意事项！', '1');
INSERT INTO `activity` VALUES ('2', '2', '2', '2016-04-19 23:14:43', '西华大学图书馆', '计算机', '注意事项！', '1');
INSERT INTO `activity` VALUES ('3', '2', '2', '2016-05-20 22:39:34', '西华大学图书馆', '计算机', '注意事项！', '1');
INSERT INTO `activity` VALUES ('5', '3', '2', '2016-05-17 12:46', '地点', '舞蹈主题', '1.注意事项', '1');
INSERT INTO `activity` VALUES ('6', '3', '2', '2016-05-19 12:46', '地点', '舞蹈主题', '1.注意事项', '1');
INSERT INTO `activity` VALUES ('9', '4', '3', '2016-05-17 16:35', '西华大学一食堂', '音乐鉴赏课后指导', '1.准时参加\n2.提前准备好问题', '1');
INSERT INTO `activity` VALUES ('10', '1', '3', '2016-05-17 21:03', '西华大学图书馆', '前端入门现场指导', '1.在线学习完成\n2.会一些基本的基础知识\n3.提前准备问题', '1');
INSERT INTO `activity` VALUES ('11', '1', '3', '2016-05-17 19:11', '六', '前端', '注意事项', '1');

-- ----------------------------
-- Table structure for ask
-- ----------------------------
DROP TABLE IF EXISTS `ask`;
CREATE TABLE `ask` (
  `ask_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `asker_id` int(11) NOT NULL,
  `anser_id` int(11) NOT NULL,
  `ask_time` datetime NOT NULL,
  `ask_text` varchar(1024) NOT NULL,
  `ask_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`ask_id`),
  KEY `FK_ask_class` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ask
-- ----------------------------
INSERT INTO `ask` VALUES ('1', '1', '1', '1', '2016-05-17 17:44:41', '这是一个留言', '1');
INSERT INTO `ask` VALUES ('2', '1', '0', '2', '2016-04-16 17:45:59', '这是一个留言askId =0', '1');
INSERT INTO `ask` VALUES ('3', '1', '1', '1', '2016-04-17 09:11:51', '这是一个留言', '1');
INSERT INTO `ask` VALUES ('4', '1', '1', '1', '2016-04-18 20:01:38', '这是一个留言', '1');
INSERT INTO `ask` VALUES ('5', '1', '1', '1', '2016-04-18 20:04:07', '这是一个留言', '1');
INSERT INTO `ask` VALUES ('6', '1', '0', '3', '2016-04-18 20:13:49', '这是一个留言', '1');
INSERT INTO `ask` VALUES ('7', '1', '1', '1', '2016-04-18 21:07:47', '这是一个留言', '1');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(64) NOT NULL,
  `Attribute_35` varchar(64) DEFAULT NULL,
  `book_reason` varchar(256) DEFAULT NULL,
  `book_url` varchar(1024) DEFAULT NULL,
  `book_data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `book_author` varchar(256) DEFAULT NULL,
  `book_publish` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'Web前端开发技术', 'web;html;css;js', '此书紧密结合互联网行业发展对Web前端开发工程师岗位的技术与能力的需求，详细介绍了HTML、CSS、DIV、JavaScript、DOM与BOM几大组成部分的基本语法和关键应用。内容编排结构合理，由浅入深、循序渐进地引导读者快速入门，并能提高初级及以上读者的实际应用水平，让读者能够快速适应岗位的需求。', 'http://product.dangdang.com/23292452.html', '2016-05-16 21:40:46', '储久良', '清华大学出版社');
INSERT INTO `book` VALUES ('2', '数码单反摄影入门与提高', '摄影;单反', '本书是为摄影爱好者量身打造的一本数码单反摄影实用教程。在硬件使用、摄影技法与常见拍摄题材三个方面，对相关知识进行了深入剖析与详尽的讲解。为了将理论与实践结合起来，对等多种常见摄影题材的拍摄技法及拍摄要点进行了深入剖析。即使是接触摄影不长时间的读者，也能够通过阅读本书在较短的时间内掌握摄影技能，提升摄影水平，拍摄出令人满意的摄影作品。 ', 'http://product.dangdang.com/23775798.html', '2016-05-17 18:47:17', 'FUN视觉', '化学工业出版社');
INSERT INTO `book` VALUES ('3', 'Javascript基础', 'html;css;js', '此书紧密结合互联网行业发展对Web前端开发工程师岗位的技术与能力的需求，详细介绍了HTML、CSS、DIV、JavaScript、DOM与BOM几大组成部分的基本语法和关键应用。内容编排结构合理，由浅入深、循序渐进地引导读者快速入门，并能提高初级及以上读者的实际应用水平，让读者能够快速适应岗位的需求。', 'http://product.dangdang.com/23292452.html', '2016-05-16 21:41:28', '作者', '出版社');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(64) NOT NULL,
  `user_id` int(11) NOT NULL,
  `class_keyword` varchar(64) NOT NULL,
  `class_tag` int(11) NOT NULL,
  `class_start` datetime NOT NULL,
  `class_end` datetime NOT NULL,
  `class_description` varchar(256) NOT NULL,
  `class_count` int(11) NOT NULL,
  `class_star` int(11) DEFAULT NULL,
  `class_person` int(11) DEFAULT NULL,
  `class_liveness` int(11) DEFAULT NULL,
  `class_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '前端入门', '3', 'html;css;js', '1', '2016-04-18 22:09:37', '2016-04-18 22:09:37', '本课程主要讲解web前端入门知识。', '13', '3', '100', '32', '1');
INSERT INTO `class` VALUES ('2', '单反使用入门', '3', '单反', '2', '2016-04-28 00:00:00', '2016-05-12 09:45:08', '本课程将具体讲解相机基本构造，让选课学生从一个摄影爱好者，甚至是菜鸟，变成能熟练掌握单反的基本操作，变得更加专业！', '4', '0', '0', '0', '1');
INSERT INTO `class` VALUES ('3', '舞蹈视频', '3', '舞蹈', '3', '2016-05-31 00:08:00', '2016-06-30 00:00:32', '本课程提供几个简短舞蹈视频供大家学习', '3', '0', '0', '0', '3');
INSERT INTO `class` VALUES ('4', '音乐鉴赏', '3', '音乐', '4', '2016-05-01 14:23:39', '2016-05-31 14:23:49', '本课程音乐教程', '4', '0', '0', '0', '2');

-- ----------------------------
-- Table structure for class_book
-- ----------------------------
DROP TABLE IF EXISTS `class_book`;
CREATE TABLE `class_book` (
  `class_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  PRIMARY KEY (`class_id`,`book_id`),
  KEY `FK_class_book2` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_book
-- ----------------------------

-- ----------------------------
-- Table structure for class_session
-- ----------------------------
DROP TABLE IF EXISTS `class_session`;
CREATE TABLE `class_session` (
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `session_name` varchar(64) NOT NULL,
  `session_url` varchar(512) NOT NULL,
  `session_free` tinyint(1) NOT NULL,
  `session_value` int(11) NOT NULL,
  `session_brith` date NOT NULL,
  PRIMARY KEY (`session_id`),
  KEY `FK_class_session` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_session
-- ----------------------------
INSERT INTO `class_session` VALUES ('1', '2', '单反-课时1', 'url1', '1', '1', '2016-04-20');
INSERT INTO `class_session` VALUES ('2', '2', '单反-课时2', 'url2', '1', '2', '2016-04-22');
INSERT INTO `class_session` VALUES ('3', '2', '单反-课时3', 'url3', '0', '3', '2016-04-24');
INSERT INTO `class_session` VALUES ('4', '1', '前端-课时1', 'webUrl1', '1', '1', '2016-05-14');
INSERT INTO `class_session` VALUES ('5', '1', '前端-课时2', 'webUrl2', '1', '1', '2016-05-15');
INSERT INTO `class_session` VALUES ('6', '1', '前端-课时3', 'webUrl3', '0', '3', '2016-05-16');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `exam_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `exam_name` varchar(128) NOT NULL,
  `exam_ans` varchar(256) DEFAULT NULL,
  `exam_value` int(11) NOT NULL,
  `exam_state` int(11) DEFAULT NULL,
  `exam_createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`exam_id`),
  KEY `FK_class_exam` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('1', '2', '题目', '答案', '3', '1', '2016-04-19 23:14:47');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `report_id` int(11) NOT NULL AUTO_INCREMENT,
  `ask_id` int(11) NOT NULL,
  `reporter_id` int(11) NOT NULL,
  `report_time` datetime NOT NULL,
  `report_reason` varchar(256) NOT NULL,
  PRIMARY KEY (`report_id`),
  KEY `FK_report_reply` (`ask_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('2', '1', '1', '2016-04-16 16:51:00', '内容不健康');
INSERT INTO `report` VALUES ('3', '3', '2', '2016-04-16 16:56:37', '内容不健康,就更新你');
INSERT INTO `report` VALUES ('4', '1', '1', '2016-04-16 16:51:43', '内容不健康');
INSERT INTO `report` VALUES ('5', '1', '1', '2016-04-16 16:56:23', '内容不健康');
INSERT INTO `report` VALUES ('6', '1', '1', '2016-04-24 22:38:23', '内容不健康');
INSERT INTO `report` VALUES ('7', '1', '1', '2016-05-04 16:34:14', '内容不健康');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_emaile` varchar(64) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `user_vip` tinyint(1) DEFAULT NULL,
  `user_teacher` tinyint(1) DEFAULT NULL,
  `user_experience` int(11) DEFAULT NULL,
  `user_interest` varchar(64) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_state` int(11) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `user_edu` varchar(8) DEFAULT NULL,
  `user_createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', 'dy@qq.com', 'dy', '1', '0', '300', '', '16', '1', '1', '大学', '2016-04-19 23:39:36');
INSERT INTO `user` VALUES ('2', null, '123', null, '0', '0', null, '0', '0', '0', null, '2016-04-27 22:31:41');
INSERT INTO `user` VALUES ('3', '111', '123', null, '1', '0', '1;2;3', '0', '0', '0', null, '2016-04-28 10:32:35');
INSERT INTO `user` VALUES ('4', '342252183@qq.com', 'dy', null, '0', '0', null, '0', '0', '0', null, '2016-04-28 11:04:32');
INSERT INTO `user` VALUES ('5', '11', '11', null, '1', '0', null, '0', '0', '0', null, '2016-04-28 13:15:00');
INSERT INTO `user` VALUES ('6', '962410196', 'dd', null, '0', '0', null, '0', '0', '0', null, '2016-04-28 13:23:09');
INSERT INTO `user` VALUES ('7', '222', '22', null, '0', '0', null, '0', '0', '0', null, '2016-04-28 13:24:01');
INSERT INTO `user` VALUES ('8', '123', null, null, '0', '0', null, '0', '0', '0', null, '2016-04-28 13:41:25');
INSERT INTO `user` VALUES ('9', '1111', '11', null, '0', '0', null, '0', '0', '0', null, '2016-04-28 13:43:15');
INSERT INTO `user` VALUES ('10', '1234', '11', null, '0', '0', null, '0', '0', '0', null, '2016-04-28 13:50:14');
INSERT INTO `user` VALUES ('11', '11111', '11', null, '0', '0', null, '0', '0', '0', null, '2016-04-28 13:52:17');
INSERT INTO `user` VALUES ('12', '1111112', '11', null, '0', '0', null, '0', '0', '0', null, '2016-04-28 13:56:36');
INSERT INTO `user` VALUES ('13', '12', '11', null, '0', '0', null, '0', '0', '0', null, '2016-04-28 13:57:05');
INSERT INTO `user` VALUES ('14', '5678', '111', '0', '0', '0', '1;2;3;4;5', '23', '0', '1', '其他', '2016-05-16 10:32:30');

-- ----------------------------
-- Table structure for user_class
-- ----------------------------
DROP TABLE IF EXISTS `user_class`;
CREATE TABLE `user_class` (
  `class_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `study_progress` float unsigned zerofill DEFAULT NULL,
  `study_off` tinyint(1) DEFAULT NULL,
  `study_attention` tinyint(1) DEFAULT NULL,
  `user_star` int(11) DEFAULT NULL,
  `user_class_createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`class_id`,`user_id`),
  KEY `FK_user_class2` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_class
-- ----------------------------
INSERT INTO `user_class` VALUES ('1', '3', null, null, '1', '0', '2016-05-17 19:07:08');
INSERT INTO `user_class` VALUES ('2', '3', null, null, '1', '0', '2016-05-15 13:46:21');
INSERT INTO `user_class` VALUES ('2', '4', null, null, '1', '0', '2016-05-14 17:34:18');
INSERT INTO `user_class` VALUES ('2', '14', null, null, '1', '0', '2016-05-16 13:06:22');
INSERT INTO `user_class` VALUES ('3', '3', null, null, '1', '0', '2016-05-17 19:16:22');
INSERT INTO `user_class` VALUES ('3', '14', null, null, '1', '0', '2016-05-16 14:27:16');
INSERT INTO `user_class` VALUES ('4', '3', null, null, '1', '0', '2016-05-17 19:16:58');
INSERT INTO `user_class` VALUES ('4', '14', null, null, '1', '0', '2016-05-16 14:27:54');

-- ----------------------------
-- Table structure for user_exam
-- ----------------------------
DROP TABLE IF EXISTS `user_exam`;
CREATE TABLE `user_exam` (
  `exam_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `exam_state` int(11) DEFAULT NULL,
  `user_exam_createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`exam_id`,`user_id`),
  KEY `FK_user_exam2` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_exam
-- ----------------------------

-- ----------------------------
-- Table structure for user_session
-- ----------------------------
DROP TABLE IF EXISTS `user_session`;
CREATE TABLE `user_session` (
  `session_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `session_state` int(11) DEFAULT NULL,
  `user_session_createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`session_id`,`user_id`),
  KEY `FK_user_session2` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_session
-- ----------------------------
