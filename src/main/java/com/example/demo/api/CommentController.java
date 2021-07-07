package com.example.demo.api;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import com.example.demo.system.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService comments;

    @GetMapping
    public List<Comment> getComments(){
        return comments.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Comment> getCommentById(@PathVariable("id") Long id) {
        return comments.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCommentById(@PathVariable("id") Long id) {
        comments.deleteById(id);
        return ResponseEntity.ok().body("success");
    }
}
