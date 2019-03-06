package com.example.demo;

import java.util.List;

public interface DemoDateService {

    void submit(List<DemoDate> demoDateList);

    List<DemoDate> sorted();
}
