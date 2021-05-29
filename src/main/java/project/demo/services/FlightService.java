package project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo.domain.Flight;
import project.demo.repositories.FlightRepository;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight findById(long id) {
        return flightRepository.findById(id);
    }

    public Flight save(Flight flight) {
        if (flight == null) {
            System.err.println("Can't parse flight");
            return null;
        }
        if (findById(flight.id) != null) {
            System.err.println("Can't find flight with id" + flight.id);
            return null;
        }
        return flightRepository.save(flight);
    }
}
