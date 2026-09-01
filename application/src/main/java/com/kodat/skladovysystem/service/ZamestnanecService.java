package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.ZamestnanecDto;
import com.kodat.skladovysystem.entities.Zamestnanec;
import com.kodat.skladovysystem.interfaces.Irepository.IZamestnanecRepository;
import com.kodat.skladovysystem.interfaces.Iservices.IZamestnanecService;

import java.util.ArrayList;
import java.util.List;

public class ZamestnanecService implements IZamestnanecService {
    private final IZamestnanecRepository _IZamestnaecRepository;

    public ZamestnanecService(IZamestnanecRepository iZamestnaecRepository) {
        _IZamestnaecRepository = iZamestnaecRepository;
    }

    @Override
    public ZamestnanecDto dejZamestnanceDtoPodleId(long id) {
        ZamestnanecDto dto = new ZamestnanecDto();
        return dto;
    }

    @Override
    public List<ZamestnanecDto> dejZamestnanceDto() {
        List<ZamestnanecDto> dtos = new ArrayList<>();
        for(Zamestnanec z : _IZamestnaecRepository.dejZamestnance()){
            dtos.add(prevedZamestnanceNaDto(z));
        }
        return dtos;
    }

    @Override
    public void odeberZamestnanceDto(long id) {
        _IZamestnaecRepository.odeberZamestnance(id);
    }

    @Override
    public void pridejZamestnanceDto(ZamestnanecDto dto) {
        Zamestnanec z = prevedNaZamestnanceZDto(dto);
        _IZamestnaecRepository.pridejZamestnance(z);
    }

    @Override
    public void upravZamestnanceDto(ZamestnanecDto dto, long id) {
        var existujiciZ = _IZamestnaecRepository.dejZamestnancePodleId(id);
        if(existujiciZ == null)
            throw new RuntimeException("Zamestnanec neexistuje");
        existujiciZ = prevedNaZamestnanceZDto(dto);
        _IZamestnaecRepository.upravZamestnance(existujiciZ);

    }

    private Zamestnanec prevedNaZamestnanceZDto(ZamestnanecDto dto){
        var zamestnanec = new Zamestnanec();
        zamestnanec.setEmail(dto.getEmail());
        zamestnanec.setJmeno(dto.getJmeno());
        zamestnanec.setPrijmeni(dto.getPrijmeni());
        return zamestnanec;
    }

    private ZamestnanecDto prevedZamestnanceNaDto(Zamestnanec zamestnanec){
        var dto = new ZamestnanecDto();
        dto.setEmail(zamestnanec.getEmail());
        dto.setJmeno(zamestnanec.getJmeno());
        dto.setPrijmeni(zamestnanec.getPrijmeni());
        return dto;
    }
}
