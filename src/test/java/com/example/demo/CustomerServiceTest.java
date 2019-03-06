package com.example.demo;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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

        // TODO use order mockito feature
        this.customerService.submit(Arrays.asList(secondCustomer, firstCustomer));
        assertEquals(firstCustomer, this.customerService.sorted().get(0));
        assertEquals(secondCustomer, this.customerService.sorted().get(1));
    }
}
