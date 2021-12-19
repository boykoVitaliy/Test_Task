package com.ua.repository;

import com.ua.Entity.Airplane;
import com.ua.Entity.Enum.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    List<Airplane> findByAirplaneType(AirplaneType airplaneType);

    List<Airplane> findByAirCompanyId(Long airCompanyId);


}
