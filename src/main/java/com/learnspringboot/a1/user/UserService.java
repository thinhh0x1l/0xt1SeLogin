package com.learnspringboot.a1.user;

import com.learnspringboot.a1.registration.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User registerUser(RegistrationRequest registrationRequest) {
        return userRepository.save(new User
            (registrationRequest.getFirstName(),
            registrationRequest.getLastName(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword()),
            List.of(new Role("ROLE_USER"))
        ));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
