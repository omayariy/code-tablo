create TABLE tablo (
    id serial NOT NULL,
    code varchar(255),
    CONSTRAINT pk_codes PRIMARY KEY (id)
);
insert into tablo(id, code)
values(1, 'a0a0');