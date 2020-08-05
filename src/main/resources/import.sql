INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES (1, 'test', 'test', 'test-user', 'test@gmail.com');
INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES (2, 'test1', 'test1', 'test-user1', 'test1@gmail.com');

INSERT INTO QUESTION (ID, WRITER_ID, TITLE, CONTENTS, CREATE_DATE) VALUES (1, 1,   'test-title', 'test-contents', current_timestamp);
INSERT INTO QUESTION (ID, WRITER_ID, TITLE, CONTENTS, CREATE_DATE) VALUES (2, 2,   'test-title1', 'test-contents1', current_timestamp);