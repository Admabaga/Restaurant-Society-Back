package com.project.RestaurantSociety.Service;

import com.project.RestaurantSociety.Converter.UserConverter;
import com.project.RestaurantSociety.DTO.UserDTO;
import com.project.RestaurantSociety.Entity.User;
import com.project.RestaurantSociety.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserConverter.dtoToEntity(userDTO);
        fieldValidation(user);
        userRepository.save(user);
        return UserConverter.entityToDto(user);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()){
            throw new RuntimeException(String.format("El usuario con id %s no existe.", userId));
        }
        User user = userOptional.get();
        user.setUserName(userDTO.getUserName());
        user.setUserMail(userDTO.getUserMail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        userRepository.save(user);
        return UserConverter.entityToDto(user);
    }

    public void fieldValidation(User user){
        if (user.getUserMail().isEmpty() || user.getUserMail() == null){
            throw  new RuntimeException("Debes ingresar un email valido.");
        }
        if (user.getUserName().isEmpty() || user.getUserName() == null){
            throw new RuntimeException("Debes ingresar un nombre valido.");
        }
        if (user.getPassword().isEmpty() || user.getPassword() == null){
            throw  new RuntimeException("La contraseña no es valida.");
        }
    }
}
