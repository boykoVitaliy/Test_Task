package com.ua.repository;

import com.ua.Entity.AirCompany;
import com.ua.Entity.Airplain;
import com.ua.Entity.Enum.AirplaineType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Type;
import java.util.List;

public interface AirplainRepository extends JpaRepository<Airplain, Long> {

    List<Airplain> findByAirplaineType(AirplaineType airplaineType);

    List<Airplain> findByAirCompanyId(Long airCompanyId);
    void deleteById(Long id);

}
