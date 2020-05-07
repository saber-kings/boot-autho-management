/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : shiro

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 08/05/2020 01:54:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_permissions`;
CREATE TABLE `sys_roles_permissions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_roles_permissions
-- ----------------------------
INSERT INTO `sys_roles_permissions` VALUES (1, 'user:deleted', 'test');
INSERT INTO `sys_roles_permissions` VALUES (2, 'user:list', 'test');
INSERT INTO `sys_roles_permissions` VALUES (3, '*', 'admin');
INSERT INTO `sys_roles_permissions` VALUES (4, 'user:edit', 'test');

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO `sys_user_roles` VALUES (1, 'admin', 'admin');
INSERT INTO `sys_user_roles` VALUES (2, 'test', 'test');

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES (1, 'admin', '123456');
INSERT INTO `sys_users` VALUES (2, 'test', '123456');

SET FOREIGN_KEY_CHECKS = 1;
