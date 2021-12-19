package com.ua.service;

import com.ua.DTO.AirplaneDto.AirplaneDto;
import com.ua.DTO.AirplaneDto.AirplaneSaveDto;
import com.ua.Entity.Airplane;
import com.ua.Entity.Enum.AirplaneType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirplaneService {


    List<AirplaneDto> findByAirplaneType(AirplaneType airplaneType);

    List<AirplaneDto> findByAirCompanyId(Long airCompanyId);

    Airplane save (Long airCompanyId, AirplaneSaveDto airplaneSaveDto);

    Airplane update (Long airCompanyId, AirplaneDto airplaneDto);

    void deleteById(Long id);

}
