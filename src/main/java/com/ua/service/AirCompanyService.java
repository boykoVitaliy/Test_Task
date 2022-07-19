package com.ua.service;

import com.ua.DTO.AirCompany.AirCompanyDto;
import com.ua.DTO.AirCompany.AirCompanySaveDto;
import com.ua.DTO.FlightDto.FlightDto;
import com.ua.Entity.AirCompany;
import com.ua.Entity.Enum.CompanyType;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirCompanyService {

    void deleteById(Long id);

    AirCompany update (Long airCompanyid, AirCompanyDto airCompanyDto);
    List<AirCompanyDto> findAllByName(String name);
    List<AirCompanyDto> findByCompanyType(CompanyType companyType);

//    List<AirCompanyDto> findById(Long id);

    AirCompany save (AirCompanySaveDto airCompanySaveDto);

}
