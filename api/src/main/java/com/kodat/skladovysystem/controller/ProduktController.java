package com.kodat.skladovysystem.controller;


import com.kodat.skladovysystem.Dto.ProduktDto;
import com.kodat.skladovysystem.interfaces.Iservices.IProduktService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/produkty")
@RestController
public class ProduktController {
    private final IProduktService _iProduktService;

    public ProduktController(IProduktService _iProduktService) {
        this._iProduktService = _iProduktService;
    }


    @GetMapping("/{id}")
    public ProduktDto dejProdukt(@PathVariable Long id){
        return _iProduktService.najdiPodleId(id);
    }

    @GetMapping
    public List<ProduktDto> dejVsechny()
    {
        return _iProduktService.najdiVsechny();
    }

    @PutMapping("/{id}")
    public void upravProdukt(
            @RequestBody ProduktDto produktDto,
            @PathVariable Long id
    ){
        _iProduktService.upravProdukt(produktDto, id);
    }

    @DeleteMapping("/{id}")
    public void smazProdukt(
           @PathVariable Long id){
        _iProduktService.odeberPodleId(id);
    }

    @PostMapping
    public void pridejProdukt(
           @RequestBody ProduktDto produkt){
        _iProduktService.pridejProduktDto(produkt);
    }

    @GetMapping("/hledat")
    public List<ProduktDto> dejProduktyPodleNazvu(
           @RequestParam String nazev){
        return _iProduktService.najdiProduktyPodleNazvu(nazev);
    }

}
