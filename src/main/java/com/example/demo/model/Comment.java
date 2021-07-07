package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment extends BaseEntity{

//    @Column(name = "account_id")
//    private Long accountId;
//
//    @Column(name = "post_id")
//    private Long postId;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post post;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "account_id")
    private Account account;

}
