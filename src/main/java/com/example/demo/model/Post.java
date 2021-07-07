package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "post")
@NoArgsConstructor
public class Post extends BaseEntity {

//    @Column(name = "account_id")
//    private Long accountId;

    @Getter @Setter private String title;
    @Getter @Setter private String content;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @JsonManagedReference
    @Getter private List<Comment> comments;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "account_id")
    @Getter @Setter private Account account;
}
