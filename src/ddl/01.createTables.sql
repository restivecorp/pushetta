CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creationDate` datetime NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,  
  `scheduleDate` date NOT NULL,
  `text` varchar(300) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `trySend` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1urdwwsh2ti15ta6f6p5dbdcp` (`user_id`),
  CONSTRAINT `FK_1urdwwsh2ti15ta6f6p5dbdcp` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;



