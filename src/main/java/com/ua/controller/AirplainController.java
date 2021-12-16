package com.ua.controller;

import com.ua.DTO.AirplainDto.AirplainDto;
import com.ua.DTO.AirplainDto.AirplaineSaveDto;
import com.ua.Entity.AirCompany;
import com.ua.Entity.Airplain;
import com.ua.Entity.Enum.AirplaineType;
import com.ua.service.AirCompanyService;
import com.ua.service.AirplainService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ua.constants.ResourceMapping.*;

@RestController
public class AirplainController {

    private final AirplainService airplainService;
    private final ModelMapper modelMapper;
    private final AirCompanyService airCompanyService;

    public AirplainController(AirplainService airplainService, ModelMapper modelMapper, AirCompanyService airCompanyService) {
        this.airplainService = airplainService;
        this.modelMapper = modelMapper;
        this.airCompanyService = airCompanyService;
    }

    @GetMapping(AIRPLAIN)
    public List<AirplainDto> findByAirplaineType(AirplaineType airplaineType){
        return airplainService.findByAirplaineType(airplaineType);
    }

    @GetMapping(AIRPLAIN+NAME)
    public List<AirplainDto> findByAirCompany(Long airCompanyId) {
        return airplainService.findByAirCompanyId(airCompanyId);
    }

    @PostMapping(AIRPLAIN +"/airplain/{Id}")
    public Airplain save(Long airCompanyId, AirplaineSaveDto airplaineSaveDto) {
        return airplainService.save(airCompanyId,airplaineSaveDto);
    }

    @PostMapping(AIRPLAIN+ "/airplain{Id}")
    public Airplain update(Long airCompanyId, AirplainDto airplainDto) {
        return airplainService.update(airCompanyId,airplainDto);}

    @PostMapping(AIRPLAIN+ "/delete/{Id}")
    public void deleteById(Long id) {
            airplainService.deleteById(id);
        }
}
