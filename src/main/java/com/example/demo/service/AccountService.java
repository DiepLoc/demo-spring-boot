package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository account;

    public List<Account> findAll() {
        return account.findAll();
    }

    public void deleteById(Long id) {
        account.deleteById(id);
    }

    public Optional<Account> findById (Long id) {
        return account.findById(id);
    }

    public List<Post> getPostsByAccountId(Long id) {
        Optional<Account> targetAccount = findById(id);
        if (targetAccount.isEmpty()) return null;
        return targetAccount.get().getPosts();
    }

}
