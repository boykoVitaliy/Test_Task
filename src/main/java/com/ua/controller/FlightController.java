package com.ua.controller;

import com.ua.DTO.FlightDto.FlightDto;
import com.ua.DTO.FlightDto.FlightSaveDto;
import com.ua.Entity.Enum.FlightStatus;
import com.ua.Entity.Flight;
import com.ua.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static com.ua.constants.ResourceMapping.*;


@RestController
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(FLIGHT + STATUS_CREATED)
    public List<FlightDto> findByCreatedAtAndFlightStatus()
     {
        return flightService.findByCreatedAtAndFlightStatus();
    }

    @GetMapping(FLIGHT+ "/delete/{id}")
    public void deleteById(Long id) {
        flightService.deleteById(id);
    }

    @PostMapping(FLIGHT + "/flight/{id}")
    public Flight save(FlightSaveDto flightSaveDto){
        return flightService.save(flightSaveDto);
    }

    @GetMapping(FLIGHT+STATUS)
    public List<FlightDto> findByFlightStatusCompletedAndFlightStatusDelayed(){
        return flightService.findByFlightStatusCompletedAndFlightStatusDelayed();
    }

    @PostMapping(FLIGHT+"/flight_update/{id}")
    public Flight updateStatus(Long flightId, FlightStatus flightStatus) {
        return flightService.updateStatus(flightId, flightStatus);
    }
}
