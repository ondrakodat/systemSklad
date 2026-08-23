package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.ProduktDto;
import com.kodat.skladovysystem.entities.Produkt;
import com.kodat.skladovysystem.interfaces.Irepository.IProduktRepository;
import com.kodat.skladovysystem.interfaces.Iservices.IProduktService;
import org.springframework.boot.logging.structured.ElasticCommonSchemaProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduktService implements IProduktService {
    private final IProduktRepository _IproduktRepository;

    public ProduktService(IProduktRepository _IproduktRepository) {
        this._IproduktRepository = _IproduktRepository;
    }

    @Override
    public void pridejProduktDto(ProduktDto produkt) {
        Produkt p = new Produkt();
        p.setNazev(produkt.getNazev());
        p.setPopis(produkt.getPopis());
       // p.setKategorie(produkt.getKategorieId());
        p.setCena(produkt.getCena());
        p.setNakupniCena(produkt.getNakupniCena());
        p.setMinimalniSkladovaneMnozstvi(produkt.getMinimalniSkladovaneMnozstvi());
        p.setEan(produkt.getEan());
        p.setHmotnost(produkt.getHmotnost());

        _IproduktRepository.pridej(p);
    }

    @Override
    public ProduktDto najdiPodleId(Long id) {
        return null;
    }

    @Override
    public void OdeberPodleId(Long id) {

    }

    @Override
    public List<ProduktDto> najdiVsechny() {
        return List.of();
    }
}
