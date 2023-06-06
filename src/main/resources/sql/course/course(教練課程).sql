DROP TABLE IF EXISTS `trainerCert`;

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
(1, '足球初級', 100, '2024-05-20', '2024-05-20 09:00:00', '0.5', '2024-05-19 18:00:00', '2023-05-18 10:00:00', 50, '課程一的描述', 'photo1.jpg', '地點一', '台北市', '大安區', '詳細地址一', '足球', 0, 1, 0, '2023-05-18 12:00:00'),
(2, '足球初級', 100, '2024-05-20', '2024-05-20 10:00:00', '0.5', '2024-05-19 18:00:00', '2023-05-18 10:00:00', 50, '課程一的描述', 'photo1.jpg', '地點一', '台北市', '大同區', '詳細地址一', '足球', 0, 1, 0, '2023-05-18 12:00:00'),
(3, '足球初級', 100, '2024-05-20', '2024-05-20 14:00:00', '0.5', '2024-05-19 18:00:00', '2023-05-18 10:00:00', 50, '課程一的描述', 'photo1.jpg', '地點一', '台北市', '信義區', '詳細地址一', '足球', 0, 1, 0, '2023-05-18 12:00:00'),
(4, '足球初級', 200, '2024-05-20', '2024-05-20 16:00:00', '1', '2024-05-19 18:00:00', '2023-05-18 10:00:00', 2, '課程一的描述', 'photo1.jpg', '地點一', '台北市', '淡水區', '詳細地址一', '足球', 0, 1, 0, '2023-05-18 12:00:00'),				
(5, '足球初級', 100, '2024-05-20', '2024-05-20 20:00:00', '1', '2024-05-19 18:00:00', '2023-05-18 10:00:00', 2, '課程一的描述', 'photo1.jpg', '地點一', '台北市', '新店區', '詳細地址一', '足球', 0, 1, 0, '2023-05-18 12:00:00'),                
                
(3, '網球體驗', 200, '2024-05-20', '2024-05-20 20:00:00', '4', '2024-05-19 18:00:00', '2023-05-18 10:00:00', 2, '課程一的描述', 'photo1.jpg', '地點一', '基隆', '七堵區', '詳細地址一', '網球', 0, 1, 0, '2023-05-18 12:00:00'),
(2, '網球中級1', 300, '2024-05-20', '2024-05-20 20:00:00', '4', '2024-05-19 18:00:00', '2023-05-18 10:00:00', 2, '課程一的描述', 'photo1.jpg', '地點一', '台北市', '新店區', '詳細地址一', '網球', 0, 1, 0, '2023-05-18 12:00:00'),
(2, '網球中級2', 300, '2024-05-20', '2024-05-25 17:00:00', '4', '2024-05-19 18:00:00', '2023-05-18 10:00:00', 2, '課程一的描述', 'photo1.jpg', '地點一', '台北市', '新店區', '詳細地址一', '網球', 0, 1, 0, '2023-05-18 12:00:00'),
(2, '網球中級3', 300, '2024-05-20', '2024-05-30 20:00:00', '4', '2024-05-19 18:00:00', '2023-05-18 10:00:00', 2, '課程一的描述', 'photo1.jpg', '地點一', '台北市', '新店區', '詳細地址一', '網球', 0, 1, 0, '2023-05-18 12:00:00'),
(2, '籃球初級1', 200, '2024-05-20', '2024-05-20 10:00:00', '2', '2024-05-19 23:59:59', '2024-05-19 08:00:00', 20, '籃球初級課程一的描述', 'photo1.jpg', '籃球場地一', '台北市', '新店區', '新店路1號', '籃球', 0, 1, 0, '2024-05-19 08:00:00'),
(2, '籃球初級2', 200, '2024-05-21', '2024-05-21 14:00:00', '2', '2024-05-20 23:59:59', '2024-05-20 10:00:00', 20, '籃球初級課程二的描述', 'photo2.jpg', '籃球場地二', '台北市', '內湖區', '內湖路2號', '籃球', 0, 1, 0, '2024-05-20 10:00:00'),
(3, '籃球中級1', 300, '2024-05-22', '2024-05-22 18:00:00', '2', '2024-05-21 23:59:59', '2024-05-21 16:00:00', 20, '籃球中級課程一的描述', 'photo3.jpg', '籃球場地三', '台北市', '信義區', '信義路3號', '籃球', 0, 1, 0, '2024-05-21 16:00:00'),
(3, '籃球中級2', 300, '2024-05-23', '2024-05-23 10:00:00', '2', '2024-05-22 23:59:59', '2024-05-22 08:00:00', 20, '籃球中級課程二的描述', 'photo4.jpg', '籃球場地四', '台北市', '大安區', '大安路4號', '籃球', 0, 1, 0, '2024-05-22 08:00:00'),
(3, '籃球高級1', 400, '2024-05-24', '2024-05-24 16:00:00', '2', '2024-05-23 23:59:59', '2024-05-23 14:00:00', 20, '籃球高級課程一的描述', 'photo5.jpg', '籃球場地五', '台北市', '士林區', '士林路5號', '籃球', 0, 1, 0, '2024-05-23 14:00:00'),
(3, '籃球高級2', 400, '2024-05-26', '2024-05-26 20:00:00', '2', '2024-05-25 23:59:59', '2024-05-25 18:00:00', 20, '籃球高級課程二的描述', 'photo6.jpg', '籃球場地六', '台北市', '北投區', '北投路6號', '籃球', 0, 1, 0, '2024-05-25 18:00:00'),
(4, '籃球進階1', 500, '2024-05-27', '2024-05-27 10:00:00', '2', '2024-05-26 23:59:59', '2024-05-26 08:00:00', 20, '籃球進階課程一的描述', 'photo7.jpg', '籃球場地七', '台北市', '中山區', '中山路7號', '籃球', 0, 1, 0, '2024-05-26 08:00:00'),
(3, '籃球進階1', 250, '2024-06-10', '2024-06-10 14:00:00', '2', '2024-06-09 23:59:59', '2024-06-09 10:00:00', 15, '籃球進階課程一的描述', 'photo2.jpg', '籃球場地二', '新竹', '東區', '中山路2號', '籃球', 0, 1, 0, '2024-06-09 10:00:00'),
(4, '籃球高級1', 300, '2024-06-15', '2024-06-15 18:00:00', '2', '2024-06-14 23:59:59', '2024-06-14 15:00:00', 12, '籃球高級課程一的描述', 'photo3.jpg', '籃球場地三', '新竹', '北區', '民生路3號', '籃球', 0, 1, 0, '2024-06-14 15:00:00'),
(5, '籃球精英1', 350, '2024-06-20', '2024-06-20 20:00:00', '2', '2024-06-19 23:59:59', '2024-06-19 18:00:00', 10, '籃球精英課程一的描述', 'photo4.jpg', '籃球場地四', '新竹', '西區', '建功路4號', '籃球', 0, 1, 0, '2024-06-19 18:00:00'),
(3, '重量訓練體驗', 250, '2024-06-10', '2024-06-10 14:00:00', '2.5', '2024-06-09 23:59:59', '2024-06-09 10:00:00', 15, '籃球進階課程一的描述', 'john-arano.jpg', '健身房', '新竹', '東區', '中山路2號', '重訓課', 0, 1, 0, '2024-06-09 10:00:00'),
(4, '重量訓練初級1', 300, '2024-06-15', '2024-06-15 18:00:00', '2 ', '2024-06-14 23:59:59', '2024-06-14 15:00:00', 12, '籃球高級課程一的描述', 'john-arano.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 1, 0, '2024-06-14 15:00:00'),
(4, '重量訓練初級2', 350, '2024-06-20', '2024-06-20 20:00:00', '2 ', '2024-06-19 23:59:59', '2024-06-19 18:00:00', 10, '籃球精英課程一的描述', 'john-arano.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 1, 0, '2024-06-19 18:00:00'),
(1, '橄欖球體驗1', 350, '2023-05-17', '2024-05-17 20:00:00', '2 ', '2023-05-14 23:59:59', '2024-05-11 18:00:00', 10, '橄欖球是一種受歡迎的肢體接觸運動，主要在美國、加拿大、英國、澳大利亞和紐西蘭等國家流行。它有兩支由11名球員組成的球隊，以橢圓形的球進行比賽。
橄欖球比賽的目標是將球帶進對方的終場區，以得分。這可以通過持球跑、傳球或踢球實現。進攻方試圖獲得更多的進球，而防守方則試圖阻止進攻方的進攻，並奪取球權。橄欖球比賽的場地呈長方形，由兩個終場區和中場區組成。比賽時間分為四個節，每節長度取決於比賽級別和規則。', '1198035985.jpg', '健身房', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),
(2, '橄欖球體驗2', 350, '2023-05-18', '2024-05-18 20:00:00', '2 ', '2023-05-14 23:59:59', '2024-05-11 18:00:00', 10, '橄欖球是一種受歡迎的肢體接觸運動，主要在美國、加拿大、英國、澳大利亞和紐西蘭等國家流行。它有兩支由11名球員組成的球隊，以橢圓形的球進行比賽。
橄欖球比賽的目標是將球帶進對方的終場區，以得分。這可以通過持球跑、傳球或踢球實現。進攻方試圖獲得更多的進球，而防守方則試圖阻止進攻方的進攻，並奪取球權。橄欖球比賽的場地呈長方形，由兩個終場區和中場區組成。比賽時間分為四個節，每節長度取決於比賽級別和規則。', '1198035985.jpg', '健身房', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),
(3, '橄欖球體驗3', 350, '2023-05-19', '2024-05-18 20:00:00', '1.5 ', '2023-05-14 23:59:59', '2024-05-11 18:00:00', 10, '橄欖球是一種受歡迎的肢體接觸運動，主要在美國、加拿大、英國、澳大利亞和紐西蘭等國家流行。它有兩支由11名球員組成的球隊，以橢圓形的球進行比賽。
橄欖球比賽的目標是將球帶進對方的終場區，以得分。這可以通過持球跑、傳球或踢球實現。進攻方試圖獲得更多的進球，而防守方則試圖阻止進攻方的進攻，並奪取球權。橄欖球比賽的場地呈長方形，由兩個終場區和中場區組成。比賽時間分為四個節，每節長度取決於比賽級別和規則。', '1198035985.jpg', '健身房', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),
(4, '橄欖球友誼賽', 350, '2023-05-20', '2024-05-20 13:00:00', '2 ', '2023-06-01 23:59:59', '2024-05-19 18:00:00', 10, '橄欖球是一種受歡迎的肢體接觸運動，主要在美國、加拿大、英國、澳大利亞和紐西蘭等國家流行。它有兩支由11名球員組成的球隊，以橢圓形的球進行比賽。
橄欖球比賽的目標是將球帶進對方的終場區，以得分。這可以通過持球跑、傳球或踢球實現。進攻方試圖獲得更多的進球，而防守方則試圖阻止進攻方的進攻，並奪取球權。橄欖球比賽的場地呈長方形，由兩個終場區和中場區組成。比賽時間分為四個節，每節長度取決於比賽級別和規則。', '1198035985.jpg', '健身房', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),
(4, '橄欖球友誼賽', 350, '2023-05-20', '2024-05-20 20:00:00', '2 ', '2023-06-01 23:59:59', '2024-05-19 18:00:00', 10, '橄欖球是一種受歡迎的肢體接觸運動，主要在美國、加拿大、英國、澳大利亞和紐西蘭等國家流行。它有兩支由11名球員組成的球隊，以橢圓形的球進行比賽。
橄欖球比賽的目標是將球帶進對方的終場區，以得分。這可以通過持球跑、傳球或踢球實現。進攻方試圖獲得更多的進球，而防守方則試圖阻止進攻方的進攻，並奪取球權。橄欖球比賽的場地呈長方形，由兩個終場區和中場區組成。比賽時間分為四個節，每節長度取決於比賽級別和規則。', '1198035985.jpg', '健身房', '宜蘭', '宜蘭市','中山路7號', '橄欖球', 0, 1, 0, '2024-06-19 18:00:00'),
 (3, '重練1', 350, '2024-06-20', '2024-06-20 20:00:00', '2 ', '2024-06-19 23:59:59', '2024-06-19 18:00:00', 10, '籃球精英課程一的描述', 'john-arano.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 2, 0, '2024-06-19 18:00:00'),
 (3, '重練2', 350, '2024-06-20', '2024-06-20 20:00:00', '2 ', '2024-06-19 23:59:59', '2024-06-19 18:00:00', 10, '籃球精英課程一的描述', 'john-arano.jpg', '健身房', '台北市', '中山區','中山路7號', '重訓課', 0, 2, 0, '2024-06-19 18:00:00')
;


SELECT * FROM THA101G1.course;