package com.example.api_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_gateway.service.ProxyService;

@RestController 
public class GatewayController {

    private final ProxyService proxyService;

    public  GatewayController(ProxyService proxyService){
        this.proxyService = proxyService;
    }

     @GetMapping("/api/users/{id}")
    public String getUser(@PathVariable Long id)
            throws Exception {

        return proxyService.forwardRequest("/users/" + id);
    }

}
