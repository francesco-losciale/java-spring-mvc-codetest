package com.example.demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoSortingDateController {

    @Autowired
    private DemoDateService demoDateService;

    @RequestMapping(value = "/date/submit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String save(@RequestBody DemoDateSet demoDateSet) {
        return "Done";
    }

    @RequestMapping(value="/date/sorted", method=RequestMethod.GET)
    public @ResponseBody List<DemoDate> getSortedList() {
        return demoDateService.getSortedDateSet();
    }

//    @RequestMapping(value="/date/sorted", method=RequestMethod.GET)
//    public @ResponseBody DemoDate[] getSortedList() {
//        return new DemoDate[1];
//    }

}
