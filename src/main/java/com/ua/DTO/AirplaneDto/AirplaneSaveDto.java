package com.ua.DTO.AirplaneDto;

import com.ua.Entity.Enum.AirplaneType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneSaveDto {

    @NotNull
    private String name;
    @NotNull
    private Integer numberOfFlights;
    @NotNull
    private Double flightDistance;
    @NotNull
    private Double fuelCapacity;
    @NotNull
    private Long factorySerialNumber;

    @Enumerated(value = EnumType.STRING)
    private AirplaneType airplaneType;


}
