create table EVENT_ATTENDEES
(
    attendId       int auto_increment
        primary key,
    eventId        int           null,
    accountId      int           null,
    attendTime     timestamp     null,
    attendeeStatus int default 0 not null comment '1.參加待審核2.通過3.未通過4:退出',
    reason         text          not null,
    commentStatus  int default 0 null comment '0.未評價1.已評價'
);

INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (6, 1, 4, '2023-06-12 12:39:38', 2, '我想打球', 0);
INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (7, 1, 2, '2023-06-12 12:39:38', 1, '我想打中鋒', 0);
INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (8, 1, 3, '2023-06-12 12:39:38', 1, '我想打後衛', 0);
INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (9, 1, 5, '2023-06-12 12:39:38', 1, '我想打人!', 0);
INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (10, 2, 3, '2023-06-12 12:39:38', 1, '我愛打球，拜託拜託，讓我加入', 0);
INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (11, 2, 3, '2023-06-12 12:39:38', 4, '想交朋友', 0);
INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (12, 2, 4, '2023-06-12 12:39:38', 4, '身體健康', 0);
INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (13, 2, 5, '2023-06-12 12:39:38', 4, '學習', 0);
INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (14, 3, 1, '2023-06-12 12:39:38', 1, '想要交朋友', 0);
INSERT INTO THA101G1.EVENT_ATTENDEES (attendId, eventId, accountId, attendTime, attendeeStatus, reason, commentStatus) VALUES (15, 3, 2, '2023-06-12 12:39:38', 1, '想要交朋友', 0);
