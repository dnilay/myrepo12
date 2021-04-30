package com.example.demo.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Rental;
import com.example.demo.service.RentalService;
import com.example.demo.shared.RentalDto;
import com.example.demo.ui.RentalRequestModel;
import com.example.demo.ui.RentalResponseModel;

@RestController
public class RentalController {
	
	private RentalService rentalService;
	private ModelMapper modelMapper;
	@Autowired
	public RentalController(RentalService rentalService, ModelMapper modelMapper) {
		super();
		this.rentalService = rentalService;
		this.modelMapper = modelMapper;
	}
	
	@PostMapping("/rentals")
	public ResponseEntity<RentalResponseModel> createRental(@RequestBody RentalRequestModel rentalDetails)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		RentalDto dto=modelMapper.map(rentalDetails, RentalDto.class);
		dto.setRentalId(UUID.randomUUID().toString());
		Rental rental=rentalService.createRental(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(rental, RentalResponseModel.class));
	}

}
