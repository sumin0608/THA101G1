create table course_comment
(
    commentId         int auto_increment comment '課程評論流水號'
        primary key,
    courseId          int                                 null comment '課程編號',
    eventName         varchar(50)                         not null comment '課程名字',
    accountIdReviewed int                                 null comment '會員編號(被評論者)',
    accountIdReviewer int                                 null comment '會員編號(評論者)',
    commentContent    varchar(255)                        null comment '評論內容',
    commentRating     int                                 null comment '評論分數',
    createdAt         timestamp                           null comment '日期',
    updatedAt         timestamp default CURRENT_TIMESTAMP null comment '修改日期',
    photo             varchar(100)                        null
);

INSERT INTO THA101G1.course_comment (commentId, courseId, eventName, accountIdReviewed, accountIdReviewer, commentContent, commentRating, createdAt, updatedAt, photo) VALUES (1, 31, '橄欖球友誼賽', 5, 1, '非常好!', 4, '2023-05-30 20:00:00', '2023-05-30 20:00:00', null);
INSERT INTO THA101G1.course_comment (commentId, courseId, eventName, accountIdReviewed, accountIdReviewer, commentContent, commentRating, createdAt, updatedAt, photo) VALUES (2, 31, '橄欖球友誼賽', 5, 2, '用心教學，服務良好!', 4, '2023-05-21 20:00:00', '2023-05-30 20:00:00', null);
INSERT INTO THA101G1.course_comment (commentId, courseId, eventName, accountIdReviewed, accountIdReviewer, commentContent, commentRating, createdAt, updatedAt, photo) VALUES (3, 31, '橄欖球友誼賽', 5, 3, '學到很多!', 4, '2023-05-19 20:00:00', '2023-05-19 20:00:00', null);
INSERT INTO THA101G1.course_comment (commentId, courseId, eventName, accountIdReviewed, accountIdReviewer, commentContent, commentRating, createdAt, updatedAt, photo) VALUES (4, 32, '橄欖球賽', 5, 7, '還行', 3, '2023-05-30 20:00:00', '2023-05-30 20:00:00', null);
INSERT INTO THA101G1.course_comment (commentId, courseId, eventName, accountIdReviewed, accountIdReviewer, commentContent, commentRating, createdAt, updatedAt, photo) VALUES (5, 32, '橄欖球賽', 5, 8, '真的瘦了', 5, '2023-05-28 20:00:00', '2023-05-28 20:00:00', null);
INSERT INTO THA101G1.course_comment (commentId, courseId, eventName, accountIdReviewed, accountIdReviewer, commentContent, commentRating, createdAt, updatedAt, photo) VALUES (6, 32, '橄欖球友誼賽2', 5, 8, '太累', 2, '2023-05-29 20:00:00', '2023-05-29 20:00:00', null);
INSERT INTO THA101G1.course_comment (commentId, courseId, eventName, accountIdReviewed, accountIdReviewer, commentContent, commentRating, createdAt, updatedAt, photo) VALUES (7, 36, 'trx肌力平衡', 7, 5, '喜歡這教練', 4, '2023-05-30 20:00:00', '2023-05-30 20:00:00', null);
INSERT INTO THA101G1.course_comment (commentId, courseId, eventName, accountIdReviewed, accountIdReviewer, commentContent, commentRating, createdAt, updatedAt, photo) VALUES (8, 37, '專業教練課程', 7, 5, '好課大推', 5, '2023-05-28 20:00:00', '2023-05-28 20:00:00', null);
INSERT INTO THA101G1.course_comment (commentId, courseId, eventName, accountIdReviewed, accountIdReviewer, commentContent, commentRating, createdAt, updatedAt, photo) VALUES (9, 38, 'tibame籃球賽', 10, 5, 'xxxx', 4, '2023-06-12 14:47:42', '2023-06-12 14:47:42', null);
