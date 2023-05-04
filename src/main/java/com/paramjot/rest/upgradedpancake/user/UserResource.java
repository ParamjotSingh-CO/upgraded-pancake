package com.paramjot.rest.upgradedpancake.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDAOService service;

    public UserResource(UserDAOService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findALL();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User foundUser = service.findOne(id);
        if (foundUser == null){
            throw new UserNotFoundException("id: " + id);
        }

        return foundUser;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
