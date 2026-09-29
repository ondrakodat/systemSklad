package com.kodat.skladovysystem.interfaces.Iservices;

import com.kodat.skladovysystem.Dto.ZamestnanecDto;
import com.kodat.skladovysystem.entities.Zamestnanec;

import java.util.List;

public interface IZamestnanecService {
    ZamestnanecDto dejZamestnanceDtoPodleId(long id);
    List<ZamestnanecDto> dejZamestnanceDto();
    void odeberZamestnanceDto(long id);
    void pridejZamestnanceDto(ZamestnanecDto dto);
    void upravZamestnanceDto(ZamestnanecDto dto, long id);
    List<ZamestnanecDto> dejZamestnancePodleNazvu(String nazev);
}
