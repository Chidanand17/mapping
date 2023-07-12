package com.demomap.mapping.service;

import com.demomap.mapping.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createpost(PostDto postdto);

    List<PostDto> getpost();

    PostDto getpostid(Integer id);

    void deletepost(Integer id);

    PostDto updatepost(PostDto postDto,Integer id );
}
