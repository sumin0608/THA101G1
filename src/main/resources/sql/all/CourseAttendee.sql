create table CourseAttendee
(
    attendId      int auto_increment
        primary key,
    courseId      int           null,
    accountId     int           null,
    attendTime    timestamp     null,
    status        int default 0 not null comment '1.參加待審核2.通過3.未通過4:退出待審核5:退出成功6:完成課程',
    reason        text          not null,
    paymentStatus int default 1 null comment '1.未付款
2.已付款
3.申請退款
4:已退款',
    commentStatus int default 0 null comment '0.未評價1.已評價'
);

INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (1, 21, 1, '2023-06-12 12:40:30', 2, '我想打球', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (2, 21, 2, '2023-06-12 12:40:30', 1, '我想打中鋒', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (3, 21, 3, '2023-06-12 12:40:30', 1, '我想打後衛', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (4, 21, 7, '2023-06-12 12:40:30', 1, '我想打人!', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (5, 21, 8, '2023-06-12 12:40:30', 1, '我愛打球，拜託拜託，讓我加入', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (6, 24, 1, '2023-06-12 12:40:30', 4, '想交朋友', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (7, 24, 2, '2023-06-12 12:40:30', 4, '身體健康', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (8, 25, 1, '2023-06-12 12:40:30', 4, '學習', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (9, 25, 2, '2023-06-12 12:40:30', 1, '想要交朋友', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (10, 1, 2, '2023-06-12 12:40:30', 1, '想要交朋友', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (11, 2, 2, '2023-06-12 12:40:30', 1, '我要減肥', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (12, 3, 2, '2023-06-12 12:40:30', 1, 'I love play ball', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (13, 31, 2, '2023-06-12 12:40:30', 1, 'I love play~', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (14, 32, 2, '2023-06-12 12:40:30', 1, 'I love play~', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (15, 33, 2, '2023-06-12 12:40:30', 1, 'I love play~', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (16, 29, 5, '2023-06-12 12:40:30', 1, 'I love play~', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (17, 30, 5, '2023-06-12 12:40:30', 1, 'I love play~', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (18, 34, 5, '2023-06-12 12:40:30', 1, 'I love play~', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (19, 35, 5, '2023-06-12 12:40:30', 2, '我愛運動~', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (20, 36, 5, '2023-06-12 12:40:30', 6, '我愛運動~', 2, 1);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (21, 37, 5, '2023-06-12 12:40:30', 6, '我愛運動~', 2, 1);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (22, 38, 5, '2023-06-12 12:40:30', 6, '我愛運動~', 2, 1);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (23, 39, 5, '2023-06-12 12:40:30', 6, '我愛運動~', 2, 0);
INSERT INTO THA101G1.CourseAttendee (attendId, courseId, accountId, attendTime, status, reason, paymentStatus, commentStatus) VALUES (24, 20, 1, '2023-06-12 14:35:43', 0, '想打籃球', 1, 0);
