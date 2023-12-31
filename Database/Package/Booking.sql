--=============================================================
--==================== BOOKING PACKAGE ========================
CREATE OR REPLACE PACKAGE BOOKING_PKG AS

    PROCEDURE INSERT_BOOKING(
        BOOKING_NAME IN VARCHAR2,
        BOOKING_ROOM_KEY IN VARCHAR2,
        USERNAME IN VARCHAR2,
        ROOM_ID IN NUMBER,
        BOOKING_HOURS IN NUMBER
    );

    PROCEDURE UPDATE_BOOKING(
        BOOKING_ID_PARAM IN NUMBER,
        BOOKING_NAME_PARAM IN VARCHAR2,
        BOOKING_ROOM_KEY_PARAM IN VARCHAR2,
        USERNAME_PARAM IN VARCHAR2,
        ROOM_ID_PARAM IN NUMBER,
        BOOKING_HOURS_PARAM IN NUMBER,
        STATUS_PARAM IN VARCHAR2
    );

    PROCEDURE DELETE_BOOKING(
        BOOKING_ID_PARAM IN NUMBER
    );
END BOOKING_PKG;
/

CREATE OR REPLACE PACKAGE BODY BOOKING_PKG AS
 --==========================================================
 --====================CREATE ROOM===========================
    PROCEDURE INSERT_BOOKING (
        BOOKING_NAME IN VARCHAR2,
        BOOKING_ROOM_KEY IN VARCHAR2,
        USERNAME IN VARCHAR2,
        ROOM_ID IN NUMBER,
        BOOKING_HOURS IN NUMBER
    ) IS
    BEGIN
        INSERT INTO DEV.BOOKING (
            BOOKING_NAME,
            BOOKING_ROOM_KEY,
            USERNAME,
            ROOM_ID,
            BOOKING_HOURS
        ) VALUES (
            BOOKING_NAME,
            BOOKING_ROOM_KEY,
            USERNAME,
            ROOM_ID,
            BOOKING_HOURS
        );
        COMMIT;
    END INSERT_BOOKING;
 --==========================================================
 --====================UPDATE ROOM===========================
    PROCEDURE UPDATE_BOOKING(
        BOOKING_ID_PARAM IN NUMBER,
        BOOKING_NAME_PARAM IN VARCHAR2,
        BOOKING_ROOM_KEY_PARAM IN VARCHAR2,
        USERNAME_PARAM IN VARCHAR2,
        ROOM_ID_PARAM IN NUMBER,
         BOOKING_HOURS_PARAM IN NUMBER,
        STATUS_PARAM IN VARCHAR2
    ) IS
    BEGIN
        UPDATE DEV.BOOKING
        SET
            BOOKING_NAME = BOOKING_NAME_PARAM,
            BOOKING_ROOM_KEY = BOOKING_ROOM_KEY_PARAM,
            USERNAME = USERNAME_PARAM,
            ROOM_ID = ROOM_ID_PARAM,
            BOOKING_HOURS = BOOKING_HOURS_PARAM,
            STATUS = STATUS_PARAM
        WHERE
            BOOKING_ID = BOOKING_ID_PARAM;
        COMMIT;
    END UPDATE_BOOKING;
 --==========================================================
 --====================DELETE ROOM===========================
    PROCEDURE DELETE_BOOKING(
        BOOKING_ID_PARAM IN NUMBER
    ) IS
    BEGIN
        DELETE FROM DEV.BOOKING
        WHERE
            DEV.BOOKING.BOOKING_ID = BOOKING_ID_PARAM;
        COMMIT;
    END DELETE_BOOKING;
END BOOKING_PKG;
/

--==========================================================
SELECT
    *
FROM
    ROOM;

SELECT
    *
FROM
    BOOKING;

CALL BOOKING_PKG.INSERT_BOOKING('Booking 02', 'test', 'DEV', 2, 2.5);

CALL BOOKING_PKG.UPDATE_BOOKING(21, 'BOOKING 02', 'test', 'DEV', 2, 2.5);


 --==========================================================
 --====================CREATE ROOM===========================
CREATE OR REPLACE PROCEDURE INSERT_BOOKING (
        BOOKING_NAME IN VARCHAR2,
        BOOKING_ROOM_KEY IN VARCHAR2,
        USERNAME IN VARCHAR2,
        ROOM_ID IN NUMBER,
        BOOKING_HOURS IN NUMBER
    ) IS
    BEGIN
        INSERT INTO DEV.BOOKING (
            BOOKING_NAME,
            BOOKING_ROOM_KEY,
            USERNAME,
            ROOM_ID,
            BOOKING_HOURS
        ) VALUES (
            BOOKING_NAME,
            BOOKING_ROOM_KEY,
            USERNAME,
            ROOM_ID,
            BOOKING_HOURS
        );
        COMMIT;
    END INSERT_BOOKING;
 --==========================================================
 --====================UPDATE ROOM===========================
CREATE OR REPLACE PROCEDURE UPDATE_BOOKING(
        BOOKING_ID_PARAM IN NUMBER,
        BOOKING_NAME_PARAM IN VARCHAR2,
        BOOKING_ROOM_KEY_PARAM IN VARCHAR2,
        USERNAME_PARAM IN VARCHAR2,
        ROOM_ID_PARAM IN NUMBER,
         BOOKING_HOURS_PARAM IN NUMBER,
        STATUS_PARAM IN VARCHAR2
    ) IS
    BEGIN
        UPDATE DEV.BOOKING
        SET
            BOOKING_NAME = BOOKING_NAME_PARAM,
            BOOKING_ROOM_KEY = BOOKING_ROOM_KEY_PARAM,
            USERNAME = USERNAME_PARAM,
            ROOM_ID = ROOM_ID_PARAM,
            BOOKING_HOURS = BOOKING_HOURS_PARAM,
            STATUS = STATUS_PARAM
        WHERE
            BOOKING_ID = BOOKING_ID_PARAM;
        COMMIT;
    END UPDATE_BOOKING;
    --==========================================================
 --====================DELETE ROOM===========================
    CREATE OR REPLACE PROCEDURE DELETE_BOOKING(
        BOOKING_ID_PARAM IN NUMBER
    ) IS
    BEGIN
        DELETE FROM DEV.BOOKING
        WHERE
            DEV.BOOKING.BOOKING_ID = BOOKING_ID_PARAM;
        COMMIT;
    END DELETE_BOOKING;