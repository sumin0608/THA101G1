CREATE TABLE `trainer_cert` (
  `number` int NOT NULL DEFAULT '0',
  `cert_name` varchar(20) NOT NULL,
  `english_cert_name` varchar(50) DEFAULT NULL,
  `abbr_name` varchar(20) DEFAULT NULL
);

INSERT INTO `THA101G1`.`trainer_cert`
(`cert_name`,
`english_cert_name`,
`abbr_name`)
VALUES
('籃球教練',
'basketball coach',
'b_license');


SELECT * FROM THA101G1.trainer_cert;