/*
 Navicat Premium Data Transfer

 Source Server         : 73
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : 192.168.1.73:3306
 Source Schema         : sharding_sphere_db1

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 13/05/2024 18:23:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order`  (
  `order_id` bigint(0) NOT NULL COMMENT '订单ID',
  `user_id` bigint(0) NOT NULL COMMENT '用户编号',
  `status` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '状态（0交易成功 1交易失败）',
  `order_no` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '订单流水',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '订单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order
-- ----------------------------

-- ----------------------------
-- Table structure for sys_order_0
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_0`;
CREATE TABLE `sys_order_0`  (
  `order_id` bigint(0) NOT NULL COMMENT '订单ID',
  `user_id` bigint(0) NOT NULL COMMENT '用户编号',
  `status` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '状态（0交易成功 1交易失败）',
  `order_no` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '订单流水',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '订单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_0
-- ----------------------------

-- ----------------------------
-- Table structure for sys_order_1
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_1`;
CREATE TABLE `sys_order_1`  (
  `order_id` bigint(0) NOT NULL COMMENT '订单ID',
  `user_id` bigint(0) NOT NULL COMMENT '用户编号',
  `status` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '状态（0交易成功 1交易失败）',
  `order_no` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '订单流水',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '订单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order_1
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `age` int(0) NOT NULL COMMENT '年龄',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_202201
-- ----------------------------
DROP TABLE IF EXISTS `t_user_202201`;
CREATE TABLE `t_user_202201`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `age` int(0) NOT NULL COMMENT '年龄',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表202201' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_202201
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_202405
-- ----------------------------
DROP TABLE IF EXISTS `t_user_202405`;
CREATE TABLE `t_user_202405`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `age` int(0) NOT NULL COMMENT '年龄',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表202201' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_202405
-- ----------------------------
INSERT INTO `t_user_202405` VALUES (1789911746940542978, '张三', '123456', 15, '2024-05-13 00:00:00', '2024-05-13 03:01:28');
INSERT INTO `t_user_202405` VALUES (1789911935688417281, '张三1', '123456', 10, '2024-05-13 00:00:00', '2024-05-13 02:56:00');

-- ----------------------------
-- Table structure for t_user_202406
-- ----------------------------
DROP TABLE IF EXISTS `t_user_202406`;
CREATE TABLE `t_user_202406`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `age` int(0) NOT NULL COMMENT '年龄',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表202201' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_202406
-- ----------------------------
INSERT INTO `t_user_202406` VALUES (1789912318775173121, '张', '123456', 11, '2024-06-13 00:00:00', '2024-05-13 03:01:21');

-- ----------------------------
-- Table structure for t_user_202407
-- ----------------------------
DROP TABLE IF EXISTS `t_user_202407`;
CREATE TABLE `t_user_202407`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `age` int(0) NOT NULL COMMENT '年龄',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表202201' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_202407
-- ----------------------------
INSERT INTO `t_user_202407` VALUES (1789912430284939266, '张三2', '123456', 10, '2024-07-13 00:00:00', '2024-07-13 00:00:00');

-- ----------------------------
-- Table structure for t_user_202408
-- ----------------------------
DROP TABLE IF EXISTS `t_user_202408`;
CREATE TABLE `t_user_202408`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `age` int(0) NOT NULL COMMENT '年龄',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表202201' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_202408
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_generator
-- ----------------------------
DROP TABLE IF EXISTS `tbl_generator`;
CREATE TABLE `tbl_generator`  (
  `id` int(0) NOT NULL,
  `type` int(0) NOT NULL,
  `max_id` int(0) NOT NULL,
  `step` int(0) NOT NULL,
  `remarks` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_generator
-- ----------------------------
INSERT INTO `tbl_generator` VALUES (1000, 10, 1000, 0, 'order_id自增');

-- ----------------------------
-- Table structure for tbl_order_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info`;
CREATE TABLE `tbl_order_info`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_0
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_0`;
CREATE TABLE `tbl_order_info_0`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_0
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_1
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_1`;
CREATE TABLE `tbl_order_info_1`  (
  `order_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_1
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_10
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_10`;
CREATE TABLE `tbl_order_info_10`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_10
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_11
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_11`;
CREATE TABLE `tbl_order_info_11`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_11
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_12
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_12`;
CREATE TABLE `tbl_order_info_12`  (
  `order_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_12
-- ----------------------------
INSERT INTO `tbl_order_info_12` VALUES (1, 1, '西瓜', '0');
INSERT INTO `tbl_order_info_12` VALUES (2, 2, '西瓜', '0');
INSERT INTO `tbl_order_info_12` VALUES (3, 2, '西瓜', '0');

-- ----------------------------
-- Table structure for tbl_order_info_2
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_2`;
CREATE TABLE `tbl_order_info_2`  (
  `order_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_2
-- ----------------------------
INSERT INTO `tbl_order_info_2` VALUES (14, 10109, '西瓜', '0');
INSERT INTO `tbl_order_info_2` VALUES (16, 10109, '西瓜', '0');

-- ----------------------------
-- Table structure for tbl_order_info_202405
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_202405`;
CREATE TABLE `tbl_order_info_202405`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_202405
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_202406
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_202406`;
CREATE TABLE `tbl_order_info_202406`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_202406
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_202407
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_202407`;
CREATE TABLE `tbl_order_info_202407`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_202407
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_202408
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_202408`;
CREATE TABLE `tbl_order_info_202408`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_202408
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_202409
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_202409`;
CREATE TABLE `tbl_order_info_202409`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_202409
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_202410
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_202410`;
CREATE TABLE `tbl_order_info_202410`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_202410
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_202411
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_202411`;
CREATE TABLE `tbl_order_info_202411`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_202411
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_202412
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_202412`;
CREATE TABLE `tbl_order_info_202412`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_202412
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_3
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_3`;
CREATE TABLE `tbl_order_info_3`  (
  `order_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_3
-- ----------------------------
INSERT INTO `tbl_order_info_3` VALUES (1, 2, '西瓜', '0');
INSERT INTO `tbl_order_info_3` VALUES (15, 10109, '西瓜', '0');

-- ----------------------------
-- Table structure for tbl_order_info_4
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_4`;
CREATE TABLE `tbl_order_info_4`  (
  `order_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_4
-- ----------------------------
INSERT INTO `tbl_order_info_4` VALUES (2, 3, '西瓜', '0');

-- ----------------------------
-- Table structure for tbl_order_info_5
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_5`;
CREATE TABLE `tbl_order_info_5`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_5
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_6
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_6`;
CREATE TABLE `tbl_order_info_6`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_6
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_7
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_7`;
CREATE TABLE `tbl_order_info_7`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_7
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_8
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_8`;
CREATE TABLE `tbl_order_info_8`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_8
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order_info_9
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_9`;
CREATE TABLE `tbl_order_info_9`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_9
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
