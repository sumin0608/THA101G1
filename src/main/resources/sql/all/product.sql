create table product
(
    id          int auto_increment
        primary key,
    productNo   varchar(45)   null,
    productName varchar(45)   null,
    picture     varchar(45)   null,
    price       int           null,
    amount      int           null,
    comment     varchar(5000) null
);

INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (3, 'P003', '藍色球衣', 'clothes01.jpg', 1000, 4, '舒爽衣物，球員好物。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (4, 'P004', '喬丹23號球衣', 'clothes02.jpg', 5000, 1, '喬丹聯名球衣，獨家販售。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (5, 'P005', '湖人James球衣', 'clothes03.jpg', 3000, 1, '小皇帝聯名球衣，獨家販售，自有收藏。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (6, 'P006', 'Wade熱火球衣', 'clothes04.jpg', 3000, 1, '閃電俠球衣，熱火隊球迷推薦好物!');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (7, 'P007', '限量球鞋', 'Nike01.jpg', 2000, 1, '限量球鞋，限時販售。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (8, 'P008', '黑色球鞋', 'Nike02.jpg', 2000, 2, '黑色球鞋，氣墊，有彈性。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (9, 'P009', '斯伯丁 2號籃球', 'basketball03.jpg', 400, 4, '斯伯丁新款籃球，室外球。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (10, 'P010', '黑橘色 籃球', 'basketball04.jpg', 200, 1, '斯伯丁黑橘色款籃球。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (11, 'P011', '斯伯丁白色花紋球', 'basketball05.jpg', 300, 1, '斯伯丁特殊花紋造型籃球，室內外用。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (12, 'P012', '室外用籃球', 'basketball06.jpg', 600, 1, '室外用籃球，黃色邊造型。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (13, 'P013', 'Success 棒球', 'base01.jpg', 800, 2, '材質好的棒球，結實質地。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (14, 'P014', '少年棒球鋁棒', 'base02.jpg', 600, 2, '鋁製球棒for少年棒球隊。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (15, 'P015', '樂樂棒球', 'base03.jpg', 200, 1, '好玩樂樂棒球，軟球質。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (16, 'P016', '兒童棒球手套', 'base04.jpg', 300, 1, '兒童棒球手套，好穿戴。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (17, 'P017', '樂樂棒球打擊組', 'base05.jpg', 100, 2, '樂樂棒球for小學教具，體育課實用。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (18, 'P018', '標準手套', 'base06.jpg', 300, 2, '標準手套，球員推薦。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (19, 'P019', '(紅色)球棒01', 'base07.jpg', 500, 3, '球棒紅色的，好握，止滑。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (20, 'P020', '木球棒', 'base08.jpg', 600, 2, '木質球棒，好握，止滑。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (21, 'P021', '黑色籃球金邊', 'basketball07.jpg', 700, 1, '金色邊的黑色籃球，有彈力。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (22, 'P022', '黑白色籃球', 'basketball08.jpg', 600, 1, '黑白色花紋籃球，有彈力。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (23, 'P023', '黃黑色籃球', 'basketball09.jpg', 600, 1, '黃黑色花紋籃球，有彈力。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (24, 'P024', '室內室外兩用籃球', 'basketball10.jpg', 500, 1, '紅色籃球，球質好，好握，室內室外兩用。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (25, 'P025', '藍色籃球', 'basketball11.jpg', 500, 1, '藍色籃球，球質好，好握。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (26, 'P026', '深藍色籃球', 'basketball12.jpg', 600, 1, '深藍色籃球，球質好，好握。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (27, 'P027', '漸層色籃球', 'basketball13.jpg', 500, 1, '漸層色籃球，球質好，好握。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (28, 'P028', '賽爾提克籃球', 'basketball14.jpg', 500, 1, '賽爾提克籃球，NBA授權。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (29, 'P029', '黑色鋁製球棒', 'base09.jpg', 600, 1, '鋁製球棒，打擊教練推薦。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (30, 'P030', '紅色木質球棒', 'base10.jpg', 200, 1, '紅色木質，材質極佳。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (31, 'P031', '多樣式球棒', 'base11.jpg', 500, 1, '多樣式球棒，四種選擇，隨機出貨。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (32, 'P032', '耐用手套', 'base12.jpg', 700, 1, '耐用手套，質地好，耐磨。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (33, 'P033', '棒球護膝', 'base13.jpg', 200, 1, '四種護膝，隨機出貨。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (34, 'P034', '大聯盟用球', 'base14.jpg', 100, 1, '大聯盟用球，彈性係數標準。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (35, 'P035', '棒球襪子', 'base15.jpg', 100, 3, '棒球襪，好穿，好洗。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (36, 'P036', '中職用球', 'base16.jpg', 100, 1, '中職用球，彈性係數標準。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (37, 'P037', '棒球皮帶', 'base17.jpg', 100, 1, '棒球皮帶，質地好，耐髒。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (38, 'P038', '棒球旅行袋', 'base18.jpg', 100, 1, '棒球旅行袋，空間大，裝200顆球。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (39, 'P039', '打擊練習網', 'base19.jpg', 700, 1, '打擊練習網，整套特價，要搶要快。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (40, 'P040', '捕手面具', 'base20.jpg', 200, 1, '捕手面具，材質堅硬。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (41, 'P041', '德甲聯賽足球01', 'soccer01.jpg', 200, 1, '德甲聯賽標準足球。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (42, 'P042', '斯伯丁足球', 'soccer02.jpg', 200, 1, '斯伯丁標準足球，材質耐踢。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (43, 'P043', '德甲足球02', 'soccer03.jpg', 200, 1, '德甲聯賽標準足球。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (44, 'P044', '足球練習組合', 'soccer04.jpg', 500, 1, '唯一一組，足球練習組合。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (45, 'P045', '體育課用足球', 'soccer05.jpg', 800, 1, '中小學體育課用球。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (46, 'P046', '斯伯丁皮足球', 'soccer06.jpg', 200, 1, '皮製光華足球，好用。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (47, 'P047', '攜帶用球門', 'soccer07.jpg', 700, 1, '攜帶用球門。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (48, 'P048', '室內練習球門', 'soccer08.jpg', 200, 1, '室內練習用球門，方便攜帶。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (49, 'P049', '銀色足球', 'soccer09.jpg', 300, 1, '銀色足球，好踢，好玩。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (50, 'P050', '足球員護膝', 'soccer10.jpg', 200, 1, '材質好，保護膝蓋。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (51, 'P051', '足球襪', 'soccer11.jpg', 100, 2, '足球襪，好穿。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (52, 'P052', '練習用足球', 'soccer12.jpg', 100, 2, '球員練習用足球。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (53, 'P053', '黃色足球襪', 'soccer13.jpg', 50, 1, '黃色耐穿足球襪。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (54, 'P054', '藍色足球襪', 'soccer14.jpg', 50, 1, '藍色耐穿足球襪。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (55, 'P055', '紅色足球襪', 'soccer15.jpg', 50, 1, '紅色耐穿足球襪。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (56, 'P056', '玩具足球', 'soccer16.jpg', 100, 1, '供學齡兒童遊戲用玩具足球。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (57, 'P057', '成功牌足球', 'soccer17.jpg', 100, 1, '成功牌足球，好踢。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (58, 'P058', '小小兵樣式足球', 'soccer18.jpg', 100, 1, '小小兵樣式足球。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (59, 'P059', '日式足球', 'soccer19.jpg', 100, 1, '日式足球，日本規格。');
INSERT INTO THA101G1.product (id, productNo, productName, picture, price, amount, comment) VALUES (60, 'P060', '護膝繃帶', 'soccer20.jpg', 100, 1, '條狀繃帶保護膝蓋。');
