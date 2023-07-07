package com.example.tpvendredi_07_07.service.DtoService;

import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Dislike;
import com.example.tpvendredi_07_07.entity.Like;
import com.example.tpvendredi_07_07.entity.User;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.repository.CommentRepository;
import com.example.tpvendredi_07_07.repository.DislikeRepository;
import com.example.tpvendredi_07_07.repository.LikeRepository;
import com.example.tpvendredi_07_07.repository.UserRepository;
import com.example.tpvendredi_07_07.service.CommentService;
import com.example.tpvendredi_07_07.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DtoService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private DislikeRepository dislikeRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    public Like findLikeById(int id) throws NotFounfException {
        Optional<Like> likeOptional = likeRepository.findById(id);
        if(likeOptional.isPresent()){
            return likeOptional.get();
        }
        throw new NotFounfException();
    }

    public Dislike findDislikeById(int id) throws NotFounfException {
        Optional<Dislike> dislikeOptional = dislikeRepository.findById(id);
        if(dislikeOptional.isPresent()){
            return dislikeOptional.get();
        }
        throw new NotFounfException();
    }

    public Comment findComment (int id) throws NotFounfException {
        return commentService.findById(id);
    }

    public User findUser (int id) throws NotFounfException {
        return userService.findById(id);
    }
}
