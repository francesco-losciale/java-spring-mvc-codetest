package com.example.demo;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> sortList(List<Customer> customerList) {
        Collections.sort(customerList);
        return customerList;
    }
}
