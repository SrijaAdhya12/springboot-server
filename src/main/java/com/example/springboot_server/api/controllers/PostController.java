package com.example.springboot_server.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_server.api.models.Post;
import com.example.springboot_server.service.PostService;

@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        Optional<List<Post>> posts = postService.find();
        if (posts.isPresent())
            return ResponseEntity.ok(posts.get());
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            return ResponseEntity.ok(post.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newpost = postService.createPost(post);
        return new ResponseEntity<>(newpost, HttpStatus.CREATED);
    }

    @PatchMapping("/posts/{id}")
    public ResponseEntity<Post> editUser(@PathVariable int id, @RequestBody Post post) {
        Optional<Post> editeedPost = postService.editPost(id, post);
        if (editeedPost.isPresent()) {
            return ResponseEntity.ok(editeedPost.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {
        Optional<Post> updatedPost = postService.updateById(id, post);
        if (updatedPost.isPresent()) {
            return ResponseEntity.ok(updatedPost.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Integer id) {
        Optional<Post> deletedPost = postService.deletePost(id);
        if (deletedPost.isPresent()) {
            return ResponseEntity.ok(deletedPost.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/posts")
    public ResponseEntity<String> deleteAllUsers() {
        postService.deleteAllPosts();
        return ResponseEntity.ok("All posts deleted");
    }

}
