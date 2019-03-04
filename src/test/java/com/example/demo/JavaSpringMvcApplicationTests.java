package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JavaSpringMvcApplicationTests {

    @LocalServerPort
    private int port;

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
    public void testCallIsWorking() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting",
                String.class)).contains("Thanks for calling");
    }

    @Test
    public void testSubmit() {
        DemoDate demoDate = new DemoDate();
        demoDate.setId(1L);
        DemoDateSet demoDateSet = new DemoDateSet();
        demoDateSet.setDates(Arrays.asList(demoDate));
        this.restTemplate.postForEntity("http://localhost:" + port + "/date/save", demoDateSet, String.class);
    }

    @Test
    public void testGetSortedList() {
        // https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate
        ResponseEntity<DemoDate[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/date/sorted", DemoDate[].class);
        DemoDate[] objects = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertEquals(HttpStatus.OK, statusCode);
    }

}

