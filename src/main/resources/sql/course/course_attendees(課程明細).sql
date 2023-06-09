DROP TABLE IF EXISTS `CourseAttendee`;

CREATE TABLE CourseAttendee (
`attendId` int NOT NULL AUTO_INCREMENT,
`courseId` int DEFAULT NULL,
`accountId` int DEFAULT NULL,
  `attendTime` timestamp NULL DEFAULT NULL,`status` int NOT NULL DEFAULT '0' COMMENT '1.參加待審核2.通過3.未通過4:退出待審核5:退出成功6:完成課程',`reason` text NOT NULL,
  `paymentStatus` int DEFAULT '1' COMMENT '1.未付款\n2.已付款\n3.申請退款\n4:已退款',
  `commentStatus` int DEFAULT '0' COMMENT '0.未評價1.已評價',
  PRIMARY KEY (`attendId`)
);

INSERT INTO CourseAttendee (courseId,accountId, attendTime, status, reason, paymentStatus, commentStatus)
VALUES 
(21, 1, CURRENT_TIMESTAMP, 2, '我想打球', 2, 0),
(21, 2, CURRENT_TIMESTAMP, 1, '我想打中鋒', 2, 0),
(21, 3, CURRENT_TIMESTAMP, 1, '我想打後衛', 2, 0),
(21, 7, CURRENT_TIMESTAMP, 1, '我想打人!', 2, 0),
(21, 8, CURRENT_TIMESTAMP, 1, '我愛打球，拜託拜託，讓我加入', 2, 0),
     
(24, 1, CURRENT_TIMESTAMP, 4, '想交朋友', 2, 0),
(24, 2, CURRENT_TIMESTAMP, 4, '身體健康', 2, 0),
(25, 1, CURRENT_TIMESTAMP, 4, '學習', 2, 0),
(25, 2, CURRENT_TIMESTAMP, 1, '想要交朋友', 2, 0),
(1, 2, CURRENT_TIMESTAMP, 1, '想要交朋友', 2, 0),
(2, 2, CURRENT_TIMESTAMP, 1, '我要減肥', 2, 0),
(3, 2, CURRENT_TIMESTAMP, 1, 'I love play ball', 2, 0),
(31, 2, CURRENT_TIMESTAMP, 1, 'I love play~', 2, 0),
(32, 2, CURRENT_TIMESTAMP, 1, 'I love play~', 2, 0),
(33, 2, CURRENT_TIMESTAMP, 1, 'I love play~', 2, 0),
(29, 5, CURRENT_TIMESTAMP, 1, 'I love play~', 2, 0),
(30, 5, CURRENT_TIMESTAMP, 1, 'I love play~', 2, 0),
(34, 5, CURRENT_TIMESTAMP, 1, 'I love play~', 2, 0),
(35, 5, CURRENT_TIMESTAMP, 2, '我愛運動~', 2, 0),
(36, 5, CURRENT_TIMESTAMP, 6, '我愛運動~', 2, 1),
(37, 5, CURRENT_TIMESTAMP, 6, '我愛運動~', 2, 1),
(38, 5, CURRENT_TIMESTAMP, 6, '我愛運動~', 2, 0),
(39, 5, CURRENT_TIMESTAMP, 6, '我愛運動~', 2, 0)
;
SELECT * FROM THA101G1.CourseAttendee;