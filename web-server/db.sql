CREATE TABLE `demo_user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `last_update` timestamp NULL DEFAULT NULL,
  `enable` tinyint(4) DEFAULT '1' COMMENT '1表示有效记录，0表示记录已被删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;