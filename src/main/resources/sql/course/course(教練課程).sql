CREATE TABLE `course` (
  `courseID` int NOT NULL AUTO_INCREMENT,
  `creator` int NOT NULL COMMENT 'memberID',
  `eventName` varchar(50) NOT NULL,
  `expectedPrice` int NOT NULL,
  `courseStartDate` date NOT NULL,
  `courseStartTime` datetime NOT NULL,
  `courseDuration` time DEFAULT NULL,
  `registrationDeadline` timestamp NOT NULL,
  `courseCreationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `maximumCapacity` int NOT NULL,
  `description` text NOT NULL,
  `photo` varchar(255) NOT NULL,
  `location` varchar(50) NOT NULL,
  `city` varchar(10) NOT NULL,
  `district` varchar(10) NOT NULL,
  `detailedAddress` varchar(100) NOT NULL,
  `categoryID` varchar(10) NOT NULL,
  `currentEnrolment` int DEFAULT '0',
  `courseStatus` int DEFAULT '1',
  `paidAdvertising` int DEFAULT '0',
  `paidAdvertisingTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`courseID`)
);

INSERT INTO course (creator,eventName, expectedPrice, courseStartDate, courseStartTime, courseDuration, registrationDeadline, courseCreationDate, maximumCapacity, description, photo, location, city, district, detailedAddress, categoryID, currentEnrolment, courseStatus, paidAdvertising, paidAdvertisingTime)
VALUES
(1, '課程一', 100, '2023-05-20', '2023-05-20 09:00:00', '02:00:00', '2023-05-19 18:00:00', '2023-05-18 10:00:00', 50, '課程一的描述', 'photo1.jpg', '地點一', '城市一', '區域一', '詳細地址一', 'CAT01', 20, 1, 0, '2023-05-18 12:00:00'),
(2, '課程二', 200, '2023-05-25', '2023-05-25 14:00:00', '01:30:00', '2023-05-23 18:00:00', '2023-05-21 11:00:00', 30, '課程二的描述', 'photo2.jpg', '地點二', '城市二', '區域二', '詳細地址二', 'CAT02', 10, 1, 1, '2023-05-20 14:00:00'),
(1, 'Event 1', 100, '2023-05-19', '2023-05-19 09:00:00', '2 hours', '2023-05-18 23:59:59', '2023-05-18 10:00:00', 50, 'Description 1', 'photo1.jpg', 'Location 1', 'City 1', 'District 1', 'Address 1', 'Category 1', 0, 1, 0, '2023-05-18 10:00:00'),
(2, 'Event 2', 200, '2023-05-20', '2023-05-20 14:00:00', '1 hour', '2023-05-19 23:59:59', '2023-05-19 12:00:00', 30, 'Description 2', 'photo2.jpg', 'Location 2', 'City 2', 'District 2', 'Address 2', 'Category 2', 0, 1, 0, '2023-05-19 12:00:00'),
(3, 'Event 3', 150, '2023-05-21', '2023-05-21 18:00:00', '3 hours', '2023-05-20 23:59:59', '2023-05-20 15:00:00', 20, 'Description 3', 'photo3.jpg', 'Location 3', 'City 3', 'District 3', 'Address 3', 'Category 1', 0, 1, 0, '2023-05-20 15:00:00'),
(4, 'Event 4', 120, '2023-05-22', '2023-05-22 10:30:00', '2.5 hours', '2023-05-21 23:59:59', '2023-05-21 08:00:00', 30, 'Description 4', 'photo4.jpg', 'Location 4', 'City 4', 'District 4', 'Address 4', 'Category 2', 0, 1, 0, '2023-05-21 08:00:00'),
(5, 'Event 5', 180, '2023-05-23', '2023-05-23 15:00:00', '2 hours', '2023-05-22 23:59:59', '2023-05-22 13:00:00', 40, 'Description 5', 'photo5.jpg', 'Location 5', 'City 5', 'District 5', 'Address 5', 'Category 1', 0, 1, 0, '2023-05-22 13::00:00');


SELECT * FROM THA101G1.course;