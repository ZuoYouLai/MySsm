

#创建数据库
CREATE DATABASE IF NOT EXISTS stuproject default charset utf8 COLLATE utf8_general_ci;

USE stuproject;


CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updated_at` DATETIME DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci




CREATE TABLE `passports` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `account` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salt` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `blocked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否被冻结',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '邮箱',
  `mobile` char(11) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `created_at` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updated_at` DATETIME DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci




CREATE TABLE `item` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `content` TEXT DEFAULT NULL COMMENT '商品排版内容(html)',
  `expire` DATETIME DEFAULT NULL COMMENT '过期时间',
  `created_at` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updated_at` DATETIME DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci






CREATE TABLE `user_point` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `point_group` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ponit_level` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point` INT(5) UNSIGNED NOT NULL DEFAULT '0' COMMENT '分数内容',
  `user_id` BIGINT(20) DEFAULT NULL COMMENT '用户的id',
  `created_at` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updated_at` DATETIME DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci




CREATE TABLE `user_file` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `file_name` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文件名称',
  `file_path` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文件路径',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci
