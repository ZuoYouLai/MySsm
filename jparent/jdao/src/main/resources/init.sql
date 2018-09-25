stuproject database


CREATE TABLE `user` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
   `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci





CREATE TABLE `user_point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `point_group` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ponit_level` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point` int(5) unsigned NOT NULL DEFAULT '0' COMMENT '分数内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci

