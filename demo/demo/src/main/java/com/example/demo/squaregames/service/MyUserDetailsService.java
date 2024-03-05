package com.example.demo.squaregames.service;

import com.example.demo.squaregames.entity.UserAuth;
import com.example.demo.squaregames.repository.UserRepositoryAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositoryAuth userRepositoryAuth;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepositoryAuth.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Error : No user called: " + username));
    }
}
