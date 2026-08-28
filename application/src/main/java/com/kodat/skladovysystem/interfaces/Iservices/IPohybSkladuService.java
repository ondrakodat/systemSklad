package com.kodat.skladovysystem.interfaces.Iservices;


import com.kodat.skladovysystem.Dto.PohybSkladuDto;
import com.kodat.skladovysystem.entities.PohybSkladu;

import java.util.List;

public interface IPohybSkladuService {
    void odeberPohybSkladuDto(long id);
    void pridejPohybSKladuDto(PohybSkladuDto dto);
    void upravPohybSkladuDto(PohybSkladuDto dto, long id);
    List<PohybSkladuDto> vypisPohybySkladuDto();
    PohybSkladuDto dejPohybSkladuDto(long id);
}
