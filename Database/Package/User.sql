--==========================================================
--==================== USER INFOR PACKAGE ========================
CREATE OR REPLACE PACKAGE USER_PKG IS

    PROCEDURE CREATE_USER(
        P_USERNAME IN VARCHAR2,
        P_PASSWORD IN VARCHAR2,
        P_MAIL IN NVARCHAR2
    );
    
    PROCEDURE CREATE_MANAGER(
        P_USERNAME IN VARCHAR2,
        P_PASSWORD IN VARCHAR2,
        P_MAIL IN NVARCHAR2
    );

    PROCEDURE DELETE_USER (
        P_USERNAME IN VARCHAR2
    );
END USER_PKG;
/

CREATE OR REPLACE PACKAGE BODY USER_PKG IS
 --==========================================================
 --====================CREATE USER===========================
    PROCEDURE CREATE_USER(
        P_USERNAME IN VARCHAR2,
        P_PASSWORD IN VARCHAR2,
        P_MAIL IN NVARCHAR2
    ) IS
    BEGIN
        EXECUTE IMMEDIATE 'CREATE USER ' || P_USERNAME || ' IDENTIFIED BY ' || P_PASSWORD;
        EXECUTE IMMEDIATE 'GRANT ROLE_USER TO ' || P_USERNAME;
        DEV.INSERT_INFOR(P_USERNAME, P_MAIL);
        COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
        -- Handle exceptions if any
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        RAISE;
    END CREATE_USER;
 --==========================================================
 --====================CREATE MANAGER===========================
    PROCEDURE CREATE_MANAGER(
        P_USERNAME IN VARCHAR2,
        P_PASSWORD IN VARCHAR2,
        P_MAIL IN NVARCHAR2
    ) IS
    BEGIN
        EXECUTE IMMEDIATE 'CREATE USER ' || P_USERNAME || ' IDENTIFIED BY ' || P_PASSWORD;
        EXECUTE IMMEDIATE 'GRANT ROLE_MANAGER TO ' || P_USERNAME;
        DEV.INSERT_INFOR(P_USERNAME, P_MAIL);
        COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
        -- Handle exceptions if any
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        RAISE;
    END CREATE_MANAGER;
 --==========================================================
 --====================DELETE ROOM===========================
    PROCEDURE DELETE_USER(
        P_USERNAME IN VARCHAR2
    ) IS
    BEGIN
        EXECUTE IMMEDIATE 'DROP USER ' || P_USERNAME;
        DEV.DELETE_INFOR(P_USERNAME);
        COMMIT;
    END DELETE_USER;
END USER_PKG;
/
--==========================================================
SELECT * FROM USER_INFOR;
CALL DEV.USER_PKG.CREATE_USER('USER01', '1', 'vgd@gmail.com');
CALL DEV.USER_PKG.UPDATE_USER(1, 'DEV', 'vgd.learn@gmail.com', '');

SELECT * FROM ALL_USERS;
select * from user_infor;
BEGIN DEV.CREATE_NEW_USER('USER01', '1', 'user@gmail.com'); END;
CALL DEV.DELETE_USER('USER01');
DROP USER USER01;