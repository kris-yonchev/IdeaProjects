CREATE TABLE `users` (
	`id` INT AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` BLOB,
    `last_login_time` TIME,
    `is_deleted` BOOLEAN, 
	CONSTRAINT pk_users 
    PRIMARY KEY `users`(`id`)
);

INSERT INTO `users` (`username`, `password`)
VALUES 
('Test1', 'Pass'),
('Test2', 'Pass'),
('Test3', 'Pass'),
('Test4', 'Pass'),
('Test5', 'Pass');