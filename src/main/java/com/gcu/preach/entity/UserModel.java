package com.gcu.preach.entity;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserModel {
    @NotNull(message="User name field cannot be empty!")
    @Size(min=1, max=32, message="Your user name must be between 1 and 32 characters long!")
    private String userName;
    @NotNull(message="User name field cannot be empty!")
    @Size(min=1, max=32, message="Your password must be between 1 and 32 characters long!")
    private String userPassword;
    @NotNull(message="User name field cannot be empty!")
    @Size(min=1, max=20, message="Your first name must be between 1 and 32 characters long!")
    private String userFirstName;
    @NotNull(message="User name field cannot be empty!")
    @Size(min=1, max=20, message="Your last name must be between 1 and 32 characters long!")
    private String userLastName;
    @NotNull(message="User name field cannot be empty!")
    @Size(min=1, max=50, message="Your email must be between 1 and 50 characters long!")
    private String userEmail;
    @NotNull(message="User name field cannot be empty!")
    @Size(min=10, max=10, message="Your phone number must be contain 10 characters, (only numbers please)!")
    private String userPhoneNumber;
    @NotNull(message="User name field cannot be empty!")
    @Size(min=4, max=60, message="Your address must be between 4 and 60 characters long!")
    private String userAddress1;
    @Size(min=0, max=60, message="Your address2 must be between 0 and 60 characters long!")
    private String userAddress2;
    @NotNull(message="User name field cannot be empty!")
    @Size(min=1, max=32, message="Your city must be between 1 and 32 characters long!")
    private String userCity;
    @NotNull(message="User name field cannot be empty!")
    @Size(min=4, max=14, message="Your state must be between 1 and 14 characters long!")
    private String userState;
    @NotNull(message="User name field cannot be empty!")
    @Size(min=5, max=5, message="Your zipcode must be between 5 characters long!")
    private String userZip;

}
