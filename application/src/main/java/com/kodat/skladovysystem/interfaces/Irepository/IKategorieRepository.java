package com.kodat.skladovysystem.interfaces.Irepository;

import com.kodat.skladovysystem.entities.Kategorie;

public interface IKategorieRepository {
    Kategorie najdiKategoriiPodleId(long id);
    Long najdiIdKategorie(Kategorie kategorie);
}
