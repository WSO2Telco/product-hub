ALTER TABLE `<<STATS_DB>>`.`sub_approval_audit`  drop primary key;

ALTER TABLE `<<STATS_DB>>`.`sub_approval_audit`  ADD SUB_APPROVAL_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY;

CREATE TABLE IF NOT EXISTS `workflow_reference` (
  `workflow_ref_id` varchar(255) NOT NULL,
  `application_id` varchar(45) DEFAULT NULL,
  `api_name` varchar(45) DEFAULT NULL,
  `api_version` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `service_endpoint` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`workflow_ref_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
