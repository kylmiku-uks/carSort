package com.rentalcars.carSort;

import com.rentalcars.carSort.rest.SearchResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class CarSortApplication {

	private static DataStorage db;
	private static Reporter reporter;

	public static void main(String[] args) {
		db = DataStorage.getInstance();
		reporter = new Reporter();
		SpringApplication.run(CarSortApplication.class, args);

		reporter.reportFullSpecs(db.getVehicles());
		reporter.reportByPrice(db.getByPrice());
		reporter.reportByBestSupplier(db.getByBestSupplier());
		reporter.reportByScore(db.getByScore());
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public DataStorage db() {
		return DataStorage.getInstance();
	}

	@Bean
	CommandLineRunner init(RestTemplate restTemplate, DataStorage db) throws Exception {
		return args -> {
			SearchResponse input = restTemplate.getForObject("http://www.rentalcars.com/js/vehicles.json", SearchResponse.class);
			db.setVehicles(Arrays.asList(input.getSearch().getVehicleList()));
		};
	}
}
