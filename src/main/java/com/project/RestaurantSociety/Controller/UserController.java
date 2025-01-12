package com.project.RestaurantSociety.Controller;

import com.project.RestaurantSociety.DTO.LoginRequest;
import com.project.RestaurantSociety.DTO.LoginResponse;
import com.project.RestaurantSociety.DTO.UserDTO;
import com.project.RestaurantSociety.Entity.User;
import com.project.RestaurantSociety.Repository.UserRepository;
import com.project.RestaurantSociety.SecurityConfig.JwtUtil;
import com.project.RestaurantSociety.Service.UserSecurityService;
import com.project.RestaurantSociety.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserSecurityService userSecurityService;
    @Autowired
    private JwtUtil jwtUtil;
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @PutMapping("/users/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO){
        return  userService.updateUser(userId, userDTO);
    }

    @PostMapping("/users/logins")
    public ResponseEntity<?> login(@RequestBody LoginRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserMail(), authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Usuario y/o contraseña inválidos."));
        }
        final UserDetails userDetails = userSecurityService.loadUserByUsername(authenticationRequest.getUserMail());
        User user = userRepository.getUserByEmail(authenticationRequest.getUserMail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el email: " + authenticationRequest.getUserMail()));
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(jwt, user.getUserId()));
    }

}
