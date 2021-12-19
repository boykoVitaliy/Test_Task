package com.ua.Entity;

import com.ua.Entity.Enum.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
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
        private List<Airplane> airplanes;

    @OneToMany(mappedBy = "airCompany", fetch = FetchType.LAZY)
        private List<Flight> flights;

}
