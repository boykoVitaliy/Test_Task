package com.ua.repository;

import com.ua.Entity.Enum.FlightStatus;
import com.ua.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByCreatedAtAndFlightStatus(Date date, FlightStatus flightStatus);

    @Query(value = "SELECT * from Flight f WHERE f.flight_status='COMPLETED' " +
            "and f.ended_at - f.created_at > f.estimated_flight_time", nativeQuery = true)
    List<Flight> findByFlightStatusCompletedAndFlightStatusDelayed();

}
