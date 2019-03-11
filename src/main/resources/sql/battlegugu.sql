/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : battlegugu

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 21/02/2019 15:05:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for battleinfo
-- ----------------------------
DROP TABLE IF EXISTS `battleinfo`;
CREATE TABLE `battleinfo`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(20) NOT NULL,
  `leave_desc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请假理由',
  `is_join` tinyint(1) NOT NULL DEFAULT 0,
  `battle_date` date NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '团战信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of battleinfo
-- ----------------------------
INSERT INTO `battleinfo` VALUES (1, 202718, '请假回家', 0, '2019-01-26');
INSERT INTO `battleinfo` VALUES (2, 256498, NULL, 1, '2019-01-26');
INSERT INTO `battleinfo` VALUES (3, 2046589, NULL, 0, '2019-01-26');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(11) DEFAULT -1,
  `role` int(11) DEFAULT 1,
  `is_delete` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `user_uid_uindex`(`uid`) USING BTREE,
  UNIQUE INDEX `user_username_uindex`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (202718, 'cirno', '241929', '乡村野团琪露诺', 0, 1, 0);
INSERT INTO `user` VALUES (256498, 'rbqyuluo', 'password', '桥驿听雨落', 1, 1, 0);
INSERT INTO `user` VALUES (2046589, 'qingning123', 'password', '青柠', -1, 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
