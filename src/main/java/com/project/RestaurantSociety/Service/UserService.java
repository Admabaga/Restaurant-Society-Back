package com.project.RestaurantSociety.Service;

import com.project.RestaurantSociety.DTO.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long userId, UserDTO userDTO );


}
