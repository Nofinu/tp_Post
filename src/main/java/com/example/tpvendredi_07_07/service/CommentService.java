package com.example.tpvendredi_07_07.service;

import com.example.tpvendredi_07_07.dto.Comment.CommentDto;
import com.example.tpvendredi_07_07.dto.Comment.CommentDtoToComment;
import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Post;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentDtoToComment commentDtoToComment;
    @Autowired
    private PostService postService;

    public Comment create (CommentDto comment) throws NotFounfException {
        return commentRepository.save(commentDtoToComment.convert(comment));
    }

    public List<Comment> findByPost(int postId) throws NotFounfException {
        Post post = postService.findById(postId);
        return commentRepository.findByPost(post);
    }

    public Comment findById(int id) throws NotFounfException {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            return comment.get();
        }
        throw new NotFounfException();
    }
}
