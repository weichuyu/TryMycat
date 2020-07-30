/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50730
Source Host           : 127.0.0.1:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-07-30 19:10:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `test1`
-- ----------------------------
DROP TABLE IF EXISTS `test1`;
CREATE TABLE `test1` (
  `id` char(36) NOT NULL,
  `number` decimal(21,3) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
