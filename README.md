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

1. Controller testing: Spring container is used testing the controller for the sake of simplicity but a more performant solution such as http://www.mock-server.com/ would be better. Ultimately what we want to test is the http paramters serialization/deserialization. 

2. Sorting Service testing: the sorting is tested in the service unit test only

3. Current performance in warmed up state: 4s for 400 users

4. TODO add packaging for classes
