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

 Date: 18/04/2022 08:41:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1025 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tag
-- ----------------------------
BEGIN;
INSERT INTO `tag` VALUES (1, '社交');
INSERT INTO `tag` VALUES (2, '游戏');
INSERT INTO `tag` VALUES (3, '学习');
INSERT INTO `tag` VALUES (4, '恋爱');
INSERT INTO `tag` VALUES (5, '找人');
INSERT INTO `tag` VALUES (6, '专升本');
INSERT INTO `tag` VALUES (1024, '官方');
INSERT INTO `tag` VALUES (7, '考试');
INSERT INTO `tag` VALUES (8, '毕业');
INSERT INTO `tag` VALUES (9, '实习');
INSERT INTO `tag` VALUES (10, '食堂');
INSERT INTO `tag` VALUES (11, '回家');
INSERT INTO `tag` VALUES (12, '寻物');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
