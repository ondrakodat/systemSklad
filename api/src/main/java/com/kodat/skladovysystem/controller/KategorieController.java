package com.kodat.skladovysystem.controller;

import com.kodat.skladovysystem.Dto.KategorieDto;
import com.kodat.skladovysystem.entities.Kategorie;
import com.kodat.skladovysystem.interfaces.Iservices.IKategorieService;
import com.kodat.skladovysystem.service.KategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/kategorie")
public class KategorieController {
    private final IKategorieService _kategorieService;

    public KategorieController(IKategorieService _kategorieService) {
        this._kategorieService = _kategorieService;
    }

    @GetMapping
    public List<KategorieDto> dejKategorie(){
        return _kategorieService.dejKategorie();
    }

    @GetMapping("/{id}")
    public KategorieDto dejKategoriiPodleId(
            @PathVariable long id
    ){
        return _kategorieService.dejKategorieDtoPodleId(id);
    }

    @PutMapping("/{id}")
    public void upravKategorii(
            @RequestBody KategorieDto dto,
            @PathVariable long id){
        _kategorieService.upravKategoriiDto(dto, id);
    }

    @DeleteMapping("/{id}")
    public void odstranKategorii(
           @PathVariable long id){
        _kategorieService.odeberKategoriiDto(id);
    }

    @PostMapping
    public void vytvorKategorii(
           @RequestBody KategorieDto dto){
        _kategorieService.pridejKategorieDto(dto);
    }

}
