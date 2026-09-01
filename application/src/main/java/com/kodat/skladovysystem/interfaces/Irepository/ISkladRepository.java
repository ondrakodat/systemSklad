package com.kodat.skladovysystem.interfaces.Irepository;

import com.kodat.skladovysystem.entities.Sklad;

import java.util.List;

public interface ISkladRepository {
    Sklad najdiSkladPodleId(long id);
    List<Sklad> dejSklady();
    void odeberSklad(long id);
    void pridejSklad(Sklad sklad);
    void upravSklad(Sklad sklad);
}
