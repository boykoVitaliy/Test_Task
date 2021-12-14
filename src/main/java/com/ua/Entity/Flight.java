package com.ua.Entity;


import com.ua.Entity.Enum.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String departureCountry;

    @Column(nullable = false)
    private String destinationCountry;

    @Column(nullable = false)
    private Double distance;

    @Column(nullable = false)
    private Double estimatedFlightTime;

    @Column(nullable = false)
    private Double endedAt;

    @Column(nullable = true)
    private Double delayStartedAt;

    @Column(nullable = false)
    private Double createdAt;

    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "flights")
    private List<AirCompany> airCompanies;

}
