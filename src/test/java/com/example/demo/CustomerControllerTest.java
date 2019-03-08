package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService service;

    @InjectMocks
    private CustomerController customerController = new CustomerController();

    @Test
    public void testRestSerialization() throws Exception {
        List<Customer> customerList = readDemoDatesFromFile("customers.json");
        when(service.sortList(any())).thenReturn(customerList);
        List<Customer> customerResultList = this.customerController.sort(customerList);
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

}

