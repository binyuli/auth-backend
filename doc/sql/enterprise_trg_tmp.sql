/* enterprise 数据分发，临时使用触发器实现*/
/* 需要使用 root 账户执行*/

DELIMITER $$

USE `dms_am`$$

DROP TRIGGER IF EXISTS `trg_enterprise_insert`$$

CREATE
    /*!50017 DEFINER = 'root'@'%' */
    TRIGGER `trg_enterprise_insert` AFTER INSERT ON `enterprise` 
    FOR EACH ROW 
BEGIN
    INSERT INTO `sales`.`dealer`(id, CODE, NAME, TYPE, STATUS, create_time, creator_id, creator_name)
    VALUES (new.id, new.code, new.name, 1, 1, SYSDATE(), 'dms_am', 'dms_am')
    ON DUPLICATE KEY UPDATE CODE = new.code, NAME = new.name, modify_time = SYSDATE(), modifier_id = 'dms_am', modifier_name = 'dms_am';
END;
$$

DELIMITER ;

DELIMITER $$

USE `dms_am`$$

DROP TRIGGER /*!50032 IF EXISTS */ `trg_enterprise_update`$$

CREATE
    /*!50017 DEFINER = 'root'@'%' */
    TRIGGER `trg_enterprise_update` AFTER UPDATE ON `enterprise` 
    FOR EACH ROW 
BEGIN
    INSERT INTO `sales`.`dealer`(id, CODE, NAME, TYPE, STATUS, create_time, creator_id, creator_name)
    VALUES (new.id, new.code, new.name, 1, 1, SYSDATE(), 'dms_am', 'dms_am')
    ON DUPLICATE KEY UPDATE CODE = new.code, NAME = new.name, modify_time = SYSDATE(), modifier_id = 'dms_am', modifier_name = 'dms_am';
END;
$$

DELIMITER ;