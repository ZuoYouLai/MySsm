stuproject database


CREATE TABLE `user` (
   `id` varchar(32) NOT NULL,
   `NAME` varchar(64) DEFAULT NULL,
   `PASSWORD` varchar(64) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1