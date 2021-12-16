package com.ua.Entity;

import com.ua.Entity.Enum.AirplaineType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table(name="airplain")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airplain {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
    private String name;

@Column(nullable = false)
    private Integer numberOfFlights;

@Column(nullable = false)
    private Double flightDistance;

@Column(nullable = false)
    private Double fuelCapacity;

@Column(nullable = false)
    private Long factorySerialNumber;

@Enumerated(value = EnumType.STRING)
    private AirplaineType airplaineType;

@ManyToOne
    private AirCompany airCompany;

@OneToMany(mappedBy = "airplain", fetch = FetchType.LAZY)
    private List<Flight> flights;
}
