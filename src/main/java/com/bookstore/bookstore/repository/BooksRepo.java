package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.Books;

public interface BooksRepo extends JpaRepository<Books,Integer>{
    
}
