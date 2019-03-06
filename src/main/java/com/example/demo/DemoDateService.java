package com.example.demo;

import java.util.List;

public interface DemoDateService {

    void submitDemoDateSet(List<DemoDate> demoDateList);

    List<DemoDate> getSortedDateSet();
}
