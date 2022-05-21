package com.spring.jpa.h2.simplelibrary.controller;

import com.spring.jpa.h2.simplelibrary.entity.Author;
import com.spring.jpa.h2.simplelibrary.entity.Book;
import com.spring.jpa.h2.simplelibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;
    @GetMapping("/")
    public ResponseEntity<List<Author>> getAllAuthors(@RequestParam(required = false) String name) {
        try {
            List<Author> authors = new ArrayList<>();
            if (name != null) {
                authors.addAll(authorRepository.findByNameContaining(name));
            } else {
                authors.addAll(authorRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
            }

            if (authors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(authors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") long id) {
        Optional<Author> authorData = authorRepository.findById(id);
        return authorData.map(author -> new ResponseEntity<>(author, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        try {
            Author _author = authorRepository
                    .save(new Author(author.getName(),author.getNationality(), author.getBookList()));
            return new ResponseEntity<>(_author, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") long id, @RequestBody Author author) {
        Optional<Author> authorData = authorRepository.findById(id);
        if (authorData.isPresent()) {
            Author _author = authorData.get();
            _author.setName(author.getName());
            _author.setNationality(author.getNationality());
            _author.setBookList(author.getBookList());

            return new ResponseEntity<>(authorRepository.save(_author), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("id") long id) {
        try {
            authorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllAuthors() {
        try {
            authorRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
}