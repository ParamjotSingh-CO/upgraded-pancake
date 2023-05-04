package com.paramjot.rest.upgradedpancake.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("new world of vast iron");
    }
}
