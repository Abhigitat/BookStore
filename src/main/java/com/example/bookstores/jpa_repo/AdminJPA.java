package com.example.bookstores.jpa_repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstores.admin.Admin;

public interface AdminJPA extends JpaRepository<Admin, Integer>{

}
