package com.demomap.mapping.service.impl;

import com.demomap.mapping.entity.Post;
import com.demomap.mapping.exception.Resourcenotfound;
import com.demomap.mapping.payload.PostDto;
import com.demomap.mapping.repository.PostRepo;
import com.demomap.mapping.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceimpl implements PostService {
    @Autowired
    private PostRepo postrepo;
    @Override
    public PostDto createpost(PostDto postdto) {
        Post post = maptoentity(postdto);
        Post saved = postrepo.save(post);
        PostDto postDtos = maptodto(saved);

        return postDtos;
    }

    @Override
    public List<PostDto> getpost() {
        List<Post> all = postrepo.findAll();
        List<PostDto> collect = all.stream().map((post) -> maptodto(post)).collect(Collectors.toList());
        return collect;
    }


    @Override
    public PostDto getpostid(Integer id) {
        Post post = postrepo.findById(id).orElseThrow(() -> new Resourcenotfound("post is not there for this id" +id));
        PostDto getp = maptodto(post);
        return getp;
    }

    @Override
    public void deletepost(Integer id) {
        Post pp = postrepo.findById(id).orElseThrow(() -> new Resourcenotfound("resource not found with id" + id));
        postrepo.deleteById(pp.getId());

    }

    @Override
    public PostDto updatepost(PostDto postDto,Integer id) {
        Post post = postrepo.findById(id).orElseThrow(() -> new Resourcenotfound("post not found with this id" + id));
   //  post.setId(postDto.getId());
     post.setTitle(postDto.getTitle());
     post.setContent(postDto.getContent());
     post.setDiscription(postDto.getDiscription());
        Post save = postrepo.save(post);
        PostDto postdtos = maptodto(save);

        return postdtos;
    }

    private  PostDto maptodto(Post post){
        PostDto postdto =new PostDto();
        postdto.setId(post.getId());
        postdto.setTitle(post.getTitle());
        postdto.setContent(post.getContent());
        postdto.setDiscription(post.getDiscription());
        return postdto;

    }
    private Post maptoentity(PostDto postDto){
        Post post =new Post();
          post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
post.setDiscription(postDto.getDiscription());
return post;
    }
}
