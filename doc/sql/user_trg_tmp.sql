/* user 数据分发，临时使用触发器实现*/
/* 需要使用 root 账户执行*/

DELIMITER $$

USE `dms_am`$$

DROP TRIGGER IF EXISTS `trg_user_insert`$$

CREATE
    /*!50017 DEFINER = 'root'@'%' */
    TRIGGER `trg_user_insert` AFTER INSERT ON `user` 
    FOR EACH ROW 
BEGIN
    SET @enterprise_name = (SELECT NAME FROM enterprise WHERE id = new.enterprise_id);
        
    INSERT INTO `crm_pre_sale`.`user`(id, NAME, enterprise_id, enterprise_name, STATUS)
    VALUES (new.id, new.name, new.enterprise_id, @enterprise_name, new.status)
    ON DUPLICATE KEY UPDATE NAME = new.name, enterprise_id = new.enterprise_id, enterprise_name = @enterprise_name, STATUS = new.status, row_version = new.row_version;
    
    INSERT INTO `crm_pre_sale`.`consultant`(user_id, CODE, NAME, job, create_time, creator_id, creator_name, enterprise_id)
    VALUES (new.id, new.name, new.name, 0, SYSDATE(), 'dms_am', 'dms_am', new.enterprise_id)
    ON DUPLICATE KEY UPDATE CODE = new.name, NAME = new.name, enterprise_id = modify_time = SYSDATE();
    
    INSERT INTO `sales`.`user`(id, NAME, enterprise_id, enterprise_name, STATUS)
    VALUES (new.id, new.name, new.enterprise_id, @enterprise_name, new.status)
    ON DUPLICATE KEY UPDATE NAME = new.name, enterprise_id = new.enterprise_id, enterprise_name = @enterprise_name, STATUS = new.status, row_version = new.row_version;
END;
$$

DELIMITER ;

DELIMITER $$

USE `dms_am`$$

DROP TRIGGER IF EXISTS `trg_user_update`$$

CREATE
    /*!50017 DEFINER = 'root'@'%' */
    TRIGGER `trg_user_update` AFTER UPDATE ON `user` 
    FOR EACH ROW 
BEGIN
    SET @enterprise_name = (SELECT NAME FROM enterprise WHERE id = new.enterprise_id);
        
    INSERT INTO `crm_pre_sale`.`user`(id, NAME, enterprise_id, enterprise_name, STATUS)
    VALUES (new.id, new.name, new.enterprise_id, @enterprise_name, new.status)
    ON DUPLICATE KEY UPDATE NAME = new.name, enterprise_id = new.enterprise_id, enterprise_name = @enterprise_name, STATUS = new.status, row_version = new.row_version;
    
    INSERT INTO `sales`.`user`(id, NAME, enterprise_id, enterprise_name, STATUS)
    VALUES (new.id, new.name, new.enterprise_id, @enterprise_name, new.status)
    ON DUPLICATE KEY UPDATE NAME = new.name, enterprise_id = new.enterprise_id, enterprise_name = @enterprise_name, STATUS = new.status, row_version = new.row_version;
END;
$$

DELIMITER ;

/* crm销售人员处理，待业务调整后废弃*/
/* 需要使用 root 账户执行*/

DELIMITER $$

USE `dms_am`$$

DROP TRIGGER IF EXISTS `trg_user_role_insert`$$

CREATE
    /*!50017 DEFINER = 'root'@'%' */
    TRIGGER `trg_user_role_insert` AFTER INSERT ON `user_role` 
    FOR EACH ROW 
BEGIN
    SET @jingli = 'c312a000-5a4c-4e5e-8f3d-ef1550d22154' COLLATE utf8_unicode_ci;
    SET @guwen = '49c669f1-f5f2-4410-8bbc-a88fda756bab' COLLATE utf8_unicode_ci;
    SET @job = (SELECT MAX(job) 
                 FROM (SELECT CASE role_id WHEN @jingli THEN 2 WHEN @guwen THEN 1 ELSE 0 END job 
                         FROM user_role WHERE user_id = new.user_id) tmp);
    IF @job=0 THEN
        DELETE FROM `crm_pre_sale`.`consultant` WHERE user_id = (new.user_id COLLATE utf8_general_ci);
    ELSE
        SELECT NAME, enterprise_id INTO @name, @enterprise_id FROM `user` WHERE id=new.user_id;
        INSERT INTO `crm_pre_sale`.`consultant`(user_id, CODE, NAME, job, create_time, creator_id, creator_name, enterprise_id)
        VALUES (new.user_id, IFNULL(@name, 'tmp'), IFNULL(@name, 'tmp'), @job, SYSDATE(), 'dms_am', 'dms_am', IFNULL(@enterprise_id, 'tmp'))
        ON DUPLICATE KEY UPDATE job = @job, modify_time = SYSDATE();
    END IF;
END;
$$

DELIMITER ;

DELIMITER $$

USE `dms_am`$$

DROP TRIGGER IF EXISTS `trg_user_role_delete`$$

CREATE
    /*!50017 DEFINER = 'root'@'%' */
    TRIGGER `trg_user_role_delete` AFTER DELETE ON `user_role` 
    FOR EACH ROW 
BEGIN
    SET @jingli = 'c312a000-5a4c-4e5e-8f3d-ef1550d22154' COLLATE utf8_unicode_ci;
    SET @guwen = '49c669f1-f5f2-4410-8bbc-a88fda756bab' COLLATE utf8_unicode_ci;
    SET @job = (SELECT MAX(job) 
                 FROM (SELECT CASE role_id WHEN @jingli THEN 2 WHEN @guwen THEN 1 ELSE 0 END job 
                         FROM user_role WHERE user_id = old.user_id) tmp);
    IF @job=0 || @job IS NULL THEN
        DELETE FROM `crm_pre_sale`.`consultant` WHERE user_id = (old.user_id COLLATE utf8_general_ci);
    ELSE 
        UPDATE `crm_pre_sale`.`consultant` SET job = @job, modify_time = SYSDATE() WHERE user_id = (old.user_id COLLATE utf8_general_ci);
    END IF;
END;
$$

DELIMITER ;