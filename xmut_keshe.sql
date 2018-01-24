/*
Navicat MySQL Data Transfer

Source Server         : xmutkeshe
Source Server Version : 50547

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2018-01-19 15:40:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for k_article
-- ----------------------------
DROP TABLE IF EXISTS `k_article`;
CREATE TABLE `k_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(300) NOT NULL,
  `author` varchar(30) NOT NULL,
  `sort` varchar(300) NOT NULL,
  `time` varchar(50) DEFAULT '2017-09-18 00:00:00',
  `star` int(11) DEFAULT '0',
  `comment` int(11) DEFAULT '0',
  `visit` int(11) DEFAULT '0',
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1083 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for k_article_delet
-- ----------------------------
DROP TABLE IF EXISTS `k_article_delet`;
CREATE TABLE `k_article_delet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(30) NOT NULL,
  `sort` varchar(30) NOT NULL,
  `time` datetime DEFAULT '2017-09-18 00:00:00',
  `star` int(11) DEFAULT '0',
  `comment` int(11) DEFAULT '0',
  `visit` int(11) DEFAULT '0',
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for k_comment
-- ----------------------------
DROP TABLE IF EXISTS `k_comment`;
CREATE TABLE `k_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `content` text,
  `time` varchar(30) DEFAULT '2017-09-18 00:00:00',
  `star` int(11) DEFAULT '0',
  `diss` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `article_id` FOREIGN KEY (`article_id`) REFERENCES `k_article` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for k_tag
-- ----------------------------
DROP TABLE IF EXISTS `k_tag`;
CREATE TABLE `k_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag` varchar(30) DEFAULT NULL,
  `num` varchar(30) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for k_user
-- ----------------------------
DROP TABLE IF EXISTS `k_user`;
CREATE TABLE `k_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary_key',
  `user_name` varchar(50) NOT NULL COMMENT 'username',
  `user_password` varchar(50) NOT NULL COMMENT 'password',
  `about` text,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for k_visitor
-- ----------------------------
DROP TABLE IF EXISTS `k_visitor`;
CREATE TABLE `k_visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `web_ip` varchar(50) DEFAULT NULL,
  `host` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
