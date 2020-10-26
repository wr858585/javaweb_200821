USE book;

CREATE TABLE t_order(
`order_id` VARCHAR(64) PRIMARY KEY,
`create_time` DATETIME,
`price` DECIMAL(11,2),
`status` INT,
`user_id` INT,
FOREIGN KEY(`user_id`) REFERENCES t_user(`id`)
);

CREATE TABLE t_order_item(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200),
`price` DECIMAL(11,2),
`count` INT,
`total_price` DECIMAL(11,2),
`order_id` VARCHAR(64),
FOREIGN KEY(`order_id`) REFERENCES t_order(`order_id`)
);