package com.ua.service;

import com.ua.DTO.AirplainDto.AirplainDto;
import com.ua.DTO.AirplainDto.AirplaineSaveDto;
import com.ua.Entity.AirCompany;
import com.ua.Entity.Airplain;
import com.ua.Entity.Enum.AirplaineType;

import java.util.List;

public interface AirplainService {


    List<AirplainDto> findByAirplaineType(AirplaineType airplaineType);

    List<AirplainDto> findByAirCompanyId(Long airCompanyId);

    Airplain save (Long airCompanyId, AirplaineSaveDto airplaineSaveDto);

    Airplain update (Long airCompanyId, AirplainDto airplainDto);

    void deleteById(Long id);

}
