package com.spring.jpa.h2.simplelibrary.repository;

import com.spring.jpa.h2.simplelibrary.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //List<Book> findAllByTitleContainingByTitleAsc(String title);
    List<Customer> findByNameContaining(String name);

   // List<Book> findByPublished(boolean published);
   // List<Book> findAuthorContaining(String author);
    //List<Book> findByReader(String readerName);
   //List<Book> findByBorrowed(boolean borrowed);
   // List<Book> findByIsbn(String isbn);
}
