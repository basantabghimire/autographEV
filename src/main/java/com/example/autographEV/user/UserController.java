package com.example.autographEV.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User saveUser(@RequestBody @Valid User user) {
        System.out.println("Add user info");
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("All user information");
        return userService.getAllUsers();
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

    @GetMapping("/email")
    public User getByEmail(@RequestParam String email) {
        System.out.println("view email");
        return userService.getEmail(email);
    }

}


//    @GetMapping("/{address}")
//    public List<User> getByAddress(@RequestParam("address") String address){
//        System.out.println("Get user information by address");
//        return userService.getByAddress(address);
//    }
//
//    @GetMapping("/{name}")
//    public List<User>getByName(@RequestParam("name") String name,@RequestHeader (name="idToken") String idToken) throws RestrictedInfoException{
//        if(name.equalsIgnoreCase("root")){
//            throw new RestrictedInfoException();
//        }
//        return userService.getByName(name);
//    }

//controller
//   @GetMapping("/myProfile")
//       public User getMe(@RequestParam (name="email") String headers){
//             Optional<User> user = userService.getByIdToken(headers);
//             if(user.isPresent()){
//                System.out.println("retrieve current user record using idToken => headers");
//                return user.get();
//             }else {throw
//                     new RuntimeException("user not fount");
//             }
//    }

//    @GetMapping("/myProfile")
//    public User getMe(@RequestParam (name="email") String headers)throws RestrictedInfoException{
//        if(headers.equalsIgnoreCase("root")){
//            throw new RestrictedInfoException();
//        }
//        System.out.println("view email");
//        return userService.getByEmail(headers);
//    }


//http://localhost:8083/api/users/me?email=bbg%40gmail.com

//http://localhost:8083/api/users/me?email=testgmh%40gmail.com


//    @GetMapping("/email")
//    public User getUser(@PathVariable String email) {
//        System.out.println("One User information get based by the given ID");
//        return userService.getByIdToken(email);
//    }

//    @GetMapping("/email")
//    public User getUser(@RequestParam String email){
//        System.out.println("get user record-by-email");
//        return userService.getUser(email);
//    }

//    @GetMapping("/me")
//    public User findOneByEmail(@RequestParam(name = "me") String email)throws RestrictedInfoException {
//        if(email.equalsIgnoreCase("root")){
//            throw new RestrictedInfoException();
//        }
//        System.out.println("view email");
//        return userService.getUser(email);
//    }

//    @GetMapping("/{userId}")
//    public User getById(@RequestParam("userId") String userId) {
//        System.out.println("One User information get based by the given ID");
//        return userService.getById(userId);
//    }
