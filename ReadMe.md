
# Spring Boot URL Shortener!

A simple url shortener made in Spring Boot.

## Requirements

For building and running the application you need:

-   [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
-   [Maven 3](https://maven.apache.org/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the  `main`  method in the  `com.ermalferati.urlshortener.UrlShortenerApplication`  class from your IDE.

Alternatively you can use the  [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)  like so:

```
mvn spring-boot:run
```

## Using the application
```
GET - http://localhost:8080/
```
Opens the main page
```
GET - http://localhost:8080/url
```
Shows the list of the shortened websites
```
GET - http://localhost:8080/{url}
```
Redirects to the {url} if it exists in the database, if not it redirects to the error page 