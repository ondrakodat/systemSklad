package com.kodat.skladovysystem.Dto;

import com.kodat.skladovysystem.entities.Produkt;
import com.kodat.skladovysystem.entities.Sklad;
import com.kodat.skladovysystem.enums.StavRezervace;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

public class RezervaceDto {
    private Long id;
    private String cisloObjednavky;
    private int mnozstvi;
    private long stav_id;
    private long produkt_id;
    private long sklad_id;
}
