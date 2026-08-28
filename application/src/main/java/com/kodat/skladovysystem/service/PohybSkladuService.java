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
    private final IProduktRepository _IproduktRepository;
    private final ISkladRepository _IskladRepository;
    private final IZamestnanecRepository _IzamestnanecRepository;

    public PohybSkladuService(IPohybSkladuRepository ipohybSkladuRepository, IProduktRepository iproduktRepository, ISkladRepository iskladRepository, IZamestnanecRepository izamestnanecRepository) {
        _IpohybSkladuRepository = ipohybSkladuRepository;
        _IproduktRepository = iproduktRepository;
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
        pohyb.setMnozstvi(dto.getMnozstvi());
        pohyb.setPoznamka(dto.getPoznamka());
        if(_IproduktRepository.najdiPodleId(dto.getProdukt_id()) != null)
        pohyb.setProdukt(_IproduktRepository
                .najdiPodleId(dto
                        .getProdukt_id()));
        else
            throw new RuntimeException("Nenalezen produkt pri mapovani pohybu skladu");

        if(_IskladRepository.najdiSkladPodleId(dto.getSklad_id()) != null)
        pohyb.setSklad(_IskladRepository
                .najdiSkladPodleId(dto
                        .getSklad_id()));
        else
            throw new RuntimeException("Nenalezen sklad pri mapovani pohybu skladu");

        if(_IzamestnanecRepository.dejZamestnancePodleId(dto.getZamestnanec_id()) != null)
        pohyb.setZamestnanec(_IzamestnanecRepository
                .dejZamestnancePodleId(dto
                        .getZamestnanec_id()));
        else
            throw new RuntimeException("Nenalezen zamestnanec pri mapovani pohybu skladu");

        return pohyb;
    }
    private PohybSkladuDto namapujNaPohybSkladuDto(PohybSkladu pohyb){
        PohybSkladuDto dto = new PohybSkladuDto();
        dto.setCisloDokladu(pohyb.getCisloDokladu());
        dto.setDatum(pohyb.getDatum());
        dto.setMnozstvi(pohyb.getMnozstvi());
        dto.setPoznamka(pohyb.getPoznamka());

        if(pohyb.getProdukt() != null)
        dto.setProdukt_id(pohyb
                .getProdukt()
                .getId());
        else
            dto.setProdukt_id(null);

        if(pohyb.getZamestnanec() != null)
        dto.setZamestnanec_id(pohyb
                .getZamestnanec()
                .getId());
        else
            dto.setZamestnanec_id(null);

        if(pohyb.getSklad() != null){
            dto.setSklad_id(pohyb
                    .getSklad()
                    .getId());
        }
        else
            dto.setSklad_id(null);

        return dto;
    }

}
