package com.example.demo.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalDto {
	private String rentalId;
	private String movieName;
	private String dateOut;
	private String dateReturned;
	private double dailyRentalRate;

}
