package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.RezervaceDto;
import com.kodat.skladovysystem.entities.Rezervace;
import com.kodat.skladovysystem.interfaces.Irepository.IRezervaceRepository;
import com.kodat.skladovysystem.interfaces.Iservices.IRezervaceService;

import java.util.List;

public class RezervaceService implements IRezervaceService {
    private final IRezervaceRepository _rezervaceRepo;

    public RezervaceService(IRezervaceRepository rezervaceRepo) {
        _rezervaceRepo = rezervaceRepo;
    }

    @Override
    public RezervaceDto najdiRezervaciPodleId(long id) {
        RezervaceDto dto = new RezervaceDto();
        _rezervaceRepo.najdiRezervaciPodleId(id);
        return null;
    }

    @Override
    public List<RezervaceDto> dejRezervace() {
        return List.of();
    }

    @Override
    public void odeberRezervaci(long id) {

    }

    @Override
    public void pridejRezervaci(RezervaceDto rezervace) {

    }

    @Override
    public void upravRezervaci(RezervaceDto rezervace) {

    }

    private RezervaceDto prevedNaRezervaciDto(){
        return null;
    }

    private Rezervace prevedNaRezervaci(){
        return null;
    }

}
