# Altice Labs Technical Exercise

## Description

Implement a REST service, using a JAVAframework, returning a value from the **labseq** sequence.
Optionally implement a simple JavaScript2 web GUI to invoke the service.

The **labseq – l(n)** - sequence is defined as follows:

- n=0 => l(0) = 0
- n=1 => l(1) = 1
- n=2 => l(2) = 0
- n=3 => l(3) = 1
- n>3 => l(n) = l(n-4) + l(n-3)

Example of the first sequence values:

0<br>
1<br>
0<br>
1<br>
1<br>
1<br>
1<br>
2<br>
2<br>
2<br>
3<br>
[…]

The endpoint created should be in the form `<baseurl>/labseq/{n} where {n}` represents the index of the sequence’s (**single**) value to return. The index may be **any** non-negative integer number.

The implemented service should use a caching mechanism to take advantage of previous calculations to speed up future calculations. This caching mechanism must be used in the algorithm’s intermediate calculations (if applicable), and not only in the endpoint’s invocations.

The answer must include:
- Source code
- REST API documentation – Open API format (Swagger)
- Execution instructions (containers or other)

Java code development best practices will be considered in the evaluation of the proposed resolution. Calculation performance is also a plus - calculation of l(10000) must be correctly returned under 10s.

If there are any doubts regarding specific issues of the exercise that may influence its implementation, the applicant must make assumptions and implement the exercise according to them (these assumptions should be included in the answer).

## Tech Stack

JDK 17
Spring Boot 3.2.5
Angular 15.0.5
JUnit 5.10.2
Docker 26.0.0

## Run Locally

To **run the application locally**, execute both the front-end (SPA application) and back-end (Restful API).

### Restful API

In the `backend` folder, run the command `mvn install` to build the application.
This command also prepares the application for the containerization.

In the `backend/target` folder, execute the command `java -jar labseq.jar` to run the API on port `8080`.

### Single Page Application

In the `frontend` folder, execute the command `ng serve --open` to run the application.

## Containerization

### Docker

A `Dockerfile` was created for each application part - back-end and front-end. 

### API Documentation

The Restful API has been documented following the Open API
standard. The Swagger was employed for such documentation.
It is available at [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/).
