package com.productapp.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id="myendpoint")
@Component
public class MyCustomerEndPoint {

    @Bean
    @ReadOperation
    public String hello(){
        return "app is working";
    }
}
