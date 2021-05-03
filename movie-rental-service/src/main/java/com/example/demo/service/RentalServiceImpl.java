package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RentalRepository;
import com.example.demo.model.Rental;
import com.example.demo.shared.RentalDto;
@Service
public class RentalServiceImpl implements RentalService {

	private RentalRepository rentalRepository;
	private ModelMapper modelMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RentalServiceImpl.class);

	@Autowired
	public RentalServiceImpl(RentalRepository rentalRepository, ModelMapper modelMapper) {
		super();
		this.rentalRepository = rentalRepository;
		this.modelMapper = modelMapper;
		LOGGER.info("di for repo and modelmapper is done");
	}


	@Override
	public Rental createRental(RentalDto rentalDto) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Rental rental=modelMapper.map(rentalDto, Rental.class);
		return rentalRepository.save(rental);
	}


	@Override
	public Rental findByRentalId(String rentalId) {
		// TODO Auto-generated method stub
		
		Rental rental=rentalRepository.findByRentalId(rentalId);
		if((rental==null))
		{
			throw new RentalNotFoundException("rental not found with the rentalId: "+rentalId);
		}
		
		return rentalRepository.findByRentalId(rentalId);
	}


	@Override
	public List<Rental> displayAllRental() {
		// TODO Auto-generated method stub
		return rentalRepository.findAll();
	}


	@Override
	public Rental updateRental(String rentalId,String movieName) {
		Rental rental=rentalRepository.findByRentalId(rentalId);
		if(rental==null)
		{
			throw new RentalNotFoundException("id not found");
		}
		rental.setMovieName(movieName);
		rentalRepository.save(rental);
		return rental;
	}


	@Override
	public Rental deleteRental(String rentalId) {
		// TODO Auto-generated method stub
		Rental rental=rentalRepository.findByRentalId(rentalId);
		if(rental==null)
		{
			throw new RentalNotFoundException("id not found");
		}
		rentalRepository.delete(rental);
		return rental;
	}

}
