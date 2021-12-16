package com.ua.controller;

import com.ua.DTO.AirCompany.AirCompanyDto;
import com.ua.DTO.AirCompany.AirCompanySaveDto;
import com.ua.Entity.AirCompany;
import com.ua.Entity.Enum.CompanyType;
import com.ua.repository.AirCompanyRepository;
import com.ua.service.AirCompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ua.constants.ResourceMapping.*;

@RestController
public class AirCompanyController {

    private final ModelMapper modelMapper;
    private final AirCompanyService airCompanyService;

    @Autowired
    public AirCompanyController(ModelMapper modelMapper, AirCompanyService airCompanyService) {
        this.modelMapper = modelMapper;
        this.airCompanyService = airCompanyService;

    }

    @GetMapping(AIRCOMPANY + NAME)
    public List<AirCompanyDto> findAllByName(String name) {
        return airCompanyService.findAllByName(name);
    }

    @GetMapping(AIRCOMPANY+TYPE)
    public List<AirCompanyDto> findByCompanyType(CompanyType companyType) {
        return airCompanyService.findByCompanyType(companyType);

    }

    @GetMapping(AIRCOMPANY+DELETE)
    public void deleteById(Long id){
        airCompanyService.deleteById(id);
    }

    @PostMapping(AIRCOMPANY+SAVE)
    public AirCompany save(AirCompanySaveDto airCompanySaveDto) {
        return airCompanyService.save(airCompanySaveDto);
    }

    AirCompany update (Long airCompanyid, AirCompanyDto airCompanyDto){
        return airCompanyService.update(airCompanyid,airCompanyDto);
    }
}
