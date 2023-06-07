CREATE TABLE `report` (
  `reportId` int NOT NULL AUTO_INCREMENT,
  `accountId` int NOT NULL,
  `reportType` varchar(10) NOT NULL,
  `accountId2` int NOT NULL,
  `reportTime` timestamp(5) NOT NULL,
  `reportReason` varchar(200) NOT NULL,
  `reportStatus` int NOT NULL,
  `reportPicture` longtext NOT NULL,
  PRIMARY KEY (`reportId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `project`.`report`
(`reportId`,
`accountId`,
`reportType`,
`accountId2`,
`reportTime`,
`reportReason`,
`reportStatus`,
`reportPicture`)
VALUES
(<{reportId: }>,
<{accountId: }>,
<{reportType: }>,
<{accountId2: }>,
<{reportTime: }>,
<{reportReason: }>,
<{reportStatus: }>,
<{reportPicture: }>);
