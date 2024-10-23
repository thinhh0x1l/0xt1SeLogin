package com.learnspringboot.a1.registration;

import com.learnspringboot.a1.user.Role;
import lombok.Data;

import java.util.List;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Role> roles;
}
