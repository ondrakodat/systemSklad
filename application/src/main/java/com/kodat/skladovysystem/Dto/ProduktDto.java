package com.kodat.skladovysystem.Dto;

import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduktDto {
    private long id;

    private String nazev;

    private String popis;

    private Long kategorieId;

    private BigDecimal cena;

    private BigDecimal nakupniCena;

    @PositiveOrZero
    private int minimalniSkladovaneMnozstvi;

    private String ean;

    @PositiveOrZero
    private double hmotnost;
}
