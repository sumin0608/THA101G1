DROP TABLE IF EXISTS `trainerCert`;

CREATE TABLE `trainerCert` (
  `licenseId` int NOT NULL DEFAULT '0',
  `certName` varchar(20) NOT NULL,
  `englishCertName` varchar(50) DEFAULT NULL,
  `abbrName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `THA101G1`.`trainerCert`
(`licenseId`, `certName`, `englishCertName`, `abbrName`)
VALUES
    (1, '健身教練證照', 'Fitness Trainer Certification', 'FTC'),
    (2, '營養師證照', 'Nutritionist Certification', 'NC'),
    (3, '瑜珈教練證照', 'Yoga Instructor Certification', 'YIC'),
    (4, '游泳教練證照', 'Swimming Coach Certification', 'SCC'),
    (5, '有氧運動教練證照', 'Aerobics Instructor Certification', 'AIC'),
    (6, '健康管理師證照', 'Health Manager Certification', 'HMC'),
    (7, '體適能教練證照', 'Physical Fitness Coach Certification', 'PFCC'),
    (8, '國際教練證照', 'International Coach Certification', 'ICC'),
    (9, '羽球教練證照', 'Badminton Coach Certification', 'BCC'),
    (10, '跑步教練證照', 'Running Coach Certification', 'RCC');
