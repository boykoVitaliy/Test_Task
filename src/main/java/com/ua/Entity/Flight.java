package com.ua.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ua.Entity.Enum.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

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
    private Date estimatedFlightTime;

    @Column(nullable = false)
    private Date endedAt;

    @Column(nullable = false)
    private Date delayStartedAt;


    @Column(nullable = false)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private AirCompany airCompany;

    @ManyToOne
    private Airplane airplain;

}
