package org.senechka.lab1.service;

import org.senechka.lab1.models.User;
import org.senechka.lab1.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new RuntimeException("User with username " + username + " already exists");
        }

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }
}
