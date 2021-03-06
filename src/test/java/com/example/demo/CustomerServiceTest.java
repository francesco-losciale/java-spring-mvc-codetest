package com.example.demo;

import org.junit.Test;

import java.io.File;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerServiceTest {

    private CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Test
    public void testCustomerListSize() {
        List<Customer> expectedCustomerList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("test");
        customer.setDuetime(ZonedDateTime.now());
        customer.setJointime(ZonedDateTime.now());
        expectedCustomerList.add(customer);
        List<Customer> resultList = this.customerService.sortList(expectedCustomerList);
        assertArrayEquals(expectedCustomerList.toArray(), resultList.toArray());
    }

    @Test
    public void testSimpleSorting() throws Exception {
        Customer firstCustomer = new Customer();
        firstCustomer.setId(1L);
        firstCustomer.setName("test");
        firstCustomer.setDuetime(ZonedDateTime.of(2019, 03, 06, 8, 40, 5, 500, ZoneId.systemDefault()));
        firstCustomer.setJointime(ZonedDateTime.of(2019, 03, 06, 8, 40, 5, 500, ZoneId.systemDefault()));

        Customer secondCustomer = new Customer();
        secondCustomer.setId(1L);
        secondCustomer.setName("test");
        secondCustomer.setDuetime(ZonedDateTime.of(2019, 03, 06, 8, 40, 5, 501, ZoneId.systemDefault()));
        secondCustomer.setJointime(ZonedDateTime.of(2019, 03, 06, 8, 40, 5, 501, ZoneId.systemDefault()));

        List<Customer> resultList = this.customerService.sortList(Arrays.asList(secondCustomer, firstCustomer));

        assertEquals(firstCustomer, resultList.get(0));
        assertEquals(secondCustomer, resultList.get(1));
    }

    @Test
    public void testCompleteSorting() throws Exception {
        String resourceName = "customers.json";
        List<Customer> customerList = readDemoDatesFromFile(resourceName);
        List<Customer> resultList = this.customerService.sortList(customerList);

        Collections.sort(customerList);
        assertArrayEquals(customerList.toArray(), resultList.toArray());
    }

    private List<Customer> readDemoDatesFromFile(String resourceName) throws java.io.IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        File jsonFile = new File(getClass().getClassLoader().getResource(resourceName).getFile());
        return jsonMapper.readValue(jsonFile, new TypeReference<List<Customer>>() {});
    }

}
