package com.four.hotelinfo.Controller;

import com.four.hotelinfo.model.User;
import com.four.hotelinfo.service.UserService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/join")
    public ResponseEntity<?> joinUser(@RequestBody User user) {
        if(user.getUserId().equals("admin")){
            user.setLogin_status(0);
        } else{
            user.setLogin_status(1);
        }
        boolean result = service.insertUser(user);
        if (result){
            return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>("FAIL", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update") // 아직
    public ResponseEntity<?> updateUser(@RequestBody User user){
        boolean result = service.updateUser(user);
        if (result){
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FAIL", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user){
        User u = service.login(user);
        if(u.getUserId()==null){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(u, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{userid}")
    public ResponseEntity<?> deleteMember(@PathVariable("userid") String Userid) {
        boolean result = service.deleteUser(Userid);
        if(result){
            return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("FAIL", HttpStatus.CONFLICT);
        }
    }
    
    @GetMapping("/alluser")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
