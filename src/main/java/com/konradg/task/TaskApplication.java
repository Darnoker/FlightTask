package com.konradg.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.konradg.task.models.BaggageObject;
import com.konradg.task.models.Cargo;
import com.konradg.task.models.CargoObject;
import com.konradg.task.models.Flight;
import com.konradg.task.services.BaggageObjectService;
import com.konradg.task.services.CargoObjectService;
import com.konradg.task.services.CargoService;
import com.konradg.task.services.FlightService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Bean
	CommandLineRunner flightRunner(FlightService flightService) {
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<List<Flight>> typeReference = new TypeReference<List<Flight>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/JSON/flights.json");
			try{
				List<Flight> flights = objectMapper.readValue(inputStream, typeReference);
				flightService.saveAll(flights);
				System.out.println("Flights saved");
			}catch (IOException e){
				System.out.println("Unable to save flights " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner elementRunner(BaggageObjectService baggageElementService, CargoObjectService cargoElementService) {
		return args -> {
			String cargoPath = "/JSON/cargo.json";
			InputStream is = TaskApplication.class.getResourceAsStream(cargoPath);
			if(is == null) {
				throw new NullPointerException("Cannot find resource file " + cargoPath);
			}
			JSONTokener tokener = new JSONTokener(is);
			JSONArray jsonArray = new JSONArray(tokener);
			for(int i =0; i<jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				JSONArray objectArray = (JSONArray) jsonObject.get("baggage");

				for (int j = 0; j<objectArray.length(); j++) {
					BaggageObject baggageElement = new BaggageObject();
					JSONObject baggageObject = (JSONObject) objectArray.get(j);

					baggageElement.setWeight(Long.valueOf((Integer)baggageObject.get("weight")));
					baggageElement.setWeightUnit((String) baggageObject.get("weightUnit"));
					baggageElement.setPieces(Long.valueOf((Integer)baggageObject.get("pieces")));

					baggageElementService.save(baggageElement);
				}

				objectArray = (JSONArray) jsonObject.get("cargo");

				for(int j = 0; j<objectArray.length();j++) {
					CargoObject cargoElement = new CargoObject();
					JSONObject cargoObject = (JSONObject) objectArray.get(j);

					cargoElement.setWeight(Long.valueOf((Integer)cargoObject.get("weight")));
					cargoElement.setWeightUnit((String) cargoObject.get("weightUnit"));
					cargoElement.setPieces(Long.valueOf((Integer)cargoObject.get("pieces")));

					cargoElementService.save(cargoElement);
				}
			}
		};
	}

	@Bean
	CommandLineRunner cargoRunner(CargoService cargoService) {
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TypeReference<List<Cargo>> typeReference = new TypeReference<List<Cargo>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/JSON/cargo.json");
			try{
				List<Cargo> cargos = objectMapper.readValue(inputStream, typeReference);
				cargoService.saveAll(cargos);
				System.out.println("Cargos saved");
			}catch (IOException e){
				System.out.println("Unable to save cargos " + e.getMessage());
			}
		};
	}

}
