DROP TABLE IF EXISTS `course_comment`;

CREATE TABLE `course_comment` (
  `commentId` int NOT NULL AUTO_INCREMENT COMMENT '課程評論流水號',
  `courseId` int DEFAULT NULL COMMENT '課程編號',
  `eventName` varchar(50) NOT NULL COMMENT '課程名字',
  `accountIdReviewed` int DEFAULT NULL COMMENT '會員編號(被評論者)',
  `accountIdReviewer` int DEFAULT NULL COMMENT '會員編號(評論者)',
  `commentContent` varchar(255) DEFAULT NULL COMMENT '評論內容',
  `commentRating` int DEFAULT NULL COMMENT '評論分數',
  `createdAt` timestamp NULL DEFAULT NULL COMMENT '日期',
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改日期',
  `photo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `THA101G1`.`course_comment`
(`courseId`,`eventName`,`accountIdReviewed`,`accountIdReviewer`,`commentContent`,`commentRating`,
`createdAt`,`updatedAt`,`photo`)
VALUES
(31,'橄欖球友誼賽',5,1,'非常好!', 4, '2023-05-30 20:00:00', '2023-05-30 20:00:00', null),
(31,'橄欖球友誼賽',5,2,'用心教學，服務良好!', 4, '2023-05-21 20:00:00', '2023-05-30 20:00:00', null),
(31,'橄欖球友誼賽',5,3,'學到很多!', 4, '2023-05-19 20:00:00', '2023-05-19 20:00:00', null),
(32,'橄欖球賽',5,7,'還行', 3, '2023-05-30 20:00:00', '2023-05-30 20:00:00', null),
(32,'橄欖球賽',5,8,'真的瘦了', 5, '2023-05-28 20:00:00', '2023-05-28 20:00:00', null),
(32,'橄欖球友誼賽2',5,8,'太累', 2, '2023-05-29 20:00:00', '2023-05-29 20:00:00', null),
(36,'trx肌力平衡',7,5,'喜歡這教練', 4, '2023-05-30 20:00:00', '2023-05-30 20:00:00', null),
(37,'專業教練課程',7,5,'好課大推', 5, '2023-05-28 20:00:00', '2023-05-28 20:00:00', null)
;


SELECT * FROM THA101G1.course_comment;
