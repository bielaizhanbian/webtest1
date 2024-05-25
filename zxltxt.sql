/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : wsltxt

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 23/05/2024 10:03:00
*/
create database wsltxt;
drop database wsltxt;
use  wsltxt;
create database chatproject;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'root');
INSERT INTO `t_admin` VALUES (2, '账号2', '密码2');
INSERT INTO `t_admin` VALUES (3, '账号3', '密码3');
INSERT INTO `t_admin` VALUES (4, '账号4', '密码4');
INSERT INTO `t_admin` VALUES (5, '账号5', '密码5');
INSERT INTO `t_admin` VALUES (6, '账号6', '密码6');
INSERT INTO `t_admin` VALUES (7, '账号7', '密码7');
INSERT INTO `t_admin` VALUES (8, '账号8', '密码8');
INSERT INTO `t_admin` VALUES (9, '账号9', '密码9');
INSERT INTO `t_admin` VALUES (10, 'root', 'root');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分组id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分组' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, '名称1');
INSERT INTO `t_category` VALUES (2, '名称2');
INSERT INTO `t_category` VALUES (3, '名称3');
INSERT INTO `t_category` VALUES (4, '名称4');
INSERT INTO `t_category` VALUES (5, '名称5');
INSERT INTO `t_category` VALUES (6, '名称6');
INSERT INTO `t_category` VALUES (7, '名称7');
INSERT INTO `t_category` VALUES (8, '名称8');
INSERT INTO `t_category` VALUES (9, '名称9');
INSERT INTO `t_category` VALUES (10, '名称10');

-- ----------------------------
-- Table structure for t_chat
-- ----------------------------
DROP TABLE IF EXISTS `t_chat`;
CREATE TABLE `t_chat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '聊天id',
  `senderid` int(11) NULL DEFAULT NULL COMMENT '发送者id',
  `senderidentity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者身份',
  `sendername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者名字',
  `receiverid` int(11) NULL DEFAULT NULL COMMENT '接收者id',
  `receiveridentity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收者身份',
  `receivername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收者名字',
  `sendtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送时间',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送内容',
  `isread` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '已读状态',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '聊天' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_chat
-- ----------------------------
INSERT INTO `t_chat` VALUES (2, 2, '发送者身份2', '发送者名字2', 2, '接收者身份2', '接收者名字2', '发送时间2', '发送内容2', '已读状态2', '类型2');
INSERT INTO `t_chat` VALUES (3, 3, '发送者身份3', '发送者名字3', 3, '接收者身份3', '接收者名字3', '发送时间3', '发送内容3', '已读状态3', '类型3');
INSERT INTO `t_chat` VALUES (4, 4, '发送者身份4', '发送者名字4', 4, '接收者身份4', '接收者名字4', '发送时间4', '发送内容4', '已读状态4', '类型4');
INSERT INTO `t_chat` VALUES (5, 5, '发送者身份5', '发送者名字5', 5, '接收者身份5', '接收者名字5', '发送时间5', '发送内容5', '已读状态5', '类型5');
INSERT INTO `t_chat` VALUES (11, 11, '用户', '1', 1, '用户', '张三', '2024-05-23 09:59:55', '你好', '1', '0');
INSERT INTO `t_chat` VALUES (12, 11, '用户', '1', 1, '用户', '张三', '2024-05-23 09:59:59', '你好啊', '1', '0');
INSERT INTO `t_chat` VALUES (13, 11, '用户', '1', 11, '用户', '李四', '2024-05-23 10:00:54', '你好', '1', '0');
INSERT INTO `t_chat` VALUES (14, 11, '用户', '1', 11, '用户', '李四', '2024-05-23 10:01:02', '好', '1', '0');
INSERT INTO `t_chat` VALUES (15, 11, '用户', '1', 11, '用户', '李四', '2024-05-23 10:01:10', '111', '1', '0');
INSERT INTO `t_chat` VALUES (16, 1, '用户', 'admin', 11, '用户', '1', '2024-05-23 10:02:02', '444', '1', '0');

-- ----------------------------
-- Table structure for t_friends
-- ----------------------------
DROP TABLE IF EXISTS `t_friends`;
CREATE TABLE `t_friends`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '好友id',
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户',
  `userid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `mingzi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '好友',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分组',
  `categoryid` int(11) NULL DEFAULT NULL COMMENT '分组id',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '好友' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_friends
-- ----------------------------
INSERT INTO `t_friends` VALUES (1, '用户1', 1, '好友1', '分组1', 1, '状态1');
INSERT INTO `t_friends` VALUES (2, '用户2', 2, '好友2', '分组2', 2, '状态2');
INSERT INTO `t_friends` VALUES (3, '用户3', 3, '好友3', '分组3', 3, '状态3');
INSERT INTO `t_friends` VALUES (4, '用户4', 4, '好友4', '分组4', 4, '状态4');
INSERT INTO `t_friends` VALUES (5, '用户5', 5, '好友5', '分组5', 5, '状态5');
INSERT INTO `t_friends` VALUES (6, '用户6', 6, '好友6', '分组6', 6, '状态6');
INSERT INTO `t_friends` VALUES (7, '用户7', 7, '好友7', '分组7', 7, '状态7');
INSERT INTO `t_friends` VALUES (8, '用户8', 8, '好友8', '分组8', 8, '状态8');
INSERT INTO `t_friends` VALUES (9, '用户9', 9, '好友9', '分组9', 9, '状态9');
INSERT INTO `t_friends` VALUES (10, '用户10', 10, '好友10', '分组10', 10, '状态10');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `comtent` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `addtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (1, '标题1', 'syspic/notice1.jpg', '内容1内容1内容1内容1内容1', '2024-05-23 09:38:59', '发布人1');
INSERT INTO `t_notice` VALUES (2, '标题2', 'syspic/notice2.jpg', '内容2内容2内容2内容2内容2', '2024-05-23 09:38:59', '发布人2');
INSERT INTO `t_notice` VALUES (3, '标题3', 'syspic/notice3.jpg', '内容3内容3内容3内容3内容3', '2024-05-23 09:38:59', '发布人3');
INSERT INTO `t_notice` VALUES (4, '标题4', 'syspic/notice4.jpg', '内容4内容4内容4内容4内容4', '2024-05-23 09:38:59', '发布人4');
INSERT INTO `t_notice` VALUES (5, '标题5', 'syspic/notice5.jpg', '内容5内容5内容5内容5内容5', '2024-05-23 09:38:59', '发布人5');
INSERT INTO `t_notice` VALUES (6, '标题6', 'syspic/notice6.jpg', '内容6内容6内容6内容6内容6', '2024-05-23 09:38:59', '发布人6');
INSERT INTO `t_notice` VALUES (7, '标题7', 'syspic/notice7.jpg', '内容7内容7内容7内容7内容7', '2024-05-23 09:38:59', '发布人7');
INSERT INTO `t_notice` VALUES (8, '标题8', 'syspic/notice8.jpg', '内容8内容8内容8内容8内容8', '2024-05-23 09:38:59', '发布人8');
INSERT INTO `t_notice` VALUES (9, '标题9', 'syspic/notice9.jpg', '内容9内容9内容9内容9内容9', '2024-05-23 09:38:59', '发布人9');
INSERT INTO `t_notice` VALUES (10, '标题10', 'syspic/notice10.jpg', '内容10内容10内容10内容10内容10', '2024-05-23 09:38:59', '发布人10');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin1', 'admin1', '张三', '女', '邮箱1', '15874029071');
INSERT INTO `t_user` VALUES (2, '账号2', '密码2', '姓名2', '男', '邮箱2', '15751569631');
INSERT INTO `t_user` VALUES (3, '账号3', '密码3', '姓名3', '男', '邮箱3', '15877882465');
INSERT INTO `t_user` VALUES (4, '账号4', '密码4', '姓名4', '女', '邮箱4', '13813980223');
INSERT INTO `t_user` VALUES (5, '账号5', '密码5', '姓名5', '女', '邮箱5', '17295355774');
INSERT INTO `t_user` VALUES (6, '账号6', '密码6', '姓名6', '女', '邮箱6', '13696512127');
INSERT INTO `t_user` VALUES (7, '账号7', '密码7', '姓名7', '男', '邮箱7', '17747132407');
INSERT INTO `t_user` VALUES (8, '账号8', '密码8', '姓名8', '女', '邮箱8', '18006190074');
INSERT INTO `t_user` VALUES (9, '账号9', '密码9', '姓名9', '女', '邮箱9', '13574450158');
INSERT INTO `t_user` VALUES (10, 'admin0', 'admin0', '姓名10', '女', '邮箱10', '16640035975');
INSERT INTO `t_user` VALUES (11, '1', '1', '李四', '', '', '');
INSERT INTO `t_user` VALUES (12, 'xtt', '1234', 'xtt', '', '', '');
INSERT INTO `t_user` VALUES (11, 'xtq', '1234', 'xtq', '', '', '');
SET FOREIGN_KEY_CHECKS = 1;
