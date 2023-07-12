package com.demomap.mapping.service.impl;

import com.demomap.mapping.entity.Comment;
import com.demomap.mapping.entity.Post;
import com.demomap.mapping.exception.BlognotFoundException;
import com.demomap.mapping.exception.Resourcenotfound;
import com.demomap.mapping.payload.CommentDto;
import com.demomap.mapping.repository.CommentRepo;
import com.demomap.mapping.repository.PostRepo;
import com.demomap.mapping.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceimpl  implements CommentService {
    @Autowired
     private  CommentRepo commentRepo;
    @Autowired
    private PostRepo postRepo;



    @Override
    public CommentDto createcommentbyId(Integer postId, CommentDto commentDto) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new Resourcenotfound("resource not found with this id" +postId));
        Comment comment = maptoEntity(commentDto);
        comment.setPost(post);
        Comment saved = commentRepo.save(comment);
        CommentDto saveddto = maptoDto(saved);
        return saveddto;
    }

    @Override
    public List<CommentDto> getcommentsbyPostid(Integer postid) {
        List<Comment> byPostId = commentRepo.findByPostId(postid);
        List<CommentDto> collects = byPostId.stream().map((posts) -> maptoDto(posts)).collect(Collectors.toList());
        return collects;
    }

    private  CommentDto maptoDto(Comment comment){
        CommentDto dto= new CommentDto();
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        return dto;
    }
    private  Comment maptoEntity(CommentDto commentDto){
        Comment comment = new Comment();
//        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return  comment;
        
    }

}
