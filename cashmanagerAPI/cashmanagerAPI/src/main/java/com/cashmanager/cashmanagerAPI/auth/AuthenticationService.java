package com.cashmanager.cashmanagerAPI.auth;

import com.cashmanager.cashmanagerAPI.user.Role;
import com.cashmanager.cashmanagerAPI.user.UserRepository;
import com.cashmanager.cashmanagerAPI.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = Users.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        return  null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
    }
}
