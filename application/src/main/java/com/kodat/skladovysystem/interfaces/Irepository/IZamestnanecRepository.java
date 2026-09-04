package com.kodat.skladovysystem.interfaces.Irepository;

import com.kodat.skladovysystem.entities.Zamestnanec;

import java.util.List;

public interface IZamestnanecRepository {
    Zamestnanec dejZamestnancePodleId(Long id);
    List<Zamestnanec> dejZamestnance();
    void odeberZamestnance(long id);
    void upravZamestnance(Zamestnanec zamestnanec);
    void pridejZamestnance(Zamestnanec zamestnanec);
    List<Zamestnanec> najdiZamestnancePodleNazvu(String jmeno);
}
