package com.ecs.technicaltask.carsweb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecs.technicaltask.carsweb.dao.CarsDao;
import com.ecs.technicaltask.carsweb.exception.ApiException;

public class CarsServiceTest {

	CarsService carsSevice = new CarsService();

	@BeforeEach
	public void seup() {
		CarsService.carsMap.clear();
		CarsDao car1 = new CarsDao(1, "Ford", "Fiesta", "blue", "2021");
		CarsDao car2 = new CarsDao(2, "Ford", "Focus", "red", "2018");
		CarsDao car3 = new CarsDao(3, "Ford", "Escort", "white", "2015");
		CarsDao car4 = new CarsDao(4, "Ford", "Mondeo", "white", "2012");
		CarsService.carsMap.put(car1.getId(), car1);
		CarsService.carsMap.put(car2.getId(), car2);
		CarsService.carsMap.put(car3.getId(), car3);
		CarsService.carsMap.put(car4.getId(), car4);
	}

	@Test
	public void testGetAllCars() {
		List<CarsDao> carsList = carsSevice.getAllCars();
		assertTrue(carsList.size() > 0);
	}

	@Test
	public void testAPiException() {
		try {
			CarsService.carsMap.clear();
			carsSevice.getAllCars();
		} catch (ApiException e) {
			assertEquals(e.getMessage(), "In Memory Repository is not initiated. Try Again");
		}

	}

	@Test
	public void testGetCar() {

		CarsDao car = carsSevice.getCar(1);
		assertEquals("Ford", car.getMake());
		assertEquals("Fiesta", car.getModel());
		assertEquals("blue", car.getColour());
		assertEquals("2021", car.getYear());
	}

	@Test
	public void testAddCar() {
		CarsDao car = new CarsDao(5, "Volkswagen", "Golf", "blue", "2019");
		CarsDao car1 = new CarsDao(6, "Volkswagen", "Lavida", "red", "2018");
		CarsDao car2 = carsSevice.addCar(car);
		CarsDao car3 = carsSevice.addCar(car1);
		assertEquals("Volkswagen", car2.getMake());
		assertEquals("Golf", car2.getModel());
		assertEquals("blue", car2.getColour());
		assertEquals("2019", car2.getYear());

		assertEquals("Volkswagen", car3.getMake());
		assertEquals("Lavida", car3.getModel());
		assertEquals("red", car3.getColour());
		assertEquals("2018", car3.getYear());
	}

	@Test
	public void testDeleteCar() {
		carsSevice.deleteCar(2);
		System.out.println("size of hashmap" + CarsService.carsMap.size());
		assertTrue(CarsService.carsMap.size() == 3);

	}

}
