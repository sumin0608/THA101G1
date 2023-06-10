DROP TABLE IF EXISTS `EVENT_ATTENDEES`;

CREATE TABLE `EVENT_ATTENDEES`
(
    `attendId`       int  NOT NULL AUTO_INCREMENT,
    `eventId`        int           DEFAULT NULL,
    `accountId`      int           DEFAULT NULL,
    `attendTime`     timestamp NULL DEFAULT NULL,
    `attendeeStatus` int  NOT NULL DEFAULT '0' COMMENT '1.參加待審核2.通過3.未通過4:退出',
    `reason`         text NOT NULL,
    `commentStatus`  int           DEFAULT '0' COMMENT '0.未評價1.已評價',
    PRIMARY KEY (`attendId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO EVENT_ATTENDEES (eventId, accountId, attendTime, attendeeStatus, reason, commentStatus)
VALUES (1, 1, CURRENT_TIMESTAMP, 2, '我想打球', 0),
       (1, 2, CURRENT_TIMESTAMP, 1, '我想打中鋒', 0),
       (1, 3, CURRENT_TIMESTAMP, 1, '我想打後衛', 0),
       (1, 5, CURRENT_TIMESTAMP, 1, '我想打人!', 0),
       (2, 3, CURRENT_TIMESTAMP, 1, '我愛打球，拜託拜託，讓我加入', 0),
       (2, 3, CURRENT_TIMESTAMP, 4, '想交朋友', 2, 0),
       (2, 4, CURRENT_TIMESTAMP, 4, '身體健康', 0),
       (2, 5, CURRENT_TIMESTAMP, 4, '學習', 0),
       (3, 1, CURRENT_TIMESTAMP, 1, '想要交朋友', 0),
       (3, 2, CURRENT_TIMESTAMP, 1, '想要交朋友', 0)
;


SELECT *
FROM THA101G1.EVENT_ATTENDEES;