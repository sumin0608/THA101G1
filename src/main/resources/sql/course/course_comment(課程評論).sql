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
(`courseId`,`accountIdReviewed`,`accountIdReviewer`,`commentContent`,`commentRating`,
`createdAt`,`updatedAt`,`photo`)
VALUES
(1,1001,2004,'這是一個評論內容', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null);


SELECT * FROM THA101G1.course_comment;
