package com.kodat.skladovysystem.Dto;

import com.kodat.skladovysystem.entities.Sklad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PohybSkladuDto {
    //private long id;
    private int mnozstvi;
    private LocalDateTime datum;
    private String poznamka;
    private String typPohybu;
    private Long produkt_id;
    private Long sklad_id;
    private Long zamestnanec_id;
    private String cisloDokladu;
}
