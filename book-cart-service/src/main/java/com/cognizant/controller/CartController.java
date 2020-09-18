package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.model.BookModel;
import com.cognizant.model.CartModel;
import com.cognizant.service.CartService;

@RestController
@RequestMapping("user")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/books")
	public List<BookModel> getBookDeatils() {
		return cartService.getBookDeatils();
	}

	@PostMapping("/cart/{userid}/{bookid}")
	public String addToCart(@PathVariable("userid") Long userId, @PathVariable("bookid") Long bookId) {

		return cartService.addToCart(userId, bookId);

	}

	@GetMapping("/cart/{userid}")
	public List<BookModel> viewCartItems(@PathVariable("userid") Long userid, CartModel cart) {
		return  cartService.viewCartItems(userid, cart);
	}

	@DeleteMapping("/cart/{userid}/{bookid}")
	public String deleteFromCart(@PathVariable("userid") Long userId, @PathVariable("bookid") Long bookId) {
		return cartService.deleteFromCart(userId, bookId);
	}

}
