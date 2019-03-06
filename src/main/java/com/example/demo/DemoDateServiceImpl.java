package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DemoDateServiceImpl implements DemoDateService {

    @Override
    public void submitDemoDateSet(List<DemoDate> demoDateList) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public List<DemoDate> getSortedDateSet() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
