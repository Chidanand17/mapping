package com.demomap.mapping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String title;
    private  String content;
    private  String discription;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();
}
