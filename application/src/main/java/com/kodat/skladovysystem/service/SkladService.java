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
        List<SkladDto> dtos = new ArrayList<>();
        for(Sklad s : _IskladRepository.dejSklady()){
           dtos.add(upravSkladNaDto(s));
        }
        return dtos;
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
        Sklad s = new Sklad();
        s.setId(dto.getId());
        s.setNazev(dto.getNazev());
        s.setMesto(dto.getMesto());
        return s;
    }

    private SkladDto upravSkladNaDto(Sklad sklad){
        SkladDto s = new SkladDto();
        s.setId(sklad.getId());
        s.setNazev(sklad.getNazev());
        s.setMesto(sklad.getMesto());
        return s;
    }
}
