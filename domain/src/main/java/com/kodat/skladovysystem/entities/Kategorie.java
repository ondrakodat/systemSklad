package com.kodat.skladovysystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "kategorie")
public class Kategorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 100)
    private String nazev;
    @ManyToOne
    @JoinColumn(name = "rodic_id", nullable = true)
    private Kategorie nadkategorie;
    @OneToMany(mappedBy = "nadkategorie")
    private List<Kategorie> podKategorie = new ArrayList<>();
    @OneToMany(mappedBy = "kategorie")
    private List<Produkt> produkty = new ArrayList<>();

    public void pridatKategorie(Kategorie kategorie){
        podKategorie.add(kategorie);
        kategorie.setNadkategorie(this);
    }

}
