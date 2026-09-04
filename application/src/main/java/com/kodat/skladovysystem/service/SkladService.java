package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.SkladDto;
import com.kodat.skladovysystem.entities.Sklad;
import com.kodat.skladovysystem.interfaces.Irepository.ISkladRepository;
import com.kodat.skladovysystem.interfaces.Iservices.ISkladService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkladService implements ISkladService {
    private final ISkladRepository _IskladRepository;

    public SkladService(ISkladRepository iskladRepository) {
        _IskladRepository = iskladRepository;
    }

    @Override
    public SkladDto dejSkladPodleId(long id) {
        SkladDto dto = new SkladDto();
        return dto;
    }

    @Override
    public List<SkladDto> dejSklady() {
        return null;
    }

    @Override
    public void pridejSklad(SkladDto sklad) {

    }

    @Override
    public void odeberSkladPodleId(long id) {

    }

    @Override
    public void upravSkladPodleID(SkladDto dto, long id) {

    }

    @Override
    public List<SkladDto> najdiPodleNazvu(String nazev) {
        List<Sklad> vysledek = _IskladRepository.najdiSkladyPodleNazvu(nazev);
        List<SkladDto>  vysledekDto = new ArrayList<>();
        for(Sklad s : vysledek){
             vysledekDto.add(upravSkladNaDto(s));
        }
        return vysledekDto;

    }


    private Sklad upravSkladZDto(SkladDto dto){
        return null;
    }

    private SkladDto upravSkladNaDto(Sklad sklad){
        return null;
    }
}
