DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `courseID` int NOT NULL AUTO_INCREMENT,`creator` int NOT NULL COMMENT 'memberID',`eventName` varchar(50) NOT NULL,
  `expectedPrice` int NOT NULL,`courseStartDate` date NOT NULL,`courseStartTime` datetime NOT NULL,
  `courseDuration` time DEFAULT NULL,`registrationDeadline` timestamp NOT NULL,
  `courseCreationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `maximumCapacity` int NOT NULL,`description` text NOT NULL,`photo` varchar(255) NOT NULL,
  `location` varchar(50) NOT NULL,`city` varchar(10) NOT NULL,`district` varchar(10) NOT NULL,
  `detailedAddress` varchar(100) NOT NULL,`categoryID` varchar(10) NOT NULL,`currentEnrolment` int DEFAULT '0',
  `courseStatus` int DEFAULT '1' COMMENT '1.可參加 2. 暫停報名 3. 截止報名 4:滿團 5:強制下架' ,`paidAdvertising` int DEFAULT '0',`paidAdvertisingTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`courseID`)
);

INSERT INTO course (creator,eventName, expectedPrice, courseStartDate, courseStartTime, courseDuration, registrationDeadline, courseCreationDate, maximumCapacity, description, photo, location, city, district, detailedAddress, categoryID, currentEnrolment, courseStatus, paidAdvertising, paidAdvertisingTime)
VALUES
(5, '重量訓練體驗', 500, '2023-07-10', '2023-07-10 14:00:00', '2.5', '2023-07-09 23:59:59', '2023-06-09 10:00:00', 10, '塑造健美身材，重訓運動帶來的力量與自信，由此開始！', 'john-arano.jpg', '健身房', '台北市', '中山區', '中山北路二段107號', '重訓課', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '重量訓練初級1', 500, '2023-07-15', '2023-06-15 18:00:00', '2 ', '2023-07-09 23:59:59', '2023-06-09 15:00:00', 10, '塑造健美身材，重訓運動帶來的力量與自信，由此開始！', 'john-arano.jpg', '健身房', '台北市', '中山區','中山北路二段107號', '重訓課', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '重量訓練初級2', 350, '2023-06-20', '2023-06-20 20:00:00', '2 ', '2023-07-09 23:59:59', '2023-06-09 18:00:00', 10, '塑造健美身材，重訓運動帶來的力量與自信，由此開始！', 'john-arano.jpg', '健身房', '台北市', '中山區','中山北路二段107號', '重訓課', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '重量訓練初級3', 350, '2023-06-21', '2023-06-21 20:00:00', '2 ', '2023-07-09 23:59:59', '2023-06-09 18:00:00', 10, '塑造健美身材，重訓運動帶來的力量與自信，由此開始！', 'john-arano.jpg', '健身房', '台北市', '中山區','中山北路二段107號', '重訓課', 0, 2, 0, '2024-06-19 18:00:00'),
(5, '重量訓練初級4', 350, '2023-06-22', '2023-06-22 20:00:00', '2 ', '2023-07-09 23:59:59', '2023-06-09 18:00:00', 3, '塑造健美身材，重訓運動帶來的力量與自信，由此開始！', 'john-arano.jpg', '健身房', '台北市', '中山區','中山北路二段107號', '重訓課', 0, 4, 0, '2024-06-19 18:00:00'),

(7, '足球初級1', 100, '2023-07-20', '2023-07-20 09:00:00', '0.5', '2023-07-19 18:00:00', '2023-05-18 10:00:00', 10, '磨練技術，踢出激情，一起追逐足球夢！', 'aboodi.jpg', '足球場', '台北市', '大安區', '詳細地址待定', '足球', 0, 1, 0, '2024-06-19 18:00:00'),
(7, '足球初級2', 100, '2023-07-22', '2023-07-22 10:00:00', '2', '2023-07-19 18:00:00', '2023-05-18 10:00:00', 10, '磨練技術，踢出激情，一起追逐足球夢！', 'aboodi.jpg', '足球場', '台北市', '大同區', '詳細地址待定', '足球', 0, 2, 0, '2024-06-19 18:00:00'),
(7, '足球初級3', 100, '2023-07-23', '2023-07-23 14:00:00', '1.5', '2023-07-19 18:00:00', '2023-05-18 10:00:00', 10, '磨練技術，踢出激情，一起追逐足球夢！', 'aboodi.jpg', '足球場', '台北市', '信義區', '詳細地址待定', '足球', 0, 1, 0, '2024-06-19 18:00:00'),
-- 預計demo滿團
(7, '足球中級', 200, '2023-07-25', '2023-07-25 16:00:00', '1', '2023-07-21 18:00:00', '2023-05-18 10:00:00', 1, '磨練技術，踢出激情，一起追逐足球夢！', 'amogrlA.jpg', '淡江大學', '台北市', '淡水區', '英專路151號', '足球', 0, 1, 0, '2024-06-19 18:00:00'),				

(8, '室外足球', 100, '2023-07-23', '2023-07-23 20:00:00', '1', '2023-07-20 18:00:00', '2023-05-18 10:00:00', 2, '我愛足球~', 'Cuccittini.jpg', '新店足球場', '台北市', '新店區', '環河路22號B1', '足球', 0, 1, 0, '2024-06-19 18:00:00'),                
                
(7, '網球體驗', 200, '2023-07-20', '2023-07-20 20:00:00', '4', '2023-07-20 18:00:00', '2023-05-18 10:00:00', 1, '體驗網球的魅力吧!', '1626080183.png', '網球教室', '基隆', '七堵區', '大成街51號', '網球', 0, 1, 0, '2024-06-19 18:00:00'),
(8, '網球中級1', 300, '2023-07-20', '2023-07-20 20:00:00', '4', '2023-07-19 18:00:00', '2023-05-18 10:00:00', 2, '發揮你的力量，擊出精彩，征服網球場', '457_924.jpg', '網球教室', '桃園', '桃園區', '桃園區縣府路1號', '網球', 0, 1, 0, '2024-06-19 18:00:00'),
(8, '網球中級2', 300, '2023-07-20', '2023-07-25 17:00:00', '4', '2023-07-19 18:00:00', '2023-05-18 10:00:00', 2, '發揮你的力量，擊出精彩，征服網球場', '457_924.jpg', '網球教室', '桃園', '桃園區', '桃園區縣府路1號', '網球', 0, 1, 0, '2024-06-19 18:00:00'),
(8, '網球中級3', 300, '2023-07-20', '2023-07-30 20:00:00', '4', '2023-07-19 18:00:00', '2023-05-18 10:00:00', 2, '擊出精彩殺球、發揮你的力量', '457images.jpg', '網球場一', '台北市', '新店區', '環河路37號', '網球', 0, 1, 0, '2024-06-19 18:00:00'),

(5, '籃球初級1', 200, '2023-07-20', '2023-07-20 10:00:00', '2', '2023-07-19 23:59:59', '2024-05-19 08:00:00', 10, '籃球初級課程一的教學', 'cce334.jpg', '籃球場地一', '台北市', '新店區', '新店路1號', '籃球', 0, 1, 0, '2024-05-19 08:00:00'),
(5, '籃球初級2', 200, '2023-07-21', '2023-07-21 14:00:00', '2', '2023-07-20 23:59:59', '2024-05-20 10:00:00', 10, '籃球初級課程二的教學描述', 'mcz968378217810.jpg', '籃球場地二', '台北市', '內湖區', '內湖路2號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '籃球中級1', 300, '2023-07-22', '2023-07-22 18:00:00', '2', '2023-07-21 23:59:59', '2024-05-21 16:00:00', 10, '籃球中級課程一的教學描述', '809dde90.jpg', '籃球場地三', '台北市', '信義區', '信義路3號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '籃球中級2', 300, '2023-07-22', '2023-07-23 10:00:00', '2', '2023-07-22 23:59:59', '2024-05-22 08:00:00', 10, '籃球中級課程二的教學描述', '20210818145.jpg', '籃球場地四', '台北市', '大安區', '大安路4號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '籃球高級1', 400, '2023-07-24', '2023-07-24 16:00:00', '2', '2023-07-23 23:59:59', '2024-05-23 14:00:00', 10, '籃球高級課程一的教學描述', '0479-scaled.jpg', '籃球場地五', '台北市', '士林區', '士林路5號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '籃球高級2', 400, '2023-07-26', '2023-07-26 20:00:00', '2', '2023-07-25 23:59:59', '2024-05-25 18:00:00', 10, '籃球高級課程二的教學描述', '0479-scaled.jpg', '籃球場地六', '台北市', '北投區', '北投路6號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),
-- 預計demo參加 
(5, '5vs5籃球賽', 550, '2023-08-01', '2023-08-01 10:00:00', '5', '2023-07-26 23:59:59', '2024-05-26 08:00:00', 10, '籃球進階課程一的教學描述', 'jokic1.webp', '朱崙公園籃球場', '台北市', '中山區', '龍江路45巷內號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),

(10, '籃球進階1', 250, '2023-07-10', '2023-07-10 14:00:00', '2', '2023-07-09 23:59:59', '2024-06-09 10:00:00', 15, '紙上得來終覺淺，絕知此事要躬行，出來打球', 'kylie-osullivan.jpg', '籃球場地二', '新竹', '東區', '中山路2號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),
(10, '籃球高級1', 300, '2023-07-15', '2023-07-15 18:00:00', '2', '2023-07-14 23:59:59', '2024-06-14 15:00:00', 12, '籃球高級課程一的教學描述', 'jokic2.jpg', '籃球場地三', '新竹', '北區', '民生路3號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '籃球灌籃教學', 350, '2023-07-20', '2023-07-20 20:00:00', '2', '2023-07-19 23:59:59', '2024-06-19 18:00:00', 10, '籃球精英課程一的教學描述', 'stephen-baker.jpg', '籃球場地四', '新竹', '西區', '建功路4號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),

(5, '有氧訓練', 250, '2024-06-10', '2024-06-10 14:00:00', '2.5', '2024-06-09 23:59:59', '2024-06-09 10:00:00', 15, '籃球進階課程一的描述', 'john-arano.jpg', '健身房', '新竹', '東區', '中山路2號', '重訓課', 0, 4, 0, '2024-06-19 18:00:00'),
(5, '壺玲訓練1', 300, '2024-06-15', '2024-06-15 18:00:00', '2 ', '2024-06-14 23:59:59', '2024-06-14 15:00:00', 12, '籃球高級課程一的描述', 'john-arano.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 2, 0, '2024-06-14 15:00:00'),
(5, '壺玲訓練2', 350, '2024-06-20', '2024-06-20 20:00:00', '2 ', '2024-06-19 23:59:59', '2024-06-19 18:00:00', 10, '籃球精英課程一的描述', 'john-arano.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 3, 0, '2024-06-19 18:00:00'),

(5, '橄欖球體驗1', 350, '2023-07-17', '2023-07-17 20:00:00', '2 ', '2023-06-14 23:59:59', '2024-05-11 18:00:00', 10, '橄欖球它有兩支由11名球員組成的球隊，以橢圓形的球進行比賽。進攻方試圖獲得更多的進球，而防守方則試圖阻止進攻方的進攻。', 'fit-Pzx.jpg', '河濱橄欖球場', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),
(8, '橄欖球體驗2', 350, '2023-06-18', '2023-06-18 20:00:00', '2 ', '2023-06-14 23:59:59', '2024-05-11 18:00:00', 10, '橄欖球是一種受歡迎的肢體接觸運動，比賽時間分為四個節，每節長度取決於比賽級別和規則。', 'fit-zc22p.jpg', '橄欖球場一', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),
(8, '橄欖球體驗3', 350, '2023-08-19', '2023-08-18 20:00:00', '1.5 ', '2023-08-14 23:59:59', '2024-05-11 18:00:00', 10, '主要在美國、加拿大、英國、澳大利亞和紐西蘭等國家流行。它有兩支由11名球員組成的球隊，以橢圓形的球進行比賽。
橄欖球比賽的目標是將球帶進對方的終場區，以得分。這可以通過持球跑、傳球或踢球實現。進攻方試圖獲得更多的進球，而防守方則試圖阻止進攻方的進攻，並奪取球權。橄欖球比賽的場地呈長方形，由兩個終場區和中場區組成。比賽時間分為四個節，每節長度取決於比賽級別和規則。', 'quarterback-67.jpg', '橄欖球場', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),

-- 過去課程 
(5, '橄欖球友誼賽', 350, '2023-05-20', '2023-05-20 13:00:00', '2 ', '2023-05-01 23:59:59', '2023-05-19 18:00:00', 10, '橄欖球是一種受歡迎的肢體接觸運動，以橢圓形的球進行比賽。
橄欖球比賽的目標是將球帶進對方的終場區，以得分。這可以通過持球跑、傳球或踢球實現。進攻方試圖獲得更多的進球，而防守方則試圖阻止進攻方的進攻，並奪取球權。橄欖球比賽的場地呈長方形，每節長度取決於比賽級別和規則。', 'fit-zc22p.jpg', '草皮', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '橄欖球友誼賽', 350, '2023-05-20', '2023-05-20 20:00:00', '2 ', '2023-05-01 23:59:59', '2024-05-19 18:00:00', 10, '比賽時間分為四個節，每節長度取決於比賽級別和規則。', 'fit-zc22p.jpg', '室外場地', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),
(5, '橄欖球速成班', 200, '2023-05-05', '2023-05-05 18:30:00', '2 ', '2023-05-01 23:59:59', '2023-08-31 18:00:00', 20, '快速入門橄欖球', 'fit-zc22p.jpg', '運動場', '宜蘭', '羅東鎮', '民權路123號', '橄欖球', 0, 1, 0, '2024-01-01 12:00:00'),
-- 過去課程
 (7, 'trx-1', 350, '2023-06-20', '2023-06-20 20:00:00', '2 ', '2023-06-19 23:59:59', '2023-06-19 18:00:00', 10, 'trx-1課程一', 'trx-1.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 2, 0, '2024-06-19 18:00:00'),
 (7, 'trx-2', 350, '2023-06-20', '2023-06-20 20:00:00', '2 ', '2023-06-19 23:59:59', '2023-06-19 18:00:00', 10, 'trx-1課程一', 'john-arano.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 2, 0, '2024-06-19 18:00:00'),
 (7, 'trx肌力平衡', 350, '2023-05-20', '2023-05-20 20:00:00', '2 ', '2023-05-19 23:59:59', '2023-06-19 18:00:00', 10, 'trx-1課程一', 'trx-1.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 2, 0, '2024-06-19 18:00:00'),
 (7, '專業教練課程', 350, '2023-05-20', '2023-05-20 20:00:00', '2 ', '2023-05-19 23:59:59', '2023-06-19 18:00:00', 10, 'trx-1課程一', 'john-arano.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 2, 0, '2024-06-19 18:00:00'),
(10, 'tibame籃球賽', 10, '2023-05-10', '2023-05-10 14:00:00', '2', '2023-05-09 23:59:59', '2024-06-09 10:00:00', 15, '紙上得來終覺淺，絕知此事要躬行，出來打球', 'kylie-osullivan.jpg', '籃球場地二', '新竹', '東區', '中山路2號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),
(7, '專業教練課程', 350, '2023-05-20', '2023-05-20 20:00:00', '2 ', '2023-05-19 23:59:59', '2023-06-19 18:00:00', 10, 'trx-1課程一', 'john-arano.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 2, 0, '2024-06-19 18:00:00')
;


SELECT * FROM THA101G1.course;