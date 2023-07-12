package com.demomap.mapping.repository;

import com.demomap.mapping.entity.Comment;
import com.demomap.mapping.payload.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

    List<Comment> findByPostId( Integer postid);


}
