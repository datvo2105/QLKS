ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

CREATE USER DEV IDENTIFIED BY 1;

GRANT ALL PRIVILEGES TO DEV;

ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YYYY HH24:MI:SS';

MA

//========================================================================================

// TABLE ROOM

//========================================================================================

CREATE TABLE ROOM (
    ROOM_ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ROOM_NAME VARCHAR2(50),
    STATUS VARCHAR2(10) DEFAULT 'Empty' CHECK (STATUS IN ('Booked', 'Empty')),
    PRICE NUMBER,
    PUBLIC_KEY VARCHAR2(4000),
    PRIVATE_KEY VARCHAR2(4000)
);

/

SELECT
    *
FROM
    ROOM;

/

INSERT INTO ROOM (
    ROOM_NAME,
    STATUS,
    PRICE
) VALUES (
    'ROOM 01',
    'Empty',
    10000
);

INSERT INTO ROOM (
    ROOM_NAME,
    STATUS,
    PRICE
) VALUES (
    'ROOM 02',
    'Booked',
    5000
);

/

//========================================================================================

// TABLE BOOKING

//========================================================================================

CREATE TABLE BOOKING (
    BOOKING_ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    BOOKING_NAME VARCHAR2(50),
    BOOKING_ROOM_KEY VARCHAR2(4000) NOT NULL,
    USERNAME VARCHAR(50),
    ROOM_ID NUMBER,
    BOOKING_HOURS NUMBER,
    FOREIGN KEY(ROOM_ID) REFERENCES ROOM(ROOM_ID)
);

/

SELECT
    *
FROM
    BOOKING;

/

INSERT INTO BOOKING (
    BOOKING_NAME,
    BOOKING_ROOM_KEY,
    USERNAME,
    ROOM_ID,
    BOOKING_HOURS
) VALUES (
    'BOOKING 01',
    'KEY',
    'DEV',
    2,
    2
);

/

//========================================================================================

// TABLE RECEIPT

//========================================================================================

CREATE TABLE RECEIPT (
    RECEIPT_ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    CREATED DATE,
    BOOKING_ID NUMBER NOT NULL,
    TOTAL_HOURS NUMBER,
    PAYMENT NUMBER,
    FOREIGN KEY(BOOKING_ID) REFERENCES BOOKING(BOOKING_ID)
);

/

SELECT
    *
FROM
    RECEIPT;

/

INSERT INTO RECEIPT (
    CREATED,
    BOOKING_ID,
    TOTAL_HOURS,
    PAYMENT
) VALUES (
    SYSDATE,
    1,
    2,
    10000
);

/

SELECT
    SYSDATE
FROM
    DUAL //======================================================================================== // TABLE STATISTICAL //======================================================================================== CREATE TABLE STATISTICAL( STATISTICAL_ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    STATISTICAL_NAME VARCHAR(20),
    RECEIPTS NUMBER,
    TOTAL_PAYMENT NUMBER );

/

SELECT
    *
FROM
    STATISTICAL;

/

INSERT INTO STATISTICAL (
    STATISTICAL_NAME,
    RECEIPTS,
    TOTAL_PAYMENT
) VALUES (
    TO_CHAR(SYSDATE, 'MONTH'),
    1,
    10000
);

/

//========================================================================================

SELECT
    *
FROM
    ROOM
WHERE
    ROOM.ROOM_NAME LIKE '%'
                        || ''
                        || '';