package com.ua.DTO.FlightDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSaveDto {

    @NotNull
    private String departureCountry;
    @NotNull
    private String destinationCountry;
    @NotNull
    private Double distance;
    @NotNull
    private Date estimatedFlightTime;
    @NotNull
    private Date endedAt;
    @NotNull
    private Date delayStartedAt;
    @NotNull
    private Date createdAt;

}
