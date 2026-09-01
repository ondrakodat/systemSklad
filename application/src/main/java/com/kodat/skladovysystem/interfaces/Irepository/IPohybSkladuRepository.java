package com.kodat.skladovysystem.interfaces.Irepository;

import com.kodat.skladovysystem.entities.PohybSkladu;

import java.util.List;


public interface IPohybSkladuRepository {
    PohybSkladu vypisPohybPodleId(Long id);
    void odeberPohybSkladuPodleId(Long id);
    void upravPohybSkladu(PohybSkladu pohyb);
    List<PohybSkladu> vypisPohybySkladu();
    void vytvorPohybSkladu(PohybSkladu pohyb);
}
