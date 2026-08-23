package com.kodat.skladovysystem.interfaces.Iservices;

import com.kodat.skladovysystem.Dto.ProduktDto;

import java.util.List;

public interface IProduktService {
    void pridejProduktDto(ProduktDto produkt);
    ProduktDto najdiPodleId(Long id);
    void OdeberPodleId(Long id);
    List<ProduktDto> najdiVsechny();

}
