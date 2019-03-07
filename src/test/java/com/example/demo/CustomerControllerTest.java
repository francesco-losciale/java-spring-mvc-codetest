package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.comparator.Comparators;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Mock
    private CustomerService service;

    @Autowired
    private TestRestTemplate restTemplate;

    @InjectMocks
    @Autowired
    private CustomerController customerController;

    @Test
    public void contextLoads() {
        assertThat(customerController).isNotNull();
    }

    @Test
    public void testRestSerialization() throws Exception {
        List<Customer> customerList = readDemoDatesFromFile("customers.json");
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + this.port + "/customers/sorting", customerList, String.class);

        when(service.sortList(any())).thenReturn(customerList);

        List<Customer> customerResultList = readDemoDatesFromString(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(customerList.size(), customerResultList.size());
    }

    @Test
    public void testDateFormat() {
        String value = "2014-05-27T12:30:05-07:00";
        assertEquals(value, ZonedDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME).toString());
    }

    private List<Customer> readDemoDatesFromFile(String resourceName) throws java.io.IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        File jsonFile = new File(getClass().getClassLoader().getResource(resourceName).getFile());
        return jsonMapper.readValue(jsonFile, new TypeReference<List<Customer>>() {});
    }

    private List<Customer> readDemoDatesFromString(String content) throws java.io.IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.readValue(content, new TypeReference<List<Customer>>() {});
    }
}

