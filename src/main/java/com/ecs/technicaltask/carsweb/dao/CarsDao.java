package com.ecs.technicaltask.carsweb.dao;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsDao {
	@ApiModelProperty(notes = "The generated user ID")
	private int id;
	@ApiModelProperty(notes = "The make of the car")
	private String make;
	@ApiModelProperty(notes = "The model of the car")
	private String model;
	@ApiModelProperty(notes = "The colour of the car")
	private String colour;
	@ApiModelProperty(notes = "The year car manufactured")
	private String year;

}
