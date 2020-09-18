package com.cognizant.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.model.BookModel;

@FeignClient(name = "book-api-service")
public interface BookFeignClient {

	@GetMapping("api/books/detail")
	public List<BookModel> getBookDetails();

	@GetMapping("api/books/{id}")
	public BookModel findByBookId(@PathVariable Long id);

	@PostMapping("books/add")
	public BookModel addNewBook(@RequestBody BookModel newBook);

	@PutMapping("books/{id}")
	public BookModel updateBookModel(@RequestBody BookModel newBook, @PathVariable Long id);

	@DeleteMapping("books/{id}")
	void deleteBook(@PathVariable Long id);

}
