package com.example.autographEV.user;
import com.example.autographEV.exception.RestrictedInfoException;
import com.example.autographEV.firebase.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping
    public User saveUser(@RequestBody @Valid User user, String idToken) {
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
