package com.demomap.mapping.controller;

import com.demomap.mapping.entity.Comment;
import com.demomap.mapping.payload.CommentDto;
import com.demomap.mapping.service.CommentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping
    @RequestMapping("/posts/{postid}/comments")
    private ResponseEntity<CommentDto> createcomment(@PathVariable("postid") Integer postid,
                                                     @RequestBody CommentDto commentDto){
        CommentDto dto = commentService.createcommentbyId(postid,commentDto);
return  new ResponseEntity<CommentDto>(dto, HttpStatus.CREATED);
    }
    @GetMapping
    @RequestMapping("/posts/comments/{postid}")
    private  ResponseEntity<List<CommentDto>> getcommentbypostid(@PathVariable("postid") Integer postid){
        List<CommentDto> collects = commentService.getcommentsbyPostid(postid);
        return  new  ResponseEntity<>(collects,HttpStatus.OK);
    }



}
