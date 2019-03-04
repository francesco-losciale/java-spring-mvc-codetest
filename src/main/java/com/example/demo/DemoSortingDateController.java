package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
public class DemoSortingDateController {

    @RequestMapping(value = "/date/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String save(@RequestBody DemoDateSet demoDateSet) {
        return "Done";
    }

    @RequestMapping("/greeting")
    public @ResponseBody String greeting() {
        return "Thanks for calling";
    }

//    @RequestMapping(value="sorted", method = RequestMethod.GET)
//    public List<DemoDate> sorted() {
//        return Collections.emptyList();
//    }

//    @RequestMapping(value="/Object/getList/", method=RequestMethod.GET)
    @RequestMapping(value="/date/sorted", method=RequestMethod.GET)
    public @ResponseBody List<Object> findAllObjects() {
        return Collections.emptyList();
    }

}
