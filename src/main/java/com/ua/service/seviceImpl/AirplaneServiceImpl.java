package com.ua.service.seviceImpl;

import com.ua.DTO.AirplaneDto.AirplaneDto;
import com.ua.DTO.AirplaneDto.AirplaneSaveDto;
import com.ua.Entity.Airplane;
import com.ua.Entity.Enum.AirplaneType;
import com.ua.exception.NotFoundException;
import com.ua.repository.AirCompanyRepository;
import com.ua.repository.AirplaneRepository;
import com.ua.service.AirplaneService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final ModelMapper modelMapper;
    private final AirplaneRepository airplaneRepository;
    private final AirCompanyRepository airCompanyRepository;

    @Autowired
    public AirplaneServiceImpl(ModelMapper modelMapper, AirplaneRepository airplaneRepository, AirCompanyRepository airCompanyRepository) {
        this.modelMapper = modelMapper;
        this.airplaneRepository = airplaneRepository;
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public List<AirplaneDto> findByAirplaneType(AirplaneType airplaneType) {
        return modelMapper.map(airplaneRepository.findByAirplaneType(airplaneType),
                new TypeToken<List<AirplaneDto>>(){}.getType());
    }

    @Override
    public List<AirplaneDto> findByAirCompanyId(Long airCompanyId) {
        return modelMapper.map(airplaneRepository.findByAirCompanyId(airCompanyId),
                new TypeToken<List<AirplaneDto>>(){}.getType());
    }

    @Override
    public Airplane save(Long airCompanyId, AirplaneSaveDto airplaneSaveDto) {
        Airplane airplane = modelMapper.map(airplaneSaveDto, Airplane.class);
        return airCompanyRepository.findById(airCompanyId).map(airCompany->{
            airplane.setAirCompany(airCompany);
            airplane.setAirplaneType(airplaneSaveDto.getAirplaneType());
            return airplaneRepository.save(airplane);
        }).orElseThrow(()->new NotFoundException("Not_Found_Id" + airCompanyId));
    }

    @Override
    public Airplane update(Long airCompanyId, AirplaneDto airplaneDto) {
        Airplane airplane = modelMapper.map(airplaneDto, Airplane.class);

        return airCompanyRepository.findById(airCompanyId).map(airCompany -> {
            return  airplaneRepository.save(airplane);
        }).orElseThrow(()->new NotFoundException("Not_Found_Id"+airCompanyId));
    }

    @Override
    public void deleteById(Long id) {
        airplaneRepository.deleteById(id);
    }
}
