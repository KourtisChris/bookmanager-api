package com.bookmanager.domain.repossitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmanager.domain.models.entities.Author;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {

}
