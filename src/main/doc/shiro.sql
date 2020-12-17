/*
Navicat MySQL Data Transfer

Source Server         : cp
Source Server Version : 50725
Source Host           : 127.0.0.1:3306
Source Database       : mydatabase

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-12-17 16:20:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission_shiro
-- ----------------------------
DROP TABLE IF EXISTS `permission_shiro`;
CREATE TABLE `permission_shiro` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`permission`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限编码' ,
`description`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=7

;

-- ----------------------------
-- Records of permission_shiro
-- ----------------------------
BEGIN;
INSERT INTO `permission_shiro` VALUES ('1', 'add', '增加权限'), ('2', 'delete', '删除权限'), ('3', 'update', '修改权限'), ('4', 'select', '查看权限');
COMMIT;

-- ----------------------------
-- Table structure for role_permission_shiro
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_shiro`;
CREATE TABLE `role_permission_shiro` (
`role_id`  int(11) NOT NULL COMMENT '角色id' ,
`permission_id`  int(11) NOT NULL COMMENT '权限id' ,
PRIMARY KEY (`role_id`, `permission_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of role_permission_shiro
-- ----------------------------
BEGIN;
INSERT INTO `role_permission_shiro` VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('2', '1'), ('2', '3'), ('2', '4'), ('3', '4');
COMMIT;

-- ----------------------------
-- Table structure for role_shiro
-- ----------------------------
DROP TABLE IF EXISTS `role_shiro`;
CREATE TABLE `role_shiro` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id' ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称' ,
`code`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of role_shiro
-- ----------------------------
BEGIN;
INSERT INTO `role_shiro` VALUES ('1', '管理员', 'admin'), ('2', '普通用户', 'user'), ('3', '访客', 'visitor');
COMMIT;

-- ----------------------------
-- Table structure for user_role_shiro
-- ----------------------------
DROP TABLE IF EXISTS `user_role_shiro`;
CREATE TABLE `user_role_shiro` (
`user_id`  int(11) NOT NULL COMMENT '用户id' ,
`role_id`  int(11) NOT NULL COMMENT '角色id' ,
PRIMARY KEY (`user_id`, `role_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of user_role_shiro
-- ----------------------------
BEGIN;
INSERT INTO `user_role_shiro` VALUES ('1', '1'), ('1', '2'), ('2', '2'), ('3', '2');
COMMIT;

-- ----------------------------
-- Table structure for user_shiro
-- ----------------------------
DROP TABLE IF EXISTS `user_shiro`;
CREATE TABLE `user_shiro` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名' ,
`password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码' ,
`perms`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of user_shiro
-- ----------------------------
BEGIN;
INSERT INTO `user_shiro` VALUES ('1', 'jack', '123456', 'user:one'), ('2', 'tom', '123456', 'user:two'), ('3', 'rose', '123456', null);
COMMIT;

-- ----------------------------
-- Auto increment value for permission_shiro
-- ----------------------------
ALTER TABLE `permission_shiro` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for role_shiro
-- ----------------------------
ALTER TABLE `role_shiro` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for user_shiro
-- ----------------------------
ALTER TABLE `user_shiro` AUTO_INCREMENT=4;
