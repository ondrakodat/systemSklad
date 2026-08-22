package com.kodat.skladovysystem.entities;


import com.kodat.skladovysystem.enums.TypPohybu;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pohyb_skladu")
public class PohybSkladu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mnozstvi;
    private LocalDateTime datum;
    private String poznamka;
    @Enumerated(EnumType.STRING)
    private TypPohybu typPohybu;
    @ManyToOne
    @JoinColumn(name="produkt_id")
    private Produkt produkt;
    @ManyToOne
    @JoinColumn(name="sklad_id")
    private Sklad sklad;
    @ManyToOne
    @JoinColumn(name="zamestnanec_id")
    private Zamestnanec zamestnanec;
    private String cisloDokladu;

}
