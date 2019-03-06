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
public class DemoDateControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    private DemoDateService service;

    @Autowired
    private DemoDateController demoDateController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(demoDateController).isNotNull();
    }

    @Test
    public void testSubmit() throws Exception {
        String resourceName = "customers.json";
        List<DemoDate> demoDateList = readDemoDatesFromFile(resourceName);
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/date/submit/", demoDateList, String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetSortedList() throws Exception {
        String resourceName = "customers.json";
        List<DemoDate> demoDateList = readDemoDatesFromFile(resourceName);

        when(service.getSortedDateSet()).thenReturn(demoDateList);

        ResponseEntity<List<DemoDate>> responseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/date/sorted/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DemoDate>>(){});
        List<DemoDate> demoDateResultList = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(demoDateList.size(), demoDateResultList.size());
    }

    @Test
    public void testLocalDateFormatFromJson() {
        String value = "2014-05-27T12:30:05-07:00";
        assertEquals(value, ZonedDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME).toString());
    }

    private List<DemoDate> readDemoDatesFromFile(String resourceName) throws java.io.IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        File jsonFile = new File(getClass().getClassLoader().getResource(resourceName).getFile());
        return jsonMapper.readValue(jsonFile, new TypeReference<List<DemoDate>>() {});
    }

}

