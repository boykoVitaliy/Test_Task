package com.ua.repository;

import com.ua.Entity.AirCompany;
import com.ua.Entity.Enum.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {

    List<AirCompany> findAllByName(String name);

    Optional<AirCompany> findById(Long id);
    List<AirCompany> findByCompanyType(CompanyType companyType);

}
