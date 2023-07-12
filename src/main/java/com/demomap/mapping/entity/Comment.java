package com.demomap.mapping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    private  String email;
    private  String body;
    @ManyToOne()
    @JoinColumn(name = "post_id")
   private  Post post;

}
