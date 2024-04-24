package com.bookstore.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.entity.Books;
import com.bookstore.bookstore.repository.BooksRepo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class BookController {

	@Autowired
	BooksRepo b;

	@PostMapping("/savebook")
	public boolean saveBook(@RequestBody Books b) throws Exception {
		try {
			this.b.save(b);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping("/deletebook/{id}")
	public boolean deleteBook(@PathVariable("id") int id) {
		// Integer id=Integer.parseInt(i);
		Optional<Books> op = b.findById(id);
		if (!op.isEmpty()) {
			Books book = op.get();
			System.out.println("Working??");
			b.delete(book);
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("/getbook")
	public Books getBooks(@RequestParam int id) {
		Optional<Books> op = b.findById(id);
		if (op.isPresent()) {
			Books book = op.get();
			return book;
		}
		return null;
	}

	@PutMapping("/updateBook")
	public boolean updateBook(@RequestParam int id, @RequestBody Books entity) {
		Optional<Books> op = b.findById(id);
		if (op.isPresent()) {
			Books book = op.get();
			book.setAuthor(entity.getAuthor() == null ? book.getAuthor() : entity.getAuthor());
			book.setBookcount(entity.getBookcount() == 0 ? book.getBookcount() : entity.getBookcount());
			book.setDescription(entity.getDescription() == null ? book.getDescription() : entity.getDescription());
			book.setPrice(entity.getPrice() == 0 ? book.getPrice() : entity.getPrice());
			book.setTitle(entity.getTitle() == null ? book.getTitle() : entity.getTitle());
			b.save(book);
			return true;
		}
		return false;
	}

	@GetMapping("/getAllBooks")
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	public List<Books> getAllBooks() {
		List<Books> bookList = new ArrayList<>();
		b.findAll().forEach(book -> bookList.add(book));
		return bookList;
	}

}
