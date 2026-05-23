package com.bookmanager.domain.models.entities;

import java.util.*;

import com.bookmanager.domain.models.enums.dataBaseTables;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity 
@Table (name = dataBaseTables.Books)
public class Book {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Ο τίτλος είναι υποχρεωτικός.")
	private String title;
	private String isbn;
	private String category;
	private Integer publication_year;
	
	@OneToMany (mappedBy = "book")
	private List<Book_and_Author> booksList = new ArrayList<>();
	
	
	public Long getId() {return id;}
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
