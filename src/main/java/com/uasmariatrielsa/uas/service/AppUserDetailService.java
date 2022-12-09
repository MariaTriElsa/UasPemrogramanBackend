/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uasmariatrielsa.uas.service;

import com.uasmariatrielsa.uas.model.AppUserDetail;
import com.uasmariatrielsa.uas.model.User;
import com.uasmariatrielsa.uas.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService{
    
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("Username or password is not correct"));
        return new AppUserDetail(user);
    }
    
}
