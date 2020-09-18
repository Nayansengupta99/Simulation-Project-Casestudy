package com.cognizant;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.controller.CartController;
import com.cognizant.feignclient.BookFeignClient;
import com.cognizant.model.CartModel;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class BookCartServiceApplicationTests {

	@Autowired
	CartController cController;
    @Autowired
	MockMvc mvc;

	@Test
	@Order(1)
	void contextLoadsUser() throws Exception {
		assertNotNull(cController);
	}

	@Test
	@Order(2)
	void testInsertBook() throws Exception {
		CartModel b = new CartModel((long) 200, (long) 201);
		Gson g = new Gson();
		String s = g.toJson(b);
		ResultActions actions = mvc
				.perform(post("/user/cart/200/201").contentType(MediaType.APPLICATION_JSON).content(s));
		actions.andExpect(status().isOk());

	}

	@Test
	@Order(3)
	void testFindCartDetailsByUserId() throws Exception {
		ResultActions actions = mvc.perform(get("/user/cart/101"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$[0].title").value("MALGUDI DAYS"));
	} 

	@Test
	@Order(4)
	void testDeleteBookFromCart() throws Exception {
		ResultActions actions = mvc.perform(delete("/user/cart/102/2"));
		actions.andExpect(status().isOk());
	}

}
