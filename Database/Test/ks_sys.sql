SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTED_ROLE LIKE '%' || 'ROLE_' || '%';
SELECT * FROM ROLE_TAB_PRIVS WHERE ROLE LIKE '%' || 'ROLE' || '%';
SELECT * FROM ROLE_TAB_PRIVS WHERE