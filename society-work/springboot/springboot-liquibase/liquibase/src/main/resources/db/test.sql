/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-10-08 10:36:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for 20161008
-- ----------------------------
DROP TABLE IF EXISTS `20161008`;
CREATE TABLE `20161008` (
  `djk` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for databasechangelog
-- ----------------------------
DROP TABLE IF EXISTS `databasechangelog`;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for databasechangeloglock
-- ----------------------------
DROP TABLE IF EXISTS `databasechangeloglock`;
CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for global_table
-- ----------------------------
DROP TABLE IF EXISTS `global_table`;
CREATE TABLE `global_table` (
  `GLOBAL_CUID` int(11) NOT NULL AUTO_INCREMENT,
  `GLOBAL_TABLE_NAME` varchar(255) DEFAULT NULL,
  `GLOBAL_TABLE_NOTES` varchar(255) DEFAULT NULL,
  `GLOBAL_CREATE_TIME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`GLOBAL_CUID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for ht_fms_host
-- ----------------------------
DROP TABLE IF EXISTS `ht_fms_host`;
CREATE TABLE `ht_fms_host` (
  `host_id` int(11) NOT NULL COMMENT '主机id',
  `host_domain` varchar(20) NOT NULL COMMENT '主机域名',
  `host_ip` varchar(20) NOT NULL COMMENT '主机IP',
  `host_version` varchar(10) DEFAULT NULL COMMENT '主机版本',
  `host_online_count` int(11) DEFAULT NULL COMMENT '在线人数',
  `host_max_count` int(11) NOT NULL COMMENT '最大容量',
  `host_status` varchar(10) NOT NULL COMMENT '主机状态（running，down）',
  `host_create_time` varchar(20) NOT NULL COMMENT '创建时间',
  `host_update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`host_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流媒体寻址表';

-- ----------------------------
-- Table structure for img
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `text` mediumtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for message_center
-- ----------------------------
DROP TABLE IF EXISTS `message_center`;
CREATE TABLE `message_center` (
  `message_center_id` varchar(40) NOT NULL COMMENT '消息中心id',
  `title` varchar(255) DEFAULT NULL COMMENT '消息标题',
  `type` smallint(2) DEFAULT NULL COMMENT '消息类型',
  `state` smallint(2) DEFAULT NULL COMMENT '消息状态',
  `content` varchar(255) DEFAULT NULL COMMENT '消息内容',
  `sponsor_user_id` bigint(20) DEFAULT NULL COMMENT '发起者的userId',
  `sponsor_user_name` varchar(20) DEFAULT NULL COMMENT '发起者的userName',
  `receive_user_id` bigint(20) DEFAULT NULL COMMENT '接收者的userId',
  `receive_user_name` varchar(20) DEFAULT NULL COMMENT '接收者的userName',
  `create_time` varchar(20) DEFAULT NULL COMMENT '消息创建时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '消息更新时间',
  PRIMARY KEY (`message_center_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pay_clear
-- ----------------------------
DROP TABLE IF EXISTS `pay_clear`;
CREATE TABLE `pay_clear` (
  `pay_clear_id` varchar(40) NOT NULL COMMENT '清分总表uuid',
  `pay_clear_no` varchar(20) DEFAULT NULL COMMENT '清分总表单据号',
  `end_time` varchar(20) DEFAULT NULL COMMENT '本次清分结束时间',
  `order_price` decimal(10,2) NOT NULL COMMENT '清分订单的总金额',
  `clear_price` decimal(10,2) NOT NULL COMMENT '本次清分总金额',
  `number` int(11) DEFAULT NULL COMMENT '清分总表本次清分总的公司数量或者医生数量',
  `operate_id` bigint(20) NOT NULL COMMENT '本次清分操作人id',
  `operate_name` varchar(20) NOT NULL COMMENT '本次清分操作人名称',
  `operate_time` varchar(20) NOT NULL COMMENT '本次清分操作时间',
  `state` smallint(1) DEFAULT NULL COMMENT '清分状态（未使用）',
  `notice` varchar(255) DEFAULT NULL COMMENT '清分提示',
  PRIMARY KEY (`pay_clear_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='清分总表';

-- ----------------------------
-- Table structure for pay_clear_detail
-- ----------------------------
DROP TABLE IF EXISTS `pay_clear_detail`;
CREATE TABLE `pay_clear_detail` (
  `pay_clear_detail_id` varchar(40) NOT NULL,
  `pay_clear_list_id` varchar(40) NOT NULL COMMENT '(pay_clear_list)id',
  `pay_bonus_company_id` bigint(20) NOT NULL COMMENT '订单分红信息表id',
  `order_no` varchar(20) NOT NULL COMMENT '订单号',
  `order_price` decimal(10,2) DEFAULT NULL COMMENT '订单价格',
  `clear_price` decimal(10,2) DEFAULT NULL COMMENT '清分价格',
  PRIMARY KEY (`pay_clear_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='清分详情表';

-- ----------------------------
-- Table structure for pay_clear_epay
-- ----------------------------
DROP TABLE IF EXISTS `pay_clear_epay`;
CREATE TABLE `pay_clear_epay` (
  `pay_clear_epay_id` varchar(40) NOT NULL COMMENT '清分橙E付id',
  `pay_clear_list_id` varchar(40) DEFAULT NULL COMMENT 'pay_clear_list表的id（作为外键）',
  `serial_number` varchar(40) NOT NULL,
  `payment_id` varchar(40) DEFAULT NULL COMMENT '支付人id',
  `payment_account` varchar(255) DEFAULT NULL COMMENT '支付人账号',
  `payee_id` bigint(11) DEFAULT NULL COMMENT '收款人id',
  `payee_account` varchar(255) DEFAULT NULL COMMENT '收款人账号',
  `pay_time` varchar(20) DEFAULT NULL COMMENT '橙E付支付时间',
  `operate_time` varchar(20) NOT NULL COMMENT '操作时间',
  `send_msg` varchar(255) NOT NULL COMMENT '橙E付发送报文',
  `back_msg` varchar(255) NOT NULL COMMENT '橙E付接收报文',
  `estate` int(1) NOT NULL COMMENT '橙E付返回状态（待定）',
  `state` int(1) NOT NULL COMMENT '支付状态（1成功、2失败、3质疑、4清分中、5已再次清分）',
  `notice` varchar(255) DEFAULT NULL COMMENT '支付提示',
  PRIMARY KEY (`pay_clear_epay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='清分橙E付流水表';

-- ----------------------------
-- Table structure for pay_clear_list
-- ----------------------------
DROP TABLE IF EXISTS `pay_clear_list`;
CREATE TABLE `pay_clear_list` (
  `pay_clear_list_id` varchar(40) NOT NULL COMMENT '清分id',
  `pay_clear_id` varchar(40) NOT NULL COMMENT '清分主表（pay_clear）的uuid',
  `pay_clear_no` varchar(40) DEFAULT NULL COMMENT '清分总表单据号',
  `serial_number` varchar(40) DEFAULT NULL COMMENT '清分流水号（作为橙E付支付订单号）',
  `user_id` int(11) DEFAULT NULL COMMENT '清分账户的id（被清分的人的userid）',
  `user_name` varchar(20) DEFAULT NULL COMMENT '清分账户名称（组织机构名称、管理公司名称、医生名称）',
  `user_type` int(1) DEFAULT NULL COMMENT '用户类型（0：医生、1：便民店、2：组织机构（医院）、3：管理公司、4：平台）',
  `order_price` decimal(10,2) NOT NULL COMMENT '本次清分订单的总金额',
  `clear_price` decimal(10,2) NOT NULL COMMENT '本次清分金额',
  `payment_id` bigint(20) DEFAULT NULL COMMENT '支付人对应的userid',
  `payment_account` varchar(40) DEFAULT NULL COMMENT '支付人对应的橙E付账号',
  `payee_id` bigint(20) DEFAULT NULL COMMENT '收款人id',
  `payee_account` varchar(40) DEFAULT NULL COMMENT '收款人橙E付账号',
  `operate_user_id` bigint(20) DEFAULT NULL COMMENT '本次清分操作人id',
  `operate_user_name` varchar(20) DEFAULT NULL,
  `state` varchar(255) NOT NULL COMMENT '清分状态（1完成、2失败、3质疑、4清分中、5已再次清分）',
  `end_time` varchar(20) NOT NULL COMMENT '清分截止时间',
  `operate_time` varchar(20) DEFAULT NULL COMMENT '本次清分操作时间',
  `notice` varchar(255) DEFAULT NULL COMMENT '清分提示',
  PRIMARY KEY (`pay_clear_list_id`,`pay_clear_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='清分主表';

-- ----------------------------
-- Table structure for pay_voucher
-- ----------------------------
DROP TABLE IF EXISTS `pay_voucher`;
CREATE TABLE `pay_voucher` (
  `pay_voucher_id` varchar(24) NOT NULL COMMENT '支付凭证UUID',
  `pay_vouche_user_id` bigint(20) DEFAULT NULL COMMENT '支付人id    xt_user外键',
  `pay_vouche_pay_info_id` bigint(20) DEFAULT NULL COMMENT '支付信息id    pay_info外键',
  `pay_vouche_order_no` varchar(20) DEFAULT NULL COMMENT '订单号    pay_order的外键',
  `pay_vouche_content` varchar(200) DEFAULT NULL COMMENT '支付凭证发送报文',
  `pay_vouche_back_content` varchar(1000) DEFAULT NULL COMMENT '支付凭证接收报文',
  `pay_vouche_state` smallint(5) DEFAULT NULL COMMENT '支付状态',
  `pay_vouche_way` smallint(5) DEFAULT NULL COMMENT '支付方式',
  `pay_vouche_pay_code` varchar(20) DEFAULT NULL COMMENT '支付返回方的code码',
  `pay_vouche_pay_desc` varchar(255) DEFAULT NULL COMMENT '支付返回的状态描述',
  `pay_vouche_create_time` varchar(20) DEFAULT NULL COMMENT '支付凭证时间',
  PRIMARY KEY (`pay_voucher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='橙E付支付信息';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for useraccount
-- ----------------------------
DROP TABLE IF EXISTS `useraccount`;
CREATE TABLE `useraccount` (
  `djk` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Function structure for currval
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS int(11)
    READS SQL DATA
    DETERMINISTIC
BEGIN

DECLARE
VALUE
	INTEGER ;
SET
VALUE
	= 0 ; SELECT
		current_value INTO
	VALUE

	FROM
		sequence
	WHERE
		NAME = seq_name ; RETURN
	VALUE
		;
	END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nextval`(seq_name VARCHAR(50)) RETURNS int(11)
    DETERMINISTIC
BEGIN
	UPDATE sequence
SET current_value = current_value + increment
WHERE
	NAME = seq_name ; RETURN currval (seq_name) ;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SELECT_GLOBAL_ID
-- ----------------------------
DROP FUNCTION IF EXISTS `SELECT_GLOBAL_ID`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SELECT_GLOBAL_ID`() RETURNS varchar(255) CHARSET latin1
BEGIN

DECLARE CUID VARCHAR (255);

INSERT INTO global_table
VALUES
	(
		'',
		'GLOBAL_TABLE',
		'测试而已',
		(SELECT CURTIME())
	);


SET CUID = CONCAT(
	'GLOBAL_TABLE',
	DATE_FORMAT(NOW(), '%Y%m%d'),
	(SELECT
		LAST_INSERT_ID())
);

RETURN CUID;


END
;;
DELIMITER ;
