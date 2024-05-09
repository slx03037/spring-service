
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_order_info_0
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info_0`;
CREATE TABLE `tbl_order_info_0`  (
  `order_id` bigint(0) NOT NULL,
  `order_type` int(0) NOT NULL,
  `order_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_2
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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_3
-- ----------------------------
INSERT INTO `tbl_order_info_3` VALUES (1, 2, '西瓜', '0');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order_info_4
-- ----------------------------

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
