package com.wuychn.service;

import com.wuychn.client.HiFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    @Autowired
    private HiFeignClient hiFeignClient;

    public String hi(String name) {
        return hiFeignClient.hi(name);
    }
}
