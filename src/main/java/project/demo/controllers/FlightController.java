package project.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.demo.Utils;
import project.demo.domain.Flight;
import project.demo.form.CSVForm;
import project.demo.form.FlightOutForm;
import project.demo.services.FlightService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/view")
public class FlightController {

    private final FlightService flightService;

    public FlightController(@Autowired FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights/{id}")
    public String getFlight(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("flight", FlightOutForm.flightToForm(flightService.findById(id)));
        return "FlightPage";
    }

    @GetMapping("/flight/create")
    public String createFlight(Model model) {
        model.addAttribute("request", new CSVForm());
        return "CreateFlight";
    }

    /**
     * Create new flight by CSV string
     * @param stringFlight CSV format: Id,Origin,Destination,DepartureDate,DepartureTime,ArrivalDate,ArrivalTime,Number
     * @return Flight if success save or null (if flight has already existed or data was uncorrected
     */
    @PostMapping("/flight/create")
    public String saveFlight(@ModelAttribute("request") CSVForm stringFlight, Model model) {
        Flight flight = Utils.parseFlightData(stringFlight.getText().replace("\"", ""));
        if (flight == null) {
            return "ErrorPage";
        }
        if (flightService.findById(flight.id) != null) {
            model.addAttribute("errorId", flight.id);
            return "ErrorPage";
        }
        if (flightService.save(flight) == null) {
            return "ErrorPage";
        }
        return "redirect:/view/flights/" + flight.id;
    }

}
