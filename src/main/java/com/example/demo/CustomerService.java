package com.example.demo;

import java.util.List;

public interface CustomerService {

    void submit(List<Customer> customerList);

    List<Customer> sorted();
}
