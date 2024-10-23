package com.learnspringboot.a1.user;

import com.learnspringboot.a1.registration.RegistrationRequest;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User registerUser(RegistrationRequest registrationRequest);

    User findByEmail(String email);
}
