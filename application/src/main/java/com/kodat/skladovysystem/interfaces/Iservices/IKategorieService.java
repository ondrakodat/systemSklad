package com.kodat.skladovysystem.interfaces.Iservices;

import com.kodat.skladovysystem.Dto.KategorieDto;
import com.kodat.skladovysystem.entities.Kategorie;

import java.util.List;

public interface IKategorieService {
    void pridejKategorieDto(KategorieDto kategorie);
    void odeberKategoriiDto(long id);
    void upravKategoriiDto(KategorieDto kategorie, Long id);
    List<KategorieDto> dejKategorie();
    KategorieDto dejKategorieDtoPodleId(Long id);
}
