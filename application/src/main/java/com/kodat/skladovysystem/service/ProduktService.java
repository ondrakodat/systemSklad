package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.ProduktDto;
import com.kodat.skladovysystem.entities.Kategorie;
import com.kodat.skladovysystem.entities.Produkt;
import com.kodat.skladovysystem.interfaces.Irepository.IKategorieRepository;
import com.kodat.skladovysystem.interfaces.Irepository.IProduktRepository;
import com.kodat.skladovysystem.interfaces.Iservices.IProduktService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduktService implements IProduktService {
    private final IProduktRepository _IproduktRepository;
    private final IKategorieRepository _IkategorieRepository;


    public ProduktService(IProduktRepository _IproduktRepository, IKategorieRepository _IkategorieRepository) {
        this._IproduktRepository = _IproduktRepository;
        this._IkategorieRepository = _IkategorieRepository;
    }

    @Override
    public void pridejProduktDto(ProduktDto produkt) {
        Produkt p = new Produkt();

        p.setNazev(produkt.getNazev());
        p.setPopis(produkt.getPopis());
        Long id = produkt.getKategorieId();
        Kategorie kategorie = _IkategorieRepository.najdiKategoriiPodleId(id);
        p.setKategorie(kategorie);
        p.setCena(produkt.getCena());
        p.setNakupniCena(produkt.getNakupniCena());
        p.setMinimalniSkladovaneMnozstvi(produkt.getMinimalniSkladovaneMnozstvi());
        p.setEan(produkt.getEan());
        p.setHmotnost(produkt.getHmotnost());

        _IproduktRepository.pridej(p);
    }

    @Override
    public ProduktDto najdiPodleId(Long id) {

        Produkt p = _IproduktRepository.najdiPodleId(id);

        if(p == null){
            return null;
        }

        ProduktDto produkt = new ProduktDto();

        produkt.setNazev(p.getNazev());
        if(p.getPopis() == null){
            produkt.setPopis("");
        }else{
            produkt.setPopis(p.getPopis());
        }
        produkt.setCena(p.getCena());
        produkt.setNakupniCena(p.getNakupniCena());
        produkt.setHmotnost(p.getHmotnost());
        produkt.setMinimalniSkladovaneMnozstvi(p.getMinimalniSkladovaneMnozstvi());
        if(p.getKategorie() != null) {
            produkt.setKategorieId(p.getKategorie().getId());
        }
        return produkt;
    }

    @Override
    public void OdeberPodleId(Long id) {
        _IproduktRepository.odeberProduktpodleId(id);
    }

    @Override
    public List<ProduktDto> najdiVsechny() {
       List<Produkt> produkty = _IproduktRepository.najdiVsechny();
       List<ProduktDto> produktyDto = new ArrayList<>();
       for (Produkt p : produkty){
           ProduktDto produktD = new ProduktDto();
           produktD.setNazev(p.getNazev());
           String popis = p.getPopis();
           if(popis != null){
               produktD.setPopis(popis);
           }else{
               produktD.setPopis("");
           }
           produktD.setCena(p.getCena());
           produktD.setNakupniCena(p.getNakupniCena());
           produktD.setMinimalniSkladovaneMnozstvi(p.getMinimalniSkladovaneMnozstvi());
           produktD.setEan(p.getEan());
           produktD.setHmotnost(p.getHmotnost());
           produktD.setKategorieId(p.getKategorie().getId());
           produktyDto.add(produktD);

       }
       return produktyDto;
    }
}
