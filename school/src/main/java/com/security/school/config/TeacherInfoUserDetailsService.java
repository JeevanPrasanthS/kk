package com.security.school.config;

import com.security.school.entity.Teacher;
import com.security.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public class TeacherInfoUserDetailsService implements UserDetailsService {

    @Autowired
    TeacherRepository repository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Teacher> userInfo = repository.findByName(name);
        return userInfo.map(TeacherInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + name));
    }
}
