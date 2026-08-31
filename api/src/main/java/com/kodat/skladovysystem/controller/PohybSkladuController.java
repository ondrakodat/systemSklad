package com.kodat.skladovysystem.controller;


import com.kodat.skladovysystem.Dto.PohybSkladuDto;
import com.kodat.skladovysystem.interfaces.Iservices.IPohybSkladuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/pohybSkladu")
public class PohybSkladuController {

    private final IPohybSkladuService _pohybSkladuService;

    public PohybSkladuController(IPohybSkladuService pohybSkladuService) {
        _pohybSkladuService = pohybSkladuService;
    }

    @GetMapping("/{id}")
    public PohybSkladuDto dejPohybSkladu(
           @PathVariable long id){
       return _pohybSkladuService.dejPohybSkladuDto(id);
    }

    @DeleteMapping("/{id}")
    public void odstranPohybSkladu(
           @PathVariable long id){
        _pohybSkladuService.odeberPohybSkladuDto(id);
    }
    @GetMapping
    public List<PohybSkladuDto> dejPohybySkladu(){
        return _pohybSkladuService.vypisPohybySkladuDto();
    }
    @PostMapping
    void pridejPohybSkladu(
           @RequestBody PohybSkladuDto dto){
        _pohybSkladuService.pridejPohybSKladuDto(dto);
    }

    @PutMapping
    public void upravPohybSkladu(
           @RequestBody PohybSkladuDto dto,
           @PathVariable long id){
        _pohybSkladuService.upravPohybSkladuDto(dto, id);
    }

}
