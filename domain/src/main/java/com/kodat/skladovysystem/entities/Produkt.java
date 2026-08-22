package com.kodat.skladovysystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "produkt")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazev;
    private String popis;
    @ManyToOne
    @JoinColumn(name = "kategorie_id")
    private Kategorie kategorie;
    private BigDecimal cena;
    private BigDecimal nakupniCena;
    private int minimalniSkladovaneMnozstvi;
    private String ean;
    private double hmotnost;
    private boolean stav;
    private LocalDateTime datumVytvoreni;
    private LocalDateTime datumPosledniZmeny;
    @OneToMany(mappedBy = "produkt")
    private List<Inventar> inventare = new ArrayList<>();
    @OneToMany(mappedBy = "produkt")
    private List<Rezervace> rezervace = new ArrayList<>();
    @OneToMany(mappedBy = "produkt")
    private List<PohybSkladu> pohyby = new ArrayList<>();

}
