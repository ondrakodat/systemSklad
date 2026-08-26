package com.kodat.skladovysystem.interfaces.Irepository;

import com.kodat.skladovysystem.entities.Kategorie;

import java.util.List;

public interface IKategorieRepository {
    Kategorie najdiKategoriiPodleId(long id);
    void pridejKategorii(Kategorie kategorie);
    void odeberKategorii(Long id);
    void upravKategorii(Kategorie kategorie);
    List<Kategorie> vypisKategorie();
}
