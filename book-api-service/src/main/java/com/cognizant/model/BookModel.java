package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class BookModel {
	@Id
	
	@Column(name = "id", nullable = false)
	@NotNull(message = "Book Id can not be null")
	private Long id;
	
	@Column(name = "title", nullable = false)
	@NotNull(message = "Title can not be null")
	private String title;
	
	
	@Column(name = "author")
	
	@NotNull private String author;
	
	@Column(name = "price", nullable = false)
	@NotNull(message = "Price can not be null")
	private Double price;
	
	@Column(name = "language", nullable = false)
	@NotNull(message = "Language can not be null")
	private String language;
	
	
}
