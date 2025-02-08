package com.pain.haven;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/v1")
public class Main {

    @GetMapping("/")
    public List<Map<String, Object>> main() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        System.out.println("test");
        // 나중에 따로 받아야 할 자료들
        return list;
    }

}
