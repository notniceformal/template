package com.nnf.service;

import com.nnf.adapter.AppUserAdapter;
import com.nnf.domain.AppUser;
import com.nnf.dto.AppUserDTO;
import com.nnf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUserAdapter userAdapter;

    public AppUser loadUser(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s);
    }

    public AppUser loadUserByEmail(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    public void saveUser(AppUserDTO dto) {
        userRepository.save(userAdapter.toDo(dto));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
