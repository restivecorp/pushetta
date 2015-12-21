# Schedule Notificator System with Pushetta

This is a small project to implement and test a lot of technologies such as:

* Maven
* Spring Framework
* Spring Data
* Spring Data JPA
* Spring Schedule / CRON
* Spring Web / Rest WS
* MySQL
* Hibernate
* JPA
* -- Java Validation
* Rest WS
* Servlets
* JSF 2.0
* Primefaces
* Java Mail
* jUnit
* Spring Test
* Log4j

## Description
Schedule Notificator System with Pushetta is a program that allows for the integration of Java with http://pushetta.com/ and gives it 
additional capacity : save notifications and these will be sent on a given date. The main idea of ​​the project is to make use of the above 
mentioned technologies to create a mini application as a planner.

## How does it work?
The user creates the notification to be sent. For it indicates the text and the date on which you want to send. This information is recorded in 
a database and from that moment the application begins to evaluate from time to time if you have to send notifications or not. When found, it 
connects to http://pushetta.com/ and sends the message.

The notifications are stored with the corresponding delivery date . Also the failed requests are stored in the system and can be forwarded to 
user request.

## How to configure?

### db.properties
In this file configure the following parameters, the rest may be changed if desired, but not strictly necessary

* jdbc.username = USER_NAME (to connect with the database)
* jdbc.password = PASSWORD (to connect)
* jdbc.url = jdbc:mysql://HOST:PORT/DATABASE_NAME (replace HOST, PORT and DATABASE_NAME by appropiate)

### cron.properties
* cron.send.notifications = Change cron expression to fits your needs. Help in http://www.cronmaker.com/

###  pushetta.properties
In this file configure the following parameters, the rest may be changed if desired, but not strictly necessary

 * pushetta.user.token = TOKEN (from http://pushetta.com/ user account)
 * pushetta.user.channel = CHANNEL_NAME (to notify)
 * pushetta.cfg.enable = true

## How to run?
1. Clone the repository
2. Create the database and the user needed to access
3. Create the table with ddl (src/ddl/01.createTables.sql)
4. Configure *.properties file
5. Execute mvn jetty:run or deploy in container
6. The application runs
7. Go to http://localhost:8080/pushetta to view control panel
8. Manage Users
9. Create Notifications
10. Send rest requests
11. Let the application do its job. You will be notified at the time

## The API rest
The base URL might be something like http://localhost:8080/pushetta then:

* POST: /rest/notify/create (body example >> {"text":"Dumy text", "scheduleDate":"2015-12-01"}) // require Auth http header with user token
* POST: /rest/notify/createSend (body example >> {"text":"Dumy text", "scheduleDate":"2015-12-01"}) // require Auth hhtp header with user token
* GET:  /rest/notify/get/{id}
* GET:  /rest/notify/by/{status} (valid params >> PENDING | SENT | ERROR | ALL)
* GET:  /rest/notify/delete/{id}
* GET:  /rest/notify/send/{kind} (valid kinds >> PENDING | ERROR )

