package project.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.demo.Utils;
import project.demo.domain.Flight;
import project.demo.form.FlightInForm;
import project.demo.form.FlightOutForm;
import project.demo.services.FlightService;
import javax.servlet.http.HttpSession;

@RestController
public class FlightRestController {

    private final FlightService flightService;

    public FlightRestController(@Autowired FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Get flight by id
     * @param id flight id
     * @return flight by id
     */
    @GetMapping("/flights/{id}")
    public FlightOutForm getFlight(@PathVariable(value = "id") int id) {
        return FlightOutForm.flightToForm(flightService.findById(id));
    }


    /**
     * Create new flight by JSON
     * @param flightForm Json: Id,Origin,Destination,DepartureDate,DepartureTime,ArrivalDate,ArrivalTime,Number
     * @return Flight if success save or null (if flight has already existed or data was uncorrected
     */
    @PostMapping("/flights")
    public FlightOutForm saveFlight(@RequestBody FlightInForm flightForm) {
        if (flightForm == null) {
            return null;
        }
        Flight flight = flightForm.toFlight();
        if (flight == null) {
            System.err.println("Can't parse flight");
            return null;
        }
        return FlightOutForm.flightToForm(flightService.save(flight));
    }

    /**
     * Create new flight by CSV string
     * @param stringFlight CSV format: Id,Origin,Destination,DepartureDate,DepartureTime,ArrivalDate,ArrivalTime,Number
     * @return Flight if success save or null (if flight has already existed or data was uncorrected
     */
    @PostMapping("/flights/string")
    public Flight saveFlight(@RequestBody String stringFlight) {
        Flight flight = Utils.parseFlightData(stringFlight.replace("\"", ""));
        if (flight == null) {
            return null;
        }
        return flightService.save(flight);
    }
}
