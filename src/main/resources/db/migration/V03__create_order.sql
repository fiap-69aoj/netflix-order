CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `insert_date` DATE NOT NULL,
  `order_status` varchar(256) NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `payment_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tb_order_user`
    FOREIGN KEY (`client_id`)
    REFERENCES `tb_user` (`id`),
  CONSTRAINT `fk_tb_order_payment`
    FOREIGN KEY (`payment_id`)
    REFERENCES `tb_payment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;