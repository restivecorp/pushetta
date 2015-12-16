insert into notification (creationDate, scheduleDate, text, status, trySend) values (curdate(), curdate(), "Sample text - Notification pending to send", null, null);
insert into notification (creationDate, scheduleDate, text, status, trySend) values (curdate(), curdate(), "Sample text - Notification sent width error", "ERROR: xxxxxx", curdate());
insert into notification (creationDate, scheduleDate, text, status, trySend) values (curdate(), curdate(), "Sample text - Notification pending to send", "SENT", curdate());
