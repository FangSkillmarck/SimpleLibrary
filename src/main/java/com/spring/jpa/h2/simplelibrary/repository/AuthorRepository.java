package com.spring.jpa.h2.simplelibrary.repository;

import com.spring.jpa.h2.simplelibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    //List<Book> findAllByTitleContainingByTitleAsc(String title);
    List<Author> findByNameContaining(String name);

   // List<Book> findByPublished(boolean published);
   // List<Book> findAuthorContaining(String author);
    //List<Book> findByAuthor(String readerName);
   //List<Book> findByBorrowed(boolean borrowed);
   // List<Book> findByIsbn(String isbn);
}
