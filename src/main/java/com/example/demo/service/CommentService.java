package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository comment;

    public List<Comment> findAll() {
        return comment.findAll();
    }

    public void deleteById(Long id) {
        comment.deleteById(id);
    }

    public Optional<Comment> findById(Long id) {
        return comment.findById(id);
    }
}
