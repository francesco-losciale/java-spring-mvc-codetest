package com.example.demo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoSortingDateController {

    @RequestMapping(value = "date", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<LocalDate> save(@RequestBody DemoDateSet demoDateSet) {
        return Collections.emptyList();
    }
}
