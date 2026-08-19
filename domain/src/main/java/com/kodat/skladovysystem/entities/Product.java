package com.kodat.skladovysystem.entities;

import java.util.Date;

public class Product {
    private Long id;
    private String nazev;
    private String popis;
    //private Kategorie kategorie;
    private double cena;
    private double nakupniCena;
    private int minimalniSkladovaneMnozstvi;
    private double ean;
    private double hmotnost;
    private boolean stav;
    private Date datumVytvoreni;
    private Date datumPosledniZmeny;
}
