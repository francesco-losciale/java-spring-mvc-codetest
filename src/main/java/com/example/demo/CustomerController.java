package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/submit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String submit(@RequestBody List<Customer> customerList) {
        return "Done";
    }

    @RequestMapping(value="/customer/sorted", method=RequestMethod.GET)
    public @ResponseBody List<Customer> customerSortedList() {
        return customerService.sorted();
    }

}
