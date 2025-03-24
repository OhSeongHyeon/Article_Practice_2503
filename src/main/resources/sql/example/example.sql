CREATE TABLE EXAMPLE_TABLE (
                               ID NUMBER PRIMARY KEY
    ,   NAME VARCHAR2(128) NOT NULL
    ,   DESCRIPTION VARCHAR2(1000)
    ,   CAMEL_CASE VARCHAR2(64)
    ,   REG_DATE DATE NOT NULL
);


INSERT INTO EXAMPLE_TABLE (ID, NAME, DESCRIPTION, CAMEL_CASE, REG_DATE) VALUES
    (1, 'Sample Name 1', 'This is a description for sample 1.', 'camelCaseValue1', TO_DATE('2024-03-24', 'YYYY-MM-DD'));

INSERT INTO EXAMPLE_TABLE (ID, NAME, DESCRIPTION, CAMEL_CASE, REG_DATE) VALUES
    (2, 'Sample Name 2', 'This is a description for sample 2.', 'camelCaseValue2', TO_DATE('2024-03-23', 'YYYY-MM-DD'));

INSERT INTO EXAMPLE_TABLE (ID, NAME, DESCRIPTION, CAMEL_CASE, REG_DATE) VALUES
    (3, 'Sample Name 3', 'This is a description for sample 3.', 'camelCaseValue3', TO_DATE('2024-03-22', 'YYYY-MM-DD'));

INSERT INTO EXAMPLE_TABLE (ID, NAME, DESCRIPTION, CAMEL_CASE, REG_DATE) VALUES
    (4, 'Sample Name 4', 'This is a description for sample 4.', 'camelCaseValue4', TO_DATE('2024-03-21', 'YYYY-MM-DD'));

INSERT INTO EXAMPLE_TABLE (ID, NAME, DESCRIPTION, CAMEL_CASE, REG_DATE) VALUES
    (5, 'Sample Name 5', 'This is a description for sample 5.', 'camelCaseValue5', TO_DATE('2024-03-20', 'YYYY-MM-DD'));

SELECT * FROM EXAMPLE_TABLE;
