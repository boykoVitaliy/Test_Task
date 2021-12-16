package com.ua.repository;

import com.ua.Entity.Enum.FlightStatus;
import com.ua.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

//
//    List<Flight> findAllByFlightStatus(FlightStatus flightStatus);
//
//
//    List<Flight> findByDistance(Double distance);

    List<Flight> findByCreatedAtAndFlightStatus(Date date, FlightStatus flightStatus);
    List<Flight> findByFlightStatusCompletedAndFlightStatusDelayed();

}
