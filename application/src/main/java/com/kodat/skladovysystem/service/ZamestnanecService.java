package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.ZamestnanecDto;
import com.kodat.skladovysystem.entities.Zamestnanec;
import com.kodat.skladovysystem.interfaces.Irepository.IZamestnanecRepository;
import com.kodat.skladovysystem.interfaces.Iservices.IZamestnanecService;

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
        return List.of();
    }

    @Override
    public void odeberZamestnanceDto(long id) {
        _IZamestnaecRepository.odeberZamestnance(id);
    }

    @Override
    public void pridejZamestnanceDto(ZamestnanecDto dto) {

    }

    @Override
    public void upravZamestnanceDto(ZamestnanecDto dto, long id) {

    }

    private Zamestnanec prevedNaZamestnanceZDto(ZamestnanecDto dto){
        var zamestnanec = new Zamestnanec();
        return zamestnanec;
    }

    private ZamestnanecDto prevedZamestnanceNaDto(Zamestnanec zamestnanec){
        var dto = new ZamestnanecDto();
        return dto;
    }
}
