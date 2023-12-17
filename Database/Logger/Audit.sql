ALTER SESSION SET NLS_DATE_FORMAT = 'HH24:MI:SS DD/MM/YYYY';
DROP TABLE LOGIN_LOG;
CREATE TABLE LOGIN_LOG (
    USERNAME VARCHAR2(50),
    LOGIN_TIME DATE,
    IP_ADDRESS VARCHAR2(50)
)

CREATE OR REPLACE TRIGGER LOGIN
AFTER LOGON ON DATABASE
DECLARE
    IP_LOGIN VARCHAR2(50);
BEGIN
    IP_LOGIN := SYS_CONTEXT('userenv', 'ip_address');

   
        INSERT INTO LOGIN_LOG (USERNAME, LOGIN_TIME, IP_ADDRESS)
        VALUES (USER, SYSDATE, IP_LOGIN);
END;

SELECT * FROM LOGIN_LOG;