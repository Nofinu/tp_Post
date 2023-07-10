package com.example.tpvendredi_07_07.dto.Comment;

import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Dislike;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.service.CommentService;
import com.example.tpvendredi_07_07.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoToComment {
    @Autowired
    private CommentDtoService commentService;
    @Autowired
    private PostService postService;

    public Comment convert(CommentDto commentDto) throws NotFounfException {
        Comment comment = commentDto.getId() != null ? commentService.findById(commentDto.getId()) : new Comment();
        comment.setPost(postService.findById(commentDto.getPost()));
        comment.setMessage(commentDto.getMessage());
        return comment;
    }
}
