package com.paramjot.rest.upgradedpancake.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonEndpoint {

    @GetMapping(path = "/v1/person")
    public Person getPersonBYURLVersioning(){
        return new Person("Charlie Bose");
    }

    @GetMapping(path = "/v2/person")
    public NewPerson getNewPersonByURLVersioning(){
        return new NewPerson("Issac", "Newton");
    }

    @GetMapping(path = "/person", params = "version=1")
    public Person getPersonByRequestParameterVersioning(){
        return new Person("Charlie Bose");
    }

    @GetMapping(path = "/person", params = "version=2")
    public NewPerson getNewPersonByRequestParameterVersioning(){
        return new NewPerson("Issac", "Newton");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public Person getPersonByRequestHeaderVersioning(){
        return new Person("Charlie Bose");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public NewPerson getNewPersonByRequestHeaderVersioning(){
        return new NewPerson("Issac", "Newton");
    }

    @GetMapping(path = "/person", produces = "application/test.app-v1+json")
    public Person getPersonByRequestAcceptHeaderVersioning(){
        return new Person("Charlie Bose");
    }

    @GetMapping(path = "/person", produces = "application/test.app-v2+json")
    public NewPerson getNewPersonByRequestAcceptHeaderVersioning(){
        return new NewPerson("Issac", "Newton");
    }
}
