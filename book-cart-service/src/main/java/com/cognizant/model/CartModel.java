package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "cart")
@IdClass(UserId.class)
public class CartModel {
	@Id
	
	
	@Column(name = "userid")
	@NotNull(message = "User Id can not be null")
	private Long userId;
	
	@Id
	@Column(name = "bookid")
	@NotNull(message = "Book Id can not be null")
	private Long bookId;

}
