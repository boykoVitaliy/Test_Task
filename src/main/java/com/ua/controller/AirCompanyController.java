package com.ua.controller;

import com.ua.DTO.AirCompany.AirCompanyDto;
import com.ua.DTO.AirCompany.AirCompanySaveDto;
import com.ua.Entity.AirCompany;
import com.ua.Entity.Enum.CompanyType;
import com.ua.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AirCompanyController {


    private final AirCompanyService airCompanyService;

    @Autowired
    public AirCompanyController(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;

    }

    @GetMapping("/aircompany/name")
    public List<AirCompanyDto> findAllByName(String name) {
        return airCompanyService.findAllByName(name);
    }

    @GetMapping("/aircompany/companyId")
    public List<AirCompanyDto> findById(Long id) {
        return airCompanyService.findById(id);
    }


    @GetMapping("/aircompany/type")
    public List<AirCompanyDto> findByCompanyType(CompanyType companyType) {
        return airCompanyService.findByCompanyType(companyType);
    }

    @GetMapping("/aircompany")
    public void deleteById(Long id){
        airCompanyService.deleteById(id);
    }

    @PostMapping("/aircompany")
    public AirCompany save(AirCompanySaveDto airCompanySaveDto) {
        return airCompanyService.save(airCompanySaveDto);
    }

    @PutMapping("/aircompany")
    AirCompany update (Long airCompanyid, AirCompanyDto airCompanyDto){
        return airCompanyService.update(airCompanyid,airCompanyDto);
    }
}
