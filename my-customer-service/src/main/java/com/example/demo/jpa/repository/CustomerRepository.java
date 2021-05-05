package com.example.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.jpa.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
