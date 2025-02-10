package com.leonard.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String name, String phrase) {
        String greeting = String.format("Hello %s, %s", name, phrase);
        return greeting;
    }

    @Override
    public String sayHelloError(String name, String phrase) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sayHelloError'");
    }

}
