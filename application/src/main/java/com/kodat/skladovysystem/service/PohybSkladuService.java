package com.kodat.skladovysystem.service;

import com.kodat.skladovysystem.Dto.PohybSkladuDto;
import com.kodat.skladovysystem.entities.PohybSkladu;
import com.kodat.skladovysystem.interfaces.Irepository.IPohybSkladuRepository;
import com.kodat.skladovysystem.interfaces.Irepository.IProduktRepository;
import com.kodat.skladovysystem.interfaces.Irepository.ISkladRepository;
import com.kodat.skladovysystem.interfaces.Irepository.IZamestnanecRepository;
import com.kodat.skladovysystem.interfaces.Iservices.IPohybSkladuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PohybSkladuService implements IPohybSkladuService {
    private final IPohybSkladuRepository _IpohybSkladuRepository;
    private final IProduktRepository IproduktRepository;
    private final ISkladRepository _IskladRepository;
    private final IZamestnanecRepository _IzamestnanecRepository;

    public PohybSkladuService(IPohybSkladuRepository ipohybSkladuRepository, IProduktRepository iproduktRepository, ISkladRepository iskladRepository, IZamestnanecRepository izamestnanecRepository) {
        _IpohybSkladuRepository = ipohybSkladuRepository;
        IproduktRepository = iproduktRepository;
        _IskladRepository = iskladRepository;
        _IzamestnanecRepository = izamestnanecRepository;
    }


    @Override
    public void odeberPohybSkladuDto(long id) {
        if(_IpohybSkladuRepository.vypisPohybPodleId(id) != null)
            _IpohybSkladuRepository.odeberPohybSkladuPodleId(id);
        else
            throw new RuntimeException("Pohyb skladu neexistuje");
    }

    @Override
    public void pridejPohybSKladuDto(PohybSkladuDto dto) {
        com.kodat.skladovysystem.entities.PohybSkladu pohyb = namapujPohybSkladuZDto(dto);
        _IpohybSkladuRepository.vytvorPohybSkladu(pohyb);
    }

    @Override
    public void upravPohybSkladuDto(PohybSkladuDto dto, long id) {
        PohybSkladu pohyb = _IpohybSkladuRepository.vypisPohybPodleId(id);
        if(pohyb != null){
            _IpohybSkladuRepository.upravPohybSkladu(pohyb);
        }else
            throw new RuntimeException("Pohyb skladu neexistuje");

    }

    @Override
    public List<PohybSkladuDto> vypisPohybySkladuDto() {
        List<PohybSkladu> pohyby = _IpohybSkladuRepository.vypisPohybySkladu();
        List<PohybSkladuDto> dtos = new ArrayList<>();
        for(PohybSkladu pohyb : pohyby){
            dtos.add(namapujNaPohybSkladuDto(pohyb));
        }
        return dtos;
    }

    @Override
    public PohybSkladuDto dejPohybSkladuDto(long id) {
        return namapujNaPohybSkladuDto(_IpohybSkladuRepository
                .vypisPohybPodleId(id));
    }

    private PohybSkladu namapujPohybSkladuZDto(PohybSkladuDto dto){
        PohybSkladu pohyb = new PohybSkladu();
        pohyb.setCisloDokladu(dto.getCisloDokladu());
        pohyb.setDatum(dto.getDatum());
        pohyb.setId(dto.getId());
        pohyb.setMnozstvi(dto.getMnozstvi());
        pohyb.setPoznamka(dto.getPoznamka());
        pohyb.setProdukt(IproduktRepository
                .najdiPodleId(dto
                        .getProdukt_id()));
        pohyb.setSklad(_IskladRepository
                .najdiSkladPodleId(dto
                        .getSklad_id()));
        pohyb.setZamestnanec(_IzamestnanecRepository
                .dejZamestnancePodleId(dto
                        .getZamestnanec_id()));
        return pohyb;
    }
    private PohybSkladuDto namapujNaPohybSkladuDto(PohybSkladu pohyb){
        PohybSkladuDto dto = new PohybSkladuDto();
        return dto;
    }

}
