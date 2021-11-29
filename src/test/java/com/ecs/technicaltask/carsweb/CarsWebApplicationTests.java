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
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class CarsWebApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	@BeforeEach
	public void seup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testAddCar_ok() throws Exception {
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
	public void retrievetest_ok() throws Exception {
		testAddCar_ok();
		mockMvc.perform(get("/api/v1/cars/4")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(4))
				.andExpect(MockMvcResultMatchers.jsonPath("$.make").value("Volkswagen"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.model").value("Golf"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.year").value("2019"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.colour").value("blue"));
		mockMvc.perform(get("/api/v1/cars/5")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(5))
				.andExpect(MockMvcResultMatchers.jsonPath("$.make").value("Volkswagen"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.model").value("Lavida"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.year").value("2018"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.colour").value("red"));

	}

	@Test
	public void retrieveNotFoundTest() throws Exception {
		mockMvc.perform(get("/api/v1/cars/8")).andExpect(status().isNotFound());

	}

	@Test
	public void retrieveAll_ok() throws Exception {
		testAddCar_ok();
		mockMvc.perform(get("/api/v1/cars")).andExpect(status().isOk());

	}

	@Test
	public void testDeleteCar_ok() throws Exception {
		mockMvc.perform(
				delete("/api/v1/cars/3").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());

	}

	@Test
	public void testDeleteCarNotFound() throws Exception {

		mockMvc.perform(delete("/api/v1/cars/6")).andExpect(status().isNotFound());

	}

	private byte[] toJson(Object r) throws Exception {
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(r).getBytes();
	}

}
