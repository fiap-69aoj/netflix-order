INSERT INTO `tb_user` (`id`) VALUES (1);
INSERT INTO `tb_user` (`id`) VALUES (2);

INSERT INTO `tb_payment` (`insert_date`) VALUES (curdate());
INSERT INTO `tb_payment` (`insert_date`) VALUES (curdate());

INSERT INTO `tb_order` (`insert_date`, `order_status`, `client_id`, `payment_id`) VALUES (curdate(), 'PAID', 1, 1);
INSERT INTO `tb_order` (`insert_date`, `order_status`, `client_id`, `payment_id`) VALUES (curdate(), 'PAID', 2, 1);
INSERT INTO `tb_order` (`insert_date`, `order_status`, `client_id`, `payment_id`) VALUES (curdate(), 'WAITING_PAYMENT', 1, 1);
INSERT INTO `tb_order` (`insert_date`, `order_status`, `client_id`, `payment_id`) VALUES (curdate(), 'WAITING_PAYMENT', 1, 1);
INSERT INTO `tb_order` (`insert_date`, `order_status`, `client_id`, `payment_id`) VALUES (curdate(), 'CANCELED', 1, 1);