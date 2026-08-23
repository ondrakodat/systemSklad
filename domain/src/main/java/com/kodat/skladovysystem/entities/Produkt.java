package com.kodat.skladovysystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
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
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private BigDecimal cena = BigDecimal.valueOf(0);
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private BigDecimal nakupniCena = BigDecimal.valueOf(0);
    @PositiveOrZero
    private int minimalniSkladovaneMnozstvi;
    private String ean = "";
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private double hmotnost = 0;
    private boolean stav = false;
    private LocalDateTime datumVytvoreni = LocalDateTime.now();
    private LocalDateTime datumPosledniZmeny;
    @OneToMany(mappedBy = "produkt")
    private List<Inventar> inventare = new ArrayList<>();
    @OneToMany(mappedBy = "produkt")
    private List<Rezervace> rezervace = new ArrayList<>();
    @OneToMany(mappedBy = "produkt")
    private List<PohybSkladu> pohyby = new ArrayList<>();



}


