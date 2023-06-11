DROP TABLE IF EXISTS `EVENT`;

create table EVENT
(
    eventId          int unsigned auto_increment
        primary key,
    creatorId        int                                    not null,
    eventName        varchar(255)                           null,
    price            int                                    null,
    eventDate        date                                   null,
    startTime        time                                   null,
    deadline         datetime                               null,
    createDate       timestamp    default CURRENT_TIMESTAMP null,
    maxAttendees     int unsigned                           null,
    description      text                                   null,
    photo            longblob                               null,
    location         varchar(255)                           null,
    address          varchar(255)                           null,
    addressUrl       text                                   null,
    addressNickname  text                                   null,
    city             varchar(255)                           null,
    district         varchar(255)                           null,
    categoryId       int unsigned                           null,
    currentAttendees int unsigned default '0'               null,
    status           int          default 1                 null,
    paymentMethod    int                                    null
);

INSERT INTO THA101G1.EVENT (eventId, creatorId, eventName, price, eventDate, startTime, deadline, createDate, maxAttendees, description, photo, location, address, addressUrl, addressNickname, city, district, categoryId, currentAttendees, status, paymentMethod) VALUES (1, 1, '周末來大安森林公園打打籃球🏀', 0, '2023-06-21', '22:10:00', '2023-06-20 10:55:00', '2023-06-10 00:55:45', 5, '<h1><em>周末來大安森林公園打打籃球8 !!</em></h1>

<p><strong><s><em>要嗎?</em></s></strong></p>

<p>&nbsp;</p>
INSERT INTO THA101G1.EVENT (eventId, creatorId, eventName, price, eventDate, startTime, deadline, createDate, maxAttendees, description, photo, location, address, addressUrl, addressNickname, city, district, categoryId, currentAttendees, status, paymentMethod) VALUES (2, 2, '周末來逛個街8🛒🛍️', 0, '2023-06-22', '15:40:00', '2023-06-10 21:25:00', '2023-06-10 13:17:21', 5, '<p>r rgggr</p>
INSERT INTO THA101G1.EVENT (eventId, creatorId, eventName, price, eventDate, startTime, deadline, createDate, maxAttendees, description, photo, location, address, addressUrl, addressNickname, city, district, categoryId, currentAttendees, status, paymentMethod) VALUES (3, 3, '來打網球🌺🌴🎾', 50, '2023-06-20', '15:00:00', '2023-06-20 06:20:00', '2023-06-10 22:36:09', 4, '<ul>
	<li>
	<h2><cite><big><strong>來</strong><s>打打</s>網球!</big></cite></h2>
	</li>
</ul>

<blockquote>
<ol>
	<li><cite><big>吧!</big></cite></li>
</ol>
</blockquote>

SELECT * FROM THA101G1.EVENT;