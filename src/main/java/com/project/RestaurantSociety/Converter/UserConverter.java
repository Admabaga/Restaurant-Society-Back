package com.project.RestaurantSociety.Converter;

import com.project.RestaurantSociety.DTO.UserDTO;
import com.project.RestaurantSociety.Entity.User;

public class UserConverter {

    public static User dtoToEntity(UserDTO userDTO){
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setUserMail(userDTO.getUserMail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return user;
    }

    public static UserDTO entityToDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserMail(user.getUserMail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }
}
