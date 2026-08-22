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
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int mnozstvi;
    @Column(nullable = false)
    private LocalDateTime datum;
    @Column(nullable = false, length = 200)
    private String poznamka;
    @Enumerated(EnumType.STRING)
    private TypPohybu typPohybu;
    @ManyToOne
    @JoinColumn(name="produkt_id", nullable = false)
    private Produkt produkt;
    @ManyToOne
    @JoinColumn(name="sklad_id", nullable = false)
    private Sklad sklad;
    @ManyToOne
    @JoinColumn(name="zamestnanec_id", nullable = false)
    private Zamestnanec zamestnanec;
    @Column(nullable = false, length = 50)
    private String cisloDokladu;

}
