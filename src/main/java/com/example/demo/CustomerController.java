package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers/submit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void submit(@RequestBody List<Customer> customerList) {
        customerService.submit(customerList);
    }

    @RequestMapping(value="/customers/sorted", method=RequestMethod.GET)
    public List<Customer> customerSortedList() {
        return customerService.sorted();
    }

}
