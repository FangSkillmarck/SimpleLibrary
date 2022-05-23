package com.spring.jpa.h2.simplelibrary.repository;

import com.spring.jpa.h2.simplelibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
