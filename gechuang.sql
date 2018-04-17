-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.13-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 gechuang 的数据库结构
CREATE DATABASE IF NOT EXISTS `gechuang` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gechuang`;

-- 导出  表 gechuang.t_department 结构
CREATE TABLE IF NOT EXISTS `t_department` (
  `d_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(255) DEFAULT NULL,
  `d_decription` varchar(255) DEFAULT NULL,
  `p_children` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`d_id`),
  KEY `FKmfndaxf9b53rhvah40859eppd` (`p_children`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- 正在导出表  gechuang.t_department 的数据：12 rows
/*!40000 ALTER TABLE `t_department` DISABLE KEYS */;
INSERT INTO `t_department` (`d_id`, `d_name`, `d_decription`, `p_children`) VALUES
	(1, '项目开发部', '做项目', 7),
	(2, '培训部', '培训', 6),
	(3, '三创工作部', '比赛', 6),
	(4, 'IT信息部', '信息', 7),
	(14, '管理中心', '管理', NULL),
	(6, '活动中心', '活动', NULL),
	(7, '科技中心', '科技', NULL),
	(8, '创新中心', '创新', NULL),
	(9, '网站设计部', '网站', 8),
	(15, '办公室', '办公', 14),
	(11, '网络运维部', '运维', 8),
	(16, '开发1部', '开发', 1);
/*!40000 ALTER TABLE `t_department` ENABLE KEYS */;

-- 导出  表 gechuang.t_forum 结构
CREATE TABLE IF NOT EXISTS `t_forum` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(255) DEFAULT NULL,
  `f_desctiption` varchar(255) DEFAULT NULL,
  `f_position` int(11) DEFAULT NULL,
  `topicCount` int(11) DEFAULT NULL,
  `articleCount` int(11) DEFAULT NULL,
  `lastTopicId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  UNIQUE KEY `UK_sqasfsa8db8p3e0f5fl9n15h3` (`lastTopicId`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 正在导出表  gechuang.t_forum 的数据：3 rows
/*!40000 ALTER TABLE `t_forum` DISABLE KEYS */;
INSERT INTO `t_forum` (`f_id`, `f_name`, `f_desctiption`, `f_position`, `topicCount`, `articleCount`, `lastTopicId`) VALUES
	(13, 'aa', 'aa', 13, 7, 11, 14),
	(14, 'bb', 'bb', 14, 0, 0, NULL),
	(15, 'cc', 'cc', 15, 0, 0, NULL);
/*!40000 ALTER TABLE `t_forum` ENABLE KEYS */;

-- 导出  表 gechuang.t_privilege 结构
CREATE TABLE IF NOT EXISTS `t_privilege` (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(255) DEFAULT NULL,
  `p_url` varchar(255) DEFAULT NULL,
  `p_icon` varchar(255) DEFAULT NULL,
  `p_children` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  KEY `FKsjrvbl2jjufo76dd9euj8y156` (`p_children`)
) ENGINE=MyISAM AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- 正在导出表  gechuang.t_privilege 的数据：27 rows
/*!40000 ALTER TABLE `t_privilege` DISABLE KEYS */;
INSERT INTO `t_privilege` (`p_id`, `p_name`, `p_url`, `p_icon`, `p_children`) VALUES
	(54, '系统管理', NULL, 'FUNC20082.gif', NULL),
	(55, '角色管理', 'role_list', NULL, 54),
	(56, '部门管理', 'department_list', NULL, 54),
	(57, '用户管理', 'user_list', NULL, 54),
	(58, '角色列表', 'role_list', NULL, 55),
	(59, '角色增加', 'role_add', NULL, 55),
	(60, '角色删除', 'role_delete', NULL, 55),
	(61, '角色修改', 'role_update', NULL, 55),
	(62, '设置权限', 'role_setPrivilege', NULL, 55),
	(63, '部门列表', 'department_list', NULL, 56),
	(64, '部门增加', 'department_add', NULL, 56),
	(65, '部门删除', 'department_delete', NULL, 56),
	(66, '部门修改', 'department_update', NULL, 56),
	(67, '用户列表', 'user_list', NULL, 57),
	(68, '用户增加', 'user_add', NULL, 57),
	(69, '用户删除', 'user_delete', NULL, 57),
	(70, '用户修改', 'user_update', NULL, 57),
	(71, '用户初始化密码', 'user_initPassword', NULL, 57),
	(72, '网上交流', NULL, 'FUNC20064.gif', NULL),
	(73, '论坛管理', 'forumManager_list', NULL, 72),
	(74, '论坛', 'forum_list', NULL, 72),
	(75, '审批流转', NULL, 'FUNC20057.gif', NULL),
	(76, '审批流程管理', 'processDefinition_list', NULL, 75),
	(77, '申请流程管理', 'applicationTemplate_list', NULL, 75),
	(78, '起草申请', 'flow_applicationTemplate', NULL, 75),
	(79, '待我审批', 'flow_myTaskList', NULL, 75),
	(80, '我的申请查询', 'flow_myApplication', NULL, 75);
/*!40000 ALTER TABLE `t_privilege` ENABLE KEYS */;

-- 导出  表 gechuang.t_reply 结构
CREATE TABLE IF NOT EXISTS `t_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `faceIcon` varchar(255) DEFAULT NULL,
  `postTime` datetime DEFAULT NULL,
  `ipAdd` varchar(255) DEFAULT NULL,
  `autherId` bigint(20) DEFAULT NULL,
  `topicId` bigint(20) DEFAULT NULL,
  `authorId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhoe66a1cq9lmxyv57vhxiaru8` (`autherId`),
  KEY `FK37b9iumamw83guv9njs51073t` (`authorId`),
  KEY `FK2pkpxbfargvdt42812x56p8sh` (`topicId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  gechuang.t_reply 的数据：4 rows
/*!40000 ALTER TABLE `t_reply` DISABLE KEYS */;
INSERT INTO `t_reply` (`id`, `title`, `content`, `faceIcon`, `postTime`, `ipAdd`, `autherId`, `topicId`, `authorId`) VALUES
	(1, '回复：测试', '合适的啊', '2', '2017-09-03 16:42:01', '0:0:0:0:0:0:0:1', NULL, 11, 16),
	(2, '回复：测试', '本线程', '2', '2017-09-03 16:46:44', '0:0:0:0:0:0:0:1', NULL, 11, 16),
	(3, '回复：测试', ' 爱的方式', '7', '2017-09-03 16:48:23', '0:0:0:0:0:0:0:1', NULL, 11, 16),
	(4, '回复：V字形', '<img src="http://localhost:8080/fckeditor/editor/images/smiley/wangwang/11.gif" alt="" />&nbsp;<span style="font-size: 72px;">成功了</span>', NULL, '2017-09-03 19:21:06', '0:0:0:0:0:0:0:1', NULL, 14, 16);
/*!40000 ALTER TABLE `t_reply` ENABLE KEYS */;

-- 导出  表 gechuang.t_role 结构
CREATE TABLE IF NOT EXISTS `t_role` (
  `r_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `r_name` varchar(255) DEFAULT NULL,
  `r_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 正在导出表  gechuang.t_role 的数据：6 rows
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`r_id`, `r_name`, `r_description`) VALUES
	(1, '会员', '学院外'),
	(2, '干事', '学院内'),
	(14, '副主席', '大三'),
	(7, '部长', '大三'),
	(8, '副部', '大二'),
	(11, '主席', '大三');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;

-- 导出  表 gechuang.t_role_privilege 结构
CREATE TABLE IF NOT EXISTS `t_role_privilege` (
  `rId` bigint(20) NOT NULL,
  `pId` bigint(20) NOT NULL,
  PRIMARY KEY (`pId`,`rId`),
  KEY `FKajiylkcjh1plbtlpp3v0dkrxi` (`rId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  gechuang.t_role_privilege 的数据：17 rows
/*!40000 ALTER TABLE `t_role_privilege` DISABLE KEYS */;
INSERT INTO `t_role_privilege` (`rId`, `pId`) VALUES
	(11, 1),
	(11, 2),
	(11, 3),
	(11, 4),
	(11, 5),
	(11, 9),
	(11, 10),
	(11, 11),
	(11, 12),
	(11, 13),
	(11, 14),
	(11, 15),
	(11, 16),
	(11, 17),
	(11, 18),
	(11, 19),
	(11, 20);
/*!40000 ALTER TABLE `t_role_privilege` ENABLE KEYS */;

-- 导出  表 gechuang.t_topic 结构
CREATE TABLE IF NOT EXISTS `t_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `faceIcon` varchar(255) DEFAULT NULL,
  `postTime` datetime DEFAULT NULL,
  `ipAdd` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `lastUpdateTime` datetime DEFAULT NULL,
  `replyCount` int(11) DEFAULT NULL,
  `autherId` bigint(20) DEFAULT NULL,
  `forumId` bigint(20) DEFAULT NULL,
  `lastReplyId` bigint(20) DEFAULT NULL,
  `authorId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4yc0copsk181kigbq4x8ro45j` (`lastReplyId`),
  KEY `FKim1r2is6j8qlwjmfi8qlttfy2` (`autherId`),
  KEY `FKbpua1g4ogstq6gv498jm2jtyr` (`authorId`),
  KEY `FKsqj3md0vsvk2wmpny5kwjljtc` (`forumId`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- 正在导出表  gechuang.t_topic 的数据：7 rows
/*!40000 ALTER TABLE `t_topic` DISABLE KEYS */;
INSERT INTO `t_topic` (`id`, `title`, `content`, `faceIcon`, `postTime`, `ipAdd`, `type`, `lastUpdateTime`, `replyCount`, `autherId`, `forumId`, `lastReplyId`, `authorId`) VALUES
	(7, 'fasd', 'fa', '6', '2017-09-03 14:25:04', '0:0:0:0:0:0:0:1', 0, '2017-09-03 14:25:04', 0, NULL, 13, NULL, 16),
	(8, 'vzc', 'f', '3', '2017-09-03 14:25:25', '0:0:0:0:0:0:0:1', 2, '2017-09-03 14:25:25', 0, NULL, 13, NULL, 16),
	(9, 'gdfs', 'vzx', '6', '2017-09-03 14:29:16', '0:0:0:0:0:0:0:1', 0, '2017-09-03 14:29:16', 0, NULL, 13, NULL, 16),
	(10, 'bcxv', 'vzx', '1', '2017-09-03 14:30:16', '0:0:0:0:0:0:0:1', 2, '2017-09-03 14:30:48', 0, NULL, 13, NULL, 16),
	(11, '测试', '从车上', '4', '2017-09-03 14:32:51', '0:0:0:0:0:0:0:1', 1, '2017-09-03 16:48:23', 3, NULL, 13, 3, 16),
	(12, 'hh', 'hehe', '2', '2017-09-03 14:35:50', '0:0:0:0:0:0:0:1', 0, '2017-09-03 14:35:50', 0, NULL, 13, NULL, 16),
	(14, 'V字形', '在在', '3', '2017-09-03 16:48:36', '0:0:0:0:0:0:0:1', 0, '2017-09-03 19:21:06', 1, NULL, 13, 4, 16);
/*!40000 ALTER TABLE `t_topic` ENABLE KEYS */;

-- 导出  表 gechuang.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) DEFAULT NULL,
  `u_login_name` varchar(255) DEFAULT NULL,
  `u_password` varchar(255) DEFAULT NULL,
  `u_sex` bit(1) DEFAULT NULL,
  `u_phone` varchar(255) DEFAULT NULL,
  `u_email` varchar(255) DEFAULT NULL,
  `u_desctiption` varchar(255) DEFAULT NULL,
  `u_department` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  KEY `FK33xm02j86g70kowharf2plv1s` (`u_department`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- 正在导出表  gechuang.t_user 的数据：7 rows
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`u_id`, `u_name`, `u_login_name`, `u_password`, `u_sex`, `u_phone`, `u_email`, `u_desctiption`, `u_department`) VALUES
	(1, '张三', 'zhangshan', '81dc9bdb52d04dc20036dbd8313ed055', b'1', '', '', '', 1),
	(2, '李四', 'lisi', '81dc9bdb52d04dc20036dbd8313ed055', b'1', '', '', '', 3),
	(3, 'zhao', 'ezra', '81dc9bdb52d04dc20036dbd8313ed055', b'1', '123', '123', '', 14),
	(12, 'fasd', 'fdas', '81dc9bdb52d04dc20036dbd8313ed055', b'0', 'asdf', 'fas', '', 1),
	(14, 'y', 'x', '81dc9bdb52d04dc20036dbd8313ed055', b'1', 'z', '', '', 2),
	(15, 'w', 'q', '81dc9bdb52d04dc20036dbd8313ed055', b'0', 'e', 'r', 't', NULL),
	(16, '超级管理员', 'admin', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

-- 导出  表 gechuang.t_user_role 结构
CREATE TABLE IF NOT EXISTS `t_user_role` (
  `uId` bigint(20) NOT NULL,
  `rId` bigint(20) NOT NULL,
  PRIMARY KEY (`rId`,`uId`),
  KEY `FKs00gm9ty17a9hpb2qmy8rjtn2` (`uId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  gechuang.t_user_role 的数据：7 rows
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` (`uId`, `rId`) VALUES
	(1, 1),
	(0, 2),
	(2, 2),
	(14, 7),
	(12, 8),
	(3, 11),
	(15, 14);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
