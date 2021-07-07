package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
@Data
public class Account extends BaseEntity {

    @Column(name = "user_name")
    private String username;

    @OneToMany
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private List<Post> posts;

    @OneToMany
    @JsonManagedReference
    @JoinColumn(name = "account_id")
    private List<Comment> comments;
}
