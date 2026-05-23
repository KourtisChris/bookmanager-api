package com.bookmanager.domain.models.entities;

import java.time.LocalDate;
import java.util.*;
import java.util.Date;

import com.bookmanager.domain.models.enums.dataBaseTables;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = dataBaseTables.Authors)
public class Author {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Το όνομα είναι υποχρεωτικό.")
	private String name;
	
	private String nationality;
	private LocalDate birth_date;
	
	@OneToMany (mappedBy = "author")
	private List<Book_and_Author> authorsList = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public LocalDate getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}
}
