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

import com.bookstore.bookstore.entity.Seller;
import com.bookstore.bookstore.repository.SellerRepo;

public class SellerController {

    @Autowired
    SellerRepo s;

    @PostMapping("/saveSeller")
    public boolean saveSeller(@RequestBody Seller seller) throws Exception {
        try {
            s.save(seller);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/deleteSeller")
    public boolean deleteSeller(@RequestParam String email) {
        // Integer id=Integer.parseInt(i);
        Optional<Seller> op = s.findById(email);
        if (!op.isEmpty()) {
            Seller user = op.get();
            s.delete(user);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/getSeller")
    public Seller getSeller(@RequestParam String email) {
        Optional<Seller> op = s.findById(email);
        if (op.isPresent()) {
            Seller seller = op.get();
            return seller;
        }
        return null;
    }

    @PutMapping("/updateSeller")
    public boolean updateSeller(@RequestParam String email, @RequestParam String password, @RequestBody Seller entity) {
        Optional<Seller> op = s.findById(email);
        if (op.isPresent()) {
            Seller user = op.get();
            if (user.getPassword().equals(password)) {
                user.setAddress(entity.getAddress() == null ? user.getAddress() : entity.getAddress());
                user.setName(entity.getName() == null ? user.getName() : entity.getName());
                user.setPhone(entity.getPhone() == null ? user.getPhone() : entity.getPhone());
                user.setPassword(entity.getPassword() == null ? user.getPassword() : entity.getPassword());
                user.setUsername(entity.getUsername() == null ? user.getUsername() : entity.getUsername());
                s.save(user);
                return true;
            }
        }
        return false;
    }

    @GetMapping("/getAllSellers")
    public List<Seller> getAllSellers() {
        List<Seller> sellerlist = new ArrayList<>();
        s.findAll().forEach(seller -> sellerlist.add(seller));
        return sellerlist;
    }
}
