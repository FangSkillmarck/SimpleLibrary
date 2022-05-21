package com.spring.jpa.h2.simplelibrary.repository;

import com.spring.jpa.h2.simplelibrary.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

    //List<Book> findAllByTitleContainingByTitleAsc(String title);
    List<Reader> findByFirstNameContaining(String firstName);

   // List<Book> findByPublished(boolean published);
   // List<Book> findAuthorContaining(String author);
    //List<Book> findByReader(String readerName);
   //List<Book> findByBorrowed(boolean borrowed);
   // List<Book> findByIsbn(String isbn);
}
