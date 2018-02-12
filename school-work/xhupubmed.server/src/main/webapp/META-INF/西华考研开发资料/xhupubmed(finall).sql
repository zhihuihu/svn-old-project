/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : xhupubmed

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-06-02 10:35:07
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
INSERT INTO `classroom` VALUES ('CLASSROOM201604200141', 'SYSUSER2016031305', '冲刺学习', '6教', '6A414', '今天晚上就一起学习吧,快来参加吧,', null, '6', '1', '2016-05-20 21:40:00', '2016-04-20 21:40:52');
INSERT INTO `classroom` VALUES ('CLASSROOM201604200142', 'SYSUSER2016031305', '今晚上冲刺学习,大家加油啊', '6教', '6A414', '今天晚上就一起学习吧,快来参加吧,', null, '3', '1', '2016-04-20 22:40:00', '2016-04-20 21:42:44');
INSERT INTO `classroom` VALUES ('CLASSROOM201604200143', 'SYSUSER2016031305', '教室一起来呀', '6教', '6A602', '好的好的黑道皇后好哒好哒好', null, '2', '1', '2016-04-20 23:23:00', '2016-04-20 22:23:18');
INSERT INTO `classroom` VALUES ('CLASSROOM201604210150', 'SYSUSER2016031305', '4.21冲刺啦，时间不多了', '6教', '6a102', '好的好的喝酒喝的哈哈哈哈等哈好好学呵呵就放假飞机杯好吃经常', null, '3', '1', '2016-04-22 21:27:00', '2016-04-21 21:27:31');
INSERT INTO `classroom` VALUES ('CLASSROOM201604230156', 'SYSUSER2016031305', '周六大放送', '6教', '6a504', '结婚的话放假几号放假放假觉得好吃好好好。好的黄飞鸿好多好吃结婚好成绩', null, '3', '1', '2016-04-24 15:43:00', '2016-04-23 15:43:58');
INSERT INTO `classroom` VALUES ('CLASSROOM201605040222', 'SYSUSER2016031305', '5.求约', '6教', '6A504', 'u付放假放假', null, '4', '1', '2016-05-04 17:06:00', '2016-05-04 15:06:48');
INSERT INTO `classroom` VALUES ('CLASSROOM201605050278', 'SYSUSER201605050272', '测试教室', '6教', '6a408', '好的好的好', null, '4', '1', '2016-05-06 16:23:00', '2016-05-05 12:23:18');
INSERT INTO `classroom` VALUES ('CLASSROOM201605050294', 'SYSUSER201605050272', '今天来吧', '5教', '5A406', '恒大华府就放假', null, '3', '1', '2016-05-05 18:40:00', '2016-05-05 12:41:01');
INSERT INTO `classroom` VALUES ('CLASSROOM201605220518', 'SYSUSER201605050272', '添加新教室', '6教', '6A408', '呵呵电话费', null, '2', '1', '2016-05-23 22:14:00', '2016-05-22 22:15:02');
INSERT INTO `classroom` VALUES ('CLASSROOM201605220519', 'SYSUSER2016031305', '今晚不醉不归', '6教', '6A503', '速度来啊，考研的同学们', null, '3', '1', '2016-05-23 22:20:00', '2016-05-22 22:20:39');
INSERT INTO `classroom` VALUES ('CLASSROOM201605270544', 'SYSUSER2016031305', '比赛教室', '6教', '6A432', '大家快来哦', null, '2', '1', '2016-05-28 09:15:00', '2016-05-27 22:15:37');
INSERT INTO `classroom` VALUES ('CLASSROOM201605270545', 'SYSUSER2016031305', '比赛教室', '6教', '6A432', '大家快来哦', null, '2', '1', '2016-05-28 09:15:00', '2016-05-27 22:15:51');

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
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605020198', 'SYSUSER2016031305', '最后测试', '2', '英语', '1', null, '合适的话', '就放假放假', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462183272529505.qm_guid', 'http://192.168.31.219:8080/xhupubmedfiles/file/1462183272574133.dat', 'localhost:8080/xhupubmedfiles/file/1462183272617161.cache', null, '2016-05-02 18:01:12', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605020199', 'SYSUSER2016031305', '最后测试', '2', '英语', '1', null, '合适的话', '就放假放假', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462183298901748.qm_guid', 'http://192.168.31.219:8080/xhupubmedfiles/file/1462183298921911.dat', null, null, '2016-05-02 18:01:38', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605020200', 'SYSUSER2016031305', '添加数据一', '2', '英语', '1', null, '合适的话', '就放假放假', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462183339813282.jpg', null, null, null, '2016-05-02 18:02:14', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605020201', 'SYSUSER2016031305', '添加数据二', '2', '英语', '1', null, '合适的话', '就放假放假', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462183352344455.jpg', null, null, null, '2016-05-02 18:02:32', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605030202', 'SYSUSER2016031305', '2016最新英语复习资料', '2', '英语', '1', null, '好烦好烦和我好好学哈哈哈发哈发哈好好吃饭好奖学金发货经常吃货就吃饭黄飞鸿好像好吃警察局发货继续接电话', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462239035450421.txt', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462239037489177.jpg', null, null, '2016-05-03 09:30:33', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605030205', 'SYSUSER2016031305', '5.3政治分享', '2', '政治', '1', null, '好的好烦好烦', 'www.xhu.edu.cn', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462251841934898.jpg', null, null, null, '2016-05-03 13:03:58', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605030216', 'SYSUSER2016031305', '最好的回归测试', '2', '数学', '1', null, '回电话防腐剂', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462258094047634.jpg', null, null, null, '2016-05-03 14:48:11', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605050281', 'SYSUSER201605050272', '随便测试', '2', '英语', '1', null, '恒大华府黄飞鸿', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462422654260246.jpg', null, null, null, '2016-05-05 12:30:50', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605060310', 'SYSUSER201605050272', '5.6文件分享', '2', '公共', '1', null, '好词好句', 'www.baidu.com', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462522986086833.jpg', null, null, null, '2016-05-06 16:23:02', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605070320', 'SYSUSER201605050272', '随便分享', '2', '政治', '1', null, '回电话附近的', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462609791327478.png', null, null, null, '2016-05-07 16:29:51', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605080331', 'SYSUSER201605050272', '英语书籍分享', '1', '英语', '1', null, '好的好的黄飞鸿金凤凰发哈恒大华府呵呵吹风机就喜欢吃饭哈接电话发货', '', null, null, null, null, '2016-05-08 11:31:07', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605100335', 'SYSUSER201605050274', '测试分享', '2', '政治', '1', null, '发生发生的按时阿萨德昂发', null, null, null, null, null, '2016-05-10 14:17:27', '2016-05-10 14:17:27');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605100336', 'SYSUSER201605050274', '管理员测试分享', '2', '政治', '1', null, '佛挡杀佛昂发阿萨德发生的按时', 'www.taobao.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462861120200496.exe', 'http://192.168.31.219:8080/xhupubmedfiles/files/1462861121953839.zip', null, null, '2016-05-10 14:18:40', '2016-05-10 14:18:40');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605100392', 'SYSUSER2016031305', '测试分享', '2', '英语', '1', null, '回到家发酒疯', 'www.baidu.com', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462867022407821.jpg', null, null, null, '2016-05-10 15:56:59', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605100393', 'SYSUSER2016031305', '管理员测试分享2', '1', '政治', '1', null, 'fasgadkjf hasdlfj las lfas;l vlasdjf asd fa', 'www.baidu.com', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462872125654299.zip', null, null, null, '2016-05-10 17:22:05', '2016-05-10 17:22:05');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605100394', 'SYSUSER2016031305', '小文件测试', '2', '英语', '1', null, 'fasfas dfa sf a', 'www.baidu.com', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462872242244702.jpg', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462872242248855.jpg', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462872242252490.jpg', null, '2016-05-10 17:24:02', '2016-05-10 17:24:02');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605100395', 'SYSUSER2016031305', '大文件测试', '2', '数学', '1', null, 'fadfjkasdhfkask gnadkjshf kjasdjfkj dhkjashfasd', 'www.baidu.com', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462872493431310.zip', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462872493439476.zip', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462872493444909.zip', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462872493450767.zip', '2016-05-10 17:28:13', '2016-05-10 17:28:13');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605100396', 'SYSUSER2016031305', '大文件测试3', '2', '英语', '1', null, 'fadsfasdf asf a ', 'www.baidu.com', 'http://192.168.2.122:8080/xhupubmedfiles/files/1462872674252296.exe', null, null, null, '2016-05-10 17:31:14', '2016-05-10 17:31:14');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605160420', 'SYSUSER2016031305', '测试分享', '2', '政治', '1', null, '测试内容而已', '英语', 'http://192.168.2.122:8080/xhupubmedfiles/files/1463368330670445.exe', null, null, null, '2016-05-16 11:12:10', '2016-05-16 11:12:10');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605160421', 'SYSUSER2016031305', '测试', '2', '英语', '1', null, 'fsdaf a', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1463368416138552.txt', null, null, null, '2016-05-16 11:13:36', '2016-05-16 11:13:36');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605190430', 'SYSUSER201605050274', '测试文件分享', '1', '政治', '1', null, 'fdafasdf asf asd f', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1463667201299416.exe', null, null, null, '2016-05-19 22:13:21', '2016-05-19 22:13:21');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605210478', 'SYSUSER2016031305', '分享文件', '2', '政治', '1', null, '好的好的回电话', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1463834279036311.qm_guid', null, null, null, '2016-05-21 20:37:58', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605210479', 'SYSUSER2016031305', 'fenx', '2', '政治', '1', null, '好的好的好', '', 'http://192.168.31.219:8080/xhupubmedfiles/files/1463834332461675.jpg', null, null, null, '2016-05-21 20:38:52', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605210490', 'SYSUSER2016031305', '最新书籍', '3', '政治', '1', null, '就等会', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1463837217267164.jpg', null, null, null, '2016-05-21 21:26:57', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605210491', 'SYSUSER2016031305', 'fenxhdh', '2', '', '1', null, '', '', 'http://192.168.31.219:8080/xhupubmedfiles/files/1463837291010112.jpg', 'http://192.168.31.219:8080/xhupubmedfiles/files/1463837291574157.jpg', 'http://192.168.31.219:8080/xhupubmedfiles/files/1463837291794657.png', null, '2016-05-21 21:28:09', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605210492', 'SYSUSER2016031305', '最新英语资料', '1', '英语', '1', null, '防撒旦法 ', '阿萨德法师打发阿萨德', null, null, null, null, '2016-05-21 21:30:27', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605210493', 'SYSUSER2016031305', '最新英语资料', '1', '英语', '1', null, '防撒旦法 ', '阿萨德法师打发阿萨德', null, null, null, null, '2016-05-21 21:30:35', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605210494', 'SYSUSER2016031305', 'ceshi ', '2', '政治', '1', null, '发生的发生的发生的阿萨德', '', null, null, null, null, '2016-05-21 21:31:48', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605210496', 'SYSUSER2016031305', '文件', '2', '政治', '1', null, '好的好的好', '', 'http://192.168.31.219:8080/xhupubmedfiles/files/1463837839792202.png', null, null, null, '2016-05-21 21:37:19', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605290576', 'SYSUSER2016031305', '西华大学2016考研资料', '2', '全部', '1', null, '查看附件', '', 'http://192.168.31.219:8080/xhupubmedfiles/files/1464510812672580.jpg', null, null, null, '2016-05-29 16:33:29', null);
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605300582', 'SYSUSER201605050274', '测试文件', '1', '政治', '1', null, 'fdfas fads fas ', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1464614769218834.doc', null, null, null, '2016-05-30 21:26:09', '2016-05-30 21:26:09');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201605300586', 'SYSUSER201605050274', '测试文件', '1', '政治', '1', null, 'fsdfsd ', 'www.baidu.com', 'http://192.168.31.219:8080/xhupubmedfiles/files/1464616317882322.rar', null, null, null, '2016-05-30 21:51:57', '2016-05-30 21:51:57');
INSERT INTO `data_sharing` VALUES ('DATA_SHARING201606020606', 'SYSUSER2016031305', '分享毕业照片啦', '2', '英语', '1', null, '哈哈', '', 'http://192.168.31.219:8080/xhupubmedfiles/files/1464834373742928.jpg', null, null, null, '2016-06-02 10:26:11', null);

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
INSERT INTO `follow` VALUES ('FOLLOW201605030209', 'SYSUSER2016031305', null, null, 'POST201604230168', '2016-05-03 14:28:14', '1', '2016-05-03 14:28:14', null);
INSERT INTO `follow` VALUES ('FOLLOW201605030210', 'SYSUSER2016031305', null, null, 'POST201604160126', '2016-05-03 14:28:18', '1', '2016-05-03 14:28:18', null);
INSERT INTO `follow` VALUES ('FOLLOW201605030211', 'SYSUSER2016031305', null, null, 'POST20160410029', '2016-05-03 14:28:49', '1', '2016-05-03 14:28:49', null);
INSERT INTO `follow` VALUES ('FOLLOW201605030212', 'SYSUSER2016031305', null, null, 'POST20160408027', '2016-05-03 14:28:53', '1', '2016-05-03 14:28:53', null);
INSERT INTO `follow` VALUES ('FOLLOW201605050269', 'SYSUSER2016031305', null, null, 'POST201605050268', '2016-05-05 10:28:20', '1', '2016-05-05 10:28:20', null);
INSERT INTO `follow` VALUES ('FOLLOW201605050270', 'SYSUSER2016031305', null, null, 'POST201605030221', '2016-05-05 11:13:08', '1', '2016-05-05 11:13:08', null);
INSERT INTO `follow` VALUES ('FOLLOW201605050275', 'SYSUSER201605050272', null, null, 'POST201605030221', '2016-05-05 12:21:39', '1', '2016-05-05 12:21:39', null);
INSERT INTO `follow` VALUES ('FOLLOW201605050284', 'SYSUSER201605050272', null, null, 'POST201605050268', '2016-05-05 12:38:08', '1', '2016-05-05 12:38:08', null);
INSERT INTO `follow` VALUES ('FOLLOW201605050298', 'SYSUSER2016031305', null, null, 'POST201605050276', '2016-05-05 12:59:15', '1', '2016-05-05 12:59:15', null);
INSERT INTO `follow` VALUES ('FOLLOW201605050302', 'SYSUSER201605050272', null, null, 'POST201605050276', '2016-05-05 13:38:23', '1', '2016-05-05 13:38:23', null);
INSERT INTO `follow` VALUES ('FOLLOW201605070319', 'SYSUSER201605050272', null, null, 'POST201605070316', '2016-05-07 16:10:51', '1', '2016-05-07 16:10:51', null);
INSERT INTO `follow` VALUES ('FOLLOW201605080329', 'SYSUSER201605050272', null, null, 'POST201605080328', '2016-05-08 11:29:47', '1', '2016-05-08 11:29:47', null);
INSERT INTO `follow` VALUES ('FOLLOW201605100350', 'SYSUSER201605100339', null, null, 'POST201605070316', '2016-05-10 14:41:25', '1', '2016-05-10 14:41:25', null);
INSERT INTO `follow` VALUES ('FOLLOW201605100359', 'SYSUSER201605100339', null, null, 'POST201605100357', '2016-05-10 14:54:07', '1', '2016-05-10 14:54:07', null);
INSERT INTO `follow` VALUES ('FOLLOW201605100382', 'SYSUSER201605100368', null, null, 'POST201605070322', '2016-05-10 15:15:27', '1', '2016-05-10 15:15:27', null);
INSERT INTO `follow` VALUES ('FOLLOW201605180423', 'SYSUSER2016031305', null, null, 'POST201605140416', '2016-05-18 20:31:40', '1', '2016-05-18 20:31:40', null);
INSERT INTO `follow` VALUES ('FOLLOW201605220498', 'SYSUSER2016031305', null, null, 'POST201605210497', '2016-05-22 21:50:00', '1', '2016-05-22 21:50:00', null);
INSERT INTO `follow` VALUES ('FOLLOW201605220501', 'SYSUSER2016031305', null, null, 'POST201605220500', '2016-05-22 21:57:07', '1', '2016-05-22 21:57:07', null);
INSERT INTO `follow` VALUES ('FOLLOW201605220523', 'SYSUSER2016031305', null, null, 'POST201605220522', '2016-05-22 22:45:44', '1', '2016-05-22 22:45:44', null);
INSERT INTO `follow` VALUES ('FOLLOW201605270549', 'SYSUSER2016031305', null, null, 'POST201605270547', '2016-05-27 22:18:41', '1', '2016-05-27 22:18:41', null);

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
INSERT INTO `friend` VALUES ('FRIEND201605050280', 'SYSUSER201605050272', 'SYSUSER201605050272', '张三测试用户', 'SYSUSER201605050272', '2016-05-05 12:24:10', '1', '2016-05-05 12:24:10', null);
INSERT INTO `friend` VALUES ('FRIEND201605050285', 'SYSUSER201605050272', 'SYSUSER2016031305', 'huzhihui', 'SYSUSER2016031305', '2016-05-05 12:38:24', '1', '2016-05-05 12:38:24', null);
INSERT INTO `friend` VALUES ('FRIEND201605050297', 'SYSUSER2016031305', 'SYSUSER201605050272', '张三测试用户', 'SYSUSER201605050272', '2016-05-05 12:59:11', '1', '2016-05-05 12:59:11', null);
INSERT INTO `friend` VALUES ('FRIEND201605100361', 'SYSUSER201605100339', 'SYSUSER201605100339', 'wangxin', 'SYSUSER201605100339', '2016-05-10 14:54:59', '1', '2016-05-10 14:54:59', null);
INSERT INTO `friend` VALUES ('FRIEND201605100362', 'SYSUSER201605100339', 'SYSUSER2016031305', 'huzhihui', 'SYSUSER2016031305', '2016-05-10 14:55:06', '1', '2016-05-10 14:55:06', null);
INSERT INTO `friend` VALUES ('FRIEND201605150418', 'SYSUSER2016031305', 'SYSUSER201605100368', 'yangseng', 'SYSUSER201605100368', '2016-05-15 10:59:43', '1', '2016-05-15 10:59:43', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=610 DEFAULT CHARSET=utf8 COMMENT='系统全局CUID';

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
INSERT INTO `global_table` VALUES ('144', 'OPPOINTMENT', '用户约定表插入', '2016-04-21 21:10:38');
INSERT INTO `global_table` VALUES ('145', 'OPPOINTMENT', '用户约定表插入', '2016-04-21 21:10:57');
INSERT INTO `global_table` VALUES ('146', 'OPPOINTMENT', '用户约定表插入', '2016-04-21 21:10:59');
INSERT INTO `global_table` VALUES ('147', 'OPPOINTMENT', '用户约定表插入', '2016-04-21 21:18:40');
INSERT INTO `global_table` VALUES ('148', 'OPPOINTMENT', '用户约定表插入', '2016-04-21 21:18:45');
INSERT INTO `global_table` VALUES ('149', 'OPPOINTMENT', '用户约定表插入', '2016-04-21 21:18:48');
INSERT INTO `global_table` VALUES ('150', 'CLASSROOM', '教室表插入！', '2016-04-21 21:27:31');
INSERT INTO `global_table` VALUES ('151', 'OPPOINTMENT', '用户约定表插入', '2016-04-21 21:28:26');
INSERT INTO `global_table` VALUES ('152', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-21 21:29:37');
INSERT INTO `global_table` VALUES ('153', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-21 21:29:38');
INSERT INTO `global_table` VALUES ('154', 'OPPOINTMENT', '用户约定表插入', '2016-04-23 15:17:43');
INSERT INTO `global_table` VALUES ('155', 'OPPOINTMENT', '用户约定表插入', '2016-04-23 15:19:46');
INSERT INTO `global_table` VALUES ('156', 'CLASSROOM', '教室表插入！', '2016-04-23 15:43:58');
INSERT INTO `global_table` VALUES ('157', 'OPPOINTMENT', '用户约定表插入', '2016-04-23 15:44:14');
INSERT INTO `global_table` VALUES ('158', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:14:54');
INSERT INTO `global_table` VALUES ('159', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:14:57');
INSERT INTO `global_table` VALUES ('160', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:15:11');
INSERT INTO `global_table` VALUES ('161', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:15:12');
INSERT INTO `global_table` VALUES ('162', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:15:18');
INSERT INTO `global_table` VALUES ('163', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:15:20');
INSERT INTO `global_table` VALUES ('164', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:15:28');
INSERT INTO `global_table` VALUES ('165', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:15:29');
INSERT INTO `global_table` VALUES ('166', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:15:46');
INSERT INTO `global_table` VALUES ('167', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-04-23 16:15:48');
INSERT INTO `global_table` VALUES ('168', 'POST', '帖子表插入', '2016-04-23 16:18:29');
INSERT INTO `global_table` VALUES ('169', 'REPLIES', '帖子回复表', '2016-04-23 16:18:38');
INSERT INTO `global_table` VALUES ('170', 'POST', '帖子表插入', '2016-05-02 12:44:51');
INSERT INTO `global_table` VALUES ('171', 'REPLIES', '帖子回复表', '2016-05-02 12:45:20');
INSERT INTO `global_table` VALUES ('172', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-02 12:58:14');
INSERT INTO `global_table` VALUES ('173', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-02 12:58:16');
INSERT INTO `global_table` VALUES ('174', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-02 12:58:25');
INSERT INTO `global_table` VALUES ('175', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-02 12:58:27');
INSERT INTO `global_table` VALUES ('176', 'DATA_SHARING', '', '2016-05-02 15:15:06');
INSERT INTO `global_table` VALUES ('177', 'DATA_SHARING', '', '2016-05-02 16:37:11');
INSERT INTO `global_table` VALUES ('178', 'DATA_SHARING', '', '2016-05-02 16:39:38');
INSERT INTO `global_table` VALUES ('179', 'DATA_SHARING', '', '2016-05-02 16:40:52');
INSERT INTO `global_table` VALUES ('180', 'DATA_SHARING', '', '2016-05-02 16:42:37');
INSERT INTO `global_table` VALUES ('181', 'DATA_SHARING', '', '2016-05-02 16:48:23');
INSERT INTO `global_table` VALUES ('182', 'DATA_SHARING', '', '2016-05-02 16:59:07');
INSERT INTO `global_table` VALUES ('183', 'DATA_SHARING', '', '2016-05-02 17:03:10');
INSERT INTO `global_table` VALUES ('184', 'DATA_SHARING', '', '2016-05-02 17:04:55');
INSERT INTO `global_table` VALUES ('185', 'DATA_SHARING', '', '2016-05-02 17:07:14');
INSERT INTO `global_table` VALUES ('186', 'DATA_SHARING', '', '2016-05-02 17:11:43');
INSERT INTO `global_table` VALUES ('187', 'DATA_SHARING', '', '2016-05-02 17:15:30');
INSERT INTO `global_table` VALUES ('188', 'DATA_SHARING', '', '2016-05-02 17:43:33');
INSERT INTO `global_table` VALUES ('189', 'DATA_SHARING', '', '2016-05-02 17:45:04');
INSERT INTO `global_table` VALUES ('190', 'DATA_SHARING', '', '2016-05-02 17:46:06');
INSERT INTO `global_table` VALUES ('191', 'DATA_SHARING', '', '2016-05-02 17:46:47');
INSERT INTO `global_table` VALUES ('192', 'DATA_SHARING', '', '2016-05-02 17:47:17');
INSERT INTO `global_table` VALUES ('193', 'DATA_SHARING', '', '2016-05-02 17:47:29');
INSERT INTO `global_table` VALUES ('194', 'DATA_SHARING', '', '2016-05-02 17:48:03');
INSERT INTO `global_table` VALUES ('195', 'DATA_SHARING', '', '2016-05-02 17:56:14');
INSERT INTO `global_table` VALUES ('196', 'DATA_SHARING', '', '2016-05-02 17:56:29');
INSERT INTO `global_table` VALUES ('197', 'DATA_SHARING', '', '2016-05-02 17:57:06');
INSERT INTO `global_table` VALUES ('198', 'DATA_SHARING', '', '2016-05-02 18:01:12');
INSERT INTO `global_table` VALUES ('199', 'DATA_SHARING', '', '2016-05-02 18:01:38');
INSERT INTO `global_table` VALUES ('200', 'DATA_SHARING', '', '2016-05-02 18:02:14');
INSERT INTO `global_table` VALUES ('201', 'DATA_SHARING', '', '2016-05-02 18:02:32');
INSERT INTO `global_table` VALUES ('202', 'DATA_SHARING', '', '2016-05-03 09:30:33');
INSERT INTO `global_table` VALUES ('203', 'POST', '帖子表插入', '2016-05-03 10:18:47');
INSERT INTO `global_table` VALUES ('204', 'REPLIES', '帖子回复表', '2016-05-03 10:19:02');
INSERT INTO `global_table` VALUES ('205', 'DATA_SHARING', '', '2016-05-03 13:03:58');
INSERT INTO `global_table` VALUES ('206', 'FOLLOW', '用户关注表插入数据', '2016-05-03 13:39:48');
INSERT INTO `global_table` VALUES ('207', 'FOLLOW', '用户关注表插入数据', '2016-05-03 13:40:03');
INSERT INTO `global_table` VALUES ('208', 'FOLLOW', '用户关注表插入数据', '2016-05-03 14:28:07');
INSERT INTO `global_table` VALUES ('209', 'FOLLOW', '用户关注表插入数据', '2016-05-03 14:28:14');
INSERT INTO `global_table` VALUES ('210', 'FOLLOW', '用户关注表插入数据', '2016-05-03 14:28:18');
INSERT INTO `global_table` VALUES ('211', 'FOLLOW', '用户关注表插入数据', '2016-05-03 14:28:49');
INSERT INTO `global_table` VALUES ('212', 'FOLLOW', '用户关注表插入数据', '2016-05-03 14:28:53');
INSERT INTO `global_table` VALUES ('213', 'POST', '帖子表插入', '2016-05-03 14:29:52');
INSERT INTO `global_table` VALUES ('214', 'REPLIES', '帖子回复表', '2016-05-03 14:30:20');
INSERT INTO `global_table` VALUES ('215', 'FOLLOW', '用户关注表插入数据', '2016-05-03 14:30:32');
INSERT INTO `global_table` VALUES ('216', 'DATA_SHARING', '', '2016-05-03 14:48:11');
INSERT INTO `global_table` VALUES ('217', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-03 14:51:51');
INSERT INTO `global_table` VALUES ('218', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-03 14:51:53');
INSERT INTO `global_table` VALUES ('219', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-03 14:52:04');
INSERT INTO `global_table` VALUES ('220', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-03 14:52:07');
INSERT INTO `global_table` VALUES ('221', 'POST', '帖子表插入', '2016-05-03 15:12:33');
INSERT INTO `global_table` VALUES ('222', 'CLASSROOM', '教室表插入！', '2016-05-04 15:06:48');
INSERT INTO `global_table` VALUES ('223', 'OPPOINTMENT', '用户约定表插入', '2016-05-04 15:07:01');
INSERT INTO `global_table` VALUES ('224', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:07:33');
INSERT INTO `global_table` VALUES ('225', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:07:36');
INSERT INTO `global_table` VALUES ('226', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:07:41');
INSERT INTO `global_table` VALUES ('227', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:07:42');
INSERT INTO `global_table` VALUES ('228', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:07:46');
INSERT INTO `global_table` VALUES ('229', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:07:48');
INSERT INTO `global_table` VALUES ('230', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:07:52');
INSERT INTO `global_table` VALUES ('231', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:07:53');
INSERT INTO `global_table` VALUES ('232', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:07:59');
INSERT INTO `global_table` VALUES ('233', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-04 15:08:00');
INSERT INTO `global_table` VALUES ('240', 'SCHOOL_PROFILE', '', '2016-05-04 20:33:55');
INSERT INTO `global_table` VALUES ('243', 'SCHOOL_PROFILE', '', '2016-05-04 20:37:58');
INSERT INTO `global_table` VALUES ('244', 'SCHOOL_PROFILE', '', '2016-05-04 20:40:14');
INSERT INTO `global_table` VALUES ('246', 'SCHOOL_INFORMATION', '', '2016-05-04 23:28:58');
INSERT INTO `global_table` VALUES ('247', 'SCHOOL_INFORMATION', '', '2016-05-05 09:16:20');
INSERT INTO `global_table` VALUES ('248', 'SCHOOL_INFORMATION', '', '2016-05-05 09:16:21');
INSERT INTO `global_table` VALUES ('249', 'SCHOOL_INFORMATION', '', '2016-05-05 09:19:49');
INSERT INTO `global_table` VALUES ('250', 'SCHOOL_INFORMATION', '', '2016-05-05 09:19:49');
INSERT INTO `global_table` VALUES ('251', 'SCHOOL_INFORMATION', '', '2016-05-05 09:20:15');
INSERT INTO `global_table` VALUES ('252', 'SCHOOL_INFORMATION', '', '2016-05-05 09:20:15');
INSERT INTO `global_table` VALUES ('253', 'SCHOOL_INFORMATION', '', '2016-05-05 09:20:41');
INSERT INTO `global_table` VALUES ('254', 'SCHOOL_INFORMATION', '', '2016-05-05 09:20:41');
INSERT INTO `global_table` VALUES ('255', 'SCHOOL_INFORMATION', '', '2016-05-05 09:21:01');
INSERT INTO `global_table` VALUES ('256', 'SCHOOL_INFORMATION', '', '2016-05-05 09:21:01');
INSERT INTO `global_table` VALUES ('257', 'SCHOOL_INFORMATION', '', '2016-05-05 09:21:40');
INSERT INTO `global_table` VALUES ('258', 'SCHOOL_INFORMATION', '', '2016-05-05 09:21:40');
INSERT INTO `global_table` VALUES ('259', 'SCHOOL_INFORMATION', '', '2016-05-05 09:23:56');
INSERT INTO `global_table` VALUES ('260', 'SCHOOL_INFORMATION', '', '2016-05-05 09:24:42');
INSERT INTO `global_table` VALUES ('261', 'LEARN_PLAN', '学习计划表插入', '2016-05-05 10:25:57');
INSERT INTO `global_table` VALUES ('262', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 10:26:35');
INSERT INTO `global_table` VALUES ('263', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 10:26:37');
INSERT INTO `global_table` VALUES ('264', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 10:26:44');
INSERT INTO `global_table` VALUES ('265', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 10:26:45');
INSERT INTO `global_table` VALUES ('266', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 10:26:54');
INSERT INTO `global_table` VALUES ('267', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 10:26:55');
INSERT INTO `global_table` VALUES ('268', 'POST', '帖子表插入', '2016-05-05 10:28:12');
INSERT INTO `global_table` VALUES ('269', 'FOLLOW', '用户关注表插入数据', '2016-05-05 10:28:20');
INSERT INTO `global_table` VALUES ('270', 'FOLLOW', '用户关注表插入数据', '2016-05-05 11:13:08');
INSERT INTO `global_table` VALUES ('271', 'REPLIES', '帖子回复表', '2016-05-05 11:13:14');
INSERT INTO `global_table` VALUES ('272', 'SYS_USER', '系统用户表', '2016-05-05 12:19:26');
INSERT INTO `global_table` VALUES ('273', 'REPLIES', '帖子回复表', '2016-05-05 12:21:17');
INSERT INTO `global_table` VALUES ('274', 'REPLIES', '帖子回复表', '2016-05-05 12:21:31');
INSERT INTO `global_table` VALUES ('275', 'FOLLOW', '用户关注表插入数据', '2016-05-05 12:21:39');
INSERT INTO `global_table` VALUES ('276', 'POST', '帖子表插入', '2016-05-05 12:22:28');
INSERT INTO `global_table` VALUES ('277', 'OPPOINTMENT', '用户约定表插入', '2016-05-05 12:22:37');
INSERT INTO `global_table` VALUES ('278', 'CLASSROOM', '教室表插入！', '2016-05-05 12:23:18');
INSERT INTO `global_table` VALUES ('279', 'OPPOINTMENT', '用户约定表插入', '2016-05-05 12:23:30');
INSERT INTO `global_table` VALUES ('280', 'FRIEND', '好友表插入数据', '2016-05-05 12:24:10');
INSERT INTO `global_table` VALUES ('281', 'DATA_SHARING', '', '2016-05-05 12:30:50');
INSERT INTO `global_table` VALUES ('282', 'FRIEND', '好友表插入数据', '2016-05-05 12:37:27');
INSERT INTO `global_table` VALUES ('283', 'OPPOINTMENT', '用户约定表插入', '2016-05-05 12:37:47');
INSERT INTO `global_table` VALUES ('284', 'FOLLOW', '用户关注表插入数据', '2016-05-05 12:38:08');
INSERT INTO `global_table` VALUES ('285', 'FRIEND', '好友表插入数据', '2016-05-05 12:38:24');
INSERT INTO `global_table` VALUES ('286', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 12:38:37');
INSERT INTO `global_table` VALUES ('287', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 12:38:39');
INSERT INTO `global_table` VALUES ('288', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 12:38:47');
INSERT INTO `global_table` VALUES ('289', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 12:38:48');
INSERT INTO `global_table` VALUES ('290', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 12:39:00');
INSERT INTO `global_table` VALUES ('291', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 12:39:01');
INSERT INTO `global_table` VALUES ('292', 'LEARN_PLAN', '学习计划表插入', '2016-05-05 12:40:04');
INSERT INTO `global_table` VALUES ('293', 'LEARN_PLAN', '学习计划表插入', '2016-05-05 12:40:26');
INSERT INTO `global_table` VALUES ('294', 'CLASSROOM', '教室表插入！', '2016-05-05 12:41:01');
INSERT INTO `global_table` VALUES ('295', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 12:58:54');
INSERT INTO `global_table` VALUES ('296', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-05 12:58:55');
INSERT INTO `global_table` VALUES ('297', 'FRIEND', '好友表插入数据', '2016-05-05 12:59:11');
INSERT INTO `global_table` VALUES ('298', 'FOLLOW', '用户关注表插入数据', '2016-05-05 12:59:15');
INSERT INTO `global_table` VALUES ('299', 'REPLIES', '帖子回复表', '2016-05-05 12:59:28');
INSERT INTO `global_table` VALUES ('300', 'REPLIES', '帖子回复表', '2016-05-05 12:59:40');
INSERT INTO `global_table` VALUES ('301', 'REPLIES', '帖子回复表', '2016-05-05 13:38:08');
INSERT INTO `global_table` VALUES ('302', 'FOLLOW', '用户关注表插入数据', '2016-05-05 13:38:23');
INSERT INTO `global_table` VALUES ('303', 'REPLIES', '帖子回复表', '2016-05-05 14:08:44');
INSERT INTO `global_table` VALUES ('304', 'OPPOINTMENT', '用户约定表插入', '2016-05-05 14:09:04');
INSERT INTO `global_table` VALUES ('305', 'OPPOINTMENT', '用户约定表插入', '2016-05-05 14:09:06');
INSERT INTO `global_table` VALUES ('306', 'OPPOINTMENT', '用户约定表插入', '2016-05-05 14:09:12');
INSERT INTO `global_table` VALUES ('307', 'POST', '帖子表插入', '2016-05-05 14:10:13');
INSERT INTO `global_table` VALUES ('308', 'POST', '帖子表插入', '2016-05-05 15:19:59');
INSERT INTO `global_table` VALUES ('309', 'REPLIES', '帖子回复表', '2016-05-05 15:20:26');
INSERT INTO `global_table` VALUES ('310', 'DATA_SHARING', '', '2016-05-06 16:23:02');
INSERT INTO `global_table` VALUES ('311', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-06 16:25:07');
INSERT INTO `global_table` VALUES ('312', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-06 16:25:10');
INSERT INTO `global_table` VALUES ('313', 'FOLLOW', '用户关注表插入数据', '2016-05-06 16:26:08');
INSERT INTO `global_table` VALUES ('314', 'REPLIES', '帖子回复表', '2016-05-06 16:26:24');
INSERT INTO `global_table` VALUES ('315', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-06 16:33:21');
INSERT INTO `global_table` VALUES ('316', 'POST', '帖子表插入', '2016-05-07 15:57:35');
INSERT INTO `global_table` VALUES ('317', 'POST', '帖子表插入', '2016-05-07 16:01:47');
INSERT INTO `global_table` VALUES ('318', 'FOLLOW', '用户关注表插入数据', '2016-05-07 16:09:20');
INSERT INTO `global_table` VALUES ('319', 'FOLLOW', '用户关注表插入数据', '2016-05-07 16:10:51');
INSERT INTO `global_table` VALUES ('320', 'DATA_SHARING', '', '2016-05-07 16:29:51');
INSERT INTO `global_table` VALUES ('321', 'POST', '帖子表插入', '2016-05-07 16:50:46');
INSERT INTO `global_table` VALUES ('322', 'POST', '帖子表插入', '2016-05-07 16:52:53');
INSERT INTO `global_table` VALUES ('323', 'POST', '帖子表插入', '2016-05-07 17:17:12');
INSERT INTO `global_table` VALUES ('324', 'POST', '帖子表插入', '2016-05-07 17:20:14');
INSERT INTO `global_table` VALUES ('325', 'REPLIES', '帖子回复表', '2016-05-08 10:34:17');
INSERT INTO `global_table` VALUES ('326', 'REPLIES', '帖子回复表', '2016-05-08 10:51:13');
INSERT INTO `global_table` VALUES ('327', 'REPLIES', '帖子回复表', '2016-05-08 10:52:02');
INSERT INTO `global_table` VALUES ('328', 'POST', '帖子表插入', '2016-05-08 11:17:51');
INSERT INTO `global_table` VALUES ('329', 'FOLLOW', '用户关注表插入数据', '2016-05-08 11:29:47');
INSERT INTO `global_table` VALUES ('330', 'REPLIES', '帖子回复表', '2016-05-08 11:29:59');
INSERT INTO `global_table` VALUES ('331', 'DATA_SHARING', '', '2016-05-08 11:31:07');
INSERT INTO `global_table` VALUES ('332', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-08 12:37:07');
INSERT INTO `global_table` VALUES ('333', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-08 12:37:58');
INSERT INTO `global_table` VALUES ('334', 'SYS_USER', '系统用户表', '2016-05-09 22:06:25');
INSERT INTO `global_table` VALUES ('335', 'DATA_SHARING', '', '2016-05-10 14:17:27');
INSERT INTO `global_table` VALUES ('336', 'DATA_SHARING', '', '2016-05-10 14:18:40');
INSERT INTO `global_table` VALUES ('337', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:37:31');
INSERT INTO `global_table` VALUES ('338', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:37:33');
INSERT INTO `global_table` VALUES ('339', 'SYS_USER', '系统用户表', '2016-05-10 14:37:36');
INSERT INTO `global_table` VALUES ('340', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:37:55');
INSERT INTO `global_table` VALUES ('341', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:37:57');
INSERT INTO `global_table` VALUES ('342', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:38:08');
INSERT INTO `global_table` VALUES ('343', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:38:10');
INSERT INTO `global_table` VALUES ('344', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:40:44');
INSERT INTO `global_table` VALUES ('345', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:40:45');
INSERT INTO `global_table` VALUES ('346', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:41:03');
INSERT INTO `global_table` VALUES ('347', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:41:05');
INSERT INTO `global_table` VALUES ('348', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:41:15');
INSERT INTO `global_table` VALUES ('349', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:41:16');
INSERT INTO `global_table` VALUES ('350', 'FOLLOW', '用户关注表插入数据', '2016-05-10 14:41:25');
INSERT INTO `global_table` VALUES ('351', 'REPLIES', '帖子回复表', '2016-05-10 14:42:28');
INSERT INTO `global_table` VALUES ('352', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:44:29');
INSERT INTO `global_table` VALUES ('353', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 14:44:30');
INSERT INTO `global_table` VALUES ('354', 'REPLIES', '帖子回复表', '2016-05-10 14:46:54');
INSERT INTO `global_table` VALUES ('355', 'REPLIES', '帖子回复表', '2016-05-10 14:47:57');
INSERT INTO `global_table` VALUES ('356', 'REPLIES', '帖子回复表', '2016-05-10 14:49:09');
INSERT INTO `global_table` VALUES ('357', 'POST', '帖子表插入', '2016-05-10 14:53:52');
INSERT INTO `global_table` VALUES ('358', 'REPLIES', '帖子回复表', '2016-05-10 14:54:01');
INSERT INTO `global_table` VALUES ('359', 'FOLLOW', '用户关注表插入数据', '2016-05-10 14:54:07');
INSERT INTO `global_table` VALUES ('360', 'REPLIES', '帖子回复表', '2016-05-10 14:54:29');
INSERT INTO `global_table` VALUES ('361', 'FRIEND', '好友表插入数据', '2016-05-10 14:54:59');
INSERT INTO `global_table` VALUES ('362', 'FRIEND', '好友表插入数据', '2016-05-10 14:55:06');
INSERT INTO `global_table` VALUES ('363', 'OPPOINTMENT', '用户约定表插入', '2016-05-10 14:55:41');
INSERT INTO `global_table` VALUES ('364', 'OPPOINTMENT', '用户约定表插入', '2016-05-10 14:55:43');
INSERT INTO `global_table` VALUES ('365', 'OPPOINTMENT', '用户约定表插入', '2016-05-10 14:55:43');
INSERT INTO `global_table` VALUES ('366', 'OPPOINTMENT', '用户约定表插入', '2016-05-10 14:55:44');
INSERT INTO `global_table` VALUES ('367', 'LEARN_PLAN', '学习计划表插入', '2016-05-10 14:57:54');
INSERT INTO `global_table` VALUES ('368', 'SYS_USER', '系统用户表', '2016-05-10 15:02:41');
INSERT INTO `global_table` VALUES ('369', 'REPLIES', '帖子回复表', '2016-05-10 15:03:05');
INSERT INTO `global_table` VALUES ('370', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:03:30');
INSERT INTO `global_table` VALUES ('371', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:03:31');
INSERT INTO `global_table` VALUES ('372', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:03:37');
INSERT INTO `global_table` VALUES ('373', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:03:39');
INSERT INTO `global_table` VALUES ('374', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:03:48');
INSERT INTO `global_table` VALUES ('375', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:03:50');
INSERT INTO `global_table` VALUES ('376', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:03:55');
INSERT INTO `global_table` VALUES ('377', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:03:56');
INSERT INTO `global_table` VALUES ('378', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:04:04');
INSERT INTO `global_table` VALUES ('379', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-10 15:04:05');
INSERT INTO `global_table` VALUES ('380', 'POST', '帖子表插入', '2016-05-10 15:08:25');
INSERT INTO `global_table` VALUES ('381', 'SYS_USER', '系统用户表', '2016-05-10 15:11:30');
INSERT INTO `global_table` VALUES ('382', 'FOLLOW', '用户关注表插入数据', '2016-05-10 15:15:27');
INSERT INTO `global_table` VALUES ('383', 'SYS_USER', '系统用户表', '2016-05-10 15:16:27');
INSERT INTO `global_table` VALUES ('384', 'SYS_USER', '系统用户表', '2016-05-10 15:19:55');
INSERT INTO `global_table` VALUES ('385', 'SYS_USER', '系统用户表', '2016-05-10 15:20:15');
INSERT INTO `global_table` VALUES ('386', 'POST', '帖子表插入', '2016-05-10 15:23:03');
INSERT INTO `global_table` VALUES ('387', 'POST', '帖子表插入', '2016-05-10 15:24:06');
INSERT INTO `global_table` VALUES ('388', 'SYS_USER', '系统用户表', '2016-05-10 15:26:50');
INSERT INTO `global_table` VALUES ('389', 'SYS_USER', '系统用户表', '2016-05-10 15:28:49');
INSERT INTO `global_table` VALUES ('390', 'SYS_USER', '系统用户表', '2016-05-10 15:34:31');
INSERT INTO `global_table` VALUES ('391', 'SYS_USER', '系统用户表', '2016-05-10 15:38:06');
INSERT INTO `global_table` VALUES ('392', 'DATA_SHARING', '', '2016-05-10 15:56:59');
INSERT INTO `global_table` VALUES ('393', 'DATA_SHARING', '', '2016-05-10 17:22:05');
INSERT INTO `global_table` VALUES ('394', 'DATA_SHARING', '', '2016-05-10 17:24:02');
INSERT INTO `global_table` VALUES ('395', 'DATA_SHARING', '', '2016-05-10 17:28:13');
INSERT INTO `global_table` VALUES ('396', 'DATA_SHARING', '', '2016-05-10 17:31:14');
INSERT INTO `global_table` VALUES ('397', 'KEY_LOG', '关键日志记录表插入', '2016-05-13 20:11:37');
INSERT INTO `global_table` VALUES ('398', 'KEY_LOG', '关键日志记录表插入', '2016-05-13 20:17:55');
INSERT INTO `global_table` VALUES ('399', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-13 20:18:59');
INSERT INTO `global_table` VALUES ('400', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-13 20:19:01');
INSERT INTO `global_table` VALUES ('401', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:01');
INSERT INTO `global_table` VALUES ('402', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:03');
INSERT INTO `global_table` VALUES ('403', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:11');
INSERT INTO `global_table` VALUES ('404', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:13');
INSERT INTO `global_table` VALUES ('405', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:22');
INSERT INTO `global_table` VALUES ('406', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:27');
INSERT INTO `global_table` VALUES ('407', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:35');
INSERT INTO `global_table` VALUES ('408', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:37');
INSERT INTO `global_table` VALUES ('409', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:44');
INSERT INTO `global_table` VALUES ('410', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:12:46');
INSERT INTO `global_table` VALUES ('414', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:13:50');
INSERT INTO `global_table` VALUES ('415', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-14 15:13:52');
INSERT INTO `global_table` VALUES ('416', 'POST', '帖子表插入', '2016-05-14 15:29:55');
INSERT INTO `global_table` VALUES ('417', 'REPLIES', '帖子回复表', '2016-05-14 15:30:43');
INSERT INTO `global_table` VALUES ('418', 'FRIEND', '好友表插入数据', '2016-05-15 10:59:43');
INSERT INTO `global_table` VALUES ('419', 'REPLIES', '帖子回复表', '2016-05-15 13:16:38');
INSERT INTO `global_table` VALUES ('420', 'DATA_SHARING', '', '2016-05-16 11:12:10');
INSERT INTO `global_table` VALUES ('421', 'DATA_SHARING', '', '2016-05-16 11:13:36');
INSERT INTO `global_table` VALUES ('422', 'REPLIES', '帖子回复表', '2016-05-16 15:14:43');
INSERT INTO `global_table` VALUES ('423', 'FOLLOW', '用户关注表插入数据', '2016-05-18 20:31:40');
INSERT INTO `global_table` VALUES ('424', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-18 20:51:45');
INSERT INTO `global_table` VALUES ('425', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-18 20:51:47');
INSERT INTO `global_table` VALUES ('426', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-18 20:51:54');
INSERT INTO `global_table` VALUES ('427', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-18 20:51:56');
INSERT INTO `global_table` VALUES ('428', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-18 20:52:03');
INSERT INTO `global_table` VALUES ('429', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-18 20:52:05');
INSERT INTO `global_table` VALUES ('430', 'DATA_SHARING', '', '2016-05-19 22:13:21');
INSERT INTO `global_table` VALUES ('431', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-19 22:16:38');
INSERT INTO `global_table` VALUES ('432', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-19 22:16:40');
INSERT INTO `global_table` VALUES ('433', 'POST', '帖子表插入', '2016-05-19 22:52:27');
INSERT INTO `global_table` VALUES ('434', 'POST', '帖子表插入', '2016-05-19 22:55:52');
INSERT INTO `global_table` VALUES ('435', 'POST', '帖子表插入', '2016-05-19 22:56:26');
INSERT INTO `global_table` VALUES ('436', 'POST', '帖子表插入', '2016-05-19 22:59:57');
INSERT INTO `global_table` VALUES ('437', 'POST', '帖子表插入', '2016-05-19 23:03:16');
INSERT INTO `global_table` VALUES ('438', 'POST', '帖子表插入', '2016-05-19 23:04:31');
INSERT INTO `global_table` VALUES ('439', 'POST', '帖子表插入', '2016-05-19 23:06:55');
INSERT INTO `global_table` VALUES ('440', 'POST', '帖子表插入', '2016-05-19 23:09:49');
INSERT INTO `global_table` VALUES ('441', 'POST', '帖子表插入', '2016-05-19 23:15:58');
INSERT INTO `global_table` VALUES ('442', 'POST', '帖子表插入', '2016-05-19 23:16:53');
INSERT INTO `global_table` VALUES ('443', 'POST', '帖子表插入', '2016-05-20 09:42:04');
INSERT INTO `global_table` VALUES ('444', 'POST', '帖子表插入', '2016-05-20 09:44:42');
INSERT INTO `global_table` VALUES ('445', 'REPLIES', '帖子回复表', '2016-05-20 09:48:56');
INSERT INTO `global_table` VALUES ('446', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-20 09:56:37');
INSERT INTO `global_table` VALUES ('447', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-20 09:56:39');
INSERT INTO `global_table` VALUES ('448', 'LEARN_PLAN', '学习计划表插入', '2016-05-20 09:59:38');
INSERT INTO `global_table` VALUES ('449', 'REPLIES', '帖子回复表', '2016-05-20 10:00:03');
INSERT INTO `global_table` VALUES ('450', 'REPLIES', '帖子回复表', '2016-05-20 10:00:27');
INSERT INTO `global_table` VALUES ('451', 'POST', '帖子表插入', '2016-05-20 14:17:32');
INSERT INTO `global_table` VALUES ('452', 'REPLIES', '帖子回复表', '2016-05-20 14:18:56');
INSERT INTO `global_table` VALUES ('453', 'POST', '帖子表插入', '2016-05-20 14:19:57');
INSERT INTO `global_table` VALUES ('454', 'REPLIES', '帖子回复表', '2016-05-20 14:20:56');
INSERT INTO `global_table` VALUES ('455', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-21 13:51:54');
INSERT INTO `global_table` VALUES ('456', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-21 13:51:56');
INSERT INTO `global_table` VALUES ('457', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-21 13:52:07');
INSERT INTO `global_table` VALUES ('458', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-21 13:52:08');
INSERT INTO `global_table` VALUES ('459', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-21 13:52:18');
INSERT INTO `global_table` VALUES ('460', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-21 13:52:19');
INSERT INTO `global_table` VALUES ('461', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-21 13:52:32');
INSERT INTO `global_table` VALUES ('462', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-21 13:52:34');
INSERT INTO `global_table` VALUES ('463', 'POST', '帖子表插入', '2016-05-21 13:53:22');
INSERT INTO `global_table` VALUES ('464', 'POST', '帖子表插入', '2016-05-21 13:53:34');
INSERT INTO `global_table` VALUES ('465', 'POST', '帖子表插入', '2016-05-21 13:53:59');
INSERT INTO `global_table` VALUES ('466', 'REPLIES', '帖子回复表', '2016-05-21 13:54:39');
INSERT INTO `global_table` VALUES ('467', 'POST', '帖子表插入', '2016-05-21 13:56:20');
INSERT INTO `global_table` VALUES ('468', 'REPLIES', '帖子回复表', '2016-05-21 17:50:03');
INSERT INTO `global_table` VALUES ('469', 'REPLIES', '帖子回复表', '2016-05-21 17:50:18');
INSERT INTO `global_table` VALUES ('470', 'SCHOOL_PROFILE', '', '2016-05-21 18:14:41');
INSERT INTO `global_table` VALUES ('472', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-21 18:18:02');
INSERT INTO `global_table` VALUES ('473', 'REPLIES', '帖子回复表', '2016-05-21 20:19:36');
INSERT INTO `global_table` VALUES ('474', 'POST', '帖子表插入', '2016-05-21 20:20:05');
INSERT INTO `global_table` VALUES ('475', 'POST', '帖子表插入', '2016-05-21 20:32:45');
INSERT INTO `global_table` VALUES ('476', 'POST', '帖子表插入', '2016-05-21 20:34:32');
INSERT INTO `global_table` VALUES ('477', 'POST', '帖子表插入', '2016-05-21 20:35:53');
INSERT INTO `global_table` VALUES ('478', 'DATA_SHARING', '', '2016-05-21 20:37:58');
INSERT INTO `global_table` VALUES ('479', 'DATA_SHARING', '', '2016-05-21 20:38:52');
INSERT INTO `global_table` VALUES ('480', 'POST', '帖子表插入', '2016-05-21 20:47:56');
INSERT INTO `global_table` VALUES ('481', 'REPLIES', '帖子回复表', '2016-05-21 20:52:53');
INSERT INTO `global_table` VALUES ('482', 'REPLIES', '帖子回复表', '2016-05-21 20:56:28');
INSERT INTO `global_table` VALUES ('483', 'POST', '帖子表插入', '2016-05-21 21:03:30');
INSERT INTO `global_table` VALUES ('484', 'POST', '帖子表插入', '2016-05-21 21:07:08');
INSERT INTO `global_table` VALUES ('485', 'REPLIES', '帖子回复表', '2016-05-21 21:07:42');
INSERT INTO `global_table` VALUES ('486', 'REPLIES', '帖子回复表', '2016-05-21 21:08:09');
INSERT INTO `global_table` VALUES ('487', 'REPLIES', '帖子回复表', '2016-05-21 21:14:50');
INSERT INTO `global_table` VALUES ('488', 'REPLIES', '帖子回复表', '2016-05-21 21:15:58');
INSERT INTO `global_table` VALUES ('489', 'POST', '帖子表插入', '2016-05-21 21:18:13');
INSERT INTO `global_table` VALUES ('490', 'DATA_SHARING', '', '2016-05-21 21:26:57');
INSERT INTO `global_table` VALUES ('491', 'DATA_SHARING', '', '2016-05-21 21:28:09');
INSERT INTO `global_table` VALUES ('492', 'DATA_SHARING', '', '2016-05-21 21:30:27');
INSERT INTO `global_table` VALUES ('493', 'DATA_SHARING', '', '2016-05-21 21:30:35');
INSERT INTO `global_table` VALUES ('494', 'DATA_SHARING', '', '2016-05-21 21:31:48');
INSERT INTO `global_table` VALUES ('495', 'REPLIES', '帖子回复表', '2016-05-21 21:33:00');
INSERT INTO `global_table` VALUES ('496', 'DATA_SHARING', '', '2016-05-21 21:37:19');
INSERT INTO `global_table` VALUES ('497', 'POST', '帖子表插入', '2016-05-21 21:37:50');
INSERT INTO `global_table` VALUES ('498', 'FOLLOW', '用户关注表插入数据', '2016-05-22 21:50:00');
INSERT INTO `global_table` VALUES ('499', 'REPLIES', '帖子回复表', '2016-05-22 21:50:29');
INSERT INTO `global_table` VALUES ('500', 'POST', '帖子表插入', '2016-05-22 21:52:46');
INSERT INTO `global_table` VALUES ('501', 'FOLLOW', '用户关注表插入数据', '2016-05-22 21:57:07');
INSERT INTO `global_table` VALUES ('502', 'REPLIES', '帖子回复表', '2016-05-22 22:04:53');
INSERT INTO `global_table` VALUES ('503', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-22 22:05:37');
INSERT INTO `global_table` VALUES ('504', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:10:16');
INSERT INTO `global_table` VALUES ('505', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:10:19');
INSERT INTO `global_table` VALUES ('506', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:10:27');
INSERT INTO `global_table` VALUES ('507', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:10:28');
INSERT INTO `global_table` VALUES ('508', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:10:35');
INSERT INTO `global_table` VALUES ('509', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:10:36');
INSERT INTO `global_table` VALUES ('510', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:10:44');
INSERT INTO `global_table` VALUES ('511', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:10:45');
INSERT INTO `global_table` VALUES ('512', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:11:05');
INSERT INTO `global_table` VALUES ('513', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-22 22:11:06');
INSERT INTO `global_table` VALUES ('514', 'REPLIES', '帖子回复表', '2016-05-22 22:13:13');
INSERT INTO `global_table` VALUES ('515', 'REPLIES', '帖子回复表', '2016-05-22 22:13:30');
INSERT INTO `global_table` VALUES ('516', 'OPPOINTMENT', '用户约定表插入', '2016-05-22 22:14:27');
INSERT INTO `global_table` VALUES ('517', 'OPPOINTMENT', '用户约定表插入', '2016-05-22 22:14:30');
INSERT INTO `global_table` VALUES ('518', 'CLASSROOM', '教室表插入！', '2016-05-22 22:15:02');
INSERT INTO `global_table` VALUES ('519', 'CLASSROOM', '教室表插入！', '2016-05-22 22:20:39');
INSERT INTO `global_table` VALUES ('520', 'OPPOINTMENT', '用户约定表插入', '2016-05-22 22:38:29');
INSERT INTO `global_table` VALUES ('521', 'REPLIES', '帖子回复表', '2016-05-22 22:43:57');
INSERT INTO `global_table` VALUES ('522', 'POST', '帖子表插入', '2016-05-22 22:45:24');
INSERT INTO `global_table` VALUES ('523', 'FOLLOW', '用户关注表插入数据', '2016-05-22 22:45:44');
INSERT INTO `global_table` VALUES ('524', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-23 11:03:03');
INSERT INTO `global_table` VALUES ('525', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:49:26');
INSERT INTO `global_table` VALUES ('526', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:49:29');
INSERT INTO `global_table` VALUES ('527', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:49:39');
INSERT INTO `global_table` VALUES ('528', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:49:40');
INSERT INTO `global_table` VALUES ('529', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:49:46');
INSERT INTO `global_table` VALUES ('530', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:49:48');
INSERT INTO `global_table` VALUES ('531', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:49:54');
INSERT INTO `global_table` VALUES ('532', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:49:56');
INSERT INTO `global_table` VALUES ('533', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:50:01');
INSERT INTO `global_table` VALUES ('534', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:50:02');
INSERT INTO `global_table` VALUES ('535', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:50:07');
INSERT INTO `global_table` VALUES ('536', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-25 13:50:08');
INSERT INTO `global_table` VALUES ('537', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-26 21:29:42');
INSERT INTO `global_table` VALUES ('538', 'OPPOINTMENT', '用户约定表插入', '2016-05-27 22:13:13');
INSERT INTO `global_table` VALUES ('539', 'LEARN_PLAN', '学习计划表插入', '2016-05-27 22:14:21');
INSERT INTO `global_table` VALUES ('540', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-27 22:14:36');
INSERT INTO `global_table` VALUES ('541', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-27 22:14:38');
INSERT INTO `global_table` VALUES ('542', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-27 22:14:43');
INSERT INTO `global_table` VALUES ('543', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-27 22:14:44');
INSERT INTO `global_table` VALUES ('544', 'CLASSROOM', '教室表插入！', '2016-05-27 22:15:37');
INSERT INTO `global_table` VALUES ('545', 'CLASSROOM', '教室表插入！', '2016-05-27 22:15:51');
INSERT INTO `global_table` VALUES ('546', 'OPPOINTMENT', '用户约定表插入', '2016-05-27 22:16:00');
INSERT INTO `global_table` VALUES ('547', 'POST', '帖子表插入', '2016-05-27 22:18:09');
INSERT INTO `global_table` VALUES ('548', 'REPLIES', '帖子回复表', '2016-05-27 22:18:36');
INSERT INTO `global_table` VALUES ('549', 'FOLLOW', '用户关注表插入数据', '2016-05-27 22:18:41');
INSERT INTO `global_table` VALUES ('550', 'REPLIES', '帖子回复表', '2016-05-27 22:18:53');
INSERT INTO `global_table` VALUES ('551', 'KEY_LOG', '关键日志记录表插入', '2016-05-27 22:19:53');
INSERT INTO `global_table` VALUES ('552', 'REPLIES', '帖子回复表', '2016-05-27 22:23:32');
INSERT INTO `global_table` VALUES ('553', 'LEARN_PLAN', '学习计划表插入', '2016-05-27 22:32:16');
INSERT INTO `global_table` VALUES ('554', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:13:27');
INSERT INTO `global_table` VALUES ('555', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:13:30');
INSERT INTO `global_table` VALUES ('556', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:13:39');
INSERT INTO `global_table` VALUES ('557', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:13:40');
INSERT INTO `global_table` VALUES ('558', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:13:47');
INSERT INTO `global_table` VALUES ('559', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:13:49');
INSERT INTO `global_table` VALUES ('560', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:13:59');
INSERT INTO `global_table` VALUES ('561', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:14:02');
INSERT INTO `global_table` VALUES ('562', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:14:18');
INSERT INTO `global_table` VALUES ('563', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:14:19');
INSERT INTO `global_table` VALUES ('564', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:14:32');
INSERT INTO `global_table` VALUES ('565', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:14:33');
INSERT INTO `global_table` VALUES ('566', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:14:39');
INSERT INTO `global_table` VALUES ('567', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:14:40');
INSERT INTO `global_table` VALUES ('568', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:14:52');
INSERT INTO `global_table` VALUES ('569', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 14:14:54');
INSERT INTO `global_table` VALUES ('570', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 15:20:54');
INSERT INTO `global_table` VALUES ('571', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 15:20:56');
INSERT INTO `global_table` VALUES ('572', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 15:21:07');
INSERT INTO `global_table` VALUES ('573', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-05-29 15:21:08');
INSERT INTO `global_table` VALUES ('574', 'OPPOINTMENT', '用户约定表插入', '2016-05-29 16:04:24');
INSERT INTO `global_table` VALUES ('575', 'OPPOINTMENT', '用户约定表插入', '2016-05-29 16:04:57');
INSERT INTO `global_table` VALUES ('576', 'DATA_SHARING', '', '2016-05-29 16:33:29');
INSERT INTO `global_table` VALUES ('577', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-30 20:28:06');
INSERT INTO `global_table` VALUES ('578', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-30 21:21:11');
INSERT INTO `global_table` VALUES ('579', 'POST', '帖子表插入', '2016-05-30 21:21:53');
INSERT INTO `global_table` VALUES ('580', 'REPLIES', '帖子回复表', '2016-05-30 21:22:31');
INSERT INTO `global_table` VALUES ('581', 'SYS_USER', '系统用户表', '2016-05-30 21:24:09');
INSERT INTO `global_table` VALUES ('582', 'DATA_SHARING', '', '2016-05-30 21:26:09');
INSERT INTO `global_table` VALUES ('583', 'INFORMATION_PUSH', '信息推送表插入数据', '2016-05-30 21:32:30');
INSERT INTO `global_table` VALUES ('584', 'REPLIES', '帖子回复表', '2016-05-30 21:33:13');
INSERT INTO `global_table` VALUES ('585', 'SCHOOL_INFORMATION', '', '2016-05-30 21:43:58');
INSERT INTO `global_table` VALUES ('586', 'DATA_SHARING', '', '2016-05-30 21:51:57');
INSERT INTO `global_table` VALUES ('587', 'LEARN_PLAN', '学习计划表插入', '2016-06-01 10:21:27');
INSERT INTO `global_table` VALUES ('588', 'INTELLIGENT_MESSAGE', '智能消息表插入数据', '2016-06-01 10:26:43');
INSERT INTO `global_table` VALUES ('589', 'INTELLIGENT_MESSAGE', '智能消息表插入数据', '2016-06-01 10:32:58');
INSERT INTO `global_table` VALUES ('590', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:00:37');
INSERT INTO `global_table` VALUES ('591', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:00:40');
INSERT INTO `global_table` VALUES ('592', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:00:53');
INSERT INTO `global_table` VALUES ('593', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:00:55');
INSERT INTO `global_table` VALUES ('594', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:22:44');
INSERT INTO `global_table` VALUES ('595', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:22:45');
INSERT INTO `global_table` VALUES ('596', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:22:52');
INSERT INTO `global_table` VALUES ('597', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:22:53');
INSERT INTO `global_table` VALUES ('598', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:23:01');
INSERT INTO `global_table` VALUES ('599', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:23:02');
INSERT INTO `global_table` VALUES ('600', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:23:10');
INSERT INTO `global_table` VALUES ('601', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:23:11');
INSERT INTO `global_table` VALUES ('602', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:23:18');
INSERT INTO `global_table` VALUES ('603', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:23:19');
INSERT INTO `global_table` VALUES ('604', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:23:28');
INSERT INTO `global_table` VALUES ('605', 'INTELLIGENT_MESSAGE', '只能消息表插入数据', '2016-06-02 10:23:30');
INSERT INTO `global_table` VALUES ('606', 'DATA_SHARING', '', '2016-06-02 10:26:11');
INSERT INTO `global_table` VALUES ('607', 'POST', '帖子表插入', '2016-06-02 10:27:05');
INSERT INTO `global_table` VALUES ('608', 'REPLIES', '帖子回复表', '2016-06-02 10:27:20');
INSERT INTO `global_table` VALUES ('609', 'REPLIES', '帖子回复表', '2016-06-02 10:27:35');

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
  `INFORMATION_PUSH_URL` varchar(1000) DEFAULT NULL COMMENT '信息推送URL',
  `INFORMATION_PUSH_STATE` int(11) NOT NULL COMMENT '信息推送状态',
  `INFORMATION_PUSH_CREATE_TIME` datetime NOT NULL COMMENT '信息推送创建时间',
  `INFORMATION_PUSH_UPDATE_TIME` datetime DEFAULT NULL COMMENT '信息推送更新时间',
  PRIMARY KEY (`INFORMATION_PUSH_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息推送';

-- ----------------------------
-- Records of information_push
-- ----------------------------
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604170129', '继续测试', 'fdfasdfk ajdkf asdf jldakj adsf<img style=\"width:100px;height:100px;\"></img> das fasf asdf asd fasd ad fasd fsad fasf sad fads fads fda ', 'Admin', 'www.baidu.com', '2', '2016-04-17 18:33:04', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604200137', '考研心态调整', '1.保持一种积极乐观的心态\n　　一个好的投手在接受记者采访时说，我每次投球的时候不关心球进不进，而是欣赏球离开手抛向篮板的优美弧线。关注过程而非结果，这可能是他百投百中的一大诀窍。考研过程也是非常锻炼人的一个过程，不管结果怎样，过程本身就非常有价值，瓜熟蒂落、水到渠成是大家都知道的道理，只要付出努力，总是会有所收获，对结果的担忧不仅没用也非常没有必要，所以保持一种乐观的心态，把关注的焦点回归到复习的技巧和效率上来，才是明智之举。\n　　2.利用语言暗示的作用\n　　当你被不良情结所压抑的时候，可以通过言语暗示来调整和放松心理上的紧张，使不良情绪得到缓解。语言是一个人情绪体验强有力的表现工具。通过语言可以引起或抑制情绪反应，即使不出声的内心语言，也能起到调节作用。在你发怒时，可以暗示自己“不要发怒”，“发怒会把事情办坏的”;陷入忧愁时，提醒自己“忧愁没有用，于事无益，还是面对现实，想想办法吧”，等等。在松弛平静、排除杂念、专心致志的情况下，进行这种自我暗示，对情绪的好转大有益处。\n　　3.了解生物节律，尊重情绪规律\n　　人是有生物钟和生物节律的，比如有的人是早起型，有人是晚睡型，有人早晨效率高，有人下午头脑好，其实情绪也一样有它的节律。\n　　美国加州大学心理学教授罗伯特•塞伊曾经做过一个实验，在一段时间里对125名实验者的情绪和体温变化进行了观察。他发现，当人们的体温在正常范围内处于上升期时，他们的心情要更愉快些，而此时他们的精力也最充沛。根据塞伊教授的结论，人的情绪变化是有周期的。塞伊本人就严格遵循着这一“生物节奏”的规律，他往往很早就开始写作，“我写作的最佳时间是早上”，而在下午，他一般都用来会客和处理杂事，“因为那时我的精力往往不够集中，更适合与人交谈”。\n　　所以我们要熟悉自己的生物节律和情绪周期，合理安排考研事件，这样便能得到更有效率的成果，从而避免消极情绪的不良影响。\n　　4.保证充足的睡眠\n　　睡眠不足可能不是某几个考研人的问题，前天一位考研的学生告诉我，现在他们都四点半起床，都紧张得很!大家为了考研，都在拼命挤压本来就有限的睡眠时间，可是时间与成绩是成正比的吗?付出时间越多效率就越高吗?恐怕不尽然。匹兹堡大学医学中心的罗拉德•达尔教授的一项研究发现，睡眠不足对我们的情绪影响极大，他说：“对睡眠不足者而言，那些令人烦心的事更能左右他们的情绪”。\n　　当你每天睡眠不足，强打精神把自己控制在书桌前，烦躁、抑郁、焦虑、担忧等不良情绪也会轻易找上你，不仅使你复习效率全无，而且还有影响考研的自信心。其实对于准备时间晚的同学，只要合理安排时间，有效完成计划，成果总是会有的。当然，多少睡眠量能满足自己的需求因人而宜，但最起码要保证充足的高质量的睡眠，这也是保持良好情绪，取得好成绩的重要保证。\n　　5.养成良好的运动习惯\n　　运动是一个极有效的驱除不良心情的自助手段。研究人员发现，健身运动能使你的身体产生一系列的生理变化，其功效与那些能提神醒脑的药物类似。但比药物更胜一筹的是，健身运动对你是有百利而无一害。不过，要做到效果明显，你最好是从事有氧运动——跑步、体操、骑车、游泳和其他有一定强度的运动，运动之后再洗个热水澡则效果更佳。如果在紧张的复习中这些活动很难进行，哪怕你只是散步十分钟，或围着操场跑两圈，对克服坏心情都能收到立竿见影之效。\n　　6.保证合理饮食\n　　你是否为了多挤出时间复习，吃饭总是凑合凑合，匆匆了事?其实这样不仅难以提高效率，反而会给我们带来坏心情。大脑活动的所有能量都能来自于我们所吃的食物，因此情绪波动也常常与我们吃的东西有关。《食物与情绪》一书的作者索姆认为，对于那些每天早晨只喝一杯咖啡的人来说，心情不佳是一点也不足为怪的。索姆建议，要确保你心情愉快，你应养成一些好的饮食习惯：定时就餐(早餐尤其不能省)，限制咖啡和糖的摄入(它们都可能使你过于激动)，每天至少喝六至八杯水(脱水易使人疲劳)。\n　　营养是保持充沛精力、贮藏能量的重要手段，也是预防紧张的主要措施。所以考研人更要注意营养的均衡，养成良好的饮食习惯，这对于抵抗紧张情绪反应和提高智力水平都是非常必要的。\n　　聪明的人能够做到劳逸结合，提高效率;了解自己的生物节律和情绪周期，能把自己的潜能充分发挥出来;保证充足的睡眠和合理的饮食，为考研成功做好充分的准备。学会合理调控情绪，成为情绪的主人，这不仅仅是对考研，同时对以后的人生路也是大有裨益的。', 'Admin', 'www.baidu.com', '1', '2016-04-20 20:45:47', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604200138', '考研一般要准备多长时间', '一般是那一年的2-3份开始正式准了，有些人想考好一点的，还有名校的好专业，专业科上压力要大一些，专业科要早点准备，可以比一般可以早上4-5个月，英语与政治不要过早准备了，要考数一与数二的话，可能数学要占多一点时间，所以时间又可以拖长一点了。\n但考研切记，不要以为准备的时间越长越好，太长，心会疲，考研不是英语四六级，不是机械的练习就可以，有很多方法与技巧。', 'Admin', 'www.baidu.com', '2', '2016-04-20 20:51:16', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201604200139', '考研准备过程', '您好，这要看个人情况和要报考的学校了基础差或者报考学校比较知名，准备时间就要长一些.按照下面的时间安排再根据自己的跟人情况稍作修改。一般是20111月 搜集考研信息，听免费讲座。2月-3月 确定考研目标，听考研形势的讲座。考研应如何选择专业，全面了解所报专业的信息。准备复习。4月-5月 第一轮复习，可以报一个基础班，特别是数学班和英语班。不要急于做模拟试题，着重于基础的复习。6月 全面关注考研公共课的考试大纲，购买最新的辅导用书，准备暑期复习。7月-8月 制定一个全面复习计划，开始第二轮复习。可以参加一个有权威性的辅导班，有选择地做一些必要的题目。9月 关注各招生单位的招生简章和专业计划，购买专业课辅导用书，联系导师，获取专业课考试信息。10月 确定十一黄金周复习计划，对前两个阶段的复习进行总结。同时，开始专业课的复习，可报一个长期班系统复习。11月10-14日 研究生考试报名工作开始，报名、填报专愿。11月中下旬 第三轮复习阶段开始，政治、英语、数学、专业课的冲刺复习，购买辅导冲刺的内部资料。冲刺班报名。12-1月 进行模拟实训，报一个冲刺班，做考前整理。第二年1月中下旬 调整心态、准备考试。熟悉考试环境。2月 放松心情，查询初试成绩。3月 关注复试复试分数线。4月 准备复试，联系招生单位。5月 关注复试成绩。6月 关注录取通知书。9月 到。!。。。欢迎向158教育在线知道提问', 'Admin', 'www.baidu.com', '2', '2016-04-20 20:51:37', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201605060315', '5.6新闻推送', '开房间爱多客服哈客户反馈爱上的咖啡爱的是客户方卡戴珊发咖啡店和卡复活点款付好款按时', 'Admin', 'www.baidu.com', '1', '2016-05-06 16:33:21', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201605080332', '5.8周末书籍推荐', '该表是本人依照历年考研学子用书反馈以及自己的亲身考研经历精心编制，仅供参考。由于部分图书现在还没有出版，所以图片借用2015版本。这些都是比较不错的考研书籍，当然，没有什么书是十全十美的，我也将其优缺点都尽数列出来了，具体的大家去书店或者天猫搜索一下，自己选一本适合自己的。\n　　除非我标注说必须买的，否则，大家都是任选其一即可。考研书籍贵精不贵多。我是不太建议大家去实体书店买考研书的，除非那些书店打折能够打到五六折甚至更多。因为考研书籍你不是买一本两本，那么多的书，很烧钱的。当然，如果你是土豪，那另当别论了。\n　　我认为，天猫和当当都是不错的选择，如果大量购书，亚马逊也可以。如果有研友，几个人团购当然更好了。英语是一个长期积累的过程，不要急于求成，更不可能一蹴而就。\n　　英语\n　　单词词汇\n　　婉儿学姐温馨提示：\n　　英语单词是考研英语资料的基础关，这一关过不了，其他一切都是浮云。作为过来人，我能理解，背单词的确是一件非常枯燥乏味的事情，重在坚持。但是，背单词也是你无论如何必须得跨越的一条鸿沟。\n　　给大家的建议是，大家应该打破每次都从第一页的A开始死记硬背的古老单词记忆法。因为不知你是否发现，无论四六级还是考研英语，我们记忆的最熟悉的往往是A开头的几个单词，但是，我们却永远背不到Z就考试了。而考试的时候发现，很多背过的A开头的单词并没有用到很多，而我们还没来得及或者说没有坚持到背后面的，就考试了。\n　　于是导致考试时候单词还是我们的致命伤。再有就是，背单词是一件很浪费时间的事情，所以学姐建议，如果有MP3的就把MP3拷贝下来，每天洗漱、吃饭、走路或者躺在床上睡不着的时候，这些零散时间好好利用起来听一听。不一定非要求听了就记住，但是至少耳熟能详。\n　　千万不要专门拿出大量时间来专门背单词，那是得不偿失的。最后，只有一种情况你可以用来专门背单词，那就是结合真题。把历年真题的阅读都拿过来，作为精读文章。逐字逐句的翻译，翻译不过来的记下来，看看是单词问题，还是语法问题。\n　　语法问题就去解决语法，单词问题就把不认识的单词在你的单词书中找出来，画下来，专门找一个本记下来。这样的单词你要反复多次记忆几遍。几套真题下来，你几乎就有了一个专属于自己的高频词汇，困难词汇的小册子。而这才是为你量身定做的单词本。\n　　别人总结的高频词汇书，你拿来背，和你背普通的单词书并没有区别，因为那是老师们根据考生的大多数总结出来的，适合于大多数考生，却未必适合你。下面是我为大家精选的几本比较不错的单词书，大家任选其一即可。单词书买多了没有用，除了增加你的痛苦之外。', 'Admin', 'www.baidu.com', '3', '2016-05-08 12:37:07', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201605080333', '英语推荐', '1、考研英语词汇红宝书 西北大学出版社\n　　\n　　优点：权威经典，收词全面，有精缩版易携带，有配套练习可检测记忆效果，有MP3可以边走路边记忆\n　　缺点：按字母排序易感枯燥，容易产生词汇过多的烦躁感', 'Admin', 'http://mt.sohu.com/20150526/n413763691.shtml', '1', '2016-05-08 12:37:58', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201605220503', '5.25拍毕业照', '放大发送阿斯蒂芬阿斯蒂芬阿斯蒂芬啊撒撒', 'Admin', 'www.xhu.edu.cn', '3', '2016-05-22 22:05:37', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201605260537', '哈哈，发布新版本啦', '放发顺丰阿斯蒂芬阿斯蒂芬阿萨德发射点发爱的色放广东省分公司答复公司东方感到十分公司的风格速读法双方各', 'Admin', 'www.xhu.edu.cn', '3', '2016-05-26 21:29:41', null);
INSERT INTO `information_push` VALUES ('INFORMATIONPUSH201605300577', 'finally Test', '放发顺丰阿斯蒂芬阿斯蒂芬阿萨德发射点发爱的色放广东省分公司答复公司东方感到十分公司的风格速读法双方各', 'Admin', 'www.xhu.edu.cn', '3', '2016-05-30 20:28:06', null);

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
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604210152', 'SYSUSER2016031305', null, null, '小子', '1', '4', '2016-04-21 21:29:37', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604210153', 'SYSUSER2016031305', null, '图灵机器人', '没大没小的，叫哥哥我还嫌你小呢', '2', '4', '2016-04-21 21:29:38', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230158', 'SYSUSER2016031305', null, null, '是不是啊', '1', '4', '2016-04-23 16:14:54', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230159', 'SYSUSER2016031305', null, '图灵机器人', '是的，这个对我真的很重要。 谢谢！', '2', '4', '2016-04-23 16:14:57', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230160', 'SYSUSER2016031305', null, null, '小激情', '1', '4', '2016-04-23 16:15:11', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230161', 'SYSUSER2016031305', null, '图灵机器人', '激情照在很前面', '2', '4', '2016-04-23 16:15:12', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230162', 'SYSUSER2016031305', null, null, '真的么', '1', '4', '2016-04-23 16:15:18', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230163', 'SYSUSER2016031305', null, '图灵机器人', '比真金还真', '2', '4', '2016-04-23 16:15:20', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230164', 'SYSUSER2016031305', null, null, '今晚上吃什么', '1', '4', '2016-04-23 16:15:28', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230165', 'SYSUSER2016031305', null, '图灵机器人', '我觉得晚上少吃一些为妙，吃些容易消化的', '2', '4', '2016-04-23 16:15:29', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230166', 'SYSUSER2016031305', null, null, '你晚上吃什么呢？', '1', '4', '2016-04-23 16:15:46', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201604230167', 'SYSUSER2016031305', null, '图灵机器人', '晚上饿了没控制住吃了点零食', '2', '4', '2016-04-23 16:15:48', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605020172', 'SYSUSER2016031305', null, null, '给我来碗饭', '1', '4', '2016-05-02 12:58:14', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605020173', 'SYSUSER2016031305', null, '图灵机器人', '来吧做饭给你吃', '2', '4', '2016-05-02 12:58:16', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605020174', 'SYSUSER2016031305', null, null, '你做什么饭啊', '1', '4', '2016-05-02 12:58:25', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605020175', 'SYSUSER2016031305', null, '图灵机器人', '亲，已帮您找到菜谱信息菜名:热门法式甜品介绍<br>菜谱信息:这是一个、读书笔记<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/101696193/\'>点击查看更多哦</a><br>菜名:热门咖啡馆饮品介绍与做法<br>菜谱信息:这是一个、读书笔记<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/101696202/\'>点击查看更多哦</a><br>菜名:广东最热门小点--老婆饼<br>菜谱信息:#糯米馅、糯米粉、水、猪油、水、猪油、#油酥、猪油 | 细砂糖、炒熟的白芝麻、#水油皮、中筋面粉、细砂糖、全蛋液、中筋面粉<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100468446/\'>点击查看更多哦</a><br>菜名:白巧轻乳酪蛋糕，youtube热门，不算成功版本<br>菜谱信息:白巧克力、奶油奶酪、大鸡蛋<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100632450/\'>点击查看更多哦</a><br>菜名:一人食牛油果溏心蛋拌饭<br>菜谱信息:鸡蛋、牛油果 | 米饭、海苔、芥末、日本酱油<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100421960/\'>点击查看更多哦</a><br>菜名:老妈煎土豆片<br>菜谱信息:土豆 | 盐、鸡精<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100302512/\'>点击查看更多哦</a><br>菜名:草莓多水果蛋糕<br>菜谱信息:烤一个6寸戚风蛋糕、草莓 | 芒果、火龙果、猕猴桃、白巧克力<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100447430/\'>点击查看更多哦</a><br>菜名:棉花感咖哩蛋包饭（非原创）<br>菜谱信息:a、白米熟饭、红萝卜丁、花椰菜丁、玉米粒、熟大排肉丁、猪油、b、大蒜胡椒粗粒、盐、砂糖、辣椒粉、姜黄粉、c、鸡蛋、砂糖、番茄酱<br>详细连接:<a href=\'http://m.xiachufang.com/recipe/100539258/\'>点击查看更多哦</a><br>', '2', '4', '2016-05-02 12:58:27', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605030217', 'SYSUSER2016031305', null, null, 'nijiusdouvi', '1', '4', '2016-05-03 14:51:51', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605030218', 'SYSUSER2016031305', null, '图灵机器人', '我不会说英语的啦，你还是说中文吧。', '2', '4', '2016-05-03 14:51:53', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605030219', 'SYSUSER2016031305', null, null, 'are you OK', '1', '4', '2016-05-03 14:52:04', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605030220', 'SYSUSER2016031305', null, '图灵机器人', '我不会说英语的啦，你还是说中文吧。', '2', '4', '2016-05-03 14:52:07', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040224', 'SYSUSER2016031305', null, null, '继续聊天哦', '1', '4', '2016-05-04 15:07:33', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040225', 'SYSUSER2016031305', null, '图灵机器人', '说好的继续呢', '2', '4', '2016-05-04 15:07:36', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040226', 'SYSUSER2016031305', null, null, '你是谁啊', '1', '4', '2016-05-04 15:07:41', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040227', 'SYSUSER2016031305', null, '图灵机器人', '我可是人见人爱的考研书童呢，你竟然不认识我', '2', '4', '2016-05-04 15:07:42', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040228', 'SYSUSER2016031305', null, null, '真的吗', '1', '4', '2016-05-04 15:07:46', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040229', 'SYSUSER2016031305', null, '图灵机器人', '我所说的每句话都可作为呈堂证供', '2', '4', '2016-05-04 15:07:48', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040230', 'SYSUSER2016031305', null, null, '好吧', '1', '4', '2016-05-04 15:07:52', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040231', 'SYSUSER2016031305', null, '图灵机器人', '嗯，你答应了我就开心了', '2', '4', '2016-05-04 15:07:53', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040232', 'SYSUSER2016031305', null, null, ' 逗逼', '1', '4', '2016-05-04 15:07:59', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605040233', 'SYSUSER2016031305', null, '图灵机器人', '你是猴子请来的傻瓜，这个我知道。', '2', '4', '2016-05-04 15:08:00', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050262', 'SYSUSER2016031305', null, null, '好的好的好', '1', '4', '2016-05-05 10:26:35', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050263', 'SYSUSER2016031305', null, '图灵机器人', '你帮我找一个好的中医呗~~~', '2', '4', '2016-05-05 10:26:37', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050264', 'SYSUSER2016031305', null, null, '你是逗比嘛', '1', '4', '2016-05-05 10:26:44', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050265', 'SYSUSER2016031305', null, '图灵机器人', '逗。逗。非常逗。', '2', '4', '2016-05-05 10:26:45', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050266', 'SYSUSER2016031305', null, null, '小逗比', '1', '4', '2016-05-05 10:26:54', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050267', 'SYSUSER2016031305', null, '图灵机器人', '肯定是孙猴子请来的,哈哈', '2', '4', '2016-05-05 10:26:55', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050286', 'SYSUSER201605050272', null, null, 'suib', '1', '4', '2016-05-05 12:38:37', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050287', 'SYSUSER201605050272', null, '图灵机器人', '我不会说英语的啦，你还是说中文吧。', '2', '4', '2016-05-05 12:38:39', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050288', 'SYSUSER201605050272', null, null, '你是谁', '1', '4', '2016-05-05 12:38:47', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050289', 'SYSUSER201605050272', null, '图灵机器人', '我是棒棒哒考研书童', '2', '4', '2016-05-05 12:38:48', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050290', 'SYSUSER201605050272', null, null, '好嘛 看你像一个SB一样', '1', '4', '2016-05-05 12:39:00', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050291', 'SYSUSER201605050272', null, '图灵机器人', '懂不了乃们成年人的世届戒界', '2', '4', '2016-05-05 12:39:01', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050295', 'SYSUSER2016031305', null, null, 'woca', '1', '4', '2016-05-05 12:58:54', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605050296', 'SYSUSER2016031305', null, '图灵机器人', '我不会说英语的啦，你还是说中文吧。', '2', '4', '2016-05-05 12:58:55', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605060311', 'SYSUSER201605050272', null, null, '哈哈哈', '1', '4', '2016-05-06 16:25:07', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605060312', 'SYSUSER201605050272', null, '图灵机器人', '哈哈', '2', '4', '2016-05-06 16:25:10', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100337', 'SYSUSER2016031305', null, null, '艹', '1', '4', '2016-05-10 14:37:31', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100338', 'SYSUSER2016031305', null, '图灵机器人', '打住，再说我报警啦', '2', '4', '2016-05-10 14:37:33', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100340', 'SYSUSER2016031305', null, null, '狗日的', '1', '4', '2016-05-10 14:37:55', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100341', 'SYSUSER2016031305', null, '图灵机器人', '褪尽风华，我依然在彼岸守护你', '2', '4', '2016-05-10 14:37:57', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100342', 'SYSUSER201605100339', null, null, '好屌哦', '1', '4', '2016-05-10 14:38:08', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100343', 'SYSUSER201605100339', null, '图灵机器人', '必须的', '2', '4', '2016-05-10 14:38:10', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100344', 'SYSUSER2016031305', null, null, '你是有好屌', '1', '4', '2016-05-10 14:40:44', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100345', 'SYSUSER2016031305', null, '图灵机器人', '不好意思，我还真没有！', '2', '4', '2016-05-10 14:40:45', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100346', 'SYSUSER201605100339', null, null, '鸡鸡', '1', '4', '2016-05-10 14:41:03', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100347', 'SYSUSER201605100339', null, '图灵机器人', '唧唧复唧唧，木兰开飞机', '2', '4', '2016-05-10 14:41:05', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100348', 'SYSUSER201605100339', null, null, '狗日的', '1', '4', '2016-05-10 14:41:15', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100349', 'SYSUSER201605100339', null, '图灵机器人', '笑而不语是一种态度', '2', '4', '2016-05-10 14:41:16', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100352', 'SYSUSER201605100339', null, null, '你是谁', '1', '4', '2016-05-10 14:44:29', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100353', 'SYSUSER201605100339', null, '图灵机器人', '我是棒棒哒考研书童', '2', '4', '2016-05-10 14:44:30', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100370', 'SYSUSER201605100368', null, null, 'hallo', '1', '4', '2016-05-10 15:03:30', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100371', 'SYSUSER201605100368', null, '图灵机器人', '我不会说英语的啦，你还是说中文吧。', '2', '4', '2016-05-10 15:03:31', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100372', 'SYSUSER201605100368', null, null, '是不是啊', '1', '4', '2016-05-10 15:03:37', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100373', 'SYSUSER201605100368', null, '图灵机器人', '差不多啦', '2', '4', '2016-05-10 15:03:39', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100374', 'SYSUSER201605100368', null, null, '你是狗日的', '1', '4', '2016-05-10 15:03:48', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100375', 'SYSUSER201605100368', null, '图灵机器人', '消消气了，谁又惹到你了', '2', '4', '2016-05-10 15:03:50', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100376', 'SYSUSER201605100368', null, null, '你惹我了', '1', '4', '2016-05-10 15:03:55', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100377', 'SYSUSER201605100368', null, '图灵机器人', '我哪里惹你了', '2', '4', '2016-05-10 15:03:56', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100378', 'SYSUSER201605100368', null, null, '你长了小鸡鸡', '1', '4', '2016-05-10 15:04:04', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605100379', 'SYSUSER201605100368', null, '图灵机器人', '笑而不语是一种态度', '2', '4', '2016-05-10 15:04:05', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605130399', 'SYSUSER2016031305', null, null, '草', '1', '4', '2016-05-13 20:18:59', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605130400', 'SYSUSER2016031305', null, '图灵机器人', '放心吧，我不会告诉别人，你竟然问了这个问题的', '2', '4', '2016-05-13 20:19:01', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140401', 'SYSUSER2016031305', null, null, '我要点外卖', '1', '4', '2016-05-14 15:12:01', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140402', 'SYSUSER2016031305', null, '图灵机器人', '要点脸好吗', '2', '4', '2016-05-14 15:12:03', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140403', 'SYSUSER2016031305', null, null, '我要吃饭', '1', '4', '2016-05-14 15:12:11', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140404', 'SYSUSER2016031305', null, '图灵机器人', '正好加餐啊我正在吃', '2', '4', '2016-05-14 15:12:13', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140405', 'SYSUSER2016031305', null, null, '吃的什么呢？', '1', '4', '2016-05-14 15:12:22', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140406', 'SYSUSER2016031305', null, '图灵机器人', '吃的大米饭', '2', '4', '2016-05-14 15:12:27', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140407', 'SYSUSER2016031305', null, null, '有多好吃啊', '1', '4', '2016-05-14 15:12:35', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140408', 'SYSUSER2016031305', null, '图灵机器人', '很好吃的', '2', '4', '2016-05-14 15:12:37', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140409', 'SYSUSER2016031305', null, null, '西红柿', '1', '4', '2016-05-14 15:12:44', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140410', 'SYSUSER2016031305', null, '图灵机器人', '番茄，别名西红柿、洋柿子。很多人认为西红柿就番茄，其实他们是不一样的，古名六月柿、喜报三元。在秘鲁和墨西哥，最初称之为“狼桃”。全体生粘质腺毛，有强烈气味。茎易倒伏。叶羽状复叶或羽状深裂，小叶极不规则，大小不等，卵形或矩圆形，边缘有不规则锯齿或裂片。花萼辐状，裂片披针形，果时宿存；花冠辐状，黄色。浆果扁球状或近球状，肉质而多汁液，桔黄色或鲜红色，光滑；种子黄色。花果期夏秋季。番茄是喜温、喜光性蔬菜，对土壤条件要求不太严格，但为获得丰产，促进根系良好发育，应选用土层深厚，排水良好，富含有机质的肥沃壤土。原产南美洲，中国南北广泛栽培。番茄营养丰富，具特殊风味。具有减肥瘦身、消除疲劳、增进食欲、提高对蛋白质的消化、减少胃胀食积等功效。', '2', '4', '2016-05-14 15:12:46', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140414', 'SYSUSER2016031305', null, null, '西红柿', '1', '4', '2016-05-14 15:13:50', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605140415', 'SYSUSER2016031305', null, '图灵机器人', '番茄，别名西红柿、洋柿子。很多人认为西红柿就番茄，其实他们是不一样的，古名六月柿、喜报三元。在秘鲁和墨西哥，最初称之为“狼桃”。全体生粘质腺毛，有强烈气味。茎易倒伏。叶羽状复叶或羽状深裂，小叶极不规则，大小不等，卵形或矩圆形，边缘有不规则锯齿或裂片。花萼辐状，裂片披针形，果时宿存；花冠辐状，黄色。浆果扁球状或近球状，肉质而多汁液，桔黄色或鲜红色，光滑；种子黄色。花果期夏秋季。番茄是喜温、喜光性蔬菜，对土壤条件要求不太严格，但为获得丰产，促进根系良好发育，应选用土层深厚，排水良好，富含有机质的肥沃壤土。原产南美洲，中国南北广泛栽培。番茄营养丰富，具特殊风味。具有减肥瘦身、消除疲劳、增进食欲、提高对蛋白质的消化、减少胃胀食积等功效。', '2', '4', '2016-05-14 15:13:52', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605180424', 'SYSUSER2016031305', null, null, '你好呀', '1', '4', '2016-05-18 20:51:45', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605180425', 'SYSUSER2016031305', null, '图灵机器人', '很高兴和你聊天', '2', '4', '2016-05-18 20:51:47', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605180426', 'SYSUSER2016031305', null, null, '很高兴认识你', '1', '4', '2016-05-18 20:51:54', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605180427', 'SYSUSER2016031305', null, '图灵机器人', '也很高兴认识你', '2', '4', '2016-05-18 20:51:56', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605180428', 'SYSUSER2016031305', null, null, '你是谁呀', '1', '4', '2016-05-18 20:52:03', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605180429', 'SYSUSER2016031305', null, '图灵机器人', '我是你的考研书童', '2', '4', '2016-05-18 20:52:05', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605190431', 'SYSUSER2016031305', null, null, '好纠结', '1', '4', '2016-05-19 22:16:38', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605190432', 'SYSUSER2016031305', null, '图灵机器人', '纠结什么', '2', '4', '2016-05-19 22:16:40', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605200446', 'SYSUSER2016031305', null, null, '聊天', '1', '4', '2016-05-20 09:56:37', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605200447', 'SYSUSER2016031305', null, '图灵机器人', '正有此意最近都有什么开心的事拿出来晒晒', '2', '4', '2016-05-20 09:56:39', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605210455', 'SYSUSER2016031305', null, null, '哈哈', '1', '4', '2016-05-21 13:51:54', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605210456', 'SYSUSER2016031305', null, '图灵机器人', '哈哈', '2', '4', '2016-05-21 13:51:56', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605210457', 'SYSUSER2016031305', null, null, '你是神经病', '1', '4', '2016-05-21 13:52:07', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605210458', 'SYSUSER2016031305', null, '图灵机器人', '你太聪明了，这都被你发现了，不简单！', '2', '4', '2016-05-21 13:52:08', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605210459', 'SYSUSER2016031305', null, null, '肯定不简单啊', '1', '4', '2016-05-21 13:52:18', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605210460', 'SYSUSER2016031305', null, '图灵机器人', '那是肯定的啦', '2', '4', '2016-05-21 13:52:19', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605210461', 'SYSUSER2016031305', null, null, '最新新闻', '1', '4', '2016-05-21 13:52:32', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605210462', 'SYSUSER2016031305', null, '图灵机器人', '亲，已帮您找到相关新闻标题:国台办:坚持\"九二共识\"两岸沟通才能延续<br>来源:网易新闻<br>详细连接:<a href=\'http://news.163.com/16/0521/10/BNJ5HU6700014AEE.html\'>点击查看更多哦</a><br>标题:\"中原首家五星会所\"被查 消费\"很黄很贵\"<br>来源:网易新闻<br>详细连接:<a href=\'http://news.163.com/16/0520/23/BNI0GO670001124J.html\'>点击查看更多哦</a><br>标题:张北\"草原天路\"收费仅持续22天 下周取消<br>来源:网易新闻<br>详细连接:<a href=\'http://news.163.com/16/0521/01/BNI8LJ6D00014AED.html\'>点击查看更多哦</a><br>标题:汪星人行走江湖靠的竟然是…<br>来源:网易新闻<br>详细连接:<a href=\'http://news.163.com/16/0520/11/BNGMJSKM00014TUH.html#163interesting?xstt\'>点击查看更多哦</a><br>标题:请1000只喵出席婚礼证婚？！<br>来源:网易新闻<br>详细连接:<a href=\'http://news.163.com/16/0521/12/BNJDEQ55000155K8.html#163interesting?xstt\'>点击查看更多哦</a><br>标题:一年狂瘦70斤雪洗被劈腿耻辱<br>来源:网易新闻<br>详细连接:<a href=\'http://news.163.com/16/0521/12/BNJCICT0000155K8.html#163interesting?xstt\'>点击查看更多哦</a><br>标题:国产恐怖片，不色情会死么<br>来源:网易新闻<br>详细连接:<a href=\'http://news.163.com/16/0521/11/BNJAQBF1000155K8.html#163interesting?xstt\'>点击查看更多哦</a><br>标题:超近距离观测科罗拉多龙卷风<br>来源:网易新闻<br>详细连接:<a href=\'http://news.163.com/16/0521/11/BNJ8T5C0000155K8.html#163interesting?xstt\'>点击查看更多哦</a><br>标题:用小型火药管爆炸来防盗？！<br>来源:网易新闻<br>详细连接:<a href=\'http://news.163.com/16/0521/11/BNJ8Q0US00014TUH.html#163interesting?xstt\'>点击查看更多哦</a><br>', '2', '4', '2016-05-21 13:52:34', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220504', 'SYSUSER2016031305', null, null, '教我做作业', '1', '4', '2016-05-22 22:10:16', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220505', 'SYSUSER2016031305', null, '图灵机器人', '做作业累啊', '2', '4', '2016-05-22 22:10:19', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220506', 'SYSUSER2016031305', null, null, '真的很累吗？', '1', '4', '2016-05-22 22:10:27', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220507', 'SYSUSER2016031305', null, '图灵机器人', '是很累但是想着是为韬做的总是觉得很幸福', '2', '4', '2016-05-22 22:10:28', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220508', 'SYSUSER2016031305', null, null, '你真笨', '1', '4', '2016-05-22 22:10:35', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220509', 'SYSUSER2016031305', null, '图灵机器人', '我不笨，我只是反应慢', '2', '4', '2016-05-22 22:10:36', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220510', 'SYSUSER2016031305', null, null, '都会', '1', '4', '2016-05-22 22:10:44', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220511', 'SYSUSER2016031305', null, '图灵机器人', '会些什么啊', '2', '4', '2016-05-22 22:10:45', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220512', 'SYSUSER2016031305', null, null, '回家觉得', '1', '4', '2016-05-22 22:11:05', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605220513', 'SYSUSER2016031305', null, '图灵机器人', '就这样吧', '2', '4', '2016-05-22 22:11:06', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250525', 'SYSUSER2016031305', null, null, '你谁呀', '1', '4', '2016-05-25 13:49:26', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250526', 'SYSUSER2016031305', null, '图灵机器人', '我是你的好盆友个叫考研书童的智能机器人', '2', '4', '2016-05-25 13:49:29', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250527', 'SYSUSER2016031305', null, null, '回答这么慢', '1', '4', '2016-05-25 13:49:39', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250528', 'SYSUSER2016031305', null, '图灵机器人', '速度挺慢的说实话', '2', '4', '2016-05-25 13:49:40', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250529', 'SYSUSER2016031305', null, null, '笨得很哦', '1', '4', '2016-05-25 13:49:46', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250530', 'SYSUSER2016031305', null, '图灵机器人', '跟笨有啥子关系', '2', '4', '2016-05-25 13:49:48', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250531', 'SYSUSER2016031305', null, null, '就是笨得很', '1', '4', '2016-05-25 13:49:54', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250532', 'SYSUSER2016031305', null, '图灵机器人', '我也觉得不是点点笨', '2', '4', '2016-05-25 13:49:56', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250533', 'SYSUSER2016031305', null, null, '哈哈哈', '1', '4', '2016-05-25 13:50:01', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250534', 'SYSUSER2016031305', null, '图灵机器人', '哈哈', '2', '4', '2016-05-25 13:50:02', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250535', 'SYSUSER2016031305', null, null, 'SB', '1', '4', '2016-05-25 13:50:07', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605250536', 'SYSUSER2016031305', null, '图灵机器人', '不听人家不听', '2', '4', '2016-05-25 13:50:08', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605270540', 'SYSUSER2016031305', null, null, '你居然不听', '1', '4', '2016-05-27 22:14:36', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605270541', 'SYSUSER2016031305', null, '图灵机器人', '你要听不', '2', '4', '2016-05-27 22:14:39', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605270542', 'SYSUSER2016031305', null, null, '傻不拉几的', '1', '4', '2016-05-27 22:14:43', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605270543', 'SYSUSER2016031305', null, '图灵机器人', '确实挺傻', '2', '4', '2016-05-27 22:14:44', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290554', 'SYSUSER2016031305', null, null, '爱你哦', '1', '4', '2016-05-29 14:13:27', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290555', 'SYSUSER2016031305', null, '图灵机器人', '我也爱你呀', '2', '4', '2016-05-29 14:13:30', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290556', 'SYSUSER2016031305', null, null, '有多爱我啊', '1', '4', '2016-05-29 14:13:39', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290557', 'SYSUSER2016031305', null, '图灵机器人', '好爱你哦', '2', '4', '2016-05-29 14:13:40', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290558', 'SYSUSER2016031305', null, null, '西红柿', '1', '4', '2016-05-29 14:13:47', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290559', 'SYSUSER2016031305', null, '图灵机器人', '番茄，别名西红柿、洋柿子。很多人认为西红柿就番茄，其实他们是不一样的，古名六月柿、喜报三元。在秘鲁和墨西哥，最初称之为“狼桃”。全体生粘质腺毛，有强烈气味。茎易倒伏。叶羽状复叶或羽状深裂，小叶极不规则，大小不等，卵形或矩圆形，边缘有不规则锯齿或裂片。花萼辐状，裂片披针形，果时宿存；花冠辐状，黄色。浆果扁球状或近球状，肉质而多汁液，桔黄色或鲜红色，光滑；种子黄色。花果期夏秋季。番茄是喜温、喜光性蔬菜，对土壤条件要求不太严格，但为获得丰产，促进根系良好发育，应选用土层深厚，排水良好，富含有机质的肥沃壤土。原产南美洲，中国南北广泛栽培。番茄营养丰富，具特殊风味。具有减肥瘦身、消除疲劳、增进食欲、提高对蛋白质的消化、减少胃胀食积等功效。', '2', '4', '2016-05-29 14:13:49', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290560', 'SYSUSER2016031305', null, null, '西华大学', '1', '4', '2016-05-29 14:13:59', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290561', 'SYSUSER2016031305', null, '图灵机器人', '人南校区:四川省成都市人民南路3段37号,邮政编码:610041 安德校区:四川省成都市郫县安德镇温彭路399号', '2', '4', '2016-05-29 14:14:02', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290562', 'SYSUSER2016031305', null, null, '西华大学信息', '1', '4', '2016-05-29 14:14:18', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290563', 'SYSUSER2016031305', null, '图灵机器人', '西华大学是经国家教育部2003年4月16日批准，由原四川工业学院和原成都师范高等专科学校合并组建，是四川省重点建设和发展的省属多科性大学。', '2', '4', '2016-05-29 14:14:19', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290564', 'SYSUSER2016031305', null, null, '北京大学', '1', '4', '2016-05-29 14:14:32', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290565', 'SYSUSER2016031305', null, '图灵机器人', '中国最好的高等学府之一。', '2', '4', '2016-05-29 14:14:33', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290566', 'SYSUSER2016031305', null, null, '胡志辉', '1', '4', '2016-05-29 14:14:39', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290567', 'SYSUSER2016031305', null, '图灵机器人', '胡志辉，长沙市长郡中学教师。', '2', '4', '2016-05-29 14:14:40', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290568', 'SYSUSER2016031305', null, null, '西华大学 胡志辉', '1', '4', '2016-05-29 14:14:52', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290569', 'SYSUSER2016031305', null, '图灵机器人', '我当得了女神,装得了萝莉,扮得了御姐,卖得了萌', '2', '4', '2016-05-29 14:14:54', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290570', 'SYSUSER2016031305', null, null, '找工作', '1', '4', '2016-05-29 15:20:54', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290571', 'SYSUSER2016031305', null, '图灵机器人', '这个社会不好混啊,努力吧', '2', '4', '2016-05-29 15:20:56', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290572', 'SYSUSER2016031305', null, null, '最近什么工作最好啊', '1', '4', '2016-05-29 15:21:07', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201605290573', 'SYSUSER2016031305', null, '图灵机器人', '考研书童也不知道是什么耶', '2', '4', '2016-05-29 15:21:08', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606010589', 'SYSUSER2016031305', '任务提醒', '任务提醒', '你有新任务哦，请在个人任务中查看！', '2', '4', '2016-06-01 10:32:58', '2016-06-01 14:20:00');
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020590', 'SYSUSER2016031305', null, null, '西红柿', '1', '4', '2016-06-02 10:00:37', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020591', 'SYSUSER2016031305', null, '图灵机器人', '番茄，别名西红柿、洋柿子。很多人认为西红柿就番茄，其实他们是不一样的，古名六月柿、喜报三元。在秘鲁和墨西哥，最初称之为“狼桃”。全体生粘质腺毛，有强烈气味。茎易倒伏。叶羽状复叶或羽状深裂，小叶极不规则，大小不等，卵形或矩圆形，边缘有不规则锯齿或裂片。花萼辐状，裂片披针形，果时宿存；花冠辐状，黄色。浆果扁球状或近球状，肉质而多汁液，桔黄色或鲜红色，光滑；种子黄色。花果期夏秋季。番茄是喜温、喜光性蔬菜，对土壤条件要求不太严格，但为获得丰产，促进根系良好发育，应选用土层深厚，排水良好，富含有机质的肥沃壤土。原产南美洲，中国南北广泛栽培。番茄营养丰富，具特殊风味。具有减肥瘦身、消除疲劳、增进食欲、提高对蛋白质的消化、减少胃胀食积等功效。', '2', '4', '2016-06-02 10:00:40', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020592', 'SYSUSER2016031305', null, null, '番茄炒蛋怎么做', '1', '4', '2016-06-02 10:00:53', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020593', 'SYSUSER2016031305', null, '图灵机器人', '亲，已帮您找到菜谱信息菜名:番茄炒蛋<br>菜谱信息:番茄、鸡蛋、盐、糖<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1000357/\'>点击查看更多哦</a><br>菜名:番茄炒蛋<br>菜谱信息:番茄、鸡蛋、盐、葱花<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1012917/\'>点击查看更多哦</a><br>菜名:番茄炒蛋<br>菜谱信息:鸡蛋、番茄、盐、糖<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1001365/\'>点击查看更多哦</a><br>菜名:番茄炒蛋<br>菜谱信息:番茄、鸡蛋、油、盐、白糖、胡椒粉、料酒<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/91130/\'>点击查看更多哦</a><br>菜名:番茄炒鸡蛋<br>菜谱信息:鸡蛋、番茄、小葱、泡椒、蒜瓣、食用油、盐、番茄酱、白糖、白酒<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/98252/\'>点击查看更多哦</a><br>菜名:番茄炒鸡蛋<br>菜谱信息:番茄、鸡蛋、盐、白糖<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1049342/\'>点击查看更多哦</a><br>菜名:番茄炒蛋<br>菜谱信息:中等个头的番茄、鸡蛋、盐、白糖<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/12328/\'>点击查看更多哦</a><br>菜名:番茄炒鸡蛋<br>菜谱信息:番茄、鸡蛋、葱、盐、糖、味精<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/164439/\'>点击查看更多哦</a><br>菜名:番茄炒蛋<br>菜谱信息:番茄、鸡蛋、盐、油<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1042233/\'>点击查看更多哦</a><br>菜名:番茄炒鸡蛋<br>菜谱信息:番茄、鸡蛋、盐、清水、油<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1042511/\'>点击查看更多哦</a><br>菜名:番茄炒蛋<br>菜谱信息:番茄、鸡蛋<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1007704/\'>点击查看更多哦</a><br>菜名:番茄炒鸡蛋<br>菜谱信息:番茄、土鸡蛋、盐、糖<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1073369/\'>点击查看更多哦</a><br>菜名:番茄炒蛋<br>菜谱信息:番茄、鸭蛋（鸡蛋也可以）、食用油、盐、鸡精、糖<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1001602/\'>点击查看更多哦</a><br>菜名:番茄炒蛋<br>菜谱信息:番茄、鸡蛋、糖、葱<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/1029625/\'>点击查看更多哦</a><br>菜名:番茄炒鸡蛋<br>菜谱信息:西红柿、鸡蛋、盐、白糖<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.xiachufang.com/recipe/100022245/\'>点击查看更多哦</a><br>', '2', '4', '2016-06-02 10:00:55', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020594', 'SYSUSER2016031305', null, null, '你是谁呀', '1', '4', '2016-06-02 10:22:44', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020595', 'SYSUSER2016031305', null, '图灵机器人', '我是你的考研书童', '2', '4', '2016-06-02 10:22:45', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020596', 'SYSUSER2016031305', null, null, '今天心情不开心', '1', '4', '2016-06-02 10:22:52', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020597', 'SYSUSER2016031305', null, '图灵机器人', '不开心就是在拿别人的错误惩罚自己[点头]', '2', '4', '2016-06-02 10:22:53', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020598', 'SYSUSER2016031305', null, null, '好多作业哦', '1', '4', '2016-06-02 10:23:01', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020599', 'SYSUSER2016031305', null, '图灵机器人', '明天考试没留作业', '2', '4', '2016-06-02 10:23:02', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020600', 'SYSUSER2016031305', null, null, '你真傻呀', '1', '4', '2016-06-02 10:23:10', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020601', 'SYSUSER2016031305', null, '图灵机器人', '你说谁傻呢？', '2', '4', '2016-06-02 10:23:11', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020602', 'SYSUSER2016031305', null, null, '说你傻呀', '1', '4', '2016-06-02 10:23:18', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020603', 'SYSUSER2016031305', null, '图灵机器人', '我只是聪明的不明显', '2', '4', '2016-06-02 10:23:19', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020604', 'SYSUSER2016031305', null, null, '最新考验新闻', '1', '4', '2016-06-02 10:23:28', null);
INSERT INTO `intelligent_message` VALUES ('INTELLIGENTMESSAGE201606020605', 'SYSUSER2016031305', null, '图灵机器人', '亲，已帮您找到相关新闻标题:<br>来源:网易新闻<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.news.so.com//transcode?ofmt=html&src=srp&q=%E8%80%83%E9%AA%8C&pn=1&pos=1&m=f12f4558e8a98a24a2189ae40fe849b2c35993bc&u=http%3A%2F%2Ffinance.sina.com.cn%2Fmoney%2Ffuture%2Ffmnews%2F2016-06-02%2Fdoc-ifxsvexw8236702.shtml&sign=news_mso&refer=list\'>点击查看更多哦</a><br>标题:<br>来源:网易新闻<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.news.so.com//transcode?ofmt=html&src=srp&q=%E8%80%83%E9%AA%8C&pn=1&pos=4&m=76fde4a2937055e3570362ef867d50b1ebd1421c&u=http%3A%2F%2Fnews.china.com%2Finternationalgd%2F10000166%2F20160529%2F22759778.html&sign=news_mso&refer=list\'>点击查看更多哦</a><br>标题:<br>来源:网易新闻<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.news.so.com//transcode?ofmt=html&src=srp&q=%E8%80%83%E9%AA%8C&pn=1&pos=5&m=9143edb85b887b1afd4f9ebf3788e266a3004d6d&u=http%3A%2F%2Fmini.eastday.com%2Fa%2F160602093750749-2.html&sign=news_mso&refer=list\'>点击查看更多哦</a><br>标题:<br>来源:网易新闻<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.news.so.com//transcode?ofmt=html&src=srp&q=%E8%80%83%E9%AA%8C&pn=1&pos=6&m=c0aa73efa9a33f2d64ba3668b44439a0d4292c02&u=http%3A%2F%2Fxhpfm.news.zhongguowangshi.com%3A8091%2Fv200%2Fnewshare%2F868815%3Fchannel%3D360&sign=news_mso&refer=list\'>点击查看更多哦</a><br>标题:<br>来源:网易新闻<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.news.so.com//transcode?ofmt=html&src=srp&q=%E8%80%83%E9%AA%8C&pn=1&pos=7&m=9c6e097dce1fc3ef8f6186a2acf8cf38348c9b26&u=http%3A%2F%2Fnews.iresearch.cn%2Fcontent%2F2016%2F06%2F261444.shtml&sign=news_mso&refer=list\'>点击查看更多哦</a><br>标题:<br>来源:网易新闻<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.news.so.com//transcode?ofmt=html&src=srp&q=%E8%80%83%E9%AA%8C&pn=1&pos=8&m=03b08b1544de651fa53932b05e00d019b236e59d&u=http%3A%2F%2Fsports.qq.com%2Fa%2F20160601%2F022944.htm&sign=news_mso&refer=list\'>点击查看更多哦</a><br>标题:<br>来源:网易新闻<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.news.so.com//transcode?ofmt=html&src=srp&q=%E8%80%83%E9%AA%8C&pn=1&pos=9&m=9038f637fde567b35ef8828311bbcb4b04151010&u=http%3A%2F%2Ffashion.sohu.com%2F20160531%2Fn452193023.shtml&sign=news_mso&refer=list\'>点击查看更多哦</a><br>标题:<br>来源:网易新闻<br>详细连接:<a class=\'robit_url\' href=\'javascript:void(0);\' href_url=\'http://m.news.so.com//transcode?ofmt=html&src=srp&q=%E8%80%83%E9%AA%8C&pn=1&pos=10&m=062638a421d8058100ea94d970f0e8cf9198d271&u=http%3A%2F%2Fauto.dahe.cn%2F2016%2F06-02%2F106943896.html&sign=news_mso&refer=list\'>点击查看更多哦</a><br>', '2', '4', '2016-06-02 10:23:30', null);

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
INSERT INTO `key_log` VALUES ('KEYLOG201605130397', '李小二', '罚款是打发三角阀傻大姐发牢骚啊啊速读法啊', '1837847382', '10', '2016-05-13 20:11:35');
INSERT INTO `key_log` VALUES ('KEYLOG201605270551', '王鑫', '好的好的黑道皇后好的好的好恒大华府好好的好的黄飞鸿', '18345621357', '10', '2016-05-27 22:19:53');
INSERT INTO `key_log` VALUES ('KEY_LOG_001', '胡志辉', '这个软件很好用哦,希望流畅性更加提升就好', '18380461811', '10', '2016-05-08 15:00:13');

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
INSERT INTO `learn_plan` VALUES ('LEARNPLAN201605050261', 'SYSUSER2016031305', '5.5学习', null, '开始学习', '2016-05-05 13:25:00', '2016-05-05 14:25:00', '1', '2016-05-05 10:25:57', '2016-05-05 10:25:57');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN201605050293', 'SYSUSER201605050272', '开始啦', null, '哇咔咔', '2016-05-05 12:40:00', '2016-05-06 12:40:00', '1', '2016-05-05 12:40:26', '2016-05-05 12:40:26');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN201605100367', 'SYSUSER201605100339', '呵呵', null, '我', '2016-05-16 14:57:00', '2016-06-16 14:57:00', '1', '2016-05-10 14:57:54', '2016-05-10 14:57:54');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN201605200448', 'SYSUSER2016031305', '今天考验啦', null, '很好的', '2016-05-20 11:59:00', '2016-05-22 11:59:00', '1', '2016-05-20 09:59:38', '2016-05-20 09:59:38');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN201605270539', 'SYSUSER2016031305', '明天进行比赛', null, '很好的', '2016-05-28 08:13:00', '2016-05-28 22:14:00', '1', '2016-05-27 22:14:21', '2016-05-27 22:14:21');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN201605270553', 'SYSUSER2016031305', '返回吧', null, '哈哈', '2016-05-27 22:31:00', '2016-05-27 23:32:00', '1', '2016-05-27 22:32:16', '2016-05-27 22:32:16');
INSERT INTO `learn_plan` VALUES ('LEARNPLAN201606010587', 'SYSUSER2016031305', '就要答辩啦', null, '答辩啦', '2016-06-01 14:20:00', '2016-06-01 19:21:00', '1', '2016-06-01 10:21:27', '2016-06-01 10:21:27');

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
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201604210147', 'CLASSROOM201604200141', 'SYSUSER2016031305', '发生的  ', 'huzhihui', null, '1', '2016-04-21 21:18:40', '2016-04-21 21:18:40', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201604210148', 'CLASSROOM201604200142', 'SYSUSER2016031305', 'ceshi', 'huzhihui', null, '1', '2016-04-21 21:18:45', '2016-04-21 21:18:45', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201604210149', 'CLASSROOM201604200143', 'SYSUSER2016031305', null, 'huzhihui', null, '1', '2016-04-21 21:18:48', '2016-04-21 21:18:48', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201604210151', 'CLASSROOM201604210150', 'SYSUSER2016031305', null, 'huzhihui', null, '1', '2016-04-21 21:28:26', '2016-04-21 21:28:26', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201604230157', 'CLASSROOM201604230156', 'SYSUSER2016031305', '好的好的好', 'huzhihui', null, '1', '2016-04-23 15:44:14', '2016-04-23 15:44:14', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605040223', 'CLASSROOM201605040222', 'SYSUSER2016031305', null, 'huzhihui', null, '1', '2016-05-04 15:07:01', '2016-05-04 15:07:01', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605050277', 'CLASSROOM201604200142', 'SYSUSER201605050272', null, '张三测试用户', null, '1', '2016-05-05 12:22:37', '2016-05-05 12:22:37', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605050279', 'CLASSROOM201605050278', 'SYSUSER2016031305', '评论', 'huzhihui', null, '1', '2016-05-05 12:23:30', '2016-05-05 12:23:30', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605050283', 'CLASSROOM201604200141', 'SYSUSER201605050272', 'woshishdhfh', '张三测试用户', null, '1', '2016-05-05 12:37:47', '2016-05-05 12:37:47', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605050304', 'CLASSROOM201605050294', 'SYSUSER201605050272', null, '张三测试用户', null, '1', '2016-05-05 14:09:04', '2016-05-05 14:09:04', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605050305', 'CLASSROOM201605040222', 'SYSUSER201605050272', null, '张三测试用户', null, '1', '2016-05-05 14:09:06', '2016-05-05 14:09:06', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605050306', 'CLASSROOM201604210150', 'SYSUSER201605050272', null, '张三测试用户', null, '1', '2016-05-05 14:09:12', '2016-05-05 14:09:12', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605100363', 'CLASSROOM201604200141', 'SYSUSER201605100339', null, 'wangxin', null, '1', '2016-05-10 14:55:41', '2016-05-10 14:55:41', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605100364', 'CLASSROOM201605050278', 'SYSUSER201605100339', null, 'wangxin', null, '1', '2016-05-10 14:55:43', '2016-05-10 14:55:43', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605100365', 'CLASSROOM201605050294', 'SYSUSER201605100339', null, 'wangxin', null, '1', '2016-05-10 14:55:43', '2016-05-10 14:55:43', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605100366', 'CLASSROOM201605040222', 'SYSUSER201605100339', null, 'wangxin', null, '1', '2016-05-10 14:55:44', '2016-05-10 14:55:44', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605220516', 'CLASSROOM201605050278', 'SYSUSER201605050272', null, '张三测试用户', null, '1', '2016-05-22 22:14:27', '2016-05-22 22:14:27', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605220517', 'CLASSROOM201604230156', 'SYSUSER201605050272', null, '张三测试用户', null, '1', '2016-05-22 22:14:30', '2016-05-22 22:14:30', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605220520', 'CLASSROOM201605220519', 'SYSUSER201605050272', '起来啦，人好少啊', '张三测试用户', null, '1', '2016-05-22 22:38:29', '2016-05-22 22:38:29', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605270538', 'CLASSROOM201605220519', 'SYSUSER2016031305', '我来学习啦', 'huzhihui', null, '1', '2016-05-27 22:13:13', '2016-05-27 22:13:13', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605270546', 'CLASSROOM201605270544', 'SYSUSER2016031305', 'wojiuswo', 'huzhihui', null, '1', '2016-05-27 22:16:00', '2016-05-27 22:16:00', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605290574', 'CLASSROOM201605270545', 'SYSUSER2016031305', null, 'huzhihui', null, '1', '2016-05-29 16:04:24', '2016-05-29 16:04:24', null);
INSERT INTO `oppointment` VALUES ('OPPOINTMENT201605290575', 'CLASSROOM201605220518', 'SYSUSER2016031305', null, 'huzhihui', null, '1', '2016-05-29 16:04:57', '2016-05-29 16:04:57', null);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `POST_CUID` varchar(100) NOT NULL COMMENT '帖子CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `POST_NAME` varchar(50) DEFAULT NULL COMMENT '帖子名称',
  `POST_URL` varchar(500) DEFAULT '' COMMENT '帖子图片',
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
INSERT INTO `post` VALUES ('POST20160405010', 'SYSUSER2016031305', '最大的', null, 'gadget暗帝', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:33:59', '2016-04-05 20:33:59');
INSERT INTO `post` VALUES ('POST20160405011', 'SYSUSER2016031305', '最大的', null, '股份公司地方', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:02', '2016-04-05 20:34:02');
INSERT INTO `post` VALUES ('POST20160405012', 'SYSUSER2016031305', '最大的2', null, '发射点发', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:04', '2016-04-05 20:34:04');
INSERT INTO `post` VALUES ('POST20160405013', 'SYSUSER2016031305', '最大的2', null, '发射点发按时', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:07', '2016-04-05 20:34:07');
INSERT INTO `post` VALUES ('POST20160405014', 'SYSUSER2016031305', '最大的2', null, '就是发帖,怎么样', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:13', '2016-04-05 20:34:13');
INSERT INTO `post` VALUES ('POST20160405015', 'SYSUSER2016031305', '最大的2', null, '随便发', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:34:17', '2016-04-05 20:34:17');
INSERT INTO `post` VALUES ('POST2016040508', 'SYSUSER2016031305', '软件工程', null, '第一个帖子', '第一个测试', '2', '0', '0', null, '1', '2016-04-05 20:31:08', '2016-04-05 20:31:08');
INSERT INTO `post` VALUES ('POST2016040509', 'SYSUSER2016031305', '最大的', null, '陈巧巧专用贴', '哈哈哈', '2', '0', '0', null, '1', '2016-04-05 20:33:56', '2016-04-05 20:33:56');
INSERT INTO `post` VALUES ('POST20160406016', 'SYSUSER2016031305', '软件工程', null, '最新的帖子哦', '好的好的好黄河大街黄飞鸿很好的话好的不好的话好的吧并不是宝贝不懂好吧不喜欢才不会好的好的好不喜欢电话', '2', '0', '0', null, '1', '2016-04-06 20:50:39', '2016-04-06 22:06:06');
INSERT INTO `post` VALUES ('POST20160406021', 'SYSUSER2016031305', '软件工程', null, '4.6测试帖子', '我的测试今天接口', '2', '0', '0', null, '1', '2016-04-06 22:06:06', '2016-04-06 22:06:06');
INSERT INTO `post` VALUES ('POST20160407024', 'SYSUSER2016031305', '软件工程', null, '4.7帖子', '我的4.8', '2', '0', '0', null, '1', '2016-04-07 20:49:09', '2016-04-07 20:49:09');
INSERT INTO `post` VALUES ('POST20160408027', 'SYSUSER2016031305', '软件工程', null, '每日一贴4.8', '好的好的好的好的好C多喝点接电话X单反', '2', '0', '0', null, '1', '2016-04-08 21:52:19', '2016-04-08 21:52:19');
INSERT INTO `post` VALUES ('POST20160410029', 'SYSUSER2016031305', '软件工程', null, '4.10m每日一贴', '的好的好的回电话很喜欢的很方便好的好的不方便不对不对黄飞鸿好的好的好', '2', '0', '0', null, '1', '2016-04-10 17:00:58', '2016-04-10 17:00:58');
INSERT INTO `post` VALUES ('POST20160413045', 'SYSUSER2016031305', '软件工程', null, '4.14.一贴', '好的接电话好的好的好好的好的好', '2', '0', '0', null, '1', '2016-04-13 22:26:15', '2016-04-13 22:26:15');
INSERT INTO `post` VALUES ('POST201604150103', 'SYSUSER2016031305', 'hxhfh', null, 'kkk', 'bjnn', '2', '0', '0', null, '1', '2016-04-15 22:23:48', '2016-04-15 22:23:48');
INSERT INTO `post` VALUES ('POST201604160126', 'SYSUSER2016031305', '软件工程', null, '4.16.帖子', 'H就放假大家就放假大家', '2', '0', '0', null, '1', '2016-04-16 10:07:33', '2016-04-16 10:07:33');
INSERT INTO `post` VALUES ('POST201604230168', 'SYSUSER2016031305', '软件工程', null, '好久没有发帖了', '布丁酒店就放假基础护肤经常回家就放假放假', '2', '0', '0', null, '1', '2016-04-23 16:18:29', '2016-04-23 16:18:29');
INSERT INTO `post` VALUES ('POST201605020170', 'SYSUSER2016031305', '软件工程', null, '今天发一贴', '恒大华府回房间', '2', '0', '0', null, '1', '2016-05-02 12:44:51', '2016-05-02 12:44:51');
INSERT INTO `post` VALUES ('POST201605030203', 'SYSUSER2016031305', '软件工程', null, '已经5.3号了，', '得加油了', '2', '0', '0', null, '1', '2016-05-03 10:18:47', '2016-05-03 10:18:47');
INSERT INTO `post` VALUES ('POST201605030213', 'SYSUSER2016031305', '', null, '', '', '2', '0', '0', null, '1', '2016-05-03 14:29:52', '2016-05-03 14:29:52');
INSERT INTO `post` VALUES ('POST201605030221', 'SYSUSER2016031305', '软件工程', null, '最新事件', '就放假放假发货就放假放假减肥黄飞鸿积化和差', '2', '0', '0', null, '1', '2016-05-03 15:12:33', '2016-05-03 15:12:33');
INSERT INTO `post` VALUES ('POST201605050268', 'SYSUSER2016031305', '软件工程', null, '5.5每日一贴', '好的好的黄飞鸿', '2', '0', '0', null, '1', '2016-05-05 10:28:12', '2016-05-05 10:28:12');
INSERT INTO `post` VALUES ('POST201605050276', 'SYSUSER201605050272', '多喝点接电话', null, '测试区发帖', '多喝点黄飞鸿', '2', '0', '0', null, '1', '2016-05-05 12:22:28', '2016-05-05 12:22:28');
INSERT INTO `post` VALUES ('POST201605050307', 'SYSUSER201605050272', '软件工程', null, '多贴测试', '好的解决方法', '2', '0', '0', null, '1', '2016-05-05 14:10:13', '2016-05-05 14:10:13');
INSERT INTO `post` VALUES ('POST201605050308', 'SYSUSER201605050272', '不限', null, '全名共享', '好烦好烦回房间', '2', '0', '0', null, '1', '2016-05-05 15:19:59', '2016-05-05 15:19:59');
INSERT INTO `post` VALUES ('POST201605070316', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462607856136286.png', '测试图片上传', '发生的飞洒地方啊', '2', '0', '0', null, '1', '2016-05-07 15:57:33', '2016-05-07 15:57:33');
INSERT INTO `post` VALUES ('POST201605070317', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462608108088804.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462608111655932.jpg', '手机测试', '回到家大家', '2', '0', '0', null, '1', '2016-05-07 16:01:47', '2016-05-07 16:01:47');
INSERT INTO `post` VALUES ('POST201605070321', 'SYSUSER201605050272', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462611047980230.jpg', 'ceshi', '回电话放假', '2', '0', '0', null, '1', '2016-05-07 16:50:46', '2016-05-07 16:50:46');
INSERT INTO `post` VALUES ('POST201605070322', 'SYSUSER201605050272', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462611173748539.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462611174101226.jpg', 'ceshi1图', '回电话放假', '2', '0', '0', null, '1', '2016-05-07 16:52:53', '2016-05-07 16:52:53');
INSERT INTO `post` VALUES ('POST201605070323', 'SYSUSER201605050272', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462612633133733.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462612633296712.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462612633335955.jpg', 'ceshi1图22', '回电话放假', '2', '0', '0', null, '1', '2016-05-07 17:17:12', '2016-05-07 17:17:12');
INSERT INTO `post` VALUES ('POST201605070324', 'SYSUSER201605050272', '公共', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462612814501136.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462612814576750.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462612814618609.jpg', '测试文件', '话费加肥加大', '2', '0', '0', null, '1', '2016-05-07 17:20:13', '2016-05-07 17:20:13');
INSERT INTO `post` VALUES ('POST201605080328', 'SYSUSER201605050272', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462677471683407.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462677471735190.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462677471770312.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462677471826748.jpg', '文件测试啊', '黄飞鸿很好的话', '2', '0', '0', null, '1', '2016-05-08 11:17:51', '2016-05-08 11:17:51');
INSERT INTO `post` VALUES ('POST201605100357', 'SYSUSER201605100339', 'fhhfhf', null, 'ceshifjfj', 'hfufu', '2', '0', '0', null, '1', '2016-05-10 14:53:52', '2016-05-10 14:53:52');
INSERT INTO `post` VALUES ('POST201605100380', 'SYSUSER201605100368', '软件工程', null, '杨森测试发帖', '恢复肌肤解放军', '2', '0', '0', null, '1', '2016-05-10 15:08:25', '2016-05-10 15:08:25');
INSERT INTO `post` VALUES ('POST201605100386', 'SYSUSER2016031305', '软件工程', 'http://192.168.2.122:8080/xhupubmedfiles/images/1462864984225837.jpg', '测试', '华东交大就放假', '2', '0', '0', null, '1', '2016-05-10 15:23:03', '2016-05-10 15:23:03');
INSERT INTO `post` VALUES ('POST201605100387', 'SYSUSER2016031305', '软件工程', 'http://192.168.2.122:8080/xhupubmedfiles/images/1462865046585445.jpg;http://192.168.2.122:8080/xhupubmedfiles/images/1462865046612534.jpg;http://192.168.2.122:8080/xhupubmedfiles/images/1462865046644283.jpg', '测试多文件', '就放假放假', '2', '0', '0', null, '1', '2016-05-10 15:24:06', '2016-05-10 15:24:06');
INSERT INTO `post` VALUES ('POST201605140416', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463210997700736.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463210997773169.jpg', '随便测', '话费就放假放假', '2', '0', '0', null, '1', '2016-05-14 15:29:55', '2016-05-14 15:29:55');
INSERT INTO `post` VALUES ('POST201605190433', 'SYSUSER2016031305', '软件工程', null, '测试返回', '测试返回', '2', '0', '0', null, '1', '2016-05-19 22:52:27', '2016-05-19 22:52:27');
INSERT INTO `post` VALUES ('POST201605190434', 'SYSUSER2016031305', '软件工程', null, '手机真机测试返回', '好的好的回电话', '2', '0', '0', null, '1', '2016-05-19 22:55:52', '2016-05-19 22:55:52');
INSERT INTO `post` VALUES ('POST201605190435', 'SYSUSER2016031305', '软件工程', null, '手机真机测试返回', '好的好的回电话', '2', '0', '0', null, '1', '2016-05-19 22:56:26', '2016-05-19 22:56:26');
INSERT INTO `post` VALUES ('POST201605190436', 'SYSUSER2016031305', '软件工程', null, '继续测试', '回电话放假', '2', '0', '0', null, '1', '2016-05-19 22:59:57', '2016-05-19 22:59:57');
INSERT INTO `post` VALUES ('POST201605190437', 'SYSUSER2016031305', '测试', null, '测试', '好好的回家', '2', '0', '0', null, '1', '2016-05-19 23:03:16', '2016-05-19 23:03:16');
INSERT INTO `post` VALUES ('POST201605190438', 'SYSUSER2016031305', '测试', null, '测试', '好好的回家', '2', '0', '0', null, '1', '2016-05-19 23:04:31', '2016-05-19 23:04:31');
INSERT INTO `post` VALUES ('POST201605190439', 'SYSUSER2016031305', '测试', null, '文件失败', '好的好的回电话', '2', '0', '0', null, '1', '2016-05-19 23:06:55', '2016-05-19 23:06:55');
INSERT INTO `post` VALUES ('POST201605190440', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463670590431755.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463670590477583.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463670590545488.jpg', '文件依然失败嘛', '好的好好的', '2', '0', '0', null, '1', '2016-05-19 23:09:49', '2016-05-19 23:09:49');
INSERT INTO `post` VALUES ('POST201605190441', 'SYSUSER2016031305', '软件', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463670959096334.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463670959163354.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463670959171401.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463670959204790.jpg', '测试', '好的黄飞鸿', '2', '0', '0', null, '1', '2016-05-19 23:15:58', '2016-05-19 23:15:58');
INSERT INTO `post` VALUES ('POST201605190442', 'SYSUSER2016031305', '测试', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463671013386568.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463671013448638.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463671013499578.jpg', '测试', '好的好的好', '2', '0', '0', null, '1', '2016-05-19 23:16:53', '2016-05-19 23:16:53');
INSERT INTO `post` VALUES ('POST201605200443', 'SYSUSER2016031305', '测试', null, '测试', '回电话回电话', '2', '0', '0', null, '1', '2016-05-20 09:42:04', '2016-05-20 09:42:04');
INSERT INTO `post` VALUES ('POST201605200444', 'SYSUSER2016031305', '测试', null, '测试', '发生大法师的', '2', '0', '0', null, '1', '2016-05-20 09:44:42', '2016-05-20 09:44:42');
INSERT INTO `post` VALUES ('POST201605200451', 'SYSUSER2016031305', '测试', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463725052627615.jpg', '丢失测试', '黑道皇后发发汗', '2', '1', '0', null, '1', '2016-05-20 14:17:32', '2016-05-20 14:17:32');
INSERT INTO `post` VALUES ('POST201605200453', 'SYSUSER2016031305', '合适', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463725198048470.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463725198047687.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463725198094662.jpg', '丢失测试', '减肥黄飞鸿', '2', '1', '0', null, '1', '2016-05-20 14:19:57', '2016-05-20 14:19:57');
INSERT INTO `post` VALUES ('POST201605210463', 'SYSUSER2016031305', '软件工程', null, '哈哈', 'u嘟嘟', '2', '0', '0', null, '1', '2016-05-21 13:53:22', '2016-05-21 13:53:22');
INSERT INTO `post` VALUES ('POST201605210464', 'SYSUSER2016031305', '软件工程', null, '哈哈', 'u嘟嘟', '2', '0', '0', null, '1', '2016-05-21 13:53:34', '2016-05-21 13:53:34');
INSERT INTO `post` VALUES ('POST201605210465', 'SYSUSER2016031305', '测试', null, '唉细', '好的好的好', '2', '1', '0', null, '1', '2016-05-21 13:53:59', '2016-05-21 13:53:59');
INSERT INTO `post` VALUES ('POST201605210467', 'SYSUSER2016031305', '测试', null, '文件呀', '嫉妒度', '2', '3', '0', null, '1', '2016-05-21 13:56:20', '2016-05-21 13:56:20');
INSERT INTO `post` VALUES ('POST201605210474', 'SYSUSER2016031305', '测试', null, '帖子哦，最后几贴', '好的好的好', '2', '0', '0', null, '1', '2016-05-21 20:20:05', '2016-05-21 20:20:05');
INSERT INTO `post` VALUES ('POST201605210475', 'SYSUSER2016031305', '软件工程', null, 'haha哈哈哈', '好好的好的', '2', '0', '0', null, '1', '2016-05-21 20:32:45', '2016-05-21 20:32:45');
INSERT INTO `post` VALUES ('POST201605210476', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463834072498675.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463834073024857.jpg;', 'aixi', '好烦好烦好', '2', '0', '0', null, '1', '2016-05-21 20:34:32', '2016-05-21 20:34:32');
INSERT INTO `post` VALUES ('POST201605210477', 'SYSUSER2016031305', '软僵持', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463834155188725.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463834155221861.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463834155275599.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463834155324636.jpg', '再一次', '好的好的好', '2', '0', '0', null, '1', '2016-05-21 20:35:53', '2016-05-21 20:35:53');
INSERT INTO `post` VALUES ('POST201605210480', 'SYSUSER2016031305', '软件工程', '', '考验呀', '好的好的好', '2', '2', '0', null, '1', '2016-05-21 20:47:56', '2016-05-21 20:47:56');
INSERT INTO `post` VALUES ('POST201605210483', 'SYSUSER2016031305', '软件工程', null, '发财啦', '好的好的好', '2', '1', '0', null, '1', '2016-05-21 21:03:30', '2016-05-21 21:03:30');
INSERT INTO `post` VALUES ('POST201605210484', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463836029476144.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463836029517974.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463836029522894.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463836029560497.jpg;', '这道题怎么做啊', '好的好好的', '2', '4', '0', null, '1', '2016-05-21 21:07:08', '2016-05-21 21:07:08');
INSERT INTO `post` VALUES ('POST201605210489', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463836693390505.jpg;', '优化到此为止了', '好的好好的', '2', '0', '0', null, '1', '2016-05-21 21:18:13', '2016-05-21 21:18:13');
INSERT INTO `post` VALUES ('POST201605210497', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463837872195971.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463837872292352.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463837872297291.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463837872304168.jpg;', '哈哈哈，拍毕业照', '好的好好的', '2', '2', '0', null, '1', '2016-05-21 21:37:50', '2016-05-21 21:37:50');
INSERT INTO `post` VALUES ('POST201605220500', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463925166727276.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463925166919699.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463925166830333.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463925166998335.jpg;', '5.22下雨了', '好好的回电话', '2', '4', '1', null, '1', '2016-05-22 21:52:46', '2016-05-22 21:52:46');
INSERT INTO `post` VALUES ('POST201605220522', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463928324846195.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463928324871514.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463928324896524.jpg;', '发布版本', '王鑫郑楼', '2', '0', '1', null, '1', '2016-05-22 22:45:24', '2016-05-22 22:45:24');
INSERT INTO `post` VALUES ('POST201605270547', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1464358689549166.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1464358689577676.jpg;', '明天比赛', '好的好的好', '2', '5', '1', null, '1', '2016-05-27 22:18:09', '2016-05-27 22:18:09');
INSERT INTO `post` VALUES ('POST201605300579', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1464614515278793.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1464614515619233.jpg;', '测试贴', '好的好的呵呵', '2', '0', '0', null, '4', '2016-05-30 21:21:53', '2016-05-30 21:21:53');
INSERT INTO `post` VALUES ('POST201606020607', 'SYSUSER2016031305', '软件工程', 'http://192.168.31.219:8080/xhupubmedfiles/images/1464834426642730.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1464834426681320.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1464834426543826.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1464834426716710.jpg;', '明天演示程序', '结婚的话', '2', '2', '0', null, '1', '2016-06-02 10:27:05', '2016-06-02 10:27:05');

-- ----------------------------
-- Table structure for replies
-- ----------------------------
DROP TABLE IF EXISTS `replies`;
CREATE TABLE `replies` (
  `REPLIES_CUID` varchar(100) NOT NULL COMMENT '回帖CUID',
  `POST_CUID` varchar(100) DEFAULT NULL COMMENT '帖子CUID',
  `CLASSROOM_CUID` varchar(100) DEFAULT NULL COMMENT '教室CUID',
  `SYS_USER_CUID` varchar(100) DEFAULT NULL COMMENT '系统用户CUID',
  `REPLIES_TITLE` varchar(500) DEFAULT '' COMMENT '回帖标题(做为图片使用)',
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
INSERT INTO `replies` VALUES ('REPLIES201604230169', 'POST201604230168', null, 'SYSUSER2016031305', null, '好的好的觉得', '1', '2016-04-23 16:18:38', '西华大学', '2016-04-23 16:18:38', '2016-04-23 16:18:38');
INSERT INTO `replies` VALUES ('REPLIES201605020171', 'POST201605020170', null, 'SYSUSER2016031305', null, '呵呵喜欢的回电话', '1', '2016-05-02 12:45:20', '西华大学', '2016-05-02 12:45:20', '2016-05-02 12:45:20');
INSERT INTO `replies` VALUES ('REPLIES201605030204', 'POST201605030203', null, 'SYSUSER2016031305', null, '评论你好了', '1', '2016-05-03 10:19:02', '西华大学', '2016-05-03 10:19:02', '2016-05-03 10:19:02');
INSERT INTO `replies` VALUES ('REPLIES201605030214', 'POST201605030213', null, 'SYSUSER2016031305', null, '什么都没有吗', '1', '2016-05-03 14:30:20', '西华大学', '2016-05-03 14:30:20', '2016-05-03 14:30:20');
INSERT INTO `replies` VALUES ('REPLIES201605050271', 'POST201605030221', null, 'SYSUSER2016031305', null, '随便料理', '1', '2016-05-05 11:13:14', '西华大学', '2016-05-05 11:13:14', '2016-05-05 11:13:14');
INSERT INTO `replies` VALUES ('REPLIES201605050273', 'POST201605050268', null, 'SYSUSER201605050272', null, '回帖测试', '1', '2016-05-05 12:21:17', '西华大学', '2016-05-05 12:21:17', '2016-05-05 12:21:17');
INSERT INTO `replies` VALUES ('REPLIES201605050274', 'POST201605030221', null, 'SYSUSER201605050272', null, '成功了啊', '1', '2016-05-05 12:21:31', '西华大学', '2016-05-05 12:21:31', '2016-05-05 12:21:31');
INSERT INTO `replies` VALUES ('REPLIES201605050299', 'POST201605050276', null, 'SYSUSER2016031305', null, '看你像什么东西哦', '1', '2016-05-05 12:59:28', '西华大学', '2016-05-05 12:59:28', '2016-05-05 12:59:28');
INSERT INTO `replies` VALUES ('REPLIES201605050300', 'POST201605050276', null, 'SYSUSER2016031305', null, '为什么这么难看啊', '1', '2016-05-05 12:59:40', '西华大学', '2016-05-05 12:59:40', '2016-05-05 12:59:40');
INSERT INTO `replies` VALUES ('REPLIES201605050303', 'POST201605050276', null, 'SYSUSER201605050272', null, '继续回复哦', '1', '2016-05-05 14:08:44', '西华大学', '2016-05-05 14:08:44', '2016-05-05 14:08:44');
INSERT INTO `replies` VALUES ('REPLIES201605050309', 'POST20160405012', null, 'SYSUSER201605050272', null, '随便测试', '1', '2016-05-05 15:20:26', '西华大学', '2016-05-05 15:20:26', '2016-05-05 15:20:26');
INSERT INTO `replies` VALUES ('REPLIES201605060314', 'POST201604160126', null, 'SYSUSER201605050272', null, '复古', '1', '2016-05-06 16:26:24', '西华大学', '2016-05-06 16:26:24', '2016-05-06 16:26:24');
INSERT INTO `replies` VALUES ('REPLIES201605080325', 'POST201605070324', null, 'SYSUSER201605050272', null, '随便回复', '1', '2016-05-08 10:34:17', '西华大学', '2016-05-08 10:34:17', '2016-05-08 10:34:17');
INSERT INTO `replies` VALUES ('REPLIES201605080326', 'POST201605070324', null, 'SYSUSER201605050272', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462675874241307.jpg123', '好的好的好', '1', '2016-05-08 10:51:13', '西华大学', '2016-05-08 10:51:13', '2016-05-08 10:51:13');
INSERT INTO `replies` VALUES ('REPLIES201605080327', 'POST201605070324', null, 'SYSUSER201605050272', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462675922898615.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462675922934359.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1462675922977122.jpg123', '继续测试', '1', '2016-05-08 10:52:02', '西华大学', '2016-05-08 10:52:02', '2016-05-08 10:52:02');
INSERT INTO `replies` VALUES ('REPLIES201605080330', 'POST201605080328', null, 'SYSUSER201605050272', 'http://192.168.31.219:8080/xhupubmedfiles/images/1462678201815791.jpg123', '回帖啦', '1', '2016-05-08 11:29:59', '西华大学', '2016-05-08 11:29:59', '2016-05-08 11:29:59');
INSERT INTO `replies` VALUES ('REPLIES201605100351', 'POST201605070317', null, 'SYSUSER201605100339', null, '测试', '1', '2016-05-10 14:42:28', '西华大学', '2016-05-10 14:42:28', '2016-05-10 14:42:28');
INSERT INTO `replies` VALUES ('REPLIES201605100354', 'POST201605070322', null, 'SYSUSER201605100339', null, 'yyfhfh', '1', '2016-05-10 14:46:54', '西华大学', '2016-05-10 14:46:54', '2016-05-10 14:46:54');
INSERT INTO `replies` VALUES ('REPLIES201605100355', 'POST201605070323', null, 'SYSUSER2016031305', null, '测试', '1', '2016-05-10 14:47:57', '西华大学', '2016-05-10 14:47:57', '2016-05-10 14:47:57');
INSERT INTO `replies` VALUES ('REPLIES201605100356', 'POST201605080328', null, 'SYSUSER201605100339', null, 'fgg', '1', '2016-05-10 14:49:09', '西华大学', '2016-05-10 14:49:09', '2016-05-10 14:49:09');
INSERT INTO `replies` VALUES ('REPLIES201605100358', 'POST201605100357', null, 'SYSUSER201605100339', null, 'hdhfh', '1', '2016-05-10 14:54:01', '西华大学', '2016-05-10 14:54:01', '2016-05-10 14:54:01');
INSERT INTO `replies` VALUES ('REPLIES201605100360', 'POST201605100357', null, 'SYSUSER201605100339', null, 'sibi', '1', '2016-05-10 14:54:29', '西华大学', '2016-05-10 14:54:29', '2016-05-10 14:54:29');
INSERT INTO `replies` VALUES ('REPLIES201605100369', 'POST201605080328', null, 'SYSUSER201605100368', null, 'suib', '1', '2016-05-10 15:03:05', '西华大学', '2016-05-10 15:03:05', '2016-05-10 15:03:05');
INSERT INTO `replies` VALUES ('REPLIES201605140417', 'POST201605140416', null, 'SYSUSER2016031305', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463211043889285.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463211043977872.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463211043997426.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463211044000337.jpg123', '复古风', '1', '2016-05-14 15:30:43', '西华大学', '2016-05-14 15:30:43', '2016-05-14 15:30:43');
INSERT INTO `replies` VALUES ('REPLIES201605150419', 'POST201605100387', null, 'SYSUSER2016031305', null, '', '1', '2016-05-15 13:16:38', '西华大学', '2016-05-15 13:16:38', '2016-05-15 13:16:38');
INSERT INTO `replies` VALUES ('REPLIES201605160422', 'POST201605140416', null, 'SYSUSER2016031305', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463382884325893.jpg123', '测试', '1', '2016-05-16 15:14:43', '西华大学', '2016-05-16 15:14:43', '2016-05-16 15:14:43');
INSERT INTO `replies` VALUES ('REPLIES201605200445', 'POST201605200444', null, 'SYSUSER2016031305', null, '回复啦', '1', '2016-05-20 09:48:56', '西华大学', '2016-05-20 09:48:56', '2016-05-20 09:48:56');
INSERT INTO `replies` VALUES ('REPLIES201605200449', 'POST201605200444', null, 'SYSUSER2016031305', null, '测试回复咯', '1', '2016-05-20 10:00:03', '西华大学', '2016-05-20 10:00:03', '2016-05-20 10:00:03');
INSERT INTO `replies` VALUES ('REPLIES201605200450', 'POST201605200444', null, 'SYSUSER2016031305', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463709628282841.jpg123', '累了', '1', '2016-05-20 10:00:27', '西华大学', '2016-05-20 10:00:27', '2016-05-20 10:00:27');
INSERT INTO `replies` VALUES ('REPLIES201605200452', 'POST201605200451', null, 'SYSUSER2016031305', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463725136699959.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463725136810845.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463725136781847.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463725136845266.jpg123', '丢失测试', '1', '2016-05-20 14:18:56', '西华大学', '2016-05-20 14:18:56', '2016-05-20 14:18:56');
INSERT INTO `replies` VALUES ('REPLIES201605200454', 'POST201605200453', null, 'SYSUSER2016031305', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463725256568256.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463725256681968.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463725256609623.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463725256669699.jpg123', '测试', '1', '2016-05-20 14:20:56', '西华大学', '2016-05-20 14:20:56', '2016-05-20 14:20:56');
INSERT INTO `replies` VALUES ('REPLIES201605210466', 'POST201605210465', null, 'SYSUSER2016031305', null, '又出问题啦', '1', '2016-05-21 13:54:39', '西华大学', '2016-05-21 13:54:39', '2016-05-21 13:54:39');
INSERT INTO `replies` VALUES ('REPLIES201605210468', 'POST201605210467', null, 'SYSUSER2016031305', null, '好好学好的好的', '1', '2016-05-21 17:50:03', '西华大学', '2016-05-21 17:50:03', '2016-05-21 17:50:03');
INSERT INTO `replies` VALUES ('REPLIES201605210469', 'POST201605210467', null, 'SYSUSER2016031305', null, '好的好的好', '1', '2016-05-21 17:50:18', '西华大学', '2016-05-21 17:50:18', '2016-05-21 17:50:18');
INSERT INTO `replies` VALUES ('REPLIES201605210473', 'POST201605210467', null, 'SYSUSER2016031305', null, '回复测试', '1', '2016-05-21 20:19:36', '西华大学', '2016-05-21 20:19:36', '2016-05-21 20:19:36');
INSERT INTO `replies` VALUES ('REPLIES201605210481', 'POST201605210480', null, 'SYSUSER2016031305', null, '会哈', '1', '2016-05-21 20:52:53', '西华大学', '2016-05-21 20:52:53', '2016-05-21 20:52:53');
INSERT INTO `replies` VALUES ('REPLIES201605210482', 'POST201605210480', null, 'SYSUSER2016031305', '', '牛啊', '1', '2016-05-21 20:56:28', '西华大学', '2016-05-21 20:56:28', '2016-05-21 20:56:28');
INSERT INTO `replies` VALUES ('REPLIES201605210485', 'POST201605210484', null, 'SYSUSER2016031305', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463836062714699.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463836062763275.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463836062791374.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463836062826197.jpg;', '1+1得2', '1', '2016-05-21 21:07:42', '西华大学', '2016-05-21 21:07:42', '2016-05-21 21:07:42');
INSERT INTO `replies` VALUES ('REPLIES201605210486', 'POST201605210484', null, 'SYSUSER2016031305', '', '是是是', '1', '2016-05-21 21:08:09', '西华大学', '2016-05-21 21:08:09', '2016-05-21 21:08:09');
INSERT INTO `replies` VALUES ('REPLIES201605210487', 'POST201605210484', null, 'SYSUSER2016031305', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463836491784709.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463836491790808.jpg;http://192.168.31.219:8080/xhupubmedfiles/images/1463836491831543.jpg;', '我也做不来', '1', '2016-05-21 21:14:50', '西华大学', '2016-05-21 21:14:50', '2016-05-21 21:14:50');
INSERT INTO `replies` VALUES ('REPLIES201605210488', 'POST201605210484', null, 'SYSUSER2016031305', '', '你会吗？', '1', '2016-05-21 21:15:58', '西华大学', '2016-05-21 21:15:58', '2016-05-21 21:15:58');
INSERT INTO `replies` VALUES ('REPLIES201605210495', 'POST201605210483', null, 'SYSUSER2016031305', '', '发给', '1', '2016-05-21 21:33:00', '西华大学', '2016-05-21 21:33:00', '2016-05-21 21:33:00');
INSERT INTO `replies` VALUES ('REPLIES201605220502', 'POST201605220500', null, 'SYSUSER2016031305', '', '我来回复啦', '1', '2016-05-22 22:04:53', '西华大学', '2016-05-22 22:04:53', '2016-05-22 22:04:53');
INSERT INTO `replies` VALUES ('REPLIES201605220514', 'POST201605220500', null, 'SYSUSER201605050272', '', '这个是谁发的', '1', '2016-05-22 22:13:13', '西华大学', '2016-05-22 22:13:13', '2016-05-22 22:13:13');
INSERT INTO `replies` VALUES ('REPLIES201605220515', 'POST201605220500', null, 'SYSUSER201605050272', '', '张三是你呀', '1', '2016-05-22 22:13:30', '西华大学', '2016-05-22 22:13:30', '2016-05-22 22:13:30');
INSERT INTO `replies` VALUES ('REPLIES201605220521', 'POST201605220500', null, 'SYSUSER2016031305', 'http://192.168.31.219:8080/xhupubmedfiles/images/1463928237761349.jpg;', '贴上原图', '1', '2016-05-22 22:43:57', '西华大学', '2016-05-22 22:43:57', '2016-05-22 22:43:57');
INSERT INTO `replies` VALUES ('REPLIES201605270548', 'POST201605270547', null, 'SYSUSER2016031305', '', '来比赛啦', '1', '2016-05-27 22:18:36', '西华大学', '2016-05-27 22:18:36', '2016-05-27 22:18:36');
INSERT INTO `replies` VALUES ('REPLIES201605270550', 'POST201605270547', null, 'SYSUSER2016031305', '', '小王还没有来啊', '1', '2016-05-27 22:18:53', '西华大学', '2016-05-27 22:18:53', '2016-05-27 22:18:53');
INSERT INTO `replies` VALUES ('REPLIES201605270552', 'POST201605270547', null, 'SYSUSER2016031305', 'http://192.168.31.219:8080/xhupubmedfiles/images/1464359012818281.jpg;', '王鑫镇楼', '1', '2016-05-27 22:23:32', '西华大学', '2016-05-27 22:23:32', '2016-05-27 22:23:32');
INSERT INTO `replies` VALUES ('REPLIES201606020608', 'POST201606020607', null, 'SYSUSER2016031305', '', '好激动呀', '1', '2016-06-02 10:27:20', '西华大学', '2016-06-02 10:27:20', '2016-06-02 10:27:20');
INSERT INTO `replies` VALUES ('REPLIES201606020609', 'POST201606020607', null, 'SYSUSER2016031305', '', '汪鑫郑楼', '1', '2016-06-02 10:27:35', '西华大学', '2016-06-02 10:27:35', '2016-06-02 10:27:35');

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
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605040246', 'SCHOOL_PROFILE201605040244', '测试结果123', '测试', '1', '<script type=\"text/javascript\">\nfunction UrlSearch() \n{\n   var name,value; \n   var str=location.href; //取得整个地址栏\n   var num=str.indexOf(\"?\") \n   str=str.substr(num+1); //取得所有参数   stringvar.substr(start [, length ]\n\n   var arr=str.split(\"&\"); //各个参数放到数组里\n   for(var i=0;i < arr.length;i++){ \n    num=arr[i].indexOf(\"=\"); \n    if(num>0){ \n     name=arr[i].substring(0,num);\n     value=arr[i].substr(num+1);\n     this[name]=value;\n     } \n    } \n} \nvar Request=new UrlSearch(); //实例化', '法法师打发', '10', '1', '2016-05-04 23:28:57', '2016-05-21 20:10:45');
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605050247', 'SCHOOL_PROFILE201605040240', '软件工程最新考研信息', '软件工程考研', '1', '西华） 软件工程专业于2006年开始招生，现为西华大学特色专业。2014年成为四川省卓越工程师计划试点专业。迄今已有约10年的办学历史。目前在校生约600人。毕业学生广泛分别于国内外大型企业。 软件工程专业学生创新创业团队非常活跃，在学科竞赛中屡获佳绩。 软件工程专业优秀毕业生有推免研究生的资格。', '今年学校可以直接本硕连读哦', '10', '1', '2016-05-05 09:16:20', '2016-05-05 09:16:20');
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605050249', 'SCHOOL_PROFILE201605040240', '软件工程最好导师陈广贵', '软件工程考研导师', '1', '陈广贵，教授，博士，硕士生导师，四川省数学学会常务理事。主要从事函数逼近论和计算复杂性方面的研究，在“J.Complexity”、“Constructive Approximation ”、“J.Approximation Theory”、《中国科学》（英文版）、《数学学报》（英文版）、《自然科学进展》（英文版）、《应用数学学报》（英文版）等国内外期刊上发表论文十多篇，有5篇被SCI检索；多次作为主研人员参加国家自然科学基金项目，独自承担省教育厅青年基金项目和省科技厅重点项目各一项。', '今年学校可以直接本硕连读哦', '10', '1', '2016-05-05 09:19:49', '2016-05-05 09:19:49');
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605050251', 'SCHOOL_PROFILE201605040240', '软件工程最好导师刘克剑', '软件工程考研导师', '1', '姓名：刘克剑　性别：男　出生年月：1974年\n　　职称：副教授　学院：数学与计算机学院\n　　\n　　刘克剑，男，副教授，1974年出生，湖北随州人。1995年毕业于哈尔滨工业大学，获学士学位。1998年毕业于四川工业学院，获硕士学位。现任数计学院计算机系副主任，中共数计学院分党委委员，教工一支部支部书记。多次荣获西华大学优秀教师和优秀共产党员称号。\n\n　　研究方向：\n　　1．计算机网络和无线网络技术：P2P网络和云计算技术、网络协议、网络应用技术；\n　　2．智能信息处理技术：搜索引擎技术和信息发现技术；\n　　3．高性能计算技术、并行计算技术和分布式计算技术；\n　　4．Java EE和数据库技术；\n　　 \n　　已发表论文20余篇，其中多篇论文被SCI/EI检索。\n　　曾主持和参与的主要科研项目：基于领域本体的WEB语义爬行策略研究（国家自然科学基金项目，主研）；P2P网络复杂搜索技术的研究（四川省教育厅自然项目，主持）以及其它多项企业联合项目和纵向项目。\n　　Email：liukejian@gmail.com\n　　手机：138-8222-1442', '今年学校可以直接本硕连读哦', '10', '1', '2016-05-05 09:20:15', '2016-05-05 09:20:15');
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605050253', 'SCHOOL_PROFILE201605040240', '软件工程最好导师何明星', '软件工程考研导师', '1', '姓名：何明星　性别：男　出生年月：1964年\n　　职称：教授　学院：数学与计算机学院\n\n　　何明星，男，1964年出生，1990年于重庆大学获理学硕士学位，2003年于西南交通大学获工学博士学位，2002.08-2003.07留学德国，参加国际合作项目IQN的研究和开发。现为西华大学数学与计算机学院教授，副院长。四川省教学名师，四川省学术与技术带头人后备人选，四川省计算机学会常务理事，国家自然科学基金评议专家。国际密码学会会员。IEEE会员。中国密码学会高级会员。近10年主要在高校从事密码与信息安全方面的教学与科研工作。\n\n　　主要研究方向：现代密码算法、安全协议、密钥管理技术、无线网络安全技术、电子商务/电子政务安全技术、扩频序列设计在移动通信中的应用等。\n\n　　主持的科研项目有：国家自然科学基金项目2项；教育部重点科技项目1项；四川省科技厅重点项目1项；四川省科技厅国际合作项目1项；人事部（厅）科研项目2项；四川省教育厅项目1项。\n先后在Pattern Recognition、IEEE Transactions on Wireless Communications、International Journal of Network Security、Journal of Electronics、Lecture Notes in Computer Science、计算机学报、软件学报、电子学报、电子与信息学报、IWSDA01(IEEE)、InfoSecu2002 （ACM）、ISCTA01 (IEE)、ICCCAS2002（IEEE）、PDCAT03(IEEE)、IEEE CEC03等重要学术期刊和国际会议上发表论文50余篇, 其中30余篇被SCI、EI检索。还担任IEEE Communication Letters、电子学报、电子与信息学报等近10种国内外重要学术刊物审稿人。\n已培养硕士研究生20多名，在国内外高等院校、政府部门、IT企业就业或深造。\n\n　　联系电话：13882027553 \n\n　　Email：he_mingxing64@yahoo.com.cn', '今年学校可以直接本硕连读哦', '10', '1', '2016-05-05 09:20:41', '2016-05-05 09:20:41');
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605050255', 'SCHOOL_PROFILE201605040240', '软件工程最好导师宋文', '软件工程考研导师', '1', '一、本人情况：\n　　宋文，男，54岁，教授，硕士生导师。研究方向:Petri网理论及应用、计算理论。中国计算机学会高级会员，中国计算机学会Petri网专委会委员，四川省高性能计算学会理事，《软件学报》审稿人。在国家级、省级刊物上发表文章40余篇（其中14篇EI检索），出版专著3部。担任四川省科技厅、教育厅基础研究项目5项。\n\n　　二、方向介绍\n　　Carl Adam Petri是世界著名的计算机理论科学家。Petri网是以Petri的人名命名。Petri网是一种适用于多种系统的图形化、数学化建模工具，为描述和研究具有并行、异步、分布式和随机性等特征的信息加工系统提供了强有力的手段。已广泛应用于网络协议、人工智能、形式语义、操作系统、并行编译、数据管理、形式化软件开发等计算机学科的领域。\n\n　　三、对学生的基础要求\n生源可以是计算机专业（软件方向）、信息与计算科学、数学专业（代数、逻辑方向）\n\n　　四、毕业生走向\n　　大型的IT行业、国内外大学继续深造\n', '今年学校可以直接本硕连读哦', '10', '1', '2016-05-05 09:21:01', '2016-05-05 09:21:01');
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605050257', 'SCHOOL_PROFILE201605040240', '软件工程导师杜亚军', '软件工程考研导师', '1', '杜亚军，男，1967年出生，教授，硕士研究生导师，2005年西南交通大学计算机与通信学院博士毕业，获工学博士学位。第六批四川省学术和技术带头人后备人选，四川省工业与应用数学学会计算机分会理事，西华大学计算机软件研究所所长，全国搜索引擎与网上数据挖掘（SEWM）学术会议程序委员会会议委员、SEWM2010组织委员会主席。主持国家自然科学基金1项（在研），主持完成和在研省部级项目5项，主研完成国家部属八五、九五重点科技攻关项目4项，承担九五重点科技攻关项目三级子课题两项，并集体获得国土资源部（原地矿部）二等奖、集体获得四川省科技进步三等奖；主持研究纵向（计算机应用、数据库信息管理）项目20项。近年来，在《Applied Soft Computing》、《Journal of Computational Information Systems》、《Transactions on Computer and Information Technology》、《计算机应用》等刊物和LNCS/LNAI 国际会议公开刊物发表论文80篇，其中被SCI检索论文2篇，EI检索论文40余篇. 副主编本科教材2本，合作出版论著1本。学术成果也多次在国际会议上报告，受到同行专家的关注，论文多篇次被国外学者索要、引用。在《Applied Soft Computing》、《Information Processing & Mangment》等国际杂志长期担任审稿人。\n　　\n　　主要研究方向：\n　　1.Web数据挖掘与知识发现，包括Web服务与P2P网络；智能搜索引擎与智能网络；4.Web信息检索与评价；网格计算；基于语义的Web爬行策略。\n　　2.智能信息处理, 包括模糊语言值命题抽取与推理；信息系统中的属性约简与知识发现；基于模糊语言值知识的预测与决策；形式背景中的概念格生成。', '今年学校可以直接本硕连读哦', '10', '1', '2016-05-05 09:21:40', '2016-06-01 10:48:06');
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605050259', 'SCHOOL_PROFILE201605040240', '西华大学数学与计算机学院导师介绍：何承源', '考研导师', '1', '姓名：何承源　性别：男　出生年月：1961年6月\n　　职称：教授　学院：数学与计算机学院\n　　研究方向：矩阵理论与应用研究\n\n　　何承源，男，1961年6月生，教授，硕士生导师。现任西华大学教务处副处长。四川省学术和技术带头人后备人选。主要从事矩阵理论与应用研究。\n何承源教授曾经先后主持省教育厅青年教师科研基金一项、省教育厅重点项目基金三项。先后在《Chinese J.Num.Math.& Appl》、《系统科学与数学》、《应用数学学报》、《数值计算与计算机应用》、《高等学校计算数学学报》、《工程数学学报》、《高校应用数学学报》等刊物上发表论文40余篇。', '可以本硕连读哦', '10', '1', '2016-05-05 09:23:56', '2016-05-05 09:23:56');
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605050260', 'SCHOOL_PROFILE201605040240', '数学与计算机学院导师贾年', '考研导师', '1', '姓名：贾年　性别：男\n　　职称：教授　学院：数学与计算机学院\n　　研究方向：计算机网络、数据库、搜索引擎、图像处理等研究\n　　\n　　贾年，副教授，男，38岁，四川大学计算数学及应用软件专业理学学士，电子科技大学计算机应用技术专业工学硕士，1994年进入高校，至今从事教学、科研工作，主要从事计算机网络、数据库、搜索引擎、图像处理等研究，并长期从事计算机应用项目的开发。近5年来，作为项目负责人，从事的主要项目有：\n　　1、图像型大空间火灾探测及定位系统研制（四川省教育厅重点项目，项目负责人）\n　　2、北京工人体育馆自动灭火系统（北京2008奥运会项目，项目负责人）\n　　3、北京奥林匹克森林公园消防炮控制系统（北京2008奥运会项目，项目负责人）\n　　4、基于移动Agent的搜索引擎的研究（项目负责人）\n　　5、2007年世界遗产博览会主会场智能灭火系统（项目负责人）\n　　6、荷兰皇家帝斯曼（佛山）有限公司消防炮控制系统（项目负责人）\n　　7、数控消防炮网络控制系统研制（项目负责人）\n　　8、基于电话网络数据语音传真自动应答系统（项目负责人）\n　　9、美国迪皮埃复材构件（太仓）有限公司消防炮控制系统（项目负责人）\n　　10、沈阳飞机公司智能灭火系统（项目负责人）\n　　11、南京斯堪维北欧工业园区智能消防系统（项目负责人）\n　　12、无锡尚德太阳能有限公司消防炮控制系统（项目负责人）\n　　13、广州欧亚消防炮控制系统（项目负责人）\n　　14、武汉杂技厅消防炮控制系统（项目负责人）\n　　15、齐齐哈尔国际会展中心智能消防灭火系统（项目负责人）\n　　16、山东滕州体育中心智能灭火系统（项目负责人）\n　　17、苏州演艺中心消防炮控制系统（项目负责人）\n　　18、北京天文馆智能灭火系统（项目负责人）', '可以本硕连读哦', '10', '1', '2016-05-05 09:24:42', '2016-06-01 10:48:22');
INSERT INTO `school_information` VALUES ('SCHOOL_INFORMATION201605300585', 'SCHOOL_PROFILE201605210470', '测试结果001', '测试001', '1', '<script type=\"text/javascript\">\nfunction UrlSearch() \n{\n   var name,value; \n   var str=location.href; //取得整个地址栏\n   var num=str.indexOf(\"?\") \n   str=str.substr(num+1); //取得所有参数   stringvar.substr(start [, length ]\n\n   var arr=str.split(\"&\"); //各个参数放到数组里\n   for(var i=0;i < arr.length;i++){ \n    num=arr[i].indexOf(\"=\"); \n    if(num>0){ \n     name=arr[i].substring(0,num);\n     value=arr[i].substr(num+1);\n     this[name]=value;\n     } \n    } \n} \nvar Request=new UrlSearch(); //实例化', '法法师打发', '10', '4', '2016-05-30 21:43:58', '2016-05-30 21:44:51');

-- ----------------------------
-- Table structure for school_profile
-- ----------------------------
DROP TABLE IF EXISTS `school_profile`;
CREATE TABLE `school_profile` (
  `SCHOOL_PROFILE_CUID` varchar(100) NOT NULL COMMENT '考研学校CUID',
  `SCHOOL_PROFILE_NAME` varchar(300) DEFAULT NULL COMMENT '考研学校名称',
  `SCHOOL_PROFILE_IS_TOP` int(11) NOT NULL COMMENT '考研学校IS_TOP',
  `SCHOOL_PROFILE_TAG` varchar(100) DEFAULT NULL COMMENT '考研学校标签',
  `SCHOOL_PROFILE_CODE` varchar(50) DEFAULT NULL COMMENT '考研学校代码',
  `SCHOOL_PROFILE_SC_CREATE_TIME` datetime DEFAULT NULL COMMENT '考研学校创建时间',
  `SCHOOL_PROFILE_BASE_PROFILE` varchar(1000) DEFAULT NULL COMMENT '考研学校基本资料',
  `SCHOOL_PROFILE_MAIN_PROFILE` varchar(10000) DEFAULT NULL COMMENT '考研学校详细介绍',
  `SCHOOL_PROFILE_BEST_MAJOR` varchar(10000) DEFAULT NULL COMMENT '考研学校最好专业',
  `SCHOOL_PROFILE_BEST_TEACHER` mediumtext COMMENT '考研学校最好导师',
  `SCHOOL_PROFILE_STATE` int(11) NOT NULL COMMENT '考研学校状态',
  `SCHOOL_PROFILE_CREATE_TIME` datetime NOT NULL COMMENT '考研学校系统创建时间',
  `SCHOOL_PROFILE_UPDATE_TIME` datetime DEFAULT NULL COMMENT '考研学校系统更新时间',
  PRIMARY KEY (`SCHOOL_PROFILE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考研学校简介';

-- ----------------------------
-- Records of school_profile
-- ----------------------------
INSERT INTO `school_profile` VALUES ('SCHOOL_PROFILE201605040240', '西华大学', '10', '省属重点大学/公立大学', null, null, '西华大学（Xihua University），简称“西华”，是四川省属重点大学，是中西部高校基础能力建设工程(小211)试点高校之一，拥有博士后科研工作站。同时具有向全国推荐优秀应届本科毕业生免试攻读硕士研究生的资格。', '学校位于国家历史文化名城成都。截至2015年11月，学校拥有校本部、彭州校区和人南校区三个校区，校园总面积近3000亩。下设22个学院，开设80个本科专业。有12个一级学科硕士学位授权点，56个二级学科硕士学位授权点，3个专业硕士学位类别，12个工程硕士领域。有教授、副教授等高级专业技术职务人员800余名。以工为主，工、理、文、管、经、法、教、艺等多学科协调发展，现有全日制在校学生近4万人，研究生2000余人。学校面向全国28个省（市）招生，并招收空军国防生和乒乓球、健美操、跆拳道高水平运动队学生。[1] \n西华大学2016年在川招生新变化：43个专业纳入本科一批次录取。', '政治学院 　　1、思想政治教育　本科　学制四年　就读校区：校本部    西华大学经济与贸易学院 　　1、经济学　本科　学制四年　就读校区：校本部 　　专业方向1：投资与理财 　　专业方向2：流通经济学 　　2、国际经济与贸易　本科　学制四年 就读校区：校本部 　　3、电子商务　本科　学制四年　就读校区：校本部 　　4、保险学 本科 学制四年　就读校区：校本部 　　管理学院 　　1、工程管理　本科 学制四年　就读校区：校本部 　　2、工商管理　本科 学制四年　就读校区：校本部 　　3、会计学　本科　学制四年　就读校区：校本部 　　4、人力资源管理　本科　学制四年　就读校区：校本部 　　5、市场营销　本科　学制四年　就读校区：校本部 　　6、财务管理　本科　学制四年　就读校区：校本部 　　人文学院 　　1、汉语言文学　本科　学制四年　就读校区：校本部 　　专业方向1：汉语言文学 　　专业方向2：汉语言文学教育 　　专业方向3：公关文秘 　　2、法学　本科　学制四年　就读校区：校本部    西华大学3、历史学 本科　学制四年　就读校区：校本部 　　4、学前教育 本科　学制四年　就读校区：校本部 　　外国语学院 　　1、英语　本科　学制四年　就读校区：校本部 　　专业方向1：英语教育 　　专业方向2：商务英语 　　2、日语　本科　学制四年　就读校区：校本部 　　艺术学院 　　1、工业设计　本科　学制四年　就读校区：校本部 　　2、艺术设计　本科　学制四年　就读校区：校本部 　　专业方向1：视觉传达设计 　　专业方向2：环境艺术设计 　　3、美术学　本科　学制四年 就读校区：校本部 　　4、音乐学（非师范专业，四川省考生认可音乐学专业联考成绩，电脑音乐作曲、声乐、器乐、视唱练耳、应用和声与键盘等方向）　本科　学制四年　就读校区：校本部 　　5、舞蹈学（非师范专业）　本科　学制四年　就读校区：校本部 　　专业方向1：音乐舞蹈（非师范专业，四川省考生认可音乐舞蹈专业联考成绩） 　　专业方向2：舞蹈表演（非师范专业，四川省考生认可表演类的舞蹈表演专业联考成绩） 理科　　数学与计算机学院 　　1、计算机科学与技术　本科 学制四年　就读校区：校本部 　　专业方向１：计算机应用　 　　专业方向２：数字系统设计 　　专业方向３：网络工程与信息安全 　　2、软件工程　本科　学制四年　就读校区：校本部 　　3、信息与计算科学 本科　学制四年　就读校区：校本部 　　4、数学与应用数学 本科　学制四年　就读校区：校本部 　　物理与化学学院 　　1、应用物理学　本科　学制四年　就读校区：校本部 　　专业方向：光电技术 　　2、化学　本科　学制四年　就读校区：校本部 　　专业方向：应用化学 　　3、产品质量工程　本科　学制四年　就读校区：校本部 　　专业方向：质量检测与控制 　　材料科学与工程学院 　　1、材料科学与工程　本科　学制四年　就读校区：校本部 　　专业方向１：材料工程 　　专业方向２：电子材料与元器件 　　专业方向3：高分子材料工程 　　2、材料成型及控制工程　本科　学制四年　就读校区：校本部 　　专业方向1：模具设计与制造 　　专业方向2：铸造工艺及设备 　　专业方向3：焊接工艺及设备 　　专业方向4：塑性成形工艺及设备 　　机械工程与自动化学院 　　1、机械设计制造及其自动化　本科　学制四年 就读校区：校本部 　　专业方向１：制造工程 　　专业方向２：产品数字化设计 　　专业方向３：模具CAD/CAM 　　2、机械电子工程 本科　学制四年　就读校区：校本部 　　3、自动化　本科　学制四年　就读校区：校本部 　　专业方向１：工业测控技术 　　专业方向２：智能仪器仪表 　　4、工业工程　本科　学制四年　就读校区：校本部 　　专业方向１：生产系统工程 　　专业方向２：物流工程 　　5、工业设计　本科　学制四年　就读校区：校本部 　　能源与环境学院 　　1、热能与动力工程　本科　学制四年　就读校区：校本部 　　专业方向１：水力机械及工程 　　专业方向２：水利水电动力工程 　　2、水利水电工程　本科　学制四年　就读校区：校本部 　　3、建筑环境与设备工程　本科　学制四年　就读校区：校本部 　　专业方向１：智能建筑工程 　　专业方向２：供热通风与空调工程 　　4、给水排水工程　本科　学制四年　就读校区：校本部 　　5、环境工程　本科　学制四年　就读校区：校本部 　　电气信息学院 　　1、信息工程　本科　学制四年　就读校区：校本部 　　专业方向１：电子信息工程 　　专业方向２：通信工程 　　2、电气工程与自动化　本科　学制四年　就读校区：校本部 　　专业方向１：电力系统及其自动化 　　专业方向２：自动化 　　专业方向3：电气技术 　　3、测控技术与仪器　本科　学制四年　就读校区：校本部 　　建筑与土木工程学院 　　1、建筑学 本科 学制五年 就读校区：校本部 　　注：本专业需一定美术基础，入学后须加试素描，不合格者转入其它相关专业。 　　2、城市规划　本科　学制五年　就读校区：校本部 　　专业方向：城市规划、景观建筑设计 　　注：本专业需一定美术基础，入学后须加试素描，不合格者转入其它相关专业。 　　3、土木工程　本科　学制四年　就读校区：校本部 　　专业方向：建筑工程、交通土建 　　4、工程造价　本科　学制四年　就读校区：校本部 　　交通与汽车工程学院 　　1、车辆工程　本科　学制四年　就读校区：校本部 　　专业方向：汽车设计与制造、汽车电子技术、工程机械 　　2、热能与动力工程（汽车发动机）　本科　学制四年　就读校区：校本部 　　专业方向：汽车发动机 　　3、交通工程　本科　学制四年　就读校区：校本部 　　专业方向：道路工程、交通规划与控制 　　4、汽车服务工程　本科　学制四年　就读校区：校本部 　　专业方向：汽车服务工程 　　5、物流管理　本科　学制四年', '西华大学生物工程学院导师介绍：袁永俊\n西华大学生物工程学院导师介绍：向文良\n西华大学生物工程学院导师介绍：马力', '1', '2016-05-04 20:33:55', '2016-05-30 21:42:40');
INSERT INTO `school_profile` VALUES ('SCHOOL_PROFILE201605040243', '电子科技大学  University Of Electronic Science And Technology Of China', '10', '理工/公立大学', null, null, '电子科技大学（University of Electronic Science and Technology of China）简称电子科大，坐落于有“天府之国”之称的成都市，由中华人民共和国教育部直属，位列“211工程”、“985工程”，入选国家“2011计划”、“111计划”、“卓越工程师教育培养计划”，两电一邮成员，设有研究生院，是一所以电子信息科学技术为核心的全国重点大学，被誉为“中国电子类院校的排头兵”。', '电子科技大学原名成都电讯工程学院，是1956年在周恩来总理的亲自部署下，由交通大学（现上海交通大学、西安交通大学）、南京工学院（现东南大学）、华南工学院（现华南理工大学）的电讯工程有关专业合并创建而成。1960年，被中共中央列为全国重点高等学校；1961年，被中共中央确定为七所国防工业院校之一。1988年，更名为电子科技大学。1997年，被确定为国家首批“211工程”建设的重点大学。2000年，由原信息产业部主管划转为教育部主管。2001年，进入国家“985工程”重点建设大学行列。根据2016年4月学校官网显示，学校设有清水河、沙河、九里堤三个校区，占地面积5000余亩；设有24个学院（部），59个本科专业；有各类全日制在读学生33000余人，其中博士、硕士研究生12000余人；有教职工3800余人，其中专任教师2100余人，教授445人', '信息安全	信息安全	1	\n通信工程	通信工程	1	\n集成电路设计与集成系统	集成电路	1	\n电子科学与技术		2	\n电子信息工程		2	\n测控技术与仪器		3	\n计算机科学与技术		3	\n信息显示与光电技术		3	\n网络工程		4	\n电磁场与无线技术		4	\n数学与应用数学		6	\n软件工程	', '电子科技大学计算机科学与工程学院导师介绍：郭迅\n电子科技大学计算机科学与工程学院导师介绍：曾金全\n电子科技大学计算机科学与工程学院导师介绍：禹勇\n电子科技大学计算机科学与工程学院导师介绍：杨浩淼\n电子科技大学计算机科学与工程学院导师介绍：许春香', '1', '2016-05-04 20:37:58', null);
INSERT INTO `school_profile` VALUES ('SCHOOL_PROFILE201605040244', '四川大学 Sichuan University(scu)', '10', '综合/公立大学', null, null, '四川大学（Sichuan University），简称“川大”，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”，入选“2011计划”、“珠峰计划”、“111计划”、“卓越工程师教育培养计划”、“海外高层次人才引进计划”，设有研究生院，拥有研究生自主划线资格，是一所综合性全国重点大学。', '四川大学由原四川大学、原成都科学技术大学、原华西医科大学三所全国重点大学经过两次合并而成。原四川大学起始于1896年四川总督鹿传霖奉光绪特旨创办的四川中西学堂，是西南地区最早的近代高等学校；原成都科学技术大学是新中国院系调整时组建的第一批多科型工科院校；原华西医科大学源于1910年由西方基督教会组织在成都创办的华西协合大学，是西南地区最早的西式大学和中国最早培养研究生的大学之一。1994年，原四川大学和原成都科技大学合并为四川联合大学，1998年更名为四川大学。2000年，四川大学与原华西医科大学合并，组建了新的四川大学。\n四川大学承文翁之教，聚群贤英才。百余年来，学校先后汇聚了历史学家顾颉刚、文学家李劼人、美学家朱光潜、物理学家吴大猷、植物学家方文培、卫生学家陈志潜、数学家柯召等大师。历史上，吴玉章、张澜曾执掌校务，共和国开国元勋朱德、共和国主席杨尚昆、文坛巨匠郭沫若、人民作家巴金、一代英烈江竹筠（江姐）等曾在川大求学。两院院士中，有50余位是川大校友；2001年评选的近代50位“四川文化名人”中，有36人是川大校友。[1] ', '口腔医学:第1名 \n宗教学:第1名\n法医学:第1名\n皮革化学与工程：第1名 \n对外汉语:第2名\n营养与食品卫生学:第2名\n光学:第3名\n原子与分子物理:第3名\n轻化工程:第3名 \n专门史：第3名\n博物馆学:第3名\n生物医学工程:第3名\n水文与水资源工程:第3名 \n劳动卫生与环境卫生学:第3名\n生物工程:第4名 \n基础医学:第4名 \n预防医学:第4名 \n精神病与精神卫生学:第4名\n卫生毒理学:第4名\n药剂学:第4名\n考古学:第5名 \n历史地理学：第5名\n史学理论及史学史:第5名\n历史文献学：:第5名\n中国古典文献学:第5名\n中国语言文学：第5名\n应用数学:第5名\n核科学与核技术：第5名\n材料化学:第5名 \n水利水电工程:第5名 \n编辑出版学:第5名\n诉讼法学:第5名\n病原生物学:第5名\n比较文学与世界文学:第6名\n基础数学:第6名\n运筹学与控制论:第6名\n公共事业管理:第6名\n无机非金属材料工程:第6名\n材料学:第6名\n化工过程机械:第6名\n药学:第6名 \n妇产科学:第6名\n传媒学：第7名\n金属材料工程:第7名 \n广播电视新闻学:第7名 \n企业管理学:第7名\n免疫学:第7名\n航空、航天与航海医学:第7名\n中国少数民族语言文学:第8名\n护理学:第8名 \n制药工程:第8名 \n有机化学:第8名\n高分子材料与工程:第8名\n材料物理:第8名\n等离子体物理:第8名\n文艺学:第9名\n光信息科学与技术:第9名 \n土地资源管理:第9名\n病理学与病理生理学:第9名\n外科学:第9名\n临床医学：第10名\n生态学:第10名 \n微电子学:第10名\n光学工程：第10名\n图书馆学:第10名 \n英语语言文学:第10名\n水排水工程:第11名\n管理科学:第11名\n人力资源管理:第1名\n电子信息科学与技术:第12名 \n生物技术: 第12名\n化学: 第12名\n化学工程与工艺:第12名\n水生生物学:第12名\n生物科学: 第13名\n植物学:第13名\n广告学:第13名\n财务管理:第13名\n档案学:第13名\n服装设计与工程:第14名\n绘画:第14名 \n纺织工程:第15名\n旅游管理:第15名', '四川大学经济学院导师介绍:周俊\n四川大学经济学院导师介绍:朱莉\n四川大学经济学院导师介绍:邹瑾\n四川大学经济学院导师介绍:赵智\n四川大学商学院会计学导师介绍：尹昌列', '1', '2016-05-04 20:40:14', null);
INSERT INTO `school_profile` VALUES ('SCHOOL_PROFILE201605210470', '复旦大学 编辑 Fudan University', '10', '中国高校 985工程', null, null, '复旦大学（Fudan University），简称“复旦”，位于首批沿海开放城市上海市，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”，入选“珠峰计划”、“111计划”、“2011计划”、“卓越医生教育培养计划”，为“九校联盟”成员、东亚研究型大学协会成员、环太平洋大学协会成员、21世纪大学协会成员，是一所综合性研究型的全国重点大学。', '复旦大学由原复旦大学、原上海医科大学合并而成。复旦大学创建于1905年，原名复旦公学，是中国人自主创办的第一所高等院校，创始人为中国近代知名教育家马相伯，首任校董为国父孙中山先生。校名“复旦”二字选自《尚书大传·虞夏传》中“日月光华，旦复旦兮”的名句，意在自强不息，寄托当时中国知识分子自主办学、教育强国的希望。1917年复旦公学改名为私立复旦大学；1937年抗战爆发后，学校内迁重庆北碚，并于1941年改为“国立”；1946年迁回上海江湾原址；1952年全国高等学校院系调整后，复旦大学成为以文理科为基础的综合性大学；1959年成为全国重点大学。2000年，与原上海医科大学合并成立新的复旦大学。\n复旦师生谨记“博学而笃志，切问而近思”的校训，严守“文明、健康、团结、奋发”的校风，力行“刻苦、严谨、求实、创新”的学风，发场“爱国奉献、学术独立、海纳百川、追求卓越”的复旦精神，以服务国家为己任，以培养人才为根本，以改革开放为动力，为实现中国梦作出新贡献。[1] ', '口腔医学:第1名 \n宗教学:第1名\n法医学:第1名\n皮革化学与工程：第1名 \n对外汉语:第2名\n营养与食品卫生学:第2名\n光学:第3名\n原子与分子物理:第3名\n轻化工程:第3名 \n专门史：第3名\n博物馆学:第3名\n生物医学工程:第3名\n水文与水资源工程:第3名 \n劳动卫生与环境卫生学:第3名\n生物工程:第4名 \n基础医学:第4名 \n预防医学:第4名 \n精神病与精神卫生学:第4名\n卫生毒理学:第4名\n药剂学:第4名\n考古学:第5名 \n历史地理学：第5名\n史学理论及史学史:第5名\n历史文献学：:第5名\n中国古典文献学:第5名\n中国语言文学：第5名\n应用数学:第5名\n核科学与核技术：第5名\n材料化学:第5名 \n水利水电工程:第5名 \n编辑出版学:第5名\n诉讼法学:第5名\n病原生物学:第5名\n比较文学与世界文学:第6名\n基础数学:第6名\n运筹学与控制论:第6名\n公共事业管理:第6名\n无机非金属材料工程:第6名\n材料学:第6名\n化工过程机械:第6名\n药学:第6名 \n妇产科学:第6名\n传媒学：第7名\n金属材料工程:第7名 \n广播电视新闻学:第7名 \n企业管理学:第7名\n免疫学:第7名\n航空、航天与航海医学:第7名\n中国少数民族语言文学:第8名\n护理学:第8名 \n制药工程:第8名 \n有机化学:第8名\n高分子材料与工程:第8名\n材料物理:第8名\n等离子体物理:第8名\n文艺学:第9名\n光信息科学与技术:第9名 \n土地资源管理:第9名\n病理学与病理生理学:第9名\n外科学:第9名\n临床医学：第10名\n生态学:第10名 \n微电子学:第10名\n光学工程：第10名\n图书馆学:第10名 \n英语语言文学:第10名\n水排水工程:第11名\n管理科学:第11名\n人力资源管理:第1名\n电子信息科学与技术:第12名 \n生物技术: 第12名\n化学: 第12名\n化学工程与工艺:第12名\n水生生物学:第12名\n生物科学: 第13名\n植物学:第13名\n广告学:第13名\n财务管理:第13名\n档案学:第13名\n服装设计与工程:第14名\n绘画:第14名 \n纺织工程:第15名\n旅游管理:第15名', '中国科学院院士\n院士姓名	类 别	院士姓名	类 别	院士姓名	类 别	院士姓名	类 别\n干福熹	兼职	郝柏林	专职	安芷生	兼职	杨雄里	专职\n胡和生	专职	杨福家	专职	沈学础	兼职	李大潜	专职\n沈自尹	专职	陆汝钤	兼职	王迅	专职	陈凯先	兼职\n贺福初	兼职	黄春辉	兼职	林国强	兼职	杨玉良	专职\n洪家兴	专职	陶瑞宝	专职	赵国屏	兼职	彭实戈	兼职\n江明	专职	王正敏	专职	麻生明	专职	赵东元	专职\n许宁生	专职	包信和	专职\n　　	葛均波	专职\n　　	金亚秋	专职\n孙鑫	专职\n　　	陈恕行	专职\n　　	金力	专职\n　　', '1', '2016-05-21 18:14:41', null);

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
INSERT INTO `sys_user` VALUES ('SYSUSER2016031305', null, '发抖的小喵喵', '胡志辉', 'huzhihui', '123456', '2', 'huzhihui_c@qq.com', '0', '0', '18380461811', null, 'http://192.168.31.219:8080/xhupubmedfiles/images/1463407089262146.jpg', null, '西华大学', '软件工程', '清华大学', '软件工程', null, '西华大学11舍B204', null, '1', '2016-03-13 19:06:12', null);
INSERT INTO `sys_user` VALUES ('SYSUSER2016031306', null, null, null, '', '12312141241231231231231244324234432131', '2', '', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-03-13 19:08:19', '2016-05-09 16:44:58');
INSERT INTO `sys_user` VALUES ('SYSUSER2016032607', null, null, null, 'chenqiaoqiao', '123456', '2', '1245226827@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-03-26 20:50:04', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201604150102', null, null, null, 'lambor', '123456', '2', '314753899@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-04-15 22:22:55', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201604160117', null, null, null, 'huzhihui001', '123456', '2', '742032660@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-04-16 09:57:47', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605050272', null, '张三昵称', '张三', '张三测试用户', '123456', '2', '123@qq.com', '0', '0', '18380461811', null, 'http://192.168.31.219:8080/xhupubmedfiles/images/1463926367010724.jpg', null, '计算机与软件工程学院', '软件工程', '四川大学', '软件工程', null, '西华大学', null, '1', '2016-05-05 12:19:26', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605050273', null, 'Admin', '胡志辉', '胡志辉', '123456', '1', '742032660@qq.com', '0', '0', '18380461811', null, null, null, null, null, null, null, null, '西华大学', null, '1', '2016-05-09 17:18:30', '2016-05-30 21:35:14');
INSERT INTO `sys_user` VALUES ('SYSUSER201605050274', null, '超级管理员', '超级管理员', 'superadmin', '123456', '1', '43242@qq.com', null, null, '18342342222', null, null, null, null, null, null, null, null, '西华大学', null, '1', '2016-05-09 21:46:41', '2016-05-09 21:49:30');
INSERT INTO `sys_user` VALUES ('SYSUSER201605090334', null, null, '测试管理员', 'testAdmin', '123456', '1', 'ferewr@qq.com', '0', '0', '312421231', null, null, null, null, null, null, null, null, '西华大学', null, '1', '2016-05-09 22:06:25', '2016-05-09 22:09:59');
INSERT INTO `sys_user` VALUES ('SYSUSER201605100339', null, 'wx', '汪鑫', 'wangxin', '123456', '2', 'wx@mail.com', '0', '0', '17828051573', null, null, null, '计算机与软件工程', '软件工程', null, null, null, '四舍611', null, '1', '2016-05-10 14:37:36', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605100368', null, '杨森', '杨森', 'yangseng', '123456', '2', 'hdhfhfh@qq.com', '0', '0', '18380465231', null, null, null, '计算机与软件工程', '软件工程', '很多很多很好', 'u很多很多话', null, '4舍', null, '1', '2016-05-10 15:02:41', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605100381', null, null, null, 'rewrw', '123456', '2', '42342@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-05-10 15:11:30', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605100383', null, null, null, 'rwerwerw', '123456', '2', '2342@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-05-10 15:16:27', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605100384', null, null, null, 'ewr', '123456', '2', '732321@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-05-10 15:19:55', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605100385', null, null, null, 'rwerw', '123456', '2', '42423@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-05-10 15:20:15', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605100388', null, null, null, 'hur', '123456', '2', 'jdjf@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-05-10 15:26:50', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605100389', null, null, null, '12312', '123456', '2', '31231@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-05-10 15:28:49', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605100390', null, null, null, 'ufufj', '123456', '2', 'jdjj@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-05-10 15:34:31', null);
INSERT INTO `sys_user` VALUES ('SYSUSER201605100391', null, null, null, '123123', '123456', '2', '31ds231@qq.com', '0', '0', null, null, null, null, null, null, null, null, null, null, null, '1', '2016-05-10 15:38:06', '2016-05-30 21:34:40');
INSERT INTO `sys_user` VALUES ('SYSUSER201605300581', null, null, '超级管理员001', '超级管理员001', '123456', '1', '4324232@qq.com', '0', '0', '18342342222', null, null, null, null, null, null, null, null, '西华大学', null, '4', '2016-05-30 21:24:09', '2016-05-30 21:35:22');
