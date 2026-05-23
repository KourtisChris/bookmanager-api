package com.bookmanager.buisness.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.bookmanager.buisness.dtos.AuthorDTO;
import com.bookmanager.domain.models.entities.Author;
import com.bookmanager.domain.repossitories.AuthorsRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Validated
public class AuthorService {
	
	private AuthorsRepository authorrepo;
	
	public AuthorService(AuthorsRepository authorrepo) {this.authorrepo = authorrepo;}
	
	public List<AuthorDTO> getallAuthors() {
		return authorrepo.findAll().stream()
				.map(a -> {
					AuthorDTO dto = new AuthorDTO();
						dto.setId(a.getId());
						dto.setName(a.getName());
						dto.setNationality(a.getNationality());
						dto.setBirth_date(a.getBirth_date());
				return dto;
		}).collect(Collectors.toList());
	}
	
	public AuthorDTO getAuthorById(Long id) {
		Author a = authorrepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Author"));
		AuthorDTO dto = new AuthorDTO();
			dto.setId(a.getId());
			dto.setName(a.getName());
			dto.setNationality(a.getNationality());
			dto.setBirth_date(a.getBirth_date());
		return dto;
	}
	
	@Transactional
	public Long createAuthor(@Valid AuthorDTO dto) {
		Author newa = new Author();
		newa.setName(dto.getName());
		newa.setNationality(dto.getNationality());
		newa.setBirth_date(dto.getBirth_date());
		Author saved = authorrepo.save(newa);
		return saved.getId();
	}
	
	@Transactional
	public AuthorDTO updateAuthor(@Valid AuthorDTO dto) {
		Author a = authorrepo.findById(dto.getId())
				.orElseThrow(() -> new EntityNotFoundException("Author"));
		a.setId(dto.getId());
		a.setName(dto.getName());
		a.setNationality(dto.getNationality());
		a.setBirth_date(dto.getBirth_date());
		authorrepo.save(a);
		return dto;
	}

	@Transactional
	public void deleteAuthor(Long id) {
		authorrepo.deleteById(id);
	}	
}
