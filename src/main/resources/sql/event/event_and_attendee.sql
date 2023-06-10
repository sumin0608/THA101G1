DROP VIEW IF EXISTS `event_and_attendees`;

CREATE
ALGORITHM = UNDEFINED
    DEFINER = `root`@`localhost`
    SQL SECURITY DEFINER
VIEW `event_and_attendees` AS
SELECT `event`.`eventId`                  AS `eventId`,
       `event`.`creatorId`                AS `creatorId`,
       `event`.`eventName`                AS `eventName`,
       `event`.`price`                    AS `price`,
       `event`.`eventDate`                AS `eventDate`,
       `event`.`startTime`                AS `startTime`,
       `event`.`deadline`                 AS `deadline`,
       `event`.`createDate`               AS `createDate`,
       `event`.`maxAttendees`             AS `maxAttendees`,
       `event`.`description`              AS `description`,
       `event`.`photo`                    AS `photo`,
       `event`.`location`                 AS `location`,
       `event`.`address`                  AS `address`,
       `event`.`addressUrl`               AS `addressUrl`,
       `event`.`addressNickname`          AS `addressNickname`,
       `event`.`city`                     AS `city`,
       `event`.`district`                 AS `district`,
       `event`.`categoryId`               AS `categoryId`,
       `event`.`currentAttendees`         AS `currentAttendees`,
       `event`.`status`                   AS `status`,
       `event`.`paymentMethod`            AS `paymentMethod`,
       `event_attendees`.`attendId`       AS `attendId`,
       `event_attendees`.`accountId`      AS `accountId`,
       `event_attendees`.`attendTime`     AS `attendTime`,
       `event_attendees`.`attendeeStatus` AS `attendeeStatus`,
       `event_attendees`.`reason`         AS `reason`,
       `event_attendees`.`commentStatus`  AS `commentStatus`
FROM (`event`
    JOIN `event_attendees` ON ((`event`.`eventId` = `event_attendees`.`eventId`)));

SELECT *
FROM THA101G1.event_and_attendees;