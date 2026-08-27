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
    public void pridejKategorieDto(KategorieDto dto) {
        Kategorie kategorie = prevedNaKategoriiZDto(dto);
        _kategorieRepository.pridejKategorii(kategorie);
    }

    @Override
    public void odeberKategoriiDto(long id) {
        if(_kategorieRepository.najdiKategoriiPodleId(id) == null){
            throw new RuntimeException("Kategorie neexistuje");
        }
        _kategorieRepository.odeberKategorii(id);
    }

    @Override
    public void upravKategoriiDto(KategorieDto dto, Long id) {
        Kategorie kategorie = _kategorieRepository.najdiKategoriiPodleId(id);
        if(kategorie == null){
            throw new RuntimeException("Kategorie neexistuje");
        }
        if(dto.getNadKategorie() != null){
            Kategorie nadKategorie = _kategorieRepository.najdiKategoriiPodleId(dto.getNadKategorie());
            kategorie.setNadkategorie(nadKategorie);
        }
        else{
            kategorie.setNadkategorie(null);
        }
        kategorie.setNazev(dto.getNazev());
        _kategorieRepository.upravKategorii(kategorie);

    }

    @Override
    public List<KategorieDto> dejKategorie() {
        List<Kategorie> kategorie = _kategorieRepository.vypisKategorie();
        List<KategorieDto> dtos = new ArrayList<>();
        for(Kategorie k : kategorie){
            dtos.add(prevedNaKategoriiDto(k));
        }
        return dtos;
    }

    @Override
    public KategorieDto dejKategorieDtoPodleId(Long id) {
        return prevedNaKategoriiDto(_kategorieRepository
                .najdiKategoriiPodleId(id));
    }

    private Kategorie prevedNaKategoriiZDto(KategorieDto dto){
        Kategorie k = new Kategorie();
        k.setNazev(dto.getNazev());
        if(dto.getNadKategorie() != null){
            Kategorie kategorie = _kategorieRepository.najdiKategoriiPodleId(dto.getNadKategorie());
            k.setNadkategorie(kategorie);
        }else if(dto.getNadKategorie() == null){
            k.setNadkategorie(null);
        }
        return k;
    }

    private KategorieDto prevedNaKategoriiDto(Kategorie kategorie){
        KategorieDto dto = new KategorieDto();
        if(kategorie.getNadkategorie() != null){
            dto.setNadKategorie(kategorie.getNadkategorie().getId());
        }else if(kategorie.getNadkategorie() == null){
            dto.setNadKategorie(null);
        }
        dto.setNazev(kategorie.getNazev());
        dto.setId(kategorie.getId());
        return dto;
    }

}
