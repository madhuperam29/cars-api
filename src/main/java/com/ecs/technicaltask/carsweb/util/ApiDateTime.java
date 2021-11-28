package com.ecs.technicaltask.carsweb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ApiDateTime {

	public String getCurrentDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss");
		return sdf.format(new Date());

	}
}
