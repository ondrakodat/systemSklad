package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.KategorieDto;
import com.kodat.skladovysystem.entities.Kategorie;
import com.kodat.skladovysystem.interfaces.Irepository.IKategorieRepository;
import com.kodat.skladovysystem.interfaces.Iservices.IKategorieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KategorieService implements IKategorieService {
    private final IKategorieRepository _kategorieRepository;

    public KategorieService(IKategorieRepository _kategorieRepository) {
        this._kategorieRepository = _kategorieRepository;
    }

    @Override
    public void pridejKategorieDto(KategorieDto kategorie) {

    }

    @Override
    public void odeberKategoriiDto(long id) {
        Kategorie k = _kategorieRepository.najdiKategoriiPodleId(id);
        if(k == null){
            throw new RuntimeException("Kategorie neexistuje");
        }
        _kategorieRepository.odeberKategorii(id);
    }

    @Override
    public void upravKategoriiDto(KategorieDto kategorie, Long id) {
        Kategorie k = prevedZDto(kategorie);
        _kategorieRepository.upravKategorii(k);
    }

    @Override
    public List<KategorieDto> dejKategorie() {
        List<Kategorie> kategories = _kategorieRepository.vypisKategorie();
        List<KategorieDto> kategorieDto = new ArrayList<>();
        for (Kategorie k : kategories){
               kategorieDto.add(prevedNaDto(k));
        }
        return kategorieDto;
    }

    @Override
    public KategorieDto dejKategorieDtoPodleId(Long id) {
        return null;
    }

    private Kategorie prevedZDto(KategorieDto kategorie){
        Kategorie k = _kategorieRepository.najdiKategoriiPodleId(kategorie.getId());
        if(k == null){
            throw  new RuntimeException("Kategorie neexistuje");
        }
        if(kategorie.getNadKategorie() == null){
            k.setNadkategorie(null);
        }else{
            Kategorie nadKategorie = _kategorieRepository.najdiKategoriiPodleId(kategorie.getNadKategorie());
            k.setNadkategorie(nadKategorie);
        }
        k.setNazev(kategorie.getNazev());
        return k;
    }

    private KategorieDto prevedNaDto(Kategorie kategorie){
        KategorieDto k = new KategorieDto();
        k.setId(kategorie.getId());
        k.setNazev(k.getNazev());
        Long idKategorie = kategorie.getNadkategorie().getId();
        k.setNadKategorie(idKategorie);
        return k;
    }

}
