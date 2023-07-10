package com.example.tpvendredi_07_07.repository;

import com.example.tpvendredi_07_07.entity.Comment;
import com.example.tpvendredi_07_07.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer> {
    public List<Comment> findByPost (Post post);
}
