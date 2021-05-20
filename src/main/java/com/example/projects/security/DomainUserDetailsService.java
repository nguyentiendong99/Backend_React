package com.example.projects.security;

import com.example.projects.domain.User;
import com.example.projects.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DomainUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public org.springframework.security.core.userdetails.UserDetails
    loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Could not find user");
        }
        return DomainUserDetails.build(user);
    }
}
