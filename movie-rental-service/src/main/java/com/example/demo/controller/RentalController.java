package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Rental;
import com.example.demo.service.RentalNotFoundException;
import com.example.demo.service.RentalService;
import com.example.demo.shared.RentalDto;
import com.example.demo.ui.ErrorResponse;
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
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleRentalNotFoundException(RentalNotFoundException rnfe)
	{
		ErrorResponse message=new ErrorResponse(rnfe.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@PostMapping("/rentals")
	public ResponseEntity<RentalResponseModel> createRental(@RequestBody RentalRequestModel rentalDetails)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		RentalDto dto=modelMapper.map(rentalDetails, RentalDto.class);
		String str[]=UUID.randomUUID().toString().split("-");
		dto.setRentalId(str[0]);
		Rental rental=rentalService.createRental(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(rental, RentalResponseModel.class));
	}
	
	@GetMapping("/rentals/{rentalId}")
	public ResponseEntity<RentalResponseModel> findRentalByrentalId(@PathVariable("rentalId") String rentalId)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Rental rental=rentalService.findByRentalId(rentalId);
		return new ResponseEntity<RentalResponseModel>(modelMapper.map(rental, RentalResponseModel.class),HttpStatus.OK);
	}
	
	@GetMapping("/rentals")
	public ResponseEntity<List<RentalResponseModel>> displayAll()
	{
		List<RentalResponseModel> responseList=new ArrayList<RentalResponseModel>();
		List<Rental> rentalList=rentalService.displayAllRental();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Iterator<Rental> i=rentalList.iterator();
		
		while(i.hasNext())
		{
			
			responseList.add(modelMapper.map(i.next(), RentalResponseModel.class));
		}
		return ResponseEntity.ok(responseList);
	}
	
	@PutMapping("/rentals/{rentalId}")
	public ResponseEntity<RentalResponseModel> updateRental(@PathVariable("rentalId") String rentalId,@RequestParam("movieName") String movieName)
	{
	
		Rental rental=rentalService.updateRental(rentalId, movieName);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.ok(modelMapper.map(rental, RentalResponseModel.class));
		
	}
	
	
	
	
	
	
	
	
	

}
