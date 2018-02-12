/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : xhupubmed

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-21 07:42:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `CHAT_CUID` varchar(100) NOT NULL COMMENT '聊天记录表CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `CHAT_LEFT_CUID` varchar(100) NOT NULL COMMENT '聊天记录表LEFTCUID',
  `CHAT_LEFT_NAME` varchar(50) NOT NULL COMMENT '聊天记录表LEFT名称',
  `CHAT_RIGHT_CUID` varchar(100) NOT NULL COMMENT '聊天记录表RIGHTCUID',
  `CHAT_RIGHT_NAME` varchar(50) NOT NULL COMMENT '聊天记录表RIGHT名称',
  `CHAT_CONTENT` varchar(255) DEFAULT NULL COMMENT '聊天记录表文字内容',
  `CHAT_PHOTO_URL` varchar(100) DEFAULT NULL COMMENT '聊天记录表图片URL',
  `CHAT_STATE` int(11) NOT NULL COMMENT '聊天记录表状态',
  `CHAT_CREATE_TIME` datetime NOT NULL COMMENT '聊天记录表创建时间',
  `CHAT_UPDATE_TIME` datetime DEFAULT NULL COMMENT '聊天记录表更新时间',
  PRIMARY KEY (`CHAT_CUID`),
  KEY `FK_Relationship_16` (`SYS_USER_CUID`),
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`SYS_USER_CUID`) REFERENCES `sys_user` (`SYS_USER_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='聊天记录';

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES ('CHAT2016031201', null, 'left001', '胡志辉', 'right001', '陈巧巧', null, null, '1', '2016-03-12 20:12:57', null);

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `CLASSROOM_CUID` varchar(100) NOT NULL COMMENT '教室CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `CLASSROOM_NAME` varchar(50) NOT NULL COMMENT '教室名称',
  `CLASSROOM_NUMBER` varchar(50) NOT NULL COMMENT '教学楼号数',
  `CLASSROOM_ROOM_NUMBER` varchar(50) NOT NULL COMMENT '教室编号',
  `CLASSROOM_INTRODUCTION` varchar(255) DEFAULT NULL COMMENT '教室简介',
  `CLASSROOM_QR_CODE` varchar(100) DEFAULT NULL COMMENT '教室二维码',
  `CLASSROOM_STUDENT_NUMBER` int(11) NOT NULL COMMENT '约定人总数',
  `CLASSROOM_STATE` int(11) NOT NULL COMMENT '教室状态',
  `CLASSROOM_CREATE_TIME` datetime NOT NULL COMMENT '教室创建时间',
  `CLASSROOM_UPDATE_TIME` datetime DEFAULT NULL COMMENT '教室更新时间',
  PRIMARY KEY (`CLASSROOM_CUID`),
  KEY `FK_Relationship_12` (`SYS_USER_CUID`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`SYS_USER_CUID`) REFERENCES `sys_user` (`SYS_USER_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教室';

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES ('CLASSROOM201604200141', 'SYSUSER2016031305', '冲刺学习', '6教', '6A414', '今天晚上就一起学习吧,快来参加吧,', null, '1', '1', '2016-05-20 21:40:00', '2016-04-20 21:40:52');
INSERT INTO `classroom` VALUES ('CLASSROOM201604200142', 'SYSUSER2016031305', '今晚上冲刺学习,大家加油啊', '6教', '6A414', '今天晚上就一起学习吧,快来参加吧,', null, '1', '1', '2016-04-20 22:40:00', '2016-04-20 21:42:44');
INSERT INTO `classroom` VALUES ('CLASSROOM201604200143', 'SYSUSER2016031305', '教室一起来呀', '6教', '6A602', '好的好的黑道皇后好哒好哒好', null, '1', '1', '2016-04-20 23:23:00', '2016-04-20 22:23:18');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `COLLEGE_CUID` varchar(100) NOT NULL COMMENT '学院CUID',
  `COLLEGE_NAME` varchar(50) NOT NULL COMMENT '学院名称',
  `COLLEGE_CODE` varchar(10) DEFAULT NULL COMMENT '学院CODE',
  `COLLEGE_MAJOR_NUMBER` int(11) DEFAULT NULL COMMENT '学院专业数量',
  `COLLEGE_STATE` int(11) NOT NULL COMMENT '学院状态',
  `COLLEGE_CREATE_TIME` datetime NOT NULL COMMENT '学院创建时间',
  `COLLEGE_UPDATE_TIME` datetime DEFAULT NULL COMMENT '学院更新时间',
  PRIMARY KEY (`COLLEGE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学院';

-- ----------------------------
-- Records of college
-- ----------------------------

-- ----------------------------
-- Table structure for data_sharing
-- ----------------------------
DROP TABLE IF EXISTS `data_sharing`;
CREATE TABLE `data_sharing` (
  `DATA_SHARING_CUID` varchar(100) NOT NULL COMMENT '资料共享CUID',
  `DATA_SHARING_SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '资料共享人',
  `DATA_SHARING_TITLE` varchar(50) DEFAULT NULL COMMENT '资料共享标题',
  `DATA_SHARING_TYPE` int(11) DEFAULT NULL COMMENT '资料共享类型',
  `DATA_SHARING_TAG` varchar(50) DEFAULT NULL COMMENT '资料共享标签',
  `DATA_SHARING_STATE` int(11) DEFAULT NULL COMMENT '资料共享状态',
  `DATA_SHARING_SH_CREATE_TIME` datetime DEFAULT NULL COMMENT '资料共享发表时间',
  `DATA_SHARING_MAIN_CONTENT` varchar(20000) DEFAULT NULL COMMENT '资料共享主要内容',
  `DATA_SHARING_URL` varchar(100) DEFAULT NULL COMMENT '资料共享URL',
  `DATA_SHARING_FILE_URL1` varchar(100) DEFAULT NULL COMMENT '资料共享文件URL1',
  `DATA_SHARING_FILE_URL2` varchar(100) DEFAULT NULL COMMENT '资料共享文件URL2',
  `DATA_SHARING_FILE_URL3` varchar(100) DEFAULT NULL COMMENT '资料共享文件URL3',
  `DATA_SHARING_FILE_URL4` varchar(100) DEFAULT NULL COMMENT '资料共享文件URL4',
  `DATA_SHARING_CREATE_TIME` datetime NOT NULL COMMENT '资料共享创建时间',
  `DATA_SHARING_UPDATE_TIME` datetime DEFAULT NULL COMMENT '资料共享更新时间',
  PRIMARY KEY (`DATA_SHARING_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资料共享';

-- ----------------------------
-- Records of data_sharing
-- ----------------------------

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `FOLLOW_CUID` varchar(100) NOT NULL COMMENT '用户关注CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `FOLLOW_NAME` varchar(50) DEFAULT NULL COMMENT '用户关注名称',
  `FOLLOW_URL` varchar(100) DEFAULT NULL COMMENT '用户关注图标',
  `FOLLOW_POST_CUID` varchar(100) DEFAULT NULL COMMENT '用户关注帖子CUID',
  `FOLLOW_START_TIME` datetime NOT NULL COMMENT '用户关注开始时间',
  `FOLLOW_STATE` int(11) NOT NULL COMMENT '用户关注状态',
  `FOLLOW_CREATE_TIME` datetime NOT NULL COMMENT '用户关注创建时间',
  `FOLLOW_UPDATE_TIME` datetime DEFAULT NULL COMMENT '用户关注更新时间',
  PRIMARY KEY (`FOLLOW_CUID`),
  KEY `FK_Relationship_9` (`SYS_USER_CUID`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`SYS_USER_CUID`) REFERENCES `sys_user` (`SYS_USER_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关注';

-- ----------------------------
-- Records of follow
-- ----------------------------

-- ----------------------------
-- Table structure for follow_post
-- ----------------------------
DROP TABLE IF EXISTS `follow_post`;
CREATE TABLE `follow_post` (
  `POST_CUID` varchar(100) NOT NULL COMMENT '帖子CUID',
  `FOLLOW_CUID` varchar(100) NOT NULL COMMENT '用户关注CUID',
  `FOLLOW_POST_NUMBER` int(11) DEFAULT NULL COMMENT '用户关注总人数',
  PRIMARY KEY (`POST_CUID`,`FOLLOW_CUID`),
  KEY `FK_FOLLOW_POST2` (`FOLLOW_CUID`),
  CONSTRAINT `FK_FOLLOW_POST` FOREIGN KEY (`POST_CUID`) REFERENCES `post` (`POST_CUID`),
  CONSTRAINT `FK_FOLLOW_POST2` FOREIGN KEY (`FOLLOW_CUID`) REFERENCES `follow` (`FOLLOW_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='FOLLOW_POST';

-- ----------------------------
-- Records of follow_post
-- ----------------------------

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `FRIEND_CUID` varchar(100) NOT NULL COMMENT '用户好友表CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `FRIEND_REAL_CUID` varchar(100) DEFAULT NULL COMMENT '用户好友表用户CUID',
  `FRIEND_FRIEND_NAME` varchar(50) NOT NULL COMMENT '用户好友表好友昵称',
  `FRIEND_FRIEND_CUIDS` varchar(100) NOT NULL COMMENT '用户好友表好友CUID',
  `FRIEND_ADD_TIME` datetime NOT NULL COMMENT '用户好友表添加时间',
  `FRIEND_STATE` int(11) NOT NULL COMMENT '用户好友表状态',
  `FRIEND_CREATE_TIME` datetime NOT NULL COMMENT '用户好友表创建时间',
  `FRIEND_UPDATE_TIME` datetime DEFAULT NULL COMMENT '用户好友表更新时间',
  PRIMARY KEY (`FRIEND_CUID`),
  KEY `FK_Relationship_15` (`SYS_USER_CUID`),
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`SYS_USER_CUID`) REFERENCES `sys_user` (`SYS_USER_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户好友';

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('FRIEND20160414048', 'SYSUSER2016031305', 'SYSUSER2016031305', 'huzhihui', 'SYSUSER2016031305', '2016-04-14 20:35:07', '1', '2016-04-14 20:35:07', null);

-- ----------------------------
-- Table structure for global_table
-- ----------------------------
DROP TABLE IF EXISTS `global_table`;
CREATE TABLE `global_table` (
  `GLOBAL_TABLE_CUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '全局表CUID',
  `GLOBAL_TABLE_TABLE_NAME` varchar(100) NOT NULL COMMENT '全局表所创建ID表名称',
  `GLOBAL_TABLE_NOTES` varchar(100) DEFAULT NULL COMMENT '全局表提示',
  `GLOBAL_TABLE_CREATE_TIME` datetime NOT NULL COMMENT '全局表创建时间',
  PRIMARY KEY (`GLOBAL_TABLE_CUID`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8 COMMENT='系统全局CUID';

-- ----------------------------
-- Records of global_table
-- ----------------------------
INSERT INTO `global_table` VALUES ('1', 'CHAT', 'chat表开始插入', '2016-03-12 20:12:59');
INSERT INTO `global_table` VALUES ('2', 'SYS_USER', '系统用户表', '2016-03-12 21:11:52');
INSERT INTO `global_table` VALUES ('3', 'SYS_USER', '系统用户表', '2016-03-12 21:12:26');
INSERT INTO `global_table` VALUES ('4', 'SYS_USER', '系统用户表', '2016-03-13 18:53:32');
INSERT INTO `global_table` VALUES ('5', 'SYS_USER', '系统用户表', '2016-03-13 19:06:12');
INSERT INTO `global_table` VALUES ('6', 'SYS_USER', '系统用户表', '2016-03-13 19:08:19');
INSERT INTO `global_table` VALUES ('7', 'SYS_USER', '系统用户表', '2016-03-26 20:50:04');
INSERT INTO `global_table` VALUES ('8', 'POST', '帖子表插入', '2016-04-05 20:31:08');
INSERT INTO `global_table` VALUES ('9', 'POST', '帖子表插入', '2016-04-05 20:33:56');
INSERT INTO `global_table` VALUES ('10', 'POST', '帖子表插入', '2016-04-05 20:33:59');
INSERT INTO `global_table` VALUES ('11', 'POST', '帖子表插入', '2016-04-05 20:34:02');
INSERT INTO `global_table` VALUES ('12', 'POST', '帖子表插入', '2016-04-05 20:34:04');
INSERT INTO `global_table` VALUES ('13', 'POST', '帖子表插入', '2016-04-05 20:34:07');
INSERT INTO `global_table` VALUES ('14', 'POST', '帖子表插入', '2016-04-05 20:34:13');
INSERT INTO `global_table` VALUES ('15', 'POST', '帖子表插入', '2016-04-05 20:34:17');
INSERT INTO `global_table` VALUES ('16', 'POST', '帖子表插入', '2016-04-06 20:50:39');
INSERT INTO `global_table` VALUES ('17', 'REPLIES', '帖子回复表', '2016-04-06 21:42:20');
INSERT INTO `global_table` VALUES ('18', 'REPLIES', '帖子回复表', '2016-04-06 22:00:29');
INSERT INTO `global_table` VALUES ('19', 'REPLIES', '帖子回复表', '2016-04-06 22:00:58');
INSERT INTO `global_table` VALUES ('20', 'REPLIES', '帖子回复表', '2016-04-06 22:05:08');
INSERT INTO `global_table` VALUES ('21', 'POST', '帖子表插入', '2016-04-06 22:06:06');
INSERT INTO `global_table` VALUES ('22', 'REPLIES', '帖子回复表', '2016-04-07 20:39:43');
INSERT INTO `global_table` VALUES ('23', 'REPLIES', '帖子回复表', '2016-04-07 20:43:27');
INSERT INTO `global_table` VALUES ('24', 'POST', '帖子表插入', '2016-04-07 20:49:09');
INSERT INTO `global_table` VALUES ('25', 'REPLIES', '帖子回复表', '2016-04-07 21:11:06');
INSERT INTO `global_table` VALUES ('26', 'REPLIES', '帖子回复表', '2016-04-07 21:42:10');
INSERT INTO `global_table` VALUES ('27', 'POST', '帖子表插入', '2016-04-08 21:52:19');
INSERT INTO `global_table` VALUES ('28', 'REPLIES', '帖子回复表', '2016-04-08 21:53:48');
INSERT INTO `global_table` VALUES ('29', 'POST', '帖子表插入', '2016-04-10 17:00:58');
INSERT INTO `global_table` VALUES ('30', 'LEARN_PLAN', '学习计划表插入', '2016-04-12 20:59:53');
INSERT INTO `global_table` VALUES ('31', 'LEARN_PLAN', '学习计划表插入', '2016-04-12 21:00:23');
INSERT INTO `global_table` VALUES ('32', 'LEARN_PLAN', '学习计划表插入', '2016-04-12 21:48:18');
INSERT INTO `global_table` VALUES ('33', 'LEARN_PLAN', '学习计划表插入', '2016-04-12 21:48:21');
INSERT INTO `global_table` VALUES ('34', 'LEARN_PLAN', '学习计划表插入', '2016-04-12 21:48:24');
INSERT INTO `global_table` VALUES ('35', 'LEARN_PLAN', '学习计划表插入', '2016-04-12 21:48:27');
INSERT INTO `global_table` VALUES ('36', 'LEARN_PLAN', '学习计划表插入', '2016-04-12 21:56:17');
INSERT INTO `global_table` VALUES ('37', 'LEARN_PLAN', '学习计划表插入', '2016-04-13 20:02:48');
INSERT INTO `global_table` VALUES ('38', 'LEARN_PLAN', '学习计划表插入', '2016-04-13 20:38:31');
INSERT INTO `global_table` VALUES ('39', 'LEARN_PLAN', '学习计划表插入', '2016-04-13 20:38:35');
INSERT INTO `global_table` VALUES ('40', 'REPLIES', '帖子回复表', '2016-04-13 20:39:18');
INSERT INTO `global_table` VALUES ('43', 'FRIEND', '好友表插入数据', '2016-04-13 22:12:29');
INSERT INTO `global_table` VALUES ('44', 'FRIEND', '好友表插入数据', '2016-04-13 22:12:31');
INSERT INTO `global_table` VALUES ('45', 'POST', '帖子表插入', '2016-04-13 22:26:15');
INSERT INTO `global_table` VALUES ('46', 'FRIEND', '好友表插入数据', '2016-04-14 20:30:49');
INSERT INTO `global_table` VALUES ('47', 'FRIEND', '好友表插入数据', '2016-04-14 20:34:58');
INSERT INTO `global_table` VALUES ('48', 'FRIEND', '好友表插入数据', '2016-04-14 20:35:07');
INSERT INTO `global_table` VALUES ('59', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:15:54');
INSERT INTO `global_table` VALUES ('60', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:15:56');
INSERT INTO `global_table` VALUES ('61', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:22:51');
INSERT INTO `global_table` VALUES ('62', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:22:51');
INSERT INTO `global_table` VALUES ('63', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:23:33');
INSERT INTO `global_table` VALUES ('64', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:23:33');
INSERT INTO `global_table` VALUES ('65', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:28:55');
INSERT INTO `global_table` VALUES ('66', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:28:55');
INSERT INTO `global_table` VALUES ('67', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:29:32');
INSERT INTO `global_table` VALUES ('68', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:29:33');
INSERT INTO `global_table` VALUES ('69', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:56:02');
INSERT INTO `global_table` VALUES ('70', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 21:56:04');
INSERT INTO `global_table` VALUES ('73', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:00:04');
INSERT INTO `global_table` VALUES ('74', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:00:05');
INSERT INTO `global_table` VALUES ('75', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:02:21');
INSERT INTO `global_table` VALUES ('76', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:02:23');
INSERT INTO `global_table` VALUES ('77', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:06:35');
INSERT INTO `global_table` VALUES ('78', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:06:35');
INSERT INTO `global_table` VALUES ('79', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:06:50');
INSERT INTO `global_table` VALUES ('80', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:06:50');
INSERT INTO `global_table` VALUES ('81', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:21');
INSERT INTO `global_table` VALUES ('82', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:22');
INSERT INTO `global_table` VALUES ('83', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:33');
INSERT INTO `global_table` VALUES ('84', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:34');
INSERT INTO `global_table` VALUES ('85', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:43');
INSERT INTO `global_table` VALUES ('86', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:43');
INSERT INTO `global_table` VALUES ('87', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:51');
INSERT INTO `global_table` VALUES ('88', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:51');
INSERT INTO `global_table` VALUES ('89', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:57');
INSERT INTO `global_table` VALUES ('90', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:16:58');
INSERT INTO `global_table` VALUES ('91', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:29:00');
INSERT INTO `global_table` VALUES ('92', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:29:00');
INSERT INTO `global_table` VALUES ('93', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:29:24');
INSERT INTO `global_table` VALUES ('94', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:29:24');
INSERT INTO `global_table` VALUES ('95', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:29:38');
INSERT INTO `global_table` VALUES ('96', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:29:39');
INSERT INTO `global_table` VALUES ('97', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:33:00');
INSERT INTO `global_table` VALUES ('98', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-14 22:33:00');
INSERT INTO `global_table` VALUES ('99', 'LEARN_PLAN', '学习计划表插入', '2016-04-14 22:33:57');
INSERT INTO `global_table` VALUES ('100', 'REPLIES', '帖子回复表', '2016-04-14 22:34:33');
INSERT INTO `global_table` VALUES ('101', 'REPLIES', '帖子回复表', '2016-04-14 22:35:08');
INSERT INTO `global_table` VALUES ('102', 'SYS_USER', '系统用户表', '2016-04-15 22:22:55');
INSERT INTO `global_table` VALUES ('103', 'POST', '帖子表插入', '2016-04-15 22:23:48');
INSERT INTO `global_table` VALUES ('104', 'REPLIES', '帖子回复表', '2016-04-15 22:24:05');
INSERT INTO `global_table` VALUES ('105', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:24:53');
INSERT INTO `global_table` VALUES ('106', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:24:57');
INSERT INTO `global_table` VALUES ('107', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:25:01');
INSERT INTO `global_table` VALUES ('108', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:25:05');
INSERT INTO `global_table` VALUES ('109', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:25:08');
INSERT INTO `global_table` VALUES ('110', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:25:37');
INSERT INTO `global_table` VALUES ('111', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:25:43');
INSERT INTO `global_table` VALUES ('112', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:25:52');
INSERT INTO `global_table` VALUES ('113', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:26:20');
INSERT INTO `global_table` VALUES ('114', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:29:16');
INSERT INTO `global_table` VALUES ('115', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:31:20');
INSERT INTO `global_table` VALUES ('116', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-15 22:34:36');
INSERT INTO `global_table` VALUES ('117', 'SYS_USER', '系统用户表', '2016-04-16 09:57:47');
INSERT INTO `global_table` VALUES ('118', 'LEARN_PLAN', '学习计划表插入', '2016-04-16 10:01:07');
INSERT INTO `global_table` VALUES ('119', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-16 10:02:20');
INSERT INTO `global_table` VALUES ('120', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-16 10:02:21');
INSERT INTO `global_table` VALUES ('121', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-16 10:02:52');
INSERT INTO `global_table` VALUES ('122', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-16 10:02:53');
INSERT INTO `global_table` VALUES ('123', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-16 10:03:08');
INSERT INTO `global_table` VALUES ('124', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-16 10:03:09');
INSERT INTO `global_table` VALUES ('125', 'REPLIES', '帖子回复表', '2016-04-16 10:07:08');
INSERT INTO `global_table` VALUES ('126', 'POST', '帖子表插入', '2016-04-16 10:07:33');
INSERT INTO `global_table` VALUES ('127', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-04-17 18:31:15');
INSERT INTO `global_table` VALUES ('128', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-04-17 18:31:30');
INSERT INTO `global_table` VALUES ('129', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-04-17 18:33:04');
INSERT INTO `global_table` VALUES ('130', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-19 22:16:11');
INSERT INTO `global_table` VALUES ('131', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-19 22:16:12');
INSERT INTO `global_table` VALUES ('132', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-19 22:16:21');
INSERT INTO `global_table` VALUES ('133', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-19 22:16:21');
INSERT INTO `global_table` VALUES ('134', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-19 22:16:33');
INSERT INTO `global_table` VALUES ('135', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-19 22:16:33');
INSERT INTO `global_table` VALUES ('137', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-04-20 20:45:47');
INSERT INTO `global_table` VALUES ('138', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-04-20 20:51:16');
INSERT INTO `global_table` VALUES ('139', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-04-20 20:51:37');
INSERT INTO `global_table` VALUES ('140', 'LEARN_PLAN', '学习计划表插入', '2016-04-20 20:57:28');
INSERT INTO `global_table` VALUES ('141', 'CLASSROOM', '教室表插入！', '2016-04-20 21:40:53');
INSERT INTO `global_table` VALUES ('142', 'CLASSROOM', '教室表插入！', '2016-04-20 21:42:45');
INSERT INTO `global_table` VALUES ('143', 'CLASSROOM', '教室表插入！', '2016-04-20 22:23:18');

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `IMAGES_CUID` varchar(100) NOT NULL COMMENT '图片集CUID',
  `REPLIES_CUID` varchar(100) DEFAULT NULL COMMENT '回帖CUID',
  `IMAGES_NAME` varchar(50) DEFAULT NULL COMMENT '图片集名称',
  `IMAGES_URL` varchar(100) NOT NULL COMMENT '图片集URL',
  `IMAGES_THUMB_URL` varchar(150) DEFAULT NULL COMMENT '图片集缩略图',
  `IMAGES_EXPLIAN` varchar(255) DEFAULT NULL COMMENT '图片集后续说明',
  `IMAGES_STATE` int(11) NOT NULL COMMENT '图片集状态',
  `IMAGES_CREATE_TIME` datetime NOT NULL COMMENT '图片集创建时间',
  `IMAGES_UPDATE_TIME` datetime DEFAULT NULL COMMENT '图片集更新时间',
  PRIMARY KEY (`IMAGES_CUID`),
  KEY `FK_Relationship_6` (`REPLIES_CUID`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`REPLIES_CUID`) REFERENCES `replies` (`REPLIES_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片集';

-- ----------------------------
-- Records of images
-- ----------------------------

-- ----------------------------
-- Table structure for information_push
-- ----------------------------
DROP TABLE IF EXISTS `information_push`;
CREATE TABLE `information_push` (
  `INFORMATION_PUSH_CUID` varchar(100) NOT NULL COMMENT '信息推送CUID',
  `INFORMATION_PUSH_TITLE` varchar(50) NOT NULL COMMENT '信息推送标题',
  `INFORMATION_PUSH_CONTENT` mediumtext NOT NULL COMMENT '信息推送内容',
  `INFORMATION_PUSH_PEOPLE` varchar(50) DEFAULT NULL COMMENT '信息推送创建人',
  `INFORMATION_PUSH_URL` varchar(100) DEFAULT NULL COMMENT '信息推送URL',
  `INFORMATION_PUSH_STATE` int(11) NOT NULL COMMENT '信息推送状态',
  `INFORMATION_PUSH_CREATE_TIME` datetime NOT NULL COMMENT '信息推送创建时间',
  `INFORMATION_PUSH_UPDATE_TIME` datetime DEFAULT NULL COMMENT '信息推送更新时间',
  PRIMARY KEY (`INFORMATION_PUSH_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息推送';

-- ----------------------------
-- Records of information_push
-- ----------------------------
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604170127', '', '', 'Admin', '', '1', '2016-04-17 18:31:14', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604170128', '陈巧巧', '231231231', 'Admin', '1231231', '1', '2016-04-17 18:31:30', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604170129', '继续测试', 'fdfasdfk ajdkf asdf jldakj adsf<img style=\"width:100px;height:100px;\"></img> das fasf asdf asd fasd ad fasd fsad fasf sad fads fads fda ', 'Admin', 'www.baidu.com', '2', '2016-04-17 18:33:04', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604200137', '考研心态调整', '1.保持一种积极乐观的心态\n　　一个好的投手在接受记者采访时说，我每次投球的时候不关心球进不进，而是欣赏球离开手抛向篮板的优美弧线。关注过程而非结果，这可能是他百投百中的一大诀窍。考研过程也是非常锻炼人的一个过程，不管结果怎样，过程本身就非常有价值，瓜熟蒂落、水到渠成是大家都知道的道理，只要付出努力，总是会有所收获，对结果的担忧不仅没用也非常没有必要，所以保持一种乐观的心态，把关注的焦点回归到复习的技巧和效率上来，才是明智之举。\n　　2.利用语言暗示的作用\n　　当你被不良情结所压抑的时候，可以通过言语暗示来调整和放松心理上的紧张，使不良情绪得到缓解。语言是一个人情绪体验强有力的表现工具。通过语言可以引起或抑制情绪反应，即使不出声的内心语言，也能起到调节作用。在你发怒时，可以暗示自己“不要发怒”，“发怒会把事情办坏的”;陷入忧愁时，提醒自己“忧愁没有用，于事无益，还是面对现实，想想办法吧”，等等。在松弛平静、排除杂念、专心致志的情况下，进行这种自我暗示，对情绪的好转大有益处。\n　　3.了解生物节律，尊重情绪规律\n　　人是有生物钟和生物节律的，比如有的人是早起型，有人是晚睡型，有人早晨效率高，有人下午头脑好，其实情绪也一样有它的节律。\n　　美国加州大学心理学教授罗伯特•塞伊曾经做过一个实验，在一段时间里对125名实验者的情绪和体温变化进行了观察。他发现，当人们的体温在正常范围内处于上升期时，他们的心情要更愉快些，而此时他们的精力也最充沛。根据塞伊教授的结论，人的情绪变化是有周期的。塞伊本人就严格遵循着这一“生物节奏”的规律，他往往很早就开始写作，“我写作的最佳时间是早上”，而在下午，他一般都用来会客和处理杂事，“因为那时我的精力往往不够集中，更适合与人交谈”。\n　　所以我们要熟悉自己的生物节律和情绪周期，合理安排考研事件，这样便能得到更有效率的成果，从而避免消极情绪的不良影响。\n　　4.保证充足的睡眠\n　　睡眠不足可能不是某几个考研人的问题，前天一位考研的学生告诉我，现在他们都四点半起床，都紧张得很!大家为了考研，都在拼命挤压本来就有限的睡眠时间，可是时间与成绩是成正比的吗?付出时间越多效率就越高吗?恐怕不尽然。匹兹堡大学医学中心的罗拉德•达尔教授的一项研究发现，睡眠不足对我们的情绪影响极大，他说：“对睡眠不足者而言，那些令人烦心的事更能左右他们的情绪”。\n　　当你每天睡眠不足，强打精神把自己控制在书桌前，烦躁、抑郁、焦虑、担忧等不良情绪也会轻易找上你，不仅使你复习效率全无，而且还有影响考研的自信心。其实对于准备时间晚的同学，只要合理安排时间，有效完成计划，成果总是会有的。当然，多少睡眠量能满足自己的需求因人而宜，但最起码要保证充足的高质量的睡眠，这也是保持良好情绪，取得好成绩的重要保证。\n　　5.养成良好的运动习惯\n　　运动是一个极有效的驱除不良心情的自助手段。研究人员发现，健身运动能使你的身体产生一系列的生理变化，其功效与那些能提神醒脑的药物类似。但比药物更胜一筹的是，健身运动对你是有百利而无一害。不过，要做到效果明显，你最好是从事有氧运动——跑步、体操、骑车、游泳和其他有一定强度的运动，运动之后再洗个热水澡则效果更佳。如果在紧张的复习中这些活动很难进行，哪怕你只是散步十分钟，或围着操场跑两圈，对克服坏心情都能收到立竿见影之效。\n　　6.保证合理饮食\n　　你是否为了多挤出时间复习，吃饭总是凑合凑合，匆匆了事?其实这样不仅难以提高效率，反而会给我们带来坏心情。大脑活动的所有能量都能来自于我们所吃的食物，因此情绪波动也常常与我们吃的东西有关。《食物与情绪》一书的作者索姆认为，对于那些每天早晨只喝一杯咖啡的人来说，心情不佳是一点也不足为怪的。索姆建议，要确保你心情愉快，你应养成一些好的饮食习惯：定时就餐(早餐尤其不能省)，限制咖啡和糖的摄入(它们都可能使你过于激动)，每天至少喝六至八杯水(脱水易使人疲劳)。\n　　营养是保持充沛精力、贮藏能量的重要手段，也是预防紧张的主要措施。所以考研人更要注意营养的均衡，养成良好的饮食习惯，这对于抵抗紧张情绪反应和提高智力水平都是非常必要的。\n　　聪明的人能够做到劳逸结合，提高效率;了解自己的生物节律和情绪周期，能把自己的潜能充分发挥出来;保证充足的睡眠和合理的饮食，为考研成功做好充分的准备。学会合理调控情绪，成为情绪的主人，这不仅仅是对考研，同时对以后的人生路也是大有裨益的。', 'Admin', 'www.baidu.com', '1', '2016-04-20 20:45:47', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604200138', '考研一般要准备多长时间', '一般是那一年的2-3份开始正式准了，有些人想考好一点的，还有名校的好专业，专业科上压力要大一些，专业科要早点准备，可以比一般可以早上4-5个月，英语与政治不要过早准备了，要考数一与数二的话，可能数学要占多一点时间，所以时间又可以拖长一点了。\n但考研切记，不要以为准备的时间越长越好，太长，心会疲，考研不是英语四六级，不是机械的练习就可以，有很多方法与技巧。', 'Admin', 'www.baidu.com', '2', '2016-04-20 20:51:16', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604200139', '考研准备过程', '您好，这要看个人情况和要报考的学校了基础差或者报考学校比较知名，准备时间就要长一些.按照下面的时间安排再根据自己的跟人情况稍作修改。一般是20111月 搜集考研信息，听免费讲座。2月-3月 确定考研目标，听考研形势的讲座。考研应如何选择专业，全面了解所报专业的信息。准备复习。4月-5月 第一轮复习，可以报一个基础班，特别是数学班和英语班。不要急于做模拟试题，着重于基础的复习。6月 全面关注考研公共课的考试大纲，购买最新的辅导用书，准备暑期复习。7月-8月 制定一个全面复习计划，开始第二轮复习。可以参加一个有权威性的辅导班，有选择地做一些必要的题目。9月 关注各招生单位的招生简章和专业计划，购买专业课辅导用书，联系导师，获取专业课考试信息。10月 确定十一黄金周复习计划，对前两个阶段的复习进行总结。同时，开始专业课的复习，可报一个长期班系统复习。11月10-14日 研究生考试报名工作开始，报名、填报专愿。11月中下旬 第三轮复习阶段开始，政治、英语、数学、专业课的冲刺复习，购买辅导冲刺的内部资料。冲刺班报名。12-1月 进行模拟实训，报一个冲刺班，做考前整理。第二年1月中下旬 调整心态、准备考试。熟悉考试环境。2月 放松心情，查询初试成绩。3月 关注复试复试分数线。4月 准备复试，联系招生单位。5月 关注复试成绩。6月 关注录取通知书。9月 到。!。。。欢迎向158教育在线知道提问', 'Admin', 'www.baidu.com', '2', '2016-04-20 20:51:37', null);

-- ----------------------------
-- Table structure for intelligent_message
-- ----------------------------
DROP TABLE IF EXISTS `intelligent_message`;
CREATE TABLE `intelligent_message` (
  `INTELLIGENT_MESSAGE_CUID` varchar(100) NOT NULL COMMENT '智能消息CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `INTELLIGENT_MESSAGE_NAME` varchar(50) DEFAULT NULL COMMENT '智能消息名称',
  `INTELLIGENT_MESSAGE_TITLE` varchar(50) DEFAULT NULL COMMENT '智能消息标题',
  `INTELLIGENT_MESSAGE_CONTENT` varchar(3000) NOT NULL COMMENT '智能消息内容',
  `INTELLIGENT_MESSAGE_DIRECTION` int(11) NOT NULL COMMENT '智能消息方向',
  `INTELLIGENT_MESSAGE_STATE` int(11) NOT NULL DEFAULT '1' COMMENT '智能消息状态',
  `INTELLIGENT_MESSAGE_CREATE_TIME` datetime NOT NULL COMMENT '智能消息创建时间',
  `INTELLIGENT_MESSAGE_UPDATE_TIME` datetime DEFAULT NULL COMMENT '智能消息更新时间',
  PRIMARY KEY (`INTELLIGENT_MESSAGE_CUID`),
  KEY `FK_Relationship_8` (`SYS_USER_CUID`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`SYS_USER_CUID`) REFERENCES `sys_user` (`SYS_USER_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='智能消息';

-- ----------------------------
-- Records of intelligent_message
-- ----------------------------
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414059', 'SYSUSER2016031305', null, null, '你是谁呢', '1', '4', '2016-04-14 21:15:53', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414060', 'SYSUSER2016031305', null, '图灵机器人', '咱能有点创意么？换个问题吧', '2', '4', '2016-04-14 21:15:56', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414061', 'SYSUSER2016031305', null, null, '这么乱码了啊', '1', '4', '2016-04-14 21:22:51', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414062', 'SYSUSER2016031305', null, '图灵机器人', '太乱了', '2', '4', '2016-04-14 21:22:51', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414063', 'SYSUSER2016031305', null, null, '你一点都不聪明', '1', '4', '2016-04-14 21:23:33', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414064', 'SYSUSER2016031305', null, '图灵机器人', '简直不能再聪明', '2', '4', '2016-04-14 21:23:33', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414065', 'SYSUSER2016031305', null, null, '是不是要成功了啊', '1', '4', '2016-04-14 21:28:55', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414066', 'SYSUSER2016031305', null, '图灵机器人', '必须的', '2', '4', '2016-04-14 21:28:55', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414067', 'SYSUSER2016031305', null, null, '和笨蛋聊天不好玩', '1', '4', '2016-04-14 21:29:32', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414068', 'SYSUSER2016031305', null, '图灵机器人', '不要生气了，我错了', '2', '4', '2016-04-14 21:29:33', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414069', 'SYSUSER2016031305', null, null, '你就是小不点', '1', '4', '2016-04-14 21:56:02', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414070', 'SYSUSER2016031305', null, '图灵机器人', '我叫你小不点呀', '2', '4', '2016-04-14 21:56:04', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414073', 'SYSUSER2016031305', null, null, '鱼香肉丝怎么做', '1', '4', '2016-04-14 22:00:04', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414074', 'SYSUSER2016031305', null, '图灵机器人', '亲，已帮您找到菜谱信息菜名:鱼香肉丝<br>菜谱信息:猪腿肉、泡椒、胡萝卜、香醋(保宁醋/镇江香醋)、淀粉 | 姜、蒜、葱、水发木耳、白糖、老抽、生抽、盐、清汤<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/1010097/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:瘦肉、黑木耳、胡萝卜、靑椒、豆瓣酱，葱姜蒜、白糖，香醋，料酒、酱油，盐，、水淀粉，植物油<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100352761/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:里脊肉、青红辣椒、红萝卜、油、淀粉、清水 | 干木耳、郫县豆瓣酱、蒜瓣、姜蓉、泡椒、葱白、盐、糖、香醋、酱油、料酒<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/261379/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:猪里脊肉、绿尖椒、胡萝卜、冬笋、黑木耳、四川泡辣椒 | 生抽、料酒、水淀粉、醋、白糖、盐、色拉油、葱姜蒜<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/17762/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:猪瘦肉、莴笋丝、姜米、蒜米、泡红辣椒、水淀粉、水淀粉 | 水发木耳、葱花、#鱼香汁、酱油、醋、白糖、盐、肉汤、料酒、#、盐、料酒、混合油<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100218709/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:猪里脊肉、冬笋、黑木耳、蒜末、水 | 胡萝卜、葱末、姜末、剁椒、水淀粉（一汤匙干淀粉加3汤匙清水调匀）、料酒、醋、生抽、白糖、香麻油<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/263164/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:瘦猪肉、黑木耳、春笋、葱、蒜瓣、生粉 | 胡萝卜、姜、辣酱、生抽、老抽、醋、料酒、白糖、盐、香油、清水<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/1002652/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:猪里脊、水发玉兰片、泡红辣椒、湿淀粉 | 水发木耳、胡萝卜、葱、蒜、姜、盐、白糖、醋、酱油<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/1000066/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:猪肉、鱼香肉丝调料 | 香菇、木耳、红萝卜、黄酒、玉米淀粉、盐<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/264781/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:猪里脊、笋、彩椒、蒜、干辣椒、淀粉、鸡汤、虾油 | 水发木耳、水发香菇、葱、姜、糖、醋、老抽、生抽、盐、香油、料酒、芝麻<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/1044857/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:瘦肉、木耳、泡椒 | 水发笋、葱、姜、蒜、盐、白糖、醋、生抽、水淀粉<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/1007140/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:猪瘦肉、胡萝卜、青椒、木耳、湿淀粉、郫县红油豆瓣酱 | 花生油、盐、酱油、料酒、白糖、醋、葱、姜、蒜<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/140066/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:瘦肉、冬笋、木耳、豆瓣酱 | 泡红辣椒、葱、姜、蒜、淀粉、生抽、醋、白糖<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/240704/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:猪精肉、味好美鱼香肉丝调料 | 胡萝卜、木耳、油、淀粉、料酒<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100046438/\'>点击查看更多哦</a><br>菜名:鱼香肉丝<br>菜谱信息:猪瘦肉、木耳、青椒、淀粉 | 葱、姜、蒜、郫县红油豆瓣酱、白糖、醋、酱油、料酒、鸡精<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/84154/\'>点击查看更多哦</a><br>', '2', '4', '2016-04-14 22:00:05', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414075', 'SYSUSER2016031305', null, null, '木耳炒肉怎么做', '1', '4', '2016-04-14 22:02:21', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414076', 'SYSUSER2016031305', null, '图灵机器人', '亲，已帮您找到菜谱信息菜名:木耳炒肉<br>菜谱信息:猪里脊肉、木耳 | 葱、生抽、醋、水淀粉、料酒、盐、鸡精<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/17772/\'>点击查看更多哦</a><br>菜名:肉炒腐竹木耳<br>菜谱信息:腐竹、黑木耳、猪后肘肉 | 食用油、葱、生抽、老抽、盐、鸡精<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100023399/\'>点击查看更多哦</a><br>菜名:杏鲍菇木耳炒肉<br>菜谱信息:肉丝、杏鲍菇、木耳 | 青椒、辣椒、姜、蒜<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/1007208/\'>点击查看更多哦</a><br>菜名:胡萝卜木耳炒肉<br>菜谱信息:胡萝卜、木耳（泡发） | 肉丝、葱、姜、盐、生抽、生粉、耗油、青红椒（可要可不要）<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/1075282/\'>点击查看更多哦</a><br>菜名:茭白木耳炒肉<br>菜谱信息:茭白、油 | 猪肉、黑木耳、盐、料酒、生抽、鸡精、淀粉、葱花<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/35543/\'>点击查看更多哦</a><br>菜名:香菇木耳炒肉<br>菜谱信息:木耳、香菇 | 里脊肉、蒜、生抽、糖、盐、料酒、鸡精<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100390922/\'>点击查看更多哦</a><br>菜名:白菜木耳炒肉<br>菜谱信息:白菜、木耳 | 猪肉、葱、姜、盐、生抽、醋、糖、水淀粉<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/1023848/\'>点击查看更多哦</a><br>菜名:木耳炒肉<br>菜谱信息:大蒜、香葱、鲜肉、春耳、果椒、小众油、盐、鸡精、酱油等调味料<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100017412/\'>点击查看更多哦</a><br>菜名:洋葱木耳鸡蛋炒肉<br>菜谱信息:洋葱、鸡蛋 | 黑木耳、里脊肉<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100421509/\'>点击查看更多哦</a><br>菜名:竹木耳炒肉<br>菜谱信息:竹木耳（干货） | 猪瘦肉、红辣椒、调味食盐料酒等<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100473442/\'>点击查看更多哦</a><br>菜名:山药木耳炒肉<br>菜谱信息:山药、木耳、瘦肉 | 盐、糖、玉米油、盐、料酒、生抽、太白粉<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/106796/\'>点击查看更多哦</a><br>菜名:木耳笋片炒肉<br>菜谱信息:猪瘦肉、木耳 | 笋尖、红绿彩椒、料酒、盐、淀粉、蒜片、橄榄油、蚝油<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/77885/\'>点击查看更多哦</a><br>菜名:草菇木耳炒肉<br>菜谱信息:草菇、木耳、油 | 瘦肉、葱、蒜、蚝油、生抽、辣椒酱、生粉、清水、盐<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100020990/\'>点击查看更多哦</a><br>菜名:生菜木耳炒肉<br>菜谱信息:瘦肉、木耳、生菜 | 生抽、糖、盐、生姜、白葡萄酒<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/1066596/\'>点击查看更多哦</a><br>菜名:木耳鸡蛋炒肉<br>菜谱信息:黑木耳、鸡蛋 | 猪肉、生粉、生抽、盐<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100375555/\'>点击查看更多哦</a><br>', '2', '4', '2016-04-14 22:02:23', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414077', 'SYSUSER2016031305', null, null, '你是不是饿的慌啊', '1', '4', '2016-04-14 22:06:35', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414078', 'SYSUSER2016031305', null, '图灵机器人', '别委屈了肚子吃', '2', '4', '2016-04-14 22:06:35', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414079', 'SYSUSER2016031305', null, null, '好吧，我吃饭去了', '1', '4', '2016-04-14 22:06:50', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414080', 'SYSUSER2016031305', null, '图灵机器人', '你去睡觉', '2', '4', '2016-04-14 22:06:50', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414081', 'SYSUSER2016031305', null, null, '神经病', '1', '4', '2016-04-14 22:16:21', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414082', 'SYSUSER2016031305', null, '图灵机器人', '女神和女神经，只在一念之间', '2', '4', '2016-04-14 22:16:22', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414083', 'SYSUSER2016031305', null, null, '我是男的', '1', '4', '2016-04-14 22:16:33', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414084', 'SYSUSER2016031305', null, '图灵机器人', '你是男生的，我知道的哦', '2', '4', '2016-04-14 22:16:34', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414085', 'SYSUSER2016031305', null, null, '你傻', '1', '4', '2016-04-14 22:16:43', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414086', 'SYSUSER2016031305', null, '图灵机器人', '我只是聪明的不明显', '2', '4', '2016-04-14 22:16:43', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414087', 'SYSUSER2016031305', null, null, '你丑', '1', '4', '2016-04-14 22:16:51', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414088', 'SYSUSER2016031305', null, '图灵机器人', '群主最丑', '2', '4', '2016-04-14 22:16:51', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414089', 'SYSUSER2016031305', null, null, '你是谁', '1', '4', '2016-04-14 22:16:57', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414090', 'SYSUSER2016031305', null, '图灵机器人', '我是棒棒哒考研书童', '2', '4', '2016-04-14 22:16:58', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414091', 'SYSUSER2016031305', null, null, '饿', '1', '4', '2016-04-14 22:29:00', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414092', 'SYSUSER2016031305', null, '图灵机器人', '吗', '2', '4', '2016-04-14 22:29:00', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414093', 'SYSUSER2016031305', null, null, '你是谁啊', '1', '4', '2016-04-14 22:29:24', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414094', 'SYSUSER2016031305', null, '图灵机器人', '我可是人见人爱的考研书童呢，你竟然不认识我', '2', '4', '2016-04-14 22:29:24', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414095', 'SYSUSER2016031305', null, null, '大王', '1', '4', '2016-04-14 22:29:38', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414096', 'SYSUSER2016031305', null, '图灵机器人', '乖给你唐僧肉吃', '2', '4', '2016-04-14 22:29:39', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414097', 'SYSUSER2016031305', null, null, '', '1', '4', '2016-04-14 22:33:00', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE20160414098', 'SYSUSER2016031305', null, '图灵机器人', '我不知道怎么回复了', '2', '4', '2016-04-14 22:33:00', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150105', 'SYSUSER2016031305', null, null, '美女', '1', '4', '2016-04-15 22:24:53', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150106', 'SYSUSER2016031305', null, null, '美女', '1', '4', '2016-04-15 22:24:57', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150107', 'SYSUSER2016031305', null, null, '美女', '1', '4', '2016-04-15 22:25:01', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150108', 'SYSUSER2016031305', null, null, '美女', '1', '4', '2016-04-15 22:25:05', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150109', 'SYSUSER2016031305', null, null, '美女', '1', '4', '2016-04-15 22:25:08', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150110', 'SYSUSER2016031305', null, null, '美女', '1', '4', '2016-04-15 22:25:37', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150111', 'SYSUSER2016031305', null, null, '美女', '1', '4', '2016-04-15 22:25:43', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150112', 'SYSUSER2016031305', null, null, '美女', '1', '4', '2016-04-15 22:25:52', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150113', 'SYSUSER2016031305', null, null, '是不是', '1', '4', '2016-04-15 22:26:20', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150114', 'SYSUSER2016031305', null, null, '你是谁啊', '1', '4', '2016-04-15 22:29:16', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150115', 'SYSUSER2016031305', null, null, '你是谁', '1', '4', '2016-04-15 22:31:20', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604150116', 'SYSUSER2016031305', null, null, '谁啊', '1', '4', '2016-04-15 22:34:36', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604160119', 'SYSUSER2016031305', null, null, '你是谁', '1', '4', '2016-04-16 10:02:20', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604160120', 'SYSUSER2016031305', null, '图灵机器人', '我是棒棒哒考研书童', '2', '4', '2016-04-16 10:02:21', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604160121', 'SYSUSER2016031305', null, null, '最新考验新闻', '1', '4', '2016-04-16 10:02:52', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604160122', 'SYSUSER2016031305', null, '图灵机器人', '亲，已帮你找到新闻信息<a href=\'http://m.toutiao.com/search/?keyword=%E8%80%83%E9%AA%8C&from=search_page_input\'>点击连接查看更多哦!</a>', '2', '4', '2016-04-16 10:02:53', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604160123', 'SYSUSER2016031305', null, null, '1+1等于几', '1', '4', '2016-04-16 10:03:08', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604160124', 'SYSUSER2016031305', null, '图灵机器人', '1+1=2', '2', '4', '2016-04-16 10:03:09', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604190130', 'SYSUSER2016031305', null, null, '小度', '1', '4', '2016-04-19 22:16:11', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604190131', 'SYSUSER2016031305', null, '图灵机器人', '小度是谁', '2', '4', '2016-04-19 22:16:12', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604190132', 'SYSUSER2016031305', null, null, '是你的哥哥', '1', '4', '2016-04-19 22:16:21', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604190133', 'SYSUSER2016031305', null, '图灵机器人', '考研书童没有兄弟姐妹啦,但是有你陪就够啦!', '2', '4', '2016-04-19 22:16:21', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604190134', 'SYSUSER2016031305', null, null, '真的呀，你真好啊', '1', '4', '2016-04-19 22:16:33', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604190135', 'SYSUSER2016031305', null, '图灵机器人', '额谢谢夸奖哈哈', '2', '4', '2016-04-19 22:16:33', null);

-- ----------------------------
-- Table structure for key_log
-- ----------------------------
DROP TABLE IF EXISTS `key_log`;
CREATE TABLE `key_log` (
  `KEY_LOG_CUID` varchar(100) NOT NULL COMMENT '关键日志CUID',
  `KEY_LOG_NAME` varchar(50) DEFAULT NULL COMMENT '关键日志名称',
  `KEY_LOG_CONTENT` varchar(1000) DEFAULT NULL COMMENT '关键日志内容',
  `KEY_LOG_PEOPLE` varchar(50) DEFAULT NULL COMMENT '关键日志操作人',
  `KEY_LOG_STATE` int(11) DEFAULT NULL COMMENT '关键日志状态',
  `KEY_LOG_CREATE_TIME` datetime DEFAULT NULL COMMENT '关键日志创建时间',
  PRIMARY KEY (`KEY_LOG_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关键日志';

-- ----------------------------
-- Records of key_log
-- ----------------------------

-- ----------------------------
-- Table structure for learn_plan
-- ----------------------------
DROP TABLE IF EXISTS `learn_plan`;
CREATE TABLE `learn_plan` (
  `LEARN_PLAN_CUID` varchar(100) NOT NULL COMMENT '学习计划CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `LEARN_PLAN_NAME` varchar(50) NOT NULL COMMENT '学习计划名称',
  `LEARN_PLAN_URL` varchar(100) DEFAULT NULL COMMENT '学习计划图标',
  `LEARN_PLAN_CONTENT` varchar(255) DEFAULT NULL COMMENT '学习计划内容',
  `LEARN_PLAN_START_TIME` datetime NOT NULL COMMENT '学习计划开始时间',
  `LEARN_PLAN_END_TIME` datetime NOT NULL COMMENT '学习计划完成时间',
  `LEARN_PLAN_STATE` int(11) NOT NULL COMMENT '学习计划状态',
  `LEARN_PLAN_CREATE_TIME` datetime NOT NULL COMMENT '学习计划创建时间',
  `LEARN_PLAN_UPDATE_TIME` datetime DEFAULT NULL COMMENT '学习计划更新时间',
  PRIMARY KEY (`LEARN_PLAN_CUID`),
  KEY `FK_Relationship_3` (`SYS_USER_CUID`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`SYS_USER_CUID`) REFERENCES `sys_user` (`SYS_USER_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学习计划';

-- ----------------------------
-- Records of learn_plan
-- ----------------------------
INSERT INTO `learn_plan` VALUES ('LEARNPLAN20160412035', 'SYSUSER2016031305', '第6个', null, '312柔软沙发是昂发按时发放啊', '2016-04-12 21:48:00', '2016-04-12 22:48:00', '1', '2016-04-12 21:48:27', '2016-04-12 21:48:27');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN20160413037', 'SYSUSER2016031305', '4.13.新任务额', null, '还打电话黄飞鸿好的好的好发送是', '2016-04-13 21:02:00', '2016-04-14 21:02:00', '1', '2016-04-13 20:02:48', '2016-04-13 20:02:48');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN20160413038', 'SYSUSER2016031305', '测试任务添加', null, '好的好的好回电话很喜欢好的好的哈哈八点半下班好的八点半补习班电话', '2016-04-13 20:38:00', '2016-04-13 21:38:00', '1', '2016-04-13 20:38:31', '2016-04-13 20:38:31');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN20160413039', 'SYSUSER2016031305', '测试任务添加2', null, '好的好的好回电话很喜欢好的好的哈哈八点半下班好的八点半补习班电话', '2016-04-13 20:38:00', '2016-04-13 21:38:00', '1', '2016-04-13 20:38:35', '2016-04-13 20:38:35');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN20160414099', 'SYSUSER2016031305', '4.14rl任务哦', null, '挂电话风好大呵呵', '2016-04-14 22:33:00', '2016-04-14 23:33:00', '1', '2016-04-14 22:33:57', '2016-04-14 22:33:57');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN201604200140', 'SYSUSER2016031305', '4.20.新任务哦', null, '挂电话大喊大叫就当减肥回家就当减肥姐姐就当减肥急急急的就发竞技场姐姐将错就错姐姐', '2016-04-20 20:57:00', '2016-04-21 20:57:00', '1', '2016-04-20 20:57:28', '2016-04-20 20:57:28');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `MAJOR_CUID` varchar(100) NOT NULL COMMENT '专业CUID',
  `COLLEGE_CUID` varchar(100) DEFAULT NULL COMMENT '学院CUID',
  `MAJOR_NAME` varchar(50) NOT NULL COMMENT '专业名称',
  `MAJOR_CODE` varchar(10) DEFAULT NULL COMMENT '专业CODE',
  `MAJOR_STUDENT_NUMBER` int(11) DEFAULT NULL COMMENT '专业拥有学生总数',
  `MAJOR_STATE` int(11) NOT NULL COMMENT '专业状态',
  `MAJOR_CREATE_TIME` datetime NOT NULL COMMENT '专业创建时间',
  `MAJOR_UPDATE_TIME` datetime DEFAULT NULL COMMENT '专业更新时间',
  PRIMARY KEY (`MAJOR_CUID`),
  KEY `FK_Relationship_1` (`COLLEGE_CUID`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`COLLEGE_CUID`) REFERENCES `college` (`COLLEGE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业';

-- ----------------------------
-- Records of major
-- ----------------------------

-- ----------------------------
-- Table structure for oppointment
-- ----------------------------
DROP TABLE IF EXISTS `oppointment`;
CREATE TABLE `oppointment` (
  `OPPOINTMENT_CUID` varchar(100) NOT NULL COMMENT '约定表CUID',
  `CLASSROOM_CUID` varchar(100) DEFAULT NULL COMMENT '教室CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `OPPOINTMENT_NAME` varchar(50) DEFAULT NULL COMMENT '约定表名称',
  `OPPOINTMENT_USER_NAME` varchar(50) NOT NULL COMMENT '约定表用户登录名',
  `OPPOINTMENT_USER_URL` varchar(100) DEFAULT NULL COMMENT '约定用户头像',
  `OPPOINTMENT_STATE` int(11) NOT NULL COMMENT '约定表状态',
  `OPPOINTMENT_END_TIME` datetime NOT NULL COMMENT '约定表结束时间',
  `OPPOINTMENT_CREATE_TIME` datetime NOT NULL COMMENT '约定表创建时间',
  `OPPOINTMENT_UPDATE_TIME` datetime DEFAULT NULL COMMENT '约定表更新时间',
  PRIMARY KEY (`OPPOINTMENT_CUID`),
  KEY `FK_Relationship_13` (`SYS_USER_CUID`),
  KEY `FK_Relationship_7` (`CLASSROOM_CUID`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`SYS_USER_CUID`) REFERENCES `sys_user` (`SYS_USER_CUID`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`CLASSROOM_CUID`) REFERENCES `classroom` (`CLASSROOM_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教室约定表';

-- ----------------------------
-- Records of oppointment
-- ----------------------------

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `POST_CUID` varchar(100) NOT NULL COMMENT '帖子CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `POST_NAME` varchar(50) DEFAULT NULL COMMENT '帖子名称',
  `POST_URL` varchar(100) DEFAULT NULL COMMENT '帖子图片',
  `POST_TITLE` varchar(50) NOT NULL COMMENT '帖子标题',
  `POST_CONTENT` varchar(255) DEFAULT NULL COMMENT '帖子内容',
  `POST_TYPE` int(11) NOT NULL COMMENT '帖子所属类型(1:全部;2:各个专业)',
  `POST_REPLIES_NUMBER` int(11) NOT NULL COMMENT '帖子回帖总数',
  `POST_FOLLOW_PEOPLE_NUMBER` int(11) DEFAULT NULL COMMENT '帖子关注人总数',
  `POST_CREATE_ADDRESS` varchar(100) DEFAULT NULL COMMENT '帖子创建地点',
  `POST_STATE` int(11) NOT NULL COMMENT '帖子状态',
  `POST_CREATE_TIME` datetime NOT NULL COMMENT '帖子创建时间',
  `POST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '帖子更新时间',
  PRIMARY KEY (`POST_CUID`),
  KEY `FK_Relationship_10` (`SYS_USER_CUID`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`SYS_USER_CUID`) REFERENCES `sys_user` (`SYS_USER_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子';

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('POST20160405010', 'SYSUSER2016031305', '最大的', null, '陈巧巧专用贴2', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:33:59', '2016-04-05 20:33:59');
INSERT INTO `post` VALUES ('POST20160405011', 'SYSUSER2016031305', '最大的', null, '陈巧巧专用贴4', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:02', '2016-04-05 20:34:02');
INSERT INTO `post` VALUES ('POST20160405012', 'SYSUSER2016031305', '最大的2', null, '陈巧巧专用贴4', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:04', '2016-04-05 20:34:04');
INSERT INTO `post` VALUES ('POST20160405013', 'SYSUSER2016031305', '最大的2', null, '陈巧巧', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:07', '2016-04-05 20:34:07');
INSERT INTO `post` VALUES ('POST20160405014', 'SYSUSER2016031305', '最大的2', null, '就是发帖,怎么样', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:13', '2016-04-05 20:34:13');
INSERT INTO `post` VALUES ('POST20160405015', 'SYSUSER2016031305', '最大的2', null, '随便发', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:17', '2016-04-05 20:34:17');
INSERT INTO `post` VALUES ('POST2016040508', 'SYSUSER2016031305', '软件工程', null, '第一个帖子', '第一个测试', '2', '0', '0', null, '1', '2016-04-05 20:31:08', '2016-04-05 20:31:08');
INSERT INTO `post` VALUES ('POST2016040509', 'SYSUSER2016031305', '最大的', null, '陈巧巧专用贴', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:33:56', '2016-04-05 20:33:56');
INSERT INTO `post` VALUES ('POST20160406016', 'SYSUSER2016031305', '软件工程', null, '最新的帖子哦', '好的好的好黄河大街黄飞鸿很好的话好的不好的话好的吧并不是宝贝不懂好吧不喜欢才不会好的好的好不喜欢电话', '2', '0', '0', null, '1', '2016-04-06 20:50:39', null);
INSERT INTO `post` VALUES ('POST20160406021', 'SYSUSER2016031305', '软件工程', null, '4.6测试帖子', '我的测试今天接口', '2', '0', '0', null, '1', '2016-04-06 22:06:06', '2016-04-06 22:06:06');
INSERT INTO `post` VALUES ('POST20160407024', 'SYSUSER2016031305', '软件工程', null, '4.7帖子', '我的4.8', '2', '0', '0', null, '1', '2016-04-07 20:49:09', '2016-04-07 20:49:09');
INSERT INTO `post` VALUES ('POST20160408027', 'SYSUSER2016031305', '软件工程', null, '每日一贴4.8', '好的好的好的好的好C多喝点接电话X单反', '2', '0', '0', null, '1', '2016-04-08 21:52:19', '2016-04-08 21:52:19');
INSERT INTO `post` VALUES ('POST20160410029', 'SYSUSER2016031305', '软件工程', null, '4.10m每日一贴', '的好的好的回电话很喜欢的很方便好的好的不方便不对不对黄飞鸿好的好的好', '2', '0', '0', null, '1', '2016-04-10 17:00:58', '2016-04-10 17:00:58');
INSERT INTO `post` VALUES ('POST20160413045', 'SYSUSER2016031305', '软件工程', null, '4.14.一贴', '好的接电话好的好的好好的好的好', '2', '0', '0', null, '1', '2016-04-13 22:26:15', '2016-04-13 22:26:15');
INSERT INTO `post` VALUES ('POST201604150103', 'SYSUSER2016031305', 'hxhfh', null, 'kkk', 'bjnn', '2', '0', '0', null, '1', '2016-04-15 22:23:48', '2016-04-15 22:23:48');
INSERT INTO `post` VALUES ('POST201604160126', 'SYSUSER2016031305', '软件工程', null, '4.16.帖子', 'H就放假大家就放假大家', '2', '0', '0', null, '1', '2016-04-16 10:07:33', '2016-04-16 10:07:33');

-- ----------------------------
-- Table structure for replies
-- ----------------------------
DROP TABLE IF EXISTS `replies`;
CREATE TABLE `replies` (
  `REPLIES_CUID` varchar(100) NOT NULL COMMENT '回帖CUID',
  `POST_CUID` varchar(100) DEFAULT NULL COMMENT '帖子CUID',
  `CLASSROOM_CUID` varchar(100) DEFAULT NULL COMMENT '教室CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `REPLIES_TITLE` varchar(50) DEFAULT NULL COMMENT '回帖标题',
  `REPLIES_CONTENT` varchar(255) NOT NULL COMMENT '回帖内容',
  `REPLIES_STATE` int(11) NOT NULL COMMENT '回帖状态',
  `REPLIES_TIME` datetime NOT NULL COMMENT '回帖时间',
  `REPLIES_ADDRESS` varchar(100) DEFAULT NULL COMMENT '回帖地点',
  `REPLIES_CREATE_TIME` datetime NOT NULL COMMENT '回帖创建时间',
  `REPLIES_UPDATE_TIME` datetime DEFAULT NULL COMMENT '回帖更新时间',
  PRIMARY KEY (`REPLIES_CUID`),
  KEY `FK_Relationship_11` (`SYS_USER_CUID`),
  KEY `FK_Relationship_4` (`POST_CUID`),
  KEY `FK_Relationship_5` (`CLASSROOM_CUID`),
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`SYS_USER_CUID`) REFERENCES `sys_user` (`SYS_USER_CUID`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`POST_CUID`) REFERENCES `post` (`POST_CUID`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`CLASSROOM_CUID`) REFERENCES `classroom` (`CLASSROOM_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回帖';

-- ----------------------------
-- Records of replies
-- ----------------------------
INSERT INTO `replies` VALUES ('REPLIES20160406017', 'POST20160405015', null, 'SYSUSER2016031305', null, '难道我是一楼吗?', '1', '2016-04-06 21:42:20', '西华大学', '2016-04-06 21:42:20', '2016-04-06 21:42:20');
INSERT INTO `replies` VALUES ('REPLIES20160406018', 'POST20160405015', null, 'SYSUSER2016031305', null, '第二天的时候', '1', '2016-04-06 22:00:29', '西华大学', '2016-04-06 22:00:29', '2016-04-06 22:00:29');
INSERT INTO `replies` VALUES ('REPLIES20160406019', 'POST20160405014', null, 'SYSUSER2016031305', null, '就这个帖子哦，一定记得', '1', '2016-04-06 22:00:58', '西华大学', '2016-04-06 22:00:58', '2016-04-06 22:00:58');
INSERT INTO `replies` VALUES ('REPLIES20160406020', 'POST20160405015', null, 'SYSUSER2016031305', null, '是这个帖子很牛的', '1', '2016-04-06 22:05:08', '西华大学', '2016-04-06 22:05:08', '2016-04-06 22:05:08');
INSERT INTO `replies` VALUES ('REPLIES20160407022', 'POST20160406021', null, 'SYSUSER2016031305', null, '新的帖子，测试北龙', '1', '2016-04-07 20:39:43', '西华大学', '2016-04-07 20:39:43', '2016-04-07 20:39:43');
INSERT INTO `replies` VALUES ('REPLIES20160407023', 'POST20160406016', null, 'SYSUSER2016031305', null, '黄飞鸿很好的话', '1', '2016-04-07 20:43:27', '西华大学', '2016-04-07 20:43:27', '2016-04-07 20:43:27');
INSERT INTO `replies` VALUES ('REPLIES20160407025', 'POST20160406021', null, 'SYSUSER2016031305', null, '随便哈哈', '1', '2016-04-07 21:11:06', '西华大学', '2016-04-07 21:11:06', '2016-04-07 21:11:06');
INSERT INTO `replies` VALUES ('REPLIES20160407026', 'POST20160405013', null, 'SYSUSER2016031305', null, '哈哈哈哈', '1', '2016-04-07 21:42:10', '西华大学', '2016-04-07 21:42:10', '2016-04-07 21:42:10');
INSERT INTO `replies` VALUES ('REPLIES20160408028', 'POST20160408027', null, 'SYSUSER2016031305', null, '回复一个哦', '1', '2016-04-08 21:53:48', '西华大学', '2016-04-08 21:53:48', '2016-04-08 21:53:48');
INSERT INTO `replies` VALUES ('REPLIES20160413040', 'POST20160410029', null, 'SYSUSER2016031305', null, 'u度电话', '1', '2016-04-13 20:39:18', '西华大学', '2016-04-13 20:39:18', '2016-04-13 20:39:18');
INSERT INTO `replies` VALUES ('REPLIES201604140100', 'POST20160413045', null, 'SYSUSER2016031305', null, '第一个回帖好了', '1', '2016-04-14 22:34:33', '西华大学', '2016-04-14 22:34:33', '2016-04-14 22:34:33');
INSERT INTO `replies` VALUES ('REPLIES201604140101', 'POST20160405013', null, 'SYSUSER2016031305', null, '很久以前的了', '1', '2016-04-14 22:35:08', '西华大学', '2016-04-14 22:35:08', '2016-04-14 22:35:08');
INSERT INTO `replies` VALUES ('REPLIES201604150104', 'POST201604150103', null, 'SYSUSER2016031305', null, 'nfnfn', '1', '2016-04-15 22:24:05', '西华大学', '2016-04-15 22:24:05', '2016-04-15 22:24:05');
INSERT INTO `replies` VALUES ('REPLIES201604160125', 'POST201604150103', null, 'SYSUSER2016031305', null, '很喜欢的回电话', '1', '2016-04-16 10:07:08', '西华大学', '2016-04-16 10:07:08', '2016-04-16 10:07:08');

-- ----------------------------
-- Table structure for school_information
-- ----------------------------
DROP TABLE IF EXISTS `school_information`;
CREATE TABLE `school_information` (
  `SCHOOL_INFORMATION_CUID` varchar(100) NOT NULL COMMENT '学校最新资料CUID',
  `SCHOOL_PROFILE_CUID` varchar(100) DEFAULT NULL COMMENT '考研学校CUID',
  `SCHOOL_INFORMATION_TITLE` varchar(100) DEFAULT NULL COMMENT '学校最新资料标题',
  `SCHOOL_INFORMATION_TAG` varchar(100) DEFAULT NULL COMMENT '学校最新资料标签',
  `SCHOOL_INFORMATION_TYPE` int(11) NOT NULL COMMENT '学校最新资料类型',
  `SCHOOL_INFORMATION_MAIN_CONTENT` varchar(1000) DEFAULT NULL COMMENT '学校最新资料主要内容',
  `SCHOOL_INFORMATION_NOTES` varchar(1000) DEFAULT NULL COMMENT '学校最新资料提示',
  `SCHOOL_INFORMATION_IS_TOP` int(11) NOT NULL COMMENT '学校最新资料IS_TOP',
  `SCHOOL_INFORMATION_STATE` int(11) NOT NULL COMMENT '学校最新资料状态',
  `SCHOOL_INFORMATION_CREATE_TIME` datetime NOT NULL COMMENT '学校最新资料创建时间',
  `SCHOOL_INFORMATION_UPDATE_TIME` datetime DEFAULT NULL COMMENT '学校最新资料更新时间',
  PRIMARY KEY (`SCHOOL_INFORMATION_CUID`),
  KEY `FK_Relationship_17` (`SCHOOL_PROFILE_CUID`),
  CONSTRAINT `FK_Relationship_17` FOREIGN KEY (`SCHOOL_PROFILE_CUID`) REFERENCES `school_profile` (`SCHOOL_PROFILE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校最新资料';

-- ----------------------------
-- Records of school_information
-- ----------------------------

-- ----------------------------
-- Table structure for school_profile
-- ----------------------------
DROP TABLE IF EXISTS `school_profile`;
CREATE TABLE `school_profile` (
  `SCHOOL_PROFILE_CUID` varchar(100) NOT NULL COMMENT '考研学校CUID',
  `SCHOOL_PROFILE_NAME` varchar(50) DEFAULT NULL COMMENT '考研学校名称',
  `SCHOOL_PROFILE_IS_TOP` int(11) NOT NULL COMMENT '考研学校IS_TOP',
  `SCHOOL_PROFILE_TAG` varchar(100) DEFAULT NULL COMMENT '考研学校标签',
  `SCHOOL_PROFILE_CODE` varchar(50) DEFAULT NULL COMMENT '考研学校代码',
  `SCHOOL_PROFILE_SC_CREATE_TIME` datetime DEFAULT NULL COMMENT '考研学校创建时间',
  `SCHOOL_PROFILE_BASE_PROFILE` varchar(1000) DEFAULT NULL COMMENT '考研学校基本资料',
  `SCHOOL_PROFILE_MAIN_PROFILE` varchar(10000) DEFAULT NULL COMMENT '考研学校详细介绍',
  `SCHOOL_PROFILE_BEST_MAJOR` varchar(50) DEFAULT NULL COMMENT '考研学校最好专业',
  `SCHOOL_PROFILE_BEST_TEACHER` varchar(100) DEFAULT NULL COMMENT '考研学校最好导师',
  `SCHOOL_PROFILE_STATE` int(11) NOT NULL COMMENT '考研学校状态',
  `SCHOOL_PROFILE_CREATE_TIME` datetime NOT NULL COMMENT '考研学校系统创建时间',
  `SCHOOL_PROFILE_UPDATE_TIME` datetime DEFAULT NULL COMMENT '考研学校系统更新时间',
  PRIMARY KEY (`SCHOOL_PROFILE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考研学校简介';

-- ----------------------------
-- Records of school_profile
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `SYS_USER_CUID` varchar(100) NOT NULL COMMENT '系统用户CUID',
  `MAJOR_CUID` varchar(100) DEFAULT NULL COMMENT '专业CUID',
  `SYS_USER_NAME` varchar(50) DEFAULT NULL COMMENT '系统用户名称',
  `SYS_USER_REAL_NAME` varchar(50) DEFAULT NULL COMMENT '系统用户真实名称',
  `SYS_USER_LOGIN_NAME` varchar(50) NOT NULL COMMENT '系统用户登录名',
  `SYS_USER_PASSWORD` varchar(255) NOT NULL COMMENT '系统用户登录密码',
  `SYS_USER_TYPE` int(11) DEFAULT NULL COMMENT '系统用户类型',
  `SYS_USER_EMAIL` varchar(50) DEFAULT NULL COMMENT '系统用户邮箱',
  `SYS_USER_SEX` int(11) DEFAULT NULL COMMENT '系统用户性别',
  `SYS_USER_AGE` int(11) DEFAULT NULL COMMENT '系统用户年龄',
  `SYS_USER_TELE` varchar(20) DEFAULT NULL COMMENT '系统用户电话',
  `SYS_USER_VER_CODE` varchar(10) DEFAULT NULL COMMENT '系统用户验证码',
  `SYS_USER_URL` varchar(100) DEFAULT NULL COMMENT '系统用户头像',
  `SYS_USER_SIGNATURE` varchar(255) DEFAULT NULL COMMENT '系统用户个人简介',
  `SYS_USER_COLLEGE` varchar(50) DEFAULT NULL COMMENT '系统用户学院',
  `SYS_USER_MAGOR` varchar(50) DEFAULT NULL COMMENT '系统用户专业',
  `SYS_USER_FOR_SCHOOL` varchar(50) DEFAULT NULL COMMENT '系统用户报考学校',
  `SYS_USER_FOR_MAGOR` varchar(50) DEFAULT NULL COMMENT '系统用户报考专业',
  `SYS_USER_LABEL` varchar(100) DEFAULT NULL COMMENT '系统用户标签',
  `SYS_USER_ADDRESS` varchar(100) DEFAULT NULL COMMENT '系统用户地址',
  `SYS_USER_GPS_ADDRESS` varchar(100) DEFAULT NULL COMMENT '系统用户定位地址',
  `SYS_USER_STATE` int(11) NOT NULL COMMENT '系统用户状态',
  `SYS_USER_CREATE_TIME` datetime NOT NULL COMMENT '系统用户创建时间',
  `SYS_USER_UPDATE_TIME` datetime DEFAULT NULL COMMENT '系统用户更新时间',
  PRIMARY KEY (`SYS_USER_CUID`),
  KEY `FK_Relationship_2` (`MAJOR_CUID`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`MAJOR_CUID`) REFERENCES `major` (`MAJOR_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('SYSUSER2016031305', null, '发抖的小喵喵', '胡志辉', 'huzhihui', '123456', '2', 'huzhihui_c@qq.com', '0', '0', '18380461811', null, null, null, '西华大学', '软件工程', '清华大学', '软件工程', null, '西华大学11舍B204', null, '1', '2016-03-13 19:06:12', null);
INSERT INTO `sys_user` VALUES ('SYSUSER2016031306', null, null, null, '', '12312141241231231231231244324234432131', '2', '', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-03-13 19:08:19', null);
INSERT INTO `sys_user` VALUES ('SYSUSER2016032607', null, null, null, 'chenqiaoqiao', '123456', '2', '1245226827@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-03-26 20:50:04', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201604150102', null, null, null, 'lambor', '123456', '2', '314753899@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-04-15 22:22:55', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201604160117', null, null, null, 'huzhihui001', '123456', '2', '742032660@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-04-16 09:57:47', null);
