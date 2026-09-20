package com.kodat.skladovysystem.interfaces.Irepository;

import com.kodat.skladovysystem.entities.Rezervace;
import com.kodat.skladovysystem.entities.Sklad;

import java.util.List;

public interface IRezervaceRepository {
    Rezervace najdiRezervaciPodleId(long id);
    List<Rezervace> dejRezervace();
    void odeberRezervaci(long id);
    void pridejRezervaci(Rezervace rezervace);
    void upravRezervaci(Rezervace rezervace);
}
