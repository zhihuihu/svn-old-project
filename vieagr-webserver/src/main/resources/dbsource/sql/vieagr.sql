/*
Navicat MySQL Data Transfer

Source Server         : locahost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : vieagr

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-10-18 16:34:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bet_order_product
-- ----------------------------
DROP TABLE IF EXISTS `bet_order_product`;
CREATE TABLE `bet_order_product` (
  `bet_order_product_id` varchar(40) NOT NULL COMMENT '订单与商品关联id',
  `bet_order_product_order_id` varchar(40) DEFAULT NULL COMMENT '订单主键id',
  `bet_order_product_order_number` varchar(40) DEFAULT NULL COMMENT '订单号',
  `bet_order_product_product_id` varchar(40) DEFAULT NULL COMMENT '商品主键id',
  `bet_order_product_product_count` int(10) DEFAULT NULL COMMENT '商品数量',
  `bet_order_product_create_time` varchar(20) DEFAULT NULL COMMENT '订单与商品关联创建时间',
  `bet_order_product_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '订单与商品关联更新时间',
  `bet_order_product_del_flag` int(2) DEFAULT '1' COMMENT '订单与商品关联删除标记，1、未删除，2、已删除',
  `bet_order_product_product_former_price` decimal(20,0) DEFAULT NULL COMMENT '商品原标价',
  `bet_order_product_product_sale_price` decimal(20,0) DEFAULT NULL COMMENT '商品时间成交价',
  `bet_order_product_product_total` decimal(20,0) DEFAULT NULL COMMENT '本次订单商品的总价',
  `bet_order_product_univalent_remark` varchar(255) DEFAULT NULL COMMENT '商品单价修改备注',
  PRIMARY KEY (`bet_order_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单与商品一对多关联中间表';

-- ----------------------------
-- Records of bet_order_product
-- ----------------------------

-- ----------------------------
-- Table structure for bet_vehicles_customer
-- ----------------------------
DROP TABLE IF EXISTS `bet_vehicles_customer`;
CREATE TABLE `bet_vehicles_customer` (
  `bet_vehicles_customer_id` varchar(40) NOT NULL COMMENT '车辆与客户关联id',
  `bet_vehicles_customer_vehicles_id` varchar(40) DEFAULT NULL COMMENT '车辆id',
  `bet_vehicles_customer_customer_id` varchar(40) DEFAULT NULL COMMENT '客户id',
  `bet_vehicles_customer_create_time` varchar(20) DEFAULT NULL COMMENT '车辆与客户关联创建时间',
  `bet_vehicles_customer_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '车辆与客户关联更新时间',
  `bet_vehicles_customer_del_flag` int(2) DEFAULT '1' COMMENT '车辆与客户关联删除标记，1、未删除，2、已删除',
  PRIMARY KEY (`bet_vehicles_customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='送货车辆与客户一对多关联中间表';

-- ----------------------------
-- Records of bet_vehicles_customer
-- ----------------------------

-- ----------------------------
-- Table structure for ser_delivery
-- ----------------------------
DROP TABLE IF EXISTS `ser_delivery`;
CREATE TABLE `ser_delivery` (
  `ser_deliver_id` varchar(40) NOT NULL COMMENT '送货单主键id',
  `ser_deliver_send_time` varchar(20) DEFAULT NULL COMMENT '送货时间',
  `ser_deliver_send_id` varchar(40) DEFAULT NULL COMMENT '送货人id',
  `ser_deliver_order_id` varchar(40) DEFAULT NULL COMMENT '订单外键',
  `ser_deliver_amount` decimal(20,2) DEFAULT NULL COMMENT '送货单金额',
  `ser_deliver_create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `ser_deliver_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ser_deliver_back_time` varchar(20) DEFAULT NULL COMMENT '送货单反馈时间',
  `ser_deliver_back_state` int(2) DEFAULT NULL COMMENT '送货单反馈状态，1、客户成功收货，2、客户拒绝收货',
  `ser_deliver_back_details` varchar(255) DEFAULT NULL COMMENT '送货单反馈具体详情',
  `ser_deliver_remark` varchar(255) DEFAULT NULL COMMENT '送货单备注',
  `ser_deliver_del_flag` int(2) DEFAULT '1' COMMENT '送货单删除标记，1、未删除，2、已删除',
  PRIMARY KEY (`ser_deliver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='送货单表';

-- ----------------------------
-- Records of ser_delivery
-- ----------------------------

-- ----------------------------
-- Table structure for ser_order
-- ----------------------------
DROP TABLE IF EXISTS `ser_order`;
CREATE TABLE `ser_order` (
  `ser_order_id` varchar(40) NOT NULL COMMENT '订单主键id',
  `ser_order_number` varchar(40) DEFAULT NULL COMMENT '订单号',
  `ser_order_type` int(2) DEFAULT NULL COMMENT '订单类型，1、普通订单，2、员工餐订单',
  `ser_order_state` int(2) DEFAULT NULL COMMENT '订单状态，1、待备货，2、待配送，3、配送中，4、已配送完成，5、配送遇到问题',
  `ser_order_customer_id` varchar(40) DEFAULT NULL COMMENT '客户外键',
  `ser_order_creater_id` varchar(40) DEFAULT NULL COMMENT '订单创建人id',
  `ser_order_create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `ser_order_update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `ser_order_amount` decimal(20,2) DEFAULT NULL COMMENT '订单金额',
  `ser_order_product_count` int(10) DEFAULT NULL COMMENT '订单商品总数',
  `ser_order_back_time` varchar(20) DEFAULT NULL COMMENT '订单反馈时间',
  `ser_order_back_state` int(2) DEFAULT NULL COMMENT '订单反馈状态，1、配送成功，2、配送失败，3、其他',
  `ser_order_remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `ser_order_back_details` varchar(255) DEFAULT NULL COMMENT '订单反馈具体详情',
  `ser_order_change_times` int(2) DEFAULT NULL COMMENT '订单修改次数',
  `ser_order_del_flag` int(2) DEFAULT '1' COMMENT '订单删除标记，1、未删除，2已删除',
  PRIMARY KEY (`ser_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of ser_order
-- ----------------------------

-- ----------------------------
-- Table structure for sys_customer
-- ----------------------------
DROP TABLE IF EXISTS `sys_customer`;
CREATE TABLE `sys_customer` (
  `sys_customer_id` varchar(40) NOT NULL COMMENT '客户主键',
  `sys_customer_name` varchar(40) DEFAULT NULL COMMENT '客户用户名',
  `sys_customer_sex` int(2) DEFAULT NULL COMMENT '客户性别，1、男，2、女',
  `sys_customer_age` int(3) DEFAULT NULL COMMENT '客户年龄',
  `sys_customer_real_name` varchar(40) DEFAULT NULL COMMENT '客户真实姓名',
  `sys_customer_mobile_number` varchar(40) DEFAULT NULL COMMENT '客户手机号',
  `sys_customer_qq_number` varchar(40) DEFAULT NULL COMMENT '客户QQ号码',
  `sys_customer_email` varchar(255) DEFAULT NULL COMMENT '客户邮箱',
  `sys_customer_img_url` varchar(255) DEFAULT NULL COMMENT '客户头像地址',
  `sys_customer_store_name` varchar(40) DEFAULT NULL COMMENT '客户门店名',
  `sys_customer_store_address` varchar(40) DEFAULT NULL COMMENT '客户门店地址',
  `sys_customer_type` int(2) DEFAULT '1' COMMENT '客户类型，1、普通客户，2、VIP用户',
  `sys_customer_grade` int(2) DEFAULT NULL COMMENT '客户等级，1、小型买家客户，2中型买家客户，3、大型买家客户',
  `sys_customer_state` int(2) DEFAULT '1' COMMENT '客户状态，1、启用，2、禁用',
  `sys_customer_create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `sys_customer_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `sys_customer_del_flag` int(2) DEFAULT '1' COMMENT '客户删除标记，1、未删除，2已删除',
  PRIMARY KEY (`sys_customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息表';

-- ----------------------------
-- Records of sys_customer
-- ----------------------------

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `sys_file_id` varchar(40) NOT NULL COMMENT '系统文件主键',
  `sys_file_type` int(2) DEFAULT NULL COMMENT '系统文件类型，1、图片，2、excel表格，3、word文档，4、其他',
  `sys_file_postfix` varchar(10) DEFAULT NULL COMMENT '系统文件后缀名',
  `sys_file_url` varchar(255) DEFAULT NULL COMMENT '系统文件地址',
  `sys_file_creater` varchar(40) DEFAULT NULL COMMENT '系统文件创建人id',
  `sys_file_create_time` varchar(20) DEFAULT NULL COMMENT '系统文件创建时间',
  `sys_file_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '系统文件更新时间',
  `sys_file_remark` varchar(255) DEFAULT NULL COMMENT '系统文件备注',
  `sys_file_del_flag` int(2) DEFAULT NULL COMMENT '系统文件删除标记，1、未删除，2、已删除',
  PRIMARY KEY (`sys_file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统文件储存信息表';

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_product
-- ----------------------------
DROP TABLE IF EXISTS `sys_product`;
CREATE TABLE `sys_product` (
  `sys_product_id` varchar(40) NOT NULL COMMENT '商品主键id',
  `sys_product_name` varchar(40) DEFAULT NULL COMMENT '商品名称',
  `sys_product_py_code` varchar(20) DEFAULT NULL COMMENT '商品拼音码',
  `sys_product_py_name` varchar(40) DEFAULT NULL COMMENT '商品拼音全称',
  `sys_product_state` int(2) DEFAULT '1' COMMENT '商品状态，1、启用，2、禁用',
  `sys_product_unit_name` varchar(20) DEFAULT NULL COMMENT '商品计量单位',
  `sys_product_price` decimal(2,0) DEFAULT NULL COMMENT '商品单价',
  `sys_product_img_url` varchar(255) DEFAULT NULL COMMENT '商品图片地址',
  `sys_product_create_time` varchar(20) DEFAULT NULL COMMENT '商品创建时间',
  `sys_product_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `sys_prodcut_choose_time` varchar(20) DEFAULT NULL COMMENT '商品被选中的时间',
  `sys_product_del_flag` int(2) DEFAULT '1' COMMENT '商品删除标记，1、未删除，2、已删除',
  PRIMARY KEY (`sys_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of sys_product
-- ----------------------------

-- ----------------------------
-- Table structure for sys_sender
-- ----------------------------
DROP TABLE IF EXISTS `sys_sender`;
CREATE TABLE `sys_sender` (
  `sys_sender_id` varchar(40) NOT NULL COMMENT '送货人id',
  `sys_sender_name` varchar(40) DEFAULT NULL COMMENT '送货人姓名',
  `sys_sender_mobile_number` varchar(20) DEFAULT NULL COMMENT '送货人手机号码',
  `sys_sender_state` int(2) DEFAULT '1' COMMENT '送货人状态，1、启用，2、禁用',
  `sys_sender_img_url` varchar(255) DEFAULT NULL COMMENT '送货人照片地址',
  `sys_sender_create_time` varchar(20) DEFAULT NULL COMMENT '送货人信息创建时间',
  `sys_sender_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '送货人信息更新时间',
  `sys_sender_del_flag` int(2) DEFAULT '1' COMMENT '送货人删除标记，1、未删除，2、已删除',
  PRIMARY KEY (`sys_sender_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='送货人信息表';

-- ----------------------------
-- Records of sys_sender
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `sys_user_id` varchar(40) NOT NULL COMMENT '用户主键Id',
  `sys_user_name` varchar(40) NOT NULL COMMENT '用户名',
  `sys_user_password` varchar(40) NOT NULL COMMENT '用户登录密码',
  `sys_user_sex` int(2) DEFAULT NULL COMMENT '用户性别，1、男，2、女',
  `sys_user_age` int(3) DEFAULT NULL COMMENT '用户年龄',
  `sys_user_real_name` varchar(40) DEFAULT NULL COMMENT '用户真实姓名',
  `sys_user_mobile_number` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `sys_user_type` int(2) DEFAULT '2' COMMENT '用户类型，1、超级管理员，2、普通用户',
  `sys_user_state` int(2) DEFAULT '1' COMMENT '状态，1、启用，2、禁用',
  `sys_user_img_url` varchar(255) DEFAULT NULL COMMENT '用户照片地址',
  `sys_user_create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `sys_user_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `sys_user_del_flag` int(2) DEFAULT '1' COMMENT '作废删除标记,1、未删除，2、已删除',
  PRIMARY KEY (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_vehicles
-- ----------------------------
DROP TABLE IF EXISTS `sys_vehicles`;
CREATE TABLE `sys_vehicles` (
  `sys_vehicles_id` varchar(40) NOT NULL COMMENT '车辆主键id',
  `sys_vehicles_plate_number` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `sys_vehicles_type` int(2) DEFAULT NULL COMMENT '车辆类型，1、小型货车，2、中型货车，3、大型货车，4其他',
  `sys_vehicles_desc` varchar(255) DEFAULT NULL COMMENT '车辆信息描述',
  `sys_vehicles_grade` int(2) DEFAULT NULL COMMENT '车辆等级，1、普通型，2、豪华型',
  `sys_vehicles_register_name` varchar(40) DEFAULT NULL COMMENT '车辆注册人姓名',
  `sys_vehicles_register_mobile` varchar(20) DEFAULT NULL COMMENT '车辆注册人手机号码',
  `sys_vehicles_img_url` varchar(255) DEFAULT NULL COMMENT '车辆照片地址',
  `sys_vehicles_create_time` varchar(20) DEFAULT NULL COMMENT '车辆创建时间',
  `sys_vehicles_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '车辆更新时间',
  `sys_vehicles_state` int(2) DEFAULT '1' COMMENT '车辆状态，1、启用，2、禁用',
  `sys_vehicles_del_flag` int(2) DEFAULT '1' COMMENT '车辆删除标记，1、未删除，2、已删除',
  PRIMARY KEY (`sys_vehicles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆管理表';

-- ----------------------------
-- Records of sys_vehicles
-- ----------------------------
