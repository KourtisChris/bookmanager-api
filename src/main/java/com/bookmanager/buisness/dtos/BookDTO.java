package com.bookmanager.buisness.dtos;

import jakarta.validation.constraints.*;

public class BookDTO {
	private Long id;
	
	@NotNull (message = "Title can not be Null.")
	@NotEmpty (message = "Title can not be Empty.")
	private String title;
	@NotNull (message = "ISBN can not be Null.")
	@NotEmpty (message = "ISBN can not be Empty.")
	private String isbn;
	
	private String category;
	private Integer publication_year;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(Integer publication_year) {
		this.publication_year = publication_year;
	}
}
