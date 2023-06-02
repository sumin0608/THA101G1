CREATE TABLE article
(
    articleId         int          NOT NULL AUTO_INCREMENT,
    accountId         int          NOT NULL,
    sportType         int          NOT NULL,
    articleTitle      varchar(300) NOT NULL,
    articleText       varchar(300) NOT NULL,
    articleTime       datetime     NOT NULL,
    articleChamgeTime datetime     NOT NULL,
    articleState      int          NOT NULL,
    articleType       int          NOT NULL,
    PRIMARY KEY (articleId)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO article
(accountId, sportType, articleTitle, articleText, articleTime, articleChamgeTime, articleState, articleType)
VALUES (1, 1, '範例標題1', '範例內容1', '2023-06-01 00:00:00', '2023-06-01 00:30:00', 1, 1),
       (2, 2, '範例標題2', '範例內容2', '2023-06-01 01:00:00', '2023-06-01 01:30:00', 1, 2),
       (3, 3, '範例標題3', '範例內容3', '2023-06-01 02:00:00', '2023-06-01 02:30:00', 0, 1),
       (4, 4, '範例標題4', '範例內容4', '2023-06-01 03:00:00', '2023-06-01 03:30:00', 1, 2),
       (5, 5, '範例標題5', '範例內容5', '2023-06-01 04:00:00', '2023-06-01 04:30:00', 0, 1),
       (6, 6, '範例標題6', '範例內容6', '2023-06-01 05:00:00', '2023-06-01 05:30:00', 1, 2),
       (7, 7, '範例標題7', '範例內容7', '2023-06-01 06:00:00', '2023-06-01 06:30:00', 1, 1),
       (8, 8, '範例標題8', '範例內容8', '2023-06-01 07:00:00', '2023-06-01 07:30:00', 0, 2),
       (9, 9, '範例標題9', '範例內容9', '2023-06-01 08:00:00', '2023-06-01 08:30:00', 1, 1),
       (10, 10, '範例標題10', '範例內容10', '2023-06-01 09:00:00', '2023-06-01 09:30:00', 0, 2),
       (11, 6, '範例標題11', '範例內容11', '2023-06-01 10:00:00', '2023-06-01 10:30:00', 1, 1),
       (12, 6, '範例標題12', '範例內容12', '2023-06-01 11:00:00', '2023-06-01 11:30:00', 1, 2),
       (13, 8, '範例標題13', '範例內容13', '2023-06-01 12:00:00', '2023-06-01 12:30:00', 0, 1),
       (14, 9, '範例標題14', '範例內容14', '2023-06-01 13:00:00', '2023-06-01 13:30:00', 1, 2),
       (15, 10, '範例標題15', '範例內容15', '2023-06-01 14:00:00', '2023-06-01 14:30:00', 0, 1);