package com.example.demo.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalResponseModel {
	private String rentalId;
	private String movieName;
	private String dateOut;
	private String dateReturned;
	private double dailyRentalRate;

}
