package com.example.demo.api;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService posts;

    @GetMapping
    public List<Post> getPosts() {
        return posts.findAll();
    }

//    @PostMapping
//    public ResponseEntity createPost(@RequestBody Post post) {
//        return ResponseEntity.ok().body((post));
//    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable("id") Long id) {
        return posts.findById(id);
    }

    @GetMapping("/{id}/comments")
    public List<Comment> getCommentsOfPost(@PathVariable("id") Long postId) {
        return posts.getCommentsByPostId(postId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCommentById(@PathVariable("id") Long id) {
        posts.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
