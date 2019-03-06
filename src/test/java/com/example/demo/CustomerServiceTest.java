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
    public void testSubmitCustomerList() {
        List<Customer> expectedCustomerList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("test");
        customer.setDuetime(ZonedDateTime.now());
        customer.setJointime(ZonedDateTime.now());
        expectedCustomerList.add(customer);
        this.customerService.submit(expectedCustomerList);
        assertArrayEquals(expectedCustomerList.toArray(), this.customerService.sorted().toArray());
    }

    @Test
    public void testSimpleSortingIsWorking() throws Exception {
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

        this.customerService.submit(Arrays.asList(secondCustomer, firstCustomer));

        assertEquals(firstCustomer, this.customerService.sorted().get(0));
        assertEquals(secondCustomer, this.customerService.sorted().get(1));
    }

    @Test
    public void testHeavySortingIsWorking() throws Exception {
        String resourceName = "customers.json";
        List<Customer> customerList = readDemoDatesFromFile(resourceName);
        this.customerService.submit(customerList);

        Collections.sort(customerList);
        assertArrayEquals(customerList.toArray(), this.customerService.sorted().toArray());
    }

    private List<Customer> readDemoDatesFromFile(String resourceName) throws java.io.IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        File jsonFile = new File(getClass().getClassLoader().getResource(resourceName).getFile());
        return jsonMapper.readValue(jsonFile, new TypeReference<List<Customer>>() {});
    }

}
