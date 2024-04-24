package com.bookstore.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.repository.UserRepo;

@RestController
public class UserController {

    @Autowired
    UserRepo u;

    @PostMapping("/saveUser")
    public boolean saveUser(@RequestBody User user) throws Exception {
        try {
            u.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestParam String email) {
        // Integer id=Integer.parseInt(i);
        Optional<User> op = u.findById(email);
        if (!op.isEmpty()) {
            User user = op.get();
            u.delete(user);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam String email) {
        Optional<User> op = u.findById(email);
        if (op.isPresent()) {
            User user = op.get();
            return user;
        }
        return null;
    }

    @PutMapping("/updateUser")
    public boolean updateUser(@RequestParam String email, @RequestParam String password, @RequestBody User entity) {
        Optional<User> op = u.findById(email);
        if (op.isPresent()) {
            User user = op.get();
            if (user.getPassword().equals(password)) {
                user.setAddress(entity.getAddress() == null ? user.getAddress() : entity.getAddress());
                user.setName(entity.getName() == null ? user.getName() : entity.getName());
                user.setPhone(entity.getPhone() == null ? user.getPhone() : entity.getPhone());
                user.setPassword(entity.getPassword() == null ? user.getPassword() : entity.getPassword());
                user.setUsername(entity.getUsername() == null ? user.getUsername() : entity.getUsername());
                u.save(user);
                return true;
            }
        }
        return false;
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUsers() {
        List<User> userlist = new ArrayList<>();
        u.findAll().forEach(user -> userlist.add(user));
        return userlist;
    }
}