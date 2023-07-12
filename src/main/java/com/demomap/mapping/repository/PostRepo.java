package com.demomap.mapping.repository;

import com.demomap.mapping.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Integer> {
}
