package com.example.bloggingapplication.controllers;

import com.example.bloggingapplication.payload.ApiResponse;
import com.example.bloggingapplication.payload.UserDTO;
import com.example.bloggingapplication.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserDTO> createNewUser(@Valid @RequestBody UserDTO userInfo){
        return new ResponseEntity<>(userService.createUser(userInfo), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO updatedUserInfo, @PathVariable long userId){
        return new ResponseEntity<>(userService.updateUser(updatedUserInfo,userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable long userId){
        UserDTO deletedUser = userService.removeUser(userId);
        ApiResponse response = new ApiResponse("User with "+ userId+" Deleted Successfully",true);
        System.out.println(response);
        ResponseEntity<ApiResponse> finalResponse = new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
        System.out.println(finalResponse.toString());
        return finalResponse;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long userId){
        UserDTO fetchedUser = userService.getUser(userId);
        return new ResponseEntity<UserDTO>(fetchedUser,HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> fetchedUsers = userService.getAllUsers();
        return new ResponseEntity<>(fetchedUsers,HttpStatus.OK);
    }


}
