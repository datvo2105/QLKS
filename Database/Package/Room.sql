--==========================================================
--==================== ROOM PACKAGE ========================
CREATE OR REPLACE PACKAGE ROOM_PKG IS

    PROCEDURE INSERT_ROOM(
        ROOM_NAME IN VARCHAR2,
        STATUS IN VARCHAR2,
        PRICE IN NUMBER
    );

    PROCEDURE UPDATE_ROOM(
        ROOM_ID_PARAM IN NUMBER,
        ROOM_NAME_PARAM IN VARCHAR2,
        STATUS_PARAM IN VARCHAR2,
        PRICE_PARAM IN NUMBER,
        PUBLIC_KEY_PARAM IN VARCHAR2,
        PRIVATE_KEY_PARAM IN VARCHAR2
    );

    PROCEDURE DELETE_ROOM(
        ROOM_ID_PARAM IN NUMBER
    );
END ROOM_PKG;
/

CREATE OR REPLACE PACKAGE BODY ROOM_PKG IS
 --==========================================================
 --====================CREATE ROOM===========================
    PROCEDURE INSERT_ROOM(
        ROOM_NAME IN VARCHAR2,
        STATUS IN VARCHAR2,
        PRICE IN NUMBER
    ) IS
    BEGIN
        INSERT INTO DEV.ROOM (
            ROOM_NAME,
            STATUS,
            PRICE
        ) VALUES (
            ROOM_NAME,
            STATUS,
            PRICE
        );
        COMMIT;
    END INSERT_ROOM;
 --==========================================================
 --====================UPDATE ROOM===========================
    PROCEDURE UPDATE_ROOM(
        ROOM_ID_PARAM IN NUMBER,
        ROOM_NAME_PARAM IN VARCHAR2,
        STATUS_PARAM IN VARCHAR2,
        PRICE_PARAM IN NUMBER,
        PUBLIC_KEY_PARAM IN VARCHAR2,
        PRIVATE_KEY_PARAM IN VARCHAR2
    ) IS
    BEGIN
        UPDATE DEV.ROOM
        SET
            ROOM_NAME = ROOM_NAME_PARAM,
            STATUS = STATUS_PARAM,
            PRICE = PRICE_PARAM,
            PUBLIC_KEY = PUBLIC_KEY_PARAM,
            PRIVATE_KEY = PRIVATE_KEY_PARAM
        WHERE
            ROOM_ID = ROOM_ID_PARAM;
        COMMIT;
    END UPDATE_ROOM;
 --==========================================================
 --====================DELETE ROOM===========================
    PROCEDURE DELETE_ROOM(
        ROOM_ID_PARAM IN NUMBER
    ) IS
    BEGIN
        DELETE FROM DEV.ROOM
        WHERE
            DEV.ROOM.ROOM_ID= ROOM_ID_PARAM;
        COMMIT;
    END DELETE_ROOM;
END ROOM_PKG;
/

--==========================================================

CREATE OR REPLACE PROCEDURE INSERT_ROOM(
        ROOM_NAME IN VARCHAR2,
        STATUS IN VARCHAR2,
        PRICE IN NUMBER
    ) IS
    BEGIN
        INSERT INTO DEV.ROOM (
            ROOM_NAME,
            STATUS,
            PRICE
        ) VALUES (
            ROOM_NAME,
            STATUS,
            PRICE
        );
        COMMIT;
    END INSERT_ROOM;
    
    CREATE OR REPLACE PROCEDURE UPDATE_ROOM(
        ROOM_ID_PARAM IN NUMBER,
        ROOM_NAME_PARAM IN VARCHAR2,
        STATUS_PARAM IN VARCHAR2,
        PRICE_PARAM IN NUMBER,
        PUBLIC_KEY_PARAM IN VARCHAR2,
        PRIVATE_KEY_PARAM IN VARCHAR2
    ) IS
    BEGIN
        UPDATE DEV.ROOM
        SET
            ROOM_NAME = ROOM_NAME_PARAM,
            STATUS = STATUS_PARAM,
            PRICE = PRICE_PARAM,
            PUBLIC_KEY = PUBLIC_KEY_PARAM,
            PRIVATE_KEY = PRIVATE_KEY_PARAM
        WHERE
            ROOM_ID = ROOM_ID_PARAM;
        COMMIT;
    END UPDATE_ROOM;
    
    CREATE OR REPLACE PROCEDURE DELETE_ROOM(
        ROOM_ID_PARAM IN NUMBER
    ) IS
    BEGIN
        DELETE FROM DEV.ROOM
        WHERE
            DEV.ROOM.ROOM_ID= ROOM_ID_PARAM;
        COMMIT;
    END DELETE_ROOM;