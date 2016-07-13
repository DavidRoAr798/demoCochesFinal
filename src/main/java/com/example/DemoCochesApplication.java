package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoCochesApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext context = SpringApplication.run(DemoCochesApplication.class, args);

		PersonaService personaService = context.getBean(PersonaService.class);

		personaService.testPersonas();

		CocheService cochesService = context.getBean(CocheService.class);

		cochesService.testCoches();


	}

}


