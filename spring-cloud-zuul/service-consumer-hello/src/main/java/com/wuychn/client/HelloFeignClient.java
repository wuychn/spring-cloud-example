package com.wuychn.client;

import com.wuychn.client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider", configuration = FeignConfig.class, fallback = HelloFeignFallback.class)
public interface HelloFeignClient {

    // 如果不添加@RequestParam注解，会被转化为POST请求，从而报405
    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);
}

@Component
class HelloFeignFallback implements HelloFeignClient {

    @Override
    public String hello(String name) {
        return "sorry, " + name + ", please wait..";
    }
}