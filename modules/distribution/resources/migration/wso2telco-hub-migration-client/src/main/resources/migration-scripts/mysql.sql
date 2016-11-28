ALTER TABLE `<<STATS_DB>>`.`sub_approval_audit`  drop primary key;

ALTER TABLE `<<STATS_DB>>`.`sub_approval_audit`  ADD SUB_APPROVAL_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY;
