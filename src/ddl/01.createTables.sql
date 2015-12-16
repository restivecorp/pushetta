CREATE TABLE `notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creationDate` datetime NOT NULL,
  `scheduleDate` datetime NOT NULL,
  `text` varchar(300) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `trySend` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;