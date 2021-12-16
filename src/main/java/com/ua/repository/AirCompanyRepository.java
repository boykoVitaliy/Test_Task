package com.ua.repository;

import com.ua.Entity.AirCompany;
import com.ua.Entity.Enum.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {

    List<AirCompany> findAllByName(String name);
    List<AirCompany> findByCompanyType(CompanyType companyType);

}
