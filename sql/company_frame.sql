/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : company_frame

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 08/05/2020 01:54:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `dept_no` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门编号',
  `name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `pid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父级id',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态(1:正常；0:弃用)',
  `relation_code` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '为了维护更深层级关系(规则：父级关系编码+自己的编码)',
  `dept_manager_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门经理user_id',
  `manager_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门经理名称',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门经理联系电话',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否删除(1未删除；0已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('352bd3b7-8b9b-4218-8295-086044af345e', 'YXD0000001', '二次元帝国总公司', '0', 1, 'YXD0000001', NULL, '御坂美琴', '13569874569', '2020-04-22 00:56:05', NULL, 1);
INSERT INTO `sys_dept` VALUES ('3d89fdd3-7f80-4fbf-8e6d-c0583cc66179', 'YXD0000005', '广州分部白云区', '5cbde053-0457-483f-ab83-2d7c86ff6e1e', 1, 'YXD0000001YXD0000003YXD0000005', NULL, '伊莉雅·冯爱因兹贝伦', '13899665521', '2020-05-01 11:55:20', '2020-05-01 13:18:44', 1);
INSERT INTO `sys_dept` VALUES ('5cbde053-0457-483f-ab83-2d7c86ff6e1e', 'YXD0000003', '二次元帝国广州分部', '352bd3b7-8b9b-4218-8295-086044af345e', 1, 'YXD0000001YXD0000003', NULL, '远坂凛', '15487569214', '2020-04-22 01:44:08', '2020-05-01 13:18:44', 1);
INSERT INTO `sys_dept` VALUES ('91708ca0-3cd5-4d78-87f4-56020fb34290', 'YXD0000002', '二次元帝国深圳分部', '352bd3b7-8b9b-4218-8295-086044af345e', 1, 'YXD0000001YXD0000002', NULL, '五河琴里', '15689475621', '2020-04-22 01:31:50', NULL, 1);
INSERT INTO `sys_dept` VALUES ('d30528ef-23da-4923-8dee-ce5361c1b5b5', 'YXD0000004', '二次元帝国北凉分部', '352bd3b7-8b9b-4218-8295-086044af345e', 1, 'YXD0000001YXD0000004', NULL, '徐凤年', '13465664416', '2020-04-28 21:43:35', NULL, 1);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `time` int(11) NULL DEFAULT NULL COMMENT '响应时间',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('00cd0fa4-b725-413a-a524-3bc3cc5e8729', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 68, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:18:09');
INSERT INTO `sys_log` VALUES ('0103c27d-92db-401c-8ea6-58b9825f9376', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:38:34');
INSERT INTO `sys_log` VALUES ('012368b1-649d-4ddb-8b74-7d01647ca703', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 61, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 21:15:43');
INSERT INTO `sys_log` VALUES ('01fb9455-7c07-4788-8642-26a9e8ba0b05', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-保存用户新拥有的角色信息接口', 66, 'com.yingxue.lesson.controller.UserController.saveUserOwnRole()', '[{\"roleIds\":[\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\"],\"userId\":\"fcf34b56-a7a2-4719-9236-867495e74c31\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:31:02');
INSERT INTO `sys_log` VALUES ('024a4d4d-7735-4758-b675-40c457ae4a29', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 19, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:31:08');
INSERT INTO `sys_log` VALUES ('04689931-574f-496c-855d-afe6d043f688', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 19, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:56:02');
INSERT INTO `sys_log` VALUES ('0598660b-f6c7-434c-9667-de06ebc9d4d3', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 42, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 21:55:58');
INSERT INTO `sys_log` VALUES ('05c28610-edd5-4102-8643-6b3e6fa89951', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 62, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\"]', '0:0:0:0:0:0:0:1', '2020-05-01 22:21:18');
INSERT INTO `sys_log` VALUES ('07793646-d4ab-436d-a6cb-b8a607541a0a', NULL, NULL, '组织模块-用户管理-jwt 刷新 token 接口', 107, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-04 21:36:52');
INSERT INTO `sys_log` VALUES ('0acac7dd-c4c5-4a1c-9cbf-56175155f9fd', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 69, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:23:32');
INSERT INTO `sys_log` VALUES ('0ae3b1bb-0157-4157-8075-4929a7ac6123', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 56, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 18:23:24');
INSERT INTO `sys_log` VALUES ('0aeabac5-94e4-4228-af4b-8c233db78862', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-编辑菜单权限接口', 64, 'com.yingxue.lesson.controller.PermissionController.updatePermission()', '[{\"code\":\"\",\"id\":\"99edbfda-0730-47f3-a6ca-da323eadddeb\",\"method\":\"GET\",\"name\":\"接口管理\",\"orderNum\":100,\"perms\":\"\",\"pid\":\"5ef1b976-f871-4acf-a167-8fd9a438fc1b\",\"status\":1,\"type\":2,\"url\":\"/swagger-ui.html\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 16:20:14');
INSERT INTO `sys_log` VALUES ('0bf05da6-1178-4529-8cb5-f11c8c110e73', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 3, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:00:02');
INSERT INTO `sys_log` VALUES ('0c90758d-706f-426e-b672-ce838d4a3b2a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 66, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:36:48');
INSERT INTO `sys_log` VALUES ('0eea701f-5852-4507-bf22-b21e2ef95bed', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 12, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-05 12:07:24');
INSERT INTO `sys_log` VALUES ('0fb96511-fe4b-48d6-b1a8-574bda901587', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 87, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:55:47');
INSERT INTO `sys_log` VALUES ('10326021-68df-4b72-983d-d2abb11bec07', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:38:03');
INSERT INTO `sys_log` VALUES ('11dff46a-da16-40a4-8852-1c671c13547b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 20, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:55:56');
INSERT INTO `sys_log` VALUES ('12e3702d-a15d-4915-b541-3d667825365e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-保存个人用户信息接口', 22, 'com.yingxue.lesson.controller.UserController.updateUserInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:56:26');
INSERT INTO `sys_log` VALUES ('12eff4b3-1373-43c2-9f17-4ab0cb3de83b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 68, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:45:46');
INSERT INTO `sys_log` VALUES ('13764825-574a-4cf5-a0ba-d218ba421fdf', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 31, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:37:46');
INSERT INTO `sys_log` VALUES ('138c14d9-a190-40fd-9659-c46280d9f428', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 22, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 19:21:20');
INSERT INTO `sys_log` VALUES ('1426716c-a16f-4f6a-809d-2c26406c1325', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 105, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 02:26:59');
INSERT INTO `sys_log` VALUES ('142d574f-a54e-4036-9436-0ba680feeeb7', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 625, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 02:26:50');
INSERT INTO `sys_log` VALUES ('1579ba57-f3e5-486b-bca5-f7f7332c1c08', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 15, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-05 12:12:01');
INSERT INTO `sys_log` VALUES ('158752b9-c9dd-435e-886b-be7ffabe49d8', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 53, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\"]', '0:0:0:0:0:0:0:1', '2020-05-01 22:26:45');
INSERT INTO `sys_log` VALUES ('179f35e3-4a51-4c4d-a60b-b10f0ee856ff', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 11, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 02:27:01');
INSERT INTO `sys_log` VALUES ('19f9dc46-0524-48c6-b358-70dec028f171', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 6, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:36:50');
INSERT INTO `sys_log` VALUES ('1ab29a8f-8062-430f-ad63-294b92ea8e72', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 38, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 11:29:49');
INSERT INTO `sys_log` VALUES ('1b7fb641-92b5-4b98-acf0-07d11979c946', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 17, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:54:33');
INSERT INTO `sys_log` VALUES ('1cc0f524-4235-4e04-aa8f-773c15a345c9', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-用户信息详情接口', 9, 'com.yingxue.lesson.controller.UserController.detailInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 18:00:18');
INSERT INTO `sys_log` VALUES ('21291bee-6f67-47bd-948e-b29cb6b6ac62', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 16, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-05 12:12:05');
INSERT INTO `sys_log` VALUES ('217d23b5-5697-4534-90c1-f84bef293da6', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 17, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 15:00:17');
INSERT INTO `sys_log` VALUES ('2255370d-f97b-4f22-84db-c286bed0f91a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 27, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 21:52:24');
INSERT INTO `sys_log` VALUES ('229b5831-d8a6-4dbf-bea2-818656451ec6', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-更新角色信息接口', 191, 'com.yingxue.lesson.controller.RoleController.updateRole()', '[{\"description\":\"\",\"id\":\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\",\"name\":\"test\",\"permissions\":[\"346df872-8964-4455-8afd-ffa6308fb18a\",\"c198d1cb-ad4d-4001-9375-9ec8ee04053d\",\"f9f4d9f4-a2f5-430c9f2d-6c8e650a8c39\",\"290c0240-0914-487cb4e9-6635bf5ebfec\",\"390ded0e-9f48-40a7-a841-791c203f22ae\",\"8f393e44-b585-4875-866d-71f88fea9659\",\"39313e6a-14ed-4224-a91e-ef6a10ba54cd\",\"9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63\",\"47697e92-e199-4420-a2c2-09ec1b08cb9d\",\"4caeb861-354c-45f6-98b4-59f486beb511\",\"0545d9d1-c82c-44c2-85e5-0b6ac4042515\",\"03dc1cbf-ef44-4326-a7dc-10fe16d22dad\",\"15bb6aff-2e3b-490aa21f-0167ae0ebc0d\"],\"status\":1}]', '0:0:0:0:0:0:0:1', '2020-05-02 02:29:37');
INSERT INTO `sys_log` VALUES ('26cf9bf9-6531-4458-8201-67548651ce11', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 87, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:51:22');
INSERT INTO `sys_log` VALUES ('279f50e2-778d-4d4f-9f06-8863f7799b04', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-部门管理-查询部门树形结构列表接口', 18, 'com.yingxue.lesson.controller.DeptController.getDeptTree()', '[null]', '0:0:0:0:0:0:0:1', '2020-05-01 17:56:53');
INSERT INTO `sys_log` VALUES ('27ab895f-919d-448a-8ba6-ba82ca8dac97', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-编辑菜单权限接口', 74, 'com.yingxue.lesson.controller.PermissionController.updatePermission()', '[{\"code\":\"\",\"id\":\"6da8c727-3391-45d7-9e8f-5e80a644dd02\",\"method\":\"\",\"name\":\"日志管理\",\"orderNum\":99,\"perms\":\"\",\"pid\":\"5ef1b976-f871-4acf-a167-8fd9a438fc1b\",\"status\":1,\"type\":2,\"url\":\"/index/logs\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 16:16:31');
INSERT INTO `sys_log` VALUES ('27ad9a51-27d9-4f80-a7df-192b7be39745', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 83, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\"]', '0:0:0:0:0:0:0:1', '2020-05-02 00:43:41');
INSERT INTO `sys_log` VALUES ('2c797be9-31d2-4b68-8726-e3ccc3a36291', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 17, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:30:01');
INSERT INTO `sys_log` VALUES ('2dfca715-547e-483a-970a-5f861c2cbd0b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 103, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 03:09:00');
INSERT INTO `sys_log` VALUES ('2e0dd93f-73c6-4900-8bb6-dc6c5bfe690c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 52, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:45:05');
INSERT INTO `sys_log` VALUES ('2eaec09b-cd93-4cf5-b76e-134ea57fc121', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '首页模块-获取首页数据接口', 103, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 00:38:18');
INSERT INTO `sys_log` VALUES ('2f29d2ae-570e-455f-84c2-ea18a78d39e8', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-更新角色信息接口', 52, 'com.yingxue.lesson.controller.RoleController.updateRole()', '[{\"description\":\"\",\"id\":\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\",\"name\":\"test\",\"permissions\":[\"346df872-8964-4455-8afd-ffa6308fb18a\",\"c198d1cb-ad4d-4001-9375-9ec8ee04053d\",\"f9f4d9f4-a2f5-430c9f2d-6c8e650a8c39\",\"290c0240-0914-487cb4e9-6635bf5ebfec\",\"390ded0e-9f48-40a7-a841-791c203f22ae\",\"8f393e44-b585-4875-866d-71f88fea9659\",\"39313e6a-14ed-4224-a91e-ef6a10ba54cd\",\"9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63\",\"47697e92-e199-4420-a2c2-09ec1b08cb9d\",\"4caeb861-354c-45f6-98b4-59f486beb511\",\"0545d9d1-c82c-44c2-85e5-0b6ac4042515\",\"03dc1cbf-ef44-4326-a7dc-10fe16d22dad\",\"15bb6aff-2e3b-490aa21f-0167ae0ebc0d\"],\"status\":1}]', '0:0:0:0:0:0:0:1', '2020-05-02 01:03:12');
INSERT INTO `sys_log` VALUES ('2f5abaf2-69ec-4df6-b6f5-f9c533bf4f4b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-jwt 刷新 token 接口', 15, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 22:31:02');
INSERT INTO `sys_log` VALUES ('2f799b50-104a-4790-8a03-037762a877a9', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 61, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 21:02:44');
INSERT INTO `sys_log` VALUES ('2ff6fbbf-e10d-4e00-a05b-74b6dbe9a723', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '组织模块-用户管理-jwt 刷新 token 接口', 52, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 02:30:55');
INSERT INTO `sys_log` VALUES ('3192b893-5bd0-473b-9063-9952a18502ea', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-查询用户拥有的角色数据接口', 6, 'com.yingxue.lesson.controller.UserController.getUserOwnRole()', '[\"81d01543-a856-4ef0-ae1e-806b11b57a1e\"]', '0:0:0:0:0:0:0:1', '2020-05-02 00:37:59');
INSERT INTO `sys_log` VALUES ('31e1741c-dcf9-4dcf-9481-6d9ecdafdea8', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 14, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:55:23');
INSERT INTO `sys_log` VALUES ('33ecee30-7efb-4f87-bc86-8ce55f7f8e22', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 61, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\"]', '0:0:0:0:0:0:0:1', '2020-05-01 22:29:52');
INSERT INTO `sys_log` VALUES ('35be3dff-7247-4e63-972f-bb50e3687a81', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 5, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 02:22:44');
INSERT INTO `sys_log` VALUES ('35e40b63-edef-4a98-8ac9-f70177a7600f', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 15, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:53:00');
INSERT INTO `sys_log` VALUES ('35f704ad-d674-4aaf-9463-e11777683b24', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 42, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:52:07');
INSERT INTO `sys_log` VALUES ('3620ddb4-fc1e-491c-bec3-cce11d1a9129', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 3, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:16:23');
INSERT INTO `sys_log` VALUES ('363010fd-4bb2-4b70-bf8c-2773c0d79101', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '首页模块-获取首页数据接口', 68, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 00:41:49');
INSERT INTO `sys_log` VALUES ('379840a5-2e5b-49e2-9f58-08fafc1b17e6', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 21, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:57:02');
INSERT INTO `sys_log` VALUES ('38a2816d-2885-468b-861b-b50025383a96', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 32, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:08:57');
INSERT INTO `sys_log` VALUES ('391611a2-f9ed-48ba-ba3e-00bac4f7e77c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 66, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:47:31');
INSERT INTO `sys_log` VALUES ('403879f4-1504-4494-aff6-d9d26d32ae99', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 41, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 00:54:52');
INSERT INTO `sys_log` VALUES ('4081b54e-3d86-4c7b-85dc-1e9135d4d6f7', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 6, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:22:11');
INSERT INTO `sys_log` VALUES ('414d47ea-b7b2-4e57-a690-14ea777c7862', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 60, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 04:12:41');
INSERT INTO `sys_log` VALUES ('417ea27b-565a-44a6-87e9-e05776bee283', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 28, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:00:00');
INSERT INTO `sys_log` VALUES ('418f8d7c-75c6-4ee3-ae97-cd8b2d2c3e2a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 26, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:51:34');
INSERT INTO `sys_log` VALUES ('42b16cd2-1658-41c6-a86f-bf21aca33594', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 73, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:54:13');
INSERT INTO `sys_log` VALUES ('43e15158-1137-422d-848f-b58e3dfefa18', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 17, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 02:29:37');
INSERT INTO `sys_log` VALUES ('449a0fd0-5916-47cf-a02a-ab5bfa3f1c8a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 19, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 02:22:42');
INSERT INTO `sys_log` VALUES ('4555c19a-4ed0-4b6f-8b80-f6de5e1ac158', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 40, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:51:26');
INSERT INTO `sys_log` VALUES ('45a46c1c-c032-40ea-a657-394da3d3c093', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 5, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:20:08');
INSERT INTO `sys_log` VALUES ('462ca916-2a57-4532-9b3a-25ed05b9b4b3', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 16, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:21:15');
INSERT INTO `sys_log` VALUES ('4661c429-1045-4ec1-806b-cc202aafbce5', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '系统管理-日志管理-删除日志接口', 26, 'com.yingxue.lesson.controller.LogController.deletedLog()', '[[\"4518e61c-4734-478c-889c-3b5a953d94cf\",\"4b0a1761-c48d-404b-aa25-e48443239bf5\"]]', '0:0:0:0:0:0:0:1', '2020-05-01 16:12:23');
INSERT INTO `sys_log` VALUES ('470f06f4-8f76-4af8-9c28-9dd75a1da78e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 8, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:31:04');
INSERT INTO `sys_log` VALUES ('474d0afa-1f5c-43ac-a578-feb67174a37c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 4, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:39:01');
INSERT INTO `sys_log` VALUES ('4826c7d7-243d-4bd1-a21b-c92c1cfea21e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 24, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 03:08:53');
INSERT INTO `sys_log` VALUES ('48c922ce-283c-405c-b6c0-70f34397e69b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 29, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 21:58:52');
INSERT INTO `sys_log` VALUES ('49cc6d1e-c1ad-4eae-9adf-32e7bdb9bccd', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 27, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 00:58:50');
INSERT INTO `sys_log` VALUES ('4a12e7b3-8b1f-46cf-8604-de10657b7b40', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 36, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:59:29');
INSERT INTO `sys_log` VALUES ('4bc237b8-e4b3-4598-a1d9-15b6025985f3', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 123, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-05 11:47:10');
INSERT INTO `sys_log` VALUES ('4cfa2d21-4f52-4533-a925-5e5e0b314b6a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 15, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:55:21');
INSERT INTO `sys_log` VALUES ('4ddabc33-6126-4d41-81e9-c9dfefeac6da', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-用户信息详情接口', 5, 'com.yingxue.lesson.controller.UserController.detailInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:56:30');
INSERT INTO `sys_log` VALUES ('5175845c-7382-4c02-b796-4a392d905b47', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 17, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:20:15');
INSERT INTO `sys_log` VALUES ('517b0b33-02fc-439e-9447-554ac6de5983', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-新增菜单权限接口', 111, 'com.yingxue.lesson.controller.PermissionController.addPermission()', '[{\"code\":\"\",\"method\":\"GET\",\"name\":\"SQL 监控\",\"orderNum\":98,\"perms\":\"\",\"pid\":\"5ef1b976-f871-4acf-a167-8fd9a438fc1b\",\"status\":1,\"type\":2,\"url\":\"/druid/sql.html\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 16:38:35');
INSERT INTO `sys_log` VALUES ('5192d09a-47dc-4238-93f4-bee8e63f1fd6', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 72, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\"]', '0:0:0:0:0:0:0:1', '2020-05-02 02:20:26');
INSERT INTO `sys_log` VALUES ('52d21818-64c8-41a9-913b-8d5c08c1d89a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 64, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:16:52');
INSERT INTO `sys_log` VALUES ('531aa914-0343-4201-9455-26940dfbeb0e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 33, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-04 17:02:20');
INSERT INTO `sys_log` VALUES ('5369aa84-1fca-455f-8caf-ee97e7d0b21b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 10, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:53:33');
INSERT INTO `sys_log` VALUES ('55dc1c33-5ef5-4b98-a067-4749b921b5a4', NULL, NULL, '组织模块-用户管理-jwt 刷新 token 接口', 5, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:16:00');
INSERT INTO `sys_log` VALUES ('5614989c-83ba-4e02-9e92-7453fc57486a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 17, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:37:30');
INSERT INTO `sys_log` VALUES ('56af3470-4e9a-4fc6-be44-d16fc3bc03be', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 78, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 15:16:34');
INSERT INTO `sys_log` VALUES ('58bdad8d-cebd-474b-872f-6036be076c73', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-更新角色信息接口', 111, 'com.yingxue.lesson.controller.RoleController.updateRole()', '[{\"description\":\"\",\"id\":\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\",\"name\":\"test\",\"permissions\":[\"346df872-8964-4455-8afd-ffa6308fb18a\",\"c198d1cb-ad4d-4001-9375-9ec8ee04053d\",\"f9f4d9f4-a2f5-430c9f2d-6c8e650a8c39\",\"290c0240-0914-487cb4e9-6635bf5ebfec\",\"390ded0e-9f48-40a7-a841-791c203f22ae\",\"8f393e44-b585-4875-866d-71f88fea9659\",\"39313e6a-14ed-4224-a91e-ef6a10ba54cd\",\"9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63\",\"47697e92-e199-4420-a2c2-09ec1b08cb9d\",\"4caeb861-354c-45f6-98b4-59f486beb511\",\"0545d9d1-c82c-44c2-85e5-0b6ac4042515\",\"03dc1cbf-ef44-4326-a7dc-10fe16d22dad\"],\"status\":1}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:37:23');
INSERT INTO `sys_log` VALUES ('5903bd0c-a10f-45dc-a464-848c95761e02', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 46, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:01:07');
INSERT INTO `sys_log` VALUES ('5a4418bb-ad13-45a3-af0e-4bab3fbe9053', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-更新角色信息接口', 74, 'com.yingxue.lesson.controller.RoleController.updateRole()', '[{\"description\":\"\",\"id\":\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\",\"name\":\"test\",\"permissions\":[\"346df872-8964-4455-8afd-ffa6308fb18a\",\"c198d1cb-ad4d-4001-9375-9ec8ee04053d\",\"f9f4d9f4-a2f5-430c9f2d-6c8e650a8c39\",\"290c0240-0914-487cb4e9-6635bf5ebfec\",\"390ded0e-9f48-40a7-a841-791c203f22ae\",\"8f393e44-b585-4875-866d-71f88fea9659\",\"39313e6a-14ed-4224-a91e-ef6a10ba54cd\",\"9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63\",\"47697e92-e199-4420-a2c2-09ec1b08cb9d\",\"4caeb861-354c-45f6-98b4-59f486beb511\",\"0545d9d1-c82c-44c2-85e5-0b6ac4042515\",\"03dc1cbf-ef44-4326-a7dc-10fe16d22dad\"],\"status\":1}]', '0:0:0:0:0:0:0:1', '2020-05-02 02:23:44');
INSERT INTO `sys_log` VALUES ('5a53120f-1092-4ae0-a6cc-67040bc0fe0b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 81, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:55:55');
INSERT INTO `sys_log` VALUES ('5e019597-1dcb-42e0-9711-1b54d5843f73', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 36, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:52:10');
INSERT INTO `sys_log` VALUES ('61ec404a-7ce9-409e-a3c2-5d198bc6b5da', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:32:01');
INSERT INTO `sys_log` VALUES ('62b7404b-3db3-4bd7-b419-4b5c560d0046', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 29, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:01:40');
INSERT INTO `sys_log` VALUES ('64fe3b95-47c6-41a1-af56-7786c4b48dae', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-新增菜单权限接口', 73, 'com.yingxue.lesson.controller.PermissionController.addPermission()', '[{\"code\":\"\",\"method\":\"\",\"name\":\"系统管理\",\"orderNum\":98,\"perms\":\"\",\"pid\":\"0\",\"status\":1,\"type\":1,\"url\":\"\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 15:14:11');
INSERT INTO `sys_log` VALUES ('65e75467-78e3-4df4-b430-97ec5e3a255a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-部门管理-查询部门树形结构列表接口', 12, 'com.yingxue.lesson.controller.DeptController.getDeptTree()', '[null]', '0:0:0:0:0:0:0:1', '2020-05-02 00:37:31');
INSERT INTO `sys_log` VALUES ('66b872ad-839a-4c0d-97cc-6343cd8746da', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 52, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:21:23');
INSERT INTO `sys_log` VALUES ('68d98092-3e48-402d-9187-aad56f5254a0', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 48, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:17:40');
INSERT INTO `sys_log` VALUES ('6c1364e6-17ce-4b7b-bf86-5b0f8cebd700', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 22, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 21:00:17');
INSERT INTO `sys_log` VALUES ('6caf739c-2c7a-48d0-b47a-fae027d3ce26', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 14, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:37:52');
INSERT INTO `sys_log` VALUES ('6cd5ec15-4354-4073-8ea8-e78e74ec6a5a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-保存用户新拥有的角色信息接口', 29, 'com.yingxue.lesson.controller.UserController.saveUserOwnRole()', '[{\"roleIds\":[\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\"],\"userId\":\"81d01543-a856-4ef0-ae1e-806b11b57a1e\"}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:38:03');
INSERT INTO `sys_log` VALUES ('6dda914e-451a-401f-94b6-b4cdce433852', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 5, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:26:41');
INSERT INTO `sys_log` VALUES ('6df913ad-d146-4964-b86d-23af3a1cec75', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-更新角色信息接口', 1677, 'com.yingxue.lesson.controller.RoleController.updateRole()', '[{\"description\":\"我是超级管理员\",\"id\":\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\",\"name\":\"超级管理员\",\"permissions\":[\"346df872-8964-4455-8afd-ffa6308fb18a\",\"c198d1cb-ad4d-4001-9375-9ec8ee04053d\",\"290c0240-0914-487cb4e9-6635bf5ebfec\",\"8f393e44-b585-4875-866d-71f88fea9659\",\"9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63\",\"4caeb861-354c-45f6-98b4-59f486beb511\",\"0545d9d1-c82c-44c2-85e5-0b6ac4042515\",\"24b7b13c-f00f-4e6ba221-fe2d780e4d4f\",\"7141c2e9-6d50-46b6-94e8-100466b7249f\"],\"status\":1}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:26:41');
INSERT INTO `sys_log` VALUES ('6e254603-7b38-485c-83d5-c628fc397570', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-05 12:10:24');
INSERT INTO `sys_log` VALUES ('6e78ff7b-94e8-4e30-94d6-a9d11a868e66', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 56, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:54:30');
INSERT INTO `sys_log` VALUES ('6e9772eb-c845-4a3f-a80a-356d9caf8ac6', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 11, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 15:01:43');
INSERT INTO `sys_log` VALUES ('6ed25d57-a35d-4c7b-bd39-ff291b19032a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 16, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:52:54');
INSERT INTO `sys_log` VALUES ('6eed4369-4e7a-4f9d-8b88-fedce6f312e4', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 15, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:37:56');
INSERT INTO `sys_log` VALUES ('71368551-e644-4272-ac77-5e0b6461d300', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 15, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:36:19');
INSERT INTO `sys_log` VALUES ('7260c173-6010-46ab-89de-839a8198d863', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 4, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 02:23:45');
INSERT INTO `sys_log` VALUES ('732febbb-3aa0-4b28-88da-a1a19b7f24ac', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 31, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:38:56');
INSERT INTO `sys_log` VALUES ('740f53f5-b90e-4343-90dc-56ee4d2f40ef', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 28, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:53:44');
INSERT INTO `sys_log` VALUES ('74265d01-8531-4a6d-b8e7-ac8f80b85e76', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 23, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:16:57');
INSERT INTO `sys_log` VALUES ('7444c046-adc4-4795-afc3-1744504f2745', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 24, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:48:53');
INSERT INTO `sys_log` VALUES ('7556e78d-d6df-404c-9c53-0d5e402930ba', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 80, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\"]', '0:0:0:0:0:0:0:1', '2020-05-01 22:29:17');
INSERT INTO `sys_log` VALUES ('756b3475-f038-494d-b39f-2d2620b1c655', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 2, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:58:42');
INSERT INTO `sys_log` VALUES ('75c5afd9-a2d0-4356-842d-528d299c9d0e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 88, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:23:10');
INSERT INTO `sys_log` VALUES ('763201c8-d959-45d3-8b8b-26bba3924fef', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-新增菜单权限接口', 31, 'com.yingxue.lesson.controller.PermissionController.addPermission()', '[{\"code\":\"btn-user-list\",\"method\":\"POST\",\"name\":\"查询用户信息列表权限\",\"orderNum\":100,\"perms\":\"sys:user:list\",\"pid\":\"267e9cc5-584e-472f-8661-d5b09827be49\",\"status\":1,\"type\":3,\"url\":\"/api/users\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 19:56:02');
INSERT INTO `sys_log` VALUES ('77f150d2-eb4a-404e-9951-5e6099fac37d', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 19, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 00:59:39');
INSERT INTO `sys_log` VALUES ('79b66d25-7eb0-4001-a03b-f15e91647271', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '首页模块-获取首页数据接口', 11, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 02:24:05');
INSERT INTO `sys_log` VALUES ('79d5942e-e0e5-48f3-85f7-04e84bee26c7', NULL, NULL, '组织模块-用户管理-jwt 刷新 token 接口', 54, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 03:08:32');
INSERT INTO `sys_log` VALUES ('7a07fddd-e7a2-4acb-8d1f-4be97f54e968', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 40, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:05:58');
INSERT INTO `sys_log` VALUES ('7d2239fc-7432-49cd-bda5-b9373380b76c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 3, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:56:16');
INSERT INTO `sys_log` VALUES ('7e18333b-e255-445f-8243-1510a573fa90', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 52, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 17:06:31');
INSERT INTO `sys_log` VALUES ('7f5d15be-aca5-4d15-8de1-87937de7890f', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 109, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\"]', '0:0:0:0:0:0:0:1', '2020-05-02 00:36:56');
INSERT INTO `sys_log` VALUES ('7fffbfb9-64f4-41f7-8b10-cbc5cf06cd80', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '系统管理-日志管理-删除日志接口', 42, 'com.yingxue.lesson.controller.LogController.deletedLog()', '[[\"43802fd6-0a7c-4833-96c0-43e41d801af6\"]]', '0:0:0:0:0:0:0:1', '2020-05-01 16:11:04');
INSERT INTO `sys_log` VALUES ('80f849f1-b06c-4af2-a117-852fb112826a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 54, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:28:17');
INSERT INTO `sys_log` VALUES ('815a4e66-3ecc-4c2f-86bf-6ad34f745a46', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 18, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 17:56:33');
INSERT INTO `sys_log` VALUES ('826683f0-3262-4954-a022-bc85dcbae980', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-用户信息详情接口', 8, 'com.yingxue.lesson.controller.UserController.detailInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:37:06');
INSERT INTO `sys_log` VALUES ('82a475c4-460c-4697-9600-8a85b4683f53', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 9, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:43:39');
INSERT INTO `sys_log` VALUES ('85975bfb-9438-4e85-9794-ef6aae677fb2', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 80, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 17:02:23');
INSERT INTO `sys_log` VALUES ('861c9bac-5f0c-4f5a-a17e-24c37ba5066b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 15, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:19:38');
INSERT INTO `sys_log` VALUES ('88f72093-ba55-4d2d-a91e-efb3edb8da5f', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 12, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:29:35');
INSERT INTO `sys_log` VALUES ('89828a34-add5-454c-9511-d6716fb204a3', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 62, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 02:20:20');
INSERT INTO `sys_log` VALUES ('89ffac6c-0b15-4ffd-a27c-209f2b85ff1a', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '组织模块-用户管理-jwt 刷新 token 接口', 26, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 01:03:21');
INSERT INTO `sys_log` VALUES ('8e679d17-0e2e-4858-aaf0-854d3697e77d', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 5, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 15:13:45');
INSERT INTO `sys_log` VALUES ('8e82a4cc-7fca-462b-9dce-bfe5140247c6', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '首页模块-获取首页数据接口', 29, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 02:27:45');
INSERT INTO `sys_log` VALUES ('903f07cb-c46e-460d-92f9-ded4ac910965', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 125, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\"]', '0:0:0:0:0:0:0:1', '2020-05-02 02:27:38');
INSERT INTO `sys_log` VALUES ('904a90e2-d2be-4282-bd39-6d7fc0cd5448', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 54, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:52:08');
INSERT INTO `sys_log` VALUES ('92fb6031-89ac-43cb-b676-9ebfdce1da89', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-新增菜单权限接口', 22, 'com.yingxue.lesson.controller.PermissionController.addPermission()', '[{\"code\":\"\",\"method\":\"GET\",\"name\":\"接口管理\",\"orderNum\":100,\"perms\":\"\",\"pid\":\"5ef1b976-f871-4acf-a167-8fd9a438fc1b\",\"status\":1,\"type\":2,\"url\":\"/swagger-ui.thml\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 16:16:01');
INSERT INTO `sys_log` VALUES ('9527fc3e-63b8-4f85-b204-568ca97c6258', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 19, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 14:39:39');
INSERT INTO `sys_log` VALUES ('95fad76f-3a26-447c-9e70-db07ec5fb63c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 40, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 15:39:46');
INSERT INTO `sys_log` VALUES ('972b181b-204c-426c-9762-4e7bd25a7e33', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 45, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 21:04:39');
INSERT INTO `sys_log` VALUES ('977259ac-9c2f-4822-a465-db2a632eb3ed', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '组织管理-角色管理-分页获取角色数据接口', 7, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:38:29');
INSERT INTO `sys_log` VALUES ('9837b4e5-d1c8-4e2a-95f7-4b402e4dc955', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-jwt 刷新 token 接口', 3, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 22:31:03');
INSERT INTO `sys_log` VALUES ('983c5666-fc76-4a38-b3d1-7d6c2c1ee68c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 56, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 00:33:13');
INSERT INTO `sys_log` VALUES ('98f1ab8a-1a94-488c-aeab-88a70cdece45', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 167, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 23:51:14');
INSERT INTO `sys_log` VALUES ('990735aa-a5a3-477b-a726-a0fc7216d56a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 64, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 21:07:29');
INSERT INTO `sys_log` VALUES ('994b52bc-ca43-4e8a-8a74-2de5b4824796', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 10, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 15:14:19');
INSERT INTO `sys_log` VALUES ('9aaf7742-817c-45ff-8312-13b6d1bcb872', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-新增菜单权限接口', 101, 'com.yingxue.lesson.controller.PermissionController.addPermission()', '[{\"code\":\"btn-user-add\",\"method\":\"POST\",\"name\":\"新增用户权限\",\"orderNum\":100,\"perms\":\"sys:user:add\",\"pid\":\"267e9cc5-584e-472f-8661-d5b09827be49\",\"status\":1,\"type\":3,\"url\":\"/api/user\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 19:57:27');
INSERT INTO `sys_log` VALUES ('9c52a4a7-e0a4-4bed-9cb0-e4e5567f0542', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 123, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 00:32:40');
INSERT INTO `sys_log` VALUES ('9ca15ede-f8bb-4c3d-a38d-620fc855150e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-修改个人用户密码接口', 62, 'com.yingxue.lesson.controller.UserController.updateUserInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:48:34');
INSERT INTO `sys_log` VALUES ('9ccd3616-182b-41e0-9d86-443c449a5a7f', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 22, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:35:49');
INSERT INTO `sys_log` VALUES ('9d127b82-11bf-4103-b8a4-6097dfd8cb0c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-更新角色信息接口', 51, 'com.yingxue.lesson.controller.RoleController.updateRole()', '[{\"description\":\"我是超级管理员\",\"id\":\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\",\"name\":\"超级管理员\",\"permissions\":[\"346df872-8964-4455-8afd-ffa6308fb18a\",\"c198d1cb-ad4d-4001-9375-9ec8ee04053d\",\"2eeaa020-74d5-4c4b9849-2cf4bd68fed9\",\"65734896-90c5-4b48-b9e8-dee47a74a297\",\"84b9b525-aa44-4b16-9900-adca26115a37\",\"90b3be91-5e9d-42f8-81fb-0c9ef3014faa\",\"f9f4d9f4-a2f5-430c9f2d-6c8e650a8c39\",\"290c0240-0914-487cb4e9-6635bf5ebfec\",\"2f9a3f67-6ef3-4eacb9a1-c0e898718d0c\",\"390ded0e-9f48-40a7-a841-791c203f22ae\",\"bb5ca869-0303-4fc0-b067-936cba7d1cc8\",\"e136cc74-9817-4ef1-b181-8f1afd7e102c\",\"8f393e44-b585-4875-866d-71f88fea9659\",\"013095aa-0f4d-4c32-b30e-229a587e52ad\",\"27acf73b-2fcb-451bbdc4-e11e5ab41e2a\",\"39313e6a-14ed-4224-a91e-ef6a10ba54cd\",\"b7348d63-c4d3-406d9e46-543346674275\",\"9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63\",\"145cb90b-d205-40f6-8a2d-703f41ed1feb\",\"2ae13993-9501-46d5-8473-fe45fee57f3b\",\"47697e92-e199-4420-a2c2-09ec1b08cb9d\",\"d41c2bc3-454c-4f62-84fe-97825d5cf8a7\",\"d60faf3e-9a72-49d5-b02d-a67bfeff07fa\",\"4caeb861-354c-45f6-98b4-59f486beb511\",\"0545d9d1-c82c-44c2-85e5-0b6ac4042515\",\"03dc1cbf-ef44-4326-a7dc-10fe16d22dad\",\"15bb6aff-2e3b-490aa21f-0167ae0ebc0d\",\"24b7b13c-f00f-4e6ba221-fe2d780e4d4f\",\"7141c2e9-6d50-46b6-94e8-100466b7249f\"],\"status\":1}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:29:35');
INSERT INTO `sys_log` VALUES ('9e2b07b2-f680-44ff-9d21-657bd8dbc1d4', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 71, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\"]', '0:0:0:0:0:0:0:1', '2020-05-01 22:26:31');
INSERT INTO `sys_log` VALUES ('9e50a370-7a12-47af-9f3e-6b540e75ade7', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 23, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:38:35');
INSERT INTO `sys_log` VALUES ('9e6abae8-bb60-4ce0-8651-a4a47df293a3', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 20, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 04:12:44');
INSERT INTO `sys_log` VALUES ('9eb9e92e-ea05-4920-82bb-8eb02ba1df35', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 70, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:35:58');
INSERT INTO `sys_log` VALUES ('9f322fbb-8150-49c5-87e7-dbb46c27db5f', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 9, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 02:20:22');
INSERT INTO `sys_log` VALUES ('9f5c2cd1-35b4-4541-83e3-563d40866653', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 18, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:54:32');
INSERT INTO `sys_log` VALUES ('a04a64a0-8277-40b0-ad1a-300d653d679b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 111, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 00:35:56');
INSERT INTO `sys_log` VALUES ('a19ce1df-dc50-4e46-a2cf-8bd3d1aaa424', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 92, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:42:16');
INSERT INTO `sys_log` VALUES ('a38461b4-b302-4ad3-ae6e-79c16838abfa', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '组织模块-用户管理-jwt 刷新 token 接口', 21, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 02:23:49');
INSERT INTO `sys_log` VALUES ('a39d88ce-20c4-4a67-ade2-6711cc65932d', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 14, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:29:57');
INSERT INTO `sys_log` VALUES ('a5c68ea1-2125-4e6a-964d-32711bf88640', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 62, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 01:38:20');
INSERT INTO `sys_log` VALUES ('a5ca23b9-09b7-454e-a37e-c796441c72e5', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 66, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\"]', '0:0:0:0:0:0:0:1', '2020-05-02 02:23:40');
INSERT INTO `sys_log` VALUES ('a9bd1b2e-83cb-4efa-9c1a-e09f528dd5d3', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 19, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:38:00');
INSERT INTO `sys_log` VALUES ('ab143f77-e22e-4f6a-990b-532e14662978', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 33, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:57:21');
INSERT INTO `sys_log` VALUES ('ab327e87-a76a-43a2-8a0b-c3830cb1cbf5', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 16, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:53:25');
INSERT INTO `sys_log` VALUES ('ac110ae0-2a36-45f3-b125-af2f35e92fff', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 24, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:20:14');
INSERT INTO `sys_log` VALUES ('ac363a96-d9e0-476a-bced-c73b733cc743', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 43, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 21:15:45');
INSERT INTO `sys_log` VALUES ('ada06379-22ba-460e-81e2-a0e6ead1283c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 17, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:15:09');
INSERT INTO `sys_log` VALUES ('ae335183-e8f3-4a67-97e3-73d95effd556', NULL, NULL, '组织模块-用户管理-jwt 刷新 token 接口', 6, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 22:21:13');
INSERT INTO `sys_log` VALUES ('ae652039-e388-4be7-b3ba-fc699b983df6', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 48, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:15:02');
INSERT INTO `sys_log` VALUES ('afa0c474-a8e0-483c-bf1b-4270d4eb459c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 31, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:47:28');
INSERT INTO `sys_log` VALUES ('aff55041-d9c1-4f2d-b8ea-8ddd60d20596', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 13, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:06:57');
INSERT INTO `sys_log` VALUES ('b0ed1d74-816c-459e-b0d5-878de3b99df0', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 33, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 15:05:02');
INSERT INTO `sys_log` VALUES ('b18ffff1-d520-43b4-8ed7-a19ab5b6c52b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 56, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:28:04');
INSERT INTO `sys_log` VALUES ('b5a96794-1478-40a2-8104-79d8311ebd6d', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 28, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:56:09');
INSERT INTO `sys_log` VALUES ('b5cad741-2d1d-49e7-b9f3-c781d39cb69b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 48, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\"]', '0:0:0:0:0:0:0:1', '2020-05-01 22:22:02');
INSERT INTO `sys_log` VALUES ('b8d98044-3abc-403a-b608-0e5580221d89', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 43, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:16:41');
INSERT INTO `sys_log` VALUES ('b95392ce-36b2-4677-be3d-4e92604222dc', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 55, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:20:05');
INSERT INTO `sys_log` VALUES ('b99e4e71-aae6-4f2c-adae-44bc87b3e273', NULL, NULL, '组织模块-用户管理-jwt 刷新 token 接口', 38, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 14:15:51');
INSERT INTO `sys_log` VALUES ('ba6bd4d1-a9fc-4225-8dbd-a1030fdd4493', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 81, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:37:03');
INSERT INTO `sys_log` VALUES ('ba7cf9e6-43e7-4127-9a72-2adde911da8c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:30:05');
INSERT INTO `sys_log` VALUES ('bad7d764-c18f-4d74-98ae-caf0ac4910ca', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-新增用户接口', 78, 'com.yingxue.lesson.controller.UserController.addUser()', '[{\"deptId\":\"3d89fdd3-7f80-4fbf-8e6d-c0583cc66179\",\"password\":\"666666\",\"phone\":\"13888888888\",\"status\":1,\"username\":\"test\"}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:37:56');
INSERT INTO `sys_log` VALUES ('bb33a02b-0e47-4954-8ada-60e75a3848b5', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 23, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:36:55');
INSERT INTO `sys_log` VALUES ('bbe1d3d7-ea60-4b5b-af6c-5cc4dc22b933', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 3, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:57:43');
INSERT INTO `sys_log` VALUES ('bc92192e-7be0-46b3-ad16-45fefe3eff47', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 38, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 15:37:33');
INSERT INTO `sys_log` VALUES ('bdfa6829-0117-4622-a926-9c62b774a1bf', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 28, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:42:32');
INSERT INTO `sys_log` VALUES ('bf05eb97-d044-46da-9bee-ec283f6db06d', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 14, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:51:38');
INSERT INTO `sys_log` VALUES ('c06d2e0a-b15f-4b9c-8507-cd1f01be206d', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 22, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-05 12:11:22');
INSERT INTO `sys_log` VALUES ('c1c9743f-4937-45ec-9d58-f60f610f976c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 12, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:13:18');
INSERT INTO `sys_log` VALUES ('c20a54f8-6360-4558-9a77-225e0506d465', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 71, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 18:08:01');
INSERT INTO `sys_log` VALUES ('c256ac56-a08a-4bc1-a058-7f1596f224be', NULL, NULL, '组织模块-用户管理-jwt 刷新 token 接口', 5, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:21:19');
INSERT INTO `sys_log` VALUES ('c44dd14a-fa57-4a58-be64-ddf26773ba20', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 44, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 17:11:30');
INSERT INTO `sys_log` VALUES ('c5b794c4-4f56-46a4-b7f3-08945ca0541e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 3, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:17:01');
INSERT INTO `sys_log` VALUES ('c6583c57-b490-4dc7-be4b-bd2b9476902a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 20, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:16:31');
INSERT INTO `sys_log` VALUES ('c68cae05-70c0-45f6-9b2a-99528f3bc85e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:31:11');
INSERT INTO `sys_log` VALUES ('c75b2507-c3af-4b79-989d-9273fc91b1b0', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '组织管理-角色管理-分页获取角色数据接口', 17, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:42:31');
INSERT INTO `sys_log` VALUES ('c763427a-a553-4626-9fda-55d1d7d67c25', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 83, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:44:46');
INSERT INTO `sys_log` VALUES ('c771c827-6b99-49fd-b9af-f7672d1cb57c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 35, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 15:20:57');
INSERT INTO `sys_log` VALUES ('c7f4a3e9-ba28-4ddb-a62e-8b44383135ff', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 56, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 21:15:16');
INSERT INTO `sys_log` VALUES ('c80f74f9-2736-474f-8d6e-371c32ed1df7', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-保存个人用户信息接口', 46, 'com.yingxue.lesson.controller.UserController.updateUserInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:54:51');
INSERT INTO `sys_log` VALUES ('c8256fec-c44e-4dbc-90df-146fbd2153ca', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 8, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 00:37:23');
INSERT INTO `sys_log` VALUES ('c8ea8b2d-8a07-4f7e-a9eb-07a1a14028c1', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 122, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 14:39:23');
INSERT INTO `sys_log` VALUES ('c94c8cf6-0ee5-4fbb-a4fd-8505e1ecd77b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:17:56');
INSERT INTO `sys_log` VALUES ('c966173f-c1ad-4ffb-bd90-7ca0ad30eb59', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 66, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 15:13:37');
INSERT INTO `sys_log` VALUES ('ca4423bd-d1e5-4ff3-b92f-feaa3cc9ca47', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 99, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 23:00:14');
INSERT INTO `sys_log` VALUES ('ca823364-383d-4878-9c2f-0757d14a37ff', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 10, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:57:23');
INSERT INTO `sys_log` VALUES ('ccdb8750-1178-402b-8d36-2158fc2403a4', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 66, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-05 12:08:47');
INSERT INTO `sys_log` VALUES ('cd3b63df-5257-4392-8b05-d4aaf9bedae8', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 14, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:57:26');
INSERT INTO `sys_log` VALUES ('cd44551f-4159-454c-85d3-2d8fdab0729f', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 22, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:16:01');
INSERT INTO `sys_log` VALUES ('ce0aac73-39a8-4bcb-bd73-da1f530bad03', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:32:07');
INSERT INTO `sys_log` VALUES ('ce176178-d296-4231-be8c-109d51e54e47', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 28, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:58:40');
INSERT INTO `sys_log` VALUES ('ce203833-d099-4136-a86d-49b998ed8b63', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 67, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:41:06');
INSERT INTO `sys_log` VALUES ('cfeee656-d3aa-4801-b25d-890caf8e6ae7', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 68, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:33:31');
INSERT INTO `sys_log` VALUES ('d0076380-6148-40d5-8857-e6d3571f2a6c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 47, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-04 21:36:53');
INSERT INTO `sys_log` VALUES ('d0ebe6b7-1829-4d58-ada7-c91e65e2a296', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 19, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 15:13:41');
INSERT INTO `sys_log` VALUES ('d0f1025c-72d5-4096-b7cc-ab589b265130', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-菜单权限树接口-只递归查询到菜单', 5, 'com.yingxue.lesson.controller.PermissionController.getAllPermissionTreeExcBtn()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 15:13:38');
INSERT INTO `sys_log` VALUES ('d18a1237-725f-4a20-8ce5-16eacfb79619', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-查询用户拥有的角色数据接口', 4, 'com.yingxue.lesson.controller.UserController.getUserOwnRole()', '[\"fcf34b56-a7a2-4719-9236-867495e74c31\"]', '0:0:0:0:0:0:0:1', '2020-05-01 22:30:00');
INSERT INTO `sys_log` VALUES ('d1f46438-b4d0-472e-ad4a-33bfb334f87e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-新增菜单权限接口', 43, 'com.yingxue.lesson.controller.PermissionController.addPermission()', '[{\"code\":\"btn-user-update\",\"method\":\"PUT\",\"name\":\"列表更新用户信息权限\",\"orderNum\":100,\"perms\":\"sys:user:update\",\"pid\":\"267e9cc5-584e-472f-8661-d5b09827be49\",\"status\":1,\"type\":3,\"url\":\"/api/user\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 20:00:00');
INSERT INTO `sys_log` VALUES ('d3403831-8dfa-41fd-aa3a-756f7f239c19', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 29, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:20:18');
INSERT INTO `sys_log` VALUES ('d42c5173-1136-4439-9b4c-22aeafd7ed6b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 4, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:26:53');
INSERT INTO `sys_log` VALUES ('d44efe7c-e7d1-407c-8edc-dd81ce9b7916', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 30, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 16:38:47');
INSERT INTO `sys_log` VALUES ('d4b4a84c-b2e2-401a-a8e8-d5cea2af08eb', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 16, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 00:43:32');
INSERT INTO `sys_log` VALUES ('d5def289-0e55-4b8e-b374-e61c0abb5ede', NULL, NULL, '组织模块-用户管理-jwt 刷新 token 接口', 64, 'com.yingxue.lesson.controller.UserController.refreshToken()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:28:03');
INSERT INTO `sys_log` VALUES ('d88cd28e-3245-4628-abe3-93603d4a5d4c', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-部门管理-查询所有部门数据接口', 25, 'com.yingxue.lesson.controller.DeptController.getAllDept()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 04:12:58');
INSERT INTO `sys_log` VALUES ('d91b5005-4e2d-4dbc-8d89-b3176a21e224', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-更新角色信息接口', 16, 'com.yingxue.lesson.controller.RoleController.updateRole()', '[{\"description\":\"我是超级管理员\",\"id\":\"e94d71dd-19ef-4a7c-b007-8eedc6e309de\",\"name\":\"超级管理员\",\"permissions\":[],\"status\":1}]', '0:0:0:0:0:0:0:1', '2020-05-01 22:26:53');
INSERT INTO `sys_log` VALUES ('dbd593d3-22da-4c25-ab94-f60238e089fe', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-用户信息详情接口', 41, 'com.yingxue.lesson.controller.UserController.detailInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 18:13:21');
INSERT INTO `sys_log` VALUES ('dfdb24ae-576d-4043-978b-14bbb24e7c84', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 80, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:10:15');
INSERT INTO `sys_log` VALUES ('e0a0d64e-f030-41f6-a2b0-55585cb317da', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 33, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:35:08');
INSERT INTO `sys_log` VALUES ('e18671e2-08e6-42cb-bb2c-37742423bac8', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 23, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 19:57:27');
INSERT INTO `sys_log` VALUES ('e232f7e5-2718-4ecf-8bc4-a7ff90de3a16', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-用户信息详情接口', 3, 'com.yingxue.lesson.controller.UserController.detailInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:54:55');
INSERT INTO `sys_log` VALUES ('e32eaed2-b87f-49b5-9801-cfc8abf0092a', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', '首页模块-获取首页数据接口', 233, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 03:08:20');
INSERT INTO `sys_log` VALUES ('e7085a09-2500-446b-b28e-553fce2330bc', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 13, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 14:36:15');
INSERT INTO `sys_log` VALUES ('e83c5bee-125e-4342-a90a-6253ad5ca742', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 92, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 04:12:49');
INSERT INTO `sys_log` VALUES ('e848c824-f797-41d2-812e-2e791a9aad33', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-用户信息详情接口', 39, 'com.yingxue.lesson.controller.UserController.detailInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 04:17:40');
INSERT INTO `sys_log` VALUES ('e9b513e5-03e1-4883-ab04-c9f011666b73', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-新增菜单权限接口', 87, 'com.yingxue.lesson.controller.PermissionController.addPermission()', '[{\"code\":\" btn-user-delete\",\"method\":\"DELETE\",\"name\":\"删除用户权限\",\"orderNum\":100,\"perms\":\"sys:user:delete\",\"pid\":\"267e9cc5-584e-472f-8661-d5b09827be49\",\"status\":1,\"type\":3,\"url\":\"/api/use\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 20:01:40');
INSERT INTO `sys_log` VALUES ('ebdd22e4-179b-4d7a-8324-ec70c82d9878', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 26, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 03:08:33');
INSERT INTO `sys_log` VALUES ('ec372c52-e487-4f51-be9d-14a404391c49', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 04:13:01');
INSERT INTO `sys_log` VALUES ('ec56c776-7651-4f20-8d69-1293344e84df', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 29, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:07:48');
INSERT INTO `sys_log` VALUES ('ec6f6a5e-0f37-4446-a624-84e655bb6631', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-获取角色详情接口', 65, 'com.yingxue.lesson.controller.RoleController.detailInfo()', '[\"b1a145ad-15ba-4f89-b641-4cdfe5d290a8\"]', '0:0:0:0:0:0:0:1', '2020-05-02 02:24:38');
INSERT INTO `sys_log` VALUES ('ed3d7f1b-518f-4760-943d-a979b1079851', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 99, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 14:15:54');
INSERT INTO `sys_log` VALUES ('ef3768f4-2946-4b4f-9a0e-b3e8005a6f0b', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-用户信息详情接口', 6, 'com.yingxue.lesson.controller.UserController.detailInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:56:13');
INSERT INTO `sys_log` VALUES ('f072bc71-f215-46be-952a-9458f01a90b3', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 24, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 15:16:03');
INSERT INTO `sys_log` VALUES ('f2720daf-0b77-4f8b-94b6-8122db24fba2', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 79, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:07:18');
INSERT INTO `sys_log` VALUES ('f315e580-4b0e-4424-b44a-716b2832286d', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 79, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:17:39');
INSERT INTO `sys_log` VALUES ('f532a4c1-1e83-456b-a2a8-b4c04f3deaa1', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 28, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 00:58:17');
INSERT INTO `sys_log` VALUES ('f6c7b203-b414-4119-b50c-42e1e5c255c8', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-用户信息详情接口', 6, 'com.yingxue.lesson.controller.UserController.detailInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 20:44:50');
INSERT INTO `sys_log` VALUES ('f70d0f1b-0d6f-4b72-982d-269b48320f91', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '首页模块-获取首页数据接口', 33, 'com.yingxue.lesson.controller.HomeController.getHome()', NULL, '0:0:0:0:0:0:0:1', '2020-05-05 15:11:37');
INSERT INTO `sys_log` VALUES ('f7ea6026-d3c4-4e21-9abf-159ce878739a', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-用户信息详情接口', 7, 'com.yingxue.lesson.controller.UserController.detailInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 17:54:16');
INSERT INTO `sys_log` VALUES ('f893863f-b869-4ef4-aa39-69cca6d2a4cf', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-获取所有的菜单权限数据接口', 31, 'com.yingxue.lesson.controller.PermissionController.getAllPermission()', NULL, '0:0:0:0:0:0:0:1', '2020-05-01 15:14:11');
INSERT INTO `sys_log` VALUES ('f8fd940d-7686-427a-b4e6-916297f64849', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-保存个人用户信息接口', 112, 'com.yingxue.lesson.controller.UserController.saveUserInfo()', NULL, '0:0:0:0:0:0:0:1', '2020-05-02 04:17:55');
INSERT INTO `sys_log` VALUES ('fa33321c-87bb-4712-972d-ba81d25822f9', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 13, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-05 12:09:46');
INSERT INTO `sys_log` VALUES ('fa5c8360-e190-478a-82c6-5f1e6e41cbea', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 21, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 02:20:05');
INSERT INTO `sys_log` VALUES ('fc10a9d1-a18a-4563-988c-a594467e3ec2', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-角色管理-分页获取角色数据接口', 9, 'com.yingxue.lesson.controller.RoleController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-02 01:03:12');
INSERT INTO `sys_log` VALUES ('fc368fbc-3075-477f-a141-488cb27bbd2e', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 11, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:20:41');
INSERT INTO `sys_log` VALUES ('fcb58935-7963-4057-a540-6632ca3075e7', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织模块-用户管理-分页查询用户接口', 25, 'com.yingxue.lesson.controller.UserController.pageInfo()', '[{\"pageNum\":1,\"pageSize\":10}]', '0:0:0:0:0:0:0:1', '2020-05-04 22:12:28');
INSERT INTO `sys_log` VALUES ('fe614b40-d40a-4c46-b553-2c7fa22728d0', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '组织管理-菜单权限管理-新增菜单权限接口', 41, 'com.yingxue.lesson.controller.PermissionController.addPermission()', '[{\"code\":\"btn-user-update-role\",\"method\":\"PUT\",\"name\":\"赋予用户角色权限\",\"orderNum\":100,\"perms\":\"sys:user:role:update\",\"pid\":\"267e9cc5-584e-472f-8661-d5b09827be49\",\"status\":1,\"type\":3,\"url\":\"/api/user/roles\"}]', '0:0:0:0:0:0:0:1', '2020-05-01 19:58:40');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单权限编码',
  `name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单权限名称',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(如：sys:user:add)',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址URL',
  `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源请求类型',
  `pid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级菜单权限名称',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '菜单权限类型(1:目录;2:菜单;3:按钮)',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态1:正常 0：禁用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否删除(1未删除；0已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('013095aa-0f4d-4c32-b30e-229a587e52ad', 'btn-dept-add', '新增部门权限', 'sys:dept:add', '/api/dept', 'POST', '8f393e44-b585-4875-866d-71f88fea9659', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('03dc1cbf-ef44-4326-a7dc-10fe16d22dad', 'btn-log-list', '查询日志列表权限', 'sys:log:list', '/api/logs', 'POST', '0545d9d1-c82c-44c2-85e5-0b6ac4042515', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('0545d9d1-c82c-44c2-85e5-0b6ac4042515', '', '日志管理', '', '/index/logs', '', '4caeb861-354c-45f6-98b4-59f486beb511', 100, 2, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('145cb90b-d205-40f6-8a2d-703f41ed1feb', 'btn-user-delete', '删除用户权限', 'sys:user:delete', '/api/user', 'DELETE', '9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('15bb6aff-2e3b-490aa21f-0167ae0ebc0d', 'btn-log-delete', '删除日志权限', 'sys:log:delete', '/api/log', 'DELETE', '0545d9d1-c82c-44c2-85e5-0b6ac4042515', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('24b7b13c-f00f-4e6ba221-fe2d780e4d4f', '', '接口管理', '', '/swagger-ui.html', 'GET', '4caeb861-354c-45f6-98b4-59f486beb511', 97, 2, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('27acf73b-2fcb-451bbdc4-e11e5ab41e2a', 'btn-dept-delete', '删除部门权限', 'sys:dept:delete', '/api/dept/*', 'DELETE', '8f393e44-b585-4875-866d-71f88fea9659', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('290c0240-0914-487cb4e9-6635bf5ebfec', '', '菜单权限管理', '', '/index/menus', 'GET', '346df872-8964-4455-8afd-ffa6308fb18a', 99, 2, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('2ae13993-9501-46d5-8473-fe45fee57f3b', 'btn-user-add', '新增用户权限', 'sys:user:add', '/api/user', 'POST', '9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('2eeaa020-74d5-4c4b9849-2cf4bd68fed9', 'btn-role-update', '更新角色权限', 'sys:role:update', '/api/role', 'PUT', 'c198d1cb-ad4d-4001-9375-9ec8ee04053d', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('2f9a3f67-6ef3-4eacb9a1-c0e898718d0c', 'btn-permission-delete', '删除菜单权限', 'sys:permission:delete', '/api/permission', 'DELETE', '290c0240-0914-487cb4e9-6635bf5ebfec', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('346df872-8964-4455-8afd-ffa6308fb18a', '', '组织管理', '', '', '', '0', 100, 1, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('390ded0e-9f48-40a7-a841-791c203f22ae', 'btn-permission-list', '查询菜单权限列表权限', 'sys:permission:list', '/api/permissions', 'POST', '290c0240-0914-487cb4e9-6635bf5ebfec', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('39313e6a-14ed-4224-a91e-ef6a10ba54cd', 'btn-dept-list', '查询部门信息列表权限', 'sys:dept:list', '/api/depts', 'POST', '8f393e44-b585-4875-866d-71f88fea9659', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('47697e92-e199-4420-a2c2-09ec1b08cb9d', 'btn-user-list', '查询用户信息列表权限', 'sys:user:list', '/api/users', 'POST', '9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('4caeb861-354c-45f6-98b4-59f486beb511', '', '系统管理', '', '', '', '0', 98, 1, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('65734896-90c5-4b48-b9e8-dee47a74a297', 'btn-role-delete', '删除角色权限', 'sys:role:delete', '/api/role/*', 'DELETE', 'c198d1cb-ad4d-4001-9375-9ec8ee04053d', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('7141c2e9-6d50-46b6-94e8-100466b7249f', '', 'SQL监控', '', '/druid/sql.html', 'GET', '4caeb861-354c-45f6-98b4-59f486beb511', 96, 2, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('84b9b525-aa44-4b16-9900-adca26115a37', 'btn-role-add', '新增角色权限', 'sys:role:add', '/api/role', 'POST', 'c198d1cb-ad4d-4001-9375-9ec8ee04053d', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('8f393e44-b585-4875-866d-71f88fea9659', '', '部门管理', '', '/index/depts', '', '346df872-8964-4455-8afd-ffa6308fb18a', 97, 2, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('90b3be91-5e9d-42f8-81fb-0c9ef3014faa', 'btn-role-detail', '角色详情权限', 'sys:role:detail', '/api/role/*', 'GET', 'c198d1cb-ad4d-4001-9375-9ec8ee04053d', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63', '', '用户管理', '', '/index/users', '', '346df872-8964-4455-8afd-ffa6308fb18a', 96, 2, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('b7348d63-c4d3-406d9e46-543346674275', 'btn-dept-update', '更新部门信息权限', 'sys:dept:update', '/api/dept', 'PUT', '8f393e44-b585-4875-866d-71f88fea9659', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('bb5ca869-0303-4fc0-b067-936cba7d1cc8', 'btn-permission-update', '更新菜单权限', 'sys:permission:update', '/api/permission', 'PUT', '290c0240-0914-487cb4e9-6635bf5ebfec', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('c198d1cb-ad4d-4001-9375-9ec8ee04053d', '', '角色管理', '', '/index/roles', '', '346df872-8964-4455-8afd-ffa6308fb18a', 100, 2, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('d41c2bc3-454c-4f62-84fe-97825d5cf8a7', 'btn-user-update-role', '赋予用户角色权限', 'sys:user:role:update', '/api/user/roles', 'PUT', '9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('d60faf3e-9a72-49d5-b02d-a67bfeff07fa', 'btn-user-update', '列表更新用户信息权限', 'sys:user:update', '/api/user', 'PUT', '9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('e136cc74-9817-4ef1-b181-8f1afd7e102c', 'btn-permission-add', '新增菜单权限', 'sys:permission:add', '/api/permission', 'POST', '290c0240-0914-487cb4e9-6635bf5ebfec', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);
INSERT INTO `sys_permission` VALUES ('f9f4d9f4-a2f5-430c9f2d-6c8e650a8c39', 'btn-role-list', '查询角色列表权限', 'sys:role:list', '/api/roles', 'POST', 'c198d1cb-ad4d-4001-9375-9ec8ee04053d', 100, 3, 1, '2020-05-01 20:16:03', NULL, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态(1:正常0:弃用)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否删除(1未删除；0已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('b1a145ad-15ba-4f89-b641-4cdfe5d290a8', 'test', '', 1, '2020-04-29 22:05:05', '2020-05-02 02:29:37', 1);
INSERT INTO `sys_role` VALUES ('e94d71dd-19ef-4a7c-b007-8eedc6e309de', '超级管理员', '我是超级管理员', 1, '2020-04-20 00:50:53', '2020-05-01 22:29:35', 1);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单权限id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('003f4f5f-9d77-4472-a237-17f825503706', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '390ded0e-9f48-40a7-a841-791c203f22ae', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('0804049a-3bdb-4eb7-b1b8-31fe9f3b45a9', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '8f393e44-b585-4875-866d-71f88fea9659', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('0866c302-b912-4589-aad4-b914218a91ca', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', 'f9f4d9f4-a2f5-430c9f2d-6c8e650a8c39', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('0b942758-2fac-4366-b4ec-a6a5413cff49', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', 'bb5ca869-0303-4fc0-b067-936cba7d1cc8', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('1332f52a-1272-4dc8-a905-501a8ba9e96d', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', 'f9f4d9f4-a2f5-430c9f2d-6c8e650a8c39', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('1afdab10-3dc9-4500-8be2-36967a41eb31', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '390ded0e-9f48-40a7-a841-791c203f22ae', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('28a23bde-687d-4547-9125-f6bfe350bc4c', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '47697e92-e199-4420-a2c2-09ec1b08cb9d', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('29745631-8385-4a8c-99c5-51bf1b9d5e18', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '27acf73b-2fcb-451bbdc4-e11e5ab41e2a', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('304a095f-4b98-4709-a299-46055388e141', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '0545d9d1-c82c-44c2-85e5-0b6ac4042515', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('31442342-96b1-451e-8eca-e1da34834f57', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '65734896-90c5-4b48-b9e8-dee47a74a297', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('39ed91be-c70b-46b9-a2c5-0d7d57ec0a8f', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '90b3be91-5e9d-42f8-81fb-0c9ef3014faa', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('413ac75f-5afd-4c82-baa1-a6869dc0fae3', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '2f9a3f67-6ef3-4eacb9a1-c0e898718d0c', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('4aa755ae-f25f-47f0-be92-c3fb7c58ccb8', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '7141c2e9-6d50-46b6-94e8-100466b7249f', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('5156e52c-b8f0-437c-b75a-553b540df43b', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '15bb6aff-2e3b-490aa21f-0167ae0ebc0d', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('524339eb-8874-4847-ad6a-e1e0cbba864a', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '2ae13993-9501-46d5-8473-fe45fee57f3b', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('54999ea7-1cf2-4742-8b6b-8b2376c23a78', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '03dc1cbf-ef44-4326-a7dc-10fe16d22dad', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('57c30160-78bb-4eae-96b8-1dbd1b2c5276', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '8f393e44-b585-4875-866d-71f88fea9659', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('58f58b15-9aca-40aa-b8ca-046ed2cb95f5', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', 'c198d1cb-ad4d-4001-9375-9ec8ee04053d', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('5d621b0b-2d26-497d-bf77-2b00201caf3f', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '84b9b525-aa44-4b16-9900-adca26115a37', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('76c324c8-d284-4685-9047-9f347e0ee02f', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '4caeb861-354c-45f6-98b4-59f486beb511', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('7bca3544-d8c8-4b2c-8af5-a0c1c8091744', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '346df872-8964-4455-8afd-ffa6308fb18a', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('848ac354-a627-466e-80cf-48f5a9487b93', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '24b7b13c-f00f-4e6ba221-fe2d780e4d4f', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('864f953b-2eb2-4f24-b89a-da66d27a91ef', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', 'b7348d63-c4d3-406d9e46-543346674275', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('885c72de-69e2-4a18-9ba8-c7ca896722aa', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', 'e136cc74-9817-4ef1-b181-8f1afd7e102c', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('936a0813-d8fb-476a-9772-de00f2ca8a31', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '39313e6a-14ed-4224-a91e-ef6a10ba54cd', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('975f3421-6758-4bcc-941b-a4befd3b88b3', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '15bb6aff-2e3b-490aa21f-0167ae0ebc0d', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('97d04fa6-c203-48df-9f4d-da4df10aa6dc', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '4caeb861-354c-45f6-98b4-59f486beb511', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('a25f601c-b01e-4598-ab22-e02a0e022f94', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', 'c198d1cb-ad4d-4001-9375-9ec8ee04053d', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('a4cb829f-0aba-478d-9da0-f9f637d09865', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '39313e6a-14ed-4224-a91e-ef6a10ba54cd', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('a5285cb7-de06-425b-93a1-2ff66330f263', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '013095aa-0f4d-4c32-b30e-229a587e52ad', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('a565bd4e-5262-4636-a8c7-dff998f0a51c', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '2eeaa020-74d5-4c4b9849-2cf4bd68fed9', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('a58df5f6-576f-4f5d-a8fb-7a2abfd58151', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '290c0240-0914-487cb4e9-6635bf5ebfec', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('ab630100-15bf-49da-8d46-2e5d87653dfd', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', 'd60faf3e-9a72-49d5-b02d-a67bfeff07fa', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('b784988e-35d3-43df-bd69-8505dd293d26', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '03dc1cbf-ef44-4326-a7dc-10fe16d22dad', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('b80a586c-21bf-4b51-8347-47aad8b85191', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', 'd41c2bc3-454c-4f62-84fe-97825d5cf8a7', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('b942109c-7eb4-4ebe-abc0-1347695ae9c8', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '47697e92-e199-4420-a2c2-09ec1b08cb9d', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('ce0aed61-4170-4751-9da6-78ea9215b023', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '145cb90b-d205-40f6-8a2d-703f41ed1feb', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('dea69706-afff-4830-8127-5086c063bdc7', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '346df872-8964-4455-8afd-ffa6308fb18a', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('e338cc28-0b3f-4c0b-a52a-1c227d195fd7', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63', '2020-05-01 22:29:35');
INSERT INTO `sys_role_permission` VALUES ('e82a781c-7b0f-4b3f-872d-93ac733f7156', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '290c0240-0914-487cb4e9-6635bf5ebfec', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('ea0e8664-d2d9-4043-be42-7081118072d8', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '9ce621a0-ee2c-4cf6-b7bd-012a1a01ba63', '2020-05-02 02:29:37');
INSERT INTO `sys_role_permission` VALUES ('ef3d5c08-4d15-4027-9ed3-f05afd32c8e6', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '0545d9d1-c82c-44c2-85e5-0b6ac4042515', '2020-05-01 22:29:35');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账户名称',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密盐值',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码密文',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `dept_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门id',
  `real_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实名称',
  `nick_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱(唯一)',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '账户状态(1.正常 2.锁定 )',
  `sex` tinyint(4) NOT NULL DEFAULT 1 COMMENT '性别(1.男 2.女)',
  `deleted` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否删除(1未删除；0已删除)',
  `create_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `create_where` tinyint(4) NOT NULL DEFAULT 1 COMMENT '创建来源(1.web 2.android 3.ios )',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('81d01543-a856-4ef0-ae1e-806b11b57a1e', 'test', 'fad3859677f846cbb83f', '27640be7656632a96ebdb4e9b8bd2fa9', '13888888888', '3d89fdd3-7f80-4fbf-8e6d-c0583cc66179', NULL, NULL, NULL, 1, 1, 1, NULL, NULL, 1, '2020-05-02 00:37:56', NULL);
INSERT INTO `sys_user` VALUES ('fcf34b56-a7a2-4719-9236-867495e74c31', 'admin', '1fc380a69f3e492a9e7b', '3685a0874b5f859f531cba0419d46f45', '13888888886', '352bd3b7-8b9b-4218-8295-086044af345e', '超级管理员', 'SaberKing', 'yingxue01@163.com', 1, 1, 1, NULL, 'fcf34b56-a7a2-4719-9236-867495e74c31', 3, '2019-09-22 19:38:05', '2020-05-02 04:17:55');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('11189de4-d94a-46b7-b60c-bf9d37c0e0dd', 'fcf34b56-a7a2-4719-9236-867495e74c31', 'e94d71dd-19ef-4a7c-b007-8eedc6e309de', '2020-05-01 22:31:01');
INSERT INTO `sys_user_role` VALUES ('a2df4c28-e22d-41d0-8999-acefbbba9ba0', '81d01543-a856-4ef0-ae1e-806b11b57a1e', 'b1a145ad-15ba-4f89-b641-4cdfe5d290a8', '2020-05-02 00:38:03');

SET FOREIGN_KEY_CHECKS = 1;
