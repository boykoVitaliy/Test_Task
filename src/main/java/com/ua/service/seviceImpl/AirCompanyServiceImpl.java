package com.ua.service.seviceImpl;

import com.ua.DTO.AirCompany.AirCompanyDto;
import com.ua.DTO.AirCompany.AirCompanySaveDto;
import com.ua.Entity.AirCompany;
import com.ua.Entity.Enum.CompanyType;
import com.ua.repository.AirCompanyRepository;
import com.ua.service.AirCompanyService;
import com.ua.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    private final AirCompanyRepository airCompanyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository, ModelMapper modelMapper) {
        this.airCompanyRepository = airCompanyRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<AirCompanyDto> findAllByName(String name) {
        return modelMapper.map(airCompanyRepository.findAllByName(name),
                new TypeToken<List<AirCompanyDto>>(){}.getType());
    }

    @Override
    public List<AirCompanyDto> findById(Long id) {
        return modelMapper.map(airCompanyRepository.findById(id),
                new TypeToken<List<AirCompanyDto>>(){}.getType());
    }

    @Override
    public List<AirCompanyDto> findByCompanyType(CompanyType companyType) {
        return modelMapper.map(airCompanyRepository.findByCompanyType(companyType),
                new TypeToken<List<AirCompanyDto>>(){}.getType());
    }
    @Override
    public AirCompany save(AirCompanySaveDto airCompanySaveDto) {
        return airCompanyRepository.save(modelMapper.map(airCompanySaveDto, AirCompany.class));
    }

    @Override
    public void deleteById(Long id) {
        airCompanyRepository.deleteById(id);
    }

    @Override
    public AirCompany update(Long airCompanyid, AirCompanyDto airCompanyDto)  {
        return airCompanyRepository.findById(airCompanyid).map(airCompany -> {
            airCompany.setId(airCompanyDto.getId());
            airCompany.setName(airCompanyDto.getName());
            return airCompanyRepository.save(airCompany);
        }).orElseThrow(()->new NotFoundException("Not_Found"+ airCompanyid));
    }

}
