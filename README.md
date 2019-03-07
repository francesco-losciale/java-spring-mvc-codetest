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

You can find the JMeter Test Plan file. 

# Considerations

1. Controller testing: Spring container is used testing the controller for the sake of simplicity but a more performant solution such as http://www.mock-server.com/ would be better. Ultimately what we want to test in it is the spring paramters serialization/deserialization. 

2. Sorting Service testing: the sorting is tested in the service unit test only
