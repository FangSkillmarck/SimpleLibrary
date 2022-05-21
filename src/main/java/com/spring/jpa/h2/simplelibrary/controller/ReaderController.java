package com.spring.jpa.h2.simplelibrary.controller;

import com.spring.jpa.h2.simplelibrary.entity.Reader;
import com.spring.jpa.h2.simplelibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReaderController {
    @Autowired
    ReaderRepository readerRepository;
    @GetMapping("/readers")
    public ResponseEntity<List<Reader>> getAllReaders(@RequestParam(required = false) String firstName) {
        try {
            List<Reader> readers = new ArrayList<>();
            if (firstName == null) {
                readers.addAll(readerRepository.findAll());
            } else
                readers.addAll(readerRepository.findByFirstNameContaining(firstName));
            if (readers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(readers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/readers/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable("id") long id) {
        Optional<Reader> readerData = readerRepository.findById(id);
        return readerData.map(reader -> new ResponseEntity<>(reader, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/readers")
    public ResponseEntity<Reader> createReader(@RequestBody Reader reader) {
        try {
            Reader _reader = readerRepository
                    .save(new Reader(reader.getFirstName(),reader.getLastName()));
            return new ResponseEntity<>(_reader, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/readers/{id}")
    public ResponseEntity<Reader> updateReader(@PathVariable("id") long id, @RequestBody Reader reader) {
        Optional<Reader> readerData = readerRepository.findById(id);
        if (readerData.isPresent()) {
            Reader _reader = readerData.get();
            _reader.setFirstName(reader.getFirstName());
            _reader.setLastName(reader.getLastName());

            return new ResponseEntity<>(readerRepository.save(_reader), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/readers/{id}")
    public ResponseEntity<HttpStatus> deleteReader(@PathVariable("id") long id) {
        try {
            readerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/readers")
    public ResponseEntity<HttpStatus> deleteAllReaders() {
        try {
            readerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
}