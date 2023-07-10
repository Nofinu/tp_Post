package com.example.tpvendredi_07_07.dto.Comment;

import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentDtoService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment findById(int id) throws NotFounfException {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            return comment.get();
        }
        throw new NotFounfException();
    }
}
