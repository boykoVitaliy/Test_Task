package com.ua.service;

import com.ua.DTO.FlightDto.FlightDto;
import com.ua.DTO.FlightDto.FlightSaveDto;
import com.ua.Entity.Enum.FlightStatus;
import com.ua.Entity.Flight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {

    List<FlightDto> findByCreatedAtAndFlightStatus();
    void deleteById(Long id);

    Flight save (FlightSaveDto flightSaveDto);
    List<FlightDto> findByFlightStatusCompletedAndFlightStatusDelayed();
    Flight updateStatus (Long flightId, FlightStatus flightStatus);
}
