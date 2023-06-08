CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` 
SQL SECURITY DEFINER VIEW 
`course_and_attendees` AS select `c`.`courseID` AS `courseID`,
`c`.`creator` AS `creator`,
`c`.`eventName` AS `eventName`,
`c`.`expectedPrice` AS `expectedPrice`,
`c`.`courseStartDate` AS `courseStartDate`,
`c`.`courseStartTime` AS `courseStartTime`,
`c`.`courseDuration` AS `courseDuration`,
`c`.`registrationDeadline` AS `registrationDeadline`,
`c`.`courseCreationDate` AS `courseCreationDate`,
`c`.`maximumCapacity` AS `maximumCapacity`,
`c`.`description` AS `description`,
`c`.`photo` AS `photo`,
`c`.`location` AS `location`,
`c`.`city` AS `city`,`c`.`district` AS `district`,
`c`.`detailedAddress` AS `detailedAddress`,
`c`.`categoryID` AS `categoryID`,`c`.`currentEnrolment` AS `currentEnrolment`,
`c`.`courseStatus` AS `courseStatus`,`c`.`paidAdvertising` AS `paidAdvertising`,
`c`.`paidAdvertisingTime` AS `paidAdvertisingTime`,`ca`.`attendId` AS `attendId`,
`ca`.`accountId` AS `accountId`,`ca`.`attendTime` AS `attendTime`,
`ca`.`status` AS `status`,`ca`.`reason` AS `reason`,
`ca`.`paymentStatus` AS `paymentStatus`,
`ca`.`commentStatus` AS `commentStatus` 
from (`course` `c` join `courseattendee` `ca` on((`c`.`courseID` = `ca`.`courseId`)));

