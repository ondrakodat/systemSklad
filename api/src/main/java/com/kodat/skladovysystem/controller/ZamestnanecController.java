package com.kodat.skladovysystem.controller;

import com.kodat.skladovysystem.Dto.ZamestnanecDto;
import com.kodat.skladovysystem.interfaces.Iservices.IZamestnanecService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zamestnanec")
public class ZamestnanecController {
    private final IZamestnanecService _iZamestnanecService;

    public ZamestnanecController(IZamestnanecService iZamestnanecService) {
        _iZamestnanecService = iZamestnanecService;
    }

    @PostMapping
    public void pridejZamestnance(
           @RequestBody ZamestnanecDto dto){
        _iZamestnanecService.pridejZamestnanceDto(dto);
    }

    @DeleteMapping("/{id}")
    public void odeberZamestnance(
           @PathVariable long id){
        _iZamestnanecService.odeberZamestnanceDto(id);
    }

    @GetMapping
    public List<ZamestnanecDto> dejZamestnance(){
        return _iZamestnanecService.dejZamestnanceDto();
    }

    @GetMapping("/{id}")
    public ZamestnanecDto dejZamestnancePodleId(
            @PathVariable long id
    ){
        return _iZamestnanecService.dejZamestnanceDtoPodleId(id);
    }

    @PutMapping("/{id}")
    public void upravZamestnancePodleId(
            @RequestBody ZamestnanecDto dto,
            @PathVariable long id
    ){
        _iZamestnanecService.upravZamestnanceDto(dto, id);
    }

    @GetMapping("/hledat")
    public List<ZamestnanecDto> dejZamestnancePodleNazvu(
           @RequestParam String nazev){
        return _iZamestnanecService.dejZamestnancePodleNazvu(nazev);
    }



}
