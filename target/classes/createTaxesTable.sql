CREATE TABLE SALESTAXES.TAXES
(
  ID_TAX      NUMBER(16)          NOT NULL,
  NAME        VARCHAR2(25 CHAR)   NOT NULL,
  RATE        NUMBER(4,2)         NOT NULL
);
CREATE UNIQUE INDEX SALESTAXES.IDX_TAXES ON SALESTAXES.TAXES (ID_TAX);
ALTER TABLE SALESTAXES.TAXES ADD (CONSTRAINT TAXES_PK PRIMARY KEY (ID_TAX));