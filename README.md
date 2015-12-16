# Schedule Notificator System with Pushetta

This is a small project to implement a number of technologies such as:

* Spring Framework
* Spring Data
* Spring Data JPA
* Spring Schedule / CRON
* MySQL
* Hibernate
* JPA
* Java Validation
* Servlets
* JSF 2.0
* ButterFaces
* Boostrap
* Java Mail
* jUnit
* Spring Test
* Log4j

## Description
This project will have a mechanism for integration with http://pushetta.com/. 
Through this project the user will have a table that stores bbdd send notifications, and when the right time comes they will be sent to 
pushetta for notification to the final recipient.

## How does it work?
There is a table in database where the notifications to be sent to Pushetta saved. Such notifications have a planned ship date.

The application has a CRON every so often evaluates how notifications are to be sent and if they meet the conditions they are sent

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
2. Configure *.properties file
2. Execute mvn jetty:run
3. The application runs