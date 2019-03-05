package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JavaSpringMvcApplicationTests {

    @LocalServerPort
    private int port;

    @MockBean
    private DemoDateService service;

    @Autowired
    private DemoSortingDateController demoSortingDateController;

    @Autowired
    private TestRestTemplate restTemplate;

    // TODO https://spring.io/guides/gs/testing-web/

    @Test
    public void contextLoads() {
        assertThat(demoSortingDateController).isNotNull();
    }

    @Test
    public void testSubmit() {
        DemoDate demoDate = new DemoDate();
        demoDate.setId(1L);
        DemoDateSet demoDateSet = new DemoDateSet();
        demoDateSet.setDates(Arrays.asList(demoDate));
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/date/submit", demoDateSet, String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetSortedList() throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        // TODO fix this filepath
        String jsonFilePath = "/home/ealfors/IdeaProjects/train-katas/java-spring-mvc-codetest/customers.json";
        File jsonFile = new File(jsonFilePath);
        List<DemoDate> demoDateList = jsonMapper.readValue(jsonFile, new TypeReference<List<DemoDate>>() {});


        when(service.getSortedDateSet()).thenReturn(demoDateList);//TODO read date from file

        // https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate
        ResponseEntity<DemoDate[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/date/sorted", DemoDate[].class);
        DemoDate[] demoDates = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertEquals(1, demoDates.length);
        assertEquals(HttpStatus.OK, statusCode);
    }

}

