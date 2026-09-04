package com.kodat.skladovysystem.controller;

import com.kodat.skladovysystem.Dto.SkladDto;
import com.kodat.skladovysystem.entities.Sklad;
import com.kodat.skladovysystem.interfaces.Iservices.ISkladService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sklad")
public class SkladController {
    private final ISkladService _ISkladService;

    public SkladController(ISkladService iSkladService) {
        _ISkladService = iSkladService;
    }

    @GetMapping
    public List<SkladDto> dejSklady(){
        return _ISkladService.dejSklady();
    }

    @GetMapping("/{id}")
    public SkladDto dejSkladPodleId(
           @PathVariable long id){
        return _ISkladService.dejSkladPodleId(id);
    }

    @PutMapping("/{id}")
    public void upravSkladDtoPodleId(
            @PathVariable long id,
            @RequestBody SkladDto dto){
        _ISkladService.upravSkladPodleID(dto, id);
    }

    @DeleteMapping("/{id}")
    public void smazSkladDtoPodleId(
           @PathVariable long id){
        _ISkladService.odeberSkladPodleId(id);
    }

    @PostMapping
    public void pridejSkladDto(
           @RequestBody SkladDto dto){
        _ISkladService.pridejSklad(dto);
    }

    @GetMapping("/hledat")
    public List<SkladDto> najiSkladPodleNazvu(
           @RequestParam String nazev){
        return _ISkladService.najdiPodleNazvu(nazev);
    }


}
