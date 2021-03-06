CREATE TABLE USERS(
ID NUMBER,
CONSTRAINT USERS_PK PRIMARY KEY(ID),
NAME NVARCHAR2(50),
PASSWORD NVARCHAR2(50),
COUNTRY NVARCHAR2(50),
USER_TYPE NVARCHAR2(6) NOT NULL CHECK (USER_TYPE = 'USER' OR USER_TYPE = 'ADMIN')
);

CREATE SEQUENCE USER_SEQ START WITH 1 INCREMENT BY 1;
