package com.cognizant.model;


import lombok.Data;


@Data

public class BookModel {
	
	private Long id;
	private String title;
	private String author;
	private Double price;
	private String language;
}
