package com.bookmanager.buisness.dtos;

import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.*;

public class AuthorDTO {
	private Long id;
	
	@NotNull (message = "Name can not be Empty.")
	@NotEmpty (message = "Name can not be Empty.")
	private String name;
	
	private String nationality;
	private LocalDate birth_date;
	
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
