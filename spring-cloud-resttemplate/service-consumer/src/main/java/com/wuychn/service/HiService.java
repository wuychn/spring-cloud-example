package com.wuychn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HiService {

    @Autowired
    private RestTemplate restTemplate;

    public String hi(String name) {
        return restTemplate.getForObject("http://service-provider/hi?name=" + name, String.class);
    }
}
