package com.example.bloggingapplication.services;

import com.example.bloggingapplication.payload.UserDTO;
import java.util.*;

public interface UserService {
    UserDTO createUser(UserDTO userInfo);
    UserDTO updateUser(UserDTO newDetails,long userId);
    UserDTO removeUser(long userId);
    UserDTO getUser(long userId);
    List<UserDTO> getAllUsers();

}
