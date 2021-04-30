package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Rental;
@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

}
