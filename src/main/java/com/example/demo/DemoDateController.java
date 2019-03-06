package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoDateController {

    @Autowired
    private DemoDateService demoDateService;

    @RequestMapping(value = "/date/submit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String save(@RequestBody List<DemoDate> demoDateList) {
        return "Done";
    }

    @RequestMapping(value="/date/sorted", method=RequestMethod.GET)
    public @ResponseBody List<DemoDate> getSortedList() {
        return demoDateService.sorted();
    }

}
