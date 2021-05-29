package project.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Flight {

    @Id
    public Long id;
    public String origin;
    public String destination;
    public Date departureTime;
    public Date arrivalTime;
    public String number;

    public Flight(Long id, String origin, String destination, Date departureTime, Date arrivalTime, String number) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.number = number;
    }

    public Flight() {}
}
