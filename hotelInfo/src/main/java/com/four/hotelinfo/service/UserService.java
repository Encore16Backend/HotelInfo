package com.four.hotelinfo.service;

import com.four.hotelinfo.model.User;
import com.four.hotelinfo.repo.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public Boolean insertUser(User user) {
        Optional<User> exist = userRepo.findByUserId(user.getUserId());
        if(exist.isPresent()){
            return false;
        }
        userRepo.save(user);
        return true;
    }

    public Boolean deleteUser(String userid) {
        Optional<User> exist = userRepo.findByUserId(userid);
        System.out.println(exist.toString());
        if(!exist.isPresent()){
            return false;
        }
        userRepo.deleteUserByUserId(userid);
        return true;
    }

    public Boolean updateUser(User user) {
        Optional<User> exist = findUser(user.getUserId());
        if(exist.isPresent()){
            User u = exist.get();
            u.setPassword(user.getPassword());
            userRepo.save(u);
            return true;
        }
        return false;
    }

    public Optional<User> findUser(String userid){
        return userRepo.findByUserId(userid);
    }

    public User login(User user){
        Optional<User> exist = userRepo.findByUserId(user.getUserId());
        if(exist.isPresent()){
            User u = exist.get();
            if (user.getPassword().equals(u.getPassword())){
                return u;
            }
        }
        return new User();
    }

    public List<User> findAllUser(){
        return userRepo.findAll();
    }

}
