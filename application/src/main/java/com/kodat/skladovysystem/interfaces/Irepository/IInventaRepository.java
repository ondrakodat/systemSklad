package com.kodat.skladovysystem.interfaces.Irepository;

import com.kodat.skladovysystem.entities.Inventar;

import java.util.List;

public interface IInventaRepository {
    Inventar dejInventarPodleId(long id);
    void upravInentarPodleId(long id);
    void smazInventarPodleId(long id);
    void upravInventarPodleId(long id, Inventar i);
    List<Inventar> dejInventare();
}
