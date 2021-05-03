package com.example.demo.bootstrap;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.example.demo.dao.RentalRepository;
import com.example.demo.model.Rental;

@Component
@EnableAutoConfiguration
public class RentalData implements CommandLineRunner {
	
private RentalRepository rentalRepository;


private static final Logger LOGGER = LoggerFactory.getLogger(RentalData.class);

	public RentalData(RentalRepository rentalRepository) {
	super();
	this.rentalRepository = rentalRepository;
}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("entering into bootstrap");
		
		rentalRepository.save(Rental.builder().rentalId(UUID.randomUUID().toString()).movieName("Movie-1").dateOut("01-04-2021").dateReturned("02-04-2021").dailyRentalRate(1).build());
		
		rentalRepository.save(Rental.builder().rentalId(UUID.randomUUID().toString()).movieName("Movie-2").dateOut("02-04-2021").dateReturned("03-04-2021").dailyRentalRate(1.2).build());
		
		rentalRepository.save(Rental.builder().rentalId(UUID.randomUUID().toString()).movieName("Movie-3").dateOut("03-04-2021").dateReturned("04-04-2021").dailyRentalRate(1.1).build());
		
		rentalRepository.save(Rental.builder().rentalId(UUID.randomUUID().toString()).movieName("Movie-4").dateOut("04-04-2021").dateReturned("05-04-2021").dailyRentalRate(1).build());
		
		rentalRepository.save(Rental.builder().rentalId(UUID.randomUUID().toString()).movieName("Movie-5").dateOut("05-04-2021").dateReturned("06-04-2021").dailyRentalRate(2).build());
		LOGGER.info("bootstraping done");
	}

}
