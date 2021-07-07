package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository post;

    public List<Post> findAll() {
        return post.findAll();
    }

    public void deleteById(Long id) {
        post.deleteById(id);
    }

    public Optional<Post> findById(Long id) {
        return post.findById(id);
    }

    public List<Comment> getCommentsByPostId (Long id) {
        Optional<Post> targetPost = findById(id);
        if (targetPost.isPresent()) {
            return targetPost.get().getComments();
        }
        else return null;
    }
}
