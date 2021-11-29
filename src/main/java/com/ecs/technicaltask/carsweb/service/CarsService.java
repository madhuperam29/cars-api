package com.ecs.technicaltask.carsweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.ecs.technicaltask.carsweb.dao.CarsDao;
import com.ecs.technicaltask.carsweb.exception.ApiException;
import com.ecs.technicaltask.carsweb.exception.ApiNotFoundException;

@Service
public class CarsService {

	public static Map<Integer, CarsDao> carsMap = new HashMap<>();
	private static AtomicInteger idGen = new AtomicInteger();

	static {
		// These are default entries inserted for retrieval without any new additions
		CarsDao car1 = new CarsDao(idGen.getAndIncrement(), "Ford", "Fiesta", "blue", "2021");
		CarsDao car2 = new CarsDao(idGen.getAndIncrement(), "Ford", "Focus", "red", "2018");
		CarsDao car3 = new CarsDao(idGen.getAndIncrement(), "Ford", "Escort", "white", "2015");
		CarsDao car4 = new CarsDao(idGen.getAndIncrement(), "Ford", "Mondeo", "white", "2012");
		carsMap.put(car1.getId(), car1);
		carsMap.put(car2.getId(), car2);
		carsMap.put(car3.getId(), car3);
		carsMap.put(car4.getId(), car4);
	}

	public CarsDao addCar(CarsDao car) {

		car.setId(idGen.getAndIncrement());
		carsMap.put(car.getId(), car);
		return car;

	}

	public List<CarsDao> getAllCars() throws ApiException {
		List<CarsDao> carsList = new ArrayList<>();
		if (carsMap.isEmpty()) {
			throw new ApiException("In Memory Repository is not initiated. Try Again");
		} else {
			carsMap.forEach((k, v) -> carsList.add(v));
			return carsList;
		}
	}

	public CarsDao getCar(int id) {
		Optional<CarsDao> car = Optional.ofNullable(carsMap.get(id));
		if (!car.isPresent()) {
			throw new ApiNotFoundException("Car Not Found");
		}

		return car.get();
	}

	public void deleteCar(int id) {
		Optional<CarsDao> car = Optional.ofNullable(carsMap.get(id));
		if (!car.isPresent()) {
			throw new ApiNotFoundException("Car Not Found to delete. Pass the right car ID");
		} else
			carsMap.remove(id);

	}

}
