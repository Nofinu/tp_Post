package com.example.tpvendredi_07_07.service;

import com.example.tpvendredi_07_07.dto.Dislike.DIslikeDtoToDIslike;
import com.example.tpvendredi_07_07.dto.Dislike.DislikeCreateDto;
import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Dislike;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.repository.DislikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DislikeService {
    @Autowired
    private DislikeRepository dislikeRepository;

    @Autowired
    private DIslikeDtoToDIslike dIslikeDtoToDIslike;
    @Autowired
    private CommentService commentService;

    public Dislike create (DislikeCreateDto dislikeCreateDto) throws NotFounfException {
        Dislike dislike = dIslikeDtoToDIslike.convert(dislikeCreateDto);
        return dislikeRepository.save(dislike);
    }

    public Boolean delete (int id) throws NotFounfException {
        dislikeRepository.delete(findById(id));
        return true;
    }
    public Dislike findById(int id) throws NotFounfException {
        Optional<Dislike> dislike = dislikeRepository.findById(id);
        if(dislike.isPresent()){
            return dislike.get();
        }
        throw new NotFounfException();
    }
    public List<Dislike> findByComment(int idComment) throws NotFounfException {
        Comment comment = commentService.findById(idComment);
        return dislikeRepository.findByComment(comment);
    }

}
