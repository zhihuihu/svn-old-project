/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : totop

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-29 17:11:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for global_table
-- ----------------------------
DROP TABLE IF EXISTS `global_table`;
CREATE TABLE `global_table` (
  `GLOBAL_TABLE_CUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '全局表CUID',
  `GLOBAL_TABLE_TABLE_NAME` varchar(50) DEFAULT NULL COMMENT '全局表对应创建表名称',
  `GLOBAL_TABLE_NOTES` varchar(50) DEFAULT NULL COMMENT '全局表创建注释',
  `GLOBAL_TABLE_CREATE_TIME` datetime DEFAULT NULL COMMENT '全局表创建时间',
  PRIMARY KEY (`GLOBAL_TABLE_CUID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='全局CUID表';

-- ----------------------------
-- Records of global_table
-- ----------------------------
INSERT INTO `global_table` VALUES ('1', 'SYS_USER', '主键插入', '2016-04-07 00:00:00');
INSERT INTO `global_table` VALUES ('2', 'SYS_USER', '主键插入', '2016-04-25 00:00:00');
INSERT INTO `global_table` VALUES ('3', 'SYS_USER', '主键插入', '2016-04-25 00:00:00');
INSERT INTO `global_table` VALUES ('4', 'SYS_USER', '主键插入', '2016-04-25 00:00:00');
INSERT INTO `global_table` VALUES ('5', 'INDEX_PAGE', '主键插入', '2016-04-25 00:00:00');
INSERT INTO `global_table` VALUES ('6', 'INDEX_PAGE', '主键插入', '2016-04-25 00:00:00');
INSERT INTO `global_table` VALUES ('7', 'INDEX_PAGE', '主键插入', '2016-04-25 00:00:00');
INSERT INTO `global_table` VALUES ('8', 'INDEX_PAGE', '主键插入', '2016-04-25 00:00:00');
INSERT INTO `global_table` VALUES ('9', 'INDEX_PAGE', '主键插入', '2016-04-25 00:00:00');
INSERT INTO `global_table` VALUES ('10', 'INDEX_PAGE', '主键插入', '2016-04-25 00:00:00');
INSERT INTO `global_table` VALUES ('11', 'MINGPINHUI', '主键插入', '2016-04-29 00:00:00');
INSERT INTO `global_table` VALUES ('12', 'MINGPINHUI', '主键插入', '2016-04-29 00:00:00');
INSERT INTO `global_table` VALUES ('13', 'PING_LIFE', '主键插入', '2016-04-29 00:00:00');
INSERT INTO `global_table` VALUES ('14', 'PING_LIFE', '主键插入', '2016-04-29 00:00:00');
INSERT INTO `global_table` VALUES ('15', 'PING_LIFE', '主键插入', '2016-04-29 00:00:00');
INSERT INTO `global_table` VALUES ('16', 'PING_LIFE', '主键插入', '2016-04-29 00:00:00');
INSERT INTO `global_table` VALUES ('18', 'PING_LIFE', '主键插入', '2016-04-29 00:00:00');
INSERT INTO `global_table` VALUES ('19', 'PING_LIFE', '主键插入', '2016-04-29 00:00:00');
INSERT INTO `global_table` VALUES ('20', 'PING_LIFE', '主键插入', '2016-04-29 00:00:00');
INSERT INTO `global_table` VALUES ('22', 'RICH_TEXT', '主键插入', '2016-04-29 00:00:00');

-- ----------------------------
-- Table structure for index_page
-- ----------------------------
DROP TABLE IF EXISTS `index_page`;
CREATE TABLE `index_page` (
  `INDEX_PAGE_CUID` varchar(50) NOT NULL COMMENT '主页表CUID',
  `INDEX_PAGE_IMAGE_URL` varchar(200) DEFAULT NULL COMMENT '主页表图片URL',
  `INDEX_PAGE_IMAGE_NOTES` varchar(200) DEFAULT NULL COMMENT '主页表图片提示',
  `INDEX_PAGE_SUB_CONTENT` varchar(200) DEFAULT NULL COMMENT '主页表图片后续文字',
  `INDEX_PAGE_TO_URL` varchar(100) DEFAULT NULL COMMENT '主页表跳转链接(待用)',
  `INDEX_PAGE_TITLE_NAME` varchar(200) DEFAULT NULL COMMENT '主页表介绍标题',
  `INDEX_PAGE_MAIN_CONTENT` mediumtext COMMENT '主页表介绍主要内容',
  `INDEX_PAGE_TYPE` int(11) NOT NULL COMMENT '主页表对应内容类型(1:4张主图;2:公司介绍;3:介绍旁图片;4:最下面三张图片)',
  `INDEX_PAGE_STATE` int(11) DEFAULT NULL COMMENT '主页表状态',
  `INDEX_PAGE_CREATE_TIME` datetime NOT NULL COMMENT '主页表创建时间',
  `INDEX_PAGE_UPDATE_TIME` datetime DEFAULT NULL COMMENT '主页表更新时间',
  PRIMARY KEY (`INDEX_PAGE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主页表';

-- ----------------------------
-- Records of index_page
-- ----------------------------
INSERT INTO `index_page` VALUES ('INDEX_PAGE2016042510', 'http://localhost:8080/totopImages/1461900110707930.jpg', null, null, null, null, null, '1', '0', '2016-04-25 16:43:42', '2016-04-29 11:21:50');
INSERT INTO `index_page` VALUES ('INDEX_PAGE201604259', 'http://localhost:8080/totopImages/1461573673904714.jpg', null, null, null, null, null, '1', '0', '2016-04-25 16:41:13', '2016-04-25 16:41:13');

-- ----------------------------
-- Table structure for mingpinhui
-- ----------------------------
DROP TABLE IF EXISTS `mingpinhui`;
CREATE TABLE `mingpinhui` (
  `MINGPINTHUI_CUID` varchar(50) NOT NULL COMMENT '名品汇CUID',
  `MINGPINTHUI_NAME` varchar(100) DEFAULT NULL COMMENT '名品汇名称',
  `MINGPINTHUI_TITLE` varchar(100) DEFAULT NULL COMMENT '名品汇标题',
  `MINGPINTHUI_THUMB_URL` varchar(200) DEFAULT NULL COMMENT '名品汇缩略图标',
  `MINGPINTHUI_MAIN_CONTENT` varchar(1024) DEFAULT NULL COMMENT '名品汇主要文字',
  `MINGPINTHUI_MAIN_IMAGE_URL1` varchar(200) DEFAULT NULL COMMENT '名品汇主图1',
  `MINGPINTHUI_MAIN_IMAGE_URL2` varchar(200) DEFAULT NULL COMMENT '名品汇主图2',
  `MINGPINTHUI_MAIN_IMAGE_URL3` varchar(200) DEFAULT NULL COMMENT '名品汇主图3',
  `MINGPINTHUI_MAIN_IMAGE_URL4` varchar(200) DEFAULT NULL COMMENT '名品汇主图4',
  `MINGPINTHUI_MAIN_IMAGE_URL5` varchar(200) DEFAULT NULL COMMENT '名品汇主图5',
  `MINGPINTHUI_STATE` int(11) DEFAULT NULL COMMENT '名品汇状态',
  `MINGPINTHUI_CREATE_TIME` datetime NOT NULL COMMENT '名品汇创建时间',
  `MINGPINTHUI_UPDATE_TIME` datetime DEFAULT NULL COMMENT '名品汇更新时间',
  PRIMARY KEY (`MINGPINTHUI_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='名品汇';

-- ----------------------------
-- Records of mingpinhui
-- ----------------------------
INSERT INTO `mingpinhui` VALUES ('MINGPINHUI2016042912', null, null, 'http://localhost:8080/totopImages/1461908322912890.jpg', null, '', null, null, null, null, '0', '2016-04-29 13:38:42', null);

-- ----------------------------
-- Table structure for ping_life
-- ----------------------------
DROP TABLE IF EXISTS `ping_life`;
CREATE TABLE `ping_life` (
  `PING_LIFE_CUID` varchar(50) NOT NULL COMMENT '品生活CUID',
  `PING_LIFE_MAIN_URL` varchar(200) DEFAULT NULL COMMENT '品生活主图URL',
  `PING_LIFE_MAIN_NOTES` varchar(200) DEFAULT NULL COMMENT '品生活主图提示',
  `PING_LIFE_CATEGORY` varchar(100) DEFAULT NULL COMMENT '品生活类别名称',
  `PING_LIFE_CATEGORY_CODE` varchar(50) DEFAULT NULL COMMENT '品生活类别编码',
  `PING_LIFE_TITLE_NAME` varchar(100) DEFAULT NULL COMMENT '品生活小标题名称',
  `PING_LIFE_TYPE` int(11) NOT NULL COMMENT '品生活类型(1:主图两张2:健康生活3:品味人生)',
  `PING_LIFE_STATE` int(11) DEFAULT NULL COMMENT '品生活状态',
  `PING_LIFE_CREATE_TIME` datetime NOT NULL COMMENT '品生活创建时间',
  `PING_LIFE_UPDATE_TIME` datetime DEFAULT NULL COMMENT '品生活更新时间',
  PRIMARY KEY (`PING_LIFE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品生活';

-- ----------------------------
-- Records of ping_life
-- ----------------------------
INSERT INTO `ping_life` VALUES ('PING_LIFE2016042914', 'http://localhost:8080/totopImages/1461914617890881.jpg', null, null, null, null, '1', '0', '2016-04-29 15:23:37', null);
INSERT INTO `ping_life` VALUES ('PING_LIFE2016042915', 'http://localhost:8080/totopImages/1461914619863907.jpg', null, null, null, null, '1', '0', '2016-04-29 15:23:39', null);
INSERT INTO `ping_life` VALUES ('PING_LIFE2016042916', 'http://localhost:8080/totopImages/1461914752157878.jpg', null, null, null, null, '1', '0', '2016-04-29 15:25:52', null);
INSERT INTO `ping_life` VALUES ('PING_LIFE2016042918', null, null, '健康生活', 'JKSH', '测试标题', '2', '0', '2016-04-29 16:55:04', null);
INSERT INTO `ping_life` VALUES ('PING_LIFE2016042919', null, null, '健康生活', 'JKSH', '测试标题', '2', '0', '2016-04-29 16:55:06', null);
INSERT INTO `ping_life` VALUES ('PING_LIFE2016042920', null, null, '健康生活', 'JKSH', '测试标题33', '2', '0', '2016-04-29 16:58:29', null);

-- ----------------------------
-- Table structure for rich_text
-- ----------------------------
DROP TABLE IF EXISTS `rich_text`;
CREATE TABLE `rich_text` (
  `RICH_TEXT_CUID` varchar(50) NOT NULL COMMENT '富文本内容CUID',
  `PING_LIFE_CUID` varchar(50) DEFAULT NULL COMMENT '品生活CUID',
  `RICH_TEXT_THUMB_URL` varchar(200) DEFAULT NULL COMMENT '富文本内容缩略图',
  `RICH_TEXT_TITLE` varchar(100) DEFAULT NULL COMMENT '富文本内容标题',
  `RICH_TEXT_CONTENT` mediumtext COMMENT '富文本内容主要内容',
  `RICH_TEXT_STATE` int(11) DEFAULT NULL COMMENT '富文本内容状态',
  `RICH_TEXT_CREATE_TIME` datetime NOT NULL COMMENT '富文本内容创建时间',
  `RICH_TEXT_UPDATE_TIME` datetime DEFAULT NULL COMMENT '富文本内容更新时间',
  PRIMARY KEY (`RICH_TEXT_CUID`),
  KEY `FK_Relationship_1` (`PING_LIFE_CUID`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`PING_LIFE_CUID`) REFERENCES `ping_life` (`PING_LIFE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='富文本内容';

-- ----------------------------
-- Records of rich_text
-- ----------------------------
INSERT INTO `rich_text` VALUES ('RICH_TEXT2016042922', 'PING_LIFE2016042920', null, null, '健康生活dfgsdfgsdfgdsfgdfsgdfgdfgdfgsdfgdsgfsadfasdjasdlfjasdlkfjlkasdjflkasjflksadjfl', '0', '2016-04-29 17:07:57', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `SYS_USER_CUID` varchar(50) NOT NULL COMMENT '系统用户CUID',
  `SYS_USER_LOGIN_NAME` varchar(100) DEFAULT NULL COMMENT '系统用户登录名',
  `SYS_USER_REL_NAME` varchar(100) DEFAULT NULL COMMENT '系统用户真实姓名',
  `SYS_USER_PASSWORD` varchar(100) DEFAULT NULL COMMENT '系统用户登录密码',
  `SYS_USER_TELE` varchar(20) DEFAULT NULL COMMENT '系统用户电话',
  `SYS_USER_ADDRESS` varchar(100) DEFAULT NULL COMMENT '系统用户地址',
  `SYS_USER_STATE` int(11) DEFAULT NULL COMMENT '系统用户状态',
  `SYS_USER_CREATE_TIME` datetime NOT NULL COMMENT '系统用户创建时间',
  `SYS_USER_UPDATE_TIME` datetime DEFAULT NULL COMMENT '系统用户更新时间',
  PRIMARY KEY (`SYS_USER_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('SYS_USER201604252', 'admin', null, '123456', null, 'cds', '0', '2016-04-25 13:27:01', '2016-04-26 16:30:41');

-- ----------------------------
-- Function structure for SELECT_INDEX_PAGE_CUID
-- ----------------------------
DROP FUNCTION IF EXISTS `SELECT_INDEX_PAGE_CUID`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SELECT_INDEX_PAGE_CUID`() RETURNS varchar(255) CHARSET utf8
BEGIN
	#Routine body goes here...
	DECLARE CUID VARCHAR(255);
	INSERT INTO global_table VALUES('','INDEX_PAGE','主键插入',(SELECT CURDATE()));
SET CUID = CONCAT(
	'INDEX_PAGE',
	DATE_FORMAT(NOW(), '%Y%m%d'),
	(SELECT
		LAST_INSERT_ID())
);
	RETURN CUID;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SELECT_MINGPINGHUI_CUID
-- ----------------------------
DROP FUNCTION IF EXISTS `SELECT_MINGPINGHUI_CUID`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SELECT_MINGPINGHUI_CUID`() RETURNS varchar(255) CHARSET utf8
BEGIN
	#Routine body goes here...
	DECLARE CUID VARCHAR(255);
	INSERT INTO global_table VALUES('','MINGPINHUI','主键插入',(SELECT CURDATE()));
SET CUID = CONCAT(
	'MINGPINHUI',
	DATE_FORMAT(NOW(), '%Y%m%d'),
	(SELECT
		LAST_INSERT_ID())
);
	RETURN CUID;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SELECT_PING_LIFE_CUID
-- ----------------------------
DROP FUNCTION IF EXISTS `SELECT_PING_LIFE_CUID`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SELECT_PING_LIFE_CUID`() RETURNS varchar(255) CHARSET utf8
BEGIN
	#Routine body goes here...
	DECLARE CUID VARCHAR(255);
	INSERT INTO global_table VALUES('','PING_LIFE','主键插入',(SELECT CURDATE()));
SET CUID = CONCAT(
	'PING_LIFE',
	DATE_FORMAT(NOW(), '%Y%m%d'),
	(SELECT
		LAST_INSERT_ID())
);
	RETURN CUID;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SELECT_RICH_TEXT_CUID
-- ----------------------------
DROP FUNCTION IF EXISTS `SELECT_RICH_TEXT_CUID`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SELECT_RICH_TEXT_CUID`() RETURNS varchar(255) CHARSET utf8
BEGIN
	#Routine body goes here...
	DECLARE CUID VARCHAR(255);
	INSERT INTO global_table VALUES('','RICH_TEXT','主键插入',(SELECT CURDATE()));
SET CUID = CONCAT(
	'RICH_TEXT',
	DATE_FORMAT(NOW(), '%Y%m%d'),
	(SELECT
		LAST_INSERT_ID())
);
	RETURN CUID;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SELECT_SYS_USER_CUID
-- ----------------------------
DROP FUNCTION IF EXISTS `SELECT_SYS_USER_CUID`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SELECT_SYS_USER_CUID`() RETURNS varchar(255) CHARSET utf8
BEGIN
	#Routine body goes here...
	DECLARE CUID VARCHAR(255);
	INSERT INTO global_table VALUES('','SYS_USER','主键插入',(SELECT CURDATE()));
SET CUID = CONCAT(
	'SYS_USER',
	DATE_FORMAT(NOW(), '%Y%m%d'),
	(SELECT
		LAST_INSERT_ID())
);
	RETURN CUID;
END
;;
DELIMITER ;
