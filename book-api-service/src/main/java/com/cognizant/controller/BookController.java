package com.cognizant.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.model.BookModel;
import com.cognizant.service.BookService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("api")
public class BookController {

	@Autowired
	private BookService bookService;

	@SuppressWarnings("rawtypes")
	@GetMapping("books/detail")
	public List getAllBookDetails() {
	
		return bookService.getBookDetails();
	}

	@PostMapping("books/add")
	public String addNewBook(@RequestBody BookModel newBook) {
		log.info("Book Details Saved");
		return bookService.saveNewBook(newBook);
	}

	@GetMapping("books/{id}")
	public BookModel findBookById(@PathVariable Long id) {
		
		return (bookService.findByBookId(id));
	}

	@PutMapping("books/{id}")
	public BookModel updateBookModel(@RequestBody BookModel newBook, @PathVariable Long id) {
	
		return bookService.updateBookModel(newBook, id);
	}

	@DeleteMapping("books/{id}")
	public String deleteBook(@PathVariable Long id) {
		return bookService.deleteBook(id);
	   
	}

}
