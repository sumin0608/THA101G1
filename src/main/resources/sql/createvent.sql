DROP TABLE IF EXISTS EVENT;
CREATE TABLE `EVENT`
(
    `eventId`          int unsigned NOT NULL AUTO_INCREMENT,
    `creatorId`        int NOT NULL,
    `eventName`        varchar(255) DEFAULT NULL,
    `price`            int          DEFAULT NULL,
    `eventDate`        date         DEFAULT NULL,
    `startTime`        time         DEFAULT NULL,
    `deadline`         datetime     DEFAULT NULL,
    `createDate`       timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `maxAttendees`     int unsigned DEFAULT NULL,
    `description`      text,
    `photo`            longblob,
    `location`         varchar(255) DEFAULT NULL,
    `address`          varchar(255) DEFAULT NULL,
    `city`             varchar(255) DEFAULT NULL,
    `district`         varchar(255) DEFAULT NULL,
    `categoryId`       int unsigned DEFAULT NULL,
    `currentAttendees` int unsigned DEFAULT '0',
    `status`           int          DEFAULT '1',
    `paymentMethod`    int          DEFAULT NULL,
    PRIMARY KEY (`eventId`),
    KEY                `creatorId_idx` (`creatorId`),
    CONSTRAINT `creatorId` FOREIGN KEY (`creatorId`) REFERENCES `account` (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT *
FROM THA101G1.EVENT;