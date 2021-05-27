package com.codegym.demo.service.employee_service.impl;

import com.codegym.demo.model.employee.FuramaUser;
import com.codegym.demo.model.employee.FuramaUserRole;
import com.codegym.demo.repository.employee_repository.IFuramaUserRepository;
import com.codegym.demo.repository.employee_repository.IFuramaUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IFuramaUserRepository userRepository;

    @Autowired
    private IFuramaUserRoleRepository userRoleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        FuramaUser user = userRepository.findById(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(" Không tìm thấy " + username);
        }
        FuramaUserRole userRole = userRoleRepository.findByFuramaUser(user);

        List<GrantedAuthority> grandList = new ArrayList<>();
        if (userRole != null) {
            GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getFuramaRole().getRoleName());
            grandList.add(authority);
        }
        UserDetails userDetails = new User(user.getUserName(), user.getPassword(), grandList);

        return userDetails;
    }
}
