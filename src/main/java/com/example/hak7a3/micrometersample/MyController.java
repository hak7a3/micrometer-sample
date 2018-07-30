package com.example.hak7a3.micrometersample;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class MyController {

    private final MyMetrics myMetrics;

    @Autowired
    public MyController(MyMetrics myMetrics) {
        this.myMetrics = myMetrics;
    }

    @RequestMapping("/sample")
    public Map<String, String> sample() {
        myMetrics.countHoge(3);
        myMetrics.countFuga(5);

        return new HashMap<String, String>() {{ put("hoge", "foo"); }};
    }

}