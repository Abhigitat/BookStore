package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.Seller;

public interface SellerRepo extends JpaRepository<Seller,String>{
    
}
