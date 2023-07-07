package com.example.tpvendredi_07_07.repository;

import com.example.tpvendredi_07_07.entity.Dislike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DislikeRepository extends CrudRepository<Dislike,Integer> {
}
