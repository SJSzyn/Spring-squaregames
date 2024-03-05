package com.example.demo.squaregames.repository;

import com.example.demo.squaregames.entity.UserAuth;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepositoryAuth extends CrudRepository<UserAuth, Integer> {

    Optional<UserAuth> findByUsername(String username);
}
