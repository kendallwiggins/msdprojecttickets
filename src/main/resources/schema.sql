

-- ----------------------------------------------
-- DDL Statements for tables
-- ----------------------------------------------

CREATE TABLE CUSTOMERS (
ID INTEGER NOT NULL IDENTITY,
CUSTOMER_NAME VARCHAR(255),
PASSWORD VARCHAR(255),
EMAIL VARCHAR(255));

CREATE TABLE EVENTS (
ID INTEGER NOT NULL IDENTITY, 
EVENT_CODE VARCHAR(255), 
TITLE VARCHAR(255), D
ESCRIPTION VARCHAR(255));

CREATE TABLE REGISTRATIONS (ID INTEGER NOT NULL IDENTITY, 
EVENT_ID INTEGER NOT NULL, 
CUSTOMER_ID INTEGER NOT NULL, 
REGISTRATION_DATE TIMESTAMP, NOTES VARCHAR(255));


-- ----------------------------------------------
-- DDL Statements for keys
-- ----------------------------------------------

-- primary/unique
--ALTER TABLE 'CUSTOMERS' ADD CONSTRAINT 'SQL120325130144011' PRIMARY KEY ('ID');
ALTER TABLE "CUSTOMERS" ADD CONSTRAINT "SQL120325130144011" PRIMARY KEY ("ID");
ALTER TABLE "EVENTS" ADD CONSTRAINT "SQL120325130144012" PRIMARY KEY ("ID");
ALTER TABLE "REGISTRATIONS" ADD CONSTRAINT "SQL120325130144013" PRIMARY KEY ("ID");
