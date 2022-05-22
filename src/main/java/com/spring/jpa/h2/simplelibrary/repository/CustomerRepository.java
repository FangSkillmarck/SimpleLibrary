package com.spring.jpa.h2.simplelibrary.repository;

import com.spring.jpa.h2.simplelibrary.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
