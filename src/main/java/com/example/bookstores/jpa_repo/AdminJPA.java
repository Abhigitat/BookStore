package com.example.bookstores.jpa_repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstores.entities.Admin;

import java.util.List;


public interface AdminJPA extends JpaRepository<Admin, Integer>{
	public List<Admin> findfindByName(String name);
}
