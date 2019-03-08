package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/sort", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public List<Customer> sort(@RequestBody List<Customer> customerList) {
        return customerService.sortList(customerList);
    }

}
