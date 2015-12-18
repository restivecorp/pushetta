insert into user (id, name, token) values (999, 'Dummy', '1234567890qwertyuiopasdfghjklzxcvbnm');

insert into notification (user_id, creationDate, scheduleDate, text, status, trySend) values (999, curdate(), curdate(), "Sample text - Notification pending to send", null, null);
insert into notification (user_id, creationDate, scheduleDate, text, status, trySend) values (999, curdate(), curdate(), "Sample text - Notification sent width error", "ERROR: xxxxxx", curdate());
insert into notification (user_id, creationDate, scheduleDate, text, status, trySend) values (999, curdate(), curdate(), "Sample text - Notification pending to send", "SENT", curdate());
