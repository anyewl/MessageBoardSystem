/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : message

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 18/04/2022 08:41:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for love
-- ----------------------------
DROP TABLE IF EXISTS `love`;
CREATE TABLE `love` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL,
  `name1` varchar(255) DEFAULT NULL,
  `name2` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `power` int DEFAULT NULL,
  `help_count` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of love
-- ----------------------------
BEGIN;
INSERT INTO `love` VALUES (4, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 37, 0);
INSERT INTO `love` VALUES (5, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 35, 0);
INSERT INTO `love` VALUES (66, '加油！冲冲冲', '2022-04-17 13:39:43', '李滋芸', '操作系统内核', '5201314', 37, 0);
INSERT INTO `love` VALUES (7, '加油！冲冲冲', '2022-04-17 13:39:50', '李滋芸', '操作系统内核', '5201314', 35, 0);
INSERT INTO `love` VALUES (8, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 37, 0);
INSERT INTO `love` VALUES (9, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 35, 0);
INSERT INTO `love` VALUES (10, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 37, 0);
INSERT INTO `love` VALUES (11, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 35, 0);
INSERT INTO `love` VALUES (12, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 37, 0);
INSERT INTO `love` VALUES (14, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 35, 0);
INSERT INTO `love` VALUES (15, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 37, 0);
INSERT INTO `love` VALUES (16, '加油！冲冲冲', NULL, '李滋芸', '操作系统内核', '5201314', 35, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
