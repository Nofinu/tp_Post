package com.example.tpvendredi_07_07.repository;

import com.example.tpvendredi_07_07.entity.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like,Integer> {
}
