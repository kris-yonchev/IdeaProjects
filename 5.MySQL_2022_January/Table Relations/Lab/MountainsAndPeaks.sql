CREATE TABLE `mountains` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30)
);
CREATE TABLE `peaks` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30),
`mountain_id` INT
);

ALTER TABLE `peaks`
ADD CONSTRAINT `fk_mountains_peaks`
FOREIGN KEY (`mountain_id`)
REFERENCES `mountains` (`id`);