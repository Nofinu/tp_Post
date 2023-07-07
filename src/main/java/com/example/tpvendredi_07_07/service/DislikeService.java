package com.example.tpvendredi_07_07.service;

import com.example.tpvendredi_07_07.dto.Dislike.DIslikeDtoToDIslike;
import com.example.tpvendredi_07_07.dto.Dislike.DislikeCreateDto;
import com.example.tpvendredi_07_07.entity.Dislike;
import com.example.tpvendredi_07_07.exception.NotFounfException;
import com.example.tpvendredi_07_07.repository.DislikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DislikeService {
    @Autowired
    private DislikeRepository dislikeRepository;

    @Autowired
    private DIslikeDtoToDIslike dIslikeDtoToDIslike;

    public Dislike create (DislikeCreateDto dislikeCreateDto) throws NotFounfException {
        Dislike dislike = dIslikeDtoToDIslike.convert(dislikeCreateDto);
        return dislikeRepository.save(dislike);
    }

}
