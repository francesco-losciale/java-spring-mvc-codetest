package com.example.demo;

import java.util.List;

public interface DemoDateService {

    void submitDemoDateSet(DemoDateSet demoDateSet);

    List<DemoDate> getSortedDateSet();
}
