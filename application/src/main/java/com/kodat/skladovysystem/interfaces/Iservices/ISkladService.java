package com.kodat.skladovysystem.interfaces.Iservices;

import com.kodat.skladovysystem.Dto.SkladDto;
import com.kodat.skladovysystem.entities.Sklad;

import java.util.List;

public interface ISkladService {
    SkladDto dejSkladPodleId(long id);
    List<SkladDto> dejSklady();
    void pridejSklad(SkladDto sklad);
    void odeberSkladPodleId(long id);
    void upravSkladPodleID(SkladDto dto, long id);
}
