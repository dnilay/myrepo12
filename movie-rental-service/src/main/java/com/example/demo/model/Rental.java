package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String rentalId;
	private String movieName;
	private String dateOut;
	private String dateReturned;
	private double dailyRentalRate;

}
