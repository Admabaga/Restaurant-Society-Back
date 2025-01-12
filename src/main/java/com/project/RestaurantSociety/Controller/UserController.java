package com.project.RestaurantSociety.Controller;

import com.project.RestaurantSociety.DTO.UserDTO;
import com.project.RestaurantSociety.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @PutMapping("/users/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO){
        return  userService.updateUser(userId, userDTO);
    }

}
