package project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import project.demo.domain.Flight;
import project.demo.services.FlightService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	FlightService flightService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/data/data.csv"))) {
			bufferedReader.readLine();
			String line = "";
			while((line = bufferedReader.readLine()) != null) {
				Flight flight = Utils.parseFlightData(line);
				if (flight == null) {
					return;
				}
				flightService.save(flight);
			}
		} catch (IOException exception) {
			System.err.println("No file " + exception.getMessage());
			exception.printStackTrace();
		}
	}


}
