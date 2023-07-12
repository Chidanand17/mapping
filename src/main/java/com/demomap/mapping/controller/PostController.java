package com.demomap.mapping.controller;

import com.demomap.mapping.payload.PostDto;
import com.demomap.mapping.service.PostService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postservice;

    @PostMapping
    private ResponseEntity<PostDto> createpost(@RequestBody PostDto postdto){
        PostDto postDtos = postservice.createpost(postdto);
        return new  ResponseEntity<>(postDtos, HttpStatus.CREATED);

    }

    @GetMapping("/all")
    private  ResponseEntity<List<PostDto>>getpost(){
        List<PostDto> allposts = postservice.getpost();
        return  new ResponseEntity<>(allposts,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private  ResponseEntity<PostDto> getpostid(@PathVariable("id") Integer id){
        PostDto getp = postservice.getpostid(id);
return new  ResponseEntity<>(getp,HttpStatus.OK);
    }

  @DeleteMapping("/{id}")
  private  void delete(@PathVariable("id") Integer id){
         postservice.deletepost(id);

  }

  @PutMapping("/{id}")
    private  ResponseEntity<PostDto> updatepost(@RequestBody PostDto postDto,@PathVariable("id") Integer id){
      PostDto postdtos = postservice.updatepost(postDto, id);
      return new  ResponseEntity<>(postdtos,HttpStatus.OK);

  }

}
