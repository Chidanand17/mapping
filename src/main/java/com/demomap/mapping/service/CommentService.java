package com.demomap.mapping.service;

import com.demomap.mapping.payload.CommentDto;

import java.util.List;

public interface CommentService {


    CommentDto createcommentbyId(Integer postId, CommentDto commentDto);

    List<CommentDto> getcommentsbyPostid(Integer postid);
}
