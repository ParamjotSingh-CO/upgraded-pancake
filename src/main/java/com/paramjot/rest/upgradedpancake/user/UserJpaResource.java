package com.paramjot.rest.upgradedpancake.user;

import com.paramjot.rest.upgradedpancake.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/jpa")
public class UserJpaResource {

    private UserDAOService service;
    private UserRepository userRepository;

    public UserJpaResource(UserDAOService service, UserRepository userRepository){
        this.service = service;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        Optional<User> foundUser = userRepository.findById(id);

        if(foundUser.isEmpty()){
            throw new UserNotFoundException("id: " + id);
        }

        return foundUser.get();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
