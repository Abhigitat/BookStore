package com.bookstore.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Books {
    @Id
    private int bid;
    private String title;
    private String author;
    private String description;
    private double price;
    private int bookcount;
    
    public int getBookcount() {
        return bookcount;
    }
    public void setBookcount(int bookcount) {
        this.bookcount = bookcount;
    }
    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}
