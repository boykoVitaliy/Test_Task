package com.ua.DTO.AirplaneDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneFlightDto {

    private Long id;
    private String name;
    private Long factorySerialNumber;

}
