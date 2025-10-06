package com.GeorgeDavidDAM2.festify_apiEdu;

import org.springframework.boot.SpringApplication;

public class TestFestifyApiEduApplication {

	public static void main(String[] args) {
		SpringApplication.from(FestifyApiEduApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
