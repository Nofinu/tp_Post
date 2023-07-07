package com.example.tpvendredi_07_07.repository;

import com.example.tpvendredi_07_07.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByUsername (String Username);
}
