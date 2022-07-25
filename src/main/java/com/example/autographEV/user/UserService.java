package com.example.autographEV.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getById(String Id) {
        return userRepository.findById(Id);
    }

    public User updateUser(User user) { return userRepository.save(user);}

    public void deleteUser(String id) { userRepository.deleteById(id);}

    public List<User> getByAddress(String address) { return userRepository.findAllByAddress(address); }

}
