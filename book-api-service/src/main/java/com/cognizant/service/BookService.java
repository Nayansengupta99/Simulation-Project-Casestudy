package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.exception.BookNotFoundException;
import com.cognizant.model.BookModel;
import com.cognizant.repository.BookRepository;

import lombok.extern.java.Log;

@Log
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	
	public List<BookModel> getBookDetails() {
		log.info("All book details fetched");
		return bookRepo.findAll();
	}

	public String saveNewBook(BookModel newBook) {

		 bookRepo.save(newBook);
		 return "New Book Added Successfully";
	}

	public BookModel findByBookId(Long id) {

		return bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException(id));

	}

	public BookModel updateBookModel(@RequestBody BookModel newBook, @PathVariable Long id) {
		return bookRepo.findById(id).map(book -> {
			book.setId(newBook.getId());
			book.setTitle(newBook.getTitle());
			book.setAuthor(newBook.getAuthor());
			book.setPrice(newBook.getPrice());
			book.setLanguage(newBook.getLanguage());
			log.info("Book details updated");
			return bookRepo.save(book);
		}).orElseThrow(() -> new BookNotFoundException(id));
	}

	public String deleteBook(@PathVariable Long id) {

		if (bookRepo.findById(id).isPresent()) {
			log.info("Book deleted successfully");
			
			bookRepo.deleteById(id);
			return "Book id "+Long.toString(id)+" deleted successfully";
		} else {
			throw new BookNotFoundException(id);
		}
	}

}
