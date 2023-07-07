package com.example.tpvendredi_07_07.service;

import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Post;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post create (Post post){
        return postRepository.save(post);
    }

    public Post findById(int id) throws NotFounfException {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }
        throw new NotFounfException();
    }
}
