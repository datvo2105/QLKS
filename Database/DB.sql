ALTER SESSION SET "_ORACLE_SCRIPT" = true;

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
ALTER TABLE ROOM
MODIFY (PUBLIC_KEY VARCHAR2(4000), PRIVATE_KEY VARCHAR2(4000));
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
ALTER TABLE BOOKING
MODIFY (BOOKING_ROOM_KEY VARCHAR2(4000));
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
    DUAL ;
/
//========================================================================================
// TABLE STATISTICAL 
//======================================================================================== 
CREATE TABLE STATISTICAL( STATISTICAL_ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    STATISTICAL_NAME VARCHAR(20),
    RECEIPTS NUMBER,
    TOTAL_PAYMENT NUMBER );

/
SELECT
    *
FROM
    statistical;
/

    INSERT INTO statistical (
        statistical_name,
        receipts,
        total_payment
    ) VALUES (
        to_char(sysdate, 'MONTH'),
        1,
        10000
    );
/

//========================================================================================

/
//========================================================================================
// TABLE USER_INFOR
//======================================================================================== 
CREATE TABLE USER_INFOR ( 
    USER_ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    USERNAME VARCHAR2(20) NOT NULL,
    MAIL NVARCHAR2(100) NOT NULL,
    MAIL_PASSWORD NVARCHAR2(2000)
);
ALTER TABLE USER_INFOR
MODIFY (MAIL_PASSWORD NVARCHAR2(2000));
/



//========================================================================================