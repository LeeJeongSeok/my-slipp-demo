INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES (1, 'test', 'test', 'test-user', 'test@gmail.com');
INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES (2, 'test1', 'test1', 'test-user1', 'test1@gmail.com');

INSERT INTO QUESTION (ID, WRITER_ID, TITLE, CONTENTS, CREATE_DATE, COUNT_OF_ANSWER) VALUES (1, 1,   'test-title', 'test-contents', current_timestamp, 0);
INSERT INTO QUESTION (ID, WRITER_ID, TITLE, CONTENTS, CREATE_DATE, COUNT_OF_ANSWER) VALUES (2, 2,   'test-title1', 'test-contents1', current_timestamp, 0);