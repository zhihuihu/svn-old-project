/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : waychat

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-08-12 18:08:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat_history
-- ----------------------------
DROP TABLE IF EXISTS `chat_history`;
CREATE TABLE `chat_history` (
  `chat_history_cuid` varchar(50) NOT NULL,
  `room_or_user_cuid` varchar(50) DEFAULT NULL,
  `sys_user_cuid` varchar(50) DEFAULT NULL,
  `chat_history_content` varchar(1000) DEFAULT NULL,
  `chat_history_file` varchar(1000) DEFAULT NULL,
  `chat_history_state` int(2) DEFAULT NULL,
  `chat_history_create_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`chat_history_cuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for chat_room
-- ----------------------------
DROP TABLE IF EXISTS `chat_room`;
CREATE TABLE `chat_room` (
  `chat_room_cuid` varchar(50) NOT NULL,
  `chat_room_icon` varchar(100) DEFAULT NULL,
  `chat_room_name` varchar(100) DEFAULT NULL,
  `chat_room_create_sys_user_cuid` varchar(50) DEFAULT NULL,
  `chat_room_chat_link` varchar(255) DEFAULT NULL,
  `chat_room_create_time` varchar(20) DEFAULT NULL,
  `chat_room_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`chat_room_cuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `friend_cuid` varchar(50) NOT NULL,
  `friend_group_cuid` varchar(50) DEFAULT NULL,
  `friend_des_sys_user_cuid` varchar(50) DEFAULT NULL,
  `friend_ori_like_name` varchar(100) DEFAULT NULL,
  `friend_des_like_name` varchar(100) DEFAULT NULL,
  `friend_chat_link` varchar(100) DEFAULT NULL,
  `friend_state` varchar(100) DEFAULT NULL,
  `friend_create_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`friend_cuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for friend_group
-- ----------------------------
DROP TABLE IF EXISTS `friend_group`;
CREATE TABLE `friend_group` (
  `friend_group_cuid` varchar(50) NOT NULL,
  `friend_group_icon` varchar(100) DEFAULT NULL,
  `sys_user_cuid` varchar(50) DEFAULT NULL,
  `friend_group_name` varchar(50) DEFAULT NULL,
  `friend_group_online_number` int(11) DEFAULT NULL,
  `friend_group_total_number` int(11) DEFAULT NULL,
  `friend_group_state` int(2) DEFAULT NULL,
  PRIMARY KEY (`friend_group_cuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for room_people
-- ----------------------------
DROP TABLE IF EXISTS `room_people`;
CREATE TABLE `room_people` (
  `room_people_cuid` varchar(50) NOT NULL,
  `chat_room_cuid` varchar(50) DEFAULT NULL,
  `sys_user_cuid` varchar(50) DEFAULT NULL,
  `room_people_state` smallint(2) DEFAULT NULL,
  `room_people_create_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`room_people_cuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `sys_user_cuid` varchar(50) NOT NULL,
  `sys_user_icon` varchar(255) DEFAULT NULL,
  `sys_user_name` varchar(20) DEFAULT NULL,
  `sys_user_like_name` varchar(20) DEFAULT NULL,
  `sys_user_login_name` varchar(20) DEFAULT NULL,
  `sys_user_password` varchar(255) DEFAULT NULL,
  `sys_user_profile` varchar(255) DEFAULT NULL,
  `sys_user_address` varchar(255) DEFAULT NULL,
  `sys_user_tel` varchar(20) DEFAULT NULL,
  `sys_user_email` varchar(50) DEFAULT NULL,
  `sys_user_online_state` smallint(1) DEFAULT NULL,
  `sys_user_state` smallint(2) DEFAULT NULL,
  `sys_user_create_time` varchar(20) DEFAULT NULL,
  `sys_user_update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sys_user_cuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
