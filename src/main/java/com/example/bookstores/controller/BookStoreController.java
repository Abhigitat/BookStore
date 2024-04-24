package com.example.bookstores.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookstores.entities.Admin;
import com.example.bookstores.jpa_repo.AdminJPA;


@RestController
public class BookStoreController {
	@Autowired
	AdminJPA a;
	
	@GetMapping("/saveadmin")
	public ModelAndView mapp(@RequestParam int eid,@RequestParam String name,@RequestParam String password) {
		Admin ad=new Admin();
		ad.setEid(eid);
		ad.setName(name);
		ad.setPassword(password);
		a.save(ad);
		return new ModelAndView("redirect:" + "https://www.google.com");
		//return "SAved";
	}
	
	@GetMapping("/admin")
	@ResponseStatus(HttpStatus.BAD_REQUEST)  // 409
    @ExceptionHandler(NullPointerException.class)
	public String save(@RequestParam int eid) {
		
		Optional<Admin> ad=a.findById(eid);
		
		if(ad.isPresent()) {
			Admin a=ad.get();
			return a.getEid()+" "+a.getName();
		}
		new NullPointerException("Admin not found ");
		return null;
	}
	
	
}
