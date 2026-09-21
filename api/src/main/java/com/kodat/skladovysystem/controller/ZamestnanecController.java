package com.kodat.skladovysystem.controller;

import com.kodat.skladovysystem.Dto.ZamestnanecDto;
import com.kodat.skladovysystem.email.EmailService;
import com.kodat.skladovysystem.emailEntity.EmailDetails;
import com.kodat.skladovysystem.interfaces.IemailService.IEmailService;
import com.kodat.skladovysystem.interfaces.Iservices.IZamestnanecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zamestnanec")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ZamestnanecController {

    private final IZamestnanecService _iZamestnanecService;
    private final IEmailService _iEmailService;

    public ZamestnanecController(IZamestnanecService iZamestnanecService, IEmailService iEmailService) {
        _iZamestnanecService = iZamestnanecService;
        _iEmailService = iEmailService;
    }

    @PostMapping
    public void pridejZamestnance(
           @RequestBody ZamestnanecDto dto){
        EmailDetails email = new EmailDetails();
        email.setTeloZpravy("Vitejte, toto je registrační email");
        email.setPredmetZpravy("Registrace");
        email.setPrijemce(dto.getEmail());
        String vysledek = _iEmailService.posliJednoduchyEmail(email);
        System.out.printf(vysledek);
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
