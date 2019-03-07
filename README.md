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

1. Controller testing: SpringBootTest.WebEnvironment is used for the sake of simplicity but it's not good slowing down the testsuite.
A more light solution such as http://www.mock-server.com/ is better. Ultimately what we want to test in it is the spring paramters serialization/deserialization. 

2. Sorting Service testing: the sorting is tested here only
