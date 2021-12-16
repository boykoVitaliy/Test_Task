package com.ua.service.seviceImpl;

import com.ua.DTO.AirplainDto.AirplainDto;
import com.ua.DTO.AirplainDto.AirplaineSaveDto;
import com.ua.Entity.AirCompany;
import com.ua.Entity.Airplain;
import com.ua.Entity.Enum.AirplaineType;
import com.ua.exception.NotFoundException;
import com.ua.repository.AirCompanyRepository;
import com.ua.repository.AirplainRepository;
import com.ua.service.AirplainService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplainServiceImol implements AirplainService {

    private final ModelMapper modelMapper;
    private final AirplainRepository airplainRepository;
    private final AirCompanyRepository airCompanyRepository;

    @Autowired
    public AirplainServiceImol(ModelMapper modelMapper, AirplainRepository airplainRepository, AirCompanyRepository airCompanyRepository) {
        this.modelMapper = modelMapper;
        this.airplainRepository = airplainRepository;
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public List<AirplainDto> findByAirplaineType(AirplaineType airplaineType) {
        return modelMapper.map(airplainRepository.findByAirplaineType(airplaineType),
                new TypeToken<List<AirplainDto>>(){}.getType());
    }

    @Override
    public List<AirplainDto> findByAirCompanyId(Long airCompanyId) {
        return modelMapper.map(airplainRepository.findByAirCompanyId(airCompanyId),
                new TypeToken<List<AirplainDto>>(){}.getType());
    }

    @Override
    public Airplain save(Long airCompanyId, AirplaineSaveDto airplaineSaveDto) {
        Airplain airplain = modelMapper.map(airplaineSaveDto, Airplain.class);
        return airCompanyRepository.findById(airCompanyId).map(airCompany->{
            airplain.setAirCompany(airCompany);
            return airplainRepository.save(airplain);
        }).orElseThrow(()->new NotFoundException("Not_Found_Id" + airCompanyId));
    }

    @Override
    public Airplain update(Long airCompanyId, AirplainDto airplainDto) {
        Airplain airplain = modelMapper.map(airplainDto, Airplain.class);

        return airCompanyRepository.findById(airCompanyId).map(airCompany -> {
            return airplainRepository.save(airplain);
        }).orElseThrow(()->new NotFoundException("Not_Found_Id"+airCompanyId));
    }

    @Override
    public void deleteById(Long id) {
        airplainRepository.deleteById(id);
    }
}
