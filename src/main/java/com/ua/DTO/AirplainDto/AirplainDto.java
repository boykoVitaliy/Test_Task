package com.ua.DTO.AirplainDto;

import com.ua.Entity.Enum.AirplaineType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplainDto {

    private Long id;

    private String name;
    private Integer numberOfFlights;
    private Double flightDistance;
    private Double fuelCapacity;
    private Long factorySerialNumber;

    @Enumerated(value = EnumType.STRING)
    private AirplaineType airplaineType;

}
