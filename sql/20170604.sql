


ALTER TABLE `wjw`.`user` 
ADD COLUMN `admin` BIT NOT NULL DEFAULT 0 AFTER `password`;