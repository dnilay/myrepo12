package com.example.demo.service;

import com.example.demo.model.Rental;
import com.example.demo.shared.RentalDto;

public interface RentalService {
	
	public Rental createRental(RentalDto rentalDto);

}
