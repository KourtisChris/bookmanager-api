package com.bookmanager.buisness.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.bookmanager.buisness.dtos.BookDTO;
import com.bookmanager.domain.models.entities.Book;
import com.bookmanager.domain.repossitories.BooksRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Validated
public class BookService {
	
	private BooksRepository bookrepo;
	
	public BookService(BooksRepository bookrepo) {this.bookrepo = bookrepo;}

	public List<BookDTO> getAllBooks() {
		return bookrepo.findAll().stream()
				.map(b -> {
					BookDTO dto = new BookDTO();
						dto.setId(b.getId());
						dto.setTitle(b.getTitle());
						dto.setIsbn(b.getIsbn());
						dto.setCategory(b.getCategory());
						dto.setPublication_year(b.getPublication_year());
					return dto;
				}).collect(Collectors.toList());
	}
	
	public BookDTO getBookById(Long id) {
		Book b =  bookrepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Book"));
		BookDTO dto = new BookDTO();
			dto.setId(b.getId());
			dto.setTitle(b.getTitle());
			dto.setIsbn(b.getIsbn());
			dto.setCategory(b.getCategory());
			dto.setPublication_year(b.getPublication_year());
		return dto;
	}
	
	@Transactional
	public Long createBook(@Valid BookDTO dto) {
		Book newb = new Book();
		newb.setTitle(dto.getTitle());
		newb.setIsbn(dto.getIsbn());
		newb.setCategory(dto.getCategory());
		newb.setPublication_year(dto.getPublication_year());
		Book saved = bookrepo.save(newb);
		return saved.getId();
	}
	

	@Transactional
	public BookDTO updateBook(@Valid BookDTO dto) {
		Book b = bookrepo.findById(dto.getId())
				.orElseThrow(() -> new EntityNotFoundException("Book"));
		b.setTitle(dto.getTitle());
		b.setIsbn(dto.getIsbn());
		b.setCategory(dto.getCategory());
		b.setPublication_year(dto.getPublication_year());
		bookrepo.save(b);
		return dto;
	}
	
	@Transactional
	public void deleteBook(Long id) {
		bookrepo.deleteById(id);
	}

}
