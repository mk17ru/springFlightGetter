package project.demo.form;

import project.demo.domain.Flight;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FlightOutForm {
    public String name;
    public String departureTime;
    public String arrivalTime;
    public String number;

    public FlightOutForm(String name, String departureTime, String arrivalTime, String number) {
        this.name = name;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.number = number;
    }

    public static FlightOutForm flightToForm(Flight flight) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        if (flight == null) {
            System.err.println("Can't parse flight");
            return null;
        }
        return new FlightOutForm(
                String.join("-", flight.origin, flight.destination),
                dateFormat.format(flight.departureTime),
                dateFormat.format(flight.arrivalTime),
                flight.number
        );
    }
}
