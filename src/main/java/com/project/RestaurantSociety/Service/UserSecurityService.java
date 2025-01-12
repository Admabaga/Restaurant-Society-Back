package com.project.RestaurantSociety.Service;

import com.project.RestaurantSociety.Entity.User;
import com.project.RestaurantSociety.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(userMail)
                .map(this::convertToUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el userEmail: " + userMail));
    }

    private UserDetails convertToUserDetails(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getUserMail(),
                user.getPassword(),
                user.getAuthorities()
        );
    }
}
