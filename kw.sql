/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.18 : Database - kwmanage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kwmanage` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `kwmanage`;

/*Table structure for table `jiaoshi` */

DROP TABLE IF EXISTS `jiaoshi`;

CREATE TABLE `jiaoshi` (
  `jiaoshi_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `jiaoshi_xingming` varchar(20) NOT NULL,
  `jiaoshi_shoujihaoma` varchar(25) DEFAULT NULL,
  `xuexiao_id` int(11) NOT NULL,
  `jiaoshi_state` int(11) NOT NULL,
  PRIMARY KEY (`jiaoshi_id`),
  KEY `xuexiao_id` (`xuexiao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

/*Table structure for table `kaoshi` */

DROP TABLE IF EXISTS `kaoshi`;

CREATE TABLE `kaoshi` (
  `kaoshi_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '考试ID',
  `kaoshi_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '考试编号',
  `xuexiao_id` int(11) NOT NULL COMMENT '学校ID',
  `kemu_id` int(11) NOT NULL COMMENT '科目ID',
  `xueqi_id` int(11) NOT NULL COMMENT '学期ID',
  `jiaoshi_id` int(11) DEFAULT NULL COMMENT '主管教师ID',
  `kaoshi_mingcheng` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '考试名称',
  `kaoshi_shijian` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '考试时间',
  `kaoshi_canyujiaoshi` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参与教师',
  `kaoshi_xueshengmingdan` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生名单',
  `kaoshi_renshu` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '考试人数',
  `kaoshi_timu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '考试题目',
  `kaoshi_shijuan` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '考试试卷',
  `kaoshi_dianzhenbi` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '点阵笔',
  `kaoshi_dianzhenzhi` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '点阵纸',
  `kaoshi_baoming` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '报名情况',
  `kaoshi_kaochangzhunbei` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '考场准备、考场部署',
  `kaoshi_changci` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '场次安排',
  `kaoshi_shezhi` varchar(1024) DEFAULT NULL COMMENT '考试设置',
  `kaoshi_leixing` varchar(1024) DEFAULT NULL COMMENT '考试类型',
  `kaoshi_beizhu` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '考试备注',
  `kaoshi_tixing` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '考试题型',
  `kaoshi_zhuangtai` int(10) NOT NULL DEFAULT '0' COMMENT '考试状态（灰色）未开始0、已取消-10、已终止-20（绿色）筹备中10、正在报名20、已发布30（红色）正在考试100、阅卷中110、成绩发布120（黑色）已完成200',
  `kaoshi_state` int(11) NOT NULL DEFAULT '0' COMMENT '软删除，0存在，1删除',
  `kaoshi_chuangjianren` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `kaoshi_chuangjianshijian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '创建时间',
  `kaoshi_xiugairen` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `kaoshi_xiugaishijian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '修改时间',
  PRIMARY KEY (`kaoshi_id`) USING BTREE,
  KEY `xueqi_id` (`xueqi_id`),
  KEY `xuexiao_id` (`xuexiao_id`),
  KEY `kemu_id` (`kemu_id`),
  KEY `jiaoshi_id` (`jiaoshi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=358 DEFAULT CHARSET=utf8;

/*Table structure for table `kemu` */

DROP TABLE IF EXISTS `kemu`;

CREATE TABLE `kemu` (
  `kemu_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kemu_mingcheng` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `kemu_state` int(11) NOT NULL COMMENT '软删除，0为显示，1为删除',
  PRIMARY KEY (`kemu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

/*Table structure for table `loginip` */

DROP TABLE IF EXISTS `loginip`;

CREATE TABLE `loginip` (
  `ip_id` int(15) NOT NULL AUTO_INCREMENT COMMENT 'ip ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户ID',
  `ip_date` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录时间',
  `ip_city` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录城市',
  `ip_ip` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录IP',
  `ip_device` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录设备',
  `ip_OS` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '操作系统',
  PRIMARY KEY (`ip_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;

/*Table structure for table `luti` */

DROP TABLE IF EXISTS `luti`;

CREATE TABLE `luti` (
  `luti_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '录题ID',
  `luti_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '录题编号',
  `xuexiao_id` int(10) NOT NULL COMMENT '学校ID',
  `kemu_id` int(10) NOT NULL COMMENT '科目ID',
  `luti_shuoming` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '录题说明',
  `luti_jiezhishijian` varchar(255) DEFAULT NULL COMMENT '截止时间',
  PRIMARY KEY (`luti_id`)
) ENGINE=InnoDB AUTO_INCREMENT=302 DEFAULT CHARSET=utf8;

/*Table structure for table `lutistate` */

DROP TABLE IF EXISTS `lutistate`;

CREATE TABLE `lutistate` (
  `lutistate_id` int(10) NOT NULL AUTO_INCREMENT,
  `luti_id` int(10) NOT NULL COMMENT '录题id',
  `lutistate_lururenid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '录入人id',
  `lutistate_shenherenid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审核人id',
  `lutistate_lurubeizhu` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '录入备注',
  `lutistate_shenhebeizhu` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审核备注',
  `lutistate_lurustate` int(10) DEFAULT NULL COMMENT '录入状态(0进行中,1结束)',
  `lutistate_shenhestate` int(10) DEFAULT NULL COMMENT '审核状态(0未开始，1进行中，2结束)',
  `lutistate_state` int(10) DEFAULT NULL COMMENT '总状态(0录入中,1审核中,2结束,3删除)',
  PRIMARY KEY (`lutistate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

/*Table structure for table `netdisk` */

DROP TABLE IF EXISTS `netdisk`;

CREATE TABLE `netdisk` (
  `netdisk_id` int(10) NOT NULL AUTO_INCREMENT,
  `netdisk_name` varchar(600) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '上传的文件名字',
  `netdisk_url` varchar(600) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '下载路径',
  `netdisk_size` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '文件大小',
  `netdisk_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '上传时间',
  `netdisk_lujing` varchar(600) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '存储路径',
  `netdisk_icon` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '储存后缀',
  `netdisk_state` int(10) NOT NULL DEFAULT '0' COMMENT '软删除，0公共存在，1删除，2个人存在',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `netdisk_uploaduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`netdisk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UUID',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户真实姓名',
  `user_sex` int(10) NOT NULL DEFAULT '0' COMMENT '默认为0保密，1为男，2为女',
  `user_level` int(10) NOT NULL DEFAULT '0' COMMENT '默认0未验证用户，1为用户，2为管理员',
  `login_username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `login_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `user_salt` varchar(100) NOT NULL COMMENT '用户盐',
  `user_state` int(10) NOT NULL COMMENT '正常0，禁止登录1, 已删除2',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `xueqi` */

DROP TABLE IF EXISTS `xueqi`;

CREATE TABLE `xueqi` (
  `xueqi_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `xueqi_mingcheng` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `xueqi_state` int(11) NOT NULL COMMENT '软删除，0为显示，1为删除',
  PRIMARY KEY (`xueqi_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

/*Table structure for table `xuexiao` */

DROP TABLE IF EXISTS `xuexiao`;

CREATE TABLE `xuexiao` (
  `xuexiao_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `xuexiao_mingcheng` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `xuexiao_state` int(11) NOT NULL,
  PRIMARY KEY (`xuexiao_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1055 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
