package com.ua.DTO.AirCompany;

import com.ua.Entity.Enum.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirCompanySaveDto {

//    @NotNull
    private String name;
//    @NotNull
    private String foundedAt;

    @Enumerated(value = EnumType.STRING)
    private CompanyType companyType;

}
