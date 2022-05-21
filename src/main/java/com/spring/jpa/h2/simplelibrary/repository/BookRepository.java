package com.spring.jpa.h2.simplelibrary.repository;

import com.spring.jpa.h2.simplelibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    //List<Book> findAllByTitleContainingByTitleAsc(String title);
    List<Book> findByTitleContaining(String title);
    List<Book> findByPublished(boolean published);
   // List<Book> findAuthorContaining(String author);
    //List<Book> findByReader(String readerName);
   // List<Book> findByBorrowed(boolean borrowed);
   // List<Book> findByIsbn(String isbn);
}
