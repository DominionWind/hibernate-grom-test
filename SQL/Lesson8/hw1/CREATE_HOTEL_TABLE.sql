CREATE TABLE HOTEL(
ID NUMBER,
CONSTRAINT HOTEL_PK PRIMARY KEY (ID),
NAME NVARCHAR2(50),
COUNTRY NVARCHAR2(50),
CITY NVARCHAR2(50),
STREET NVARCHAR2(50)
);

CREATE SEQUENCE HOTEL_SEQ START WITH 1 INCREMENT BY 1;

