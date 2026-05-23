package com.bookmanager.api.controllers;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookmanager.buisness.dtos.BookDTO;
import com.bookmanager.buisness.services.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private BookService bookSrv;
	
	public BookController(BookService bookService) {this.bookSrv = bookService;}
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> getBooks() {
		List<BookDTO> response = bookSrv.getAllBooks();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
		BookDTO response = bookSrv.getBookById(id);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Long> createBook(@Valid @RequestBody BookDTO dto) 
	{
		Long id = bookSrv.createBook(dto);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> updateBook(
			@PathVariable Long id, @Valid @RequestBody BookDTO dto)
	{
		dto.setId(id);
		BookDTO updated = bookSrv.updateBook(dto);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id)
	{
		bookSrv.deleteBook(id);
		return ResponseEntity.ok().build();
	}
















}
