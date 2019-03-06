package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customerList = new ArrayList<>();

    @Override
    public void submit(List<Customer> customerList) {
        this.customerList.addAll(customerList);
    }

    @Override
    public List<Customer> sorted() {
        Collections.sort(this.customerList);
        return this.customerList;
    }
}
