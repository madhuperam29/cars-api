package com.ecs.technicaltask.carsweb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ecs.technicaltask.carsweb.dao.CarsDao;
import com.ecs.technicaltask.carsweb.service.CarsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class CarsWebApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	@BeforeEach
	public void seup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		CarsService.carsMap.clear();
		CarsDao car1 = new CarsDao(0, "Ford", "Fiesta", "blue", "2021");
		CarsDao car2 = new CarsDao(1, "Ford", "Focus", "red", "2018");
		CarsDao car3 = new CarsDao(2, "Ford", "Escort", "white", "2015");
		CarsDao car4 = new CarsDao(3, "Ford", "Mondeo", "white", "2012");
		CarsService.carsMap.put(car1.getId(), car1);
		CarsService.carsMap.put(car2.getId(), car2);
		CarsService.carsMap.put(car3.getId(), car3);
		CarsService.carsMap.put(car4.getId(), car4);
	}

	@Test
	void testAddCar_ok() throws Exception {
		CarsDao car = new CarsDao(4, "Volkswagen", "Golf", "blue", "2019");
		byte[] carJson = toJson(car);
		CarsDao car1 = new CarsDao(5, "Volkswagen", "Lavida", "red", "2018");
		byte[] carJson1 = toJson(car1);
		mockMvc.perform(post("/api/v1/cars").content(carJson).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
		mockMvc.perform(post("/api/v1/cars").content(carJson1).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}

	@Test
	void retrievetest_ok() throws Exception {
		testAddCar_ok();
		mockMvc.perform(get("/api/v1/cars/1")).andExpect(status().isOk());
		mockMvc.perform(get("/api/v1/cars/2")).andExpect(status().isOk());

	}

	@Test
	void retrieveNotFoundTest() throws Exception {
		mockMvc.perform(get("/api/v1/cars/8")).andExpect(status().isNotFound());

	}

	@Test
	void retrieveAll_ok() throws Exception {
		testAddCar_ok();
		mockMvc.perform(get("/api/v1/cars")).andExpect(status().isOk());

	}

	@Test
	void testDeleteCar_ok() throws Exception {
		testAddCar_ok();
		mockMvc.perform(
				delete("/api/v1/cars/3").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());

	}

	@Test
	void testDeleteCarNotFound() throws Exception {

		mockMvc.perform(delete("/api/v1/cars/6")).andExpect(status().isNotFound());

	}

	private byte[] toJson(Object r) throws Exception {
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(r).getBytes();
	}

}
