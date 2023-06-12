create table porder
(
    id          int auto_increment
        primary key,
    porderNo    varchar(45) null,
    memberNo    varchar(45) null,
    name        varchar(45) null,
    productName varchar(45) null,
    pamount     varchar(45) null,
    pdate       datetime    null,
    phone       varchar(45) null,
    email       varchar(45) null
);

INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (7, '1', '1', 'John', 'Product A', '100', '2023-06-01 09:00:00', '1234567890', 'john@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (8, 'PO002', 'M002', 'Jane', 'Product B', '200', '2023-06-02 10:30:00', '9876543210', 'jane@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (9, 'PO003', 'M003', 'Mike', 'Product C', '150', '2023-06-03 14:45:00', '4567890123', 'mike@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (10, 'PO004', 'M004', 'Emily', 'Product A', '100', '2023-06-04 11:15:00', '7890123456', 'emily@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (11, 'PO005', 'M005', 'David', 'Product B', '200', '2023-06-05 16:20:00', '0123456789', 'david@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (12, 'PO006', 'M006', 'Sarah', 'Product C', '150', '2023-06-06 13:30:00', '2345678901', 'sarah@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (13, 'PO007', 'M007', 'Tom', 'Product A', '100', '2023-06-07 17:10:00', '5678901234', 'tom@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (14, 'PO008', 'M008', 'Alice', 'Product B', '200', '2023-06-08 12:45:00', '8901234567', 'alice@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (15, 'PO009', 'M009', 'Chris', 'Product C', '150', '2023-06-09 15:55:00', '9012345678', 'chris@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (16, 'PO010', 'M010', 'Linda', 'Product C', '100', '2023-06-10 18:25:00', '3456789012', 'linda@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (17, 'asdf', 'P001', 'John Doe', '斯伯丁 籃球', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (18, 'p001', 'P001', 'John Doe', '斯伯丁 籃球', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (19, 'p001', 'P001', 'John Doe', '標準版 籃球', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (20, 'p001', 'P001', 'John Doe', '藍色球衣', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (21, 'p001', 'P001', 'John Doe', '喬丹23號球衣', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (22, 's1813', 'P001', 'John Doe', '湖人James球衣', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (23, 'p001', 'P001', 'John Doe', '斯伯丁 籃球', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (24, 'p1233', 'P001', 'John Doe', '斯伯丁 籃球', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (25, 'p001', 'P001', 'John Doe', '斯伯丁 籃球', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (26, 'p001', 'P001', 'John Doe', '標準版 籃球', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (27, 'p001', 'P001', 'John Doe', '藍色球衣', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (28, 'p001', 'P001', 'John Doe', '喬丹23號球衣', '1', '2023-06-08 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (29, '011', 'P001', 'David Johnson', '斯伯丁 籃球', '1', '2023-06-08 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (30, 'p001', 'P001', 'David Johnson', '標準版 籃球', '1', '2023-06-08 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (31, 'p001', 'P001', 'David Johnson', '藍色球衣', '1', '2023-06-08 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (32, 'p001', 'P001', 'David Johnson', '喬丹23號球衣', '1', '2023-06-08 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (33, 'p001', 'P001', 'David Johnson', 'Wade熱火球衣', '1', '2023-06-08 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (34, 'P194087', 'P001', 'John Doe', '藍色球衣', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (35, 'P191127
', 'P001', 'John Doe', 'Wade熱火球衣', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (36, 'P196639', 'P001', 'John Doe', '藍色球衣', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (37, 'P191075', 'P001', 'John Doe', '喬丹23號球衣', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (38, 'P191007', 'P001', 'John Doe', '湖人James球衣', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (39, 'P194133', 'P001', 'John Doe', 'Wade熱火球衣', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (40, 'P195300', 'P001', 'John Doe', '限量球鞋', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (41, 'P197122', 'P001', 'John Doe', 'Success 棒球', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (42, 'P194801', 'P001', 'John Doe', 'Success 棒球', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (43, 'P191599', 'P001', 'John Doe', '樂樂棒球', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (44, 'P194208
', 'P001', 'John Doe', '樂樂棒球', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (45, 'P194208
', 'P001', 'John Doe', '樂樂棒球', '1', '2023-06-12 00:00:00', '0900000001', 'email1@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (46, 'P194687
', 'P001', 'David Johnson', '喬丹23號球衣', '1', '2023-06-12 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (47, 'P193668', 'P001', 'David Johnson', '藍色球衣', '1', '2023-06-12 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (48, 'P193327', 'P001', 'David Johnson', '喬丹23號球衣', '1', '2023-06-12 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (49, 'P196446', 'P001', 'David Johnson', '限量球鞋', '1', '2023-06-12 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (50, 'P191873', 'P001', 'David Johnson', 'Wade熱火球衣', '1', '2023-06-12 00:00:00', '0900000005', 'email5@example.com');
INSERT INTO THA101G1.porder (id, porderNo, memberNo, name, productName, pamount, pdate, phone, email) VALUES (51, 'P197389
', 'P001', 'David Johnson', '藍色球衣', '1', '2023-06-12 00:00:00', '0900000005', 'email5@example.com');
