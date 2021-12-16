package com.ua.service.seviceImpl;

import com.ua.DTO.FlightDto.FlightDto;
import com.ua.DTO.FlightDto.FlightSaveDto;
import com.ua.Entity.Enum.FlightStatus;
import com.ua.Entity.Flight;
import com.ua.exception.NotFoundException;
import com.ua.repository.FlightRepository;
import com.ua.service.FlightService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {


    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.flightRepository = flightRepository;
    }


    @Override
    public List<FlightDto> findByCreatedAtAndFlightStatus() {

        Date trueDate = new java.util.Date();
        return modelMapper.map(flightRepository.findByCreatedAtAndFlightStatus(trueDate, FlightStatus.ACTIVE),
                new TypeToken<List<FlightDto>>(){}.getType());
    }

    @Override
    public void deleteById(Long id) {
    flightRepository.deleteById(id);
    }

    @Override
    public Flight save(FlightSaveDto flightSaveDto) {
        Flight flight = modelMapper.map(flightSaveDto, Flight.class);
        flight.setFlightStatus(FlightStatus.PENDING);
        return flightRepository.save(flight);
    }

    @Override
    public List<FlightDto> findByFlightStatusCompletedAndFlightStatusDelayed() {
        return modelMapper.map(flightRepository.findByFlightStatusCompletedAndFlightStatusDelayed(),
                new TypeToken<List<FlightDto>>(){}.getType());
    }

    @Override
    public Flight updateStatus(Long flightId, FlightStatus flightStatus) {
        Date rightDate = new java.util.Date();
        if(flightStatus.equals(FlightStatus.DELAYED)){
            return flightRepository.findById(flightId).map(flight -> {
                flight.setFlightStatus(flightStatus);
                flight.setDelayStartedAt(rightDate);
                return flightRepository.save(flight);
            }).orElseThrow(()->new NotFoundException("Not_Found_Id"+flightId));
        }
        else if(flightStatus.equals(FlightStatus.ACTIVE)){
            return flightRepository.findById(flightId).map(flight -> {
                flight.setFlightStatus(flightStatus);
                flight.setEstimatedFlightTime(flight.getEstimatedFlightTime());
                return flightRepository.save(flight);
            }).orElseThrow(()->new NotFoundException("Not_Foud_Id"+flightId));
        }
        else if(flightStatus.equals(FlightStatus.COMPLETED)){
            return flightRepository.findById(flightId).map(flight -> {
                flight.setFlightStatus(flightStatus);
                flight.setEndedAt(rightDate);
                return flightRepository.save(flight);
            }).orElseThrow(()->new NotFoundException("Not_Found_Id"+flightId));

        }
        else if (flightStatus.equals(FlightStatus.PENDING)) {
            throw new NotFoundException("Not Found Flight or Id"+flightId);
        } else {
            throw new NotFoundException("Not Found Flight or Id"+flightId);
        }
    }
}
