package com.example.bloggingapplication.services.impl;

import com.example.bloggingapplication.entities.User;
import com.example.bloggingapplication.exceptions.ResourceNotFoundException;
import com.example.bloggingapplication.payload.UserDTO;
import com.example.bloggingapplication.repositories.UserRepository;
import com.example.bloggingapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userInfo) {
        User user = userDTOToUser(userInfo);
        userRepository.save(user);
        return userToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO newUserInfo, long userId) {
        User user = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user ","id",userId));
        newUserInfo.setUserId(userId);
        User updatedUser = userDTOToUser(newUserInfo);
        userRepository.save(updatedUser);
        return userToUserDTO(updatedUser);
    }

    @Override
    public UserDTO removeUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user ","id",userId));
        userRepository.deleteById(userId);
        return userToUserDTO(user);
    }

    @Override
    public UserDTO getUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user ","id",userId));
        return userToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> userToUserDTO(user)).collect(Collectors.toList());
    }

    private UserDTO userToUserDTO(User user){
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserId(user.getUserId());
//        userDTO.setUserName(user.getUserName());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setBio(user.getBio());
//        return userDTO;
          UserDTO userDTO = modelMapper.map(user,UserDTO.class);
          return userDTO;
    }

    private User userDTOToUser(UserDTO userDTO){
//        User user = new User();
//        user.setUserId(userDTO.getUserId());
//        user.setUserName(userDTO.getUserName());
//        user.setPassword(userDTO.getPassword());
//        user.setBio(userDTO.getBio());
//        return user;
          User user = modelMapper.map(userDTO,User.class);
          return user;
    }
}
