package com.wuychn.client;

import com.wuychn.client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider", configuration = FeignConfig.class, fallback = HiFeignFallback.class)
public interface HiFeignClient {

    // 如果不添加@RequestParam注解，会被转化为POST请求，从而报405
    @GetMapping("/hi")
    String hi(@RequestParam(value = "name") String name);
}

@Component
class HiFeignFallback implements HiFeignClient {

    @Override
    public String hi(String name) {
        return "sorry, " + name + ", please wait..";
    }
}