package com.ecs.technicaltask.carsweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecs.technicaltask.carsweb.dto.CarsDao;
import com.ecs.technicaltask.carsweb.service.CarsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(CarsController.CARS_RESOURCE)
@Api(value = "Cars Management", description = "Operations pertaining to cars in Car Management System")
public class CarsController {

	public static final String CARS_RESOURCE = "/api/v1/cars";

	@Autowired
	private CarsService carsService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Add a car")
	public ResponseEntity<CarsDao> post(@RequestBody CarsDao car) {
		carsService.addCar(car);
		return new ResponseEntity<>(car, HttpStatus.CREATED);

	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "View a single car", response = CarsDao.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public CarsDao getCar(@PathVariable("id") int id) {

		return carsService.getCar(id);
	}

	@GetMapping()
	@ApiOperation(value = "View a list of available cars", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public List<CarsDao> getAllCars() {
		return carsService.getAllCars();
	}

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Delete the car", response = String.class)
	public ResponseEntity<String> deleteHospital(@PathVariable("id") int id) {
		carsService.deleteCar(id);
		return new ResponseEntity<>("Car deleted", HttpStatus.NO_CONTENT);
	}

}
