package com.ua.Entity;

import com.ua.Entity.Enum.CompanyType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "air_company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String foundedAt;

    @Enumerated(value = EnumType.STRING)
    private CompanyType companyType;

@OneToMany(mappedBy = "airCompany", fetch = FetchType.LAZY)
    private List<Airplain> airplains;

@ManyToMany
    @JoinTable(name = "service", joinColumns = @JoinColumn(name = "id_air_company", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id_flight", referencedColumnName = "id")
    )
    private List<Flight> flights;

}
