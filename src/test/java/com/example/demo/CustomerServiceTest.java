package com.example.demo;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

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
    public void testSortingIsWorking() throws Exception {

    }
}
