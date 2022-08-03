package com.example.autographEV.user;

import com.example.autographEV.exception.RestrictedInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/A4/users")
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
    @GetMapping("/{userId}")
    public User getById(@RequestParam("userId") String userId) {
        System.out.println("One User information get based by the given ID");
        return userService.getById(userId);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity <String> noSuchElementError(){
        return new ResponseEntity<>("No such element found", HttpStatus.NOT_FOUND);
    }
    @PutMapping
    public User updateUser (@RequestBody User user){
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
    @ExceptionHandler(RestrictedInfoException.class)
    public ResponseEntity <String> restrictedInfoError(RestrictedInfoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
