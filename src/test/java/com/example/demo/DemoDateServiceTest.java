package com.example.demo;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class DemoDateServiceTest {

    private DemoDateServiceImpl demoDateService = new DemoDateServiceImpl();

    @Test
    public void testSubmitDemoDateList() {
        List<DemoDate> expectedDemoDateList = new ArrayList<>();
        DemoDate demoDate = new DemoDate();
        demoDate.setId(1L);
        demoDate.setName("test");
        demoDate.setDuetime(ZonedDateTime.now());
        demoDate.setJointime(ZonedDateTime.now());
        expectedDemoDateList.add(demoDate);
        demoDateService.submit(expectedDemoDateList);
        assertArrayEquals(expectedDemoDateList.toArray(), demoDateService.sorted().toArray());
    }
}
