insert into user (id, name, token) values (1, 'ARDUINO', '049f0f9a1b91f7972f991c38e19da7a00612e7da');
insert into user (id, name, token) values (2, 'RASPBERRY', '31d81448d7855d20baa8f7eb19be7bab27f39a9a');
insert into user (id, name, token) values (3, 'L. Temp', '2cabeb1f776844aa5cdf247a020db75f8eadc846');
insert into user (id, name, token) values (4, 'Testing', 'bb8dee18754ce07d7b828106d7f7b7a25c56ec00');

insert into notification (user_id, creationDate, scheduleDate, text) values (1, curdate(), curdate(), "ARD - Status OK. System enabled");
insert into notification (user_id, creationDate, scheduleDate, text) values (1, curdate(), curdate(), "ARD - Status KO");

insert into notification (user_id, creationDate, scheduleDate, text) values (2, curdate(), curdate(), "Rasp - Status OK. System enabled");
insert into notification (user_id, creationDate, scheduleDate, text) values (2, curdate(), curdate(), "Rasp - Status KO.");
insert into notification (user_id, creationDate, scheduleDate, text) values (2, curdate(), curdate(), "Rasp - Status Reboot.");
insert into notification (user_id, creationDate, scheduleDate, text) values (2, curdate(), curdate(), "Rasp - Status OK. System enabled");

insert into notification (user_id, creationDate, scheduleDate, text) values (3, curdate(), curdate(), "Temp: 19 C");
insert into notification (user_id, creationDate, scheduleDate, text) values (3, curdate(), curdate(), "Temp: 17 C . Cold");
insert into notification (user_id, creationDate, scheduleDate, text) values (3, curdate(), curdate(), "Temp: 22 C");
insert into notification (user_id, creationDate, scheduleDate, text) values (3, curdate(), curdate(), "Temp: 20 C");
insert into notification (user_id, creationDate, scheduleDate, text) values (3, curdate(), curdate(), "Temp: 25 C - HOT");

insert into notification (user_id, creationDate, scheduleDate, text) values (4, curdate(), curdate(), "Sample text");
insert into notification (user_id, creationDate, scheduleDate, text) values (4, curdate(), curdate(), "Another sample text");
insert into notification (user_id, creationDate, scheduleDate, text) values (4, curdate(), curdate(), "Sending a test....");
insert into notification (user_id, creationDate, scheduleDate, text) values (4, curdate(), curdate(), "All is OK");