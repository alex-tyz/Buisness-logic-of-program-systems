package org.senechka.lab1.service;

import org.senechka.lab1.models.Roles;
import org.senechka.lab1.models.User;
import org.senechka.lab1.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUserByRole(String role) {
        return userRepository.findAllByRole(Roles.valueOf(role));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
