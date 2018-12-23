package com.wuychn.controller;

import com.wuychn.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false, defaultValue = "wuychn") String name) {
        return hiService.hi(name);
    }

}
