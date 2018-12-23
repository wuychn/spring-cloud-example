package com.wuychn.service;

import com.wuychn.client.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloFeignClient helloFeignClient;

    public String hello(String name) {
        return helloFeignClient.hello(name);
    }
}
