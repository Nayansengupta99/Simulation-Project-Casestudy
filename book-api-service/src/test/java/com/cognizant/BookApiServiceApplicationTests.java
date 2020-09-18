package com.cognizant;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.controller.BookController;
import com.cognizant.model.BookModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class BookApiServiceApplicationTests {

	@Autowired
	BookController bController;

	@Autowired
	MockMvc mvc;

	@Test
	@Order(1)
	void contextLoadsUser() throws Exception {
		assertNotNull(bController);
	}

	@Test
	@Order(2)
	void testInsertBook() throws Exception {
		BookModel b = new BookModel((long) 20, "Mishar Rohosso", "M", 256.26, "Bengali");
		Gson g = new Gson();
		String s = g.toJson(b);
		ResultActions actions = mvc.perform(post("/api/books/add").contentType(MediaType.APPLICATION_JSON).content(s));
		actions.andExpect(status().isOk());
		
	}

	@Test
	@Order(3)
	void testUpdateBook() throws Exception {
		BookModel b = new BookModel((long) 20, "Mishar Rohosso", "M", 240.75, "Bengali");
		Gson g = new Gson();
		String s = g.toJson(b);
		ResultActions actions = mvc.perform(put("/api/books/20").contentType(MediaType.APPLICATION_JSON).content(s));
		actions.andExpect(status().isOk());
	}

	@Test
	@Order(4)
	void testFindBookById() throws Exception {
		ResultActions actions = mvc.perform(get("/api/books/8"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.title").exists());
		actions.andExpect(jsonPath("$.title").value("TRAIN TO PAKISTAN"));
	}

	@Test
	@Order(5)
	void testDeleteBookById() throws Exception {
		ResultActions actions = mvc.perform(delete("/api/books/20"));
		actions.andExpect(status().isOk());
	}

	@Test
	@Order(6)
	void testGetAllBookDetails() throws Exception {
		String uri = "/api/books/detail";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ObjectMapper objectMapper = new ObjectMapper();

		BookModel[] booklist = objectMapper.readValue(content, BookModel[].class);
		assertTrue(booklist.length > 0);

	}

}
