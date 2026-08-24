package com.kodat.skladovysystem.controller;


import com.kodat.skladovysystem.Dto.ProduktDto;
import com.kodat.skladovysystem.interfaces.Iservices.IProduktService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/api/produkty")
@RestController
public class ProduktController {
    private final IProduktService _iProduktService;

    public ProduktController(IProduktService _iProduktService) {
        this._iProduktService = _iProduktService;
    }

    @RequestMapping("/{id}")
    public ProduktDto dejProdukt(@PathVariable Long id){
        ProduktDto produkt = _iProduktService.najdiPodleId(id);
        if(produkt == null){
            throw new RuntimeException("Produkt se nepodařilo najít");
        }
        return produkt;
    }

    @GetMapping
    public List<ProduktDto> dejVsechny(){
        return _iProduktService.najdiVsechny();
    }


}
