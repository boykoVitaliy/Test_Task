package com.ua.service;

import com.ua.DTO.AirCompany.AirCompanyDto;
import com.ua.DTO.AirCompany.AirCompanySaveDto;
import com.ua.DTO.FlightDto.FlightDto;
import com.ua.Entity.AirCompany;
import com.ua.Entity.Enum.CompanyType;
import javassist.NotFoundException;

import java.util.List;

public interface AirCompanyService {

    void deleteById(Long id);

    AirCompany update (Long airCompanyid, AirCompanyDto airCompanyDto);
    List<AirCompanyDto> findAllByName(String name);
    List<AirCompanyDto> findByCompanyType(CompanyType companyType);

    AirCompany save (AirCompanySaveDto airCompanySaveDto);

}
