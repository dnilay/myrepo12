package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RentalRepository;
import com.example.demo.model.Rental;
import com.example.demo.shared.RentalDto;
@Service
public class RentalServiceImpl implements RentalService {

	private RentalRepository rentalRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public RentalServiceImpl(RentalRepository rentalRepository, ModelMapper modelMapper) {
		super();
		this.rentalRepository = rentalRepository;
		this.modelMapper = modelMapper;
	}


	@Override
	public Rental createRental(RentalDto rentalDto) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Rental rental=modelMapper.map(rentalDto, Rental.class);
		return rentalRepository.save(rental);
	}

}
