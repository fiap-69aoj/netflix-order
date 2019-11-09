CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `insert_date` DATE NOT NULL,
  `order_status` varchar(256) NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `payment_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_order_user`
    FOREIGN KEY (`client_id`)
    REFERENCES `user` (`id`),
  CONSTRAINT `fk_order_payment`
    FOREIGN KEY (`payment_id`)
    REFERENCES `payment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;