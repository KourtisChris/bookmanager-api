package com.bookmanager.api.controllers;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookmanager.buisness.dtos.AuthorDTO;
import com.bookmanager.buisness.services.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	private AuthorService authorSrv;

	public AuthorController(AuthorService authorSrv) {this.authorSrv = authorSrv;}
	
	@GetMapping
	public ResponseEntity<List<AuthorDTO>> getAuthors() {
		List<AuthorDTO> response = authorSrv.getallAuthors();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id){
		AuthorDTO response = authorSrv.getAuthorById(id);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Long> createAuthor(@Valid @RequestBody AuthorDTO dto)
	{
		Long id = authorSrv.createAuthor(dto);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorDTO dto)
	{
		dto.setId(id);
		AuthorDTO updated = authorSrv.updateAuthor(dto);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable Long id)
	{
		authorSrv.deleteAuthor(id);
		return ResponseEntity.ok().build();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
