# spring-quartz-scheduler

A Spring Boot service that schedules one-off emails using [Quartz Scheduler](https://www.quartz-scheduler.org/), with
jobs persisted in PostgreSQL via Quartz's JDBC job store.

You POST an email (recipient, subject, body, and a target date/time + time zone) to a REST endpoint, and Quartz fires
a job at that moment which sends the email via `JavaMailSender`.

## Tech stack

- Java 25
- Spring Boot 4.1.0 (Web, Data JDBC, Mail, Quartz, Validation)
- Quartz Scheduler with a JDBC (PostgreSQL) job store, so scheduled jobs survive an application restart
- PostgreSQL
- Lombok
- Maven

## Prerequisites

- JDK 25
- A running PostgreSQL instance
- SMTP credentials (e.g. a Gmail account with an app password) if you want emails to actually be sent

## Database setup

Create the database and load the Quartz JDBC job store schema:

```bash
createdb email_scheduler_db
psql -d email_scheduler_db -f extras/quartz_tables_postgres.sql
```

## Configuration

Application config lives in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/email_scheduler_db
spring.datasource.username=postgres
spring.datasource.password=hendi34

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_username
spring.mail.password=your_password

server.port=8081
```

Update the datasource credentials and SMTP settings for your environment before running the app. Quartz's job store
is configured in `src/main/resources/quartz.properties` to use the PostgreSQL JDBC delegate.

## Running the app

```bash
./mvnw spring-boot:run
```

or build and run the jar:

```bash
./mvnw clean package
java -jar target/spring-quartz-scheduler-0.0.1-SNAPSHOT.jar
```

The app starts on `http://localhost:8081`.

## API

### Health check

```
GET /ok
```

Returns `"All OK"` with a `200` status.

### Schedule an email

```
POST /schedule/email
Content-Type: application/json

{
  "email": "recipient@example.com",
  "subject": "Test Subject",
  "body": "Test email body.",
  "dateTime": "2026-08-20T18:47:00",
  "timeZone": "Asia/Jakarta"
}
```

`dateTime` must be in the future relative to `timeZone`, otherwise the API responds with `400 Bad Request`. On
success, it registers a Quartz job/trigger pair and returns:

```json
{
  "success": true,
  "jobId": "9e670029-ecf8-40da-920c-c89df5392827",
  "jobGroup": "email-jobs",
  "message": "Email scheduled successfully"
}
```

A ready-to-use Postman collection is available at `extras/EmailScheduler.postman_collection.json`.

## Testing

```bash
./mvnw test
```

The Spring Boot context test (`SpringQuartzSchedulerApplicationTests`) boots the full application context, including
the datasource and Quartz scheduler, so a reachable PostgreSQL instance with the Quartz schema loaded is required (see
[Database setup](#database-setup)).

## Continuous Integration

GitHub Actions (`.github/workflows/maven.yml`) builds the project on JDK 25 with a `postgres:16` service container,
loading the Quartz schema before running `mvn package` on every push and pull request to `main`.
