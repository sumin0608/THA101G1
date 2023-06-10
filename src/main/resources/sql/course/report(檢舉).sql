CREATE TABLE `report` (
  `reportId` int NOT NULL AUTO_INCREMENT,
  `accountId` int NOT NULL,
  `reportType` varchar(10) NOT NULL,
  `accountId2` int NOT NULL,
  `reportTime` timestamp(5) NOT NULL,
  `reportReason` varchar(200) NOT NULL,
  `reportStatus` int NOT NULL,
  `reportPicture` longtext,
  PRIMARY KEY (`reportId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `THA101G1`.`report`
(`accountId`,
`reportType`,
`accountId2`,
`reportTime`,
`reportReason`,
`reportStatus`,
`reportPicture`)
VALUES
(1, '類型1', 2, '2023-06-01 12:00:00', '原因1', 1, '圖片1'),
(3, '類型2', 4, '2023-06-02 13:30:00', '原因2', 1, '圖片2'),
(5, '類型1', 6, '2023-06-03 10:15:00', '原因3', 1, '圖片3'),
(7, '類型3', 8, '2023-06-04 09:45:00', '原因4', 1, '圖片4'),
(9, '類型2', 10, '2023-06-05 14:20:00', '原因5', 1, '圖片5'),
(11, '類型1', 12, '2023-06-06 11:30:00', '原因6', 1, '圖片6'),
(13, '類型3', 14, '2023-06-07 16:00:00', '原因7', 1, '圖片7'),
(15, '類型2', 16, '2023-06-08 15:10:00', '原因8', 1, '圖片8'),
(17, '類型1', 18, '2023-06-09 10:45:00', '原因9', 1, '圖片9'),
(19, '類型3', 20, '2023-06-10 12:20:00', '原因10', 1, '圖片10');