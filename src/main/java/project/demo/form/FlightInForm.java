package project.demo.form;

import project.demo.Utils;
import project.demo.domain.Flight;
import javax.persistence.Id;
import java.text.ParseException;
import java.util.Date;

public class FlightInForm {
    @Id
    public Long id;
    public String origin;
    public String destination;
    public String departureDate;
    public String departureTime;
    public String arrivalDate;
    public String arrivalTime;
    public String number;

    public FlightInForm(Long id, String origin, String destination, String departureDate, String departureTime,
                                            String arrivalDate, String arrivalTime, String number) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.number = number;
    }

    public Flight toFlight() {
        try {
            return new Flight(
                this.id, this.origin, this.destination,
                    Utils.dateFormat(this.departureDate + departureTime),
                    Utils.dateFormat(this.arrivalDate + this.arrivalTime),
                    this.number
            );
        }  catch (ParseException parseException) {
            System.err.println("Can't parse " + parseException.getMessage());
            return null;
        }
    }
}
