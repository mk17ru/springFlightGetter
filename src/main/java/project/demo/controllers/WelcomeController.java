package project.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.demo.form.FlightOutForm;

@Controller
public class WelcomeController {

    @GetMapping(value={"/", ""})
    public String getFlight() {
        return "WelcomePage";
    }
}
