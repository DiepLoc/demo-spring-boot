package com.example.demo.api;

import com.example.demo.model.Account;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accounts;

    @GetMapping
    public List<Account> getAccounts() {
        return accounts.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable("id") Long id) {
        return accounts.findById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPostsOfAccount(@PathVariable("id") Long accountId) {
        return accounts.getPostsByAccountId(accountId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccountById(@PathVariable("id") Long id) {
        accounts.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
