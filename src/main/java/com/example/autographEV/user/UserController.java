package com.example.autographEV.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        System.out.println("Add user info");
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        System.out.println("All user information");
        return userService.getAllUsers();
    }
    @GetMapping("/id")
    public Optional<User> getById(@RequestParam(name = "id") String id) {
        System.out.println("One User information get based for the given ID");
        return userService.getById(id);
    }
    @PutMapping
    public User updateUser (@RequestBody User user){
        System.out.println("Update an user information by Id" );
        return userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name = "id") String id){
        System.out.println("Delete an user information by Id" );
        userService.deleteUser(id);
    }
    @GetMapping("/address")
    public List<User> getByAddress(@RequestParam (name="address")String address){
        System.out.println("Get user information by address");
        return userService.getByAddress(address);
    }


}
