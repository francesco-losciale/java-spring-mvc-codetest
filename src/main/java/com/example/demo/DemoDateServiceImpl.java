package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DemoDateServiceImpl implements DemoDateService {

    private List<DemoDate> demoDateList = new ArrayList<>();

    @Override
    public void submit(List<DemoDate> demoDateList) {
        this.demoDateList.addAll(demoDateList);
    }

    @Override
    public List<DemoDate> sorted() {
        return this.demoDateList;
    }
}
