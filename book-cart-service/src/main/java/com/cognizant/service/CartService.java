package com.cognizant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.CartItemEmptyForUserException;
import com.cognizant.feignclient.BookFeignClient;
import com.cognizant.model.BookModel;
import com.cognizant.model.CartModel;
import com.cognizant.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private BookFeignClient bookClient;

	public List<BookModel> getBookDeatils() {
		return bookClient.getBookDetails();
	}

	public String addToCart(Long userId, Long bookId) {

		cartRepo.insertCartItems(userId, bookId);
		return "Book Item with Book Id " + Long.toString(bookId) + " successfully added in the cart";
	}

	public List<BookModel> viewCartItems(Long userid, CartModel cart) {

		List<BookModel> bookItems = bookClient.getBookDetails();
		List<CartModel> cartItems = cartRepo.findById(userid);

		List<BookModel> addedItems = bookItems.stream()
				.filter(items -> (cartItems).stream().anyMatch(books -> books.getBookId() == items.getId()))
				.collect(Collectors.toList());
		if (addedItems.size() > 0) {
			return addedItems;
		} else {
			throw new CartItemEmptyForUserException(userid);
		}
	}

	public String deleteFromCart(Long userId, Long bookId) {
		cartRepo.deleteById(bookId);
		return "Book Item with Book Id " + Long.toString(bookId) + " successfully deleted from the cart";
	}

}
