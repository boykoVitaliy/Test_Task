package com.ua.DTO.AirCompany;


import com.ua.Entity.Enum.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirCompanyDto {

    private Long id;
    private String name;
    private String foundedAt;

    @Enumerated(value = EnumType.STRING)
    private CompanyType companyType;
}
