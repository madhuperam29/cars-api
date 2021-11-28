package com.ecs.technicaltask.carsweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.ecs.technicaltask.carsweb.dto.CarsDao;
import com.ecs.technicaltask.carsweb.exception.ApiException;

@Service
public class CarsService {

	private static Map<Integer, CarsDao> carsMap = new HashMap<>();
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

	public List<CarsDao> getAllCars() {
		List<CarsDao> hospitalList = new ArrayList<>();
		carsMap.forEach((k, v) -> hospitalList.add(v));

		return hospitalList;
	}

	public CarsDao getCar(int id) {
		Optional<CarsDao> user = Optional.ofNullable(carsMap.get(id));
		if (!user.isPresent()) {
			throw new ApiException("Car Not Found");
		}

		return user.get();
	}

	public void deleteCar(int id) {
		// This can be improved by adding error handling for not found
		carsMap.remove(id);

	}

}
