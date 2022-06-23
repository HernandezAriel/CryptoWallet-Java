package com.bootcamp.G4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import com.bootcamp.G4.model.MyUser;
import com.bootcamp.G4.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser u = ur.findByUsername(username);

        if (u == null)
        {
            throw new UsernameNotFoundException(username);
        }
        else{

            Set<GrantedAuthority> set = new HashSet<>();
            set.add(new SimpleGrantedAuthority(u.getRole().getName()));

           return new User(u.getUsername(), u.getPassword(), set);
        }

    }
}
