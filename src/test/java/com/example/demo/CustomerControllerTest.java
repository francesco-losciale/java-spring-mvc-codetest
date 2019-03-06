package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
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

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    private CustomerService service;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(customerController).isNotNull();
    }

    @Test
    public void testSubmit() throws Exception {
        String resourceName = "customers.json";
        List<Customer> customerList = readDemoDatesFromFile(resourceName);
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/customers/submit/", customerList, String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetSortedList() throws Exception {
        String resourceName = "customers.json";
        List<Customer> customerList = readDemoDatesFromFile(resourceName);

        when(service.sorted()).thenReturn(customerList);

        ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/customers/sorted/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>(){});
        List<Customer> customerResultList = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(customerList.size(), customerResultList.size());
    }

    @Test
    public void testLocalDateFormatFromJson() {
        String value = "2014-05-27T12:30:05-07:00";
        assertEquals(value, ZonedDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME).toString());
    }

    private List<Customer> readDemoDatesFromFile(String resourceName) throws java.io.IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        File jsonFile = new File(getClass().getClassLoader().getResource(resourceName).getFile());
        return jsonMapper.readValue(jsonFile, new TypeReference<List<Customer>>() {});
    }

}

