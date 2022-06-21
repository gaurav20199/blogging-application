package com.example.bloggingapplication.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
/*
    Jo user se data lena hai vo yaha rakhenge and ye data expose bhi kar skte hai hum.
    User Entity me add bhi kar skte hai extra fields because of this, coz we will be exposing
    the userdto to external world rather than user entity.
 */
public class UserDTO {

    private long userId;
    @NotEmpty
    @Size(min = 6, max = 12, message = "username should be atleast 6 characters long and max of 12 characters")
    private String userName;
    @NotEmpty
    @Size(min = 8, max = 12, message = "password should be atleast 8 characters long and max of 12 characters")
    private String password;
    @NotEmpty
    @Size(max = 1000, message = "Bio must be within 1000 characters")
    private String bio;
}

