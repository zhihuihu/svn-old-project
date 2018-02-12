/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : photocms

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-07-06 21:40:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data_type
-- ----------------------------
DROP TABLE IF EXISTS `data_type`;
CREATE TABLE `data_type` (
  `DATA_TYPE_CUID` varchar(255) NOT NULL,
  `DATA_TYPE_NAME` varchar(100) DEFAULT NULL,
  `DATA_TYPE_CODE` varchar(100) DEFAULT NULL,
  `DATA_TYPE_CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DATA_TYPE_TOTAL_NUMBER` int(11) DEFAULT NULL,
  PRIMARY KEY (`DATA_TYPE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_type
-- ----------------------------
INSERT INTO `data_type` VALUES ('DATATYPE_20160203004', '图片类型', 'IMG', '2016-02-03 10:52:56', '0');
INSERT INTO `data_type` VALUES ('DATATYPE_20160203005', '视频类型', 'VIDEO', '2016-02-03 11:15:35', '0');
INSERT INTO `data_type` VALUES ('DATATYPE_201602190039', '文件类型', 'FILE', '2016-02-19 15:58:59', '2');
INSERT INTO `data_type` VALUES ('测试', null, null, '2016-03-05 16:27:20', '0');

-- ----------------------------
-- Table structure for global_id
-- ----------------------------
DROP TABLE IF EXISTS `global_id`;
CREATE TABLE `global_id` (
  `GLOBAL_CUID` int(11) NOT NULL AUTO_INCREMENT,
  `GLOBAL_TABLE_NAME` varchar(255) DEFAULT NULL,
  `GLOBAL_NOTES` varchar(255) DEFAULT NULL,
  `GLOBAL_CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`GLOBAL_CUID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of global_id
-- ----------------------------
INSERT INTO `global_id` VALUES ('1', 'GLOBAL_ID', '测试插入', '2016-02-02 17:46:17');
INSERT INTO `global_id` VALUES ('2', 'USER_TYPE', '用户类型表插入', '2016-02-02 22:00:51');
INSERT INTO `global_id` VALUES ('3', 'SYS_USER', '用户插入', '2016-02-03 10:26:54');
INSERT INTO `global_id` VALUES ('4', 'DATATYPE', '数据类型表插入', '2016-02-03 10:52:57');
INSERT INTO `global_id` VALUES ('6', 'SPECIAL_TYPE', '专辑类型大标签', '2016-02-03 11:16:59');
INSERT INTO `global_id` VALUES ('7', 'SPECIAL', '专辑添加', '2016-02-03 11:45:37');
INSERT INTO `global_id` VALUES ('11', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-03 12:16:02');
INSERT INTO `global_id` VALUES ('18', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 20:46:11');
INSERT INTO `global_id` VALUES ('19', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 20:46:11');
INSERT INTO `global_id` VALUES ('20', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 20:46:11');
INSERT INTO `global_id` VALUES ('21', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 20:49:21');
INSERT INTO `global_id` VALUES ('22', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 20:49:21');
INSERT INTO `global_id` VALUES ('23', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 20:49:21');
INSERT INTO `global_id` VALUES ('24', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 20:59:37');
INSERT INTO `global_id` VALUES ('25', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 20:59:37');
INSERT INTO `global_id` VALUES ('26', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 20:59:37');
INSERT INTO `global_id` VALUES ('30', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 21:34:59');
INSERT INTO `global_id` VALUES ('31', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 21:34:59');
INSERT INTO `global_id` VALUES ('32', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 21:34:59');
INSERT INTO `global_id` VALUES ('33', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 21:36:16');
INSERT INTO `global_id` VALUES ('34', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 21:36:16');
INSERT INTO `global_id` VALUES ('35', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 21:36:16');
INSERT INTO `global_id` VALUES ('36', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 21:54:35');
INSERT INTO `global_id` VALUES ('37', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 21:54:35');
INSERT INTO `global_id` VALUES ('38', 'SPECIAL_CONTENT', '专辑列表的内容添加', '2016-02-18 21:54:35');
INSERT INTO `global_id` VALUES ('39', 'DATATYPE', '数据类型表插入', '2016-02-19 15:59:00');
INSERT INTO `global_id` VALUES ('40', 'SPECIAL_TYPE', '专辑类型大标签', '2016-02-19 16:02:00');
INSERT INTO `global_id` VALUES ('42', 'SPECIAL', '专辑添加', '2016-02-19 16:10:56');
INSERT INTO `global_id` VALUES ('43', 'SPECIAL_TYPE', '专辑类型大标签', '2016-02-22 15:34:57');
INSERT INTO `global_id` VALUES ('44', 'GLOBAL_ID', '测试插入', '2016-03-05 16:27:20');
INSERT INTO `global_id` VALUES ('45', 'GLOBAL_ID', '测试插入', '2016-03-05 16:31:25');
INSERT INTO `global_id` VALUES ('46', 'GLOBAL_ID', '测试插入', '2016-03-05 16:31:53');
INSERT INTO `global_id` VALUES ('47', 'GLOBAL_ID', '测试插入', '2016-03-05 18:06:36');
INSERT INTO `global_id` VALUES ('48', 'GLOBAL_ID', '测试插入', '2016-03-05 18:07:24');
INSERT INTO `global_id` VALUES ('49', 'GLOBAL_ID', '测试插入', '2016-03-05 18:07:40');
INSERT INTO `global_id` VALUES ('50', 'GLOBAL_ID', '测试插入', '2016-03-05 18:07:53');
INSERT INTO `global_id` VALUES ('51', 'GLOBAL_ID', '测试插入', '2016-03-05 18:08:15');

-- ----------------------------
-- Table structure for special
-- ----------------------------
DROP TABLE IF EXISTS `special`;
CREATE TABLE `special` (
  `SPECIAL_CUID` varchar(255) NOT NULL,
  `SPECIAL_TYPE_CUID` varchar(255) DEFAULT NULL,
  `SPECIAL_NAME` varchar(100) DEFAULT NULL,
  `SPECIAL_TOTAL_NUMBER` int(11) DEFAULT NULL,
  `SPECIAL_SHOW` varchar(5) DEFAULT NULL,
  `SPECIAL_MAIN_IMG_URL` varchar(255) DEFAULT NULL,
  `SPECIAL_LABEL` varchar(100) DEFAULT NULL,
  `SPECIAL_AUTHOR` varchar(100) DEFAULT NULL,
  `SPECIAL_CREATE_ADDRESS` varchar(100) DEFAULT NULL,
  `SPECIAL_CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SPECIAL_UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`SPECIAL_CUID`),
  KEY `FK_Relationship_3` (`SPECIAL_TYPE_CUID`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`SPECIAL_TYPE_CUID`) REFERENCES `special_type` (`SPECIAL_TYPE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of special
-- ----------------------------
INSERT INTO `special` VALUES ('SPECIAL_20160203007', 'SPECIAL_TYPE_20160203006', '计算机与软件工程学院', '-1', '1', 'imgs/SPECIAL_TYPE_006/SPECIAL0071455802498293583.jpg', null, null, null, '2016-02-19 15:51:15', '2016-02-18 20:49:21');
INSERT INTO `special` VALUES ('SPECIAL_201602190042', 'SPECIAL_TYPE_201602190040', '广安市图片', '0', '1', null, null, null, null, '2016-02-19 16:10:55', '2016-02-19 16:10:55');

-- ----------------------------
-- Table structure for special_content
-- ----------------------------
DROP TABLE IF EXISTS `special_content`;
CREATE TABLE `special_content` (
  `SPECIAL_CONTENT_CUID` varchar(255) NOT NULL,
  `SPECIAL_CUID` varchar(255) DEFAULT NULL,
  `SPECIAL_CONTENT_NAME` varchar(100) DEFAULT NULL,
  `SPECIAL_CONTENT_THUMB_URL` varchar(255) DEFAULT NULL,
  `SPECIAL_CONTENT_MAIN_URL` varchar(255) DEFAULT NULL,
  `SPECIAL_CONTENT_SHOW` varchar(5) DEFAULT NULL,
  `SPECIAL_CONTENT_HOT` varchar(5) DEFAULT NULL COMMENT '是否置为主页图片',
  `SPECIAL_CONTENT_CREATE_USER` varchar(255) DEFAULT NULL,
  `SPECIAL_CONTENT_AUTHOR` varchar(100) DEFAULT NULL,
  `SPECIAL_CONTENT_CREATE_ADDRESS` varchar(255) DEFAULT NULL,
  `SPECIAL_CONTENT_CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SPECIAL_CONTENT_UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`SPECIAL_CONTENT_CUID`),
  KEY `FK_Relationship_4` (`SPECIAL_CUID`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`SPECIAL_CUID`) REFERENCES `special` (`SPECIAL_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of special_content
-- ----------------------------
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602030011', 'SPECIAL_20160203007', '西华美女', 'www.baodu.com', 'www.m.baidu.com', '2', '10', null, '胡志辉', null, '2016-07-06 21:37:47', '2016-02-03 12:16:02');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180018', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455799570126916.jpg', '2', '10', '胡志辉', null, null, '2016-07-06 21:37:48', '2016-02-18 20:46:11');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180019', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455799570125630.jpg', '1', '10', '胡志辉', null, null, '2016-07-06 21:37:48', '2016-02-18 20:46:11');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180020', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455799570144350.jpg', '1', '10', '胡志辉', null, null, '2016-07-06 21:37:49', '2016-02-18 20:46:11');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180021', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455799761498291.jpg', '1', '1010', '胡志辉', null, null, '2016-07-06 21:37:50', '2016-02-18 20:49:21');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180022', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455799761506642.jpg', '1', '10', '胡志辉', null, null, '2016-07-06 21:37:50', '2016-02-18 20:49:21');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180023', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455799761607947.jpg', '1', '10', '胡志辉', null, null, '2016-07-06 21:37:51', '2016-02-18 20:49:22');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180024', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455800376054265.jpg', '1', '10', '胡志辉', null, null, '2016-07-06 21:37:52', '2016-02-18 20:59:37');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180025', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455800376033840.jpg', '1', null, '胡志辉', null, null, '2016-02-19 15:10:29', '2016-02-18 20:59:37');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180026', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455800376063384.jpg', '1', null, '胡志辉', null, null, '2016-02-19 15:10:31', '2016-02-18 20:59:37');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180030', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455802498296109.jpg', '1', null, null, null, null, '2016-02-19 15:10:30', '2016-02-18 21:34:59');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180031', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455802498310709.jpg', '1', null, null, null, null, '2016-02-19 15:10:32', '2016-02-18 21:35:00');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180032', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455802498293583.jpg', '1', null, null, null, null, '2016-02-19 15:10:34', '2016-02-18 21:35:00');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180033', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455802576604845.jpg', '1', null, null, null, null, '2016-02-19 15:10:33', '2016-02-18 21:36:17');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180034', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455802576619880.jpg', '1', null, null, null, null, '2016-02-19 15:10:35', '2016-02-18 21:36:17');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180035', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455802576689465.jpg', '1', null, null, null, null, '2016-02-19 15:10:35', '2016-02-18 21:36:17');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180036', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455803675204202.jpg', '1', null, null, null, null, '2016-02-19 15:10:36', '2016-02-18 21:54:35');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180037', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455803675293108.jpg', '1', null, null, null, null, '2016-02-19 15:10:36', '2016-02-18 21:54:35');
INSERT INTO `special_content` VALUES ('SPECIAL_CONTENT_201602180038', 'SPECIAL_20160203007', null, null, 'imgs/SPECIAL_TYPE_006/SPECIAL0071455803675300919.jpg', '1', null, null, null, null, '2016-02-19 15:10:37', '2016-02-18 21:54:35');

-- ----------------------------
-- Table structure for special_type
-- ----------------------------
DROP TABLE IF EXISTS `special_type`;
CREATE TABLE `special_type` (
  `SPECIAL_TYPE_CUID` varchar(255) NOT NULL,
  `DATA_TYPE_CUID` varchar(255) DEFAULT NULL,
  `SPECIAL_TYPE_NAME` varchar(100) DEFAULT NULL,
  `SPECIAL_TYPE_CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SPECIAL_TYPE_TOTAL_NUMBER` int(11) DEFAULT NULL,
  `SPECIAL_TYPE_SHOW` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`SPECIAL_TYPE_CUID`),
  KEY `FK_Relationship_2` (`DATA_TYPE_CUID`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`DATA_TYPE_CUID`) REFERENCES `data_type` (`DATA_TYPE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of special_type
-- ----------------------------
INSERT INTO `special_type` VALUES ('SPECIAL_TYPE_20160203006', 'DATATYPE_20160203004', '成都风景', '2016-02-22 19:36:42', '0', '1');
INSERT INTO `special_type` VALUES ('SPECIAL_TYPE_201602190040', 'DATATYPE_201602190039', '四川省图片', '2016-02-19 16:10:56', '1', '1');
INSERT INTO `special_type` VALUES ('SPECIAL_TYPE_201602220043', 'DATATYPE_201602190039', '浙江省图片', '2016-02-22 15:34:57', '0', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `SYS_USER_CUID` varchar(255) NOT NULL,
  `USER_TYPE_CUID` varchar(255) DEFAULT NULL,
  `SYS_USER_LOGIN_NAME` varchar(255) DEFAULT NULL,
  `SYS_USER_REL_NAME` varchar(255) DEFAULT NULL,
  `SYS_USER_PASSWORD` varchar(255) DEFAULT NULL,
  `SYS_USER_TELE` varchar(20) DEFAULT NULL,
  `SYS_USER_MAIL` varchar(100) DEFAULT NULL,
  `SYS_USER_ADDRESS` varchar(255) DEFAULT NULL,
  `SYS_USER_VER_CODE` varchar(10) DEFAULT NULL,
  `SYS_USER_CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SYS_USER_UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`SYS_USER_CUID`),
  KEY `FK_Relationship_1` (`USER_TYPE_CUID`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`USER_TYPE_CUID`) REFERENCES `user_type` (`USER_TYPE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('SYS_USER_20160203003', 'USER_TYPE_20160202002', 'huzhihui', '胡志辉', '123456', null, 'huzhihui_c@qq.com', '成都郫县西华大学', null, '2016-02-17 20:31:41', '2016-02-03 10:26:54');

-- ----------------------------
-- Table structure for user_type
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `USER_TYPE_CUID` varchar(255) NOT NULL,
  `USER_TYPE_NAME` varchar(255) DEFAULT NULL,
  `USER_TYPE_CODE` varchar(255) DEFAULT NULL,
  `USER_TYPE_CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_TYPE_CUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_type
-- ----------------------------
INSERT INTO `user_type` VALUES ('USER_TYPE_20160202002', '管理员', 'ADMIN', '2016-02-02 22:03:48');
INSERT INTO `user_type` VALUES ('USER_TYPE_20160203003', '普通用户', 'USER', '2016-02-03 09:39:35');
