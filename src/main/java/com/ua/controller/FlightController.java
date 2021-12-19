package com.ua.controller;

import com.ua.DTO.FlightDto.FlightDto;
import com.ua.DTO.FlightDto.FlightSaveDto;
import com.ua.Entity.Enum.FlightStatus;
import com.ua.Entity.Flight;
import com.ua.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("flight/status/created")
    public List<FlightDto> findByCreatedAtAndFlightStatus()
     {
        return flightService.findByCreatedAtAndFlightStatus();
    }

    @GetMapping("/flight")
    public void deleteById(Long id) {
        flightService.deleteById(id);
    }

    @PostMapping("/flight")
    public Flight save(FlightSaveDto flightSaveDto){
        return flightService.save(flightSaveDto);
    }

    @GetMapping("/flight/find/status")
    public List<FlightDto> findByFlightStatusCompletedAndFlightStatusDelayed(){
        return flightService.findByFlightStatusCompletedAndFlightStatusDelayed();
    }

    @PutMapping("/flight/statusupdate")
    public Flight updateStatus(Long flightId, FlightStatus flightStatus) {
        return flightService.updateStatus(flightId, flightStatus);
    }
}
