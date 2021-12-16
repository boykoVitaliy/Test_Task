package com.ua.DTO.FlightDto;

import com.ua.Entity.Enum.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSaveDto {

    private String departureCountry;
    private String destinationCountry;
    private Double distance;
    private Date estimatedFlightTime;
    private Date endedAt;
    private Date delayStartedAt;
    private Date createdAt;

}
