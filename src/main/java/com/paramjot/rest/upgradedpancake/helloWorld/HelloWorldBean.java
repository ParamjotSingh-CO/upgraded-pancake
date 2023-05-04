package com.paramjot.rest.upgradedpancake.helloWorld;

public class HelloWorldBean {
    public String message;

    public HelloWorldBean(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
