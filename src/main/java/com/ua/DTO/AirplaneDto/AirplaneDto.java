package com.ua.DTO.AirplaneDto;

import com.ua.Entity.Enum.AirplaneType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneDto {

    private Long id;

    private String name;
    private Integer numberOfFlights;
    private Double flightDistance;
    private Double fuelCapacity;
    private Long factorySerialNumber;

    @Enumerated(value = EnumType.STRING)
    private AirplaneType airplaineType;

}
