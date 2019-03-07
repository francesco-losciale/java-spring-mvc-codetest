package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> sortList(List<Customer> customerList) {
        Customer[] customerArray = customerList.toArray(new Customer[customerList.size()]);
        Arrays.parallelSort(customerArray);
        return Arrays.asList(customerArray);
    }
}
