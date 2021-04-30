package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Rental;
import com.example.demo.shared.RentalDto;

public interface RentalService {
	
	public Rental createRental(RentalDto rentalDto);
	public Rental findByRentalId(String rentalId);
	public List<Rental> displayAllRental();
	
	public Rental updateRental(String rentalId,String movieName);

}
