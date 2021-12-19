package com.ua.controller;

import com.ua.DTO.AirplaneDto.AirplaneDto;
import com.ua.DTO.AirplaneDto.AirplaneSaveDto;
import com.ua.Entity.Airplane;
import com.ua.Entity.Enum.AirplaneType;
import com.ua.service.AirplaneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AirplaneController {

    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }


    @GetMapping("airplane/type")
    public List<AirplaneDto> findByAirplaneType(AirplaneType airplaneType){
        return airplaneService.findByAirplaneType(airplaneType);
    }

    @GetMapping("airplane/company")
    public List<AirplaneDto> findByAirCompany(Long airCompanyId) {
        return airplaneService.findByAirCompanyId(airCompanyId);
    }

    @PostMapping("/airplane")
    public Airplane save(Long airCompanyId, AirplaneSaveDto airplaneSaveDto) {
        return airplaneService.save(airCompanyId,airplaneSaveDto);
    }

    @PutMapping("/airplane")
    public Airplane update(Long airCompanyId, AirplaneDto airplaneDto) {
        return airplaneService.update(airCompanyId,airplaneDto);}

    @GetMapping("/airplane")
    public void deleteById(Long id) {
            airplaneService.deleteById(id);
        }
}
