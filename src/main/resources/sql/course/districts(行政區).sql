CREATE TABLE `districts` (
  `id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO districts (id, name) VALUES
(800, '中壢區','桃園'),
(801, '平鎮區','桃園'),
(802, '龍潭區','桃園'),
(803, '楊梅區','桃園'),
(804, '新屋區','桃園'),
(805, '觀音區','桃園'),
(806, '桃園區','桃園'),
(807, '龜山區','桃園'),
(808, '八德區','桃園'),
(809, '大溪區','桃園'),
(810, '復興區','桃園'),
(811, '大園區','桃園'),
(812, '蘆竹區','桃園');


SELECT * FROM THA101G1.districts;