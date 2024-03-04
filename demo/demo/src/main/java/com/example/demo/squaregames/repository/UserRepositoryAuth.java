package com.example.demo.squaregames.repository;

import com.example.demo.squaregames.entity.UserAuth;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryAuth extends CrudRepository<UserAuth, Integer> {

    UserAuth findByUsername(String username);
}
