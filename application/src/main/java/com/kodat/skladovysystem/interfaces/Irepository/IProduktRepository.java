package com.kodat.skladovysystem.interfaces.Irepository;

import com.kodat.skladovysystem.entities.Produkt;

import java.util.List;

public interface IProduktRepository {
    Produkt najdiPodleId(Long id);
    List<Produkt> najdiVsechny();
    void odeberProduktpodleId (Long id);
    void pridej(Produkt produkt);
}
