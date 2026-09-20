package com.kodat.skladovysystem.interfaces.Iservices;

import com.kodat.skladovysystem.Dto.RezervaceDto;
import com.kodat.skladovysystem.entities.Rezervace;
import com.kodat.skladovysystem.entities.Sklad;

import java.util.List;

public interface IRezervaceService {
    RezervaceDto najdiRezervaciPodleId(long id);
    List<RezervaceDto> dejRezervace();
    void odeberRezervaci(long id);
    void pridejRezervaci(RezervaceDto rezervace);
    void upravRezervaci(RezervaceDto rezervace);
}
