# Qudini Backend Software Engineer Code Test

# Instructions

For running the testsuite 

```
mvn clean test
```

For running the server

```
mvn spring:boot
```

Here the [JMeter Test Plan file](https://github.com/francesco-losciale/java-spring-mvc-codetest/blob/master/Jmeter.Test.Plan.jmx) and the [curl commands for manual testing](https://github.com/francesco-losciale/java-spring-mvc-codetest/blob/master/manual_test_commands.txt). 

# Considerations

1. Created an end-to-end (integration) test and two unit tests (controller and service)

2. Current performance in warmed up state: 4s for 400 users

4. TODO : 
- add packaging for classes
- create builder for customers & testing
- test some negative scenario ie. internal_server_error etc
- integration test must be separate by unit tests
