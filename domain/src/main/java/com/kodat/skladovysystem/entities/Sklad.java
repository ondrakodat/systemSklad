package com.kodat.skladovysystem.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sklad")
public class Sklad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100, unique = true)
    private String nazev;
    @Column(nullable = false, length = 70)
    private String mesto;
    @Column(nullable = false, length = 10)
    private String psc;
    private boolean aktivniStav;
    @OneToMany(mappedBy = "sklad")
    private List<PoziceSkladu> poziceSkladu = new ArrayList<>();
    @OneToMany(mappedBy = "sklad")
    private List<Inventar> inventare = new ArrayList<>();

    @OneToMany(mappedBy = "sklad")
    private List<Prijem> prijmy = new ArrayList<>();

    @OneToMany(mappedBy = "sklad")
    private List<Vydej> vydaje = new ArrayList<>();

    @OneToMany(mappedBy = "sklad")
    private List<Rezervace> rezervace = new ArrayList<>();

    @OneToMany(mappedBy = "zdrojovySklad")
    private List<Presun> odchoziPresuny = new ArrayList<>();

    @OneToMany(mappedBy = "cilovySklad")
    private List<Presun> prichoziPresuny = new ArrayList<>();
}
