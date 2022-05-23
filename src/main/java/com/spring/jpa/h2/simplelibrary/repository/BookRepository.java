package com.spring.jpa.h2.simplelibrary.repository;

import com.spring.jpa.h2.simplelibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleOrderByTitle(String title);
    List<Book> findByAuthorOrderByAuthor(String author);
    List<Book> findByGenreOrderByGenre(String genre);

}
