CREATE TABLE tablo (
    id serial NOT NULL,
    code varchar(255),
    CONSTRAINT pk_codes PRIMARY KEY (id)
);
INSERT INTO tablo(id, code)
VALUES(1, 'a0a0');