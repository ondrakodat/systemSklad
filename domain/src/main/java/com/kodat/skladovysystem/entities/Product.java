package com.kodat.skladovysystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazev;
    private String popis;
    @OneToMany
    @JoinColumn(name = "kategorie_id")
    private Kategorie kategorie;
    private double cena;
    private double nakupniCena;
    private int minimalniSkladovaneMnozstvi;
    private double ean;
    private double hmotnost;
    private boolean stav;
    private Date datumVytvoreni;
    private Date datumPosledniZmeny;
}
