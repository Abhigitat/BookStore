package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.User;

public interface UserRepo extends JpaRepository<User,String>{
    
}
