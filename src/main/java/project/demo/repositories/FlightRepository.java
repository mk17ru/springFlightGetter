package project.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findById(long id);
}