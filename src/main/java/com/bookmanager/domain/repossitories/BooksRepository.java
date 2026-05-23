package com.bookmanager.domain.repossitories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import com.bookmanager.domain.models.entities.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitle(String title);

}
