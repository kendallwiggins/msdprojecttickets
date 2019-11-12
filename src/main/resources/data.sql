insert into CUSTOMERS (CUSTOMER_NAME, EMAIL, PASSWORD) VALUES ('Bruce', 'bruce@a.com', 'pass');
insert into CUSTOMERS (CUSTOMER_NAME, EMAIL, PASSWORD) VALUES ('Jane', 'jane@b.com', 'abcpass');
insert into CUSTOMERS (CUSTOMER_NAME, EMAIL, PASSWORD) VALUES ('Rick', 'rick@bah.com', '123pass');

insert into EVENTS (EVENT_CODE, TITLE, DESCRIPTION ) VALUES ('CNF001', 'All-Java Conference', 'Lectures and exhibits covering all Java topics' );
insert into EVENTS (EVENT_CODE, TITLE, DESCRIPTION ) VALUES ('WKS002', 'Spring Boot Workshop', 'Hands-on Spring Boot Workshop' );
insert into EVENTS (EVENT_CODE, TITLE, DESCRIPTION ) VALUES ('TRN003', 'Angular Training Course', 'Five day introductory training in Angular' );

insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES ) VALUES ( 1, 1, '2019-01-15 00:00:00.0', 'please email me the event details' );
insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES ) VALUES ( 1, 2, '2019-01-17 00:00:00.0', 'looking for info on local hotels' );
insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES) VALUES ( 1, 3, '2019-01-13 00:00:00.0', 'na' );