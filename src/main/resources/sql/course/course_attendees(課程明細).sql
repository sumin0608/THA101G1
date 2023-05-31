CREATE TABLE course_attendees (
`attendId` int NOT NULL AUTO_INCREMENT,
`courseId` int DEFAULT NULL,
`memberId` int DEFAULT NULL,
  `attendTime` timestamp NULL DEFAULT NULL,`status` int NOT NULL DEFAULT '0' COMMENT '1.待審核2.通過3.未通過4:退出',`reason` text NOT NULL,
  `paymentStatus` int DEFAULT '1' COMMENT '1.未付款\n2.已付款\n3.申請退款\n4:已退款',
  `commentStatus` int DEFAULT NULL,
  `course_attendeescol` varchar(45) GENERATED ALWAYS AS (0) VIRTUAL COMMENT '0.未評價1.已評價',
  PRIMARY KEY (`attendId`)
);

INSERT INTO course_attendees (courseId, memberId, attendTime, status, reason, paymentStatus, commentStatus)
VALUES 
  (1, 2, CURRENT_TIMESTAMP, 1, '參加原因1', 1, 0),
  (1, 3, CURRENT_TIMESTAMP, 1, '參加原因2', 1, 0),
  (2, 4, CURRENT_TIMESTAMP, 1, '參加原因3', 0, 0);

SELECT * FROM THA101G1.course_attendees;