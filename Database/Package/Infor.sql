--==========================================================
--==================== USER INFOR PACKAGE ========================
CREATE OR REPLACE PACKAGE INFOR_PKG IS

    PROCEDURE INSERT_USER(
        USERNAME IN VARCHAR2,
        MAIL IN NVARCHAR2
    );

    PROCEDURE UPDATE_USER(
        USER_ID_PARAM IN NUMBER,
        USERNAME_PARAM IN VARCHAR2,
        MAIL_PARAM IN NVARCHAR2,
        MAIL_PASSWORD_PARAM IN NVARCHAR2,
        USER_KEY_PARAM IN NVARCHAR2
    );

    PROCEDURE DELETE_USER (
        USERNAME_PARAM IN VARCHAR2
    );
END INFOR_PKG;
/

CREATE OR REPLACE PACKAGE BODY INFOR_PKG IS
 --==========================================================
 --====================CREATE USER===========================
    PROCEDURE INSERT_USER(
        USERNAME IN VARCHAR2,
        MAIL IN NVARCHAR2
    ) IS
    BEGIN
        INSERT INTO DEV.USER_INFOR (
            USERNAME,
            MAIL
        ) VALUES (
            USERNAME,
            MAIL
        );
        COMMIT;
    END INSERT_USER;
 --==========================================================
 --====================UPDATE ROOM===========================
    PROCEDURE UPDATE_USER(
        USER_ID_PARAM IN NUMBER,
        USERNAME_PARAM IN VARCHAR2,
        MAIL_PARAM IN NVARCHAR2,
        MAIL_PASSWORD_PARAM IN NVARCHAR2,
                USER_KEY_PARAM IN NVARCHAR2

    ) IS
    BEGIN
        UPDATE DEV.USER_INFOR
        SET
            USERNAME = USERNAME_PARAM,
            MAIL = MAIL_PARAM,
            MAIL_PASSWORD= MAIL_PASSWORD_PARAM,
            USER_KEY = USER_KEY_PARAM
        WHERE
            USER_ID = USER_ID_PARAM;
        COMMIT;
    END UPDATE_USER;
 --==========================================================
 --====================DELETE ROOM===========================
    PROCEDURE DELETE_USER(
        USERNAME_PARAM IN VARCHAR2
    ) IS
    BEGIN
        DELETE FROM DEV.USER_INFOR
        WHERE
            DEV.USER_INFOR.USERNAME = USERNAME_PARAM;
        COMMIT;
    END DELETE_USER;
END INFOR_PKG;
/
--==========================================================
SELECT * FROM USER_INFOR;
CALL DEV.USER_PKG.INSERT_USER('DEV', 'vgd.learn@gmail.com');
CALL DEV.INFOR_PKG.UPDATE_USER(1, 'DEV', 'vgd@gmail.com', '', '');
DROP PROCEDURE CREATE_USER;
--==========================================================
 --====================CREATE USER===========================
    CREATE OR REPLACE PROCEDURE INSERT_INFOR(
        USERNAME IN VARCHAR2,
        MAIL IN NVARCHAR2
    ) IS
    BEGIN
        INSERT INTO DEV.USER_INFOR (
            USERNAME,
            MAIL
        ) VALUES (
            USERNAME,
            MAIL
        );
        COMMIT;
    END INSERT_INFOR;
 --==========================================================
 --====================UPDATE USER===========================
    CREATE OR REPLACE PROCEDURE UPDATE_INFOR(
        USER_ID_PARAM IN NUMBER,
        USERNAME_PARAM IN VARCHAR2,
        MAIL_PARAM IN NVARCHAR2,
        MAIL_PASSWORD_PARAM IN NVARCHAR2,
                USER_KEY_PARAM IN NVARCHAR2

    ) IS
    BEGIN
        UPDATE DEV.USER_INFOR
        SET
            USERNAME = USERNAME_PARAM,
            MAIL = MAIL_PARAM,
            MAIL_PASSWORD= MAIL_PASSWORD_PARAM,
            USER_KEY = USER_KEY_PARAM
        WHERE
            USER_ID = USER_ID_PARAM;
        COMMIT;
    END UPDATE_INFOR;
 --==========================================================
 --====================DELETE USER===========================
    CREATE OR REPLACE PROCEDURE DELETE_INFOR(
        USERNAME_PARAM IN VARCHAR2
    ) IS
    BEGIN
        DELETE FROM DEV.USER_INFOR
        WHERE
            DEV.USER_INFOR.USERNAME = USERNAME_PARAM;
        COMMIT;
    END DELETE_INFOR;