package com.restapi.airlines.model.Request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UserDetailsRequestModel {
    @NotNull
    private String userId;

    @NotBlank(message = "First must be filled")
    @Size(min=2, message = "Last name must not be less than 2 characters")
    private String firstName;

    @NotBlank(message = "Last name must be filled")
    @Size(min=2, message = "Last name must not be less than 2 characters")
    private String lastName;

    @NotBlank(message = "Phone Number must be filled")
    private String phoneNum;

    private String userName;

    @NotBlank(message = "Email name must be filled")
    @Email(message = "Email format is wrong")
    private String email;

    @NotBlank(message = "Password must be filled")
    @Size(min=8, max=16, message = "Password must be equal or greater than 8 and less than 16 character")
    private String password;
}
