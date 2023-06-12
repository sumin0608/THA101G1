create table trainer_cert
(
    number            int default 0 not null,
    cert_name         varchar(20)   not null,
    english_cert_name varchar(50)   null,
    abbr_name         varchar(20)   null
);

INSERT INTO THA101G1.trainer_cert (number, cert_name, english_cert_name, abbr_name) VALUES (0, '籃球教練', 'basketball coach', 'b_license');
