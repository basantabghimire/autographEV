package com.example.autographEV.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;


@Service
@CrossOrigin(origins = "*")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User updateUser(User user) { return userRepository.save(user);}

    public void deleteUser(String userId) { userRepository.deleteById(userId);}

    public User getEmail(String email) {
        return userRepository.findByEmail(email);
    }

}


//    public Optional<User> getByIdToken(String headers) {
//        return userRepository.findById(headers);
//    }


//    public User getByEmail(String headers) {
//        return userRepository.findById(headers).get();
//    }

//    public User getByIdToken(String email) {
//        return userRepository.findOne(User.class(email));
//    }

//    public List<User> getByAddress(String address) { return userRepository.findAllByAddress(address); }
//
//    public List<User> getByName(String name) { return userRepository.findAllByName(name); }

//    public Optional<User> getByIdToken(String headers) {
//        return userRepository.findById(headers);
//    }


//    public User getUser(String email) {
//        return userRepository.findByEmail(email);
//    }

//    public Optional<User> getByIdToken(String headers) {
//        return userRepository.findById(headers);
//    }
//public User getById(String userId) { return userRepository.findById(userId).get();}



