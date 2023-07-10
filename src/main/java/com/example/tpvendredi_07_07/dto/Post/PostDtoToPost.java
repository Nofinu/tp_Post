package com.example.tpvendredi_07_07.dto.Post;

import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Post;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostDtoToPost {
    @Autowired
    private PostDtoService postDtoService;

    public Post convert(PostDto postDto) throws NotFounfException {
        Post post = postDto.getId() != null ? postDtoService.findById(postDto.getId()) : new Post();
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        return post;
    }
}
