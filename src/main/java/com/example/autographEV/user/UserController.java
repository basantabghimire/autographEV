package com.example.autographEV.user;

import com.example.autographEV.exception.RestrictedInfoException;
import com.example.autographEV.firebase.FirebaseService;
import com.example.autographEV.firebase.FirebaseUser;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public User saveUser(@RequestBody @Valid User user, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        //System.out.println("Add user info");
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            return userService.saveUser(user);
        }
        return null;
    }

    @GetMapping
    public List<User> getAllUsers(){
        System.out.println("All user information");
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getById(@RequestParam("userId") String userId) {
        System.out.println("One User information get based by the given ID");
        return userService.getById(userId);
    }

    @PutMapping
    public User updateUser (@RequestBody @Valid User user){
        System.out.println("Update an user information by Id" );
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){
        System.out.println("Delete an user information by Id" );
        userService.deleteUser(userId);
    }

    @GetMapping("/{address}")
    public List<User> getByAddress(@RequestParam("address") String address){
        System.out.println("Get user information by address");
        return userService.getByAddress(address);
    }

    @GetMapping("/{name}")
    public List<User>getByName(@RequestParam("name") String name) throws RestrictedInfoException{
        if(name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return userService.getByName(name);
    }

}
