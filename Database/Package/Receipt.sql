--=============================================================
--==================== RECEIPT PACKAGE ========================
CREATE OR REPLACE PACKAGE RECEIPT_PKG IS

    PROCEDURE INSERT_RECEIPT (
        CREATED_PARAM IN STRING,
        BOOKING_ID IN NUMBER,
        TOTAL_HOURS IN NUMBER,
        PAYMENT IN NUMBER
    );

    PROCEDURE DELETE_RECEIPT (
        RECEIPT_ID_PARAM IN NUMBER
    );
END RECEIPT_PKG;
/

CREATE OR REPLACE PACKAGE BODY RECEIPT_PKG IS
 --==========================================================
 --====================CREATE RECEIPT===========================
    PROCEDURE INSERT_RECEIPT (
        CREATED_PARAM IN STRING,
        BOOKING_ID IN NUMBER,
        TOTAL_HOURS IN NUMBER,
        PAYMENT IN NUMBER
    ) IS
    BEGIN
        INSERT INTO DEV.RECEIPT (
            CREATED,
            BOOKING_ID,
            TOTAL_HOURS,
            PAYMENT
        ) VALUES (
            TO_DATE(CREATED_PARAM, 'HH24:MI:SS dd/MM/yyyy'),
            BOOKING_ID,
            TOTAL_HOURS,
            PAYMENT
        );
        COMMIT;
    END INSERT_RECEIPT;
 --==========================================================
 --====================DELETE RECEIPT===========================
    PROCEDURE DELETE_RECEIPT (
        RECEIPT_ID_PARAM IN NUMBER
    ) IS
    BEGIN
        DELETE FROM DEV.RECEIPT
        WHERE
            DEV.RECEIPT.RECEIPT_ID = RECEIPT_ID_PARAM;
        COMMIT;
    END DELETE_RECEIPT;
END RECEIPT_PKG;
/

--==========================================================