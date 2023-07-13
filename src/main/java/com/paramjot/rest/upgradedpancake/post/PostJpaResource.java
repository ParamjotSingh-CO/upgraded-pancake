package com.paramjot.rest.upgradedpancake.post;

import com.paramjot.rest.upgradedpancake.jpa.PostRepository;
import com.paramjot.rest.upgradedpancake.jpa.UserRepository;
import com.paramjot.rest.upgradedpancake.user.User;
import com.paramjot.rest.upgradedpancake.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/jpa/")
public class PostJpaResource {
    private PostRepository  postRepository;
    private UserRepository userRepository;

    public PostJpaResource(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/user/{id}/posts")
    public List<Post> getPostByUserPosts(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: "+ id);

        return user.get().getPosts();
    }

    @PostMapping(value ="user/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: "+ id);

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
