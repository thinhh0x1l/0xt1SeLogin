package com.learnspringboot.a1.security;

import com.learnspringboot.a1.user.User;
import com.learnspringboot.a1.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EndToEndUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /**
        Optional<User> optionalUser = userRepository.findByEmail(email);
        EndToEndUserDetails e = optionalUser
                .map(user -> new EndToEndUserDetails(user))
                .orElseThrow();

         */
        return userRepository.findByEmail(email)
                .map(EndToEndUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
